package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IAnchor;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
@SuppressWarnings("nullpointer")
public class Anchor implements IAnchor {

    Locator locator;

    @Override
    public void click() {
        locator.click();
    }

    @Override
    public boolean isClickable() {
        return locator.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return locator.isVisible();
    }

    @Override
    public String getText() {
        return locator.innerText();
    }

}
