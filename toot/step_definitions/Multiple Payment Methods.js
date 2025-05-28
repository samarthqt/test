import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user selects {string} as the payment method", (method) => {
 CheckoutPage.selectPaymentMethod(method);
});

When("the user enters valid credit card details", () => {
 CheckoutPage.enterCreditCardDetails('valid');
});

When("the user enters valid debit card details", () => {
 CheckoutPage.enterDebitCardDetails('valid');
});

When("the user enters invalid credit card details", () => {
 CheckoutPage.enterCreditCardDetails('invalid');
});

When("the user enters invalid debit card details", () => {
 CheckoutPage.enterDebitCardDetails('invalid');
});

When("the user submits the payment", () => {
 CheckoutPage.submitPayment();
});

When("the user is redirected to the PayPal login page", () => {
 CheckoutPage.redirectToPayPal();
});

When("the user logs in with valid PayPal credentials", () => {
 CheckoutPage.loginToPayPal();
});

When("the user confirms the payment", () => {
 CheckoutPage.confirmPayPalPayment();
});

When("the user cancels the payment", () => {
 CheckoutPage.cancelPayPalPayment();
});

Then("the payment should be processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("the payment should be declined", () => {
 CheckoutPage.verifyPaymentDeclined();
});

Then("the user should see a confirmation message", () => {
 CheckoutPage.verifyConfirmationMessage();
});

Then("the user should see an error message indicating invalid card details", () => {
 CheckoutPage.verifyErrorMessage();
});

Then("the user should be redirected back to the confirmation page", () => {
 CheckoutPage.verifyRedirectionToConfirmation();
});

Then("the user should be redirected back to the checkout page", () => {
 CheckoutPage.verifyRedirectionToCheckout();
});

Then("the payment should not be processed", () => {
 CheckoutPage.verifyPaymentNotProcessed();
});