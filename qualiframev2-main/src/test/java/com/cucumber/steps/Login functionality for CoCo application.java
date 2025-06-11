package com.cucumber.steps;

import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    @Given("the CoCo URL is accessible")
    public void theCoCoURLIsAccessible() {
        verifyUrlAccessibility();
    }

    @When("I launch the CoCo URL in a web browser")
    public void iLaunchTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
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
        verifyLoginFailure();
    }

    @Then("an error message 'Username and password cannot be empty' is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessage("Username and password cannot be empty");
    }

    @Given("the user has a valid username and password")
    public void theUserHasAValidUsernameAndPassword() {
        // Implementation to set valid credentials
    }

    @When("the user launches the CoCo URL in a web browser")
    public void theUserLaunchesTheCoCoURLInAWebBrowser() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the CoCo login page is displayed")
    public void theCoCoLoginPageIsDisplayedAgain() {
        verifyLoginPageDisplayed();
    }

    @Then("the CoCo URL is accessible")
    public void theCoCoURLIsAccessibleAgain() {
        verifyUrlAccessibility();
    }

    @When("the user enters {string} in the username field")
    public void theUserEntersInTheUsernameField(String username) {
        enterUserName(username);
    }

    @Then("the username is entered correctly")
    public void theUsernameIsEnteredCorrectly() {
        // Implementation to verify username entry
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password is entered correctly")
    public void thePasswordIsEnteredCorrectly() {
        // Implementation to verify password entry
    }

    @When("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the user is redirected to the homepage")
    public void theUserIsRedirectedToTheHomepage() {
        verifyHomePageRedirection();
    }

    @Then("the homepage is displayed with user-specific content")
    public void theHomepageIsDisplayedWithUserSpecificContent() {
        verifyUserSpecificContent();
    }

    @When("I enter 'invalidUser' in the username field")
    public void iEnterInvalidUserInTheUsernameField() {
        enterUserName("invalidUser");
    }

    @When("I enter 'wrongPass' in the password field")
    public void iEnterWrongPassInThePasswordField() {
        enterPassword("wrongPass");
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