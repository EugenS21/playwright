package org.eugens21.luma;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
