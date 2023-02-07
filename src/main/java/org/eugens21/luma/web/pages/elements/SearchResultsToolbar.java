package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ToolbarDetails;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.toolbar.Sorter;
import org.eugens21.luma.web.pages.elements.interfaces.IToolbar;
import org.eugens21.luma.web.pages.model.search_results.grid.toolbar.Amount;
import org.eugens21.luma.web.pages.model.search_results.grid.toolbar.ViewMode;

import static lombok.AccessLevel.PRIVATE;

@Getter
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResultsToolbar implements IToolbar {

    Locator locator;
    ViewMode viewMode;
    Amount amount;
    Sorter sorter;

    public SearchResultsToolbar(Page page, ToolbarDetails contentDetails) {
        this.locator = page.locator(contentDetails.getSelf()).first();
        this.amount = new Amount(locator, contentDetails.getAmount());
        this.sorter = new Sorter(locator, contentDetails.getSorter());
        this.viewMode = new ViewMode(locator, contentDetails.getViewModes());
    }

}
