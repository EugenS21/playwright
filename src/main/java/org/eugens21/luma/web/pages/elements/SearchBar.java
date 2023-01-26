package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.SearchForm;
import org.eugens21.luma.web.pages.elements.interfaces.Input;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchBar extends AbstractElement implements Input {

    Button search;

    public SearchBar(Page page, SearchForm searchForm) {
        super(page, searchForm);
        this.search = new Button(page.locator(searchForm.getSearchButton()));
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

    public void search(String productName) {
        input(productName);
        search();
    }

}
