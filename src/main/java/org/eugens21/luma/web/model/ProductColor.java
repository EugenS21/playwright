package org.eugens21.luma.web.model;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.Div;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ProductColor {

    Div color;

    public ProductColor(Locator locator) {
        this.color = new Div(locator);
    }

}
