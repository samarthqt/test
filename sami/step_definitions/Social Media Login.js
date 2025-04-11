import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../pageObjects/LoginPage';

const loginPage = new LoginPage();

Given('the user is on the login page', () => {
  loginPage.visitLoginPage();
});

When('the user selects {string} login option', (platform) => {
  loginPage.selectSocialMediaLogin(platform);
});

When('the user is redirected to {string} login page', (platform) => {
  loginPage.verifyRedirectedToSocialMedia(platform);
});

When('the user enters valid {string} credentials', (platform) => {
  loginPage.enterValidCredentials(platform);
});

When('the user enters invalid {string} credentials', (platform) => {
  loginPage.enterInvalidCredentials(platform);
});

When('the user authorizes the application', () => {
  loginPage.authorizeApplication();
});

When('the user denies the application authorization', () => {
  loginPage.denyApplicationAuthorization();
});

Then('the user should be redirected to the home page', () => {
  loginPage.verifyRedirectedToHomePage();
});

Then('the user should be logged in successfully', () => {
  loginPage.verifyUserLoggedIn();
});

Then('the user should see an error message indicating invalid credentials', () => {
  loginPage.verifyInvalidCredentialsError();
});

Then('the user should not be logged in', () => {
  loginPage.verifyUserNotLoggedIn();
});

Then('the user should be redirected back to the login page', () => {
  loginPage.verifyRedirectedToLoginPage();
});

When('the user looks for social media login options', () => {
  loginPage.checkSocialMediaOptions();
});

Then('the user should see options for Facebook, Google, Twitter, and LinkedIn', () => {
  loginPage.verifySocialMediaOptions();
});