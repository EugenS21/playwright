package org.eugens21.luma.hook;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.storage.ScenarioContext;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.BROWSER_PAGE;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class BrowserHooks {

    ScenarioContext scenarioContext;

    @After(value = "@ui")
    public void closePage() {
        if (scenarioContext.containsKey(BROWSER_PAGE)) {
            scenarioContext.getValue(BROWSER_PAGE, Page.class).close();
        }
    }

}

