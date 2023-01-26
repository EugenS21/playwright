package org.eugens21.luma.data_table.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductInfo {

    String name;
    String rating;
    Integer reviews;
    String price;
    List<String> availableSizes;
    List<String> availableColors;

}
