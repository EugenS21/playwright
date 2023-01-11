package org.eugens21.luma.web.driver;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.luma.enums.BrowserTypeEnum;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.UserInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class Browser {

    Playwright playwright;
    Application applicationProperties;

    @Bean
    public BrowserType getBrowser() {
        BrowserTypeEnum browserType = applicationProperties.getUserInterface().getPlaywright().getBrowserType();
        log.info("Using browser of type {}", browserType);
        return browserType.getBrowserType().apply(playwright);
    }

}
