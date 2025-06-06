package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LoginPage;

public class ErrorMessageSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @Given("the login page displays username and password fields")
    public void theLoginPageDisplaysUsernameAndPasswordFields() {
        verifyElementVisible(txtUserName);
        verifyElementVisible(txtPassword);
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

    @Then("the system processes the login attempt")
    public void theSystemProcessesTheLoginAttempt() {
        // Logic to simulate processing
        waitForProcessing();
    }

    @Then("the login is unsuccessful, and the user remains on the login page")
    public void theLoginIsUnsuccessfulAndTheUserRemainsOnTheLoginPage() {
        verifyCurrentPageIsLoginPage();
    }

    @Then("an appropriate error message indicating incorrect password is displayed")
    public void anAppropriateErrorMessageIndicatingIncorrectPasswordIsDisplayed() {
        verifyErrorMessageDisplayed("Incorrect password.");
    }

    @Then("the error message is clear and provides guidance on next steps")
    public void theErrorMessageIsClearAndProvidesGuidanceOnNextSteps() {
        verifyErrorMessageGuidance("Please try again or reset your password.");
    }
}