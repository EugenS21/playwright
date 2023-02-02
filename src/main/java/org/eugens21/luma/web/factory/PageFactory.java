package org.eugens21.luma.web.factory;

import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.exception.PageNotFoundException;
import org.eugens21.luma.web.pages.AbstractPage;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public final class PageFactory {

    static Map<Pages, AbstractPage> pages = new HashMap<>();

    public static AbstractPage get(Pages page) {
        if (pages.containsKey(page)) {
            return pages.get(page);
        }
        throw new PageNotFoundException(pages.toString().concat(" does not contain ".concat(page.name())));
    }

    public static void init(Page page, PageLocators pageLocators) {
        pages.putAll(stream(Pages.values())
                .map(el -> Pair.of(el, el.get(page, pageLocators)))
                .collect(HashMap::new, (map, key) -> map.put(key.getKey(), key.getValue()), HashMap::putAll));
    }

}
