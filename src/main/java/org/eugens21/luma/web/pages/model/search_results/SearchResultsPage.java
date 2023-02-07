package org.eugens21.luma.web.pages.model.search_results;

import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.PageWithBreadCrumbs;
import org.eugens21.luma.web.pages.actions.SearchResultsActions;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.SearchResults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResultsPage extends PageWithBreadCrumbs {

    SearchResults searchResults;

    public SearchResultsPage(Page page, PageLocators pageLocators) {
        super(pageLocators, page);
        val searchResultsLocators = pageLocators.getSearchResults();
        this.searchResults = new SearchResults(page, searchResultsLocators);
    }

    public String getTitle() {
        return searchResults.getPageTitle().getContent();
    }

    @Override
    public SearchResultsActions _do() {
        return new SearchResultsActions(searchResults);
    }

}
