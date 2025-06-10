import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";
import CheckoutPage from "../pages/checkoutPage";

Given("the user has items in the shopping cart", () => {
 ShoppingCartPage.verifyItemsInCart();
});

When("the user adjusts the quantity of a product", () => {
 ShoppingCartPage.adjustProductQuantity();
});

Then("the updated quantity should be reflected in the cart", () => {
 ShoppingCartPage.verifyUpdatedQuantity();
});

Given("the user proceeds to checkout", () => {
 CheckoutPage.proceedToCheckout();
});

When("the user provides valid shipping and billing information", () => {
 CheckoutPage.enterShippingAndBillingInfo();
});

Then("the information should be accepted and allow the user to continue", () => {
 CheckoutPage.verifyInfoAccepted();
});

Given("the user is at the payment options stage of checkout", () => {
 CheckoutPage.verifyAtPaymentOptions();
});

When("the user selects a payment method between credit/debit card and PayPal", () => {
 CheckoutPage.selectPaymentMethod();
});

Then("the selected payment method should be processed correctly", () => {
 CheckoutPage.verifyPaymentProcessed();
});

Given("the user has completed the checkout process", () => {
 CheckoutPage.verifyCheckoutComplete();
});

When("the order is confirmed", () => {
 CheckoutPage.confirmOrder();
});

Then("the user should receive an order confirmation via email and/or SMS", () => {
 CheckoutPage.verifyOrderConfirmation();
});

Given("the user enters payment information", () => {
 CheckoutPage.enterPaymentInformation();
});

When("the payment is processed", () => {
 CheckoutPage.processPayment();
});

Then("the payment data should be securely transmitted and stored", () => {
 CheckoutPage.verifyPaymentSecurity();
});

Given("the user encounters an error during checkout", () => {
 CheckoutPage.simulateError();
});

When("the error occurs", () => {
 CheckoutPage.triggerError();
});

Then("an appropriate error message should be displayed to the user", () => {
 CheckoutPage.verifyErrorMessage();
});

Given("the user completes a checkout", () => {
 CheckoutPage.completeCheckout();
});

When("the checkout process is finalized", () => {
 CheckoutPage.finalizeCheckout();
});

Then("the system should log the checkout activities", () => {
 CheckoutPage.verifyCheckoutLogging();
});

Given("the user selects a payment method", () => {
 CheckoutPage.selectPayment();
});

When("the payment is processed through a gateway", () => {
 CheckoutPage.processPaymentThroughGateway();
});

Then("the integration with the payment gateway should be seamless", () => {
 CheckoutPage.verifyGatewayIntegration();
});

Given("there are changes to the user's checkout status", () => {
 CheckoutPage.simulateCheckoutStatusChange();
});

When("a change occurs", () => {
 CheckoutPage.triggerStatusChange();
});

Then("the user should be notified of the changes", () => {
 CheckoutPage.verifyUserNotification();
});

Given("the user proceeds through the checkout process", () => {
 CheckoutPage.proceedThroughCheckout();
});

When("they interact with all features", () => {
 CheckoutPage.interactWithAllFeatures();
});

Then("each feature should function correctly and reliably", () => {
 CheckoutPage.verifyAllFeaturesFunctionality();
});