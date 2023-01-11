package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.ReducedMotion;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.ReducedMotion.NO_PREFERENCE;
import static com.microsoft.playwright.options.ReducedMotion.REDUCE;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class ReducedMotionConverter implements Converter<String, ReducedMotion> {

    @Override
    public ReducedMotion convert(String source) {
        return Match(source).of(
                Case($("reduce"), () -> REDUCE),
                Case($(), () -> NO_PREFERENCE)
        );
    }

}
