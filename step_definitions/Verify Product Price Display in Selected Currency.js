import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SettingsPage from "../pages/settingsPage";
import ProductCatalogPage from "../pages/productCatalogPage";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into the application", () => {
 cy.login();
});

When("the user navigates to the user settings page", () => {
 SettingsPage.visit();
});

Then("the user settings page is displayed", () => {
 SettingsPage.verifyPageDisplayed();
});

Then("the preferred currency is set to EUR", () => {
 SettingsPage.verifyPreferredCurrency("EUR");
});

Then("the currency selection feature is enabled", () => {
 SettingsPage.verifyCurrencySelectionEnabled();
});

Given("the currency selection dropdown is visible", () => {
 SettingsPage.verifyCurrencyDropdownVisible();
});

When("the user selects 'EUR' from the currency dropdown", () => {
 SettingsPage.selectCurrency("EUR");
});

Then("EUR is selected as the preferred currency", () => {
 SettingsPage.verifyPreferredCurrency("EUR");
});

When("the user saves the changes made in the settings", () => {
 SettingsPage.saveChanges();
});

Then("the settings are saved successfully", () => {
 SettingsPage.verifySettingsSaved();
});

When("the user navigates to the product catalog page", () => {
 ProductCatalogPage.visit();
});

Then("the product catalog is displayed", () => {
 ProductCatalogPage.verifyPageDisplayed();
});

Then("product prices are displayed in EUR", () => {
 ProductCatalogPage.verifyPricesInCurrency("EUR");
});

When("the user adds a product to the cart", () => {
 ProductCatalogPage.addProductToCart();
});

Then("the product is added to the cart successfully", () => {
 CartPage.verifyProductAdded();
});

When("the user navigates to the cart page", () => {
 CartPage.visit();
});

Then("the cart page is displayed", () => {
 CartPage.verifyPageDisplayed();
});

Then("the product price in the cart is displayed in EUR", () => {
 CartPage.verifyPriceInCurrency("EUR");
});

When("the user proceeds to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyPageDisplayed();
});

Then("the total price in the checkout page is displayed in EUR", () => {
 CheckoutPage.verifyTotalPriceInCurrency("EUR");
});

When("the user completes the purchase", () => {
 CheckoutPage.completePurchase();
});

Then("the purchase is completed successfully", () => {
 CheckoutPage.verifyPurchaseCompleted();
});

When("the user checks the order confirmation email", () => {
 cy.checkOrderConfirmationEmail();
});

Then("the order confirmation email displays prices in EUR", () => {
 cy.verifyEmailPricesInCurrency("EUR");
});

When("the user navigates to the order history page", () => {
 OrderHistoryPage.visit();
});

Then("the order history page is displayed", () => {
 OrderHistoryPage.verifyPageDisplayed();
});

Then("the currency in the order details is displayed as EUR", () => {
 OrderHistoryPage.verifyCurrencyInOrderDetails("EUR");
});