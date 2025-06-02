import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("a user has a valid order with tracking enabled", () => {
 // Assume user order is set in the system
});

When("the user logs into their account", () => {
 TrackingPage.login();
});

Then("the user should be successfully logged in", () => {
 TrackingPage.verifyLogin();
});

Then("the order ID should be {string}", (orderId) => {
 TrackingPage.verifyOrderId(orderId);
});

Given("the user is logged in", () => {
 TrackingPage.verifyLogin();
});

When("the user navigates to the 'Tracking' section", () => {
 TrackingPage.navigateToTracking();
});

Then("the tracking page should display options to view current orders", () => {
 TrackingPage.verifyTrackingOptions();
});

Then("the tracking number should be {string}", (trackingNumber) => {
 TrackingPage.verifyTrackingNumber(trackingNumber);
});

Given("the user is on the tracking page", () => {
 TrackingPage.verifyOnTrackingPage();
});

When("the user selects the order with the tracking number {string}", (trackingNumber) => {
 TrackingPage.selectOrder(trackingNumber);
});

Then("tracking details should be displayed, including location and estimated delivery time", () => {
 TrackingPage.verifyTrackingDetails();
});

Then("the current location should be {string}", (location) => {
 TrackingPage.verifyCurrentLocation(location);
});

Given("the tracking details are displayed", () => {
 TrackingPage.verifyTrackingDetails();
});

When("the user checks the current location of the package", () => {
 TrackingPage.checkCurrentLocation();
});

Then("the current location should be displayed as {string}", (location) => {
 TrackingPage.verifyCurrentLocation(location);
});

When("the user verifies the estimated delivery time", () => {
 TrackingPage.verifyEstimatedDeliveryTime();
});

Then("the estimated delivery time should be displayed as {string}", (time) => {
 TrackingPage.verifyEstimatedDeliveryTime(time);
});

When("a change in the package location is simulated to {string}", (newLocation) => {
 TrackingPage.simulateLocationChange(newLocation);
});

Then("the tracking information should update to show {string}", (newLocation) => {
 TrackingPage.verifyLocationUpdate(newLocation);
});

Given("the location is updated to {string}", (newLocation) => {
 TrackingPage.verifyLocationUpdate(newLocation);
});

When("the user refreshes the tracking page", () => {
 TrackingPage.refreshPage();
});

Then("the page should display the updated location {string}", (newLocation) => {
 TrackingPage.verifyLocationUpdate(newLocation);
});

When("the user checks the timestamp of the last update", () => {
 TrackingPage.checkTimestamp();
});

Then("the timestamp should reflect the current time of update", () => {
 TrackingPage.verifyTimestamp();
});

Given("the package is {string}", (status) => {
 TrackingPage.verifyPackageStatus(status);
});

When("delivery completion is simulated", () => {
 TrackingPage.simulateDeliveryCompletion();
});

Then("the status should update to {string}", (status) => {
 TrackingPage.verifyPackageStatus(status);
});

Given("the status is {string}", (status) => {
 TrackingPage.verifyPackageStatus(status);
});

When("the user verifies notification for delivery completion", () => {
 TrackingPage.verifyDeliveryNotification();
});

Then("the user should receive a notification for delivery completion", () => {
 TrackingPage.verifyDeliveryNotification();
});

When("the user logs out of the account", () => {
 TrackingPage.logout();
});

Then("the user should be successfully logged out", () => {
 TrackingPage.verifyLogout();
});

Given("the user is logged out", () => {
 TrackingPage.verifyLogout();
});

When("the user logs back into the account", () => {
 TrackingPage.login();
});

Then("the user should be successfully logged in again", () => {
 TrackingPage.verifyLogin();
});

Given("the user is logged in again", () => {
 TrackingPage.verifyLogin();
});

When("the user navigates to the 'Tracking' section again", () => {
 TrackingPage.navigateToTracking();
});

Then("the tracking page should display options to view current orders", () => {
 TrackingPage.verifyTrackingOptions();
});

When("the user selects the order with the tracking number {string} again", (trackingNumber) => {
 TrackingPage.selectOrder(trackingNumber);
});

Then("tracking details should be displayed, including updated location and estimated delivery time", () => {
 TrackingPage.verifyTrackingDetails();
});

When("the user verifies the tracking information", () => {
 TrackingPage.verifyTrackingInformation();
});

Then("the tracking information should consistently reflect the latest status", () => {
 TrackingPage.verifyTrackingInformation();
});