import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentTrackingPage from "../pages/shipmentTrackingPage";

Given("the user is logged into the system", () => {
 ShipmentTrackingPage.login();
});

Given("the user is on the shipment tracking page", () => {
 ShipmentTrackingPage.visit();
});

Given("shipment details for ID {string} are displayed", (shipmentId) => {
 ShipmentTrackingPage.verifyShipmentDetails(shipmentId);
});

Given("the current status is {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

Given("there is a network issue", () => {
 ShipmentTrackingPage.simulateNetworkIssue();
});

Given("the status has been updated multiple times", () => {
 ShipmentTrackingPage.verifyMultipleUpdates();
});

Given("the user is on a mobile device", () => {
 ShipmentTrackingPage.verifyMobileDevice();
});

Given("the system has been rebooted", () => {
 ShipmentTrackingPage.simulateSystemReboot();
});

When("the user navigates to the shipment tracking page", () => {
 ShipmentTrackingPage.navigate();
});

When("the user enters the Shipment ID {string} in the tracking field", (shipmentId) => {
 ShipmentTrackingPage.enterShipmentID(shipmentId);
});

When("the user checks the current status of the shipment", () => {
 ShipmentTrackingPage.checkCurrentStatus();
});

When("the status is updated to {string}", (newStatus) => {
 ShipmentTrackingPage.updateStatus(newStatus);
});

When("the user verifies the timestamp of the latest status update", () => {
 ShipmentTrackingPage.verifyTimestamp();
});

When("the user refreshes the page", () => {
 ShipmentTrackingPage.refreshPage();
});

When("the user logs out and logs back in", () => {
 ShipmentTrackingPage.logoutAndLogin();
});

When("the user checks the notification settings for shipment updates", () => {
 ShipmentTrackingPage.checkNotificationSettings();
});

When("the user attempts to update the status", () => {
 ShipmentTrackingPage.attemptStatusUpdate();
});

When("the user verifies the shipment history log", () => {
 ShipmentTrackingPage.verifyShipmentHistoryLog();
});

When("the user checks for error messages", () => {
 ShipmentTrackingPage.checkForErrorMessages();
});

When("the user attempts to update the status from a different device", () => {
 ShipmentTrackingPage.attemptUpdateFromDifferentDevice();
});

When("the user verifies the shipment status", () => {
 ShipmentTrackingPage.verifyShipmentStatus();
});

When("the user checks the shipment status", () => {
 ShipmentTrackingPage.checkShipmentStatus();
});

Then("the shipment tracking page is displayed", () => {
 ShipmentTrackingPage.verifyPageDisplayed();
});

Then("shipment data is available in the system", () => {
 ShipmentTrackingPage.verifyShipmentDataAvailable();
});

Then("shipment details for ID {string} are displayed", (shipmentId) => {
 ShipmentTrackingPage.verifyShipmentDetails(shipmentId);
});

Then("the current status is displayed as {string}", (expectedStatus) => {
 ShipmentTrackingPage.verifyCurrentStatus(expectedStatus);
});

Then("the status updates to {string} in real-time", (expectedStatus) => {
 ShipmentTrackingPage.verifyRealTimeStatusUpdate(expectedStatus);
});

Then("the timestamp matches the current time", () => {
 ShipmentTrackingPage.verifyTimestampMatchesCurrentTime();
});

Then("the status remains {string} with the same timestamp", (expectedStatus) => {
 ShipmentTrackingPage.verifyStatusAndTimestamp(expectedStatus);
});

Then("the shipment status remains {string}", (expectedStatus) => {
 ShipmentTrackingPage.verifyShipmentStatus(expectedStatus);
});

Then("notifications are enabled for real-time updates", () => {
 ShipmentTrackingPage.verifyNotificationsEnabled();
});

Then("the system handles the issue gracefully and retries the update", () => {
 ShipmentTrackingPage.verifyNetworkIssueHandling();
});

Then("the log contains all status updates with timestamps", () => {
 ShipmentTrackingPage.verifyCompleteShipmentHistoryLog();
});

Then("no error messages are displayed", () => {
 ShipmentTrackingPage.verifyNoErrorMessages();
});

Then("the status updates are synchronized across devices", () => {
 ShipmentTrackingPage.verifySynchronizationAcrossDevices();
});

Then("the status is consistent with the desktop view", () => {
 ShipmentTrackingPage.verifyConsistencyWithDesktopView();
});

Then("the status remains {string}", (expectedStatus) => {
 ShipmentTrackingPage.verifyStatusAfterReboot(expectedStatus);
});