package org.eugens21.luma.web.factory;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.exception.PageNotFoundException;
import org.eugens21.luma.web.pages.AbstractPage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Arrays.stream;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public final class PageFactory {

    static Map<Pages, Supplier<AbstractPage>> pages = new HashMap<>();
    static Page page;

    public static <T extends AbstractPage> T get(Pages page) {
        PageFactory.page.waitForLoadState(LoadState.LOAD);
        if (pages.containsKey(page)) {
            return (T) pages.get(page).get();
        }
        throw new PageNotFoundException(pages.toString().concat(" does not contain ".concat(page.name())));
    }

    public static void init(Page page, PageLocators pageLocators) {
        PageFactory.page = page;
        pages.putAll(stream(Pages.values())
                .map(el -> Pair.of(el, el.get(page, pageLocators)))
                .collect(HashMap::new, (map, key) -> map.put(key.getKey(), key.getValue()), HashMap::putAll));
    }

}
