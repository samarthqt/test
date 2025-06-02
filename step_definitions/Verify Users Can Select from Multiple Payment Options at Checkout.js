import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged into the application", () => {
 // Implement login functionality
});

When("the user navigates to the shopping cart", () => {
 CheckoutPage.goToShoppingCart();
});

Then("the shopping cart is displayed with all added items", () => {
 CheckoutPage.verifyShoppingCartItems();
});

Given("the user has items in the shopping cart", () => {
 CheckoutPage.verifyItemsInCart();
});

When("the user proceeds to the checkout page", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the checkout page is displayed with the order summary", () => {
 CheckoutPage.verifyOrderSummary();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

When("the user views the list of available payment options", () => {
 CheckoutPage.viewPaymentOptions();
});

Then("the list includes Credit Card, PayPal, and Gift Card", () => {
 CheckoutPage.verifyPaymentOptionsList();
});

When("the user selects 'Credit Card' as the payment option and enters valid card details", () => {
 CheckoutPage.selectCreditCardOption();
 CheckoutPage.enterCardDetails();
});

Then("the system accepts the card details and proceeds to the next step", () => {
 CheckoutPage.verifyCardDetailsAccepted();
});

When("the user goes back to the payment options and selects 'PayPal'", () => {
 CheckoutPage.selectPayPalOption();
});

Then("the system redirects to the PayPal login page", () => {
 CheckoutPage.verifyRedirectedToPayPal();
});

Given("the user is on the PayPal login page", () => {
 CheckoutPage.verifyOnPayPalLoginPage();
});

When("the user logs in to PayPal and confirms the payment", () => {
 CheckoutPage.loginToPayPal();
 CheckoutPage.confirmPayPalPayment();
});

Then("the payment is confirmed and the order is processed", () => {
 CheckoutPage.verifyPaymentConfirmed();
 CheckoutPage.verifyOrderProcessed();
});

When("the user returns to the payment options and selects 'Gift Card'", () => {
 CheckoutPage.selectGiftCardOption();
});

Then("the system prompts for the gift card code", () => {
 CheckoutPage.verifyGiftCardPrompt();
});

Given("the user is prompted for the gift card code", () => {
 CheckoutPage.verifyGiftCardPrompt();
});

When("the user enters a valid gift card code and applies it", () => {
 CheckoutPage.enterGiftCardCode();
 CheckoutPage.applyGiftCardCode();
});

Then("the gift card code is accepted and the order total is updated", () => {
 CheckoutPage.verifyGiftCardCodeAccepted();
 CheckoutPage.verifyOrderTotalUpdated();
});

Given("the user has selected a payment option", () => {
 CheckoutPage.verifyPaymentOptionSelected();
});

When("the user attempts to place the order", () => {
 CheckoutPage.placeOrder();
});

Then("the order is successfully placed with the selected payment option", () => {
 CheckoutPage.verifyOrderPlaced();
});

Given("the order is successfully placed", () => {
 CheckoutPage.verifyOrderPlaced();
});

When("the user views the order confirmation page", () => {
 CheckoutPage.viewOrderConfirmationPage();
});

Then("the page displays the correct payment option used", () => {
 CheckoutPage.verifyPaymentOptionDisplayed();
});

When("the user checks the email confirmation for the order", () => {
 CheckoutPage.checkEmailConfirmation();
});

Then("the email confirmation includes accurate payment details", () => {
 CheckoutPage.verifyEmailPaymentDetails();
});

When("the user selects an invalid payment option", () => {
 CheckoutPage.selectInvalidPaymentOption();
});

Then("the system displays an appropriate error message", () => {
 CheckoutPage.verifyErrorMessageDisplayed();
});

When("the user tests the responsiveness of the payment options section on different devices", () => {
 CheckoutPage.testResponsiveness();
});

Then("the payment options section is responsive and user-friendly on all devices", () => {
 CheckoutPage.verifyResponsiveness();
});

When("the user enters payment information during checkout", () => {
 CheckoutPage.enterPaymentInformation();
});

Then("the payment information is securely transmitted and stored", () => {
 CheckoutPage.verifyPaymentInformationSecurity();
});

When("the user proceeds through the checkout process with multiple payment options", () => {
 CheckoutPage.proceedThroughCheckout();
});

Then("the checkout process is smooth and efficient", () => {
 CheckoutPage.verifyCheckoutEfficiency();
});