import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user navigates to the login page", () => {
  LoginPage.visit();
});

When("the user enters valid username {string} and password {string}", (username, password) => {
  LoginPage.enterUsername(username);
  LoginPage.enterPassword(password);
});

When("clicks on the 'Login' button", () => {
  LoginPage.clickLoginButton();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
  cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
  LoginPage.ensureLoggedIn();
});

When("the user logs out of the account", () => {
  LoginPage.logout();
});

Then("the user is redirected to the login page", () => {
  cy.url().should("include", "/login");
});

When("the user selects 'Login with Facebook'", () => {
  LoginPage.clickLoginWithFacebook();
});

Then("the Facebook login page is displayed", () => {
  cy.url().should("include", "facebook.com");
});

When("the user enters Facebook credentials and logs in", () => {
  LoginPage.enterFacebookCredentials();
});

Then("the user is successfully logged in through Facebook and redirected to the dashboard", () => {
  cy.url().should("include", "/dashboard");
});

Given("the user is logged in through Facebook", () => {
  LoginPage.ensureLoggedInThroughFacebook();
});

When("the user selects 'Login with Google'", () => {
  LoginPage.clickLoginWithGoogle();
});

Then("the Google login page is displayed", () => {
  cy.url().should("include", "accounts.google.com");
});

When("the user enters Google credentials and logs in", () => {
  LoginPage.enterGoogleCredentials();
});

Then("the user is successfully logged in through Google and redirected to the dashboard", () => {
  cy.url().should("include", "/dashboard");
});

When("the user attempts to log in", () => {
  LoginPage.attemptLogin();
});

Then("CAPTCHA is displayed and required for login", () => {
  LoginPage.verifyCaptchaDisplayed();
});

Then("no security warnings or alerts are displayed", () => {
  LoginPage.verifyNoSecurityWarnings();
});

Given("the user navigates to the login page from a new device", () => {
  LoginPage.visitFromNewDevice();
});

Then("verification via email or phone is required", () => {
  LoginPage.verifyEmailOrPhoneVerificationRequired();
});

When("the user is inactive for a period", () => {
  LoginPage.waitForInactivity();
});

Then("the session times out and requires re-login", () => {
  LoginPage.verifySessionTimeout();
});

Then("all login pages and redirects are secured with HTTPS", () => {
  LoginPage.verifyHttpsRedirection();
});

Given("the system is under maintenance", () => {
  LoginPage.setSystemMaintenance();
});

Then("the user receives a maintenance notification and cannot log in", () => {
  LoginPage.verifyMaintenanceNotification();
});