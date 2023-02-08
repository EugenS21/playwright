package org.eugens21.luma.web.pages.model.search_results.grid.toolbar;

import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.SorterDetails;
import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Dropdown;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SorterOptions {

    Dropdown sortOptions;
    Anchor directionSwitcher;

    public SorterOptions(Locator locator, SorterDetails sorterOptions) {
        Locator lct = locator.locator(sorterOptions.getSelf());
        this.directionSwitcher = new Anchor(lct.getByRole(sorterOptions.getDirectionSwitcher()));
        this.sortOptions = new Dropdown(lct.locator(sorterOptions.getOption()));
    }

    public void sortBy(SortByEnum sortBy) {
        sortOptions.selectOption(sortBy.getText());
    }

    public void sort(SortEnum sort) {
        String direction = directionSwitcher.getLocator().getAttribute("data-value");
        if (direction.equals(sort.name().toLowerCase())) {
            directionSwitcher.click();
        }
    }

}
