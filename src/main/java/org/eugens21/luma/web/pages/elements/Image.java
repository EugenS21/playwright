package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IImage;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Image implements IImage {

    Locator locator;

    @Override
    public String getSrc() {
        return locator.getAttribute("src");
    }
}
