package org.eugens21.luma.web.pages.complex_model.search_results.grid;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ResultsDetails;
import org.eugens21.luma.properties.pages.search_results.SearchResultsDetails;
import org.eugens21.luma.web.pages.elements.*;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResults implements Element {

    @Getter
    Locator locator;
    @Getter
    Span pageTitle;
    @Getter
    SearchResultsToolbar searchResultsToolbar;
    @Getter
    DescriptionList relatedTermsBlock;
    @Getter
    FoundProductsGrid foundProductsGrid;
    @Getter
    Pagination paginationToolbar;


    public SearchResults(Page page, SearchResultsDetails searchResultsLocators) {
        ResultsDetails resultsLocators = searchResultsLocators.getResults();
        this.relatedTermsBlock = new DescriptionList(page, resultsLocators.getRelatedTermsBlock());
        this.locator = page.locator(searchResultsLocators.getSelf());
        this.pageTitle = new Span(page.locator(searchResultsLocators.getPageTitle()));
        this.searchResultsToolbar = new SearchResultsToolbar(page, resultsLocators.getToolbar());
        this.foundProductsGrid = new FoundProductsGrid(page, resultsLocators.getContent());
        this.paginationToolbar = new Pagination(page, searchResultsLocators.getFooter().getPages());
    }

}
