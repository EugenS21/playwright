package org.eugens21.luma.web.pages.model.search_results;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ProductActionsDetails;
import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Button;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ProductActions {

    Button addToCart;
    Anchor addToWishList;
    Anchor addToCompare;

    public ProductActions(Locator locator, ProductActionsDetails productActions) {
        this.addToCart = new Button(locator.getByRole(productActions.getAddToCart()));
        this.addToWishList = new Anchor(locator.getByTitle(productActions.getAddToWishList()));
        this.addToCompare = new Anchor(locator.getByTitle(productActions.getAddToCompare()));
    }
}
