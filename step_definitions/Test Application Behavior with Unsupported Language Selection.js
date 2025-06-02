import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserSettingsPage from "../pages/userSettingsPage";

Given("User is logged into the application", () => {
 UserSettingsPage.login();
});

When("User navigates to the user settings page", () => {
 UserSettingsPage.navigateToSettings();
});

Then("User settings page is displayed", () => {
 UserSettingsPage.verifySettingsPageDisplayed();
});

Then("Language selection feature is enabled", () => {
 UserSettingsPage.verifyLanguageFeatureEnabled();
});

Given("User is on the user settings page", () => {
 UserSettingsPage.verifyOnSettingsPage();
});

When("User locates the language selection dropdown", () => {
 UserSettingsPage.locateLanguageDropdown();
});

Then("Language selection dropdown is visible", () => {
 UserSettingsPage.verifyLanguageDropdownVisible();
});

Given("User is viewing the language selection dropdown", () => {
 UserSettingsPage.viewLanguageDropdown();
});

When("User attempts to select 'Klingon' from the dropdown", () => {
 UserSettingsPage.selectUnsupportedLanguage('Klingon');
});

Then("System does not allow selection of unsupported language", () => {
 UserSettingsPage.verifyUnsupportedLanguageNotSelectable();
});

Given("User attempted to select an unsupported language", () => {
 UserSettingsPage.attemptedUnsupportedLanguageSelection();
});

When("User checks for error messages", () => {
 UserSettingsPage.checkForErrorMessages();
});

Then("Appropriate error message is displayed indicating unsupported language", () => {
 UserSettingsPage.verifyErrorMessageForUnsupportedLanguage();
});

Given("User has selected an unsupported language", () => {
 UserSettingsPage.selectUnsupportedLanguage();
});

When("User attempts to save changes", () => {
 UserSettingsPage.attemptToSaveChanges();
});

Then("Changes are not saved", () => {
 UserSettingsPage.verifyChangesNotSaved();
});

Then("User is prompted to select a supported language", () => {
 UserSettingsPage.promptForSupportedLanguage();
});

Given("User selects a supported language", () => {
 UserSettingsPage.selectSupportedLanguage();
});

When("User saves changes", () => {
 UserSettingsPage.saveChanges();
});

Then("Changes are saved successfully with a supported language", () => {
 UserSettingsPage.verifyChangesSavedSuccessfully();
});

Given("User has saved changes with a supported language", () => {
 UserSettingsPage.savedChangesWithSupportedLanguage();
});

When("User refreshes the page or navigates to another page", () => {
 UserSettingsPage.refreshOrNavigate();
});

Then("Interface text is displayed in the selected supported language", () => {
 UserSettingsPage.verifyInterfaceTextInSupportedLanguage();
});

Given("User is logged in with a supported language", () => {
 UserSettingsPage.loggedInWithSupportedLanguage();
});

When("User logs out and logs back into the application", () => {
 UserSettingsPage.logoutAndLogin();
});

Then("Login page and subsequent pages are displayed in the selected supported language", () => {
 UserSettingsPage.verifyPagesInSupportedLanguage();
});

Given("User is logged in", () => {
 UserSettingsPage.loggedIn();
});

When("User attempts to manually change URL parameters to set an unsupported language", () => {
 UserSettingsPage.attemptUrlManipulationForLanguage();
});

Then("System prevents setting of unsupported language via URL manipulation", () => {
 UserSettingsPage.verifyUrlManipulationPrevention();
});

Given("User attempted to set an unsupported language", () => {
 UserSettingsPage.attemptedUnsupportedLanguageSetting();
});

When("User checks the default language setting", () => {
 UserSettingsPage.checkDefaultLanguageSetting();
});

Then("System reverts to default language setting", () => {
 UserSettingsPage.verifyDefaultLanguageSetting();
});

When("User checks the language settings in the user profile", () => {
 UserSettingsPage.checkLanguageSettingsInProfile();
});

Then("Language settings reflect a supported language", () => {
 UserSettingsPage.verifyLanguageSettingsSupported();
});

When("User performs a product search", () => {
 UserSettingsPage.performProductSearch();
});

Then("Search results are displayed in the supported language", () => {
 UserSettingsPage.verifySearchResultsInSupportedLanguage();
});

When("User navigates to the help section", () => {
 UserSettingsPage.navigateToHelpSection();
});

Then("Help section is displayed in the supported language", () => {
 UserSettingsPage.verifyHelpSectionInSupportedLanguage();
});

Given("User is on the language selection page", () => {
 UserSettingsPage.onLanguageSelectionPage();
});

When("User attempts to select multiple unsupported languages simultaneously", () => {
 UserSettingsPage.attemptMultipleUnsupportedLanguages();
});

Then("System does not allow selection of multiple unsupported languages", () => {
 UserSettingsPage.verifyMultipleUnsupportedLanguagesNotAllowed();
});

Given("User attempted unsupported language selection", () => {
 UserSettingsPage.attemptedUnsupportedLanguageSelection();
});

When("User verifies system logs", () => {
 UserSettingsPage.verifySystemLogs();
});

Then("System logs indicate handling of unsupported language selection without errors", () => {
 UserSettingsPage.verifyLogsForUnsupportedLanguageHandling();
});