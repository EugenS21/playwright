package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.CommonPageDetails;
import org.eugens21.luma.web.model.SearchSuggestion;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Header {

    @Getter
    HeaderLinks headerLinks;
    @Getter
    HeaderContent headerContent;

    public Header(Page page, CommonPageDetails commonPageDetails) {
        headerLinks = new HeaderLinks(page, commonPageDetails.getHeader().getPanel().getLinks());
        headerContent = new HeaderContent(page, commonPageDetails.getHeader().getContent());
    }

    public void searchForProductWithName(String name) {
        headerContent.getSearchForm().searchForProduct(name);
    }

    public List<SearchSuggestion> searchForSuggestions(String keyword) {
        return headerContent.getSearchForm().searchForSuggestions(keyword);
    }

}
