import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../pageObjects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the e-commerce platform is set up', () => {
  // Code to ensure the platform is set up
});

Given('the user is on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

Given('the user selects {string} as the payment method', (paymentMethod) => {
  checkoutPage.selectPaymentMethod(paymentMethod);
});

When('the user enters valid payment details', () => {
  checkoutPage.enterValidPaymentDetails();
});

When('the user enters invalid payment details', () => {
  checkoutPage.enterInvalidPaymentDetails();
});

When('the user confirms the payment', () => {
  checkoutPage.confirmPayment();
});

When('the user attempts to confirm the payment', () => {
  checkoutPage.attemptConfirmPayment();
});

When('the user is redirected to the PayPal login page', () => {
  checkoutPage.redirectToPayPalLogin();
});

When('the user logs in with valid PayPal credentials', () => {
  checkoutPage.loginToPayPal();
});

When('the user decides to cancel the payment', () => {
  checkoutPage.cancelPayment();
});

When('the user takes too long to confirm the payment', () => {
  checkoutPage.delayPaymentConfirmation();
});

Then('the payment should be processed successfully', () => {
  checkoutPage.verifyPaymentSuccess();
});

Then('the payment should not be processed', () => {
  checkoutPage.verifyPaymentFailure();
});

Then('the user should receive a payment confirmation', () => {
  checkoutPage.verifyPaymentConfirmation();
});

Then('the user should receive an error message indicating {string}', (errorMessage) => {
  checkoutPage.verifyErrorMessage(errorMessage);
});

Then('the order status should be updated to {string}', (status) => {
  checkoutPage.verifyOrderStatus(status);
});

Then('the user should be redirected back to the checkout page', () => {
  checkoutPage.verifyRedirectionToCheckout();
});

Then('the order status should remain {string}', (status) => {
  checkoutPage.verifyOrderStatus(status);
});

Then('the payment session should timeout', () => {
  checkoutPage.verifySessionTimeout();
});

Then('the user should be prompted to restart the payment process', () => {
  checkoutPage.verifyPromptToRestartPayment();
});