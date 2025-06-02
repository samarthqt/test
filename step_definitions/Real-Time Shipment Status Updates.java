package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @When("the user navigates to the shipment tracking page")
    public void theUserNavigatesToTheShipmentTrackingPage() {
        navigateToShipmentTrackingPage();
    }

    @Then("the shipment tracking page is displayed")
    public void theShipmentTrackingPageIsDisplayed() {
        verifyShipmentTrackingPageDisplayed();
    }

    @Given("shipment data is available in the system")
    public void shipmentDataIsAvailableInTheSystem() {
        verifyShipmentDataAvailable();
    }

    @When("the user enters the Shipment ID \"12345\" in the tracking field")
    public void theUserEntersTheShipmentIDInTheTrackingField() {
        enterShipmentID("12345");
    }

    @Then("shipment details for ID \"12345\" are displayed")
    public void shipmentDetailsForIDAreDisplayed() {
        verifyShipmentDetailsDisplayed("12345");
    }

    @Given("the shipment details for ID \"12345\" are displayed")
    public void theShipmentDetailsForIDAreDisplayed() {
        verifyShipmentDetailsDisplayed("12345");
    }

    @When("the user checks the current status of the shipment")
    public void theUserChecksTheCurrentStatusOfTheShipment() {
        checkCurrentShipmentStatus();
    }

    @Then("the current status is displayed as \"In Transit\"")
    public void theCurrentStatusIsDisplayedAsInTransit() {
        verifyCurrentStatus("In Transit");
    }

    @When("the user simulates a status update to \"Out for Delivery\"")
    public void theUserSimulatesAStatusUpdateToOutForDelivery() {
        simulateStatusUpdate("Out for Delivery");
    }

    @Then("the status updates to \"Out for Delivery\" in real-time")
    public void theStatusUpdatesToOutForDeliveryInRealTime() {
        verifyStatusUpdate("Out for Delivery");
    }

    @When("the user simulates a status update to \"Delivered\"")
    public void theUserSimulatesAStatusUpdateToDelivered() {
        simulateStatusUpdate("Delivered");
    }

    @Then("the status updates to \"Delivered\" in real-time")
    public void theStatusUpdatesToDeliveredInRealTime() {
        verifyStatusUpdate("Delivered");
    }

    @When("the user verifies the timestamp of the latest status update")
    public void theUserVerifiesTheTimestampOfTheLatestStatusUpdate() {
        verifyTimestampOfLatestStatusUpdate();
    }

    @Then("the timestamp matches the current time")
    public void theTimestampMatchesTheCurrentTime() {
        verifyTimestampMatchesCurrentTime();
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("the status remains \"Delivered\" with the same timestamp")
    public void theStatusRemainsDeliveredWithTheSameTimestamp() {
        verifyStatusRemainsDelivered();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the shipment status remains \"Delivered\"")
    public void theShipmentStatusRemainsDelivered() {
        verifyShipmentStatusRemainsDelivered();
    }

    @When("the user checks the notification settings for shipment updates")
    public void theUserChecksTheNotificationSettingsForShipmentUpdates() {
        checkNotificationSettings();
    }

    @Then("notifications are enabled for real-time updates")
    public void notificationsAreEnabledForRealTimeUpdates() {
        verifyNotificationsEnabled();
    }

    @When("the user simulates a network issue and attempts to update status")
    public void theUserSimulatesANetworkIssueAndAttemptsToUpdateStatus() {
        simulateNetworkIssueAndUpdateStatus();
    }

    @Then("the system handles the issue gracefully and retries the update")
    public void theSystemHandlesTheIssueGracefullyAndRetriesTheUpdate() {
        verifySystemHandlesNetworkIssue();
    }

    @When("the user verifies the shipment history log")
    public void theUserVerifiesTheShipmentHistoryLog() {
        verifyShipmentHistoryLog();
    }

    @Then("the log contains all status updates with timestamps")
    public void theLogContainsAllStatusUpdatesWithTimestamps() {
        verifyLogContainsStatusUpdates();
    }

    @When("the user checks for any error messages during status updates")
    public void theUserChecksForAnyErrorMessagesDuringStatusUpdates() {
        checkForErrorMessages();
    }

    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @When("the user attempts to update status from a different device")
    public void theUserAttemptsToUpdateStatusFromADifferentDevice() {
        attemptStatusUpdateFromDifferentDevice();
    }

    @Then("the status updates are synchronized across devices")
    public void theStatusUpdatesAreSynchronizedAcrossDevices() {
        verifyStatusSynchronizationAcrossDevices();
    }

    @When("the user verifies the shipment status on a mobile device")
    public void theUserVerifiesTheShipmentStatusOnAMobileDevice() {
        verifyShipmentStatusOnMobileDevice();
    }

    @Then("the status is consistent with the desktop view")
    public void theStatusIsConsistentWithTheDesktopView() {
        verifyStatusConsistencyWithDesktopView();
    }

    @When("the user checks the shipment status after a system reboot")
    public void theUserChecksTheShipmentStatusAfterASystemReboot() {
        checkShipmentStatusAfterSystemReboot();
    }

    @Then("the status remains \"Delivered\"")
    public void theStatusRemainsDelivered() {
        verifyStatusRemainsDeliveredAfterReboot();
    }
}