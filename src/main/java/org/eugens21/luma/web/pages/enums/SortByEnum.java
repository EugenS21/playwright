package org.eugens21.luma.web.pages.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public enum SortByEnum {

    RELEVANCE("Relevance"),
    PRICE("Price"),
    PRODUCT_NAME("Product Name");

    @Getter
    String text;

}
