import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountVerificationPage from '../pageObjects/AccountVerificationPage';

const accountVerificationPage = new AccountVerificationPage();

Given('the customer is on the account verification page', () => {
  accountVerificationPage.visit();
});

When('the customer enters their account information', () => {
  accountVerificationPage.enterAccountInformation();
});

When('the customer attempts to verify the account without completing all required fields', () => {
  accountVerificationPage.submitIncompleteVerification();
});

Then('an error message should be displayed indicating that all required fields must be completed', () => {
  accountVerificationPage.verifyErrorMessage();
});

When('the customer completes all required fields and submits the verification request', () => {
  accountVerificationPage.completeAndSubmitVerification();
});

Then('the verification request should be submitted successfully', () => {
  accountVerificationPage.verifySuccessfulSubmission();
});

When('the customer closes the verification page without completing the verification process', () => {
  accountVerificationPage.closePageWithoutVerification();
});

Then('the verification process should not be completed and the account should remain unverified', () => {
  accountVerificationPage.verifyAccountUnverified();
});

Given('the customer has not completed the account verification process', () => {
  accountVerificationPage.ensureAccountUnverified();
});

When('the customer attempts to access restricted features or perform actions that require account verification', () => {
  accountVerificationPage.attemptAccessRestrictedFeatures();
});

Then('the system should prevent the customer from accessing restricted features or performing actions that require account verification', () => {
  accountVerificationPage.verifyAccessDenied();
});

Given('the customer has completed the account verification process', () => {
  accountVerificationPage.ensureAccountVerified();
});

Then('the system should allow the customer to access restricted features and perform actions that require account verification', () => {
  accountVerificationPage.verifyAccessGranted();
});