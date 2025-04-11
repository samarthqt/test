import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../page_objects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user is on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

When('the user selects {string} as the payment method', (method) => {
  checkoutPage.selectPaymentMethod(method);
});

When('the user enters valid credit card details', () => {
  checkoutPage.enterValidCreditCardDetails();
});

When('the user enters invalid credit card details', () => {
  checkoutPage.enterInvalidCreditCardDetails();
});

When('the user submits the payment', () => {
  checkoutPage.submitPayment();
});

When('the user is redirected to the PayPal login page', () => {
  checkoutPage.verifyPayPalLoginPage();
});

When('the user logs in with valid PayPal credentials', () => {
  checkoutPage.loginToPayPal();
});

When('the user confirms the payment on the PayPal platform', () => {
  checkoutPage.confirmPayPalPayment();
});

When('the user cancels the payment on the PayPal platform', () => {
  checkoutPage.cancelPayPalPayment();
});

When('the user tries to proceed without selecting a payment method', () => {
  checkoutPage.proceedWithoutPaymentMethod();
});

Then('the payment should be processed successfully', () => {
  checkoutPage.verifySuccessfulPayment();
});

Then('the user should see a confirmation message for the successful payment', () => {
  checkoutPage.verifySuccessMessage();
});

Then('the payment should be declined', () => {
  checkoutPage.verifyDeclinedPayment();
});

Then('the user should see an error message indicating the payment was not successful', () => {
  checkoutPage.verifyErrorMessage();
});

Then('the payment should not be processed', () => {
  checkoutPage.verifyPaymentNotProcessed();
});

Then('the user should be redirected back to the checkout page', () => {
  checkoutPage.verifyRedirectionToCheckout();
});

Then('the user should see a message indicating the payment was canceled', () => {
  checkoutPage.verifyCancellationMessage();
});

Then('the user should see an error message indicating that a payment method must be selected', () => {
  checkoutPage.verifyPaymentMethodError();
});