package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.ServiceWorkerPolicy;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.microsoft.playwright.options.ServiceWorkerPolicy.ALLOW;
import static com.microsoft.playwright.options.ServiceWorkerPolicy.BLOCK;
import static io.vavr.API.*;

@Component
@ConfigurationPropertiesBinding
public class ServiceWorkerPolicyConverter implements Converter<String, ServiceWorkerPolicy> {

    @Override
    public ServiceWorkerPolicy convert(String source) {
        return Match(source).of(
                Case($("allow"), () -> ALLOW),
                Case($(), () -> BLOCK)
        );
    }

}
