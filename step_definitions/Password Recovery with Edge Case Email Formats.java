package com.cucumber.steps;

import com.page_objects.PasswordRecoveryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordRecoverySteps extends PasswordRecoveryPage {

    @Given("the password recovery page is open")
    public void thePasswordRecoveryPageIsOpen() {
        navigateToPasswordRecoveryPage();
    }

    @When("I enter the email format {string}")
    public void iEnterTheEmailFormat(String email) {
        enterEmail(email);
    }

    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        if (buttonName.equals("Recover Password")) {
            clickRecoverPasswordButton();
        }
    }

    @Then("the system sends a recovery email successfully")
    public void theSystemSendsARecoveryEmailSuccessfully() {
        verifyRecoveryEmailSent();
    }

    @Given("the recovery emails are sent for all valid formats")
    public void theRecoveryEmailsAreSentForAllValidFormats() {
        verifyRecoveryEmailsSentForAllFormats();
    }

    @When("I check the email inbox")
    public void iCheckTheEmailInbox() {
        checkEmailInbox();
    }

    @Then("recovery emails are received for all formats")
    public void recoveryEmailsAreReceivedForAllFormats() {
        verifyEmailsReceivedForAllFormats();
    }

    @When("I enter an invalid email format")
    public void iEnterAnInvalidEmailFormat() {
        enterInvalidEmailFormat();
    }

    @Then("the system displays an error message for invalid format")
    public void theSystemDisplaysAnErrorMessageForInvalidFormat() {
        verifyErrorMessageForInvalidFormat();
    }

    @When("I enter various email formats")
    public void iEnterVariousEmailFormats() {
        enterVariousEmailFormats();
    }

    @Then("the system validates email formats correctly")
    public void theSystemValidatesEmailFormatsCorrectly() {
        verifyEmailFormatValidation();
    }

    @Given("the password recovery process is initiated")
    public void thePasswordRecoveryProcessIsInitiated() {
        initiatePasswordRecoveryProcess();
    }

    @When("I check the system logs")
    public void iCheckTheSystemLogs() {
        checkSystemLogs();
    }

    @Then("logs reflect all recovery attempts with respective outcomes")
    public void logsReflectAllRecoveryAttemptsWithRespectiveOutcomes() {
        verifyLogsForRecoveryAttempts();
    }

    @Given("the recovery emails are received")
    public void theRecoveryEmailsAreReceived() {
        verifyRecoveryEmailsReceived();
    }

    @When("I click on the recovery link in each email")
    public void iClickOnTheRecoveryLinkInEachEmail() {
        clickRecoveryLinksInEmails();
    }

    @Then("recovery links work correctly for all formats")
    public void recoveryLinksWorkCorrectlyForAllFormats() {
        verifyRecoveryLinksFunctionality();
    }

    @When("I enter duplicate email format entries")
    public void iEnterDuplicateEmailFormatEntries() {
        enterDuplicateEmailFormatEntries();
    }

    @Then("the system handles duplicate entries gracefully")
    public void theSystemHandlesDuplicateEntriesGracefully() {
        verifyDuplicateEntriesHandling();
    }

    @Given("the password recovery process is completed")
    public void thePasswordRecoveryProcessIsCompleted() {
        completePasswordRecoveryProcess();
    }

    @When("I check system notifications")
    public void iCheckSystemNotifications() {
        checkSystemNotifications();
    }

    @Then("system sends notifications for successful recovery attempts")
    public void systemSendsNotificationsForSuccessfulRecoveryAttempts() {
        verifyNotificationsForRecoveryAttempts();
    }

    @When("I review the email content")
    public void iReviewTheEmailContent() {
        reviewEmailContent();
    }

    @Then("email content is consistent and accurate for all formats")
    public void emailContentIsConsistentAndAccurateForAllFormats() {
        verifyEmailContentConsistency();
    }
}