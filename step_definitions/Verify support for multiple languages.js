import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LanguagePage from "../pages/languagePage";

Given("the user is on the login page", () => {
 LanguagePage.visitLoginPage();
});

When("the user logs in with valid credentials", () => {
 LanguagePage.loginWithValidCredentials();
});

Then("the user is successfully logged in", () => {
 LanguagePage.verifySuccessfulLogin();
});

Given("the user is logged in", () => {
 LanguagePage.verifyUserLoggedIn();
});

When("the user navigates to the language settings page", () => {
 LanguagePage.navigateToLanguageSettings();
});

Then("the language settings page is displayed", () => {
 LanguagePage.verifyLanguageSettingsPageDisplayed();
});

Given("the user is on the language settings page", () => {
 LanguagePage.verifyLanguageSettingsPage();
});

When("the user selects a different language from the default", () => {
 LanguagePage.selectDifferentLanguage();
});

Then("the language selection is updated", () => {
 LanguagePage.verifyLanguageSelectionUpdated();
});

Given("the user has selected a different language", () => {
 LanguagePage.verifyDifferentLanguageSelected();
});

When("the user navigates through the application", () => {
 LanguagePage.navigateThroughApplication();
});

Then("the application interface is displayed in the selected language", () => {
 LanguagePage.verifyInterfaceInSelectedLanguage();
});

Given("the application interface is displayed in the selected language", () => {
 LanguagePage.verifyInterfaceDisplayedInSelectedLanguage();
});

When("the user checks the menu items", () => {
 LanguagePage.checkMenuItems();
});

Then("all menu items are correctly translated", () => {
 LanguagePage.verifyMenuItemsTranslated();
});

When("an error occurs", () => {
 LanguagePage.simulateError();
});

Then("error messages are displayed in the selected language", () => {
 LanguagePage.verifyErrorMessagesTranslated();
});

When("the user accesses help and support sections", () => {
 LanguagePage.accessHelpAndSupportSections();
});

Then("help and support sections are correctly translated", () => {
 LanguagePage.verifyHelpAndSupportSectionsTranslated();
});

When("the user views user-submitted content", () => {
 LanguagePage.viewUserSubmittedContent();
});

Then("user-submitted content remains in the original language", () => {
 LanguagePage.verifyUserContentOriginalLanguage();
});

Given("the user has selected a language", () => {
 LanguagePage.verifyLanguageSelected();
});

When("the user logs out and logs back in", () => {
 LanguagePage.logoutAndLogin();
});

Then("the selected language persists after re-login", () => {
 LanguagePage.verifyLanguagePersistsAfterRelogin();
});

When("the user accesses the application on different devices", () => {
 LanguagePage.accessOnDifferentDevices();
});

Then("language settings are consistent across different devices", () => {
 LanguagePage.verifyLanguageConsistencyAcrossDevices();
});

When("the user accesses the application on different browsers", () => {
 LanguagePage.accessOnDifferentBrowsers();
});

Then("language settings are consistent across different browsers", () => {
 LanguagePage.verifyLanguageConsistencyAcrossBrowsers();
});

When("the user accesses the mobile app", () => {
 LanguagePage.accessMobileApp();
});

Then("language settings are accessible on the mobile app", () => {
 LanguagePage.verifyLanguageAccessibilityOnMobileApp();
});

When("the user navigates through the application", () => {
 LanguagePage.navigateThroughApplication();
});

Then("there are no missing translations in the selected language", () => {
 LanguagePage.verifyNoMissingTranslations();
});

When("the user uses the application", () => {
 LanguagePage.useApplication();
});

Then("application performance remains unaffected by language selection", () => {
 LanguagePage.verifyPerformanceUnaffectedByLanguageSelection();
});

When("the user switches back to the default language", () => {
 LanguagePage.switchToDefaultLanguage();
});

Then("the language can be switched back to the default successfully", () => {
 LanguagePage.verifySwitchBackToDefaultLanguage();
});