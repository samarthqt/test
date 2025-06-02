import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CurrencyPage from "../pages/currencyPage";

Given("the user is on the login page", () => {
 CurrencyPage.visitLoginPage();
});

When("the user logs in to the application", () => {
 CurrencyPage.login();
});

Then("the user is successfully logged in", () => {
 CurrencyPage.verifyLogin();
});

Given("the user is logged in", () => {
 CurrencyPage.ensureLoggedIn();
});

When("the user navigates to the currency settings page", () => {
 CurrencyPage.navigateToCurrencySettings();
});

Then("the currency settings page is displayed", () => {
 CurrencyPage.verifyCurrencySettingsPage();
});

Given("the user is on the currency settings page", () => {
 CurrencyPage.ensureOnCurrencySettingsPage();
});

When("the user selects a different currency from the default", () => {
 CurrencyPage.selectDifferentCurrency();
});

Then("the currency selection is updated", () => {
 CurrencyPage.verifyCurrencySelectionUpdate();
});

Given("the user has selected a different currency", () => {
 CurrencyPage.ensureCurrencySelected();
});

When("the application updates prices", () => {
 CurrencyPage.updatePrices();
});

Then("prices are displayed in the selected currency", () => {
 CurrencyPage.verifyPricesInSelectedCurrency();
});

When("the application displays product prices", () => {
 CurrencyPage.displayProductPrices();
});

Then("all product prices are correctly converted", () => {
 CurrencyPage.verifyProductPriceConversion();
});

When("the application displays currency symbols", () => {
 CurrencyPage.displayCurrencySymbols();
});

Then("currency symbols are displayed correctly", () => {
 CurrencyPage.verifyCurrencySymbols();
});

When("the user views transaction amounts", () => {
 CurrencyPage.viewTransactionAmounts();
});

Then("transaction amounts are in the selected currency", () => {
 CurrencyPage.verifyTransactionAmounts();
});

When("the user logs out and logs back in", () => {
 CurrencyPage.logoutAndLogin();
});

Then("the selected currency persists after re-login", () => {
 CurrencyPage.verifyCurrencyPersistence();
});

When("the user accesses the application on different devices", () => {
 CurrencyPage.accessOnDifferentDevices();
});

Then("currency settings are consistent across different devices", () => {
 CurrencyPage.verifyCurrencyConsistencyDevices();
});

When("the user accesses the application on different browsers", () => {
 CurrencyPage.accessOnDifferentBrowsers();
});

Then("currency settings are consistent across different browsers", () => {
 CurrencyPage.verifyCurrencyConsistencyBrowsers();
});

When("the user accesses the mobile app", () => {
 CurrencyPage.accessMobileApp();
});

Then("currency settings are accessible on the mobile app", () => {
 CurrencyPage.verifyCurrencySettingsMobileApp();
});

When("the application performs currency conversion", () => {
 CurrencyPage.performCurrencyConversion();
});

Then("no discrepancies in currency conversion rates are found", () => {
 CurrencyPage.verifyCurrencyConversionRates();
});

When("the user interacts with the application", () => {
 CurrencyPage.interactWithApplication();
});

Then("application performance remains unaffected by currency selection", () => {
 CurrencyPage.verifyApplicationPerformance();
});

When("the user switches back to the default currency", () => {
 CurrencyPage.switchToDefaultCurrency();
});

Then("currency can be switched back to the default successfully", () => {
 CurrencyPage.verifySwitchBackToDefaultCurrency();
});

Given("the user selects an unsupported currency", () => {
 CurrencyPage.selectUnsupportedCurrency();
});

When("the application processes the currency selection", () => {
 CurrencyPage.processCurrencySelection();
});

Then("the system provides a fallback or notification for unsupported currencies", () => {
 CurrencyPage.verifyUnsupportedCurrencyHandling();
});