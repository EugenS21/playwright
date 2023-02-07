package org.eugens21.luma.web.factory;

import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.web.pages.AbstractPage;
import org.eugens21.luma.web.pages.home.HomePage;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public enum Pages {

    HOME_PAGE {
        @Override
        public AbstractPage get(Page page, PageLocators pageLocators) {
            return new HomePage(page, pageLocators);
        }
    },
    SEARCH_PAGE {
        @Override
        public AbstractPage get(Page page, PageLocators pageLocators) {
            return new SearchResultsPage(page, pageLocators);
        }
    };

    public abstract AbstractPage get(Page page, PageLocators pageLocators);

}
