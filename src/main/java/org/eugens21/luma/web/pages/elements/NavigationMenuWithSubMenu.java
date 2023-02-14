package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.MainMenuDetails;
import org.eugens21.luma.web.exception.MenuNotFound;
import org.eugens21.luma.web.pages.elements.interfaces.Hoverable;

import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class NavigationMenuWithSubMenu implements Hoverable {

    @Getter
    Locator locator;
    MainMenuDetails menuDetails;
    String menuName;

    public NavigationMenuWithSubMenu(Locator locator, MainMenuDetails menuDetails) {
        this.locator = locator;
        this.menuName = locator.innerText();
        this.menuDetails = menuDetails;
    }

    @Override
    public void open(String... path) {
        locator.hover();
        for (int i = 0; i < path.length; i++) {
            Locator subMenu = hoverOverLevel0Menu(path[i]);
            if (i == path.length - 1) {
                subMenu.click();
            }
        }
    }

    public Locator hoverOverLevel0Menu(String name) {
        Locator subMenu0 = locator.getByRole(menuDetails.getSubMenu1().getSelf());
        return Stream.iterate(0, i -> i + 1)
                .limit(subMenu0.count())
                .map(subMenu0::nth)
                .filter(el -> el.innerText().equals(name))
                .findFirst()
                .map(el -> {
                    el.hover();
                    return el;
                })
                .orElseThrow(() -> new MenuNotFound(String.format("Sub menu %s not found under %s", name, menuName)));
    }

}
