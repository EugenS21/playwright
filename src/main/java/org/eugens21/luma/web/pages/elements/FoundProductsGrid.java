package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.luma.properties.pages.search_results.ContentDetails;
import org.eugens21.luma.properties.pages.search_results.ItemsDetails;
import org.eugens21.luma.web.functional.WaitForPageState;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.ProductItemInfo;
import org.eugens21.luma.web.pages.elements.interfaces.Grid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.microsoft.playwright.options.LoadState.DOMCONTENTLOADED;

@Slf4j
public class FoundProductsGrid extends AbstractElement implements Grid<ProductItemInfo> {

    ContentDetails contentDetails;

    public FoundProductsGrid(Page page, ContentDetails content) {
        super(page, content);
        this.contentDetails = content;
    }

    @Override
    @WaitForPageState(loadState = DOMCONTENTLOADED)
    public List<ProductItemInfo> getElements() {
        ItemsDetails itemsLocator = contentDetails.getItems();
        Locator listMembersLocator = getLocator().getByRole(itemsLocator.getSelf());
        return Stream.iterate(0, i -> i + 1)
                .limit(listMembersLocator.count())
                .map(listMembersLocator::nth)
                .map(locator -> new ProductItemInfo(locator, itemsLocator.getProduct()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductItemInfo searchForElement(ProductItemInfo element) {
        return null;
    }
}
