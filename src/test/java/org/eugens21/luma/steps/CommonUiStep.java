package org.eugens21.luma.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.service.BrowserService;

import static lombok.AccessLevel.PROTECTED;
import static org.eugens21.luma.enums.StorageKey.BROWSER_PAGE;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public class CommonUiStep {

    Application application;
    Browser browser;
    Page page;
    PageLocators pageLocators;
    ScenarioContext scenarioContext;

    public CommonUiStep(Application application, BrowserService browserService, PageLocators pageLocators, ScenarioContext scenarioContext) {
        this.application = application;
        this.browser = browserService.getBrowser();
        if (scenarioContext.containsKey(BROWSER_PAGE)) {
            this.page = scenarioContext.getValue(BROWSER_PAGE, Page.class);
        } else {
            this.page = browser.newPage();
            scenarioContext.addValue(BROWSER_PAGE, page);
        }
        this.pageLocators = pageLocators;
        this.scenarioContext = scenarioContext;
    }

}
