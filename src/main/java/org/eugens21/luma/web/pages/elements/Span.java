package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Span implements Element {

    Page page;
    String locator;

    public Span(Page page, String locator) {
        this.locator = locator;
        this.page = page;
    }

    @Override
    public Locator getSelfLocator() {
        return page.locator(locator);
    }

}
