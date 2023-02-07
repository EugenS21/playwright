package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.Option;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Dropdown implements Option {

    @Getter
    Locator locator;

    @Override
    public void selectOption(String element) {
        locator.scrollIntoViewIfNeeded();
        locator.selectOption(new SelectOption().setLabel(element));
    }

    @Override
    public java.util.List<String> getOptions() {
        return locator.allInnerTexts();
    }
}
