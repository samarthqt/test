import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RealTimePaymentPage from '../page_objects/RealTimePaymentPage';

const realTimePaymentPage = new RealTimePaymentPage();

Given('the system is integrated with real-time payment networks', () => {
  realTimePaymentPage.verifySystemIntegration();
});

When('a user initiates a transaction', () => {
  realTimePaymentPage.initiateTransaction();
});

Then('the transaction should be completed within 5 seconds', () => {
  realTimePaymentPage.verifyTransactionCompletionTime();
});

Given('a transaction is successfully completed', () => {
  realTimePaymentPage.verifyTransactionSuccess();
});

When('the transaction is processed', () => {
  realTimePaymentPage.processTransaction();
});

Then('the user should receive immediate confirmation of the successful transaction', () => {
  realTimePaymentPage.verifyImmediateConfirmation();
});

Given('the system is operating during peak times', () => {
  realTimePaymentPage.verifyPeakOperation();
});

When('transactions are being processed', () => {
  realTimePaymentPage.processTransactions();
});

Then('the system must handle at least 10,000 transactions per minute', () => {
  realTimePaymentPage.verifyTransactionHandlingCapacity();
});

Given('the system is set up for real-time payment processing', () => {
  realTimePaymentPage.setupRealTimeProcessing();
});

When('checking the integration', () => {
  realTimePaymentPage.checkIntegration();
});

Then('the system should be integrated with at least two real-time payment networks', () => {
  realTimePaymentPage.verifyMultipleNetworkIntegration();
});

Given('a real-time payment is completed', () => {
  realTimePaymentPage.completeRealTimePayment();
});

When('the transaction history is checked', () => {
  realTimePaymentPage.checkTransactionHistory();
});

Then('it should update instantly, reflecting all real-time payments', () => {
  realTimePaymentPage.verifyInstantHistoryUpdate();
});