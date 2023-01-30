package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public abstract class AbstractElement implements Element {

    @Getter
    AbstractDetails abstractDetails;
    String selfLocator;
    Page page;

    protected AbstractElement(Page page, AbstractDetails abstractDetails) {
        this.abstractDetails = abstractDetails;
        this.selfLocator = abstractDetails.getSelf();
        this.page = page;
    }

    public Locator getLocator() {
        return page.locator(selfLocator);
    }

}
