import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountVerificationPage from '../page_objects/AccountVerificationPage';

const accountVerificationPage = new AccountVerificationPage();

Given('the user is on the account verification page', () => {
  accountVerificationPage.visit();
});

When('the user enters valid customer data {string}, {string}, {string}', (name, address, contact) => {
  accountVerificationPage.enterCustomerData(name, address, contact);
});

When('submits the customer data for verification', () => {
  accountVerificationPage.submitCustomerData();
});

Then('the system should process the data and initiate the verification process', () => {
  accountVerificationPage.verifyDataProcessing();
});

Then('verify the customer data against the database', () => {
  accountVerificationPage.checkDataAgainstDatabase();
});

Then('validate the customer data for completeness and correctness', () => {
  accountVerificationPage.validateDataCompleteness();
});

Then('perform security checks on the customer data', () => {
  accountVerificationPage.performSecurityChecks();
});

Then('generate a verification report indicating the verification status and any discrepancies found', () => {
  accountVerificationPage.generateVerificationReport();
});

Then('display the verification result {string} to the user', (result) => {
  accountVerificationPage.displayVerificationResult(result);
});

Then('provide options for corrective action if verification fails', () => {
  accountVerificationPage.provideCorrectiveOptions();
});

Then('log the verification process and result for auditing purposes', () => {
  accountVerificationPage.logVerificationProcess();
});

Then('proceed with the account setup if verification is successful', () => {
  accountVerificationPage.proceedWithAccountSetup();
});

Then('restrict account setup if verification fails', () => {
  accountVerificationPage.restrictAccountSetup();
});

Then('verify the accuracy of the verified customer data', () => {
  accountVerificationPage.verifyDataAccuracy();
});

Then('encrypt and store the verified customer data for future reference', () => {
  accountVerificationPage.encryptAndStoreData();
});

Then('notify the user about the completion of the verification process and provide any necessary instructions', () => {
  accountVerificationPage.notifyUserCompletion();
});