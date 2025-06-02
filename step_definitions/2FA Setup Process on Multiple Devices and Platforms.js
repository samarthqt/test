import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TwoFASetupPage from "../pages/twoFASetupPage";

Given("a user account with 2FA not yet set up", () => {
 // Assume user account is created without 2FA
});

When("the user logs in to the application on a desktop device", () => {
 TwoFASetupPage.login();
});

Then("the user is successfully logged in and directed to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the account security settings", () => {
 TwoFASetupPage.navigateToSecuritySettings();
});

Then("the security settings page is displayed, showing 2FA options", () => {
 TwoFASetupPage.verifySecuritySettingsPage();
});

When("the user selects the option to enable 2FA", () => {
 TwoFASetupPage.selectEnable2FA();
});

Then("the user is prompted to choose a 2FA method", () => {
 TwoFASetupPage.verify2FAMethodPrompt();
});

When("the user chooses to receive 2FA codes via SMS", () => {
 TwoFASetupPage.selectSMSOption();
});

Then("the user is prompted to enter their mobile number", () => {
 TwoFASetupPage.verifyMobileNumberPrompt();
});

When("the user enters a valid mobile number and submits", () => {
 TwoFASetupPage.enterMobileNumber("1234567890");
});

Then("a verification code is sent to the provided mobile number", () => {
 TwoFASetupPage.verifyCodeSent();
});

When("the user enters the received verification code", () => {
 TwoFASetupPage.enterVerificationCode("123456");
});

Then("2FA setup is completed successfully, and confirmation is displayed", () => {
 TwoFASetupPage.verifySetupCompletion();
});

Given("2FA is set up via SMS", () => {
 // Assume 2FA is set up via SMS
});

When("the user logs out and attempts to log in again on a smartphone", () => {
 TwoFASetupPage.logout();
 TwoFASetupPage.loginOnSmartphone();
});

Then("the user is prompted for a 2FA code after entering their credentials", () => {
 TwoFASetupPage.verify2FACodePrompt();
});

When("the user enters the correct 2FA code", () => {
 TwoFASetupPage.enter2FACode("123456");
});

Then("the user is successfully logged in on the smartphone", () => {
 cy.url().should("include", "/smartphone-dashboard");
});

When("the user repeats the login and 2FA process on a tablet", () => {
 TwoFASetupPage.loginOnTablet();
 TwoFASetupPage.enter2FACode("123456");
});

Then("the user is successfully logged in on the tablet after entering the 2FA code", () => {
 cy.url().should("include", "/tablet-dashboard");
});

When("the user navigates to account settings", () => {
 TwoFASetupPage.navigateToAccountSettings();
});

Then("2FA is shown as enabled on all devices", () => {
 TwoFASetupPage.verify2FAEnabledOnAllDevices();
});

When("the user attempts to disable 2FA from one of the devices", () => {
 TwoFASetupPage.attemptDisable2FA();
});

Then("the user is prompted to enter a confirmation code sent to the registered mobile number", () => {
 TwoFASetupPage.verifyConfirmationCodePrompt();
});

When("the user enters the correct confirmation code to disable 2FA", () => {
 TwoFASetupPage.enterConfirmationCode("654321");
});

Then("2FA is successfully disabled, and confirmation is displayed", () => {
 TwoFASetupPage.verifyDisableConfirmation();
});

Given("2FA is disabled", () => {
 // Assume 2FA is disabled
});

When("the user enables 2FA again using an authenticator app", () => {
 TwoFASetupPage.enable2FAUsingAuthenticatorApp();
});

Then("the user is prompted to scan a QR code with the authenticator app", () => {
 TwoFASetupPage.verifyQRCodePrompt();
});

When("the user scans the QR code and enters the generated code from the authenticator app", () => {
 TwoFASetupPage.scanQRCodeAndEnterGeneratedCode("789012");
});

Then("2FA setup is completed with the authenticator app, and confirmation is displayed", () => {
 TwoFASetupPage.verifyAuthenticatorSetupCompletion();
});

Given("2FA is set up with an authenticator app", () => {
 // Assume 2FA is set up with an authenticator app
});

When("the user attempts to log in on all devices", () => {
 TwoFASetupPage.loginOnAllDevices();
});

Then("the user is able to log in on all devices using the authenticator app for 2FA", () => {
 TwoFASetupPage.verifyLoginSuccessOnAllDevices();
});