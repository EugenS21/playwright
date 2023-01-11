package org.eugens21.luma.properties.user_interface;

import com.microsoft.playwright.Playwright.CreateOptions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.enums.BrowserTypeEnum;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Map;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Playwright {

    Map<String, String> createOptions;
    BrowserTypeEnum browserType;

}
