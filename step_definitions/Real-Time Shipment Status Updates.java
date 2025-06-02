package com.cucumber.steps;

import com.page_objects.ShipmentTrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    @Given("User is logged into the system")
    public void userIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @When("User navigates to the shipment tracking page")
    public void userNavigatesToTheShipmentTrackingPage() {
        navigateToShipmentTrackingPage();
    }

    @Then("Shipment tracking page is displayed")
    public void shipmentTrackingPageIsDisplayed() {
        verifyShipmentTrackingPageDisplayed();
    }

    @Then("Shipment data is available in the system")
    public void shipmentDataIsAvailableInTheSystem() {
        verifyShipmentDataAvailable();
    }

    @Given("Shipment ID is \"12345\"")
    public void shipmentIDIs() {
        setShipmentID("12345");
    }

    @When("User enters the Shipment ID \"12345\" in the tracking field")
    public void userEntersTheShipmentIDInTheTrackingField() {
        enterShipmentID("12345");
    }

    @Then("Shipment details for ID \"12345\" are displayed")
    public void shipmentDetailsForIDAreDisplayed() {
        verifyShipmentDetailsDisplayed("12345");
    }

    @Given("User ID is \"67890\"")
    public void userIDIs() {
        setUserID("67890");
    }

    @When("User checks the current status of the shipment")
    public void userChecksTheCurrentStatusOfTheShipment() {
        checkCurrentShipmentStatus();
    }

    @Then("Current status is displayed as \"In Transit\"")
    public void currentStatusIsDisplayedAs() {
        verifyCurrentStatus("In Transit");
    }

    @When("User simulates a status update to \"Out for Delivery\"")
    public void userSimulatesAStatusUpdateToOutForDelivery() {
        simulateStatusUpdate("Out for Delivery");
    }

    @Then("Status updates to \"Out for Delivery\" in real-time")
    public void statusUpdatesToOutForDeliveryInRealTime() {
        verifyStatusUpdate("Out for Delivery");
    }

    @When("User simulates a status update to \"Delivered\"")
    public void userSimulatesAStatusUpdateToDelivered() {
        simulateStatusUpdate("Delivered");
    }

    @Then("Status updates to \"Delivered\" in real-time")
    public void statusUpdatesToDeliveredInRealTime() {
        verifyStatusUpdate("Delivered");
    }

    @When("User verifies the timestamp of the latest status update")
    public void userVerifiesTheTimestampOfTheLatestStatusUpdate() {
        verifyTimestampOfLatestStatusUpdate();
    }

    @Then("Timestamp matches the current time")
    public void timestampMatchesTheCurrentTime() {
        verifyTimestampMatchesCurrentTime();
    }

    @When("User refreshes the page")
    public void userRefreshesThePage() {
        refreshPage();
    }

    @Then("Status remains \"Delivered\" with the same timestamp")
    public void statusRemainsDeliveredWithTheSameTimestamp() {
        verifyStatusAndTimestamp("Delivered");
    }

    @When("User logs out and logs back in")
    public void userLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("Shipment status remains \"Delivered\"")
    public void shipmentStatusRemainsDelivered() {
        verifyShipmentStatus("Delivered");
    }

    @When("User checks the notification settings for shipment updates")
    public void userChecksTheNotificationSettingsForShipmentUpdates() {
        checkNotificationSettings();
    }

    @Then("Notifications are enabled for real-time updates")
    public void notificationsAreEnabledForRealTimeUpdates() {
        verifyNotificationsEnabled();
    }

    @When("User simulates a network issue and attempts to update status")
    public void userSimulatesANetworkIssueAndAttemptsToUpdateStatus() {
        simulateNetworkIssueAndUpdateStatus();
    }

    @Then("System handles the issue gracefully and retries the update")
    public void systemHandlesTheIssueGracefullyAndRetriesTheUpdate() {
        verifySystemHandlesNetworkIssue();
    }

    @When("User verifies the shipment history log")
    public void userVerifiesTheShipmentHistoryLog() {
        verifyShipmentHistoryLog();
    }

    @Then("Log contains all status updates with timestamps")
    public void logContainsAllStatusUpdatesWithTimestamps() {
        verifyLogContainsStatusUpdates();
    }

    @When("User checks for any error messages during status updates")
    public void userChecksForAnyErrorMessagesDuringStatusUpdates() {
        checkForErrorMessages();
    }

    @Then("No error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @When("User attempts to update status from a different device")
    public void userAttemptsToUpdateStatusFromADifferentDevice() {
        attemptStatusUpdateFromDifferentDevice();
    }

    @Then("Status updates are synchronized across devices")
    public void statusUpdatesAreSynchronizedAcrossDevices() {
        verifyStatusSynchronizationAcrossDevices();
    }

    @When("User verifies the shipment status on a mobile device")
    public void userVerifiesTheShipmentStatusOnAMobileDevice() {
        verifyShipmentStatusOnMobileDevice();
    }

    @Then("Status is consistent with the desktop view")
    public void statusIsConsistentWithTheDesktopView() {
        verifyStatusConsistencyWithDesktopView();
    }

    @When("User checks the shipment status after a system reboot")
    public void userChecksTheShipmentStatusAfterASystemReboot() {
        checkShipmentStatusAfterSystemReboot();
    }

    @Then("Status remains \"Delivered\"")
    public void statusRemainsDelivered() {
        verifyStatusAfterReboot("Delivered");
    }
}