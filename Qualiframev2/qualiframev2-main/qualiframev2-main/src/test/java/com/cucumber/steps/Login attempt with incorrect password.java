package com.cucumber.steps;

import com.pageobjects.LoginPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAttemptSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters {string} in the username field")
    public void theUserEntersInTheUsernameField(String username) {
        enterUserName(username);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        clickLoginButton();
    }

    @Then("the login attempt is unsuccessful, and the user remains on the login page")
    public void theLoginAttemptIsUnsuccessfulAndTheUserRemainsOnTheLoginPage() {
        String currentURL = getCurrentURL();
        String loginPageURL = getAppUrl();
        Assert.assertEquals(currentURL, loginPageURL, "User is not on the login page.");
    }

    @Then("an appropriate error message is displayed")
    public void anAppropriateErrorMessageIsDisplayed() {
        String errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.contains("incorrect"), "Error message is not appropriate.");
    }

    @Then("the error message states that the username/password is incorrect")
    public void theErrorMessageStatesThatTheUsernamePasswordIsIncorrect() {
        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "The username/password is incorrect.", "Error message does not match.");
    }
}