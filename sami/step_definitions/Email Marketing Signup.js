import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import EmailSignupPage from '../pageObjects/EmailSignupPage';

const emailSignupPage = new EmailSignupPage();

Given('the user is on the email marketing signup page', () => {
  emailSignupPage.visit();
});

When('the user enters a valid email address', () => {
  emailSignupPage.enterEmail('valid@example.com');
});

When('the user enters an invalid email address', () => {
  emailSignupPage.enterEmail('invalid-email');
});

When('the user enters an email address that is already registered', () => {
  emailSignupPage.enterEmail('registered@example.com');
});

When('the user submits the signup form', () => {
  emailSignupPage.submitForm();
});

When('the user submits the signup form without entering an email address', () => {
  emailSignupPage.submitForm();
});

When('the user clicks on the privacy policy link', () => {
  emailSignupPage.clickPrivacyPolicyLink();
});

Then('the user should see a confirmation message', () => {
  emailSignupPage.verifyConfirmationMessage();
});

Then('the user should see an error message indicating the email is invalid', () => {
  emailSignupPage.verifyInvalidEmailMessage();
});

Then('the user should see a message indicating the email is already registered', () => {
  emailSignupPage.verifyAlreadyRegisteredMessage();
});

Then('the user should see an error message indicating that an email address is required', () => {
  emailSignupPage.verifyEmailRequiredMessage();
});

Then('the user should be redirected to the privacy policy page', () => {
  emailSignupPage.verifyPrivacyPolicyPage();
});

Then('the user should be able to return to the signup page', () => {
  emailSignupPage.returnToSignupPage();
});

Then('the user should be added to the email marketing list', () => {
  emailSignupPage.verifyUserAddedToList();
});

Then('the user should not be added to the email marketing list', () => {
  emailSignupPage.verifyUserNotAddedToList();
});

Then('the user should not be added to the email marketing list again', () => {
  emailSignupPage.verifyUserNotAddedToList();
});