import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GuestCheckoutPage from "../pages/guestCheckoutPage";

Given("the user is on the e-commerce website", () => {
 GuestCheckoutPage.visit();
});

Given("the shopping cart contains items", () => {
 GuestCheckoutPage.verifyCartNotEmpty();
});

Given("the user selects \"Checkout as Guest\"", () => {
 GuestCheckoutPage.selectCheckoutAsGuest();
});

When("the user enters valid shipping information", () => {
 GuestCheckoutPage.enterValidShippingInfo();
});

When("the user enters valid payment information", () => {
 GuestCheckoutPage.enterValidPaymentInfo();
});

When("the user reviews the order summary", () => {
 GuestCheckoutPage.reviewOrderSummary();
});

When("the user confirms the purchase", () => {
 GuestCheckoutPage.confirmPurchase();
});

Then("the user should see a confirmation message", () => {
 GuestCheckoutPage.verifyConfirmationMessage();
});

Then("the order should be placed successfully", () => {
 GuestCheckoutPage.verifyOrderPlacedSuccessfully();
});

When("the user enters invalid shipping information", () => {
 GuestCheckoutPage.enterInvalidShippingInfo();
});

Then("the user should see an error message indicating invalid shipping information", () => {
 GuestCheckoutPage.verifyInvalidShippingError();
});

Then("the user should be prompted to correct the shipping information", () => {
 GuestCheckoutPage.promptCorrectShippingInfo();
});

When("the user enters invalid payment information", () => {
 GuestCheckoutPage.enterInvalidPaymentInfo();
});

Then("the user should see an error message indicating invalid payment information", () => {
 GuestCheckoutPage.verifyInvalidPaymentError();
});

Then("the user should be prompted to correct the payment information", () => {
 GuestCheckoutPage.promptCorrectPaymentInfo();
});

When("the user leaves required fields empty", () => {
 GuestCheckoutPage.leaveFieldsEmpty();
});

Then("the user should see an error message indicating missing information", () => {
 GuestCheckoutPage.verifyMissingInfoError();
});

Then("the user should be prompted to complete the required fields", () => {
 GuestCheckoutPage.promptCompleteRequiredFields();
});

When("the user decides to cancel the checkout process", () => {
 GuestCheckoutPage.cancelCheckout();
});

Then("the user should be redirected back to the shopping cart", () => {
 GuestCheckoutPage.verifyRedirectToCart();
});

Then("the items should still be in the shopping cart", () => {
 GuestCheckoutPage.verifyItemsInCart();
});

When("the user enters a valid promotional code", () => {
 GuestCheckoutPage.enterPromotionalCode();
});

When("the user enters valid shipping and payment information", () => {
 GuestCheckoutPage.enterValidShippingAndPaymentInfo();
});

Then("the discount should be applied to the order total", () => {
 GuestCheckoutPage.verifyDiscountApplied();
});