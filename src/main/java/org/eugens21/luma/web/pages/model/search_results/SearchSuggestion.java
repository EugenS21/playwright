package org.eugens21.luma.web.pages.model.search_results;

import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.luma.properties.pages.common.SearchAutoCompleteItemDetails;
import org.eugens21.luma.web.pages.elements.Span;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.web.factory.PageFactory.get;
import static org.eugens21.luma.web.factory.Pages.SEARCH_RESULTS_PAGE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchSuggestion {

    Span optionName;
    Span amount;

    public SearchSuggestion(Locator lct, SearchAutoCompleteItemDetails autoCompleteDetails) {
        this.optionName = new Span(lct.locator(autoCompleteDetails.getOptionName()));
        this.amount = new Span(lct.locator(autoCompleteDetails.getAmount()));
    }

    public Pair<String, Integer> getSuggestionDetails() {
        return Pair.of(optionName.getContent(), Integer.parseInt(amount.getContent()));
    }

    public boolean hasName(String optionName) {
        return getSuggestionDetails().getKey().equals(optionName);
    }

    public SearchResultsPage click() {
        optionName.click();
        return get(SEARCH_RESULTS_PAGE);
    }

}
