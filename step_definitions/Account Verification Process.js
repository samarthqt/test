import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountVerificationPage from '../pageObjects/AccountVerificationPage';

const accountVerificationPage = new AccountVerificationPage();

Given('the customer is on the account verification page', () => {
  accountVerificationPage.visit();
});

When('the customer enters their account credentials', () => {
  accountVerificationPage.enterCredentials('validUser', 'validPassword');
});

When('the customer enters incorrect account credentials', () => {
  accountVerificationPage.enterCredentials('invalidUser', 'invalidPassword');
});

When('clicks on the {string} button', (buttonName) => {
  accountVerificationPage.clickButton(buttonName);
});

Then('the account verification is successful', () => {
  accountVerificationPage.verifySuccess();
});

Then('the account verification fails', () => {
  accountVerificationPage.verifyFailure();
});

Then('the customer is redirected to their account details page', () => {
  accountVerificationPage.verifyRedirectionToAccountDetails();
});

Then('an error message is displayed indicating the account verification failed', () => {
  accountVerificationPage.verifyErrorMessage();
});

Then('the account status is updated to {string}', (status) => {
  accountVerificationPage.verifyAccountStatus(status);
});

Then('the customer can access account features', () => {
  accountVerificationPage.verifyAccessToFeatures();
});

Then('the customer is able to logout from the account', () => {
  accountVerificationPage.logout();
});

Then('the customer is not able to access their account details page', () => {
  accountVerificationPage.verifyNoAccessToAccountDetails();
});