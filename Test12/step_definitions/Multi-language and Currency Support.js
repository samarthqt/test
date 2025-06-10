import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LocalizationPage from "../pages/localizationPage";

Given("the application is launched", () => {
 LocalizationPage.launchApp();
});

When("the user navigates to the language settings", () => {
 LocalizationPage.navigateToLanguageSettings();
});

Then("the user should see a list of available languages", () => {
 LocalizationPage.verifyLanguageList();
});

Then("the application should display the interface in the selected language", () => {
 LocalizationPage.verifyInterfaceLanguage();
});

When("the user navigates to the currency settings", () => {
 LocalizationPage.navigateToCurrencySettings();
});

Then("the system should automatically detect and set the currency based on the user's region", () => {
 LocalizationPage.verifyCurrencyDetection();
});

When("the user navigates to the settings", () => {
 LocalizationPage.navigateToSettings();
});

When("selects their preferred language and currency", () => {
 LocalizationPage.selectPreferredLanguageAndCurrency();
});

Then("the application should update the interface to the selected language", () => {
 LocalizationPage.verifyUpdatedInterfaceLanguage();
});

Then("display prices in the selected currency", () => {
 LocalizationPage.verifyPricesInSelectedCurrency();
});

When("there is a localization error", () => {
 LocalizationPage.simulateLocalizationError();
});

Then("the application should display an error message", () => {
 LocalizationPage.verifyErrorMessage();
});

Then("allow the user to continue using the application", () => {
 LocalizationPage.verifyContinuedUsage();
});

When("the user switches between languages and currencies", () => {
 LocalizationPage.switchLanguagesAndCurrencies();
});

Then("the data displayed should remain consistent", () => {
 LocalizationPage.verifyDataConsistency();
});

Then("the language and currency selection interface should be intuitive and easy to use", () => {
 LocalizationPage.verifySelectionInterface();
});

When("the user changes language or currency settings", () => {
 LocalizationPage.changeLanguageOrCurrencySettings();
});

Then("the system should log these interactions for tracking purposes", () => {
 LocalizationPage.verifyLoggingInteractions();
});

Then("the application should update these settings in real-time without requiring a restart", () => {
 LocalizationPage.verifyRealTimeUpdates();
});

Given("the application is launched on a desktop or mobile device", () => {
 LocalizationPage.launchAppOnDevice();
});

Then("the application should support localization features consistently across both platforms", () => {
 LocalizationPage.verifyCrossPlatformSupport();
});