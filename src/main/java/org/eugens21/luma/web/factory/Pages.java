package org.eugens21.luma.web.factory;

import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.AbstractPage;
import org.eugens21.luma.web.pages.home.HomePage;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public enum Pages {

    HOME_PAGE {
        @Override
        public <T extends AbstractPage> Supplier<T> get(Page page, PageLocators pageLocators) {
            return () -> (T) new HomePage(page, pageLocators);
        }
    },
    SEARCH_RESULTS_PAGE {
        @Override
        public <T extends AbstractPage> Supplier<T> get(Page page, PageLocators pageLocators) {
            return () -> (T) new SearchResultsPage(page, pageLocators);
        }
    };

    public abstract <T extends AbstractPage> Supplier<T> get(Page page, PageLocators pageLocators);

}
