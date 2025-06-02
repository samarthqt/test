package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid order with Order ID {string} and tracking number {string}")
    public void theUserHasAValidOrderWithOrderIDAndTrackingNumber(String orderID, String trackingNumber) {
        testHarness.storeData("OrderData", "OrderID", orderID);
        testHarness.storeData("OrderData", "TrackingNumber", trackingNumber);
    }

    @When("the user logs into their account")
    public void theUserLogsIntoTheirAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with the tracking number {string}")
    public void theUserSelectsTheOrderWithTheTrackingNumber(String trackingNumber) {
        selectOrderByTrackingNumber(trackingNumber);
    }

    @Then("the order details should be displayed, including tracking information")
    public void theOrderDetailsShouldBeDisplayedIncludingTrackingInformation() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the current location of the package should be displayed as {string}")
    public void theCurrentLocationOfThePackageShouldBeDisplayedAs(String location) {
        verifyPackageLocation(location);
    }

    @Then("the estimated delivery time should be displayed as {string}")
    public void theEstimatedDeliveryTimeShouldBeDisplayedAs(String deliveryTime) {
        verifyEstimatedDeliveryTime(deliveryTime);
    }

    @When("the package location is simulated to change to {string}")
    public void thePackageLocationIsSimulatedToChangeTo(String newLocation) {
        simulatePackageLocationChange(newLocation);
    }

    @Then("the tracking information should update in real-time to {string}")
    public void theTrackingInformationShouldUpdateInRealTimeTo(String updatedLocation) {
        verifyRealTimeTrackingUpdate(updatedLocation);
    }

    @When("the user refreshes the tracking page")
    public void theUserRefreshesTheTrackingPage() {
        refreshTrackingPage();
    }

    @Then("the page should display the updated location {string}")
    public void thePageShouldDisplayTheUpdatedLocation(String updatedLocation) {
        verifyUpdatedLocationDisplayed(updatedLocation);
    }

    @When("the user checks the timestamp of the last update")
    public void theUserChecksTheTimestampOfTheLastUpdate() {
        checkTimestampOfLastUpdate();
    }

    @Then("the timestamp should reflect the current time of update")
    public void theTimestampShouldReflectTheCurrentTimeOfUpdate() {
        verifyTimestampReflectsCurrentTime();
    }

    @When("delivery completion is simulated")
    public void deliveryCompletionIsSimulated() {
        simulateDeliveryCompletion();
    }

    @Then("the status should update to {string}")
    public void theStatusShouldUpdateTo(String status) {
        verifyStatusUpdate(status);
    }

    @Then("the user should receive a notification for delivery completion")
    public void theUserShouldReceiveANotificationForDeliveryCompletion() {
        verifyDeliveryCompletionNotification();
    }

    @When("the user logs out of their account")
    public void theUserLogsOutOfTheirAccount() {
        logoutOfAccount();
    }

    @Then("the user should be successfully logged out")
    public void theUserShouldBeSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }

    @When("the user logs back into their account")
    public void theUserLogsBackIntoTheirAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in again")
    public void theUserShouldBeSuccessfullyLoggedInAgain() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Order History' section again")
    public void theUserNavigatesToTheOrderHistorySectionAgain() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrdersAgain() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with the tracking number {string} again")
    public void theUserSelectsTheOrderWithTheTrackingNumberAgain(String trackingNumber) {
        selectOrderByTrackingNumber(trackingNumber);
    }

    @Then("the order details should be displayed, including updated tracking information")
    public void theOrderDetailsShouldBeDisplayedIncludingUpdatedTrackingInformation() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the tracking information should consistently reflect the latest status")
    public void theTrackingInformationShouldConsistentlyReflectTheLatestStatus() {
        verifyConsistentTrackingInformation();
    }
}