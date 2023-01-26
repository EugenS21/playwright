package org.eugens21.luma.data_table.type;

import io.cucumber.java.DataTableType;
import org.eugens21.luma.data_table.model.ProductInfo;

import java.util.List;
import java.util.Map;

public class ProductInfoType {

    @DataTableType
    public ProductInfo getHeaderProperty(Map<String, String> entry) {
        return ProductInfo.builder()
                .name(entry.get("Name"))
                .price(entry.get("Price"))
                .availableSizes(List.of(entry.get("Sizes").split(",")))
                .availableColors(List.of(entry.get("Colors").split(",")))
                .build();
    }

}
