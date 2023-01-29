package org.eugens21.luma.hook;

import io.cucumber.java.After;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.steps.CommonSteps;
import org.eugens21.luma.storage.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AssertionHooks extends CommonSteps {

    @Autowired
    public AssertionHooks(Application application, ScenarioContext scenarioContext) {
        super(application, scenarioContext);
    }

    @After(order = 1)
    public void doAssertAll() {
        softAssertions.assertAll();
    }

}
