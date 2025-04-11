import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RegistrationPage from '../pageObjects/RegistrationPage';

const registrationPage = new RegistrationPage();

Given('I am on the user registration page', () => {
  registrationPage.visit();
});

When('I enter valid details such as {string} for name, {string} for email, {string} for password', (name, email, password) => {
  registrationPage.enterName(name);
  registrationPage.enterEmail(email);
  registrationPage.enterPassword(password);
});

When('I enter {string} for name, {string} for email, {string} for password', (name, email, password) => {
  registrationPage.enterName(name);
  registrationPage.enterEmail(email);
  registrationPage.enterPassword(password);
});

When('I leave the name field empty', () => {
  registrationPage.enterName('');
});

When('I leave the email field empty', () => {
  registrationPage.enterEmail('');
});

When('I leave the password field empty', () => {
  registrationPage.enterPassword('');
});

And('I submit the registration form', () => {
  registrationPage.submitForm();
});

Then('I should see a confirmation message {string}', (message) => {
  registrationPage.verifyConfirmationMessage(message);
});

Then('I should be redirected to the login page', () => {
  registrationPage.verifyRedirectionToLogin();
});

Then('I should see an error message {string}', (message) => {
  registrationPage.verifyErrorMessage(message);
});

And('the email {string} is already registered', (email) => {
  registrationPage.setEmailAsRegistered(email);
});