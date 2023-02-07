package org.eugens21.luma.web.pages.complex_model.search_results.grid.toolbar;

import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.SorterDetails;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;
import org.eugens21.luma.web.pages.model.search_results.grid.toolbar.SorterOptions;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Sorter {

    SorterOptions options;

    public Sorter(Locator locator, SorterDetails sorter) {
        this.options = new SorterOptions(locator, sorter);
    }

    public void sortBy(SortByEnum sortBy) {
        options.sortBy(sortBy);
    }

    public void sort(SortEnum sort) {
        options.sort(sort);
    }

}
