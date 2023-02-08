package org.eugens21.luma.web.pages.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.ProductItemInfo;

import java.util.Comparator;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public enum SortByEnum {

    RELEVANCE("Relevance", Comparator.comparing(var -> var.getName().getText())),
    PRICE("Price", Comparator.comparing(var -> var.getCost().getPriceWithoutCurrency())),
    PRODUCT_NAME("Product Name", Comparator.comparing(var -> var.getName().getText()));

    String text;
    Comparator<ProductItemInfo> comparator;

}
