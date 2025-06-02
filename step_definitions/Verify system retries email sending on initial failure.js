import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EmailSystemPage from "../pages/emailSystemPage";

Given("the system is configured to send emails", () => {
 EmailSystemPage.configureSystemForEmails();
});

When("an action is triggered that sends an email to {string}", (email) => {
 EmailSystemPage.triggerEmailSending(email);
});

Then("the email sending process is initiated", () => {
 EmailSystemPage.verifyEmailSendingInitiated();
});

Given("the email server with retry capability", () => {
 EmailSystemPage.setupEmailServerWithRetry();
});

When("a failure is simulated in the email server", () => {
 EmailSystemPage.simulateEmailServerFailure();
});

Then("the email sending fails initially with subject {string}", (subject) => {
 EmailSystemPage.verifyInitialEmailFailure(subject);
});

And("the system logs the email sending failure with content {string}", (content) => {
 EmailSystemPage.verifyEmailFailureLogged(content);
});

Given("the email sending failed initially", () => {
 EmailSystemPage.verifyEmailFailedInitially();
});

When("the system retries sending the email after a specified interval", () => {
 EmailSystemPage.retryEmailSending();
});

Then("the email is successfully sent after retries", () => {
 EmailSystemPage.verifyEmailSentAfterRetries();
});

Given("the email is successfully sent after retries", () => {
 EmailSystemPage.verifyEmailSentAfterRetries();
});

When("the user checks their notifications", () => {
 EmailSystemPage.checkUserNotifications();
});

Then("the user receives a notification about the email sending status", () => {
 EmailSystemPage.verifyUserNotificationReceived();
});

Given("an attempt to send an email to an invalid address", () => {
 EmailSystemPage.attemptToSendToInvalidAddress();
});

When("the system retries sending the email", () => {
 EmailSystemPage.retryEmailSending();
});

Then("it eventually fails with an error message", () => {
 EmailSystemPage.verifyEmailFailureWithError();
});

Given("the system retries sending the email", () => {
 EmailSystemPage.retryEmailSending();
});

When("the retry attempts exceed the defined number", () => {
 EmailSystemPage.exceedRetryAttempts();
});

Then("the system stops retrying", () => {
 EmailSystemPage.verifySystemStopsRetrying();
});

Given("the system has retried sending the email", () => {
 EmailSystemPage.verifyEmailRetried();
});

When("checking the logs", () => {
 EmailSystemPage.checkLogs();
});

Then("logs contain detailed information on retry attempts and outcomes", () => {
 EmailSystemPage.verifyLogsContainRetryInfo();
});

Given("multiple email failures occur", () => {
 EmailSystemPage.simulateMultipleEmailFailures();
});

When("the system processes these failures", () => {
 EmailSystemPage.processEmailFailures();
});

Then("the system manages multiple email failures without performance degradation", () => {
 EmailSystemPage.verifyNoPerformanceDegradation();
});

Given("the email sending failed initially", () => {
 EmailSystemPage.verifyEmailFailedInitially();
});

When("the system retries sending the email for the first time", () => {
 EmailSystemPage.retryEmailSendingFirstTime();
});

Then("the email is sent successfully", () => {
 EmailSystemPage.verifyEmailSentSuccessfully();
});

Given("an email is successfully sent", () => {
 EmailSystemPage.verifyEmailSentSuccessfully();
});

When("the system sends a confirmation", () => {
 EmailSystemPage.sendConfirmation();
});

Then("a confirmation email is sent to the user", () => {
 EmailSystemPage.verifyConfirmationEmailSent();
});

Given("the system retries sending the email", () => {
 EmailSystemPage.retryEmailSending();
});

When("the email is successfully sent", () => {
 EmailSystemPage.verifyEmailSentSuccessfully();
});

Then("the email content remains consistent across retries", () => {
 EmailSystemPage.verifyEmailContentConsistency();
});

Given("the system administrator accesses the retry settings", () => {
 EmailSystemPage.accessRetrySettings();
});

When("the administrator configures the retry mechanism", () => {
 EmailSystemPage.configureRetryMechanism();
});

Then("the retry mechanism settings are configurable by the administrator", () => {
 EmailSystemPage.verifyRetrySettingsConfigurable();
});