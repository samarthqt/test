import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("a user account exists", () => {
 // Assuming user is already logged in
});

When("the user navigates to the account settings page", () => {
 AccountSettingsPage.visit();
});

Then("the user is directed to the account settings page", () => {
 cy.url().should("include", "/account/settings");
});

Given("the user is on the account settings page", () => {
 AccountSettingsPage.verifyOnSettingsPage();
});

When("the user locates the 2FA settings section", () => {
 AccountSettingsPage.locate2FASection();
});

Then("the 2FA settings section is visible", () => {
 AccountSettingsPage.verify2FASectionVisible();
});

Given("the user is in the 2FA settings section", () => {
 AccountSettingsPage.verifyIn2FASection();
});

When("the user enters an invalid email format \"user@\" in the email field", () => {
 AccountSettingsPage.enterEmail("user@");
});

Then("the email field accepts the input", () => {
 AccountSettingsPage.verifyEmailInputAccepted();
});

Given("the user has entered an invalid email format", () => {
 AccountSettingsPage.enterEmail("user@");
});

When("the user attempts to enable 2FA", () => {
 AccountSettingsPage.enable2FA();
});

Then("an error message is displayed indicating invalid email format", () => {
 AccountSettingsPage.verifyInvalidEmailError();
});

Given("the error message is displayed", () => {
 AccountSettingsPage.verifyInvalidEmailError();
});

When("the user reviews the error message", () => {
 AccountSettingsPage.reviewErrorMessage();
});

Then("the error message suggests the correct email format", () => {
 AccountSettingsPage.verifyErrorMessageSuggestion();
});

When("the user tries different invalid email formats", () => {
 AccountSettingsPage.tryDifferentInvalidEmails();
});

Then("consistent error handling is observed for all invalid formats", () => {
 AccountSettingsPage.verifyConsistentErrorHandling();
});

When("the user checks the system logs", () => {
 AccountSettingsPage.checkSystemLogs();
});

Then("the error event is logged in the system", () => {
 AccountSettingsPage.verifyErrorLogged();
});

When("the user checks the 2FA settings", () => {
 AccountSettingsPage.check2FASettings();
});

Then("the 2FA settings remain unchanged", () => {
 AccountSettingsPage.verify2FASettingsUnchanged();
});

When("the user attempts to save the email", () => {
 AccountSettingsPage.saveEmail();
});

Then("the system prevents saving and displays an error", () => {
 AccountSettingsPage.verifyPreventSaveAndError();
});

When("the user looks for guidance", () => {
 AccountSettingsPage.lookForGuidance();
});

Then("a help link is available for valid email formats", () => {
 AccountSettingsPage.verifyHelpLinkAvailable();
});

When("the user attempts to navigate away from the settings page", () => {
 AccountSettingsPage.navigateAway();
});

Then("the system prompts to correct the email before leaving", () => {
 AccountSettingsPage.verifyPromptBeforeLeaving();
});

Given("previous errors with invalid email formats", () => {
 AccountSettingsPage.enterEmail("user@");
 AccountSettingsPage.enable2FA();
});

When("the user enters a valid email format", () => {
 AccountSettingsPage.enterEmail("user@example.com");
});

Then("2FA is enabled successfully", () => {
 AccountSettingsPage.verify2FAEnabled();
});

Then("error messages are displayed promptly", () => {
 AccountSettingsPage.verifyPromptErrorMessages();
});

When("the user reviews the email field", () => {
 AccountSettingsPage.reviewEmailField();
});

Then("the invalid email field is highlighted", () => {
 AccountSettingsPage.verifyEmailFieldHighlighted();
});

Given("a valid email format with additional invalid characters is entered", () => {
 AccountSettingsPage.enterEmail("user@ex@mple.com");
});

Then("an error message is displayed for invalid characters", () => {
 AccountSettingsPage.verifyInvalidCharactersError();
});