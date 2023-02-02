package org.eugens21.luma.web.pages.actions;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.ProductItemInfo;
import org.eugens21.luma.web.pages.elements.FoundProductsGrid;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProductGridActions {

    FoundProductsGrid foundProductsGrid;

    public List<ProductItemInfo> getFoundProducts() {
        return foundProductsGrid.getElements();
    }

}
