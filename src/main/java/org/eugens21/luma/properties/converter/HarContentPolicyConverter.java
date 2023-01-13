package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.HarContentPolicy;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.HarContentPolicy.*;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class HarContentPolicyConverter implements Converter<String, HarContentPolicy> {

    @Override
    public HarContentPolicy convert(String source) {
        return Match(source).of(
                Case($("attach"), () -> ATTACH),
                Case($("embed"), () -> EMBED),
                Case($(), () -> OMIT)
        );
    }

}
