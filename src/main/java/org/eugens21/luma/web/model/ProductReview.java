package org.eugens21.luma.web.model;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.ProductReviewDetails;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ProductReview {

    RatingSummary rating;
    ReviewActions review;

    public ProductReview(Locator locator, ProductReviewDetails productReview) {
        this.rating = new RatingSummary(locator.locator(productReview.getRating()));
        this.review = new ReviewActions(locator.locator(productReview.getReview()));
    }

}
