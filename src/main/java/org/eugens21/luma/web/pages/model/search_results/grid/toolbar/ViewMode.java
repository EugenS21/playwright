package org.eugens21.luma.web.pages.model.search_results.grid.toolbar;

import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ViewModesDetails;
import org.eugens21.luma.web.pages.elements.Span;
import org.eugens21.luma.web.pages.enums.ViewModeEnum;

import static io.vavr.API.*;
import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.web.pages.enums.ViewModeEnum.LIST;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ViewMode {

    Span list;
    Span grid;

    public ViewMode(Locator locator, ViewModesDetails viewModesDetails) {
        this.list = new Span(locator.locator(viewModesDetails.getList()));
        this.grid = new Span(locator.locator(viewModesDetails.getGrid()));
    }

    public Span switchToView(ViewModeEnum viewMode) {
        return Match(viewMode).of(
                Case($(LIST), () -> list),
                Case($(), () -> grid)
        );
    }

}
