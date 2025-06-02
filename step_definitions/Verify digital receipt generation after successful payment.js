import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged into the application with valid credentials", () => {
 cy.login();
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visitCheckout();
});

When("enters payment details and confirms the payment", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.confirmPayment();
});

Then("the payment is processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("a digital receipt is generated and sent to user@example.com", () => {
 CheckoutPage.verifyReceiptSent("user@example.com");
});

Then("an email notification is received with the digital receipt", () => {
 CheckoutPage.verifyEmailNotification();
});

Then("the transaction details are updated in the order history", () => {
 CheckoutPage.verifyOrderHistoryUpdate();
});

Then("the user logs out from the application", () => {
 cy.logout();
});

When("enters payment details using a different payment method and confirms the payment", () => {
 CheckoutPage.enterDifferentPaymentMethod();
 CheckoutPage.confirmPayment();
});

Then("a digital receipt is generated successfully for the different payment method", () => {
 CheckoutPage.verifyReceiptForDifferentMethod();
});

When("enters incorrect payment details and attempts payment", () => {
 CheckoutPage.enterIncorrectPaymentDetails();
 CheckoutPage.attemptPayment();
});

Then("the system displays an error message for invalid payment details", () => {
 CheckoutPage.verifyInvalidPaymentError();
});

When("attempts payment without entering payment details", () => {
 CheckoutPage.attemptPaymentWithoutDetails();
});

Then("the system displays an error message for missing payment details", () => {
 CheckoutPage.verifyMissingDetailsError();
});

When("enters payment details and the payment is declined", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.declinePayment();
});

Then("the system displays an error message for declined payment", () => {
 CheckoutPage.verifyDeclinedPaymentError();
});

When("attempts payment when the payment gateway is unavailable", () => {
 CheckoutPage.attemptPaymentGatewayUnavailable();
});

Then("the system displays an error message for unavailable payment gateway", () => {
 CheckoutPage.verifyGatewayUnavailableError();
});

When("attempts payment when the network connection is lost", () => {
 CheckoutPage.attemptPaymentNetworkLost();
});

Then("the system displays an error message for network connection issues", () => {
 CheckoutPage.verifyNetworkError();
});

When("enters expired payment method details and attempts payment", () => {
 CheckoutPage.enterExpiredPaymentDetails();
 CheckoutPage.attemptPayment();
});

Then("the system displays an error message for expired payment method", () => {
 CheckoutPage.verifyExpiredMethodError();
});

When("enters payment details and confirms the payment", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.confirmPayment();
});

Then("the payment is processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("the system displays an error message for receipt generation failure despite successful payment", () => {
 CheckoutPage.verifyReceiptFailureError();
});