package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAttemptSteps extends LoginPage {

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
        verifyUserRemainsOnLoginPage();
    }

    @Then("an appropriate error message is displayed")
    public void anAppropriateErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message states that the username/password is incorrect")
    public void theErrorMessageStatesThatTheUsernamePasswordIsIncorrect() {
        verifyErrorMessageContent("The username/password is incorrect.");
    }
}