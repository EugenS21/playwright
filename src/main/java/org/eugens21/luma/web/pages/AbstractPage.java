package org.eugens21.luma.web.pages;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.model.SearchSuggestion;
import org.eugens21.luma.web.pages.common.Header;
import org.eugens21.luma.web.pages.search_results.SearchResultsPage;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public abstract class AbstractPage {

    Page page;
    Header header;
    PageLocators pageLocators;

    public AbstractPage(PageLocators pageLocators, Page page) {
        this.page = page;
        this.pageLocators = pageLocators;
        this.header = new Header(page, pageLocators.getCommon());
    }

    public SearchResultsPage searchForProduct(String productName) {
        header.searchForProductWithName(productName);
        return new SearchResultsPage(page, pageLocators);
    }

    public List<SearchSuggestion> lookingForSuggestions(String productName) {
        return header.searchForSuggestions(productName);
    }

}
