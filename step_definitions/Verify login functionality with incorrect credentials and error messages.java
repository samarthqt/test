package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LoginPage;

public class LoginSteps extends LoginPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters an email {string} and password {string}")
    public void theUserEntersAnEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user enters a valid email and incorrect password {string}")
    public void theUserEntersAValidEmailAndIncorrectPassword(String password) {
        String email = testHarness.getData("LoginData", "ValidEmail");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user enters an incorrect email {string} and correct password")
    public void theUserEntersAnIncorrectEmailAndCorrectPassword(String email) {
        String password = testHarness.getData("LoginData", "CorrectPassword");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user leaves the email field empty")
    public void theUserLeavesTheEmailFieldEmpty() {
        enterEmail("");
    }

    @When("the user leaves the password field empty")
    public void theUserLeavesThePasswordFieldEmpty() {
        enterPassword("");
    }

    @When("the user enters incorrect credentials multiple times")
    public void theUserEntersIncorrectCredentialsMultipleTimes() {
        for (int i = 0; i < 3; i++) {
            enterEmail("invaliduser@example.com");
            enterPassword("WrongPass123");
            clickLoginButton();
        }
    }

    @When("the user attempts login with incorrect credentials multiple times")
    public void theUserAttemptsLoginWithIncorrectCredentialsMultipleTimes() {
        theUserEntersIncorrectCredentialsMultipleTimes();
    }

    @When("the user attempts login with incorrect credentials")
    public void theUserAttemptsLoginWithIncorrectCredentials() {
        enterEmail("invaliduser@example.com");
        enterPassword("WrongPass123");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        String email = testHarness.getData("LoginData", "ValidEmail");
        String password = testHarness.getData("LoginData", "CorrectPassword");
        enterEmail(email);
        enterPassword(password);
    }

    @When("the user attempts login without internet connection")
    public void theUserAttemptsLoginWithoutInternetConnection() {
        disableInternetConnection();
        enterEmail("invaliduser@example.com");
        enterPassword("WrongPass123");
    }

    @Then("the system displays an error message indicating incorrect credentials")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectCredentials() {
        verifyErrorMessage("Incorrect credentials");
    }

    @Then("the error message clearly states the reason for login failure")
    public void theErrorMessageClearlyStatesTheReasonForLoginFailure() {
        verifyErrorMessageContains("reason for login failure");
    }

    @Then("the system displays an error message indicating incorrect password")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectPassword() {
        verifyErrorMessage("Incorrect password");
    }

    @Then("the system displays an error message indicating incorrect email")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectEmail() {
        verifyErrorMessage("Incorrect email");
    }

    @Then("the system prompts to enter email")
    public void theSystemPromptsToEnterEmail() {
        verifyErrorMessage("Please enter email");
    }

    @Then("the system prompts to enter password")
    public void theSystemPromptsToEnterPassword() {
        verifyErrorMessage("Please enter password");
    }

    @Then("the system displays consistent error messages for each attempt")
    public void theSystemDisplaysConsistentErrorMessagesForEachAttempt() {
        verifyErrorMessage("Incorrect credentials");
    }

    @Then("the system triggers security measures after several failed attempts")
    public void theSystemTriggersSecurityMeasuresAfterSeveralFailedAttempts() {
        verifySecurityMeasuresTriggered();
    }

    @Then("error messages are accessible and clearly visible")
    public void errorMessagesAreAccessibleAndClearlyVisible() {
        verifyErrorMessageAccessibility();
    }

    @Then("the user is able to log in successfully with correct credentials")
    public void theUserIsAbleToLogInSuccessfullyWithCorrectCredentials() {
        verifyHomePageRedirection(testHarness.getData("LoginData", "ExpectedHomePageURL"));
    }

    @Then("error messages are displayed correctly on mobile devices")
    public void errorMessagesAreDisplayedCorrectlyOnMobileDevices() {
        verifyErrorMessageOnMobile();
    }

    @Then("the system displays an error message indicating network issue")
    public void theSystemDisplaysAnErrorMessageIndicatingNetworkIssue() {
        verifyErrorMessage("Network issue");
    }

    @Then("system logs contain records of failed login attempts")
    public void systemLogsContainRecordsOfFailedLoginAttempts() {
        verifySystemLogsForFailedAttempts();
    }
}