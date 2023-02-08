package org.eugens21.luma.web.pages.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum ItemsPerPageEnum {

    _12("12"),
    _24("24"),
    _36("36");

    String text;

}
