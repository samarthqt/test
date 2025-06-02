package com.cucumber.steps;

import com.page_objects.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends OrderHistoryPage {

    @Given("the user has past orders with tracking enabled")
    public void theUserHasPastOrdersWithTrackingEnabled() {
        verifyPastOrdersWithTracking();
    }

    @When("the user logs into their account")
    public void theUserLogsIntoTheirAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with the tracking number OPQ789")
    public void theUserSelectsTheOrderWithTheTrackingNumberOPQ789() {
        selectOrderWithTrackingNumber("OPQ789");
    }

    @Then("the order details should be displayed, including tracking history")
    public void theOrderDetailsShouldBeDisplayedIncludingTrackingHistory() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user checks the tracking history of the package")
    public void theUserChecksTheTrackingHistoryOfThePackage() {
        checkTrackingHistory();
    }

    @Then("the tracking history should display all past locations: Warehouse, Distribution Center, In Transit, Delivered")
    public void theTrackingHistoryShouldDisplayAllPastLocations() {
        verifyTrackingHistoryLocations();
    }

    @When("the user verifies the timestamp of each location update")
    public void theUserVerifiesTheTimestampOfEachLocationUpdate() {
        verifyTimestampOfLocationUpdates();
    }

    @Then("each location update should have a corresponding timestamp")
    public void eachLocationUpdateShouldHaveACorrespondingTimestamp() {
        verifyTimestampPresence();
    }

    @When("the user verifies the delivery status")
    public void theUserVerifiesTheDeliveryStatus() {
        verifyDeliveryStatus();
    }

    @Then("the delivery status should be displayed as 'Delivered'")
    public void theDeliveryStatusShouldBeDisplayedAsDelivered() {
        verifyDeliveryStatusDisplayed();
    }

    @When("the user logs out of their account")
    public void theUserLogsOutOfTheirAccount() {
        logoutOfAccount();
    }

    @Then("the user should be successfully logged out")
    public void theUserShouldBeSuccessfullyLoggedOut() {
        verifySuccessfulLogout();
    }

    @When("the user logs back into their account")
    public void theUserLogsBackIntoTheirAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in again")
    public void theUserShouldBeSuccessfullyLoggedInAgain() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the 'Order History' section again")
    public void theUserNavigatesToTheOrderHistorySectionAgain() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrdersAgain() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with the tracking number OPQ789 again")
    public void theUserSelectsTheOrderWithTheTrackingNumberOPQ789Again() {
        selectOrderWithTrackingNumber("OPQ789");
    }

    @Then("the order details should be displayed, including tracking history")
    public void theOrderDetailsShouldBeDisplayedIncludingTrackingHistoryAgain() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user verifies that the tracking history remains consistent")
    public void theUserVerifiesThatTheTrackingHistoryRemainsConsistent() {
        verifyTrackingHistoryConsistency();
    }

    @Then("the tracking history should consistently reflect all past updates")
    public void theTrackingHistoryShouldConsistentlyReflectAllPastUpdates() {
        verifyConsistentTrackingHistory();
    }

    @When("the user checks for any discrepancies in the tracking history")
    public void theUserChecksForAnyDiscrepanciesInTheTrackingHistory() {
        checkForTrackingDiscrepancies();
    }

    @Then("there should be no discrepancies in the tracking history")
    public void thereShouldBeNoDiscrepanciesInTheTrackingHistory() {
        verifyNoTrackingDiscrepancies();
    }

    @When("the user verifies the ability to download or print tracking history")
    public void theUserVerifiesTheAbilityToDownloadOrPrintTrackingHistory() {
        verifyDownloadOrPrintTrackingHistory();
    }

    @Then("the user should be able to download or print tracking history")
    public void theUserShouldBeAbleToDownloadOrPrintTrackingHistory() {
        verifyDownloadOrPrintFunctionality();
    }

    @When("the user verifies notification settings for past orders")
    public void theUserVerifiesNotificationSettingsForPastOrders() {
        verifyNotificationSettings();
    }

    @Then("notification settings should be available for past orders")
    public void notificationSettingsShouldBeAvailableForPastOrders() {
        verifyNotificationSettingsAvailability();
    }

    @When("the user simulates a request for tracking history via customer support")
    public void theUserSimulatesARequestForTrackingHistoryViaCustomerSupport() {
        simulateTrackingHistoryRequest();
    }

    @Then("customer support should be able to provide tracking history upon request")
    public void customerSupportShouldBeAbleToProvideTrackingHistoryUponRequest() {
        verifyCustomerSupportTrackingHistory();
    }
}