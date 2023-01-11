package org.eugens21.luma.web.service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

@Lazy
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@Service
@Slf4j
public class BrowserService {

    BrowserType browserType;
    ContextOptionsService contextOptionsService;
    LaunchOptionsService launchOptionsService;
    @NonFinal
    Browser browser;
    @NonFinal
    BrowserContext browserContext;

    public Browser launchBrowser() {
        if (isNull(browser)) {
            browser = browserType.launch(launchOptionsService.getLaunchOptions());
            log.info("Browser launched");
        }
        return browser;
    }

    public BrowserContext configureBrowserContext() {
        if (isNull(browserContext)) {
            browserContext = launchBrowser().newContext(contextOptionsService.getContextOptions());
            log.info("Browser context launched");
        }
        return browserContext;
    }

    @PreDestroy
    public void close() {
        browserContext.close();
        log.info("Browser context closed");
        browser.close();
        log.info("Browser closed");

    }

}
