import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("User is logged into the application", () => {
 ShoppingCartPage.login();
});

Given("User navigates to the shopping cart page", () => {
 ShoppingCartPage.visitCart();
});

When("User clicks on the 'Proceed to Checkout' button", () => {
 ShoppingCartPage.proceedToCheckout();
});

When("User selects {string} as the payment method", (paymentMethod) => {
 ShoppingCartPage.selectPaymentMethod(paymentMethod);
});

When("User enters invalid credit card details", () => {
 ShoppingCartPage.enterInvalidCreditCardDetails();
});

When("User attempts to use an expired PayPal account", () => {
 ShoppingCartPage.useExpiredPayPalAccount();
});

When("User attempts to use a Gift Card with depleted balance", () => {
 ShoppingCartPage.useDepletedGiftCard();
});

Then("System displays an error message indicating invalid credit card details", () => {
 ShoppingCartPage.verifyInvalidCreditCardError();
});

Then("System displays an error message indicating account expiration", () => {
 ShoppingCartPage.verifyExpiredPayPalError();
});

Then("System displays an error message indicating insufficient balance", () => {
 ShoppingCartPage.verifyDepletedGiftCardError();
});

Then("System provides options to retry or select a different payment method", () => {
 ShoppingCartPage.verifyRetryOptions();
});

When("User logs out from the user account", () => {
 ShoppingCartPage.logout();
});

Then("User is logged out successfully", () => {
 ShoppingCartPage.verifyLogoutSuccess();
});