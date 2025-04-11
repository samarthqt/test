import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../page_objects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user is on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

When('the user selects {string} as the payment method', (paymentMethod) => {
  checkoutPage.selectPaymentMethod(paymentMethod);
});

When('the user enters valid payment details', () => {
  checkoutPage.enterValidPaymentDetails();
});

When('the user enters invalid credit card details', () => {
  checkoutPage.enterInvalidCreditCardDetails();
});

When('the user enters invalid PayPal account details', () => {
  checkoutPage.enterInvalidPayPalDetails();
});

When('the user decides to cancel the payment', () => {
  checkoutPage.cancelPayment();
});

When('the user confirms the payment', () => {
  checkoutPage.confirmPayment();
});

When('the user logs into their PayPal account', () => {
  checkoutPage.loginToPayPal();
});

Then('the payment should be processed successfully', () => {
  checkoutPage.verifyPaymentSuccess();
});

Then('the payment should not be processed', () => {
  checkoutPage.verifyPaymentFailure();
});

Then('the user should see a confirmation message', () => {
  checkoutPage.verifyConfirmationMessage();
});

Then('the user should see an error message indicating invalid payment details', () => {
  checkoutPage.verifyErrorMessage();
});

Then('the user should be redirected back to the checkout page', () => {
  checkoutPage.verifyRedirectionToCheckoutPage();
});

Then('the user should receive a confirmation email', () => {
  checkoutPage.verifyConfirmationEmail();
});