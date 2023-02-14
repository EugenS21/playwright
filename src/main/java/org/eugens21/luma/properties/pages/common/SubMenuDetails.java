package org.eugens21.luma.properties.pages.common;

import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Data
public class SubMenuDetails {

    AriaRole self;
    AriaRole item;

}
