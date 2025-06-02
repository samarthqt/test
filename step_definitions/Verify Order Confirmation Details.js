import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderConfirmationPage from "../pages/orderConfirmationPage";

Given("the user has completed a purchase transaction", () => {
 // Assume the purchase transaction is completed
});

When("the user navigates to the order confirmation page", () => {
 OrderConfirmationPage.visit();
});

Then("the order confirmation page is displayed", () => {
 OrderConfirmationPage.verifyPageIsDisplayed();
});

Given("the user is on the order confirmation page", () => {
 OrderConfirmationPage.visit();
});

Then("the order number {string} is displayed", (orderNumber) => {
 OrderConfirmationPage.verifyOrderNumber(orderNumber);
});

Then("the shipping address {string} is displayed", (address) => {
 OrderConfirmationPage.verifyShippingAddress(address);
});

Then("the items {string} are listed", (items) => {
 OrderConfirmationPage.verifyItemsListed(items);
});

Then("the item quantities match the purchase order", () => {
 OrderConfirmationPage.verifyItemQuantities();
});

Then("the item prices are accurate as per the purchase order", () => {
 OrderConfirmationPage.verifyItemPrices();
});

Then("the total amount matches the purchase order", () => {
 OrderConfirmationPage.verifyTotalAmount();
});

Then("the estimated delivery date is displayed", () => {
 OrderConfirmationPage.verifyEstimatedDeliveryDate();
});

Then("the payment method is displayed", () => {
 OrderConfirmationPage.verifyPaymentMethod();
});

Then("customer support contact information is displayed", () => {
 OrderConfirmationPage.verifyCustomerSupportInfo();
});

Then("a tracking link is available", () => {
 OrderConfirmationPage.verifyTrackingLink();
});

Then("the page layout is clear and information is easily readable", () => {
 OrderConfirmationPage.verifyPageLayout();
});

Then("a print option is available", () => {
 OrderConfirmationPage.verifyPrintOption();
});

Then("an email option is available", () => {
 OrderConfirmationPage.verifyEmailOption();
});

Then("promotional offers or discounts are displayed if applicable", () => {
 OrderConfirmationPage.verifyPromotionalOffers();
});