import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentNotificationPage from "../pages/paymentNotificationPage";

Given("the system is configured to send payment notifications", () => {
 PaymentNotificationPage.ensureNotificationConfig();
});

When("a payment transaction is initiated with User ID {string}", (userId) => {
 PaymentNotificationPage.initiatePaymentTransaction(userId);
});

Then("the payment transaction should be initiated successfully", () => {
 PaymentNotificationPage.verifyTransactionInitiated();
});

Given("a payment transaction is initiated", () => {
 PaymentNotificationPage.initiatePaymentTransactionWithoutUserId();
});

When("payment confirmation fails for Payment ID {string}", (paymentId) => {
 PaymentNotificationPage.simulatePaymentConfirmationFailure(paymentId);
});

Then("the system should detect the payment confirmation issue", () => {
 PaymentNotificationPage.verifyPaymentIssueDetected();
});

Given("the system detects a payment confirmation issue", () => {
 PaymentNotificationPage.detectPaymentIssue();
});

When("the notification method is set to Email", () => {
 PaymentNotificationPage.setNotificationMethodToEmail();
});

Then("the user should receive a notification about the payment issue", () => {
 PaymentNotificationPage.verifyUserReceivesNotification();
});

Given("the user receives a notification about the payment issue", () => {
 PaymentNotificationPage.userReceivesNotification();
});

When("the notification is reviewed", () => {
 PaymentNotificationPage.reviewNotification();
});

Then("the notification content should be clear and accurate", () => {
 PaymentNotificationPage.verifyNotificationContent();
});

Then("the notification should include steps to resolve the issue", () => {
 PaymentNotificationPage.verifyNotificationIncludesResolutionSteps();
});

Given("steps to resolve the payment issue are provided", () => {
 PaymentNotificationPage.provideResolutionSteps();
});

When("the user attempts to resolve the payment issue", () => {
 PaymentNotificationPage.userAttemptsResolution();
});

Then("the system should respond appropriately to issue resolution attempts", () => {
 PaymentNotificationPage.verifySystemResponseToResolution();
});

Given("a payment confirmation issue occurs", () => {
 PaymentNotificationPage.paymentIssueOccurs();
});

When("the issue is logged", () => {
 PaymentNotificationPage.logIssue();
});

Then("the payment confirmation issue should be logged in the system", () => {
 PaymentNotificationPage.verifyIssueLogged();
});

When("the user checks their account", () => {
 PaymentNotificationPage.userChecksAccount();
});

Then("the user should be able to view the notification in their account", () => {
 PaymentNotificationPage.verifyNotificationInAccount();
});

Given("a payment confirmation issue was resolved", () => {
 PaymentNotificationPage.resolvePaymentIssue();
});

When("a payment confirmation is attempted again", () => {
 PaymentNotificationPage.attemptPaymentConfirmationAgain();
});

Then("the payment confirmation should be successful after the issue", () => {
 PaymentNotificationPage.verifySuccessfulConfirmationAfterIssue();
});

Given("the payment confirmation issue is resolved", () => {
 PaymentNotificationPage.confirmationIssueResolved();
});

When("the payment confirmation is successful", () => {
 PaymentNotificationPage.confirmationIsSuccessful();
});

Then("the user should receive a confirmation notification", () => {
 PaymentNotificationPage.verifyUserReceivesConfirmationNotification();
});

Given("multiple payment issues occur concurrently", () => {
 PaymentNotificationPage.multipleIssuesOccur();
});

When("the system processes these issues", () => {
 PaymentNotificationPage.processConcurrentIssues();
});

Then("the system should handle multiple payment issues without performance degradation", () => {
 PaymentNotificationPage.verifySystemHandlesMultipleIssues();
});

Given("a payment confirmation fails", () => {
 PaymentNotificationPage.paymentConfirmationFails();
});

When("the system retries payment confirmation", () => {
 PaymentNotificationPage.retryPaymentConfirmation();
});

Then("the system should retry payment confirmation as per configured settings", () => {
 PaymentNotificationPage.verifyRetryMechanism();
});

Given("the user wants to configure their notification method", () => {
 PaymentNotificationPage.userConfiguresNotificationMethod();
});

When("the user updates their notification preferences", () => {
 PaymentNotificationPage.updateNotificationPreferences();
});

Then("the user should be able to configure their preferred notification method", () => {
 PaymentNotificationPage.verifyNotificationMethodConfigurable();
});

Given("the system sends payment notifications", () => {
 PaymentNotificationPage.systemSendsNotifications();
});

When("the notifications are reviewed for compliance", () => {
 PaymentNotificationPage.reviewNotificationsForCompliance();
});

Then("the system should comply with relevant notification regulations", () => {
 PaymentNotificationPage.verifyComplianceWithRegulations();
});