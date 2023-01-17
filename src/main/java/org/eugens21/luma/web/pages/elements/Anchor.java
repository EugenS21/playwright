package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IAnchor;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Anchor implements IAnchor {

    Page page;
    String locator;

    public Anchor(Page page, String locator) {
        this.locator = locator;
        this.page = page;
    }

    @Override
    public Locator getSelfLocator() {
        return page.locator(locator);
    }

    @Override
    public void click() {
        page.click(locator);
    }

    @Override
    public boolean isClickable() {
        return getSelfLocator().isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return getSelfLocator().isVisible();
    }

    @Override
    public String getText() {
        return page.locator(locator).innerText();
    }
}
