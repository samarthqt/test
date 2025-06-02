import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserSettingsPage from "../pages/userSettingsPage";

Given("User is logged into the application", () => {
 // Assume user is already logged in for this scenario
});

When("User navigates to the user settings page", () => {
 UserSettingsPage.navigateToSettings();
});

Then("User settings page is displayed", () => {
 UserSettingsPage.verifySettingsPageDisplayed();
});

Then("Language and currency selection feature is enabled", () => {
 UserSettingsPage.verifyLanguageCurrencyFeatureEnabled();
});

When("User locates the language selection dropdown", () => {
 UserSettingsPage.locateLanguageDropdown();
});

Then("Language selection dropdown is visible", () => {
 UserSettingsPage.verifyLanguageDropdownVisible();
});

When("User selects 'English' from the language dropdown", () => {
 UserSettingsPage.selectLanguage('English');
});

Then("English is selected as the preferred language", () => {
 UserSettingsPage.verifySelectedLanguage('English');
});

When("User locates the currency selection dropdown", () => {
 UserSettingsPage.locateCurrencyDropdown();
});

Then("Currency selection dropdown is visible", () => {
 UserSettingsPage.verifyCurrencyDropdownVisible();
});

When("User selects 'USD' from the currency dropdown", () => {
 UserSettingsPage.selectCurrency('USD');
});

Then("USD is selected as the preferred currency", () => {
 UserSettingsPage.verifySelectedCurrency('USD');
});

When("User saves the changes made in the settings", () => {
 UserSettingsPage.saveChanges();
});

Then("Settings are saved successfully", () => {
 UserSettingsPage.verifySettingsSaved();
});

When("User refreshes the page or navigates to another page", () => {
 cy.reload();
});

Then("Selected language and currency persist after refresh", () => {
 UserSettingsPage.verifyLanguageCurrencyPersistence();
});

When("User logs out and logs back into the application", () => {
 UserSettingsPage.logoutAndLogin();
});

Then("Selected language and currency settings persist after re-login", () => {
 UserSettingsPage.verifyLanguageCurrencyPersistence();
});

When("User navigates to the product catalog page", () => {
 UserSettingsPage.navigateToCatalog();
});

Then("Product catalog is displayed in the selected language", () => {
 UserSettingsPage.verifyCatalogLanguage();
});

When("User checks the product prices on the catalog page", () => {
 UserSettingsPage.checkProductPrices();
});

Then("Product prices are displayed in the selected currency", () => {
 UserSettingsPage.verifyProductPricesCurrency();
});

When("User navigates to the checkout page", () => {
 UserSettingsPage.navigateToCheckout();
});

Then("Checkout page is displayed in the selected language", () => {
 UserSettingsPage.verifyCheckoutLanguage();
});

When("User verifies the currency displayed on the checkout page", () => {
 UserSettingsPage.verifyCheckoutCurrency();
});

Then("Currency displayed on the checkout page matches the selected currency", () => {
 UserSettingsPage.verifyCheckoutCurrency();
});

When("User navigates to the user profile page", () => {
 UserSettingsPage.navigateToProfile();
});

Then("User profile page is displayed in the selected language", () => {
 UserSettingsPage.verifyProfileLanguage();
});

When("User verifies the currency settings in the user profile", () => {
 UserSettingsPage.verifyProfileCurrency();
});

Then("Currency settings in the user profile match the selected currency", () => {
 UserSettingsPage.verifyProfileCurrency();
});

When("User performs a search for products", () => {
 UserSettingsPage.performProductSearch();
});

Then("Search results are displayed in the selected language and currency", () => {
 UserSettingsPage.verifySearchResultsLanguageCurrency();
});