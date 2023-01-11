package org.eugens21.luma.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.PropertySource;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "luma")
@PropertySource(value = "classpath:application-yml.properties")
public class Application {

    String url;
    @NestedConfigurationProperty
    UserInterface userInterface;

}
