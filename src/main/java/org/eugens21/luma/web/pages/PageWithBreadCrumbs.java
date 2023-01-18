package org.eugens21.luma.web.pages;

import com.microsoft.playwright.Page;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.common.Breadcrumbs;

public class PageWithBreadCrumbs extends AbstractPage {

    Breadcrumbs breadcrumbs;

    public PageWithBreadCrumbs(PageLocators commonPageDetails, Page page) {
        super(commonPageDetails, page);
    }

}
