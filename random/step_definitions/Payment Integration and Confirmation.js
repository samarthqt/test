import { PaymentPage } from '../support/pageObjects/PaymentPage';

const paymentPage = new PaymentPage();

Given('the application is integrated with {string}', (paymentMethod) => {
  paymentPage.verifyIntegration(paymentMethod);
});

When('a user initiates a payment using {string}', (paymentMethod) => {
  paymentPage.initiatePayment(paymentMethod);
});

Then('the transaction should be secure and comply with industry standards', () => {
  paymentPage.verifyTransactionSecurity();
});

Then('the user should receive a payment confirmation message', () => {
  paymentPage.verifyPaymentConfirmationMessage();
});

Then('a receipt should be provided to the user', () => {
  paymentPage.verifyReceiptProvided();
});

Then('a notification should confirm the successful payment', () => {
  paymentPage.verifySuccessfulPaymentNotification();
});

Then('the payment operation should be logged', () => {
  paymentPage.verifyPaymentLogging();
});

When('the transaction fails', () => {
  paymentPage.simulateTransactionFailure();
});

Then('an error message should be displayed for the failed transaction', () => {
  paymentPage.verifyErrorMessageForFailedTransaction();
});