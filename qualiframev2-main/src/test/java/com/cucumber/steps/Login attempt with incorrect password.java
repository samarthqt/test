package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pageobjects.LoginPage;

public class LoginAttemptSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters \"valid_user\" in the username field")
    public void theUserEntersValidUserInTheUsernameField() {
        enterUserName("valid_user");
    }

    @When("the user enters \"incorrect_password\" in the password field")
    public void theUserEntersIncorrectPasswordInThePasswordField() {
        enterPassword("incorrect_password");
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