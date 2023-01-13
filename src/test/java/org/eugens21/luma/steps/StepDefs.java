package org.eugens21.luma.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.enums.StorageKey;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.pages.home.HomePage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class StepDefs {

    PageLocators pageLocators;
    ScenarioContext scenarioContext;
    Application application;

    @Given("I try to visit home page")
    public void iTryToVisitHomePage() {
        Browser browser = scenarioContext.getValue(StorageKey.BROWSER, Browser.class);
        Page page = browser.newPage();
//        Response navigate = page.navigate(application.getUrl());
        HomePage homePage = new HomePage(pageLocators, page);
        System.out.println();
    }
}
