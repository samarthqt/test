import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

Given("all available payment options are displayed", () => {
 CheckoutPage.verifyPaymentOptionsDisplayed();
});

When("the user proceeds to the payment section", () => {
 CheckoutPage.goToPaymentSection();
});

Then("all available payment options should be displayed", () => {
 CheckoutPage.verifyPaymentOptionsDisplayed();
});

When("the user selects a valid payment method", () => {
 CheckoutPage.selectPaymentMethod("valid");
});

Then("the system should validate the selected payment method", () => {
 CheckoutPage.validateSelectedPaymentMethod();
});

Given("the user has selected a valid payment method", () => {
 CheckoutPage.selectPaymentMethod("valid");
});

When("the payment method is validated successfully", () => {
 CheckoutPage.validateSelectedPaymentMethod();
});

Then("the user should receive a confirmation of successful payment method selection", () => {
 CheckoutPage.verifySuccessfulPaymentConfirmation();
});

Given("the user selects an invalid payment method", () => {
 CheckoutPage.selectPaymentMethod("invalid");
});

When("the system attempts to validate the selected payment method", () => {
 CheckoutPage.validateSelectedPaymentMethod();
});

Then("the user should be prompted to choose another payment option", () => {
 CheckoutPage.promptForAnotherPaymentOption();
});

Given("the user accesses the checkout page on any device", () => {
 CheckoutPage.visit();
});

When("the user navigates to the payment section", () => {
 CheckoutPage.goToPaymentSection();
});

Then("the UI should be intuitive and responsive across all devices", () => {
 CheckoutPage.verifyUIResponsive();
});