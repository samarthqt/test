package com.cucumber.steps;

import com.page_objects.LiveTrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveTrackingSteps extends LiveTrackingPage {

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @When("the user navigates to the live tracking page")
    public void theUserNavigatesToTheLiveTrackingPage() {
        navigateToLiveTrackingPage();
    }

    @Then("the live tracking page is displayed")
    public void theLiveTrackingPageIsDisplayed() {
        verifyLiveTrackingPageDisplayed();
    }

    @Given("shipment data is available in the system")
    public void shipmentDataIsAvailableInTheSystem() {
        verifyShipmentDataAvailable();
    }

    @When("the user enters the Shipment ID {string} in the tracking field")
    public void theUserEntersTheShipmentIDInTheTrackingField(String shipmentId) {
        enterShipmentID(shipmentId);
    }

    @Then("live tracking details for ID {string} are displayed")
    public void liveTrackingDetailsForIDAreDisplayed(String shipmentId) {
        verifyTrackingDetailsDisplayed(shipmentId);
    }

    @When("the user checks the current location of the shipment")
    public void theUserChecksTheCurrentLocationOfTheShipment() {
        checkCurrentLocation();
    }

    @Then("the current location is displayed on the map")
    public void theCurrentLocationIsDisplayedOnTheMap() {
        verifyCurrentLocationDisplayed();
    }

    @When("a change in shipment location is simulated")
    public void aChangeInShipmentLocationIsSimulated() {
        simulateLocationChange();
    }

    @Then("the location updates in real-time on the map")
    public void theLocationUpdatesInRealTimeOnTheMap() {
        verifyRealTimeLocationUpdate();
    }

    @When("the user verifies the estimated delivery time")
    public void theUserVerifiesTheEstimatedDeliveryTime() {
        verifyEstimatedDeliveryTime();
    }

    @Then("the estimated delivery time is displayed accurately")
    public void theEstimatedDeliveryTimeIsDisplayedAccurately() {
        verifyAccurateEstimatedDeliveryTime();
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("live tracking information remains consistent")
    public void liveTrackingInformationRemainsConsistent() {
        verifyConsistentTrackingInformation();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("live tracking information remains available")
    public void liveTrackingInformationRemainsAvailable() {
        verifyTrackingInformationAvailable();
    }

    @When("the user checks the notification settings for live tracking updates")
    public void theUserChecksTheNotificationSettingsForLiveTrackingUpdates() {
        checkNotificationSettings();
    }

    @Then("notifications are enabled for live tracking updates")
    public void notificationsAreEnabledForLiveTrackingUpdates() {
        verifyNotificationsEnabled();
    }

    @When("a network issue is simulated and the user attempts to update location")
    public void aNetworkIssueIsSimulatedAndTheUserAttemptsToUpdateLocation() {
        simulateNetworkIssue();
    }

    @Then("the system handles the issue gracefully and retries the update")
    public void theSystemHandlesTheIssueGracefullyAndRetriesTheUpdate() {
        verifyNetworkIssueHandling();
    }

    @When("the user verifies the tracking history log")
    public void theUserVerifiesTheTrackingHistoryLog() {
        verifyTrackingHistoryLog();
    }

    @Then("the log contains all location updates with timestamps")
    public void theLogContainsAllLocationUpdatesWithTimestamps() {
        verifyLogContainsUpdates();
    }

    @When("the user checks for any error messages during location updates")
    public void theUserChecksForAnyErrorMessagesDuringLocationUpdates() {
        checkForErrorMessages();
    }

    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @When("the user attempts to update location from a different device")
    public void theUserAttemptsToUpdateLocationFromADifferentDevice() {
        updateLocationFromDifferentDevice();
    }

    @Then("location updates are synchronized across devices")
    public void locationUpdatesAreSynchronizedAcrossDevices() {
        verifySynchronizationAcrossDevices();
    }

    @When("the user verifies the live tracking on a mobile device")
    public void theUserVerifiesTheLiveTrackingOnAMobileDevice() {
        verifyLiveTrackingOnMobile();
    }

    @Then("tracking is consistent with the desktop view")
    public void trackingIsConsistentWithTheDesktopView() {
        verifyConsistencyWithDesktopView();
    }

    @When("the user checks the live tracking after a system reboot")
    public void theUserChecksTheLiveTrackingAfterASystemReboot() {
        checkLiveTrackingAfterReboot();
    }

    @Then("tracking information remains available")
    public void trackingInformationRemainsAvailable() {
        verifyTrackingInformationPostReboot();
    }

    @When("the user verifies the accuracy of the live tracking system")
    public void theUserVerifiesTheAccuracyOfTheLiveTrackingSystem() {
        verifyTrackingSystemAccuracy();
    }

    @Then("live tracking information is accurate and reliable")
    public void liveTrackingInformationIsAccurateAndReliable() {
        verifyTrackingInformationReliability();
    }
}