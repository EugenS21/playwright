package org.eugens21.luma.web.pages.actions;

import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.SearchResults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResultsActions implements PageActions {

    FooterToolbarActions footerToolbarActions;
    HeaderToolbarActions headerToolbarActions;
    ProductGridActions grid;

    public SearchResultsActions(SearchResults searchResults) {
        this.footerToolbarActions = new FooterToolbarActions(searchResults.getPaginationToolbar());
        this.headerToolbarActions = new HeaderToolbarActions(searchResults.getSearchResultsToolbar());
        this.grid = new ProductGridActions(searchResults.getFoundProductsGrid());
    }

    public SearchResultsInsideActions on() {
        return new SearchResultsInsideActions();
    }

    public class SearchResultsInsideActions {

        public HeaderToolbarActions headerToolbar() {
            return headerToolbarActions;
        }

        public ProductGridActions grid() {
            return grid;
        }

        public FooterToolbarActions footer() {
            return footerToolbarActions;
        }
    }
}
