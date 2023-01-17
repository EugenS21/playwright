package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.SearchForm;
import org.eugens21.luma.web.pages.elements.interfaces.Input;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchBar implements Input {

    Button search;
    Page page;
    String locator;

    public SearchBar(Page page, SearchForm searchForm) {
        this.search = new Button(page, searchForm.getSearchButton());
        this.locator = searchForm.getSelf();
        this.page = page;
    }

    @Override
    public Locator getSelfLocator() {
        return page.locator(locator);
    }

    @Override
    public void input(String text) {
        getSelfLocator().fill(text);
    }

    @Override
    public String getText() {
        return getSelfLocator().textContent();
    }

    public void search() {
        search.click();
    }

}
