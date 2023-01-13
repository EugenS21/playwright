package org.eugens21.luma.properties.user_interface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.enums.BrowserTypeEnum;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Browser {

    BrowserTypeEnum type;
    @NestedConfigurationProperty
    LaunchOptions launchOptions;
    @NestedConfigurationProperty
    ContextOptions contextOptions;
}
