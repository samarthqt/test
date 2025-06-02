import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged into the application with valid credentials", () => {
 cy.login();
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters payment details and confirms the payment", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.confirmPayment();
});

When("the user repeats the payment process using a different payment method", () => {
 CheckoutPage.enterDifferentPaymentDetails();
 CheckoutPage.confirmPayment();
});

When("the user attempts payment with incorrect payment details", () => {
 CheckoutPage.enterIncorrectPaymentDetails();
 CheckoutPage.confirmPayment();
});

When("the user attempts payment without entering payment details", () => {
 CheckoutPage.confirmPayment();
});

When("the user attempts a payment that is declined", () => {
 CheckoutPage.enterDeclinedPaymentDetails();
 CheckoutPage.confirmPayment();
});

When("the payment gateway is unavailable", () => {
 CheckoutPage.simulatePaymentGatewayUnavailable();
});

When("the network connection is lost during payment", () => {
 CheckoutPage.simulateNetworkConnectionLost();
});

When("the user attempts payment with an expired payment method", () => {
 CheckoutPage.enterExpiredPaymentDetails();
 CheckoutPage.confirmPayment();
});

When("the user completes a payment successfully", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.confirmPayment();
});

Then("the payment is processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("a receipt is generated with transaction details", () => {
 CheckoutPage.verifyReceiptGenerated();
});

Then("an email notification is received with the receipt including transaction details", () => {
 CheckoutPage.verifyEmailNotification();
});

Then("the transaction details are updated in the order history", () => {
 CheckoutPage.verifyOrderHistoryUpdated();
});

Then("the user logs out from the application", () => {
 cy.logout();
});

Then("a receipt with transaction details is generated successfully for the different payment method", () => {
 CheckoutPage.verifyReceiptGenerated();
});

Then("the system displays an error message for invalid payment details", () => {
 CheckoutPage.verifyErrorMessage("invalid payment details");
});

Then("the system displays an error message for missing payment details", () => {
 CheckoutPage.verifyErrorMessage("missing payment details");
});

Then("the system displays an error message for declined payment", () => {
 CheckoutPage.verifyErrorMessage("declined payment");
});

Then("the system displays an error message for unavailable payment gateway", () => {
 CheckoutPage.verifyErrorMessage("unavailable payment gateway");
});

Then("the system displays an error message for network connection issues", () => {
 CheckoutPage.verifyErrorMessage("network connection issues");
});

Then("the system displays an error message for expired payment method", () => {
 CheckoutPage.verifyErrorMessage("expired payment method");
});

Then("the system displays an error message for missing transaction details in receipt", () => {
 CheckoutPage.verifyErrorMessage("missing transaction details in receipt");
});