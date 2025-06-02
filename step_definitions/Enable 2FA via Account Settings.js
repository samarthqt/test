import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("the user account is active with User ID: {string}", (userId) => {
 cy.wrap(userId).as('userId');
});

When("the user navigates to account settings", () => {
 AccountSettingsPage.visit();
});

Then("the account settings page is displayed", () => {
 AccountSettingsPage.verifyPageDisplayed();
});

Then("2FA options must be available", () => {
 AccountSettingsPage.verify2FAOptionsAvailable();
});

When("the user locates the 2FA section", () => {
 AccountSettingsPage.locate2FASection();
});

Then("the 2FA section is visible with options", () => {
 AccountSettingsPage.verify2FASectionVisible();
});

When("the user selects SMS as the 2FA method", () => {
 AccountSettingsPage.selectSMSOption();
});

Then("the SMS option is selected", () => {
 AccountSettingsPage.verifySMSOptionSelected();
});

When("the user enters a valid phone number for SMS verification", () => {
 AccountSettingsPage.enterPhoneNumber("+1234567890");
});

Then("the phone number {string} is entered successfully", (phoneNumber) => {
 AccountSettingsPage.verifyPhoneNumberEntered(phoneNumber);
});

When("the user submits the SMS verification request", () => {
 AccountSettingsPage.submitSMSVerificationRequest();
});

Then("the SMS verification request is submitted", () => {
 AccountSettingsPage.verifySMSVerificationRequestSubmitted();
});

When("the user verifies receipt of SMS verification code", () => {
 AccountSettingsPage.verifySMSCodeReceived();
});

Then("the SMS verification code is received", () => {
 AccountSettingsPage.verifySMSCodeReceived();
});

When("the user enters the SMS verification code", () => {
 AccountSettingsPage.enterSMSVerificationCode();
});

Then("the SMS verification code is entered successfully", () => {
 AccountSettingsPage.verifySMSCodeEntered();
});

When("the user confirms 2FA setup via SMS", () => {
 AccountSettingsPage.confirm2FASMSSetup();
});

Then("the 2FA setup via SMS is confirmed", () => {
 AccountSettingsPage.verify2FASMSSetupConfirmed();
});

Given("the user switches to email as the 2FA method", () => {
 AccountSettingsPage.selectEmailOption();
});

Then("the email option is selected", () => {
 AccountSettingsPage.verifyEmailOptionSelected();
});

When("the user enters a valid email address for verification", () => {
 AccountSettingsPage.enterEmailAddress("user@example.com");
});

Then("the email address {string} is entered successfully", (emailAddress) => {
 AccountSettingsPage.verifyEmailAddressEntered(emailAddress);
});

When("the user submits the email verification request", () => {
 AccountSettingsPage.submitEmailVerificationRequest();
});

Then("the email verification request is submitted", () => {
 AccountSettingsPage.verifyEmailVerificationRequestSubmitted();
});

When("the user verifies receipt of email verification code", () => {
 AccountSettingsPage.verifyEmailCodeReceived();
});

Then("the email verification code is received", () => {
 AccountSettingsPage.verifyEmailCodeReceived();
});

When("the user enters the email verification code", () => {
 AccountSettingsPage.enterEmailVerificationCode();
});

Then("the email verification code is entered successfully", () => {
 AccountSettingsPage.verifyEmailCodeEntered();
});

When("the user confirms 2FA setup via email", () => {
 AccountSettingsPage.confirm2FAEmailSetup();
});

Then("the 2FA setup via email is confirmed", () => {
 AccountSettingsPage.verify2FAEmailSetupConfirmed();
});

Given("the user switches to authenticator app as the 2FA method", () => {
 AccountSettingsPage.selectAuthenticatorAppOption();
});

Then("the authenticator app option is selected", () => {
 AccountSettingsPage.verifyAuthenticatorAppOptionSelected();
});

When("the user enables authenticator app for verification", () => {
 AccountSettingsPage.enableAuthenticatorApp();
});

Then("the authenticator app is enabled successfully", () => {
 AccountSettingsPage.verifyAuthenticatorAppEnabled();
});

When("the user verifies receipt of authenticator app code", () => {
 AccountSettingsPage.verifyAuthenticatorAppCodeReceived();
});

Then("the authenticator app code is received", () => {
 AccountSettingsPage.verifyAuthenticatorAppCodeReceived();
});

When("the user enters the authenticator app code", () => {
 AccountSettingsPage.enterAuthenticatorAppCode();
});

Then("the authenticator app code is entered successfully", () => {
 AccountSettingsPage.verifyAuthenticatorAppCodeEntered();
});

When("the user confirms 2FA setup via authenticator app", () => {
 AccountSettingsPage.confirm2FAAuthenticatorAppSetup();
});

Then("the 2FA setup via authenticator app is confirmed", () => {
 AccountSettingsPage.verify2FAAuthenticatorAppSetupConfirmed();
});

Given("the user has completed 2FA setup via SMS, email, and authenticator app", () => {
 AccountSettingsPage.verify2FASetupCompleted();
});

When("the user checks the 2FA status in user profile", () => {
 AccountSettingsPage.check2FAStatus();
});

Then("the 2FA status shows as enabled", () => {
 AccountSettingsPage.verify2FAStatusEnabled();
});