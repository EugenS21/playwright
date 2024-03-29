package org.eugens21.luma.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.service.BrowserService;
import org.eugens21.luma.web.utils.UiStep;

import static lombok.AccessLevel.PROTECTED;
import static org.eugens21.luma.enums.StorageKey.BROWSER_PAGE;
import static org.eugens21.luma.web.factory.PageFactory.init;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public abstract class CommonUiStep extends CommonSteps implements UiStep {

    Browser browser;
    @Getter
    Page page;
    PageLocators pageLocators;

    public CommonUiStep(Application application, BrowserService browserService, PageLocators pageLocators, ScenarioContext scenarioContext) {
        super(application, scenarioContext);
        this.browser = browserService.getBrowser();
        if (scenarioContext.containsKey(BROWSER_PAGE)) {
            this.page = scenarioContext.getValue(BROWSER_PAGE, Page.class);
        } else {
            this.page = browserService.getPage();
            scenarioContext.addValue(BROWSER_PAGE, page);
        }
        this.pageLocators = pageLocators;
        init(page, pageLocators);
    }

}
