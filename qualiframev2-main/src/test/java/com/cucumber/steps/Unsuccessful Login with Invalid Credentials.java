package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnsuccessfulLoginSteps extends LoginPage {

    @Given("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        // Implementation to check URL accessibility
    }

    @When("I launch the CoCo URL in a web browser")
    public void iLaunchTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page should be displayed")
    public void theCoCoLoginPageShouldBeDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("I enter 'invalidUser' in the username field")
    public void iEnterInvalidUserInTheUsernameField() {
        enterUserName("invalidUser");
    }

    @When("I enter 'wrongPass' in the password field")
    public void iEnterWrongPassInThePasswordField() {
        enterPassword("wrongPass");
    }

    @When("I click on the Login button")
    public void iClickOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the login attempt should fail")
    public void theLoginAttemptShouldFail() {
        verifyLoginFailure();
    }

    @Then("an error message 'Invalid username or password' should be displayed")
    public void anErrorMessageInvalidUsernameOrPasswordShouldBeDisplayed() {
        verifyErrorMessage("Invalid username or password");
    }
}