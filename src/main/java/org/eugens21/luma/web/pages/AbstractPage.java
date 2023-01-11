package org.eugens21.luma.web.pages;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.common.Header;
import org.eugens21.luma.web.pages.common.Panel;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractPage {

    Page page;
    Panel panel;
    Header header;

    public AbstractPage(Page page) {
        this.page = page;
        this.header = new Header(page);
        this.panel = new Panel(page);
    }
}
