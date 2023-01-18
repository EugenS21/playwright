package org.eugens21.luma.web.pages.search_results;

import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.model.ProductItemInfo;
import org.eugens21.luma.web.pages.PageWithBreadCrumbs;

import java.util.List;

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

    public List<ProductItemInfo> getFoundProducts() {
        return searchResults.getFoundProductsGrid().getElements();
    }

}
