package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AgileTestingPage;

public class AgileTestingSteps extends AgileTestingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a new browser window is opened")
    public void aNewBrowserWindowIsOpened() {
        openNewBrowserWindow();
    }

    @When("the user enters the URL \"{string}\"")
    public void theUserEntersTheURL(String url) {
        navigateToUrl(url);
    }

    @Then("the platform page should be displayed")
    public void thePlatformPageShouldBeDisplayed() {
        verifyPlatformPageDisplayed();
    }

    @When("the user clicks on the \"{string}\" sub-menu")
    public void theUserClicksOnTheSubMenu(String subMenu) {
        clickSubMenu(subMenu);
    }

    @Then("the Agile Testing page should be displayed")
    public void theAgileTestingPageShouldBeDisplayed() {
        verifyAgileTestingPageDisplayed();
    }
}