import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visitCheckoutPage();
});

Given("the user has items in the cart", () => {
 CheckoutPage.verifyItemsInCart();
});

When("the user chooses to ship to multiple addresses", () => {
 CheckoutPage.selectMultipleShippingAddresses();
});

Then("the user should see an option to select different addresses for each item", () => {
 CheckoutPage.verifyMultipleAddressOption();
});

When("the user adds a new shipping address", () => {
 CheckoutPage.addNewShippingAddress();
});

Then("the new address should be available for selection in the address list", () => {
 CheckoutPage.verifyNewAddressInList();
});

Given("the user has multiple addresses available", () => {
 CheckoutPage.verifyMultipleAddressesAvailable();
});

When("the user assigns different addresses to each item in the order", () => {
 CheckoutPage.assignAddressesToItems();
});

Then("each item should display the assigned address in the order summary", () => {
 CheckoutPage.verifyAssignedAddressesInSummary();
});

Given("the user has assigned different addresses to items", () => {
 CheckoutPage.verifyAddressesAssignedToItems();
});

When("the user reviews the order summary", () => {
 CheckoutPage.reviewOrderSummary();
});

Then("the order summary should display each item with its respective shipping address", () => {
 CheckoutPage.verifyOrderSummaryAddresses();
});

Given("the user has reviewed the order summary", () => {
 CheckoutPage.verifyOrderSummaryReviewed();
});

When("the user confirms the order", () => {
 CheckoutPage.confirmOrder();
});

Then("the order should be processed with items being shipped to their respective addresses", () => {
 CheckoutPage.verifyOrderProcessed();
});

Then("the user should receive a confirmation email with details of each shipment", () => {
 CheckoutPage.verifyConfirmationEmail();
});