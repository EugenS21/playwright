package org.eugens21.luma.web.pages.model.search_results;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.PriceBoxDetails;
import org.eugens21.luma.web.pages.elements.Span;

import static java.lang.Double.valueOf;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class PriceBox {

    Span priceLabel;
    Span price;

    public PriceBox(Locator locator, PriceBoxDetails cost) {
        this.priceLabel = new Span(locator.locator(cost.getPriceLabel()));
        this.price = new Span(locator.locator(cost.getPrice()));
    }

    public String getPrice() {
        return price.getContent();
    }

    public Double getPriceWithoutCurrency() {
        return valueOf(price.getContent().replaceAll("\\$", ""));
    }

    public String getFullPriceValue() {
        return getPriceLabel().getContent().concat(getPrice());
    }

}
