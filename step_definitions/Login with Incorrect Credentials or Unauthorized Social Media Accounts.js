import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user navigates to the login page", () => {
  LoginPage.visit();
});

When("the user attempts to login using email {string} and password {string}", (email, password) => {
  LoginPage.enterEmail(email);
  LoginPage.enterPassword(password);
  LoginPage.submit();
});

Then("the login should fail", () => {
  LoginPage.verifyLoginFailure();
});

Then("an error message {string} should be displayed", (errorMessage) => {
  LoginPage.verifyErrorMessage(errorMessage);
});

When("the user attempts to login using an unauthorized Google account", () => {
  LoginPage.loginWithGoogle();
});

When("the user attempts to login using an unauthorized Facebook account", () => {
  LoginPage.loginWithFacebook();
});

Given("the user has failed login attempts exceeding the allowed limit", () => {
  LoginPage.exceedFailedAttempts();
});

Then("the account should be locked", () => {
  LoginPage.verifyAccountLock();
});

Given("the account is locked", () => {
  LoginPage.verifyAccountLock();
});

When("the user checks for recovery options", () => {
  LoginPage.checkRecoveryOptions();
});

Then("account recovery options should be provided", () => {
  LoginPage.verifyRecoveryOptions();
});

When("the user attempts to login with valid credentials", () => {
  LoginPage.enterValidCredentials();
  LoginPage.submit();
});

Then("the login should fail due to account lockout", () => {
  LoginPage.verifyLoginFailureDueToLockout();
});

When("the user attempts to login", () => {
  LoginPage.submit();
});

Then("no unexpected errors should be logged in the browser console", () => {
  cy.checkConsoleErrors();
});

Given("multiple failed login attempts", () => {
  LoginPage.exceedFailedAttempts();
});

Then("CAPTCHA should be presented", () => {
  LoginPage.verifyCaptcha();
});

Given("the user navigates to the login page on a different device", () => {
  LoginPage.visit();
});

When("the user attempts to login using incorrect credentials", () => {
  LoginPage.enterIncorrectCredentials();
  LoginPage.submit();
});

When("the user attempts multiple failed logins", () => {
  LoginPage.attemptMultipleFailedLogins();
});

Then("the system should perform efficiently without lag", () => {
  LoginPage.verifySystemPerformance();
});

Given("the user has attempted multiple failed logins", () => {
  LoginPage.attemptMultipleFailedLogins();
});

Then("the user should remain logged out", () => {
  LoginPage.verifyUserRemainsLoggedOut();
});