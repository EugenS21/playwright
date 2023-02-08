package org.eugens21.luma.web.pages.actions;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.SearchResultsToolbar;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;
import org.eugens21.luma.web.pages.enums.ViewModeEnum;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.web.factory.PageFactory.get;
import static org.eugens21.luma.web.factory.Pages.SEARCH_RESULTS_PAGE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class HeaderToolbarActions {

    SearchResultsToolbar toolbar;

    public SearchResultsPage switchToView(ViewModeEnum viewMode) {
        toolbar.getViewMode().switchToView(viewMode);
        return get(SEARCH_RESULTS_PAGE);
    }

    public String getItems() {
        return toolbar.getAmount().getAmount();
    }

    public SearchResultsPage sortBy(SortByEnum sortBy) {
        toolbar.getSorter().sortBy(sortBy);
        return get(SEARCH_RESULTS_PAGE);
    }

    public SearchResultsPage sort(SortEnum sort) {
        toolbar.getSorter().sort(sort);
        return get(SEARCH_RESULTS_PAGE);
    }

}