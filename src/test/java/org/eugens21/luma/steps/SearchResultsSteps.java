package org.eugens21.luma.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.data_table.model.ProductInfo;
import org.eugens21.luma.data_table.model.SearchSuggestion;
import org.eugens21.luma.mapping.ProductInfoMapping;
import org.eugens21.luma.mapping.SearchSuggestionMapping;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.model.ProductItemInfo;
import org.eugens21.luma.web.pages.home.HomePage;
import org.eugens21.luma.web.pages.search_results.SearchResultsPage;
import org.eugens21.luma.web.service.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.*;

@FieldDefaults(makeFinal = true, level = PRIVATE)
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

    @SneakyThrows
    @Then("user/he/she should see the title {string}")
    public void heShouldSeeTheTitleSearchResultsForShirt(String title) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        softAssertions.assertThat(searchResultsPage)
                .describedAs("Expecting title <%s>", title)
                .extracting(SearchResultsPage::getTitle)
                .isEqualTo(title);
    }

    @And("user/he/she should see the following products:")
    public void heShouldSeeTheFollowingProducts(List<ProductInfo> products) {
        SearchResultsPage searchResultsPage = scenarioContext.getValue(GENERIC_PAGE, SearchResultsPage.class);
        List<ProductItemInfo> productItemInfo = searchResultsPage.getFoundProducts();
        List<ProductInfo> productsFromGrid = productItemInfo.stream()
                .map(productInfoMapping::getProductInfo)
                .collect(Collectors.toList());
        softAssertions.assertThat(productsFromGrid)
                .describedAs("Expecting to see <%s> on the products grid", products)
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
        List<org.eugens21.luma.web.model.SearchSuggestion> actualSuggestions
                = scenarioContext.getListValue(GENERIC, org.eugens21.luma.web.model.SearchSuggestion.class);
        softAssertions.assertThat(actualSuggestions)
                .describedAs("Expecting to have the following suggestions: <%s>", expectedSuggestions)
                .extracting(searchSuggestionMapping::getSearchSuggestion)
                .containsExactlyElementsOf(expectedSuggestions);
//                .satisfies(el-> Assertions.assertThat(el).containsExactlyElementsOf(expectedSuggestions));
    }
}
