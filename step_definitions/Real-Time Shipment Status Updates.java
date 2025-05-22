package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentStatusSteps extends ShipmentTrackingPage {

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

    @Then("shipment data is available in the system")
    public void shipmentDataIsAvailableInTheSystem() {
        verifyShipmentDataAvailability();
    }

    @Given("the shipment tracking page is displayed")
    public void theShipmentTrackingPageIsDisplayedAgain() {
        verifyShipmentTrackingPageDisplayed();
    }

    @When("the user enters the Shipment ID {int} in the tracking field")
    public void theUserEntersTheShipmentIDInTheTrackingField(int shipmentId) {
        enterShipmentID(shipmentId);
    }

    @Then("shipment details for ID {int} are displayed")
    public void shipmentDetailsForIDAreDisplayed(int shipmentId) {
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @Given("shipment details for ID {int} are displayed")
    public void shipmentDetailsForIDAreDisplayedAgain(int shipmentId) {
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @When("the user checks the current status of the shipment")
    public void theUserChecksTheCurrentStatusOfTheShipment() {
        checkCurrentShipmentStatus();
    }

    @Then("the current status is displayed as 'In Transit'")
    public void theCurrentStatusIsDisplayedAsInTransit() {
        verifyCurrentStatus("In Transit");
    }

    @Given("the current status is 'In Transit'")
    public void theCurrentStatusIsInTransit() {
        verifyCurrentStatus("In Transit");
    }

    @When("a status update to 'Out for Delivery' is simulated")
    public void aStatusUpdateToOutForDeliveryIsSimulated() {
        simulateStatusUpdate("Out for Delivery");
    }

    @Then("the status updates to 'Out for Delivery' in real-time")
    public void theStatusUpdatesToOutForDeliveryInRealTime() {
        verifyCurrentStatus("Out for Delivery");
    }

    @Given("the status is 'Out for Delivery'")
    public void theStatusIsOutForDelivery() {
        verifyCurrentStatus("Out for Delivery");
    }

    @When("a status update to 'Delivered' is simulated")
    public void aStatusUpdateToDeliveredIsSimulated() {
        simulateStatusUpdate("Delivered");
    }

    @Then("the status updates to 'Delivered' in real-time")
    public void theStatusUpdatesToDeliveredInRealTime() {
        verifyCurrentStatus("Delivered");
    }

    @Given("the status is 'Delivered'")
    public void theStatusIsDelivered() {
        verifyCurrentStatus("Delivered");
    }

    @When("the user verifies the timestamp of the latest status update")
    public void theUserVerifiesTheTimestampOfTheLatestStatusUpdate() {
        verifyTimestampOfLatestStatusUpdate();
    }

    @Then("the timestamp matches the current time")
    public void theTimestampMatchesTheCurrentTime() {
        verifyTimestampMatchesCurrentTime();
    }

    @Given("the status is 'Delivered' with the correct timestamp")
    public void theStatusIsDeliveredWithTheCorrectTimestamp() {
        verifyCurrentStatus("Delivered");
        verifyTimestampMatchesCurrentTime();
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("the status remains 'Delivered' with the same timestamp")
    public void theStatusRemainsDeliveredWithTheSameTimestamp() {
        verifyCurrentStatus("Delivered");
        verifyTimestampMatchesCurrentTime();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the shipment status remains 'Delivered'")
    public void theShipmentStatusRemainsDelivered() {
        verifyCurrentStatus("Delivered");
    }

    @When("the user checks the notification settings for shipment updates")
    public void theUserChecksTheNotificationSettingsForShipmentUpdates() {
        checkNotificationSettings();
    }

    @Then("notifications are enabled for real-time updates")
    public void notificationsAreEnabledForRealTimeUpdates() {
        verifyNotificationsEnabled();
    }

    @Given("the user attempts to update status during a network issue")
    public void theUserAttemptsToUpdateStatusDuringANetworkIssue() {
        simulateNetworkIssueDuringUpdate();
    }

    @When("the system handles the issue gracefully")
    public void theSystemHandlesTheIssueGracefully() {
        handleNetworkIssueGracefully();
    }

    @Then("the system retries the update")
    public void theSystemRetriesTheUpdate() {
        verifySystemRetriesUpdate();
    }

    @Given("the status updates have been made")
    public void theStatusUpdatesHaveBeenMade() {
        verifyStatusUpdatesMade();
    }

    @When("the user verifies the shipment history log")
    public void theUserVerifiesTheShipmentHistoryLog() {
        verifyShipmentHistoryLog();
    }

    @Then("the log contains all status updates with timestamps")
    public void theLogContainsAllStatusUpdatesWithTimestamps() {
        verifyLogContainsAllUpdates();
    }

    @Given("the user updates the shipment status")
    public void theUserUpdatesTheShipmentStatus() {
        updateShipmentStatus();
    }

    @When("the user checks for error messages")
    public void theUserChecksForErrorMessages() {
        checkForErrorMessages();
    }

    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @Given("the user has access to multiple devices")
    public void theUserHasAccessToMultipleDevices() {
        verifyAccessToMultipleDevices();
    }

    @When("the user attempts to update status from a different device")
    public void theUserAttemptsToUpdateStatusFromADifferentDevice() {
        updateStatusFromDifferentDevice();
    }

    @Then("the status updates are synchronized across devices")
    public void theStatusUpdatesAreSynchronizedAcrossDevices() {
        verifyStatusSynchronization();
    }

    @Given("the user checks the shipment status on a mobile device")
    public void theUserChecksTheShipmentStatusOnAMobileDevice() {
        checkStatusOnMobileDevice();
    }

    @When("the status is displayed")
    public void theStatusIsDisplayed() {
        verifyStatusDisplayed();
    }

    @Then("the status is consistent with the desktop view")
    public void theStatusIsConsistentWithTheDesktopView() {
        verifyStatusConsistencyWithDesktop();
    }

    @Given("the system has been rebooted")
    public void theSystemHasBeenRebooted() {
        rebootSystem();
    }

    @When("the user checks the shipment status")
    public void theUserChecksTheShipmentStatus() {
        checkShipmentStatus();
    }

    @Then("the status remains 'Delivered'")
    public void theStatusRemainsDelivered() {
        verifyCurrentStatus("Delivered");
    }
}