package com.cucumber.steps;

import com.page_objects.AccountCreationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreationSteps extends AccountCreationPage {

    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @When("I enter the email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @When("I enter a non-registered email and a password")
    public void iEnterNonRegisteredEmailAndPassword() {
        String email = getNonRegisteredEmail();
        String password = getValidPassword();
        enterEmail(email);
        enterPassword(password);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        if (buttonName.equals("Create Account")) {
            clickCreateAccountButton();
        }
    }

    @When("I repeatedly attempt to create an account with the email {string}")
    public void iRepeatedlyAttemptToCreateAccount(String email) {
        for (int i = 0; i < 3; i++) {
            enterEmail(email);
            enterPassword(getValidPassword());
            clickCreateAccountButton();
        }
    }

    @Then("I should see an error message indicating the email is already registered")
    public void iShouldSeeErrorMessageForRegisteredEmail() {
        verifyErrorMessageForRegisteredEmail();
    }

    @Then("the error message should clearly state the reason for account creation failure")
    public void errorMessageShouldStateReasonForFailure() {
        verifyErrorMessageContent();
    }

    @Then("the account should be created successfully")
    public void accountShouldBeCreatedSuccessfully() {
        verifyAccountCreationSuccess();
    }

    @Then("the system should consistently display an error message for each attempt")
    public void systemShouldConsistentlyDisplayErrorMessage() {
        verifyConsistentErrorMessageDisplay();
    }

    @Then("the error message should be accessible and clearly visible")
    public void errorMessageShouldBeAccessibleAndVisible() {
        verifyErrorMessageAccessibility();
    }

    @Then("the error message should be displayed correctly on mobile devices")
    public void errorMessageShouldBeDisplayedCorrectlyOnMobile() {
        verifyErrorMessageOnMobileDevices();
    }

    @Then("I should see an error message for both registered email and invalid password")
    public void iShouldSeeErrorMessageForEmailAndPassword() {
        verifyErrorMessageForEmailAndPassword();
    }

    @Then("the system logs should contain records of failed account creation attempts")
    public void systemLogsShouldContainFailedAttempts() {
        verifySystemLogsForFailedAttempts();
    }

    @Then("the system should handle high traffic efficiently and display an error message")
    public void systemShouldHandleHighTraffic() {
        verifyHighTrafficHandling();
    }

    @Then("the system should prompt for a stronger password and display an email registration error")
    public void systemShouldPromptForStrongerPassword() {
        verifyPasswordStrengthPrompt();
    }

    @Then("the system should display an error message indicating a network issue")
    public void systemShouldDisplayNetworkIssueMessage() {
        verifyNetworkIssueMessage();
    }

    @Then("the system should allow account creation via social media despite the registered email")
    public void systemShouldAllowSocialMediaAccountCreation() {
        verifySocialMediaAccountCreation();
    }

    @Then("the system should prompt me to re-login and display an error message for the registered email")
    public void systemShouldPromptReLogin() {
        verifySessionExpiryHandling();
    }
}