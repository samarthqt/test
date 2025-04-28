package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordResetSteps extends PasswordResetPage {

    private TestHarness testHarness = new TestHarness();

    @Given("multiple accounts exist with the same email")
    public void multipleAccountsExistWithSameEmail() {
        // Setup multiple accounts with the same email in the test data
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("the user clicks on the 'Forgot Password?' link")
    public void theUserClicksOnForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the password reset page is displayed")
    public void thePasswordResetPageIsDisplayed() {
        verifyPasswordResetPageDisplayed();
    }

    @When("the user enters the shared email {string} in the email field")
    public void theUserEntersSharedEmailInEmailField(String email) {
        enterEmail(email);
    }

    @When("clicks on the 'Submit' button")
    public void clicksOnSubmitButton() {
        clickSubmitButton();
    }

    @Then("the system processes the request")
    public void theSystemProcessesTheRequest() {
        verifyRequestProcessed();
    }

    @Then("the system prompts to select an account for password reset")
    public void theSystemPromptsToSelectAnAccountForPasswordReset() {
        verifyAccountSelectionPrompt();
    }

    @Then("the system displays: \"Select the account you wish to reset the password for.\"")
    public void theSystemDisplaysSelectAccountMessage() {
        verifySelectAccountMessage();
    }

    @When("the user selects Account 1 for password reset")
    public void theUserSelectsAccount1ForPasswordReset() {
        selectAccount1();
    }

    @Then("the system processes the request for Account 1")
    public void theSystemProcessesRequestForAccount1() {
        verifyRequestProcessedForAccount1();
    }

    @Then("the user checks the email inbox for the reset link for Account 1")
    public void theUserChecksEmailInboxForResetLinkForAccount1() {
        checkEmailForResetLinkAccount1();
    }

    @Then("the password reset email for Account 1 is received")
    public void thePasswordResetEmailForAccount1IsReceived() {
        verifyPasswordResetEmailReceivedAccount1();
    }

    @When("the user completes the password reset process for Account 1")
    public void theUserCompletesPasswordResetProcessForAccount1() {
        completePasswordResetProcessAccount1();
    }

    @Then("the password for Account 1 is successfully reset")
    public void thePasswordForAccount1IsSuccessfullyReset() {
        verifyPasswordResetSuccessAccount1();
    }

    @When("the user repeats the reset process for Account 2")
    public void theUserRepeatsResetProcessForAccount2() {
        repeatPasswordResetProcessAccount2();
    }

    @Then("the system processes the request for Account 2")
    public void theSystemProcessesRequestForAccount2() {
        verifyRequestProcessedForAccount2();
    }

    @Then("the user checks the email inbox for the reset link for Account 2")
    public void theUserChecksEmailInboxForResetLinkForAccount2() {
        checkEmailForResetLinkAccount2();
    }

    @Then("the password reset email for Account 2 is received")
    public void thePasswordResetEmailForAccount2IsReceived() {
        verifyPasswordResetEmailReceivedAccount2();
    }

    @When("the user completes the password reset process for Account 2")
    public void theUserCompletesPasswordResetProcessForAccount2() {
        completePasswordResetProcessAccount2();
    }

    @Then("the password for Account 2 is successfully reset")
    public void thePasswordForAccount2IsSuccessfullyReset() {
        verifyPasswordResetSuccessAccount2();
    }

    @When("the user attempts to log in with new passwords for both accounts")
    public void theUserAttemptsToLogInWithNewPasswordsForBothAccounts() {
        attemptLoginWithNewPasswords();
    }

    @Then("the logins are successful with new passwords")
    public void theLoginsAreSuccessfulWithNewPasswords() {
        verifySuccessfulLogins();
    }

    @When("the user verifies if the system logs show entries for both password reset requests")
    public void theUserVerifiesSystemLogsForBothPasswordResetRequests() {
        verifySystemLogsForPasswordResets();
    }

    @Then("logs indicate separate entries for each account's reset")
    public void logsIndicateSeparateEntriesForEachAccountReset() {
        verifySeparateLogEntries();
    }

    @When("the user attempts to reset the password again for the same email")
    public void theUserAttemptsToResetPasswordAgainForSameEmail() {
        attemptPasswordResetAgain();
    }

    @Then("the system prompts to select an account again")
    public void theSystemPromptsToSelectAnAccountAgain() {
        verifyAccountSelectionPromptAgain();
    }

    @When("the user verifies if any security measures are triggered by multiple resets for the same email")
    public void theUserVerifiesSecurityMeasuresForMultipleResets() {
        verifySecurityMeasuresForMultipleResets();
    }

    @Then("no unnecessary security measures are triggered")
    public void noUnnecessarySecurityMeasuresAreTriggered() {
        verifyNoUnnecessarySecurityMeasures();
    }
}