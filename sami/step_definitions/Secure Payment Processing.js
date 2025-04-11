import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../page_objects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user is on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

When('the user enters valid payment details', () => {
  checkoutPage.enterPaymentDetails('valid');
});

When('the user enters invalid payment details', () => {
  checkoutPage.enterPaymentDetails('invalid');
});

When('the user submits the payment', () => {
  checkoutPage.submitPayment();
});

When('the user is on the payment page', () => {
  checkoutPage.visitPaymentPage();
});

When('the user decides to cancel the payment', () => {
  checkoutPage.cancelPayment();
});

When('a payment is processed', () => {
  checkoutPage.processPayment();
});

Then('the payment should be processed successfully', () => {
  checkoutPage.verifyPaymentSuccess();
});

Then('the transaction should be encrypted', () => {
  checkoutPage.verifyTransactionEncryption();
});

Then('the payment should not be processed', () => {
  checkoutPage.verifyPaymentFailure();
});

Then('an error message should be displayed indicating invalid payment details', () => {
  checkoutPage.verifyErrorMessage('invalid payment details');
});

Then('the payment data should be encrypted', () => {
  checkoutPage.verifyDataEncryption();
});

Then('encryption should be verified through security logs', () => {
  checkoutPage.verifyEncryptionLogs();
});

Then('the connection should be secure', () => {
  checkoutPage.verifySecureConnection();
});

Then('the URL should start with "https"', () => {
  checkoutPage.verifyURLStartsWithHTTPS();
});

Then('the user should be informed of a payment processing delay', () => {
  checkoutPage.verifyPaymentDelayMessage();
});

Then('the payment should eventually be processed securely', () => {
  checkoutPage.verifyEventualPaymentSuccess();
});

Then('the user should be returned to the checkout page without any charges', () => {
  checkoutPage.verifyReturnToCheckout();
});

Then('the transaction should be logged', () => {
  checkoutPage.verifyTransactionLogging();
});

Then('monitored for any security breaches', () => {
  checkoutPage.verifySecurityMonitoring();
});