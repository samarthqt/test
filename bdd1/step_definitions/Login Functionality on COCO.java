package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalitySteps extends LoginPage {

    @Given("I am on the COCO login screen")
    public void iAmOnTheCOCOLoginScreen() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("I look at the login options")
    public void iLookAtTheLoginOptions() {
        // No specific action needed, just checking the visibility
    }

    @Then("I should see a new button \"Login with SSO\" displayed on the login screen")
    public void iShouldSeeANewButtonLoginWithSSODisplayedOnTheLoginScreen() {
        verifySSOButtonVisibility();
    }
}