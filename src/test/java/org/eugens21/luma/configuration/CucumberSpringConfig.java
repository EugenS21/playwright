package org.eugens21.luma.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.eugens21.luma.LumaAutomationApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = LumaAutomationApplication.class)
public class CucumberSpringConfig {}