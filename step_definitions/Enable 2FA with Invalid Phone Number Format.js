import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("a user account exists", () => {
 // Assume user is logged in
});

When("the user navigates to the account settings page", () => {
 AccountSettingsPage.visit();
});

Then("the user is directed to the account settings page", () => {
 AccountSettingsPage.verifyOnSettingsPage();
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

Given("the 2FA settings section is visible", () => {
 AccountSettingsPage.verify2FASectionVisible();
});

When("the user enters an invalid phone number format {string} in the phone number field", (phoneNumber) => {
 AccountSettingsPage.enterPhoneNumber(phoneNumber);
});

Then("the phone number field accepts the input", () => {
 AccountSettingsPage.verifyPhoneNumberFieldAcceptsInput();
});

Given("the user has entered an invalid phone number format", () => {
 AccountSettingsPage.enterPhoneNumber("12345");
});

When("the user attempts to enable 2FA using the invalid phone number", () => {
 AccountSettingsPage.attemptToEnable2FA();
});

Then("an error message is displayed indicating invalid phone number format", () => {
 AccountSettingsPage.verifyErrorMessageDisplayed();
});

Given("an error message is displayed", () => {
 AccountSettingsPage.verifyErrorMessageDisplayed();
});

Then("the error message suggests the correct phone number format", () => {
 AccountSettingsPage.verifyErrorMessageSuggestsCorrectFormat();
});

Given("the user has tried different invalid phone number formats", () => {
 AccountSettingsPage.tryDifferentInvalidPhoneFormats();
});

When("the user observes the error handling", () => {
 AccountSettingsPage.observeErrorHandling();
});

Then("consistent error handling is observed for all invalid formats", () => {
 AccountSettingsPage.verifyConsistentErrorHandling();
});

Given("an error event occurs", () => {
 AccountSettingsPage.triggerErrorEvent();
});

Then("the error event is logged in the system", () => {
 AccountSettingsPage.verifyErrorEventLogged();
});

Given("an invalid phone number format is entered", () => {
 AccountSettingsPage.enterPhoneNumber("12345");
});

When("the user checks the 2FA settings", () => {
 AccountSettingsPage.check2FASettings();
});

Then("the 2FA settings remain unchanged", () => {
 AccountSettingsPage.verify2FASettingsUnchanged();
});

When("the user attempts to save the invalid phone number", () => {
 AccountSettingsPage.attemptToSavePhoneNumber();
});

Then("the system prevents saving and displays an error", () => {
 AccountSettingsPage.verifySavePreventedAndErrorDisplayed();
});

When("the user looks for guidance", () => {
 AccountSettingsPage.lookForGuidance();
});

Then("a help link is available for valid phone number formats", () => {
 AccountSettingsPage.verifyHelpLinkAvailable();
});

When("the user attempts to navigate away from the settings page without correcting the phone number", () => {
 AccountSettingsPage.attemptToNavigateAway();
});

Then("the system prompts to correct the phone number before leaving", () => {
 AccountSettingsPage.verifyPromptToCorrectBeforeLeaving();
});

Given("previous errors occurred with invalid phone numbers", () => {
 AccountSettingsPage.triggerPreviousErrors();
});

When("the user enters a valid phone number", () => {
 AccountSettingsPage.enterPhoneNumber("+1234567890");
});

Then("2FA is enabled successfully", () => {
 AccountSettingsPage.verify2FAEnabled();
});

Given("an error message needs to be displayed", () => {
 AccountSettingsPage.prepareErrorMessageDisplay();
});

When("an invalid phone number format is entered", () => {
 AccountSettingsPage.enterPhoneNumber("12345");
});

Then("error messages are displayed promptly", () => {
 AccountSettingsPage.verifyErrorDisplayedPromptly();
});

When("the user views the phone number field", () => {
 AccountSettingsPage.viewPhoneNumberField();
});

Then("the invalid phone number field is highlighted", () => {
 AccountSettingsPage.verifyPhoneNumberFieldHighlighted();
});

Given("a valid phone number format is entered with additional invalid characters", () => {
 AccountSettingsPage.enterPhoneNumberWithInvalidCharacters("+123-456-7890abc");
});

When("the user attempts to enable 2FA", () => {
 AccountSettingsPage.attemptToEnable2FA();
});

Then("an error message is displayed for invalid characters", () => {
 AccountSettingsPage.verifyErrorForInvalidCharacters();
});