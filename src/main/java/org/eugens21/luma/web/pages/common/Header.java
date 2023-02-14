package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.CommonPageDetails;
import org.eugens21.luma.web.factory.PageFactory;
import org.eugens21.luma.web.factory.Pages;
import org.eugens21.luma.web.pages.enums.NavigationMenuEnum;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;
import org.eugens21.luma.web.pages.model.search_results.SearchSuggestion;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Header {

    @Getter
    HeaderLinks headerLinks;
    @Getter
    HeaderContent headerContent;
    @Getter
    NavigationMenu navigatioMenu;

    public Header(Page page, CommonPageDetails commonPageDetails) {
        headerLinks = new HeaderLinks(page, commonPageDetails.getHeader().getPanel().getLinks());
        headerContent = new HeaderContent(page, commonPageDetails.getHeader().getContent());
        navigatioMenu = new NavigationMenu(page, commonPageDetails.getHeader().getNavigation());
    }

    public SearchResultsPage navigateToMenu(NavigationMenuEnum menu, String... pathToVisit) {
        navigatioMenu.open(menu, pathToVisit);
        return PageFactory.get(Pages.SEARCH_RESULTS_PAGE);
    }

    public SearchResultsPage searchForProductWithName(String name) {
        return headerContent.getSearchForm().searchForProduct(name);
    }

    public SearchResultsPage searchForSuggestion(String name) {
        return headerContent.getSearchForm().chooseSuggestion(name);
    }

    public List<SearchSuggestion> searchForSuggestions(String keyword) {
        return headerContent.getSearchForm().searchForSuggestions(keyword);
    }

}
