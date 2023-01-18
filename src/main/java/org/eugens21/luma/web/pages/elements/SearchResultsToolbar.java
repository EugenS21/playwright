package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.HeaderDetails;
import org.eugens21.luma.web.pages.elements.interfaces.Element;
import org.eugens21.luma.web.pages.elements.interfaces.IToolbar;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class SearchResultsToolbar implements IToolbar {

    Page page;
    String selfLocator;

    public SearchResultsToolbar(Page page, HeaderDetails contentDetails) {
        this.selfLocator = contentDetails.getSelf();
        this.page = page;
    }

    @Override
    public Locator getLocator() {
        return page.locator(selfLocator);
    }

    @Override
    public List<Element> getContent() {
        return null;
    }


}
