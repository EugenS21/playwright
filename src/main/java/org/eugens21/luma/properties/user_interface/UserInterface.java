package org.eugens21.luma.properties.user_interface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class UserInterface {

    Boolean enabled;
    @NestedConfigurationProperty
    Playwright playwright;

}
