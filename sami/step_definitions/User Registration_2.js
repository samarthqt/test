import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RegistrationPage from '../pageObjects/RegistrationPage';

const registrationPage = new RegistrationPage();

Given('the user is on the registration page', () => {
  registrationPage.visit();
});

When('the user enters a valid username', () => {
  registrationPage.enterUsername('validUsername');
});

When('the user enters a valid email address', () => {
  registrationPage.enterEmail('valid@example.com');
});

When('the user enters a valid password', () => {
  registrationPage.enterPassword('ValidPass123!');
});

When('the user confirms the password', () => {
  registrationPage.confirmPassword('ValidPass123!');
});

When('the user submits the registration form', () => {
  registrationPage.submitForm();
});

Then('the user should see a confirmation message', () => {
  registrationPage.verifyConfirmationMessage();
});

Then('the user account should be created successfully', () => {
  registrationPage.verifyAccountCreation();
});

When('the user enters an email address that is already registered', () => {
  registrationPage.enterEmail('registered@example.com');
});

Then('the user should see an error message indicating the email is already in use', () => {
  registrationPage.verifyEmailInUseError();
});

When('the user enters an invalid email address', () => {
  registrationPage.enterEmail('invalid-email');
});

Then('the user should see an error message indicating the email format is invalid', () => {
  registrationPage.verifyInvalidEmailError();
});

When('the user enters a password', () => {
  registrationPage.enterPassword('password123');
});

When('the user enters a different password in the confirm password field', () => {
  registrationPage.confirmPassword('differentPassword123');
});

Then('the user should see an error message indicating the passwords do not match', () => {
  registrationPage.verifyPasswordMismatchError();
});

When('the user leaves the username field empty', () => {
  registrationPage.enterUsername('');
});

When('the user leaves the email field empty', () => {
  registrationPage.enterEmail('');
});

When('the user leaves the password field empty', () => {
  registrationPage.enterPassword('');
});

When('the user leaves the confirm password field empty', () => {
  registrationPage.confirmPassword('');
});

Then('the user should see an error message indicating that all fields are required', () => {
  registrationPage.verifyRequiredFieldsError();
});

When('the user enters a password that does not meet complexity requirements', () => {
  registrationPage.enterPassword('simple');
});

Then('the user should see an error message indicating the password does not meet complexity requirements', () => {
  registrationPage.verifyPasswordComplexityError();
});