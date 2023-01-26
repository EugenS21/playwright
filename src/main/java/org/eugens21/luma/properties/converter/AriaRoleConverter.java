package org.eugens21.luma.properties.converter;


import com.microsoft.playwright.options.AriaRole;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class AriaRoleConverter implements Converter<String, AriaRole> {

    @Override
    public AriaRole convert(String source) {
        return AriaRole.valueOf(source);
    }

}
