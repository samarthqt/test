import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user is on the payment page", () => {
 PaymentPage.visit();
});

When("the user selects a payment method", () => {
 PaymentPage.selectPaymentMethod();
});

Then("the user should be able to choose between Stripe and PayPal", () => {
 PaymentPage.verifyPaymentOptions(['Stripe', 'PayPal']);
});

Given("the user initiates a payment", () => {
 PaymentPage.initiatePayment();
});

When("the payment is processed", () => {
 PaymentPage.processPayment();
});

Then("the transaction should be secure and encrypted", () => {
 PaymentPage.verifyTransactionSecurity();
});

Given("the user completes a payment successfully", () => {
 PaymentPage.completePayment();
});

When("the payment is confirmed", () => {
 PaymentPage.confirmPayment();
});

Then("the system should send a confirmation and receipt to the user", () => {
 PaymentPage.verifyConfirmationAndReceipt();
});

When("the payment fails", () => {
 PaymentPage.failPayment();
});

Then("an error message should be displayed to the user", () => {
 PaymentPage.verifyErrorMessage();
});

When("the user starts the payment process", () => {
 PaymentPage.startPaymentProcess();
});

Then("the interface should guide the user through the payment steps", () => {
 PaymentPage.verifyPaymentGuidance();
});

Given("the payment system is integrated", () => {
 PaymentPage.verifyIntegration();
});

When("the payment process is initiated", () => {
 PaymentPage.initiatePaymentProcess();
});

Then("the integration should comply with industry security standards", () => {
 PaymentPage.verifyIndustryStandardsCompliance();
});

Given("a payment transaction is completed", () => {
 PaymentPage.completeTransaction();
});

Then("the system should log the transaction for auditing purposes", () => {
 PaymentPage.verifyTransactionLogging();
});

Given("the user is logged into their account", () => {
 PaymentPage.loginToAccount();
});

When("the user navigates to the payment history section", () => {
 PaymentPage.navigateToPaymentHistory();
});

Then("the user should be able to view their payment history", () => {
 PaymentPage.verifyPaymentHistory();
});

Then("the application should support multiple payment methods", () => {
 PaymentPage.verifyMultiplePaymentMethods();
});

When("a payment transaction is initiated", () => {
 PaymentPage.initiateTransaction();
});

Then("the integration should be optimized for performance", () => {
 PaymentPage.verifyPerformanceOptimization();
});