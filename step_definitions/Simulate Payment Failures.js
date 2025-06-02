import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("User is logged into the system with valid credentials", () => {
 PaymentPage.login();
});

When("User navigates to the checkout page", () => {
 PaymentPage.navigateToCheckout();
});

When("User selects a payment method and enters invalid credit card details", () => {
 PaymentPage.selectPaymentMethod();
 PaymentPage.enterInvalidCreditCardDetails();
});

Then("Payment fails due to invalid credit card details", () => {
 PaymentPage.verifyPaymentFailure("invalid credit card");
});

Then("User receives notification about payment failure", () => {
 PaymentPage.verifyFailureNotification("payment failure");
});

Then("Payment failure errors are logged correctly", () => {
 PaymentPage.verifyErrorLogs("payment failure");
});

When("User selects a payment method and enters valid payment details", () => {
 PaymentPage.selectPaymentMethod();
 PaymentPage.enterValidPaymentDetails();
});

When("Network failure occurs during payment processing", () => {
 PaymentPage.simulateNetworkFailure();
});

Then("Payment fails due to network issues", () => {
 PaymentPage.verifyPaymentFailure("network issues");
});

Then("User receives notification about network-related payment failure", () => {
 PaymentPage.verifyFailureNotification("network-related payment failure");
});

When("User selects a payment method and enters expired PayPal account details", () => {
 PaymentPage.selectPaymentMethod();
 PaymentPage.enterExpiredPayPalDetails();
});

Then("Payment fails due to expired PayPal account", () => {
 PaymentPage.verifyPaymentFailure("expired PayPal account");
});

Then("User receives notification about expired account failure", () => {
 PaymentPage.verifyFailureNotification("expired account failure");
});

When("Payment fails due to any reason", () => {
 PaymentPage.simulatePaymentFailure();
});

Then("System recovers and allows retry of payment without data loss", () => {
 PaymentPage.verifySystemRecovery();
});

Then("User is able to update payment details and retry payment", () => {
 PaymentPage.updatePaymentDetailsAndRetry();
});

When("Payment failure occurs", () => {
 PaymentPage.simulatePaymentFailure();
});

Then("System performs efficiently during payment failure handling", () => {
 PaymentPage.verifySystemPerformance();
});

Then("System handles payment failures gracefully with user notifications", () => {
 PaymentPage.verifyGracefulFailureHandling();
});

Then("No critical errors are logged during payment failure handling", () => {
 PaymentPage.verifyNoCriticalErrors();
});