import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PasswordRecoveryPage from "../pages/passwordRecoveryPage";

Given("the password recovery page is open", () => {
 PasswordRecoveryPage.visit();
});

When("I enter the email format {string}", (email) => {
 PasswordRecoveryPage.enterEmail(email);
});

When("I click on 'Recover Password'", () => {
 PasswordRecoveryPage.clickRecoverPassword();
});

Then("the system sends a recovery email successfully", () => {
 PasswordRecoveryPage.verifyRecoveryEmailSent();
});

Given("the recovery emails are sent for all valid formats", () => {
 PasswordRecoveryPage.verifyAllRecoveryEmailsSent();
});

When("I check the email inbox", () => {
 PasswordRecoveryPage.checkEmailInbox();
});

Then("recovery emails are received for all formats", () => {
 PasswordRecoveryPage.verifyEmailsReceived();
});

When("I enter an invalid email format", () => {
 PasswordRecoveryPage.enterInvalidEmail();
});

Then("the system displays an error message for invalid format", () => {
 PasswordRecoveryPage.verifyErrorMessageForInvalidFormat();
});

When("I enter various email formats", () => {
 PasswordRecoveryPage.enterVariousEmailFormats();
});

Then("the system validates email formats correctly", () => {
 PasswordRecoveryPage.verifyEmailFormatValidation();
});

Given("the password recovery process is initiated", () => {
 PasswordRecoveryPage.initiateRecoveryProcess();
});

When("I check the system logs", () => {
 PasswordRecoveryPage.checkSystemLogs();
});

Then("logs reflect all recovery attempts with respective outcomes", () => {
 PasswordRecoveryPage.verifyLogsForRecoveryAttempts();
});

Given("the recovery emails are received", () => {
 PasswordRecoveryPage.verifyEmailsReceived();
});

When("I click on the recovery link in each email", () => {
 PasswordRecoveryPage.clickRecoveryLinks();
});

Then("recovery links work correctly for all formats", () => {
 PasswordRecoveryPage.verifyRecoveryLinksFunctionality();
});

When("I enter duplicate email format entries", () => {
 PasswordRecoveryPage.enterDuplicateEmailEntries();
});

Then("the system handles duplicate entries gracefully", () => {
 PasswordRecoveryPage.verifyDuplicateEntriesHandling();
});

Given("the password recovery process is completed", () => {
 PasswordRecoveryPage.completeRecoveryProcess();
});

When("I check system notifications", () => {
 PasswordRecoveryPage.checkSystemNotifications();
});

Then("system sends notifications for successful recovery attempts", () => {
 PasswordRecoveryPage.verifyNotificationsForRecoveryAttempts();
});

When("I review the email content", () => {
 PasswordRecoveryPage.reviewEmailContent();
});

Then("email content is consistent and accurate for all formats", () => {
 PasswordRecoveryPage.verifyEmailContentConsistency();
});