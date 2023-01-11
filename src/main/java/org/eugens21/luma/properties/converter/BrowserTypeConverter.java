package org.eugens21.luma.properties.converter;


import io.vavr.API;
import org.eugens21.luma.enums.BrowserTypeEnum;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static io.vavr.API.*;
import static org.eugens21.luma.enums.BrowserTypeEnum.CHROMIUM;
import static org.eugens21.luma.enums.BrowserTypeEnum.FIREFOX;

@Component
@ConfigurationPropertiesBinding
public class BrowserTypeConverter implements Converter<String, BrowserTypeEnum> {

    @Override
    public BrowserTypeEnum convert(String source) {
        return Match(source.toLowerCase()).of(
                Case($("firefox"), () -> FIREFOX),
                Case($(), () -> CHROMIUM));
    }

}
