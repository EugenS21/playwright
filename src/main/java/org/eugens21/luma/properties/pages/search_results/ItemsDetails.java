package org.eugens21.luma.properties.pages.search_results;

import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ItemsDetails {

    AriaRole self;
    @NestedConfigurationProperty
    ProductDetails product;

}
