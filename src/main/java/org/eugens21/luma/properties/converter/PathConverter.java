package org.eugens21.luma.properties.converter;


import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@ConfigurationPropertiesBinding
public class PathConverter implements Converter<String, Path> {

    @Override
    public Path convert(String source) {
        return Paths.get(source);
    }

}
