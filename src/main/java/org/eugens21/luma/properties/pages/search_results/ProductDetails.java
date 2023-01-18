package org.eugens21.luma.properties.pages.search_results;

import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductDetails {

    AriaRole image;
    AriaRole name;
    ProductReviewDetails productReview;
    PriceBoxDetails cost;
    AvailableSizesDetails availableSizes;
    AvailableColorsDetails availableColors;
    ProductActionsDetails productActions;
    ProductDescriptionDetails productDescription;

}
