import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("payment methods are displayed", () => {
 CheckoutPage.displayPaymentMethods();
});

Then("the user should be able to select a payment method", () => {
 CheckoutPage.selectPaymentMethod();
});

Given("the user has selected a payment method", () => {
 CheckoutPage.selectPaymentMethod();
});

When("the payment is processed", () => {
 CheckoutPage.processPayment();
});

Then("an order confirmation should be generated", () => {
 CheckoutPage.verifyOrderConfirmation();
});

When("the user completes the checkout process for {string}", (scenario) => {
 CheckoutPage.completeCheckout(scenario);
});

Then("the checkout should be successful", () => {
 CheckoutPage.verifyCheckoutSuccess();
});

When("the payment attempt fails", () => {
 CheckoutPage.failPaymentAttempt();
});

Then("an error message should be displayed", () => {
 CheckoutPage.verifyErrorMessage();
});

Then("the user should be able to retry the payment", () => {
 CheckoutPage.retryPayment();
});

Then("the user interface should display all checkout steps clearly", () => {
 CheckoutPage.verifyCheckoutStepsDisplay();
});

When("the user completes the checkout process", () => {
 CheckoutPage.completeCheckout();
});

Then("all checkout activities should be logged for auditing", () => {
 CheckoutPage.verifyLoggingForAuditing();
});

Given("the user has completed the checkout process", () => {
 CheckoutPage.completeCheckout();
});

Then("the order should be integrated with the order management system", () => {
 CheckoutPage.verifyOrderIntegration();
});

Then("the checkout process should comply with payment and security standards", () => {
 CheckoutPage.verifyComplianceWithStandards();
});