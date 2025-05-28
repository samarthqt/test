import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the system is configured for payment gateway integration", () => {
 // Assume configuration is done
});

Given("the user selects {string} as the payment provider", (provider) => {
 PaymentPage.selectPaymentProvider(provider);
});

When("the user proceeds to checkout", () => {
 PaymentPage.proceedToCheckout();
});

When("the user enters {string} payment details", (validity) => {
 PaymentPage.enterPaymentDetails(validity);
});

When("the user is redirected to the PayPal login page", () => {
 PaymentPage.redirectToPayPalLogin();
});

When("the user logs in with {string} PayPal credentials", (validity) => {
 PaymentPage.loginToPayPal(validity);
});

When("the user confirms the payment", () => {
 PaymentPage.confirmPayPalPayment();
});

Then("the payment should be processed successfully", () => {
 PaymentPage.verifySuccessfulPayment();
});

Then("the payment should be declined", () => {
 PaymentPage.verifyDeclinedPayment();
});

Then("the user should receive a confirmation of the transaction", () => {
 PaymentPage.verifyConfirmationReceived();
});

Then("the user should receive an error message indicating the payment failure", () => {
 PaymentPage.verifyPaymentErrorMessage();
});

Then("the user should not be able to log in", () => {
 PaymentPage.verifyLoginFailure();
});

Then("the user should receive an error message indicating the login failure", () => {
 PaymentPage.verifyLoginErrorMessage();
});

Given("the user is on the checkout page", () => {
 PaymentPage.visitCheckoutPage();
});

When("the user selects a payment provider", () => {
 PaymentPage.selectAnyPaymentProvider();
});

Then("the selected provider should be displayed as the current payment method", () => {
 PaymentPage.verifySelectedProviderDisplayed();
});

Given("the payment is processed successfully", () => {
 PaymentPage.assumePaymentProcessedSuccessfully();
});

When("the user receives a confirmation", () => {
 PaymentPage.receiveConfirmation();
});

Then("the confirmation should include transaction ID, amount, and payment method", () => {
 PaymentPage.verifyConfirmationDetails();
});