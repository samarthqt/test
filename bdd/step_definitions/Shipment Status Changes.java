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

    @When("selects an active shipment from the shipment list")
    public void selectsAnActiveShipmentFromTheShipmentList() {
        selectActiveShipment();
    }

    @Then("the real-time shipment timeline is displayed on the screen")
    public void theRealTimeShipmentTimelineIsDisplayedOnTheScreen() {
        verifyShipmentTimelineDisplayed();
    }

    @Given("the user is in the \"My Shipments\" section")
    public void theUserIsInTheMyShipmentsSection() {
        verifyInMyShipmentsSection();
    }

    @When("the user enables push notifications for shipment status updates")
    public void theUserEnablesPushNotificationsForShipmentStatusUpdates() {
        enablePushNotifications();
    }

    @Then("push notifications should be enabled")
    public void pushNotificationsShouldBeEnabled() {
        verifyPushNotificationsEnabled();
    }

    @Given("the user is viewing an active shipment")
    public void theUserIsViewingAnActiveShipment() {
        viewActiveShipment();
    }

    @When("a backend status update is simulated to \"In Transit\"")
    public void aBackendStatusUpdateIsSimulatedToInTransit() {
        simulateBackendStatusUpdate("In Transit");
    }

    @Then("the status update should reflect instantly on the UI")
    public void theStatusUpdateShouldReflectInstantlyOnTheUI() {
        verifyStatusUpdateOnUI("In Transit");
    }

    @Then("a push notification should be triggered for the update")
    public void aPushNotificationShouldBeTriggeredForTheUpdate() {
        verifyPushNotificationTriggered();
    }

    @Given("the status update to \"In Transit\" is reflected on the UI")
    public void theStatusUpdateToInTransitIsReflectedOnTheUI() {
        verifyStatusUpdateOnUI("In Transit");
    }

    @When("the user views the shipment map")
    public void theUserViewsTheShipmentMap() {
        viewShipmentMap();
    }

    @Then("the location should correspond to the new status")
    public void theLocationShouldCorrespondToTheNewStatus() {
        verifyShipmentLocation();
    }

    @Given("the user is viewing the shipment status")
    public void theUserIsViewingTheShipmentStatus() {
        viewShipmentStatus();
    }

    @When("a status update delay is simulated \(e.g., server lag or throttling\)")
    public void aStatusUpdateDelayIsSimulated() {
        simulateStatusUpdateDelay();
    }

    @Then("a message like “Awaiting latest update…” should be displayed")
    public void aMessageLikeAwaitingLatestUpdateShouldBeDisplayed() {
        verifyAwaitingUpdateMessage();
    }
}