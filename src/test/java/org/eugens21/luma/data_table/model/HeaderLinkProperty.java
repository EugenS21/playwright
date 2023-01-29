package org.eugens21.luma.data_table.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HeaderLinkProperty {

    String link;
    boolean isDisplayed;
    boolean isClickable;

}
