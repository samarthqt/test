package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentPage;
import java.util.List;

public class ShipmentSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @When("the user navigates to the \"My Shipments\" section from the dashboard")
    public void theUserNavigatesToTheMyShipmentsSectionFromTheDashboard() {
        navigateToMyShipments();
    }

    @Then("the \"My Shipments\" section is displayed with a list of active shipments")
    public void theMyShipmentsSectionIsDisplayedWithAListOfActiveShipments() {
        verifyMyShipmentsSection();
    }

    @When("the user selects an active shipment from the shipment list")
    public void theUserSelectsAnActiveShipmentFromTheShipmentList() {
        selectActiveShipment();
    }

    @Then("the real-time shipment timeline is displayed on the screen")
    public void theRealTimeShipmentTimelineIsDisplayedOnTheScreen() {
        verifyShipmentTimeline();
    }

    @When("the user enables push notifications for shipment status updates")
    public void theUserEnablesPushNotificationsForShipmentStatusUpdates() {
        enablePushNotifications();
    }

    @Then("push notifications for shipment status updates are enabled")
    public void pushNotificationsForShipmentStatusUpdatesAreEnabled() {
        verifyPushNotificationsEnabled();
    }

    @When("a backend status update is simulated to \"In Transit\"")
    public void aBackendStatusUpdateIsSimulatedToInTransit() {
        simulateBackendStatusUpdate("In Transit");
    }

    @Then("the status update reflects instantly on the UI")
    public void theStatusUpdateReflectsInstantlyOnTheUI() {
        verifyStatusUpdateOnUI("In Transit");
    }

    @Then("a push notification is triggered for the update")
    public void aPushNotificationIsTriggeredForTheUpdate() {
        verifyPushNotificationTriggered();
    }

    @When("the user views the shipment map")
    public void theUserViewsTheShipmentMap() {
        viewShipmentMap();
    }

    @Then("the location corresponds to the new status \"In Transit\"")
    public void theLocationCorrespondsToTheNewStatusInTransit() {
        verifyShipmentLocation("In Transit");
    }

    @When("a status update delay is simulated \(e.g., server lag or throttling\)")
    public void aStatusUpdateDelayIsSimulated() {
        simulateStatusUpdateDelay();
    }

    @Then("a message like \"Awaiting latest update...\" is displayed")
    public void aMessageLikeAwaitingLatestUpdateIsDisplayed() {
        verifyAwaitingUpdateMessage();
    }
}