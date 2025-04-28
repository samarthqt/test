package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordResetSteps extends PasswordResetPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an account with a registered email")
    public void theUserHasAnAccountWithARegisteredEmail() {
        // Assume user account setup is done
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user clicks on \"Forgot Password?\" link")
    public void theUserClicksOnForgotPasswordLink() {
        clickForgotPasswordLink();
    }

    @Then("the password reset page is displayed")
    public void thePasswordResetPageIsDisplayed() {
        verifyPasswordResetPageDisplayed();
    }

    @When("the user enters the incorrect email {string} in the email field")
    public void theUserEntersTheIncorrectEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user clicks on the \"Submit\" button")
    public void theUserClicksOnTheSubmitButton() {
        clickSubmitButton();
    }

    @Then("the system processes the request")
    public void theSystemProcessesTheRequest() {
        verifyRequestProcessed();
    }

    @Then("no email is received in the inbox or spam/junk folder for {string}")
    public void noEmailIsReceivedInTheInboxOrSpamJunkFolderFor(String email) {
        verifyNoEmailReceived(email);
    }

    @Then("the system displays an error message: \"Email not recognized.\"")
    public void theSystemDisplaysAnErrorMessageEmailNotRecognized() {
        verifyErrorMessageDisplayed("Email not recognized.");
    }

    @When("the user attempts to login with the incorrect email {string}")
    public void theUserAttemptsToLoginWithTheIncorrectEmail(String email) {
        attemptLoginWithIncorrectEmail(email);
    }

    @Then("the login fails with a message indicating incorrect credentials")
    public void theLoginFailsWithAMessageIndicatingIncorrectCredentials() {
        verifyLoginFailureMessage();
    }

    @Given("the user is on the password reset page")
    public void theUserIsOnThePasswordResetPage() {
        navigateToPasswordResetPage();
    }

    @When("the user tries resetting the password with the correct email")
    public void theUserTriesResettingThePasswordWithTheCorrectEmail() {
        resetPasswordWithCorrectEmail();
    }

    @Then("the password reset email is sent to the correct email")
    public void thePasswordResetEmailIsSentToTheCorrectEmail() {
        verifyPasswordResetEmailSent();
    }

    @Given("the user has attempted a password reset with an incorrect email")
    public void theUserHasAttemptedAPasswordResetWithAnIncorrectEmail() {
        // Assume previous incorrect email attempt
    }

    @When("the system logs are checked")
    public void theSystemLogsAreChecked() {
        checkSystemLogs();
    }

    @Then("logs indicate an incorrect email attempt without errors")
    public void logsIndicateAnIncorrectEmailAttemptWithoutErrors() {
        verifyLogsForIncorrectEmailAttempt();
    }

    @Given("the user attempts multiple incorrect email entries")
    public void theUserAttemptsMultipleIncorrectEmailEntries() {
        attemptMultipleIncorrectEmails();
    }

    @When("the system checks for security measures")
    public void theSystemChecksForSecurityMeasures() {
        checkSecurityMeasures();
    }

    @Then("no security measures are triggered for a single incorrect attempt")
    public void noSecurityMeasuresAreTriggeredForASingleIncorrectAttempt() {
        verifyNoSecurityMeasuresTriggered();
    }

    @When("the user enters a valid email format that is not registered")
    public void theUserEntersAValidEmailFormatThatIsNotRegistered() {
        enterUnregisteredEmail();
    }

    @Then("the system displays \"Email not recognized\" message")
    public void theSystemDisplaysEmailNotRecognizedMessage() {
        verifyErrorMessageDisplayed("Email not recognized.");
    }

    @When("the user enters an email with special characters and submits")
    public void theUserEntersAnEmailWithSpecialCharactersAndSubmits() {
        enterEmailWithSpecialCharacters();
    }

    @Then("the system processes but does not send a reset link")
    public void theSystemProcessesButDoesNotSendAResetLink() {
        verifyNoResetLinkSent();
    }

    @When("the user enters an email with a valid domain but incorrect local part")
    public void theUserEntersAnEmailWithAValidDomainButIncorrectLocalPart() {
        enterEmailWithValidDomainIncorrectLocalPart();
    }

    @When("the user attempts a password reset with a non-existent email domain")
    public void theUserAttemptsAPasswordResetWithANonExistentEmailDomain() {
        attemptPasswordResetWithNonExistentDomain();
    }
}