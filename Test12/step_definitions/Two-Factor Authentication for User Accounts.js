import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TwoFactorAuthPage from "../pages/twoFactorAuthPage";

Given("the user is logged into their account", () => {
  cy.login();
});

When("the user navigates to the security settings", () => {
  TwoFactorAuthPage.navigateToSecuritySettings();
});

When("the user selects the option to enable two-factor authentication", () => {
  TwoFactorAuthPage.enableTwoFactorAuth();
});

Then("the user should be presented with multiple 2FA methods", () => {
  TwoFactorAuthPage.verifyMultiple2FAMethods();
});

Then("the user should be able to choose a preferred 2FA method", () => {
  TwoFactorAuthPage.choosePreferred2FAMethod();
});

Given("the user has enabled two-factor authentication", () => {
  cy.enable2FA();
});

When("a 2FA-related activity occurs", () => {
  TwoFactorAuthPage.trigger2FAActivity();
});

Then("the user should receive a notification about the activity", () => {
  TwoFactorAuthPage.verify2FANotification();
});

When("the user attempts to log in", () => {
  cy.attemptLogin();
});

Then("the application should prompt for the 2FA method", () => {
  TwoFactorAuthPage.verify2FAPrompt();
});

Then("the application should verify the 2FA method is functioning correctly", () => {
  TwoFactorAuthPage.verify2FAFunctionality();
});

Given("the user is on the two-factor authentication setup page", () => {
  TwoFactorAuthPage.visitSetupPage();
});

When("the user selects {string}", (method) => {
  TwoFactorAuthPage.select2FAMethod(method);
});

Then("the user should be able to configure {string} successfully", (method) => {
  TwoFactorAuthPage.configure2FAMethod(method);
});