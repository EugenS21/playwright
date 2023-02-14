package org.eugens21.luma.properties.pages.common;

import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Data
public class NavigationDetails {

    AriaRole self;
    @NestedConfigurationProperty
    NavigationMenuItemsDetails items;

}
