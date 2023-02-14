package org.eugens21.luma.web.pages;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.actions.PageActions;
import org.eugens21.luma.web.pages.common.Header;
import org.eugens21.luma.web.pages.enums.NavigationMenuEnum;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;
import org.eugens21.luma.web.pages.model.search_results.SearchSuggestion;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public abstract class AbstractPage implements org.eugens21.luma.web.pages.Page {

    Page page;
    Header header;
    PageLocators pageLocators;

    public AbstractPage(PageLocators pageLocators, Page page) {
        this.page = page;
        this.pageLocators = pageLocators;
        this.header = new Header(page, pageLocators.getCommon());
    }

    public SearchResultsPage searchForProduct(String productName) {
        return header.searchForProductWithName(productName);
    }

    public SearchResultsPage searchForSuggestion(String productName) {
        return header.searchForSuggestion(productName);
    }

    public List<SearchSuggestion> lookingForSuggestions(String productName) {
        return header.searchForSuggestions(productName);
    }

    public SearchResultsPage navigateToMenu(NavigationMenuEnum menu, String... pathToVisit) {
        return header.navigateToMenu(menu, pathToVisit);
    }

    @Override
    public PageActions _do() {
        return null;
    }

}
