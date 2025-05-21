import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveTrackingPage from "../pages/liveTrackingPage";

Given("the user is logged into the system", () => {
 // Assume user is logged in
});

When("the user navigates to the live tracking page", () => {
 LiveTrackingPage.visit();
});

Then("the live tracking page is displayed", () => {
 LiveTrackingPage.verifyPageDisplayed();
});

Given("shipment data is available in the system", () => {
 // Assume shipment data is available
});

When("the user enters the Shipment ID {string} in the tracking field", (shipmentId) => {
 LiveTrackingPage.enterShipmentId(shipmentId);
});

Then("live tracking details for ID {string} are displayed", (shipmentId) => {
 LiveTrackingPage.verifyTrackingDetailsDisplayed(shipmentId);
});

When("the user checks the current location of the shipment", () => {
 LiveTrackingPage.checkCurrentLocation();
});

Then("the current location is displayed on the map", () => {
 LiveTrackingPage.verifyCurrentLocationOnMap();
});

When("a change in shipment location is simulated", () => {
 LiveTrackingPage.simulateLocationChange();
});

Then("the location updates in real-time on the map", () => {
 LiveTrackingPage.verifyRealTimeLocationUpdate();
});

When("the user verifies the estimated delivery time", () => {
 LiveTrackingPage.verifyEstimatedDeliveryTime();
});

Then("the estimated delivery time is displayed accurately", () => {
 LiveTrackingPage.verifyEstimatedDeliveryTimeAccuracy();
});

When("the user refreshes the page", () => {
 cy.reload();
});

Then("live tracking information remains consistent", () => {
 LiveTrackingPage.verifyTrackingInfoConsistency();
});

When("the user logs out and logs back in", () => {
 LiveTrackingPage.logoutAndLogin();
});

Then("live tracking information remains available", () => {
 LiveTrackingPage.verifyTrackingInfoAvailability();
});

When("the user checks the notification settings for live tracking updates", () => {
 LiveTrackingPage.checkNotificationSettings();
});

Then("notifications are enabled for live tracking updates", () => {
 LiveTrackingPage.verifyNotificationsEnabled();
});

When("a network issue is simulated and the user attempts to update location", () => {
 LiveTrackingPage.simulateNetworkIssue();
});

Then("the system handles the issue gracefully and retries the update", () => {
 LiveTrackingPage.verifyNetworkIssueHandling();
});

When("the user verifies the tracking history log", () => {
 LiveTrackingPage.verifyTrackingHistoryLog();
});

Then("the log contains all location updates with timestamps", () => {
 LiveTrackingPage.verifyLogContainsUpdates();
});

When("the user checks for any error messages during location updates", () => {
 LiveTrackingPage.checkForErrorMessages();
});

Then("no error messages are displayed", () => {
 LiveTrackingPage.verifyNoErrorMessages();
});

When("the user attempts to update location from a different device", () => {
 LiveTrackingPage.updateLocationFromDifferentDevice();
});

Then("location updates are synchronized across devices", () => {
 LiveTrackingPage.verifySynchronizationAcrossDevices();
});

When("the user verifies the live tracking on a mobile device", () => {
 LiveTrackingPage.verifyLiveTrackingOnMobile();
});

Then("tracking is consistent with the desktop view", () => {
 LiveTrackingPage.verifyConsistencyWithDesktop();
});

When("the user checks the live tracking after a system reboot", () => {
 LiveTrackingPage.checkAfterSystemReboot();
});

Then("tracking information remains available", () => {
 LiveTrackingPage.verifyTrackingInfoAfterReboot();
});

When("the user verifies the accuracy of the live tracking system", () => {
 LiveTrackingPage.verifyTrackingSystemAccuracy();
});

Then("live tracking information is accurate and reliable", () => {
 LiveTrackingPage.verifyAccuracyAndReliability();
});