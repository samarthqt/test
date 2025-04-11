const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const RegistrationPage = require('../pageObjects/RegistrationPage');

Given('I am on the registration page', () => {
  RegistrationPage.visit();
});

When('I enter valid details such as username, email, and password', () => {
  RegistrationPage.enterUsername('validUser');
  RegistrationPage.enterEmail('valid@example.com');
  RegistrationPage.enterPassword('ValidPassword123');
});

When('I submit the registration form', () => {
  RegistrationPage.submitForm();
});

Then('I should see a confirmation message', () => {
  RegistrationPage.verifyConfirmationMessage();
});

Then('I should be redirected to the login page', () => {
  RegistrationPage.verifyRedirectionToLogin();
});

When('I enter {string} as my email', (email) => {
  RegistrationPage.enterEmail(email);
});

When('I fill in other valid details', () => {
  RegistrationPage.enterUsername('validUser');
  RegistrationPage.enterPassword('ValidPassword123');
});

Then('I should see an error message indicating the email is already registered', () => {
  RegistrationPage.verifyEmailAlreadyRegisteredError();
});

When('I enter a password that does not meet the security requirements', () => {
  RegistrationPage.enterPassword('weak');
});

Then('I should see an error message indicating the password is too weak', () => {
  RegistrationPage.verifyWeakPasswordError();
});

When('I leave one or more required fields empty', () => {
  RegistrationPage.leaveRequiredFieldsEmpty();
});

Then('I should see an error message indicating the fields are required', () => {
  RegistrationPage.verifyRequiredFieldsError();
});

When('I enter an invalid email format', () => {
  RegistrationPage.enterEmail('invalid-email');
});

Then('I should see an error message indicating the email format is invalid', () => {
  RegistrationPage.verifyInvalidEmailFormatError();
});

When('I enter a password and a different password in the confirmation field', () => {
  RegistrationPage.enterPassword('Password123');
  RegistrationPage.enterPasswordConfirmation('DifferentPassword123');
});

Then('I should see an error message indicating the passwords do not match', () => {
  RegistrationPage.verifyPasswordMismatchError();
});