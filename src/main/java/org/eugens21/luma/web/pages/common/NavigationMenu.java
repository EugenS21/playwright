package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.luma.properties.pages.common.MainMenuDetails;
import org.eugens21.luma.properties.pages.common.NavigationDetails;
import org.eugens21.luma.web.pages.elements.interfaces.Menu;
import org.eugens21.luma.web.pages.enums.NavigationMenuEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NavigationMenu {

    Supplier<Stream<Locator>> menuItemsStream;
    Map<NavigationMenuEnum, Menu> menus;
    MainMenuDetails menu;

    public NavigationMenu(Page page, NavigationDetails menu) {
        Locator navigationBar = page.getByRole(menu.getSelf()).getByRole(menu.getItems().getSelf());
        this.menu = menu.getItems().getMenu();
        this.menuItemsStream = () -> Stream.iterate(0, i -> i + 1)
                .limit(navigationBar.count())
                .map(navigationBar::nth);
        this.menus = init();
    }

    public void open(NavigationMenuEnum menu, String... pathToVisit) {
        menus.get(menu).open(pathToVisit);
    }

    private HashMap<NavigationMenuEnum, Menu> init() {
        return menuItemsStream.get()
                .map(el -> {
                    String s = el.getByRole(menu.getSelf()).textContent();
                    NavigationMenuEnum menu = NavigationMenuEnum.of(s);
                    return Pair.of(menu, menu.get(el, this.menu));
                })
                .collect(HashMap::new, (map, pair) -> map.put(pair.getKey(), pair.getValue()), HashMap::putAll);
    }

    public List<String> getMenuItems() {
        return menuItemsStream.get()
                .map(el -> el.getByRole(menu.getSelf()).textContent())
                .toList();
    }

}
