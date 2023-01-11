package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.ColorScheme;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.ColorScheme.*;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class ColorSchemaConverter implements Converter<String, ColorScheme> {

    @Override
    public ColorScheme convert(String source) {
        return Match(source).of(
                Case($("dark"), () -> DARK),
                Case($("light"), () -> LIGHT),
                Case($(), () -> NO_PREFERENCE)
        );
    }

}
