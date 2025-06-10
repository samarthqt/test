package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    @Given("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        // Implementation to check URL accessibility
    }

    @When("I launch the CoCo URL in a web browser")
    public void iLaunchTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayed() {
        // Implementation to verify login page display
    }

    @When("I leave the username field empty")
    public void iLeaveTheUsernameFieldEmpty() {
        enterUserName("");
    }

    @When("I leave the password field empty")
    public void iLeaveThePasswordFieldEmpty() {
        enterPassword("");
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the login attempt fails")
    public void theLoginAttemptFails() {
        // Implementation to verify login failure
    }

    @Then("an error message 'Username and password cannot be empty' is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessage("Username and password cannot be empty");
    }
}