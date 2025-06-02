package com.cucumber.steps;

import com.page_objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends LoginPage {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user enters a valid username {string} and an invalid password {string}")
    public void theUserEntersAValidUsernameAndAnInvalidPassword(String username, String password) {
        enterUserName(username);
        enterPassword(password);
    }

    @When("the user enters an invalid username and password")
    public void theUserEntersAnInvalidUsernameAndPassword() {
        enterUserName("invalid@example.com");
        enterPassword("InvalidPassword123");
    }

    @When("the user leaves the username and password fields empty")
    public void theUserLeavesTheUsernameAndPasswordFieldsEmpty() {
        enterUserName("");
        enterPassword("");
    }

    @When("the user enters a username with special characters")
    public void theUserEntersAUsernameWithSpecialCharacters() {
        enterUserName("user@!#$%");
        enterPassword("ValidPassword123");
    }

    @When("the user enters a valid username {string} and leaves the password field empty")
    public void theUserEntersAValidUsernameAndLeavesThePasswordFieldEmpty(String username) {
        enterUserName(username);
        enterPassword("");
    }

    @When("the user enters a valid username {string} and incorrect password multiple times")
    public void theUserEntersAValidUsernameAndIncorrectPasswordMultipleTimes(String username) {
        for (int i = 0; i < 5; i++) {
            enterUserName(username);
            enterPassword("IncorrectPassword123");
            clickLoginButton();
        }
    }

    @When("the user fails to login multiple times")
    public void theUserFailsToLoginMultipleTimes() {
        for (int i = 0; i < 5; i++) {
            enterUserName("user@example.com");
            enterPassword("IncorrectPassword123");
            clickLoginButton();
        }
    }

    @When("the user enters a valid username {string} and a password exceeding maximum length")
    public void theUserEntersAValidUsernameAndAPasswordExceedingMaximumLength(String username) {
        enterUserName(username);
        enterPassword("PasswordExceedingMaxLength1234567890");
    }

    @When("the user enters incorrect credentials from a different IP address")
    public void theUserEntersIncorrectCredentialsFromADifferentIPAddress() {
        enterUserName("user@example.com");
        enterPassword("IncorrectPassword123");
    }

    @When("the user enters credentials for an expired account")
    public void theUserEntersCredentialsForAnExpiredAccount() {
        enterUserName("expired@example.com");
        enterPassword("ValidPassword123");
    }

    @When("the user enters credentials for a deactivated account")
    public void theUserEntersCredentialsForADeactivatedAccount() {
        enterUserName("deactivated@example.com");
        enterPassword("ValidPassword123");
    }

    @When("the user enters incorrect credentials during system maintenance")
    public void theUserEntersIncorrectCredentialsDuringSystemMaintenance() {
        enterUserName("user@example.com");
        enterPassword("IncorrectPassword123");
    }

    @Then("the system displays an error message indicating incorrect password")
    public void theSystemDisplaysAnErrorMessageIndicatingIncorrectPassword() {
        verifyErrorMessage("Incorrect password.");
    }

    @Then("the system displays an error message indicating invalid credentials")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidCredentials() {
        verifyErrorMessage("Invalid credentials.");
    }

    @Then("the system prompts to enter valid credentials")
    public void theSystemPromptsToEnterValidCredentials() {
        verifyErrorMessage("Please enter valid credentials.");
    }

    @Then("the system displays an error message indicating invalid username format")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidUsernameFormat() {
        verifyErrorMessage("Invalid username format.");
    }

    @Then("the system prompts to enter a password")
    public void theSystemPromptsToEnterAPassword() {
        verifyErrorMessage("Please enter a password.");
    }

    @Then("the system locks the account after several failed attempts")
    public void theSystemLocksTheAccountAfterSeveralFailedAttempts() {
        verifyErrorMessage("Account locked after multiple failed attempts.");
    }

    @Then("the password recovery option is available")
    public void thePasswordRecoveryOptionIsAvailable() {
        verifyPasswordRecoveryOption();
    }

    @Then("the system displays an error message indicating password length exceeded")
    public void theSystemDisplaysAnErrorMessageIndicatingPasswordLengthExceeded() {
        verifyErrorMessage("Password length exceeded.");
    }

    @Then("CAPTCHA is required after several failed login attempts")
    public void captchaIsRequiredAfterSeveralFailedLoginAttempts() {
        verifyCaptchaRequirement();
    }

    @Then("the system displays an error message and logs the attempt")
    public void theSystemDisplaysAnErrorMessageAndLogsTheAttempt() {
        verifyErrorMessage("Invalid login attempt logged.");
    }

    @Then("the system displays an error message indicating account expiration")
    public void theSystemDisplaysAnErrorMessageIndicatingAccountExpiration() {
        verifyErrorMessage("Account expired.");
    }

    @Then("the system displays an error message indicating account deactivation")
    public void theSystemDisplaysAnErrorMessageIndicatingAccountDeactivation() {
        verifyErrorMessage("Account deactivated.");
    }

    @Then("the system displays a maintenance notification and login is not possible")
    public void theSystemDisplaysAMaintenanceNotificationAndLoginIsNotPossible() {
        verifyErrorMessage("System maintenance in progress. Login not possible.");
    }
}