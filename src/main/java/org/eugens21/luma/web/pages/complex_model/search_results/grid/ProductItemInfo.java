package org.eugens21.luma.web.pages.complex_model.search_results.grid;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.AvailableColorsDetails;
import org.eugens21.luma.properties.pages.search_results.AvailableSizesDetails;
import org.eugens21.luma.properties.pages.search_results.ProductDetails;
import org.eugens21.luma.web.functional.WaitForState;
import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Image;
import org.eugens21.luma.web.pages.model.search_results.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.microsoft.playwright.options.WaitForSelectorState.ATTACHED;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ProductItemInfo {

    Image image;
    Anchor name;
    ProductReview productReview;
    PriceBox cost;
    List<ProductSize> availableSizes;
    List<ProductColor> availableColors;
    ProductActions productActions;
    ProductDescription productDescription;

    public ProductItemInfo(Locator productItemLocatorInGrid, ProductDetails productDetails) {
        this.image = new Image(productItemLocatorInGrid.getByRole(productDetails.getImage()));
        this.name = new Anchor(productItemLocatorInGrid.getByRole(productDetails.getName()));
        this.productReview = new ProductReview(productItemLocatorInGrid.locator(productDetails.getProductReview().getSelf()), productDetails.getProductReview());
        this.cost = new PriceBox(productItemLocatorInGrid.locator(productDetails.getCost().getSelf()), productDetails.getCost());
        this.availableSizes = getProductSizes(productItemLocatorInGrid.locator(productDetails.getAvailableSizes().getSelf()), productDetails.getAvailableSizes());
        this.availableColors = getProductColors(productItemLocatorInGrid.locator(productDetails.getAvailableColors().getSelf()), productDetails.getAvailableColors());
        this.productActions = new ProductActions(productItemLocatorInGrid.locator(productDetails.getProductActions().getSelf()), productDetails.getProductActions());
        this.productDescription = new ProductDescription(productItemLocatorInGrid.locator(productDetails.getProductDescription().getSelf()), productDetails.getProductDescription());
    }

    @WaitForState(ATTACHED)
    public List<ProductSize> getProductSizes(Locator locator, AvailableSizesDetails sizeDetails) {
        Locator siblings = locator.locator(sizeDetails.getAvailableSize());
        return Stream.iterate(0, i -> i + 1)
                .limit(siblings.count())
                .map(siblings::nth)
//                .peek(Locator::scrollIntoViewIfNeeded)
                .map(ProductSize::new)
                .collect(Collectors.toList());
    }

    @WaitForState(ATTACHED)
    private List<ProductColor> getProductColors(Locator locator, AvailableColorsDetails colorDetails) {
        Locator siblings = locator.locator(colorDetails.getAvailableColor());
        return Stream.iterate(0, i -> i + 1)
                .limit(siblings.count())
                .map(siblings::nth)
//                .peek(Locator::scrollIntoViewIfNeeded)
                .map(ProductColor::new)
                .collect(Collectors.toList());
    }

}
