import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LocalizationPage from "../pages/localizationPage";

Given("the application supports multiple languages and currencies", () => {
 LocalizationPage.verifySupportForLanguagesAndCurrencies();
});

When("a user selects a preferred language and currency", () => {
 LocalizationPage.selectLanguageAndCurrency();
});

Then("the application should display content in the selected language", () => {
 LocalizationPage.verifyContentLanguage();
});

Then("prices should be shown in the selected currency", () => {
 LocalizationPage.verifyCurrencyDisplay();
});

Given("the application supports region-based content adjustment", () => {
 LocalizationPage.verifyRegionSupport();
});

When("a user accesses the application from a specific region", () => {
 LocalizationPage.accessFromRegion();
});

Then("the content should be adjusted to match the user's region", () => {
 LocalizationPage.verifyRegionContent();
});

Given("the application supports currency conversion", () => {
 LocalizationPage.verifyCurrencyConversionSupport();
});

When("a user views prices in a different currency", () => {
 LocalizationPage.viewPricesInDifferentCurrency();
});

Then("the currency conversion should be accurate and up-to-date", () => {
 LocalizationPage.verifyCurrencyConversionAccuracy();
});

Given("the application supports multiple language translations", () => {
 LocalizationPage.verifyLanguageTranslationSupport();
});

When("a user selects a language", () => {
 LocalizationPage.selectLanguage();
});

Then("the translations should be accurate and enhance the user experience", () => {
 LocalizationPage.verifyTranslationAccuracy();
});

Given("the application supports localization", () => {
 LocalizationPage.verifyLocalizationSupport();
});

When("a user changes the language or currency", () => {
 LocalizationPage.changeLanguageOrCurrency();
});

Then("the interface should remain responsive and support localization", () => {
 LocalizationPage.verifyInterfaceResponsiveness();
});

When("a user selects an invalid language or currency", () => {
 LocalizationPage.selectInvalidLanguageOrCurrency();
});

Then("an error message should be displayed", () => {
 LocalizationPage.verifyErrorMessage();
});

When("a user interacts with localized features", () => {
 LocalizationPage.interactWithLocalizedFeatures();
});

Then("the application should comply with data privacy and security standards", () => {
 LocalizationPage.verifyPrivacyAndSecurityCompliance();
});

Given("the application supports localization logging", () => {
 LocalizationPage.verifyLocalizationLoggingSupport();
});

Then("the interactions should be logged for analytics", () => {
 LocalizationPage.verifyLoggingForAnalytics();
});

Then("the localization should be optimized for performance", () => {
 LocalizationPage.verifyLocalizationPerformance();
});

When("a user wants to switch the language or currency", () => {
 LocalizationPage.switchLanguageOrCurrency();
});

Then("the user should be able to do so easily without any hassle", () => {
 LocalizationPage.verifyEasySwitching();
});