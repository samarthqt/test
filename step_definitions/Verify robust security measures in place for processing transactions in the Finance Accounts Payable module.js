import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../pageObjects/LoginPage';
import FinanceModulePage from '../pageObjects/FinanceModulePage';

const loginPage = new LoginPage();
const financeModulePage = new FinanceModulePage();

Given('the user is on the login page', () => {
  loginPage.visit();
});

When('the user enters valid credentials', () => {
  loginPage.enterCredentials('validUser', 'validPass');
  loginPage.submit();
});

Then('the user should be able to access the Finance Accounts Payable module', () => {
  financeModulePage.verifyAccess();
});

When('the user enters incorrect credentials', () => {
  loginPage.enterCredentials('invalidUser', 'invalidPass');
  loginPage.submit();
});

Then('the system should deny access and display an error message indicating incorrect credentials', () => {
  loginPage.verifyErrorMessage();
});

When('the user enters correct credentials', () => {
  loginPage.enterCredentials('correctUser', 'correctPass');
  loginPage.submit();
});

Then('the system should grant access and display the main page of the Finance Accounts Payable module', () => {
  financeModulePage.verifyMainPage();
});

Given('the user is on the main page of the Finance Accounts Payable module', () => {
  financeModulePage.visitMainPage();
});

When('the user navigates to the transaction processing section', () => {
  financeModulePage.navigateToTransactionSection();
});

Then('the user should be able to navigate to the transaction processing section without any issues', () => {
  financeModulePage.verifyTransactionSectionAccess();
});

Given('the user is on the transaction processing section', () => {
  financeModulePage.visitTransactionSection();
});

When('the user attempts to process a transaction with incorrect authorization', () => {
  financeModulePage.processTransaction('incorrectAuth');
});

Then('the system should deny the transaction processing and display an error message indicating insufficient authorization', () => {
  financeModulePage.verifyAuthorizationError();
});

When('the user attempts to process a transaction with correct authorization', () => {
  financeModulePage.processTransaction('correctAuth');
});

Then('the system should allow the transaction processing and update the relevant records accordingly', () => {
  financeModulePage.verifyTransactionSuccess();
});

Given('the user is on the Finance Accounts Payable module', () => {
  financeModulePage.visit();
});

When('sensitive data such as payment details is transmitted or stored', () => {
  financeModulePage.transmitSensitiveData();
});

Then('the system should encrypt the sensitive data to ensure secure transmission and storage', () => {
  financeModulePage.verifyDataEncryption();
});

When('the user attempts to access sensitive data or functionalities', () => {
  financeModulePage.accessSensitiveData();
});

Then('the system should have proper user access controls in place to restrict unauthorized access', () => {
  financeModulePage.verifyAccessControls();
});

When('transactions and user activities occur', () => {
  financeModulePage.performTransactions();
});

Then('the system should have an audit trail functionality that logs all transactions and user activities for traceability and accountability', () => {
  financeModulePage.verifyAuditTrail();
});

When('the system is exposed to common security threats such as SQL injection, cross-site scripting, and session hijacking', () => {
  financeModulePage.exposeToSecurityThreats();
});

Then('the system should have measures in place to protect against these threats', () => {
  financeModulePage.verifySecurityMeasures();
});

Given('the user is interacting with the system', () => {
  financeModulePage.interactWithSystem();
});

When('data is transmitted between the user and the system', () => {
  financeModulePage.transmitData();
});

Then('the system should use secure communication protocols such as HTTPS to ensure secure data transmission', () => {
  financeModulePage.verifySecureCommunication();
});

Given('the user is creating or changing a password', () => {
  loginPage.visitPasswordChange();
});

When('the user sets a password', () => {
  loginPage.setPassword('newPassword');
});

Then('the system should enforce password complexity requirements to ensure strong and not easily guessable passwords', () => {
  loginPage.verifyPasswordComplexity();
});

Given('the user is logged into the system', () => {
  loginPage.login('user', 'pass');
});

When('the user becomes inactive for a certain period of time', () => {
  financeModulePage.simulateInactivity();
});

Then('the system should automatically log out the inactive user', () => {
  financeModulePage.verifySessionTimeout();
});

Given('the system is in operation', () => {
  financeModulePage.systemOperation();
});

When('regular backup procedures are performed', () => {
  financeModulePage.performBackup();
});

Then('the system should have procedures in place to ensure data can be recovered in the event of system failures or disasters', () => {
  financeModulePage.verifyBackupRecovery();
});

Given('the user is accessing the system', () => {
  financeModulePage.accessSystem();
});

When('user training and awareness materials are provided', () => {
  financeModulePage.provideTrainingMaterials();
});

Then('the system should educate users about security best practices and potential risks', () => {
  financeModulePage.verifyUserTraining();
});