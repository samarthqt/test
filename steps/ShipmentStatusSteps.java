package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;

public class ShipmentStatusSteps extends ShipmentStatusPage {

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

    @When("the user enters the Shipment ID {string} in the tracking field")
    public void theUserEntersTheShipmentIDInTheTrackingField(String shipmentId) {
        enterShipmentID(shipmentId);
    }

    @Then("shipment details for ID {string} are displayed")
    public void shipmentDetailsForIDAreDisplayed(String shipmentId) {
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @Given("shipment details for ID {string} are displayed")
    public void shipmentDetailsForIDAreDisplayedAgain(String shipmentId) {
        verifyShipmentDetailsDisplayed(shipmentId);
    }

    @When("the user checks the current status of the shipment")
    public void theUserChecksTheCurrentStatusOfTheShipment() {
        checkCurrentShipmentStatus();
    }

    @Then("the current status is displayed as {string}")
    public void theCurrentStatusIsDisplayedAs(String status) {
        verifyCurrentStatus(status);
    }

    @Given("the current status is {string}")
    public void theCurrentStatusIs(String status) {
        verifyCurrentStatus(status);
    }

    @When("a status update is simulated to {string}")
    public void aStatusUpdateIsSimulatedTo(String newStatus) {
        simulateStatusUpdate(newStatus);
    }

    @Then("the status updates to {string} in real-time")
    public void theStatusUpdatesToInRealTime(String newStatus) {
        verifyStatusUpdateInRealTime(newStatus);
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

    @Then("the status remains {string} with the same timestamp")
    public void theStatusRemainsWithTheSameTimestamp(String status) {
        verifyStatusAndTimestamp(status);
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the shipment status remains {string}")
    public void theShipmentStatusRemains(String status) {
        verifyShipmentStatusRemains(status);
    }

    @When("the user checks the notification settings for shipment updates")
    public void theUserChecksTheNotificationSettingsForShipmentUpdates() {
        checkNotificationSettings();
    }

    @Then("notifications are enabled for real-time updates")
    public void notificationsAreEnabledForRealTimeUpdates() {
        verifyNotificationsEnabled();
    }

    @When("a network issue is simulated and an attempt is made to update status")
    public void aNetworkIssueIsSimulatedAndAnAttemptIsMadeToUpdateStatus() {
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
        verifyLogContainsAllUpdates();
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

    @Then("status updates are synchronized across devices")
    public void statusUpdatesAreSynchronizedAcrossDevices() {
        verifyStatusSynchronization();
    }

    @When("the user verifies the shipment status on a mobile device")
    public void theUserVerifiesTheShipmentStatusOnAMobileDevice() {
        verifyShipmentStatusOnMobile();
    }

    @Then("the status is consistent with the desktop view")
    public void theStatusIsConsistentWithTheDesktopView() {
        verifyStatusConsistency();
    }

    @When("the user checks the shipment status after a system reboot")
    public void theUserChecksTheShipmentStatusAfterASystemReboot() {
        checkShipmentStatusAfterReboot();
    }

    @Then("the status remains {string}")
    public void theStatusRemains(String status) {
        verifyStatusRemains(status);
    }
}

