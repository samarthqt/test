import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderConfirmationPage from "../pages/orderConfirmationPage";

Given("a user completes the checkout process", () => {
 OrderConfirmationPage.completeCheckout();
});

When("the order is placed successfully", () => {
 OrderConfirmationPage.placeOrder();
});

Then("the user should receive an order confirmation via email", () => {
 OrderConfirmationPage.verifyEmailConfirmation();
});

Then("the user should receive an order confirmation via SMS", () => {
 OrderConfirmationPage.verifySmsConfirmation();
});

Given("a user receives an order confirmation", () => {
 OrderConfirmationPage.receiveOrderConfirmation();
});

Then("the confirmation should include the order number", () => {
 OrderConfirmationPage.verifyOrderNumber();
});

Then("the confirmation should include the shipping address", () => {
 OrderConfirmationPage.verifyShippingAddress();
});

Then("the confirmation should include the items purchased", () => {
 OrderConfirmationPage.verifyItemsPurchased();
});

Then("the confirmation should include the estimated delivery date", () => {
 OrderConfirmationPage.verifyEstimatedDeliveryDate();
});

Then("the system should ensure timely delivery of confirmation messages", () => {
 OrderConfirmationPage.ensureTimelyDelivery();
});

Then("the confirmation message should be formatted for easy reading", () => {
 OrderConfirmationPage.verifyMessageFormatting();
});

Then("the user should be able to access order details from the confirmation message", () => {
 OrderConfirmationPage.accessOrderDetails();
});

Then("the system should log the confirmation message for record-keeping", () => {
 OrderConfirmationPage.logConfirmationMessage();
});