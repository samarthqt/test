import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("the user has a valid order with Order ID {string} and tracking number {string}", (orderId, trackingNumber) => {
 // Set up the order in the system with the given Order ID and tracking number
 // This could be a setup step in the backend or a mock
});

When("the user logs into their account", () => {
 OrderTrackingPage.login();
});

Then("the user should be successfully logged in", () => {
 OrderTrackingPage.verifyLogin();
});

When("the user navigates to the 'Order History' section", () => {
 OrderTrackingPage.navigateToOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 OrderTrackingPage.verifyOrderHistoryPage();
});

When("the user selects the order with the tracking number {string}", (trackingNumber) => {
 OrderTrackingPage.selectOrder(trackingNumber);
});

Then("the order details should be displayed, including tracking information", () => {
 OrderTrackingPage.verifyOrderDetails();
});

Then("the current location of the package should be displayed as {string}", (location) => {
 OrderTrackingPage.verifyPackageLocation(location);
});

Then("the estimated delivery time should be displayed as {string}", (deliveryTime) => {
 OrderTrackingPage.verifyEstimatedDeliveryTime(deliveryTime);
});

When("the package location is simulated to change to {string}", (newLocation) => {
 OrderTrackingPage.simulatePackageLocationChange(newLocation);
});

Then("the tracking information should update in real-time to {string}", (updatedLocation) => {
 OrderTrackingPage.verifyRealTimeUpdate(updatedLocation);
});

When("the user refreshes the tracking page", () => {
 OrderTrackingPage.refreshTrackingPage();
});

Then("the page should display the updated location {string}", (updatedLocation) => {
 OrderTrackingPage.verifyUpdatedLocation(updatedLocation);
});

When("the user checks the timestamp of the last update", () => {
 OrderTrackingPage.checkLastUpdateTimestamp();
});

Then("the timestamp should reflect the current time of update", () => {
 OrderTrackingPage.verifyTimestamp();
});

When("delivery completion is simulated", () => {
 OrderTrackingPage.simulateDeliveryCompletion();
});

Then("the status should update to {string}", (status) => {
 OrderTrackingPage.verifyStatusUpdate(status);
});

Then("the user should receive a notification for delivery completion", () => {
 OrderTrackingPage.verifyDeliveryNotification();
});

When("the user logs out of their account", () => {
 OrderTrackingPage.logout();
});

Then("the user should be successfully logged out", () => {
 OrderTrackingPage.verifyLogout();
});

When("the user logs back into their account", () => {
 OrderTrackingPage.login();
});

Then("the user should be successfully logged in again", () => {
 OrderTrackingPage.verifyLogin();
});

When("the user navigates to the 'Order History' section again", () => {
 OrderTrackingPage.navigateToOrderHistory();
});

Then("the order history page should display all past and current orders", () => {
 OrderTrackingPage.verifyOrderHistoryPage();
});

When("the user selects the order with the tracking number {string} again", (trackingNumber) => {
 OrderTrackingPage.selectOrder(trackingNumber);
});

Then("the order details should be displayed, including updated tracking information", () => {
 OrderTrackingPage.verifyOrderDetails();
});

Then("the tracking information should consistently reflect the latest status", () => {
 OrderTrackingPage.verifyConsistentTrackingStatus();
});