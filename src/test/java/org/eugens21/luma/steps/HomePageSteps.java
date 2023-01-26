package org.eugens21.luma.steps;

import com.microsoft.playwright.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.data_table.model.HeaderLinkProperty;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.PageLocators;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.pages.common.HeaderLinks;
import org.eugens21.luma.web.pages.elements.Span;
import org.eugens21.luma.web.pages.elements.interfaces.IAnchor;
import org.eugens21.luma.web.pages.elements.interfaces.PageElement;
import org.eugens21.luma.web.pages.home.HomePage;
import org.eugens21.luma.web.service.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.luma.enums.StorageKey.GENERIC;
import static org.eugens21.luma.enums.StorageKey.HOME_PAGE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class HomePageSteps extends CommonUiStep {

    @Autowired
    public HomePageSteps(Application application, BrowserService browserService, PageLocators pageLocators, ScenarioContext scenarioContext) {
        super(application, browserService, pageLocators, scenarioContext);
    }

    @Given("user navigates to home page")
    public void userNavigatesToPage() {
        Response homePageResponse = page.navigate(application.getUrl());
        scenarioContext.addValue(GENERIC, homePageResponse);
        HomePage homePage = new HomePage(page, pageLocators);
        scenarioContext.addValue(HOME_PAGE, homePage);
    }

    @Then("user/he/she is on home page")
    public void userIsOnHomePage() {
        softAssertions.assertThat(scenarioContext.getValue(GENERIC, Response.class))
                .describedAs("User is on home page")
                .extracting(Response::ok)
                .isEqualTo(true);
    }


    @When("user/he/she is investigating the header panel structure")
    public void userIsInvestigatingTheHeaderPanelStructure() {
        HomePage homePage = scenarioContext.getValue(HOME_PAGE, HomePage.class);
        HeaderLinks headerLinks = homePage.getHeader().getHeaderLinks();
        scenarioContext.addValue(GENERIC, headerLinks);
    }

    @Then("user/he/she should see the following links:")
    public void heShouldSeeTheFollowingLinks(List<HeaderLinkProperty> linkPropertyList) {
        HeaderLinks headerLinks = scenarioContext.getValue(GENERIC, HeaderLinks.class);
        softAssertions.assertThat(linkPropertyList)
                .allSatisfy(linkProperty -> {
                    String link = linkProperty.getLink();
                    IAnchor linkByName = headerLinks.getLinkByName(link);
                    softAssertions.assertThat(linkByName)
                            .describedAs("Expecting link <%s> to be clickable and displayed")
                            .extracting(IAnchor::isClickable, PageElement::isDisplayed)
                            .containsOnly(true);
                });
    }

    @Then("user/he/she should see the following welcome message: {string}")
    public void heShouldSeeTheFollowingWelcomeMessage(String welcomeMessage) {
        HeaderLinks headerLinks = scenarioContext.getValue(GENERIC, HeaderLinks.class);
        softAssertions.assertThat(headerLinks)
                .describedAs("Expecting non null welcome message: <%s>", welcomeMessage)
                .extracting(HeaderLinks::getWelcomeMessage)
                .extracting(Span::getContent)
                .isEqualTo(welcomeMessage);
    }

}
