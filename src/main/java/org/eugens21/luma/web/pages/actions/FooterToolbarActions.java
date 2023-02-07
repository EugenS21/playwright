package org.eugens21.luma.web.pages.actions;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.factory.PageFactory;
import org.eugens21.luma.web.factory.Pages;
import org.eugens21.luma.web.pages.elements.Pagination;
import org.eugens21.luma.web.pages.model.search_results.SearchResultsPage;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FooterToolbarActions {

    Pagination paginationToolbar;

    public List<String> getPages() {
        return paginationToolbar.pages();
    }

    public SearchResultsPage next() {
        paginationToolbar.next().click();
        return PageFactory.get(Pages.SEARCH_RESULTS_PAGE);
    }

    public SearchResultsPage moveToPage(Integer number) {
        return PageFactory.get(Pages.SEARCH_RESULTS_PAGE);
    }

}
