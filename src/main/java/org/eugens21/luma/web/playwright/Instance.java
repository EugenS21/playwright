package org.eugens21.luma.web.playwright;

import com.microsoft.playwright.Playwright;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.luma.properties.Application;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Component
@Lazy
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class Instance {

    Application applicationProperties;
    @NonFinal Playwright playwright;

    @Bean
    @ConditionalOnProperty(prefix = "luma.userInterface", name = "enabled", havingValue = "true")
    public Playwright getPlaywright() {
        Map<String, String> createOptions = applicationProperties.getUserInterface().getPlaywright().getCreateOptions();
        Playwright.CreateOptions options = new Playwright.CreateOptions();
        options.setEnv(createOptions);
        playwright = Playwright.create(options);
        log.info("Playwright instance created with options: {}", createOptions);
        return playwright;
    }

    @PreDestroy
    public void close() {
        playwright.close();
        log.info("Playwright instance closed");
    }

}
