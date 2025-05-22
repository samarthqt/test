import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentTrackingPage from "../pages/shipmentTrackingPage";

Given("the user is logged into the system", () => {
 cy.login();
});

When("the user navigates to the shipment tracking page", () => {
 ShipmentTrackingPage.visit();
});

Then("the shipment tracking page is displayed", () => {
 ShipmentTrackingPage.verifyPageDisplayed();
});

Given("the shipment tracking page is displayed", () => {
 ShipmentTrackingPage.verifyPageDisplayed();
});

When("the user enters the Shipment ID {string} in the tracking field", (shipmentId) => {
 ShipmentTrackingPage.enterShipmentID(shipmentId);
});

Then("shipment details for ID {string} are displayed", (shipmentId) => {
 ShipmentTrackingPage.verifyShipmentDetails(shipmentId);
});

Given("shipment details for ID {string} are displayed", (shipmentId) => {
 ShipmentTrackingPage.verifyShipmentDetails(shipmentId);
});

When("the user checks the current status of the shipment", () => {
 ShipmentTrackingPage.checkCurrentStatus();
});

Then("the current status is displayed as {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

Given("the current status is {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

When("a status update to {string} is simulated", (newStatus) => {
 ShipmentTrackingPage.simulateStatusUpdate(newStatus);
});

Then("the status updates to {string} in real-time", (newStatus) => {
 ShipmentTrackingPage.verifyStatusUpdate(newStatus);
});

Given("the status is {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

When("the user verifies the timestamp of the latest status update", () => {
 ShipmentTrackingPage.verifyTimestamp();
});

Then("the timestamp matches the current time", () => {
 ShipmentTrackingPage.verifyTimestampMatchesCurrentTime();
});

Given("the status is {string} with the correct timestamp", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
 ShipmentTrackingPage.verifyTimestampMatchesCurrentTime();
});

When("the user refreshes the page", () => {
 cy.reload();
});

Then("the status remains {string} with the same timestamp", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
 ShipmentTrackingPage.verifyTimestampMatchesCurrentTime();
});

Given("the status is {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

When("the user logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("the shipment status remains {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});

Given("the user is logged in", () => {
 cy.login();
});

When("the user checks the notification settings for shipment updates", () => {
 ShipmentTrackingPage.checkNotificationSettings();
});

Then("notifications are enabled for real-time updates", () => {
 ShipmentTrackingPage.verifyNotificationsEnabled();
});

Given("the user attempts to update status during a network issue", () => {
 ShipmentTrackingPage.simulateNetworkIssue();
});

When("the system handles the issue gracefully", () => {
 ShipmentTrackingPage.verifyNetworkIssueHandled();
});

Then("the system retries the update", () => {
 ShipmentTrackingPage.verifyRetryUpdate();
});

Given("the status updates have been made", () => {
 ShipmentTrackingPage.verifyStatusUpdatesMade();
});

When("the user verifies the shipment history log", () => {
 ShipmentTrackingPage.verifyHistoryLog();
});

Then("the log contains all status updates with timestamps", () => {
 ShipmentTrackingPage.verifyHistoryLogContents();
});

Given("the user updates the shipment status", () => {
 ShipmentTrackingPage.updateShipmentStatus();
});

When("the user checks for error messages", () => {
 ShipmentTrackingPage.checkForErrorMessages();
});

Then("no error messages are displayed", () => {
 ShipmentTrackingPage.verifyNoErrorMessages();
});

Given("the user has access to multiple devices", () => {
 ShipmentTrackingPage.verifyMultipleDeviceAccess();
});

When("the user attempts to update status from a different device", () => {
 ShipmentTrackingPage.updateStatusFromDifferentDevice();
});

Then("the status updates are synchronized across devices", () => {
 ShipmentTrackingPage.verifyStatusSynchronization();
});

Given("the user checks the shipment status on a mobile device", () => {
 ShipmentTrackingPage.checkStatusOnMobileDevice();
});

When("the status is displayed", () => {
 ShipmentTrackingPage.verifyStatusDisplayed();
});

Then("the status is consistent with the desktop view", () => {
 ShipmentTrackingPage.verifyStatusConsistency();
});

Given("the system has been rebooted", () => {
 ShipmentTrackingPage.rebootSystem();
});

When("the user checks the shipment status", () => {
 ShipmentTrackingPage.checkShipmentStatus();
});

Then("the status remains {string}", (status) => {
 ShipmentTrackingPage.verifyCurrentStatus(status);
});