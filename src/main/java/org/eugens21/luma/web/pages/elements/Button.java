package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IButton;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Button implements IButton {

    Locator locator;

    @Override
    public void click() {
        locator.click();
    }

    @Override
    public String getText() {
        return locator.textContent();
    }

}
