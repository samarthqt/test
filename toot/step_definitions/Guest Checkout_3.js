import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GuestCheckoutPage from "../pages/guestCheckoutPage";

Given("the online store is open", () => {
 GuestCheckoutPage.visit();
});

Given("the user is on the shopping cart page with items added", () => {
 GuestCheckoutPage.verifyCartPage();
});

Given("the user opts for guest checkout", () => {
 GuestCheckoutPage.selectGuestCheckout();
});

When("the user enters valid shipping information", () => {
 GuestCheckoutPage.enterValidShippingInfo();
});

When("the user enters invalid shipping information", () => {
 GuestCheckoutPage.enterInvalidShippingInfo();
});

When("the user enters valid payment information", () => {
 GuestCheckoutPage.enterValidPaymentInfo();
});

When("the user enters invalid payment information", () => {
 GuestCheckoutPage.enterInvalidPaymentInfo();
});

When("the user leaves mandatory fields empty", () => {
 GuestCheckoutPage.leaveMandatoryFieldsEmpty();
});

When("the user fills in only the mandatory fields", () => {
 GuestCheckoutPage.fillMandatoryFieldsOnly();
});

When("the user reviews the order summary", () => {
 GuestCheckoutPage.reviewOrderSummary();
});

When("the user enters a valid promotional code", () => {
 GuestCheckoutPage.enterValidPromoCode();
});

When("the user enters an expired promotional code", () => {
 GuestCheckoutPage.enterExpiredPromoCode();
});

Then("the user should be able to place the order successfully", () => {
 GuestCheckoutPage.placeOrder();
});

Then("the user receives an order confirmation with details", () => {
 GuestCheckoutPage.verifyOrderConfirmation();
});

Then("the user should see an error message for invalid shipping details", () => {
 GuestCheckoutPage.verifyShippingError();
});

Then("the user should not be able to proceed to payment", () => {
 GuestCheckoutPage.verifyCannotProceedToPayment();
});

Then("the user should see an error message for invalid payment details", () => {
 GuestCheckoutPage.verifyPaymentError();
});

Then("the user should not be able to place the order", () => {
 GuestCheckoutPage.verifyCannotPlaceOrder();
});

Then("the user should see an error message indicating the required fields", () => {
 GuestCheckoutPage.verifyMandatoryFieldsError();
});

Then("the user should not be able to proceed to the next step", () => {
 GuestCheckoutPage.verifyCannotProceedToNextStep();
});

Then("the user should be able to proceed with the checkout", () => {
 GuestCheckoutPage.verifyProceedWithCheckout();
});

Then("the user should not be prompted to fill optional fields", () => {
 GuestCheckoutPage.verifyNoOptionalFieldsPrompt();
});

Then("the discount should be applied to the order total", () => {
 GuestCheckoutPage.verifyDiscountApplied();
});

Then("the user should see the updated order total", () => {
 GuestCheckoutPage.verifyUpdatedOrderTotal();
});

Then("the user should see an error message for the expired code", () => {
 GuestCheckoutPage.verifyExpiredCodeError();
});

Then("the order total should not reflect any discount", () => {
 GuestCheckoutPage.verifyNoDiscountOnTotal();
});