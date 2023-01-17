package org.eugens21.luma.web.pages.home;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.AbstractPage;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage extends AbstractPage {

    public HomePage(PageLocators pageLocators, Page page) {
        super(pageLocators.getCommon(), page);
    }


}
