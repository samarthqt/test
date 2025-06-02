import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user has past orders with tracking enabled", () => {
 // Assume user has past orders
});

When("the user logs into their account", () => {
 OrderHistoryPage.login();
});

Then("the user should be successfully logged in", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 OrderHistoryPage.verifyOrderHistoryDisplayed();
});

When("the user selects the order with the tracking number OPQ789", () => {
 OrderHistoryPage.selectOrderByTrackingNumber("OPQ789");
});

Then("the order details should be displayed, including tracking history", () => {
 OrderHistoryPage.verifyOrderDetailsDisplayed();
});

When("the user checks the tracking history of the package", () => {
 OrderHistoryPage.checkTrackingHistory();
});

Then("the tracking history should display all past locations: Warehouse, Distribution Center, In Transit, Delivered", () => {
 OrderHistoryPage.verifyTrackingLocations();
});

When("the user verifies the timestamp of each location update", () => {
 OrderHistoryPage.verifyTimestamps();
});

Then("each location update should have a corresponding timestamp", () => {
 OrderHistoryPage.verifyTimestampExistence();
});

When("the user verifies the delivery status", () => {
 OrderHistoryPage.verifyDeliveryStatus();
});

Then("the delivery status should be displayed as 'Delivered'", () => {
 OrderHistoryPage.verifyDeliveredStatus();
});

When("the user logs out of their account", () => {
 OrderHistoryPage.logout();
});

Then("the user should be successfully logged out", () => {
 cy.url().should("include", "/login");
});

When("the user logs back into their account", () => {
 OrderHistoryPage.login();
});

Then("the user should be successfully logged in again", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the 'Order History' section again", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 OrderHistoryPage.verifyOrderHistoryDisplayed();
});

When("the user selects the order with the tracking number OPQ789 again", () => {
 OrderHistoryPage.selectOrderByTrackingNumber("OPQ789");
});

Then("the order details should be displayed, including tracking history", () => {
 OrderHistoryPage.verifyOrderDetailsDisplayed();
});

When("the user verifies that the tracking history remains consistent", () => {
 OrderHistoryPage.verifyTrackingHistoryConsistency();
});

Then("the tracking history should consistently reflect all past updates", () => {
 OrderHistoryPage.verifyConsistentTrackingUpdates();
});

When("the user checks for any discrepancies in the tracking history", () => {
 OrderHistoryPage.checkForDiscrepancies();
});

Then("there should be no discrepancies in the tracking history", () => {
 OrderHistoryPage.verifyNoDiscrepancies();
});

When("the user verifies the ability to download or print tracking history", () => {
 OrderHistoryPage.verifyDownloadPrintOptions();
});

Then("the user should be able to download or print tracking history", () => {
 OrderHistoryPage.verifyDownloadPrintSuccess();
});

When("the user verifies notification settings for past orders", () => {
 OrderHistoryPage.verifyNotificationSettings();
});

Then("notification settings should be available for past orders", () => {
 OrderHistoryPage.verifyNotificationSettingsExistence();
});

When("the user simulates a request for tracking history via customer support", () => {
 OrderHistoryPage.simulateCustomerSupportRequest();
});

Then("customer support should be able to provide tracking history upon request", () => {
 OrderHistoryPage.verifyCustomerSupportResponse();
});