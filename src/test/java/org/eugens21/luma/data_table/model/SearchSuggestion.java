package org.eugens21.luma.data_table.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchSuggestion {

    String suggestion;
    Integer quantity;

}
