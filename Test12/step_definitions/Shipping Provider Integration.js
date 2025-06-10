import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShippingPage from "../pages/shippingPage";

Given("the system is configured with FedEx and UPS API credentials", () => {
 ShippingPage.configureAPICredentials();
});

When("a user proceeds to checkout", () => {
 ShippingPage.proceedToCheckout();
});

Then("real-time shipping quotes should be fetched from FedEx and UPS", () => {
 ShippingPage.fetchRealTimeQuotes();
});

Given("a user has entered their shipping address", () => {
 ShippingPage.enterShippingAddress();
});

When("the system calculates shipping costs", () => {
 ShippingPage.calculateShippingCosts();
});

Then("the shipping costs should be accurately calculated based on the user's location", () => {
 ShippingPage.verifyAccurateShippingCosts();
});

Given("the system has fetched shipping options from FedEx and UPS", () => {
 ShippingPage.fetchShippingOptions();
});

When("a user views the shipping options during checkout", () => {
 ShippingPage.viewShippingOptions();
});

Then("the available shipping options should be displayed correctly", () => {
 ShippingPage.verifyDisplayedShippingOptions();
});

Given("an order has been placed with a shipping provider", () => {
 ShippingPage.placeOrderWithProvider();
});

When("the user requests tracking information", () => {
 ShippingPage.requestTrackingInformation();
});

Then("the system should retrieve and display the tracking information", () => {
 ShippingPage.displayTrackingInformation();
});

Given("the system is integrated with FedEx and UPS APIs", () => {
 ShippingPage.integrateWithAPIs();
});

When("an API call to a shipping provider fails", () => {
 ShippingPage.failAPICall();
});

Then("the system should handle the error gracefully and notify the user", () => {
 ShippingPage.handleAPIError();
});

Given("a user is at the checkout page", () => {
 ShippingPage.atCheckoutPage();
});

When("shipping information is updated", () => {
 ShippingPage.updateShippingInformation();
});

Then("the user interface should dynamically update with the new shipping information", () => {
 ShippingPage.verifyDynamicUIUpdate();
});

Given("a user completes a purchase", () => {
 ShippingPage.completePurchase();
});

When("the shipping transaction is processed", () => {
 ShippingPage.processShippingTransaction();
});

Then("the system should log the shipping transaction details for tracking", () => {
 ShippingPage.logShippingTransaction();
});

Given("an order is placed with shipping details", () => {
 ShippingPage.placeOrderWithDetails();
});

When("the order is processed", () => {
 ShippingPage.processOrder();
});

Then("the shipping details should integrate with the order management system", () => {
 ShippingPage.integrateWithOrderManagement();
});

Given("the system is integrated with FedEx and UPS", () => {
 ShippingPage.integrateWithFedExAndUPS();
});

When("shipping quotes and transactions are processed", () => {
 ShippingPage.processQuotesAndTransactions();
});

Then("the system should ensure compliance with the terms of the shipping providers", () => {
 ShippingPage.ensureComplianceWithTerms();
});