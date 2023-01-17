package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.eugens21.luma.web.pages.elements.interfaces.IButton;

public class Button implements IButton {

    Page page;
    String locator;

    public Button(Page page, String locator) {
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

}
