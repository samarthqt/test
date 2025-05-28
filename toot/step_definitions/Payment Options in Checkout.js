import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user selects \"Credit Card\" as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Credit Card');
});

When("the user enters valid credit card details", () => {
 CheckoutPage.enterCreditCardDetails('valid');
});

When("the user submits the payment", () => {
 CheckoutPage.submitPayment();
});

Then("the payment should be processed successfully", () => {
 CheckoutPage.verifyPaymentProcessed();
});

Then("the user should see a confirmation message for the successful payment", () => {
 CheckoutPage.verifyConfirmationMessage('success');
});

When("the user selects \"PayPal\" as the payment method", () => {
 CheckoutPage.selectPaymentMethod('PayPal');
});

When("the user is redirected to the PayPal login page", () => {
 CheckoutPage.verifyRedirectToPayPal();
});

When("the user logs in with valid PayPal credentials", () => {
 CheckoutPage.loginToPayPal('valid');
});

When("the user confirms the payment on the PayPal platform", () => {
 CheckoutPage.confirmPayPalPayment();
});

Then("the user should be redirected back to the checkout page", () => {
 CheckoutPage.verifyRedirectBackToCheckout();
});

When("the user enters invalid credit card details", () => {
 CheckoutPage.enterCreditCardDetails('invalid');
});

Then("the payment should be declined", () => {
 CheckoutPage.verifyPaymentDeclined();
});

Then("the user should see an error message indicating the payment was not successful", () => {
 CheckoutPage.verifyErrorMessage('declined');
});

When("the user cancels the payment on the PayPal platform", () => {
 CheckoutPage.cancelPayPalPayment();
});

Then("the payment should not be processed", () => {
 CheckoutPage.verifyPaymentNotProcessed();
});

Then("the user should see a message indicating the payment was canceled", () => {
 CheckoutPage.verifyErrorMessage('canceled');
});

When("the user tries to proceed without selecting a payment method", () => {
 CheckoutPage.proceedWithoutPaymentMethod();
});

Then("the user should see an error message indicating that a payment method must be selected", () => {
 CheckoutPage.verifyErrorMessage('mandatory');
});