import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AccountPage from '../page_objects/AccountPage';
import LoginPage from '../page_objects/LoginPage';

const accountPage = new AccountPage();
const loginPage = new LoginPage();

Given('a user navigates to the account creation page', () => {
  accountPage.navigateToAccountCreationPage();
});

When('the user enters a valid email and password', () => {
  accountPage.enterEmailAndPassword('test@example.com', 'Password123');
});

When('the user submits the registration form', () => {
  accountPage.submitRegistrationForm();
});

Then('the account is created successfully', () => {
  accountPage.verifyAccountCreationSuccess();
});

Then('a success notification is displayed', () => {
  accountPage.verifySuccessNotification();
});

When('the user chooses to register using Google', () => {
  accountPage.registerUsingGoogle();
});

When('the user completes the Google authentication process', () => {
  accountPage.completeGoogleAuth();
});

When('the user chooses to register using Facebook', () => {
  accountPage.registerUsingFacebook();
});

When('the user completes the Facebook authentication process', () => {
  accountPage.completeFacebookAuth();
});

Given('a user navigates to the login page', () => {
  loginPage.navigateToLoginPage();
});

When('the user enters a valid email and password', () => {
  loginPage.enterEmailAndPassword('test@example.com', 'Password123');
});

When('the user submits the login form', () => {
  loginPage.submitLoginForm();
});

Then('the user is logged in successfully', () => {
  loginPage.verifyLoginSuccess();
});

When('the user chooses to log in using Google', () => {
  loginPage.loginUsingGoogle();
});

When('the user chooses to log in using Facebook', () => {
  loginPage.loginUsingFacebook();
});

When('the user clicks on the forgot password link', () => {
  loginPage.clickForgotPassword();
});

When('the user enters their registered email', () => {
  loginPage.enterRegisteredEmail('test@example.com');
});

Then('a password reset link is sent to the user's email', () => {
  loginPage.verifyPasswordResetLinkSent();
});

When('the user enters an invalid email or password', () => {
  loginPage.enterInvalidEmailOrPassword('invalid@example.com', 'wrongpassword');
});

Then('an error message is displayed', () => {
  loginPage.verifyErrorMessage();
});

Given('a user logs in successfully', () => {
  loginPage.performSuccessfulLogin();
});

Then('the login attempt is recorded in the system logs', () => {
  loginPage.verifyLoginAttemptRecorded();
});

Given('a user attempts to log in with invalid credentials', () => {
  loginPage.performInvalidLoginAttempt();
});

Then('the failed login attempt is recorded in the system logs', () => {
  loginPage.verifyFailedLoginAttemptRecorded();
});

Given('a user logs in using Google or Facebook', () => {
  loginPage.performSocialMediaLogin();
});

Then('the authentication process complies with OAuth standards', () => {
  loginPage.verifyOAuthCompliance();
});

Given('a user creates an account or logs in', () => {
  loginPage.performAccountCreationOrLogin();
});

Then('the process is secure and prevents unauthorized access', () => {
  loginPage.verifySecurityMeasures();
});

Then('user credentials are encrypted and stored securely', () => {
  loginPage.verifyCredentialsEncryption();
});