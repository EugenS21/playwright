package org.eugens21.luma.web.pages;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.CommonPageDetails;
import org.eugens21.luma.web.pages.common.Header;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public abstract class AbstractPage {

    Page page;
    Header header;

    public AbstractPage(CommonPageDetails commonPageDetails, Page page) {
        this.page = page;
        this.header = new Header(page, commonPageDetails);
    }
}
