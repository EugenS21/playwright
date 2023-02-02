package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.SearchAutoCompleteDetails;
import org.eugens21.luma.properties.pages.common.SearchAutoCompleteItemDetails;
import org.eugens21.luma.web.functional.WaitForState;
import org.eugens21.luma.web.pages.elements.interfaces.AutoComplete;
import org.eugens21.luma.web.pages.model.search_results.SearchSuggestion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchAutoComplete extends AbstractElement implements AutoComplete<SearchSuggestion> {

    public SearchAutoComplete(Page page, SearchAutoCompleteDetails autoCompleteDetails) {
        super(page, autoCompleteDetails);
    }

    @WaitForState(WaitForSelectorState.VISIBLE)
    public List<SearchSuggestion> getSuggestions() {
        SearchAutoCompleteItemDetails items = ((SearchAutoCompleteDetails) getAbstractDetails()).getItems();
        Locator siblings = getLocator().locator(items.getSelf());
        return Stream.iterate(0, i -> i + 1)
                .limit(siblings.count())
                .map(siblings::nth)
                .map(lct -> new SearchSuggestion(lct, items))
                .collect(Collectors.toList());
    }

}
