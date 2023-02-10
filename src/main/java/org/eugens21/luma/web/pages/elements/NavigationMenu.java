package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.Menu;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class NavigationMenu implements Menu {

    @Getter
    Locator locator;

    @Override
    public void open(String... oaths) {
        locator.click();
    }

}
