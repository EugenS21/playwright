package org.eugens21.luma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Lazy;

@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "org.eugens21.luma.properties")
@SpringBootApplication(scanBasePackages = "org.eugens21.luma")
@Lazy
public class LumaAutomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LumaAutomationApplication.class);
    }

}
