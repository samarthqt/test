import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the e-commerce platform is set up", () => {
 cy.visit("/setup");
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

Given("the user selects Stripe as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Stripe');
});

Given("the user selects PayPal as the payment method", () => {
 CheckoutPage.selectPaymentMethod('PayPal');
});

Given("the user selects a payment method", () => {
 CheckoutPage.selectPaymentMethod();
});

When("the user enters valid payment details", () => {
 CheckoutPage.enterPaymentDetails('valid');
});

When("the user enters invalid payment details", () => {
 CheckoutPage.enterPaymentDetails('invalid');
});

When("the user confirms the payment", () => {
 CheckoutPage.confirmPayment();
});

When("the user attempts to confirm the payment", () => {
 CheckoutPage.attemptConfirmPayment();
});

When("the user is redirected to the PayPal login page", () => {
 CheckoutPage.redirectToPayPalLogin();
});

When("the user logs in with valid PayPal credentials", () => {
 CheckoutPage.loginToPayPal('valid');
});

When("the user decides to cancel the payment", () => {
 CheckoutPage.cancelPayment();
});

When("the user takes too long to confirm the payment", () => {
 CheckoutPage.waitForPaymentTimeout();
});

Then("the payment should be processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("the payment should not be processed", () => {
 CheckoutPage.verifyPaymentFailure();
});

Then("the user should receive a payment confirmation", () => {
 CheckoutPage.verifyPaymentConfirmation();
});

Then("the user should receive an error message indicating invalid card details", () => {
 CheckoutPage.verifyErrorMessage('invalid card details');
});

Then("the user should receive an error message indicating insufficient balance", () => {
 CheckoutPage.verifyErrorMessage('insufficient balance');
});

Then("the user should be redirected back to the checkout page", () => {
 CheckoutPage.verifyRedirectToCheckout();
});

Then("the payment session should timeout", () => {
 CheckoutPage.verifySessionTimeout();
});

Then("the user should be prompted to restart the payment process", () => {
 CheckoutPage.verifyRestartPaymentPrompt();
});

Then("the order status should be updated to \"Paid\"", () => {
 CheckoutPage.verifyOrderStatus('Paid');
});

Then("the order status should remain \"Pending\"", () => {
 CheckoutPage.verifyOrderStatus('Pending');
});