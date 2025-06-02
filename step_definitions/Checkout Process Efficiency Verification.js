import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in with valid credentials", () => {
  CheckoutPage.loginWithValidCredentials();
});

Given("the user has a valid payment method saved", () => {
  CheckoutPage.ensureValidPaymentMethod();
});

Given("the server is under high load", () => {
  CheckoutPage.simulateHighServerLoad();
});

Given("multiple items are added to the shopping cart", () => {
  CheckoutPage.addMultipleItemsToCart();
});

Given("the user is logged in with valid credentials on a mobile device", () => {
  CheckoutPage.loginOnMobileDevice();
});

When("the user adds a product to the shopping cart", () => {
  CheckoutPage.addProductToCart();
});

When("the user proceeds to the checkout page", () => {
  CheckoutPage.proceedToCheckout();
});

When("the user enters valid shipping address details", () => {
  CheckoutPage.enterShippingAddress();
});

When("the user selects a valid payment method", () => {
  CheckoutPage.selectPaymentMethod();
});

When("the user confirms the order", () => {
  CheckoutPage.confirmOrder();
});

When("the user completes the checkout process", () => {
  CheckoutPage.completeCheckout();
});

When("the user accesses the checkout page", () => {
  CheckoutPage.accessCheckoutPage();
});

When("the user enters invalid payment details during checkout", () => {
  CheckoutPage.enterInvalidPaymentDetails();
});

When("the user selects different payment methods during checkout", () => {
  CheckoutPage.selectDifferentPaymentMethods();
});

When("the user proceeds to confirm the order", () => {
  CheckoutPage.proceedToConfirmOrder();
});

Then("the user should receive an order confirmation message", () => {
  CheckoutPage.verifyOrderConfirmationMessage();
});

Then("the checkout should be completed with minimal steps", () => {
  CheckoutPage.verifyMinimalStepsCheckout();
});

Then("the checkout should remain responsive and functional", () => {
  CheckoutPage.verifyResponsiveCheckout();
});

Then("all fields should be pre-filled with user's saved data for quick checkout", () => {
  CheckoutPage.verifyPrefilledFields();
});

Then("the checkout process should be seamless on mobile devices", () => {
  CheckoutPage.verifySeamlessMobileCheckout();
});

Then("the system should provide appropriate error messages for invalid payment details", () => {
  CheckoutPage.verifyErrorMessagesForInvalidPayment();
});

Then("the checkout should be successful with various payment methods", () => {
  CheckoutPage.verifySuccessfulCheckoutWithDifferentMethods();
});

Then("the order summary should be displayed clearly before confirmation", () => {
  CheckoutPage.verifyOrderSummaryBeforeConfirmation();
});

Then("the checkout process should handle multiple items efficiently", () => {
  CheckoutPage.verifyMultipleItemsCheckout();
});