package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.SearchFormDetails;
import org.eugens21.luma.web.model.SearchSuggestion;
import org.eugens21.luma.web.pages.elements.interfaces.AutoCompleteForm;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchForm extends AbstractElement implements AutoCompleteForm {

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

    public void search() {
        search.click();
    }

    public void searchForProduct(String productName) {
        input(productName);
        search();
    }

    public List<SearchSuggestion> searchForSuggestions(String suggestion) {
        input(suggestion);
        return autoComplete.getSuggestions();
    }

}
