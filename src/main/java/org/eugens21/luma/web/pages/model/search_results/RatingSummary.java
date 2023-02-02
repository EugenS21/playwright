package org.eugens21.luma.web.pages.model.search_results;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.Span;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class RatingSummary {

    Span rating;
    Span percentage;

    public RatingSummary(Locator locator) {
        this.rating = new Span(locator.locator("//span[@class='label']"));
        this.percentage = new Span(locator.locator("//span[@itemprop='ratingValue']"));
    }

    public String getRating() {
        return rating.getContent().concat(percentage.getContent()).concat("% of 100");
    }

}
