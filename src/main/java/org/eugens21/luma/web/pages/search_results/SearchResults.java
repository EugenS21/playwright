package org.eugens21.luma.web.pages.search_results;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ResultsDetails;
import org.eugens21.luma.properties.pages.search_results.SearchResultsDetails;
import org.eugens21.luma.web.pages.elements.DescriptionList;
import org.eugens21.luma.web.pages.elements.FoundProductsGrid;
import org.eugens21.luma.web.pages.elements.SearchResultsToolbar;
import org.eugens21.luma.web.pages.elements.Span;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResults implements Element {

    Page page;
    @Getter
    String selfLocator;
    @Getter
    Span pageTitle;
    @Getter
    SearchResultsToolbar searchResultsToolbar;
    @Getter
    DescriptionList relatedTermsBlock;
    @Getter
    FoundProductsGrid foundProductsGrid;

    public SearchResults(Page page, SearchResultsDetails searchResultsLocators) {
        ResultsDetails resultsLocators = searchResultsLocators.getResults();
        this.relatedTermsBlock = new DescriptionList(page, resultsLocators.getRelatedTermsBlock());
        this.selfLocator = searchResultsLocators.getSelf();
        this.page = page;
        this.pageTitle = new Span(page.locator(searchResultsLocators.getPageTitle()));
        this.searchResultsToolbar = new SearchResultsToolbar(page, resultsLocators.getHeader());
        this.foundProductsGrid = new FoundProductsGrid(page, resultsLocators.getContent());
    }

    @Override
    public Locator getLocator() {
        return page.locator(selfLocator);
    }

}
