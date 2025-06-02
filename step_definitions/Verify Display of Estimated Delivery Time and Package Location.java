package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has a valid order with tracking enabled")
    public void aUserHasAValidOrderWithTrackingEnabled() {
        String orderId = testHarness.getData("OrderData", "OrderId");
        verifyOrderTrackingEnabled(orderId);
    }

    @When("the user logs into their account")
    public void theUserLogsIntoTheirAccount() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Then("the order ID should be {string}")
    public void theOrderIDShouldBe(String orderId) {
        verifyOrderId(orderId);
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Tracking' section")
    public void theUserNavigatesToTheTrackingSection() {
        navigateToTrackingSection();
    }

    @Then("the tracking page should display options to view current orders")
    public void theTrackingPageShouldDisplayOptionsToViewCurrentOrders() {
        verifyTrackingOptionsDisplayed();
    }

    @Then("the tracking number should be {string}")
    public void theTrackingNumberShouldBe(String trackingNumber) {
        verifyTrackingNumber(trackingNumber);
    }

    @Given("the user is on the tracking page")
    public void theUserIsOnTheTrackingPage() {
        verifyOnTrackingPage();
    }

    @When("the user selects the order with the tracking number {string}")
    public void theUserSelectsTheOrderWithTheTrackingNumber(String trackingNumber) {
        selectOrderWithTrackingNumber(trackingNumber);
    }

    @Then("tracking details should be displayed, including location and estimated delivery time")
    public void trackingDetailsShouldBeDisplayedIncludingLocationAndEstimatedDeliveryTime() {
        verifyTrackingDetailsDisplayed();
    }

    @Then("the current location should be {string}")
    public void theCurrentLocationShouldBe(String location) {
        verifyCurrentLocation(location);
    }

    @Given("the tracking details are displayed")
    public void theTrackingDetailsAreDisplayed() {
        verifyTrackingDetailsDisplayed();
    }

    @When("the user checks the current location of the package")
    public void theUserChecksTheCurrentLocationOfThePackage() {
        checkCurrentLocation();
    }

    @Then("the current location should be displayed as {string}")
    public void theCurrentLocationShouldBeDisplayedAs(String location) {
        verifyCurrentLocation(location);
    }

    @When("the user verifies the estimated delivery time")
    public void theUserVerifiesTheEstimatedDeliveryTime() {
        verifyEstimatedDeliveryTime();
    }

    @Then("the estimated delivery time should be displayed as {string}")
    public void theEstimatedDeliveryTimeShouldBeDisplayedAs(String deliveryTime) {
        verifyEstimatedDeliveryTime(deliveryTime);
    }

    @When("a change in the package location is simulated to {string}")
    public void aChangeInThePackageLocationIsSimulatedTo(String newLocation) {
        simulatePackageLocationChange(newLocation);
    }

    @Then("the tracking information should update to show {string}")
    public void theTrackingInformationShouldUpdateToShow(String newLocation) {
        verifyUpdatedLocation(newLocation);
    }

    @Given("the location is updated to {string}")
    public void theLocationIsUpdatedTo(String newLocation) {
        verifyUpdatedLocation(newLocation);
    }

    @When("the user refreshes the tracking page")
    public void theUserRefreshesTheTrackingPage() {
        refreshTrackingPage();
    }

    @Then("the page should display the updated location {string}")
    public void thePageShouldDisplayTheUpdatedLocation(String newLocation) {
        verifyUpdatedLocation(newLocation);
    }

    @When("the user checks the timestamp of the last update")
    public void theUserChecksTheTimestampOfTheLastUpdate() {
        checkTimestampOfLastUpdate();
    }

    @Then("the timestamp should reflect the current time of update")
    public void theTimestampShouldReflectTheCurrentTimeOfUpdate() {
        verifyTimestampOfLastUpdate();
    }

    @Given("the package is {string}")
    public void thePackageIs(String status) {
        verifyPackageStatus(status);
    }

    @When("delivery completion is simulated")
    public void deliveryCompletionIsSimulated() {
        simulateDeliveryCompletion();
    }

    @Then("the status should update to {string}")
    public void theStatusShouldUpdateTo(String status) {
        verifyPackageStatus(status);
    }

    @Given("the status is {string}")
    public void theStatusIs(String status) {
        verifyPackageStatus(status);
    }

    @When("the user verifies notification for delivery completion")
    public void theUserVerifiesNotificationForDeliveryCompletion() {
        verifyDeliveryCompletionNotification();
    }

    @Then("the user should receive a notification for delivery completion")
    public void theUserShouldReceiveANotificationForDeliveryCompletion() {
        verifyNotificationReceived();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedInAgain() {
        verifyLoginSuccess();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logout();
    }

    @Then("the user should be successfully logged out")
    public void theUserShouldBeSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyLogoutSuccess();
    }

    @When("the user logs back into the account")
    public void theUserLogsBackIntoTheAccount() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @Then("the user should be successfully logged in again")
    public void theUserShouldBeSuccessfullyLoggedInAgain() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Tracking' section again")
    public void theUserNavigatesToTheTrackingSectionAgain() {
        navigateToTrackingSection();
    }

    @Then("the tracking page should display options to view current orders")
    public void theTrackingPageShouldDisplayOptionsToViewCurrentOrdersAgain() {
        verifyTrackingOptionsDisplayed();
    }

    @When("the user selects the order with the tracking number {string} again")
    public void theUserSelectsTheOrderWithTheTrackingNumberAgain(String trackingNumber) {
        selectOrderWithTrackingNumber(trackingNumber);
    }

    @Then("tracking details should be displayed, including updated location and estimated delivery time")
    public void trackingDetailsShouldBeDisplayedIncludingUpdatedLocationAndEstimatedDeliveryTime() {
        verifyTrackingDetailsDisplayed();
    }

    @Given("the tracking details are displayed")
    public void theTrackingDetailsAreDisplayedAgain() {
        verifyTrackingDetailsDisplayed();
    }

    @When("the user verifies the tracking information")
    public void theUserVerifiesTheTrackingInformation() {
        verifyTrackingInformationConsistency();
    }

    @Then("the tracking information should consistently reflect the latest status")
    public void theTrackingInformationShouldConsistentlyReflectTheLatestStatus() {
        verifyTrackingInformationConsistency();
    }
}