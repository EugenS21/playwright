package org.eugens21.luma.hook;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.service.BrowserService;

import java.nio.file.Path;
import java.nio.file.Paths;

import static io.qameta.allure.Allure.getLifecycle;
import static java.nio.file.Files.readAllBytes;
import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.BROWSER_PAGE;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class BrowserHooks {

    BrowserService browserService;
    ScenarioContext scenarioContext;

    @SneakyThrows
    private Path getPathToTraceFile() {
        return Paths.get(getClass().getResource("/").toURI()).getParent().resolve("trace.zip");
    }

    @Before
    public void openTrace(Scenario scenario) {
        browserService.getBrowserContext().tracing().start(new Tracing.StartOptions()
                .setName(scenario.getName())
                .setScreenshots(true)
                .setSnapshots(true)
                .setTitle(scenario.getName()));
    }

    @After
    @SneakyThrows
    public void closeTrace() {
        browserService.getBrowserContext().tracing().stop(new Tracing.StopOptions()
                .setPath(getPathToTraceFile()));
        getLifecycle().addAttachment("Trace", "application/zip", "zip", readAllBytes(getPathToTraceFile()));
    }

    @After(value = "@ui")
    public void closePage() {
        if (scenarioContext.containsKey(BROWSER_PAGE)) {
            scenarioContext.getValue(BROWSER_PAGE, Page.class).close();
        }
    }

}

