package org.eugens21.luma.web.model;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.Anchor;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class ReviewActions {

    Anchor reviews;
    Anchor addReview;
    public ReviewActions(Locator locator) {
        this.reviews = new Anchor(locator.locator("//a[contains(@class,'view')]"));
        this.addReview = new Anchor(locator.locator("//a[contains(@class,'add')]"));
    }

}
