package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.HarMode;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.HarMode.FULL;
import static com.microsoft.playwright.options.HarMode.MINIMAL;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class HarModeConverter implements Converter<String, HarMode> {

    @Override
    public HarMode convert(String source) {
        return Match(source).of(
                Case($("full"), () -> FULL),
                Case($(), () -> MINIMAL)
        );
    }

}
