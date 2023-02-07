package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.Option;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Dropdown implements Option {

    @Getter
    Locator locator;

    public Dropdown(Locator locator) {
        this.locator = locator;
    }

    @Override
    public void selectOption(String element) {
        locator.selectOption(element);
    }

    @Override
    public java.util.List<String> getOptions() {
        return locator.allInnerTexts();
    }
}
