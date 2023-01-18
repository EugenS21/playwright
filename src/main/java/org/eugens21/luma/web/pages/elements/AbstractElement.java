package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public abstract class AbstractElement {

    String selfLocator;
    Page page;

    protected AbstractElement(Page page, AbstractDetails abstractDetails) {
        this.selfLocator = abstractDetails.getSelf();
        this.page = page;
    }

    public Locator getLocator() {
        return page.locator(selfLocator);
    }

}
