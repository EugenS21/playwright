package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.CommonPageDetails;

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


}
