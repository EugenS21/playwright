package org.eugens21.luma.web.pages.enums;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import org.eugens21.luma.properties.pages.common.MainMenuDetails;
import org.eugens21.luma.web.pages.elements.NavigationMenu;
import org.eugens21.luma.web.pages.elements.NavigationMenuWithSubMenu;
import org.eugens21.luma.web.pages.elements.interfaces.Menu;

@AllArgsConstructor
public enum NavigationMenuEnum {

    WHATS_NEW {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenu(locator);
        }
    },
    WOMEN {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenuWithSubMenu(locator, menuDetails);
        }
    },
    MEN {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenuWithSubMenu(locator, menuDetails);
        }
    },
    GEAR {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenuWithSubMenu(locator, menuDetails);
        }
    },
    TRAINING {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenuWithSubMenu(locator, menuDetails);
        }
    },
    SALE {
        @Override
        public Menu get(Locator locator, MainMenuDetails menuDetails) {
            return new NavigationMenu(locator);
        }
    };

    public static NavigationMenuEnum of(String value) {
        if (value.contains("What")) {
            return WHATS_NEW;
        }
        return NavigationMenuEnum.valueOf(value.toUpperCase());
    }

    public abstract Menu get(Locator locator, MainMenuDetails menuDetails);

}
