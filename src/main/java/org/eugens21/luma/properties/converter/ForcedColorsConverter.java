package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.ForcedColors;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.ForcedColors.ACTIVE;
import static com.microsoft.playwright.options.ForcedColors.NONE;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class ForcedColorsConverter implements Converter<String, ForcedColors> {

    @Override
    public ForcedColors convert(String source) {
        return Match(source).of(
                Case($("active"), () -> ACTIVE),
                Case($(), () -> NONE)
        );
    }

}
