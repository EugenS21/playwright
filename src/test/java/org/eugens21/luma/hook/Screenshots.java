package org.eugens21.luma.hook;

import com.microsoft.playwright.Page;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.storage.ScenarioContext;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.BROWSER_PAGE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class Screenshots {

    ScenarioContext scenarioContext;

    @AfterStep
    public void doScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            Page value = scenarioContext.getValue(BROWSER_PAGE, Page.class);
            byte[] screenshot = value.screenshot();
            scenario.attach(screenshot, "image/png", LocalDateTime.now().toString());
        }
    }

}
