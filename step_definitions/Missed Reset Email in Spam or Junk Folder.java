package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordResetSteps extends PasswordResetPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has requested a password reset")
    public void theUserHasRequestedAPasswordReset() {
        requestPasswordReset();
    }

    @Given("user's email provider has a spam or junk folder")
    public void usersEmailProviderHasSpamOrJunkFolder() {
        verifySpamFolderExists();
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        verifyLoginPageDisplayed();
    }

    @When("the user clicks on 'Forgot Password?' link")
    public void theUserClicksOnForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the password reset page is displayed")
    public void thePasswordResetPageIsDisplayed() {
        verifyPasswordResetPageDisplayed();
    }

    @When("the user enters the registered email {string} in the email field")
    public void theUserEntersRegisteredEmailInEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email is entered in the field")
    public void theEmailIsEnteredInTheField() {
        verifyEmailEntered();
    }

    @When("the user clicks on the 'Submit' button")
    public void theUserClicksOnSubmitButton() {
        clickSubmitButton();
    }

    @Then("the system processes the request")
    public void theSystemProcessesTheRequest() {
        verifyRequestProcessed();
    }

    @When("the user waits for the password reset email to arrive in the inbox")
    public void theUserWaitsForPasswordResetEmail() {
        waitForEmailInInbox();
    }

    @Then("the email is not found in the inbox")
    public void theEmailIsNotFoundInTheInbox() {
        verifyEmailNotInInbox();
    }

    @When("the user checks the spam/junk folder for the email")
    public void theUserChecksSpamJunkFolderForEmail() {
        checkSpamJunkFolder();
    }

    @Then("the email is found in the spam/junk folder")
    public void theEmailIsFoundInSpamJunkFolder() {
        verifyEmailInSpamJunkFolder();
    }

    @When("the user verifies the system's message advises checking spam/junk folders")
    public void theUserVerifiesSystemMessage() {
        verifySystemMessage();
    }

    @Then("the system displays: \"Check your spam/junk folder if you do not see the email in your inbox.\"")
    public void theSystemDisplaysMessage() {
        verifyDisplayedMessage();
    }

    @When("the user marks the reset email as 'Not Spam' to move it to the inbox")
    public void theUserMarksEmailAsNotSpam() {
        markEmailAsNotSpam();
    }

    @Then("the email is moved to the inbox")
    public void theEmailIsMovedToInbox() {
        verifyEmailMovedToInbox();
    }

    @When("the user opens the password reset email and follows the link")
    public void theUserOpensEmailAndFollowsLink() {
        openEmailAndFollowLink();
    }

    @Then("the password reset page is accessed via the link")
    public void thePasswordResetPageAccessedViaLink() {
        verifyPasswordResetPageAccessed();
    }

    @When("the user completes the password reset process")
    public void theUserCompletesPasswordResetProcess() {
        completePasswordResetProcess();
    }

    @Then("the password is successfully reset")
    public void thePasswordIsSuccessfullyReset() {
        verifyPasswordResetSuccess();
    }

    @When("the user attempts to log in with the new password")
    public void theUserAttemptsToLoginWithNewPassword() {
        attemptLoginWithNewPassword();
    }

    @Then("the login is successful with the new password")
    public void theLoginIsSuccessfulWithNewPassword() {
        verifyLoginSuccess();
    }

    @When("the user requests another password reset and verifies if the email goes to spam again")
    public void theUserRequestsAnotherPasswordReset() {
        requestAnotherPasswordReset();
    }

    @Then("the email arrives in the inbox, not spam")
    public void theEmailArrivesInInboxNotSpam() {
        verifyEmailInInboxNotSpam();
    }

    @When("the user checks if the email provider's spam filter settings can be adjusted")
    public void theUserChecksSpamFilterSettings() {
        checkSpamFilterSettings();
    }

    @Then("settings allow adjustment to prevent future spam classification")
    public void settingsAllowAdjustment() {
        verifySettingsAdjustment();
    }

    @When("the user sends a test email to the same address to verify spam settings")
    public void theUserSendsTestEmail() {
        sendTestEmail();
    }

    @Then("the test email arrives in the inbox")
    public void theTestEmailArrivesInInbox() {
        verifyTestEmailInInbox();
    }

    @When("the user verifies if the email content is marked as safe by the email provider")
    public void theUserVerifiesEmailContentMarkedSafe() {
        verifyEmailContentMarkedSafe();
    }

    @Then("the email content is marked as safe, ensuring future delivery to inbox")
    public void theEmailContentMarkedSafe() {
        verifyEmailContentSafety();
    }
}