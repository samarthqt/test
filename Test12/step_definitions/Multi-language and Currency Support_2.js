import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LanguageCurrencyPage from "../pages/languageCurrencyPage";

Given("the user accesses the application", () => {
 LanguageCurrencyPage.visit();
});

When("the application detects the user's region", () => {
 LanguageCurrencyPage.detectRegion();
});

Then("the application should automatically adjust language and currency settings", () => {
 LanguageCurrencyPage.verifyAutomaticAdjustment();
});

When("the user chooses to change language and currency settings manually", () => {
 LanguageCurrencyPage.changeSettingsManually();
});

Then("the application should allow the user to select their preferred language and currency", () => {
 LanguageCurrencyPage.verifyManualSelection();
});

When("the user views currency conversion rates", () => {
 LanguageCurrencyPage.viewConversionRates();
});

Then("the system should provide accurate currency conversion rates", () => {
 LanguageCurrencyPage.verifyConversionRates();
});

When("the user selects a language and region", () => {
 LanguageCurrencyPage.selectLanguageRegion();
});

Then("all text and currency formats must be appropriately displayed according to the selected language and region", () => {
 LanguageCurrencyPage.verifyDisplayFormats();
});

When("the user selects an unsupported language or currency", () => {
 LanguageCurrencyPage.selectUnsupportedLanguageCurrency();
});

Then("the application should display an error message indicating the unsupported selection", () => {
 LanguageCurrencyPage.verifyErrorMessage();
});

When("language and currency conversion is performed", () => {
 LanguageCurrencyPage.performConversion();
});

Then("security measures should ensure data integrity during the conversion process", () => {
 LanguageCurrencyPage.verifySecurityMeasures();
});

When("the user changes language and currency settings", () => {
 LanguageCurrencyPage.changeSettings();
});

Then("the application should log these changes for auditing purposes", () => {
 LanguageCurrencyPage.verifyLogging();
});

When("currency conversion is required", () => {
 LanguageCurrencyPage.requireConversion();
});

Then("integration with third-party services for currency conversion must be seamless", () => {
 LanguageCurrencyPage.verifyThirdPartyIntegration();
});

When("the application automatically changes region settings", () => {
 LanguageCurrencyPage.autoChangeRegionSettings();
});

Then("the user should receive notifications about the change", () => {
 LanguageCurrencyPage.verifyNotifications();
});

Given("the application supports multiple languages and currencies", () => {
 LanguageCurrencyPage.verifySupport();
});

When("testing is performed", () => {
 LanguageCurrencyPage.performTesting();
});

Then("functionality should be confirmed across all supported languages and currencies", () => {
 LanguageCurrencyPage.verifyFunctionality();
});