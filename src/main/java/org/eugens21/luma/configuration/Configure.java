package org.eugens21.luma.configuration;

import lombok.val;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class Configure {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        val configuration = modelMapper.getConfiguration();
        configuration.setFieldAccessLevel(PRIVATE);
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
        configuration.setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }

}
