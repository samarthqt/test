import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import RegistrationPage from '../page_objects/RegistrationPage';

const registrationPage = new RegistrationPage();

Given('the user is on the registration page', () => {
  registrationPage.visit();
});

When('the user enters the required information in the registration form', () => {
  registrationPage.fillRegistrationForm();
});

When('the user clicks on the {string} button', (button) => {
  registrationPage.clickButton(button);
});

When('the user follows the instructions provided on the screen', () => {
  registrationPage.followInstructions();
});

When('the user completes each step as instructed', () => {
  registrationPage.completeSteps();
});

When('the user continues following the instructions until the account creation process is complete', () => {
  registrationPage.completeAccountCreation();
});

Then('the user should be able to verify that the account is successfully created', () => {
  registrationPage.verifyAccountCreation();
});

Then('the user should be able to log in to the newly created account', () => {
  registrationPage.verifyLogin();
});

Then('the user should be able to verify that all the entered information is correctly displayed in the account profile', () => {
  registrationPage.verifyProfileInformation();
});

Then('the user should be able to verify that the account has the expected permissions and access rights', () => {
  registrationPage.verifyPermissions();
});

Then('the user should be able to verify that they receive a confirmation email for the account creation', () => {
  registrationPage.verifyConfirmationEmail();
});

Then('the user should be able to verify that the confirmation email contains the correct account details', () => {
  registrationPage.verifyEmailDetails();
});

Then('the user should be able to verify that the account creation process can be completed within the specified time limit', () => {
  registrationPage.verifyTimeLimit();
});

Then('the user should be able to verify that error messages are displayed for any invalid or missing information', () => {
  registrationPage.verifyErrorMessages();
});