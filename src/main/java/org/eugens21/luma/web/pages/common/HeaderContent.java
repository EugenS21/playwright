package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.ContentDetails;
import org.eugens21.luma.web.pages.elements.SearchForm;
import org.eugens21.luma.web.pages.elements.interfaces.Element;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HeaderContent implements Element {

    String selfLocator;
    Page page;
    @Getter
    SearchForm searchForm;

    public HeaderContent(Page page, ContentDetails contentDetails) {
        this.page = page;
        this.selfLocator = contentDetails.getSelf();
        this.searchForm = new SearchForm(page, contentDetails.getSearchForm());
    }

    @Override
    public Locator getLocator() {
        return page.locator(selfLocator);
    }

}
