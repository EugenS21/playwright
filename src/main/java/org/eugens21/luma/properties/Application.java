package org.eugens21.luma.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.user_interface.UserInterface;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "luma")
public class Application {

    String url;
    @NestedConfigurationProperty
    UserInterface userInterface;

}
