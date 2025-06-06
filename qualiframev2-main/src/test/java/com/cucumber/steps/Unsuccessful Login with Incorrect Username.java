package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UnsuccessfulLoginSteps extends LoginPage {

    @Given("the user account is created and activated")
    public void theUserAccountIsCreatedAndActivated() {
        // Assume user account is already created and activated
    }

    @When("the user navigates to the login page of the application")
    public void theUserNavigatesToTheLoginPageOfTheApplication() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Then("the login page is displayed with username and password fields")
    public void theLoginPageIsDisplayedWithUsernameAndPasswordFields() {
        verifyLoginPageDisplayed();
    }

    @When("the user enters {string} in the username field")
    public void theUserEntersInTheUsernameField(String username) {
        enterUserName(username);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        clickLoginButton();
    }

    @Then("the system processes the login request")
    public void theSystemProcessesTheLoginRequest() {
        // Assume processing is done
    }

    @Then("the login attempt is unsuccessful")
    public void theLoginAttemptIsUnsuccessful() {
        verifyLoginUnsuccessful();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message is clear and informative")
    public void theErrorMessageIsClearAndInformative() {
        verifyErrorMessageContent();
    }

    @Then("the error message states that the username/password is incorrect")
    public void theErrorMessageStatesThatTheUsernamePasswordIsIncorrect() {
        verifyErrorMessageIncorrectCredentials();
    }
}