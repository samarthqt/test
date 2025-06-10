import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the application is configured with Stripe API keys", () => {
 PaymentPage.configureStripe();
});

When("a user initiates a payment using Stripe", () => {
 PaymentPage.initiateStripePayment();
});

Then("the payment should be processed successfully through Stripe", () => {
 PaymentPage.verifyStripePaymentSuccess();
});

Given("the application is configured with PayPal API keys", () => {
 PaymentPage.configurePayPal();
});

When("a user initiates a payment using PayPal", () => {
 PaymentPage.initiatePayPalPayment();
});

Then("the payment should be processed successfully through PayPal", () => {
 PaymentPage.verifyPayPalPaymentSuccess();
});

Given("the application is integrated with payment gateways", () => {
 PaymentPage.verifyGatewayIntegration();
});

When("a user makes a transaction", () => {
 PaymentPage.makeTransaction();
});

Then("the transaction should be secure and reliable", () => {
 PaymentPage.verifyTransactionSecurity();
});

When("a user initiates a payment", () => {
 PaymentPage.initiatePayment();
});

Then("the transaction should be processed seamlessly", () => {
 PaymentPage.verifySeamlessTransaction();
});

Given("a user is on the checkout page", () => {
 PaymentPage.visitCheckoutPage();
});

When("the user selects a payment gateway", () => {
 PaymentPage.selectPaymentGateway();
});

Then("the system should process the payment using the selected gateway", () => {
 PaymentPage.verifyPaymentProcessing();
});

Given("a transaction is processed", () => {
 PaymentPage.processTransaction();
});

When("the transaction is completed", () => {
 PaymentPage.completeTransaction();
});

Then("the system should log the transaction details for auditing and reconciliation", () => {
 PaymentPage.logTransactionDetails();
});

When("a transaction is processed", () => {
 PaymentPage.processTransaction();
});

Then("the integration should comply with the payment gateway standards", () => {
 PaymentPage.verifyCompliance();
});

Given("a transaction error occurs", () => {
 PaymentPage.simulateTransactionError();
});

When("the system detects the error", () => {
 PaymentPage.detectTransactionError();
});

Then("the system should handle the error gracefully and notify the user", () => {
 PaymentPage.handleTransactionError();
});

When("the transaction status changes", () => {
 PaymentPage.changeTransactionStatus();
});

Then("the user should receive a notification about the transaction status", () => {
 PaymentPage.notifyUser();
});

When("there is a high volume of transactions", () => {
 PaymentPage.simulateHighVolumeTransactions();
});

Then("the integration should be scalable to support the transaction load", () => {
 PaymentPage.verifyScalability();
});