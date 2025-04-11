import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderConfirmationPage from '../pageObjects/OrderConfirmationPage';

const orderConfirmationPage = new OrderConfirmationPage();

Given('a user has completed the checkout process', () => {
  orderConfirmationPage.completeCheckout();
});

When('the order is placed successfully', () => {
  orderConfirmationPage.placeOrder();
});

Then('the user should receive an order confirmation email', () => {
  orderConfirmationPage.verifyEmailReceived();
});

Then('the email should include the order number', () => {
  orderConfirmationPage.verifyEmailOrderNumber();
});

Then('the email should include the shipping address', () => {
  orderConfirmationPage.verifyEmailShippingAddress();
});

Then('the email should include the items purchased', () => {
  orderConfirmationPage.verifyEmailItemsPurchased();
});

Then('the email should include the estimated delivery date', () => {
  orderConfirmationPage.verifyEmailDeliveryDate();
});

Then('a notification should confirm successful order placement', () => {
  orderConfirmationPage.verifyNotification();
});

Then('the system should log the order confirmation notification', () => {
  orderConfirmationPage.verifySystemLog();
});

Then('the user should receive an order confirmation SMS', () => {
  orderConfirmationPage.verifySMSReceived();
});

Then('the SMS should include the order number', () => {
  orderConfirmationPage.verifySMSOrderNumber();
});

Then('the SMS should include the shipping address', () => {
  orderConfirmationPage.verifySMSShippingAddress();
});

Then('the SMS should include the items purchased', () => {
  orderConfirmationPage.verifySMSItemsPurchased();
});

Then('the SMS should include the estimated delivery date', () => {
  orderConfirmationPage.verifySMSDeliveryDate();
});

When('there is a failure in sending the order confirmation', () => {
  orderConfirmationPage.simulateOrderFailure();
});

Then('an error message should be displayed to the user', () => {
  orderConfirmationPage.verifyErrorMessage();
});

Then('the system should log the failed order confirmation attempt', () => {
  orderConfirmationPage.verifyFailedLog();
});