package org.eugens21.luma.web.model;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ProductDescriptionDetails;
import org.eugens21.luma.web.pages.elements.Anchor;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ProductDescription {

    Anchor learnMore;

    public ProductDescription(Locator locator, ProductDescriptionDetails productDescription) {
        this.learnMore = new Anchor(locator.getByRole(productDescription.getLearnMore()));
    }

}
