package org.eugens21.luma.enums;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public enum BrowserTypeEnum {

    CHROMIUM(Playwright::chromium),
    FIREFOX(Playwright::firefox);

    @Getter
    Function<Playwright, BrowserType> browserType;

    @Override
    public String toString() {
        return this.name();
    }

}
