package org.eugens21.luma.web.pages.model.search_results.grid.toolbar;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.AmountDetails;
import org.eugens21.luma.web.pages.elements.Paragraph;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Amount {

    @Getter
    Paragraph paragraph;

    public Amount(Locator locator, AmountDetails amountDetails) {
        this.paragraph = new Paragraph(locator.locator(amountDetails.getSelf()));
    }

    public String getAmount() {
        return paragraph.getContent();
    }

}
