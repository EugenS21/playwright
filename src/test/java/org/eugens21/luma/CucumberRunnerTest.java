package org.eugens21.luma;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.eugens21.luma.web.utils.EnvironmentDetailsWriter;
import org.testng.annotations.AfterClass;

@CucumberOptions(features = "src/test/resources/features")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDownClass() {
        super.tearDownClass();
        EnvironmentDetailsWriter environmentDetailsWriter = new EnvironmentDetailsWriter();
        environmentDetailsWriter.write(System.getProperties().entrySet());
    }

}
