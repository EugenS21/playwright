package org.eugens21.luma.steps;

import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.storage.ScenarioContext;

import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PROTECTED)
public abstract class CommonSteps {

    Application application;
    ScenarioContext scenarioContext;
    SoftAssertions softAssertions;

    public CommonSteps(Application application, ScenarioContext scenarioContext) {
        this.application = application;
        this.scenarioContext = scenarioContext;
        this.softAssertions = scenarioContext.getSoftAssertions();
    }

}
