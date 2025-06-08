package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AgileTestingPage;

public class AgileTestingSteps extends AgileTestingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user opens a new browser window")
    public void theUserOpensANewBrowserWindow() {
        openNewBrowserWindow();
    }

    @When("the user enters the URL \"{string}\"")
    public void theUserEntersTheURL(String url) {
        navigateToUrl(url);
    }

    @Then("the Agile Testing page should be displayed")
    public void theAgileTestingPageShouldBeDisplayed() {
        verifyAgileTestingPageDisplayed();
    }

    @Given("the user is on the Agile Testing page")
    public void theUserIsOnTheAgileTestingPage() {
        verifyAgileTestingPageDisplayed();
    }

    @When("the user clicks on the \"{string}\" sub-menu")
    public void theUserClicksOnTheSubMenu(String subMenu) {
        clickAgileTestingSubMenu(subMenu);
    }

    @Then("the Agile Testing sub-menu should be displayed")
    public void theAgileTestingSubMenuShouldBeDisplayed() {
        verifyAgileTestingSubMenuDisplayed();
    }

    @When("the user calls Get Free Trial")
    public void theUserCallsGetFreeTrial() {
        initiateGetFreeTrial();
    }

    @Then("the Get Free Trial process should be initiated")
    public void theGetFreeTrialProcessShouldBeInitiated() {
        verifyGetFreeTrialInitiated();
    }

    @When("the user clicks on the content or Learn More button of the {string} section")
    public void theUserClicksOnTheContentOrLearnMoreButtonOfTheSection(String section) {
        clickSectionContentOrLearnMore(section);
    }

    @Then("the {string} section details should be displayed")
    public void theSectionDetailsShouldBeDisplayed(String section) {
        verifySectionDetailsDisplayed(section);
    }
}