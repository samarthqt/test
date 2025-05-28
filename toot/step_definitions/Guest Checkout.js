import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GuestCheckoutPage from "../pages/guestCheckoutPage";

Given("I have items in my shopping cart", () => {
 GuestCheckoutPage.verifyItemsInCart();
});

When("I proceed to checkout", () => {
 GuestCheckoutPage.proceedToCheckout();
});

When("I select the option to checkout as a guest", () => {
 GuestCheckoutPage.selectGuestCheckoutOption();
});

When("I enter my shipping and payment information", () => {
 GuestCheckoutPage.enterShippingInformation();
 GuestCheckoutPage.enterPaymentInformation();
});

When("I enter my shipping information", () => {
 GuestCheckoutPage.enterShippingInformation();
});

When("I enter invalid payment information", () => {
 GuestCheckoutPage.enterInvalidPaymentInformation();
});

When("I leave the shipping information blank", () => {
 GuestCheckoutPage.leaveShippingInformationBlank();
});

When("I enter an invalid email format", () => {
 GuestCheckoutPage.enterInvalidEmailFormat();
});

When("I choose to create an account with the provided information", () => {
 GuestCheckoutPage.chooseAccountCreation();
});

When("I review my order", () => {
 GuestCheckoutPage.reviewOrder();
});

When("I confirm the order", () => {
 GuestCheckoutPage.confirmOrder();
});

When("I attempt to confirm the order", () => {
 GuestCheckoutPage.attemptToConfirmOrder();
});

Then("I should see a confirmation message", () => {
 GuestCheckoutPage.verifyConfirmationMessage();
});

Then("I should receive an order confirmation email", () => {
 GuestCheckoutPage.verifyOrderConfirmationEmail();
});

Then("I should see an error message indicating payment failure", () => {
 GuestCheckoutPage.verifyPaymentFailureMessage();
});

Then("I should see an error message indicating missing shipping information", () => {
 GuestCheckoutPage.verifyMissingShippingInformationMessage();
});

Then("I should see an error message indicating invalid email format", () => {
 GuestCheckoutPage.verifyInvalidEmailFormatMessage();
});

Then("I should receive an account creation confirmation email", () => {
 GuestCheckoutPage.verifyAccountCreationEmail();
});