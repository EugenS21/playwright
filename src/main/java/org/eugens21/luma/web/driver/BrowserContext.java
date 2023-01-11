package org.eugens21.luma.web.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class BrowserContext {

    BrowserType browserType;

    @Bean
    public com.microsoft.playwright.BrowserContext getBrowserContext() {
        Browser launch = browserType.launch();
        return launch.newContext();
    }

}
