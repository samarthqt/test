import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderConfirmationPage from "../pages/orderConfirmationPage";

Given("a user has completed a purchase", () => {
 OrderConfirmationPage.completePurchase();
});

When("the purchase transaction is successful", () => {
 OrderConfirmationPage.verifyTransactionSuccess();
});

Then("an order confirmation email should be sent to the user's registered email address", () => {
 OrderConfirmationPage.verifyEmailSent();
});

Then("the email should contain the order details including order ID, items purchased, total amount, and delivery address", () => {
 OrderConfirmationPage.verifyEmailContent();
});

Then("the email should be sent from the correct sender email address for order confirmations", () => {
 OrderConfirmationPage.verifySenderEmailAddress();
});

Given("a user attempts to complete a purchase", () => {
 OrderConfirmationPage.attemptPurchase();
});

When("the purchase transaction fails", () => {
 OrderConfirmationPage.verifyTransactionFailure();
});

Then("no order confirmation email should be sent to the user", () => {
 OrderConfirmationPage.verifyNoEmailSent();
});

Given("a user has completed a purchase", () => {
 OrderConfirmationPage.completePurchase();
});

Given("the initial attempt to send an order confirmation email fails", () => {
 OrderConfirmationPage.failInitialEmailAttempt();
});

When("the system retries sending the email", () => {
 OrderConfirmationPage.retryEmailSending();
});

Then("the order confirmation email should be successfully sent to the user's registered email address", () => {
 OrderConfirmationPage.verifyEmailSent();
});

Given("a user has completed a purchase", () => {
 OrderConfirmationPage.completePurchase();
});

When("an order confirmation email is sent", () => {
 OrderConfirmationPage.sendEmail();
});

Then("the system should log the status of the email sending process", () => {
 OrderConfirmationPage.logEmailStatus();
});

Then("the log should include whether the email was successfully sent or if there were any errors", () => {
 OrderConfirmationPage.verifyLogContent();
});