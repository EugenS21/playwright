package org.eugens21.luma.web.pages.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.complex_model.search_results.grid.ProductItemInfo;

import java.util.Comparator;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum SortEnum {

    ASC,
    DESC;

    public Comparator<ProductItemInfo> get(Comparator<ProductItemInfo> comparator) {
        return this.equals(SortEnum.ASC) ? comparator : comparator.reversed();
    }

}
