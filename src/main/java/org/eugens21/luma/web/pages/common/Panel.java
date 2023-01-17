package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.PanelDetails;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Panel {

    @Getter
    HeaderLinks headerLinks;

    public Panel(Page page, PanelDetails panel) {
        headerLinks = new HeaderLinks(page, panel.getLinks());
    }


}
