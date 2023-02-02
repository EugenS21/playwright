package org.eugens21.luma.web.pages.actions;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.toolbar.SearchResultsToolbar;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;
import org.eugens21.luma.web.pages.enums.ViewModeEnum;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class HeaderToolbarActions {

    SearchResultsToolbar toolbar;

    public void switchToView(ViewModeEnum viewMode) {
        toolbar.getViewMode().switchToView(viewMode);
    }

    public String getItems() {
        return toolbar.getAmount().getAmount();
    }

    public void sortBy(SortByEnum sortBy) {
        toolbar.getSorter().sortBy(sortBy);
    }

    public void sort(SortEnum sort) {
        toolbar.getSorter().sort(sort);
    }

}