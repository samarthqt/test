import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SettingsPage from "../pages/settingsPage";

Given("the user is on the settings page", () => {
  SettingsPage.visit();
});

When("the user selects a language from the list of supported languages", () => {
  SettingsPage.selectLanguage('Spanish');
});

Then("the system should update the content to the selected language", () => {
  SettingsPage.verifyLanguageChange('Spanish');
});

When("the user selects a currency from the list of supported currencies", () => {
  SettingsPage.selectCurrency('EUR');
});

Then("the system should update the prices to the selected currency", () => {
  SettingsPage.verifyCurrencyChange('EUR');
});

Given("the user has selected a language and currency", () => {
  SettingsPage.selectLanguage('French');
  SettingsPage.selectCurrency('USD');
});

When("the user navigates through the application", () => {
  SettingsPage.navigateApplication();
});

Then("the system should display all content and prices in the selected language and currency", () => {
  SettingsPage.verifyContentAndCurrency('French', 'USD');
});

Given("the user changes the language or currency settings", () => {
  SettingsPage.changeSettings('German', 'GBP');
});

When("the user confirms the changes", () => {
  SettingsPage.confirmChanges();
});

Then("the system should immediately reflect the changes across all interfaces", () => {
  SettingsPage.verifyImmediateChanges('German', 'GBP');
});

Given("the user selects a currency for transactions", () => {
  SettingsPage.selectCurrency('JPY');
});

When("there is a need for currency conversion", () => {
  SettingsPage.triggerCurrencyConversion();
});

Then("the system should apply accurate conversion rates", () => {
  SettingsPage.verifyConversionRates('JPY');
});

Given("the user selects a language or currency not supported by the system", () => {
  SettingsPage.selectUnsupportedLanguageOrCurrency('Klingon', 'Bitcoin');
});

When("the user tries to apply the settings", () => {
  SettingsPage.applyUnsupportedSettings();
});

Then("the system should provide a fallback option to the default language or currency", () => {
  SettingsPage.verifyFallbackToDefault();
});

Given("the user has selected language and currency settings", () => {
  SettingsPage.selectLanguage('Italian');
  SettingsPage.selectCurrency('AUD');
});

When("the user accesses different interfaces of the application", () => {
  SettingsPage.accessDifferentInterfaces();
});

Then("the system should maintain consistency with the selected settings", () => {
  SettingsPage.verifyConsistency('Italian', 'AUD');
});

Given("the user accesses the application on a desktop or mobile device", () => {
  SettingsPage.accessOnDevice();
});

When("the user navigates to the settings page", () => {
  SettingsPage.navigateToSettings();
});

Then("the localization features should be available and functional on both types of devices", () => {
  SettingsPage.verifyLocalizationFeatures();
});