import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountPage from '../pageObjects/AccountPage';

const accountPage = new AccountPage();

Given('I have valid account information', () => {
  accountPage.setValidAccountInfo();
});

Given('I have account information with missing data', () => {
  accountPage.setAccountInfoWithMissingData();
});

Given('I have account information with invalid data', () => {
  accountPage.setAccountInfoWithInvalidData();
});

Given('I have account information with incorrect format', () => {
  accountPage.setAccountInfoWithIncorrectFormat();
});

Given('I have account information exceeding maximum length', () => {
  accountPage.setAccountInfoExceedingMaxLength();
});

Given('I have account information with special characters', () => {
  accountPage.setAccountInfoWithSpecialCharacters();
});

Given('I have account information with leading/trailing spaces', () => {
  accountPage.setAccountInfoWithLeadingTrailingSpaces();
});

Given('I have account information with duplicate data', () => {
  accountPage.setAccountInfoWithDuplicateData();
});

Given('I have valid account information in all fields', () => {
  accountPage.setValidAccountInfoInAllFields();
});

Given('I have invalid account information in all fields', () => {
  accountPage.setInvalidAccountInfoInAllFields();
});

Given('I have missing account information in some fields', () => {
  accountPage.setMissingAccountInfoInSomeFields();
});

Given('I have account information with incorrect format in some fields', () => {
  accountPage.setAccountInfoWithIncorrectFormatInSomeFields();
});

Given('I have account information exceeding maximum length in some fields', () => {
  accountPage.setAccountInfoExceedingMaxLengthInSomeFields();
});

Given('I have account information with special characters in some fields', () => {
  accountPage.setAccountInfoWithSpecialCharactersInSomeFields();
});

Given('I have account information with leading/trailing spaces in some fields', () => {
  accountPage.setAccountInfoWithLeadingTrailingSpacesInSomeFields();
});

When('I enter the account information', () => {
  accountPage.enterAccountInformation();
});

Then('the system should accept the entered account information without displaying any error messages', () => {
  accountPage.verifyNoErrorMessages();
});

Then('the system should display appropriate error messages indicating the missing data', () => {
  accountPage.verifyErrorMessagesForMissingData();
});

Then('the system should display appropriate error messages indicating the invalid data', () => {
  accountPage.verifyErrorMessagesForInvalidData();
});

Then('the system should display appropriate error messages indicating the incorrect format', () => {
  accountPage.verifyErrorMessagesForIncorrectFormat();
});

Then('the system should display appropriate error messages indicating the maximum length exceeded', () => {
  accountPage.verifyErrorMessagesForMaxLengthExceeded();
});

Then('the system should display appropriate error messages indicating the presence of special characters', () => {
  accountPage.verifyErrorMessagesForSpecialCharacters();
});

Then('the system should trim the leading/trailing spaces and accept the account information without displaying any error messages', () => {
  accountPage.verifyTrimAndAccept();
});

Then('the system should display appropriate error messages indicating the duplicate data', () => {
  accountPage.verifyErrorMessagesForDuplicateData();
});

Then('the system should display appropriate error messages indicating the invalid data in all fields', () => {
  accountPage.verifyErrorMessagesForInvalidDataInAllFields();
});

Then('the system should display appropriate error messages indicating the missing data in the respective fields', () => {
  accountPage.verifyErrorMessagesForMissingDataInSomeFields();
});

Then('the system should display appropriate error messages indicating the incorrect format in the respective fields', () => {
  accountPage.verifyErrorMessagesForIncorrectFormatInSomeFields();
});

Then('the system should display appropriate error messages indicating the maximum length exceeded in the respective fields', () => {
  accountPage.verifyErrorMessagesForMaxLengthExceededInSomeFields();
});

Then('the system should display appropriate error messages indicating the presence of special characters in the respective fields', () => {
  accountPage.verifyErrorMessagesForSpecialCharactersInSomeFields();
});

Then('the system should trim the leading/trailing spaces in the respective fields and accept the account information without displaying any error messages', () => {
  accountPage.verifyTrimAndAcceptInSomeFields();
});