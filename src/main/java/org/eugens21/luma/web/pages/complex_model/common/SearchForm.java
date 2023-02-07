package org.eugens21.luma.web.pages.complex_model.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.SearchFormDetails;
import org.eugens21.luma.web.exception.SuggestionNotFoundException;
import org.eugens21.luma.web.factory.PageFactory;
import org.eugens21.luma.web.pages.elements.AbstractElement;
import org.eugens21.luma.web.pages.elements.Button;
import org.eugens21.luma.web.pages.elements.SearchAutoComplete;
import org.eugens21.luma.web.pages.elements.interfaces.AutoCompleteForm;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;
import org.eugens21.luma.web.pages.model.search_results.SearchSuggestion;

import java.util.List;

import static java.lang.String.format;
import static org.eugens21.luma.web.factory.Pages.SEARCH_PAGE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchForm extends AbstractElement implements AutoCompleteForm<SearchAutoComplete> {

    Button search;
    @Getter
    SearchAutoComplete autoComplete;

    public SearchForm(Page page, SearchFormDetails searchForm) {
        super(page, searchForm);
        this.search = new Button(page.locator(searchForm.getSearchButton()));
        this.autoComplete = new SearchAutoComplete(page, searchForm.getSearchAutoComplete());
    }

    @Override
    public void input(String text) {
        getLocator().fill(text);
    }

    @Override
    public String getText() {
        return getLocator().textContent();
    }

    public SearchResultsPage search() {
        search.click();
        return PageFactory.get(SEARCH_PAGE);
    }

    public SearchResultsPage searchForProduct(String productName) {
        input(productName);
        return search();
    }

    public List<SearchSuggestion> searchForSuggestions(String suggestion) {
        input(suggestion);
        return autoComplete.getSuggestions();
    }

    public SearchResultsPage chooseSuggestion(String suggestion) {
        return autoComplete.getSuggestions().stream()
                .filter(el -> el.hasName(suggestion))
                .findFirst()
                .map(SearchSuggestion::click)
                .orElseThrow(() -> new SuggestionNotFoundException(format("Unable to locate %s within existing suggestions", suggestion)));
    }

}
