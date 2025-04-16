import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountCreationPage from '../page_objects/AccountCreationPage';

const accountCreationPage = new AccountCreationPage();

Given('I am on the account creation page', () => {
  accountCreationPage.visit();
});

When('I enter the required information for account creation', () => {
  accountCreationPage.enterAccountInformation();
});

When("I click on the 'Cancel' button", () => {
  accountCreationPage.clickCancelButton();
});

Then('a confirmation message should be prompted', () => {
  accountCreationPage.verifyConfirmationMessage();
});

When('I confirm the cancellation', () => {
  accountCreationPage.confirmCancellation();
});

Then('the account creation process should be canceled and I should be navigated back to the previous page', () => {
  accountCreationPage.verifyNavigationToPreviousPage();
});

Then('the entered information should not be saved', () => {
  accountCreationPage.verifyInformationNotSaved();
});