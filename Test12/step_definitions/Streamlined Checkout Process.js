import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("a user has items in their cart", () => {
 CheckoutPage.addItemsToCart();
});

When("the user initiates the checkout process", () => {
 CheckoutPage.initiateCheckout();
});

Then("the checkout should be completed in 5 steps or fewer", () => {
 CheckoutPage.verifyCheckoutSteps(5);
});

Given("a user has completed the checkout process", () => {
 CheckoutPage.completeCheckout();
});

Then("the user should receive confirmation of successful checkout", () => {
 CheckoutPage.verifyCheckoutConfirmation();
});

Given("a user is at the payment step of checkout", () => {
 CheckoutPage.navigateToPaymentStep();
});

Then("payment options should be clearly presented", () => {
 CheckoutPage.verifyPaymentOptions();
});

Given("a user has previously entered shipping information", () => {
 CheckoutPage.enterShippingInformation();
});

When("the user reaches the shipping step of checkout", () => {
 CheckoutPage.navigateToShippingStep();
});

Then("shipping information must be auto-filled", () => {
 CheckoutPage.verifyAutoFilledShippingInfo();
});

When("the user chooses to save their payment method", () => {
 CheckoutPage.savePaymentMethod();
});

Then("the payment method should be saved for future use", () => {
 CheckoutPage.verifyPaymentMethodSaved();
});

Given("a user encounters an error during checkout", () => {
 CheckoutPage.triggerCheckoutError();
});

Then("error handling should guide the user to resolve the issue", () => {
 CheckoutPage.verifyErrorHandling();
});

Given("a user has items in their cart and abandons the checkout process", () => {
 CheckoutPage.abandonCheckout();
});

Then("an abandoned cart notification must be sent to the user", () => {
 CheckoutPage.verifyAbandonedCartNotification();
});

Given("a user navigates to the checkout page", () => {
 CheckoutPage.visitCheckoutPage();
});

Then("the checkout page must load within 3 seconds", () => {
 CheckoutPage.verifyPageLoadTime(3);
});

Given("a user is entering sensitive information during checkout", () => {
 CheckoutPage.enterSensitiveInformation();
});

Then("security measures must be in place to protect user data", () => {
 CheckoutPage.verifySecurityMeasures();
});

Given("the checkout process has been implemented", () => {
 CheckoutPage.implementCheckoutProcess();
});

When("user testing is conducted", () => {
 CheckoutPage.conductUserTesting();
});

Then("the testing should validate the efficiency of the checkout process", () => {
 CheckoutPage.verifyCheckoutEfficiency();
});