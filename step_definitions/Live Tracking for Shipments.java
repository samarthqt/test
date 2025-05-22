package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveTrackingSteps extends LiveTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the system")
    public void userIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @When("User navigates to the live tracking page")
    public void userNavigatesToTheLiveTrackingPage() {
        navigateToLiveTrackingPage();
    }

    @Then("Live tracking page is displayed")
    public void liveTrackingPageIsDisplayed() {
        verifyLiveTrackingPageDisplayed();
    }

    @Given("Shipment data is available in the system")
    public void shipmentDataIsAvailableInTheSystem() {
        verifyShipmentDataAvailability();
    }

    @When("User enters the Shipment ID {int} in the tracking field")
    public void userEntersTheShipmentIDInTheTrackingField(int shipmentId) {
        enterShipmentID(shipmentId);
    }

    @Then("Live tracking details for ID {int} are displayed")
    public void liveTrackingDetailsForIDAreDisplayed(int shipmentId) {
        verifyTrackingDetailsDisplayed(shipmentId);
    }

    @Given("User ID is {int}")
    public void userIDIs(int userId) {
        verifyUserID(userId);
    }

    @When("User checks the current location of the shipment")
    public void userChecksTheCurrentLocationOfTheShipment() {
        checkCurrentLocation();
    }

    @Then("Current location is displayed on the map")
    public void currentLocationIsDisplayedOnTheMap() {
        verifyCurrentLocationDisplayed();
    }

    @When("User simulates a change in shipment location")
    public void userSimulatesAChangeInShipmentLocation() {
        simulateLocationChange();
    }

    @Then("Location updates in real-time on the map")
    public void locationUpdatesInRealTimeOnTheMap() {
        verifyRealTimeLocationUpdate();
    }

    @When("User verifies the estimated delivery time")
    public void userVerifiesTheEstimatedDeliveryTime() {
        verifyEstimatedDeliveryTime();
    }

    @Then("Estimated delivery time is displayed accurately")
    public void estimatedDeliveryTimeIsDisplayedAccurately() {
        verifyAccurateDeliveryTime();
    }

    @When("User refreshes the page")
    public void userRefreshesThePage() {
        refreshPage();
    }

    @Then("Live tracking information remains consistent")
    public void liveTrackingInformationRemainsConsistent() {
        verifyConsistentTrackingInformation();
    }

    @When("User logs out and logs back in")
    public void userLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("Live tracking information remains available")
    public void liveTrackingInformationRemainsAvailable() {
        verifyTrackingInformationAvailability();
    }

    @When("User checks the notification settings for live tracking updates")
    public void userChecksTheNotificationSettingsForLiveTrackingUpdates() {
        checkNotificationSettings();
    }

    @Then("Notifications are enabled for live tracking updates")
    public void notificationsAreEnabledForLiveTrackingUpdates() {
        verifyNotificationsEnabled();
    }

    @When("User simulates a network issue and attempts to update location")
    public void userSimulatesANetworkIssueAndAttemptsToUpdateLocation() {
        simulateNetworkIssue();
    }

    @Then("System handles the issue gracefully and retries the update")
    public void systemHandlesTheIssueGracefullyAndRetriesTheUpdate() {
        verifyNetworkIssueHandling();
    }

    @When("User verifies the tracking history log")
    public void userVerifiesTheTrackingHistoryLog() {
        verifyTrackingHistoryLog();
    }

    @Then("Log contains all location updates with timestamps")
    public void logContainsAllLocationUpdatesWithTimestamps() {
        verifyLogContents();
    }

    @When("User checks for any error messages during location updates")
    public void userChecksForAnyErrorMessagesDuringLocationUpdates() {
        checkForErrorMessages();
    }

    @Then("No error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @When("User attempts to update location from a different device")
    public void userAttemptsToUpdateLocationFromADifferentDevice() {
        updateLocationFromDifferentDevice();
    }

    @Then("Location updates are synchronized across devices")
    public void locationUpdatesAreSynchronizedAcrossDevices() {
        verifySynchronizationAcrossDevices();
    }

    @When("User verifies the live tracking on a mobile device")
    public void userVerifiesTheLiveTrackingOnAMobileDevice() {
        verifyLiveTrackingOnMobile();
    }

    @Then("Tracking is consistent with the desktop view")
    public void trackingIsConsistentWithTheDesktopView() {
        verifyConsistencyWithDesktopView();
    }

    @When("User checks the live tracking after a system reboot")
    public void userChecksTheLiveTrackingAfterASystemReboot() {
        checkLiveTrackingAfterReboot();
    }

    @Then("Tracking information remains available")
    public void trackingInformationRemainsAvailable() {
        verifyTrackingInformationPostReboot();
    }

    @When("User verifies the accuracy of the live tracking system")
    public void userVerifiesTheAccuracyOfTheLiveTrackingSystem() {
        verifyTrackingSystemAccuracy();
    }

    @Then("Live tracking information is accurate and reliable")
    public void liveTrackingInformationIsAccurateAndReliable() {
        verifyAccuracyAndReliability();
    }
}