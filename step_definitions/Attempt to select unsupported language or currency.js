import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserSettingsPage from "../pages/userSettingsPage";

Given("the user is logged into the application", () => {
  cy.login();
});

When("the user navigates to the user settings page", () => {
  UserSettingsPage.visit();
});

Then("the user settings page is displayed", () => {
  UserSettingsPage.verifyPageDisplayed();
});

When("the user locates the language selection dropdown", () => {
  UserSettingsPage.locateLanguageDropdown();
});

Then("the language dropdown is visible", () => {
  UserSettingsPage.verifyLanguageDropdownVisible();
});

When("the user attempts to select 'Klingon' from the language dropdown", () => {
  UserSettingsPage.selectUnsupportedLanguage();
});

Then("an error message 'Language not supported' is displayed", () => {
  UserSettingsPage.verifyLanguageErrorMessage();
});

When("the user locates the currency selection dropdown", () => {
  UserSettingsPage.locateCurrencyDropdown();
});

Then("the currency dropdown is visible", () => {
  UserSettingsPage.verifyCurrencyDropdownVisible();
});

When("the user attempts to select 'Bitcoin' from the currency dropdown", () => {
  UserSettingsPage.selectUnsupportedCurrency();
});

Then("an error message 'Currency not supported' is displayed", () => {
  UserSettingsPage.verifyCurrencyErrorMessage();
});

Given("the user has attempted to select unsupported language and currency", () => {
  UserSettingsPage.attemptUnsupportedSelections();
});

When("the user attempts to save the changes", () => {
  UserSettingsPage.saveChanges();
});

Then("changes are not saved and error persists", () => {
  UserSettingsPage.verifyChangesNotSaved();
});

When("the user refreshes the page", () => {
  cy.reload();
});

Then("settings revert to last valid selection", () => {
  UserSettingsPage.verifySettingsReverted();
});

When("the user navigates to the home page", () => {
  cy.visit('/home');
});

Then("the home page displays in previously set valid language and currency", () => {
  UserSettingsPage.verifyHomePageSettings();
});

When("the user checks product listings", () => {
  UserSettingsPage.checkProductListings();
});

Then("product prices are displayed in last valid currency", () => {
  UserSettingsPage.verifyProductPrices();
});

When("the user accesses the help section", () => {
  UserSettingsPage.accessHelpSection();
});

Then("the help section is displayed in last valid language", () => {
  UserSettingsPage.verifyHelpSectionLanguage();
});

When("the user logs out and logs back in", () => {
  cy.logout();
  cy.login();
});

Then("language and currency settings persist as last valid selection", () => {
  UserSettingsPage.verifySettingsPersist();
});

When("the user attempts to select a combination of unsupported language and currency", () => {
  UserSettingsPage.selectUnsupportedCombination();
});

Then("error messages for both selections are displayed", () => {
  UserSettingsPage.verifyCombinationErrorMessages();
});

When("the user checks notifications", () => {
  UserSettingsPage.checkNotifications();
});

Then("notifications remain in last valid language", () => {
  UserSettingsPage.verifyNotificationsLanguage();
});

When("the user attempts to enter unsupported values manually", () => {
  UserSettingsPage.enterUnsupportedValues();
});

Then("the system rejects unsupported values with error messages", () => {
  UserSettingsPage.verifyUnsupportedValuesRejection();
});

When("the user checks system logs", () => {
  UserSettingsPage.checkSystemLogs();
});

Then("errors are logged appropriately for unsupported selections", () => {
  UserSettingsPage.verifyErrorLogs();
});