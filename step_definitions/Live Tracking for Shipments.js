import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LiveTrackingPage from "../pages/liveTrackingPage";

Given("User is logged into the system", () => {
 LiveTrackingPage.login();
});

Given("Shipment data is available in the system", () => {
 LiveTrackingPage.verifyShipmentData();
});

Given("User ID is 09876", () => {
 LiveTrackingPage.setUserID('09876');
});

When("User navigates to the live tracking page", () => {
 LiveTrackingPage.navigateToTrackingPage();
});

Then("Live tracking page is displayed", () => {
 LiveTrackingPage.verifyTrackingPageDisplayed();
});

When("User enters the Shipment ID {string} in the tracking field", (shipmentID) => {
 LiveTrackingPage.enterShipmentID(shipmentID);
});

Then("Live tracking details for ID {string} are displayed", (shipmentID) => {
 LiveTrackingPage.verifyTrackingDetails(shipmentID);
});

When("User checks the current location of the shipment", () => {
 LiveTrackingPage.checkCurrentLocation();
});

Then("Current location is displayed on the map", () => {
 LiveTrackingPage.verifyCurrentLocationDisplayed();
});

When("User simulates a change in shipment location", () => {
 LiveTrackingPage.simulateLocationChange();
});

Then("Location updates in real-time on the map", () => {
 LiveTrackingPage.verifyRealTimeLocationUpdate();
});

When("User verifies the estimated delivery time", () => {
 LiveTrackingPage.verifyEstimatedDeliveryTime();
});

Then("Estimated delivery time is displayed accurately", () => {
 LiveTrackingPage.verifyDeliveryTimeAccuracy();
});

When("User refreshes the page", () => {
 LiveTrackingPage.refreshPage();
});

Then("Live tracking information remains consistent", () => {
 LiveTrackingPage.verifyTrackingConsistency();
});

When("User logs out and logs back in", () => {
 LiveTrackingPage.logoutAndLogin();
});

Then("Live tracking information remains available", () => {
 LiveTrackingPage.verifyTrackingAvailability();
});

When("User checks the notification settings for live tracking updates", () => {
 LiveTrackingPage.checkNotificationSettings();
});

Then("Notifications are enabled for live tracking updates", () => {
 LiveTrackingPage.verifyNotificationsEnabled();
});

When("User simulates a network issue and attempts to update location", () => {
 LiveTrackingPage.simulateNetworkIssue();
});

Then("System handles the issue gracefully and retries the update", () => {
 LiveTrackingPage.verifyNetworkIssueHandling();
});

When("User verifies the tracking history log", () => {
 LiveTrackingPage.verifyTrackingHistoryLog();
});

Then("Log contains all location updates with timestamps", () => {
 LiveTrackingPage.verifyLogContainsUpdates();
});

When("User checks for any error messages during location updates", () => {
 LiveTrackingPage.checkForErrorMessages();
});

Then("No error messages are displayed", () => {
 LiveTrackingPage.verifyNoErrorMessages();
});

When("User attempts to update location from a different device", () => {
 LiveTrackingPage.updateLocationFromDifferentDevice();
});

Then("Location updates are synchronized across devices", () => {
 LiveTrackingPage.verifySynchronizationAcrossDevices();
});

When("User verifies the live tracking on a mobile device", () => {
 LiveTrackingPage.verifyTrackingOnMobile();
});

Then("Tracking is consistent with the desktop view", () => {
 LiveTrackingPage.verifyConsistencyWithDesktopView();
});

When("User checks the live tracking after a system reboot", () => {
 LiveTrackingPage.checkTrackingAfterReboot();
});

Then("Tracking information remains available", () => {
 LiveTrackingPage.verifyTrackingAvailabilityAfterReboot();
});

When("User verifies the accuracy of the live tracking system", () => {
 LiveTrackingPage.verifyTrackingSystemAccuracy();
});

Then("Live tracking information is accurate and reliable", () => {
 LiveTrackingPage.verifyTrackingInformationAccuracy();
});