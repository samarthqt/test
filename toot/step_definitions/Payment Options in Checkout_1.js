import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user selects {string} as the payment method", (paymentMethod) => {
 CheckoutPage.selectPaymentMethod(paymentMethod);
});

When("the user enters valid payment details", () => {
 CheckoutPage.enterValidPaymentDetails();
});

When("the user enters invalid credit card details", () => {
 CheckoutPage.enterInvalidCreditCardDetails();
});

When("the user enters invalid PayPal account details", () => {
 CheckoutPage.enterInvalidPayPalDetails();
});

When("the user decides to cancel the payment", () => {
 CheckoutPage.cancelPayment();
});

When("the user confirms the payment", () => {
 CheckoutPage.confirmPayment();
});

Then("the payment should be processed successfully", () => {
 CheckoutPage.verifySuccessfulPayment();
});

Then("the payment should not be processed", () => {
 CheckoutPage.verifyFailedPayment();
});

Then("the user should see a confirmation message", () => {
 CheckoutPage.verifyConfirmationMessage();
});

Then("the user should see an error message indicating invalid payment details", () => {
 CheckoutPage.verifyErrorMessage();
});

Then("the user should be redirected back to the checkout page", () => {
 CheckoutPage.verifyRedirectToCheckout();
});

Then("the user should receive a confirmation email", () => {
 CheckoutPage.verifyConfirmationEmail();
});