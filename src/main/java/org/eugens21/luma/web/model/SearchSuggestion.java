package org.eugens21.luma.web.model;

import com.microsoft.playwright.Locator;
import lombok.Getter;
import org.eugens21.luma.properties.pages.common.SearchAutoCompleteItemDetails;
import org.eugens21.luma.web.pages.elements.Span;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class SearchSuggestion {

    Span optionName;
    Span amount;

    public SearchSuggestion(Locator lct, SearchAutoCompleteItemDetails autoCompleteDetails) {
        this.optionName = new Span(lct.locator(autoCompleteDetails.getOptionName()));
        this.amount = new Span(lct.locator(autoCompleteDetails.getAmount()));
    }

}
