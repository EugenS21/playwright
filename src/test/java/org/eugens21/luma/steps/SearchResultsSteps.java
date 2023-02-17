package org.eugens21.luma.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.data_table.model.MenuPath;
import org.eugens21.luma.data_table.model.ProductInfo;
import org.eugens21.luma.data_table.model.SearchSuggestion;
import org.eugens21.luma.enums.PageNavigationEnum;
import org.eugens21.luma.mapping.ProductInfoMapping;
import org.eugens21.luma.mapping.SearchSuggestionMapping;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.functional.Attachment;
import org.eugens21.luma.web.functional.Loggable;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.ProductItemInfo;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;
import org.eugens21.luma.web.pages.enums.ViewModeEnum;
import org.eugens21.luma.web.pages.home.HomePage;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;
import org.eugens21.luma.web.service.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.*;

@Attachment
@FieldDefaults(makeFinal = true, level = PRIVATE)
@Loggable
public class SearchResultsSteps extends CommonUiStep {

    ProductInfoMapping productInfoMapping;
    SearchSuggestionMapping searchSuggestionMapping;

    @Autowired
    public SearchResultsSteps(Application application,
                              BrowserService browserService,
                              PageLocators pageLocators,
                              ProductInfoMapping productInfoMapping,
                              ScenarioContext scenarioContext,
                              SearchSuggestionMapping searchSuggestionMapping) {
        super(application, browserService, pageLocators, scenarioContext);
        this.productInfoMapping = productInfoMapping;
        this.searchSuggestionMapping = searchSuggestionMapping;
    }

    @When("user/he/she search for a product with name {string}")
    public void userSearchForAProductWithName(String productName) {
        HomePage homePage = scenarioContext.getValue(HOME_PAGE, HomePage.class);
        SearchResultsPage searchResultsPage = homePage.searchForProduct(productName);
        scenarioContext.addValue(GENERIC_PAGE, searchResultsPage);
    }

    @When("user/he/she choose to navigate to the following path '{menuPath}'")
    public void userChoosingMenu(MenuPath menuToVisit) {
        HomePage homePage = scenarioContext.getValue(HOME_PAGE, HomePage.class);
        SearchResultsPage searchResultsPage = homePage.navigateToMenu(menuToVisit.getMainMenu(), menuToVisit.getPathToVisit());
        scenarioContext.addValue(GENERIC_PAGE, searchResultsPage);
    }

    @SneakyThrows
    @Then("user/he/she should see the title {string}")
    public void heShouldSeeTheTitleSearchResultsForShirt(String title) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        softAssertions.assertThat(searchResultsPage)
                .describedAs("Expecting title <%s>", title)
                .extracting(SearchResultsPage::getTitle)
                .isEqualTo(title);
    }

    @Then("user/he/she should see the following products:")
    public void heShouldSeeTheFollowingProducts(List<ProductInfo> products) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        List<ProductItemInfo> productItemInfo = searchResultsPage._do().on().grid().getFoundProducts();
        softAssertions.assertThat(productItemInfo)
                .describedAs("Expecting to see <%s> on the products grid", products)
                .extracting(productInfoMapping::getProductInfo)
                .containsExactlyElementsOf(products);
    }

    @When("user/he/she is looking to search for {string}")
    public void heIsLookingToSearchForTop(String searchKeyword) {
        HomePage homePage = scenarioContext.getValue(HOME_PAGE, HomePage.class);
        val actualSearchSuggestions = homePage.lookingForSuggestions(searchKeyword);
        scenarioContext.addValue(GENERIC, actualSearchSuggestions);
    }

    @Then("user/he/she should see the following suggestions:")
    public void heShouldSeeTheFollowingSuggestions(List<SearchSuggestion> expectedSuggestions) {
        List<org.eugens21.luma.web.pages.model.search_results.SearchSuggestion> actualSuggestions
                = scenarioContext.getListValue(GENERIC, org.eugens21.luma.web.pages.model.search_results.SearchSuggestion.class);
        softAssertions.assertThat(actualSuggestions)
                .describedAs("Expecting to have the following suggestions: <%s>", expectedSuggestions)
                .extracting(searchSuggestionMapping::getSearchSuggestion)
                .containsExactlyInAnyOrderElementsOf(expectedSuggestions);
    }


    @When("he is clicking on {string} suggestion")
    public void heIsClickingOnKeywordSuggestion(String suggestionToClick) {
        HomePage homePage = scenarioContext.getValue(HOME_PAGE, HomePage.class);
        SearchResultsPage searchResultsPage = homePage.searchForSuggestion(suggestionToClick);
        scenarioContext.addValue(GENERIC_PAGE, searchResultsPage);
    }

    @Then("^he should count '(\\d+)' found products$")
    public void heShouldCountQuantityFoundProducts(Integer productsOnGrid) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        List<ProductItemInfo> productItemInfo = searchResultsPage._do().on().grid().getFoundProducts();
        softAssertions.assertThat(productItemInfo)
                .describedAs("Expecting to found <%d> products", productsOnGrid)
                .hasSizeGreaterThan(9);
    }

    @When("he is choosing to switch to '{viewMode}' view")
    public void heIsChoosingToSwitchToLISTView(ViewModeEnum viewMode) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        SearchResultsPage searchPage = searchResultsPage._do().on().headerToolbar().switchToView(viewMode);
        scenarioContext.addValue(GENERIC_PAGE, searchPage);
    }

    @Then("he should see the amount {string}")
    public void heShouldSeeTheAmountItems(String amount) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        String items = searchResultsPage._do().on().headerToolbar().getItems();
        softAssertions.assertThat(items)
                .describedAs("Expecting to see <%s> on toolbar", amount)
                .isEqualTo(amount);
    }

    @When("he is sorting the grid '{sort}' by '{sortBy}'")
    public void heIsSortingTheGridBySortCriteria(SortEnum sort, SortByEnum sortBy) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        SearchResultsPage sortedByPage = searchResultsPage._do().on().headerToolbar().sortBy(sortBy);
        SearchResultsPage sortedPage = searchResultsPage._do().on().headerToolbar().sort(sort);
        List<ProductItemInfo> foundProducts = sortedPage._do().on().grid().getFoundProducts();
        scenarioContext.addValue(GENERIC, foundProducts);
    }

    @Then("he should see the grid sorted '{sort}' by '{sortBy}'")
    public void heShouldSeeTheGridSortedBySortCriteriaAndStrategy(SortEnum sort, SortByEnum sortBy) {
        List<ProductItemInfo> listValue = scenarioContext.getListValue(GENERIC, ProductItemInfo.class);
        softAssertions.assertThat(listValue)
                .describedAs("Expecting products to be sorted <%s> by <%s>", sort, sortBy)
                .isSortedAccordingTo(sort.get(sortBy.getComparator()));
    }

    @When("he is looking for pages number")
    public void heIsLookingForPagesNumber() {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        List<String> pages = searchResultsPage._do().on().footer().getPages();
        scenarioContext.addValue(LIST_KEY, pages);
    }

    @Then("he should see the following pages:")
    public void heShouldSeePages(List<String> pages) {
        softAssertions.assertThat(pages)
                .describedAs("Expecting the following <%s> pages", pages)
                .containsExactlyElementsOf(scenarioContext.getListValue(LIST_KEY, String.class));
    }

    @When("he is navigating to the '{page}' page")
    public void heIsNavigatingToTheNextPage(PageNavigationEnum page) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        SearchResultsPage next = searchResultsPage._do().on().footer().next();
        scenarioContext.addValue(GENERIC_PAGE, next);
    }
}
