import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RegistrationPage from '../pageObjects/RegistrationPage';

const registrationPage = new RegistrationPage();

Given('the user is on the registration page', () => {
  registrationPage.visit();
});

When('the user enters valid details in all required fields', (dataTable) => {
  const data = dataTable.rowsHash();
  registrationPage.fillFirstName(data['First Name']);
  registrationPage.fillLastName(data['Last Name']);
  registrationPage.fillEmail(data['Email']);
  registrationPage.fillPassword(data['Password']);
  registrationPage.fillConfirmPassword(data['Confirm Password']);
});

When('the user leaves the {string} field empty', (field) => {
  registrationPage.leaveFieldEmpty(field);
});

When('the user enters an invalid email format {string}', (invalidEmail) => {
  registrationPage.fillEmail(invalidEmail);
});

When('the user enters {string} in the {string} field', (value, field) => {
  registrationPage.fillField(field, value);
});

When('the user enters an email {string} that is already registered', (email) => {
  registrationPage.fillEmail(email);
});

And('the user submits the registration form', () => {
  registrationPage.submitForm();
});

Then('the user account should be created successfully', () => {
  registrationPage.verifyAccountCreation();
});

Then('the user should see a confirmation message {string}', (message) => {
  registrationPage.verifyConfirmationMessage(message);
});

Then('the user should see an error message {string}', (errorMessage) => {
  registrationPage.verifyErrorMessage(errorMessage);
});