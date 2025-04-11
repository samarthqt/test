import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PaymentInfoPage from '../page-objects/PaymentInfoPage';

const paymentInfoPage = new PaymentInfoPage();

Given('the user is logged into their account', () => {
  // Code to ensure the user is logged in
});

Given('the user is on the {string} page', (page) => {
  paymentInfoPage.navigateToPage(page);
});

Given('the user enters valid payment details', (dataTable) => {
  const data = dataTable.rowsHash();
  paymentInfoPage.enterPaymentDetails(data);
});

Given('the user enters invalid payment details', (dataTable) => {
  const data = dataTable.rowsHash();
  paymentInfoPage.enterPaymentDetails(data);
});

Given('the user enters incomplete payment details', (dataTable) => {
  const data = dataTable.rowsHash();
  paymentInfoPage.enterPaymentDetails(data);
});

Given('the user has previously saved payment information', () => {
  paymentInfoPage.checkSavedPaymentInfo();
});

When('the user saves the payment information', () => {
  paymentInfoPage.savePaymentInfo();
});

When('the user attempts to save the payment information', () => {
  paymentInfoPage.savePaymentInfo();
});

When('the user updates the payment details', (dataTable) => {
  const data = dataTable.rowsHash();
  paymentInfoPage.enterPaymentDetails(data);
});

When('the user saves the updated payment information', () => {
  paymentInfoPage.savePaymentInfo();
});

When('the user opts to delete the saved payment information', () => {
  paymentInfoPage.deletePaymentInfo();
});

Then('the payment information should be saved securely', () => {
  paymentInfoPage.verifyPaymentInfoSaved();
});

Then('a confirmation message {string} should be displayed', (message) => {
  paymentInfoPage.verifyConfirmationMessage(message);
});

Then('an error message {string} should be displayed', (message) => {
  paymentInfoPage.verifyErrorMessage(message);
});

Then('the payment information should not be saved', () => {
  paymentInfoPage.verifyPaymentInfoNotSaved();
});

Then('the updated payment information should be saved securely', () => {
  paymentInfoPage.verifyPaymentInfoUpdated();
});

Then('the payment information should be removed', () => {
  paymentInfoPage.verifyPaymentInfoDeleted();
});