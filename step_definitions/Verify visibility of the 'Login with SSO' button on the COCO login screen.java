package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CocoLoginPage;

public class CocoLoginSteps extends CocoLoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to the COCO application login screen")
    public void iHaveAccessToTheCOCOApplicationLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I navigate to the COCO login screen")
    public void iNavigateToTheCOCOLoginScreen() {
        verifyLoginScreenDisplayed();
    }

    @Then("the login screen is displayed")
    public void theLoginScreenIsDisplayed() {
        verifyLoginScreenDisplayed();
    }

    @Then("'Login with SSO' button is visible on the login screen")
    public void loginWithSSOButtonIsVisibleOnTheLoginScreen() {
        verifySSOButtonVisibility();
    }
}