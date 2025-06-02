import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderConfirmationPage from "../pages/orderConfirmationPage";

Given("the user has completed a purchase transaction with edge case data", () => {
  OrderConfirmationPage.completePurchaseWithEdgeCaseData();
});

When("the user navigates to the order confirmation page", () => {
  OrderConfirmationPage.navigateToOrderConfirmation();
});

Then("the order confirmation page is displayed", () => {
  OrderConfirmationPage.verifyOrderConfirmationPageDisplayed();
});

Given("the order ID is '99999999999999999999'", () => {
  OrderConfirmationPage.setOrderID('99999999999999999999');
});

Then("the order number '99999999999999999999' is displayed without truncation", () => {
  OrderConfirmationPage.verifyOrderNumberDisplayedCorrectly('99999999999999999999');
});

Given("the shipping address exceeds normal limits", () => {
  OrderConfirmationPage.setLongShippingAddress();
});

Then("the shipping address is displayed without truncation or errors", () => {
  OrderConfirmationPage.verifyLongShippingAddressDisplayedCorrectly();
});

Given("no items were purchased", () => {
  OrderConfirmationPage.setNoItemsPurchased();
});

Then("the system indicates no items were purchased with a user-friendly message", () => {
  OrderConfirmationPage.verifyNoItemsPurchasedMessage();
});

Then("the UI remains intact and user-friendly despite the long address", () => {
  OrderConfirmationPage.verifyUIIntegrityWithLongAddress();
});

Then("the total amount is displayed as zero with a message explaining the reason", () => {
  OrderConfirmationPage.verifyTotalAmountAsZero();
});

Then("the message indicates no delivery date due to no items purchased", () => {
  OrderConfirmationPage.verifyNoDeliveryDateMessage();
});

Then("the payment method is displayed as N/A with a message explaining the reason", () => {
  OrderConfirmationPage.verifyPaymentMethodAsNA();
});

Then("customer support contact information is displayed", () => {
  OrderConfirmationPage.verifyCustomerSupportInfoDisplayed();
});

Then("the system provides a message indicating the absence of tracking information", () => {
  OrderConfirmationPage.verifyNoTrackingInformationMessage();
});

Then("the print option is disabled or provides a message about no items", () => {
  OrderConfirmationPage.verifyPrintOptionDisabled();
});

Then("the email option is disabled or provides a message about no items", () => {
  OrderConfirmationPage.verifyEmailOptionDisabled();
});

Then("promotional offers or discounts are displayed if applicable, with a message about no items", () => {
  OrderConfirmationPage.verifyPromotionalOffersDisplayed();
});

Then("the system logs an error for handling edge case order confirmation details for auditing purposes", () => {
  OrderConfirmationPage.verifyErrorLoggedForEdgeCaseDetails();
});

Given("multiple edge case orders are placed simultaneously", () => {
  OrderConfirmationPage.placeMultipleEdgeCaseOrders();
});

Then("the system handles multiple edge case orders without crashing or performance issues", () => {
  OrderConfirmationPage.verifySystemStabilityUnderLoad();
});