package org.eugens21.luma.hook;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import io.cucumber.java.Before;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.service.BrowserService;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.BROWSER;
import static org.eugens21.luma.enums.StorageKey.BROWSER_CONTEXT;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class BrowserHooks {

    BrowserService browserService;
    ScenarioContext scenarioContext;

    @Before(value = "@ui", order = 1)
    public void doLaunchBrowser() {
        Browser browser = browserService.launchBrowser();
        scenarioContext.addValue(BROWSER, browser);
    }

    @Before(value = "@ui", order = 2)
    public void doConfigureContext() {
        BrowserContext browserContext = browserService.configureBrowserContext();
        scenarioContext.addValue(BROWSER_CONTEXT, browserContext);
    }

}
