import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SettingsPage from "../pages/settingsPage";
import HomePage from "../pages/homePage";
import ProductCatalogPage from "../pages/productCatalogPage";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";
import UserProfilePage from "../pages/userProfilePage";
import OrderHistoryPage from "../pages/orderHistoryPage";
import HelpSectionPage from "../pages/helpSectionPage";
import LoginPage from "../pages/loginPage";

Given("the user is logged into the application", () => {
 cy.login();
});

When("the user navigates to the user settings page", () => {
 SettingsPage.visit();
});

Then("the user settings page is displayed", () => {
 SettingsPage.verifyPageDisplayed();
});

And("the language selection feature is enabled", () => {
 SettingsPage.verifyLanguageFeatureEnabled();
});

When("the user locates the language selection dropdown", () => {
 SettingsPage.locateLanguageDropdown();
});

Then("the language selection dropdown is visible", () => {
 SettingsPage.verifyDropdownVisible();
});

When("the user selects 'Spanish' from the language dropdown", () => {
 SettingsPage.selectLanguage('Spanish');
});

Then("Spanish is selected as the preferred language", () => {
 SettingsPage.verifyLanguageSelected('Spanish');
});

When("the user saves the changes made in the settings", () => {
 SettingsPage.saveChanges();
});

Then("settings are saved successfully", () => {
 SettingsPage.verifySettingsSaved();
});

When("the user refreshes the page or navigates to another page", () => {
 cy.reload();
});

Then("interface text is updated to Spanish", () => {
 SettingsPage.verifyInterfaceTextUpdated('Spanish');
});

When("the user navigates to the home page", () => {
 HomePage.visit();
});

Then("the home page is displayed in Spanish", () => {
 HomePage.verifyPageDisplayedInSpanish();
});

When("the user navigates to the product catalog page", () => {
 ProductCatalogPage.visit();
});

Then("the product catalog is displayed in Spanish", () => {
 ProductCatalogPage.verifyPageDisplayedInSpanish();
});

When("the user navigates to the cart page", () => {
 CartPage.visit();
});

Then("the cart page is displayed in Spanish", () => {
 CartPage.verifyPageDisplayedInSpanish();
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed in Spanish", () => {
 CheckoutPage.verifyPageDisplayedInSpanish();
});

When("the user navigates to the user profile page", () => {
 UserProfilePage.visit();
});

Then("the user profile page is displayed in Spanish", () => {
 UserProfilePage.verifyPageDisplayedInSpanish();
});

When("the user navigates to the order history page", () => {
 OrderHistoryPage.visit();
});

Then("the order history page is displayed in Spanish", () => {
 OrderHistoryPage.verifyPageDisplayedInSpanish();
});

When("the user performs a product search", () => {
 cy.performSearch();
});

Then("search results are displayed in Spanish", () => {
 cy.verifySearchResultsInSpanish();
});

When("the user checks the help section", () => {
 HelpSectionPage.visit();
});

Then("the help section is displayed in Spanish", () => {
 HelpSectionPage.verifyPageDisplayedInSpanish();
});

When("the user logs out and logs back into the application", () => {
 cy.logout();
 cy.login();
});

Then("the login page and subsequent pages are displayed in Spanish", () => {
 LoginPage.verifyPageDisplayedInSpanish();
});

When("the user verifies any error messages displayed", () => {
 cy.verifyErrorMessages();
});

Then("error messages are displayed in Spanish", () => {
 cy.verifyErrorMessagesInSpanish();
});