package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IDiv;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Div implements IDiv {

    Locator locator;

    @Override
    public String getAttribute(String attribute) {
        return locator.getAttribute(attribute);
    }

    @Override
    public String getText() {
        return locator.textContent();
    }

    @Override
    public String toString() {
        return getText();
    }

}
