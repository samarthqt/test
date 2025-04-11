import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderConfirmationPage from '../page_objects/OrderConfirmationPage';

const orderPage = new OrderConfirmationPage();

Given('a user has completed a purchase', () => {
  orderPage.completePurchase();
});

When('the purchase transaction is successful', () => {
  orderPage.verifyTransactionSuccess();
});

Then('an order confirmation email should be sent to the user's registered email address', () => {
  orderPage.verifyEmailSent();
});

Then('the email should contain the order details including order ID, items purchased, total amount, and delivery address', () => {
  orderPage.verifyEmailContent();
});

Then('the email should be sent from the correct sender email address for order confirmations', () => {
  orderPage.verifyEmailSender();
});

Given('a user attempts to complete a purchase', () => {
  orderPage.attemptPurchase();
});

When('the purchase transaction fails', () => {
  orderPage.verifyTransactionFailure();
});

Then('no order confirmation email should be sent to the user', () => {
  orderPage.verifyNoEmailSent();
});

Given('the initial attempt to send an order confirmation email fails', () => {
  orderPage.failInitialEmailSend();
});

When('the system retries sending the email', () => {
  orderPage.retryEmailSend();
});

Then('the order confirmation email should be successfully sent to the user's registered email address', () => {
  orderPage.verifyEmailSent();
});

When('an order confirmation email is sent', () => {
  orderPage.sendEmail();
});

Then('the system should log the status of the email sending process', () => {
  orderPage.logEmailStatus();
});

Then('the log should include whether the email was successfully sent or if there were any errors', () => {
  orderPage.verifyLogContent();
});