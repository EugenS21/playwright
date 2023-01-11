package org.eugens21.luma.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.user_interface.Playwright;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UserInterface {

    @NestedConfigurationProperty
    Playwright playwright;

}
