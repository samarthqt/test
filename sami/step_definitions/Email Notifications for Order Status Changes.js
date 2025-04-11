import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderPage from '../../support/pageObjects/OrderPage';

const orderPage = new OrderPage();

Given('the user is logged into the order management system', () => {
  orderPage.login();
});

Given('the user has valid email notification settings configured', () => {
  orderPage.configureEmailSettings();
});

Given('an order with ID {string} is in the system', (orderId) => {
  orderPage.checkOrderInSystem(orderId);
});

When('the order status is updated to {string}', (status) => {
  orderPage.updateOrderStatus(status);
});

Then('an email notification should be sent to the customer's registered email address', () => {
  orderPage.verifyEmailSent();
});

Then('the email subject should be {string}', (subject) => {
  orderPage.verifyEmailSubject(subject);
});

Then('the email body should contain the {string}', (content) => {
  orderPage.verifyEmailBody(content);
});

Then('no email notification should be sent to the customer', () => {
  orderPage.verifyNoEmailSent();
});

Given('the email server is down', () => {
  orderPage.simulateEmailServerDown();
});

Then('the system should log an error indicating the email could not be sent', () => {
  orderPage.verifyEmailErrorLogged();
});

Then('the user should be notified of the failure to send the email notification', () => {
  orderPage.verifyUserNotifiedOfFailure();
});

Then('the email should contain the correct order ID, status, and {string}', (details) => {
  orderPage.verifyEmailContent(details);
});