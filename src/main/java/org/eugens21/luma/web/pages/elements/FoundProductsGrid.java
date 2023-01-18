package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.eugens21.luma.properties.pages.search_results.ContentDetails;
import org.eugens21.luma.properties.pages.search_results.ItemsDetails;
import org.eugens21.luma.web.model.ProductItemInfo;
import org.eugens21.luma.web.pages.elements.interfaces.Grid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoundProductsGrid extends AbstractElement implements Grid<ProductItemInfo> {

    ContentDetails contentDetails;

    public FoundProductsGrid(Page page, ContentDetails content) {
        super(page, content);
        this.contentDetails = content;
    }

    @Override
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
