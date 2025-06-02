import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LanguageSettingsPage from "../pages/languageSettingsPage";

Given("the user is logged into the application", () => {
 // Implement login functionality
});

When("the user navigates to the language settings", () => {
 LanguageSettingsPage.navigateToSettings();
});

Then("the language settings screen is displayed", () => {
 LanguageSettingsPage.verifySettingsScreen();
});

Given("the user is on the language settings screen", () => {
 LanguageSettingsPage.verifySettingsScreen();
});

When("the user selects English (LTR) as the current language", () => {
 LanguageSettingsPage.selectLanguage("English");
});

Then("the application interface updates to display in English", () => {
 LanguageSettingsPage.verifyLanguageUpdate("English");
});

Given("the application interface is in English (LTR)", () => {
 LanguageSettingsPage.verifyLanguageUpdate("English");
});

Then("all text is aligned to the left", () => {
 LanguageSettingsPage.verifyTextAlignment("left");
});

And("navigation is from left to right", () => {
 LanguageSettingsPage.verifyNavigationDirection("LTR");
});

When("the user switches the language setting to Arabic (RTL)", () => {
 LanguageSettingsPage.selectLanguage("Arabic");
});

Then("the application interface updates to display in Arabic", () => {
 LanguageSettingsPage.verifyLanguageUpdate("Arabic");
});

Given("the application interface is in Arabic (RTL)", () => {
 LanguageSettingsPage.verifyLanguageUpdate("Arabic");
});

Then("all text is aligned to the right", () => {
 LanguageSettingsPage.verifyTextAlignment("right");
});

And("navigation is from right to left", () => {
 LanguageSettingsPage.verifyNavigationDirection("RTL");
});

When("the user navigates through different application modules", () => {
 LanguageSettingsPage.navigateThroughModules();
});

Then("all modules are accessible and display correctly in RTL format", () => {
 LanguageSettingsPage.verifyModulesInRTL();
});

When("the user switches back to English (LTR)", () => {
 LanguageSettingsPage.selectLanguage("English");
});

Then("the application returns to LTR format with no loss of functionality", () => {
 LanguageSettingsPage.verifyLanguageUpdate("English");
});

Given("the application interface is switched between languages", () => {
 // Assume the interface is switched
});

Then("all user data remains consistent and accessible", () => {
 LanguageSettingsPage.verifyUserDataConsistency();
});

Given("the application supports both RTL and LTR modes", () => {
 // Assume application supports both modes
});

Then("navigation and functionality remain intact in both modes", () => {
 LanguageSettingsPage.verifyFunctionalityInBothModes();
});

When("the user logs out and logs back in", () => {
 // Implement logout and login functionality
});

Then("the selected language persists after logout and login", () => {
 LanguageSettingsPage.verifyLanguagePersistence();
});

Then("input fields reflect the correct text direction based on language setting", () => {
 LanguageSettingsPage.verifyInputFieldsDirection();
});

Then("error messages and alerts are displayed correctly in the selected language", () => {
 LanguageSettingsPage.verifyErrorMessagesAndAlerts();
});

Then("application layout remains responsive and intact during and after language switch", () => {
 LanguageSettingsPage.verifyLayoutIntegrity();
});

Then("language switch functions correctly across various devices and screen sizes", () => {
 LanguageSettingsPage.verifyLanguageSwitchAcrossDevices();
});

Then("session and security settings remain unaffected by language switch", () => {
 LanguageSettingsPage.verifySessionAndSecurity();
});