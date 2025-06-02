package com.cucumber.steps;

import com.page_objects.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends OrderHistoryPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @Given("the user has previously placed an order")
    public void theUserHasPreviouslyPlacedAnOrder() {
        verifyPreviousOrderExists();
    }

    @When("the user navigates to the order history page")
    public void theUserNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed")
    public void theOrderHistoryPageIsDisplayed() {
        verifyOrderHistoryPageDisplayed();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        verifyOrderHistoryPageDisplayed();
    }

    @When("the user locates the order with Order ID {string} in the order history list")
    public void theUserLocatesTheOrderWithOrderIDInTheOrderHistoryList(String orderID) {
        locateOrderInHistory(orderID);
    }

    @Then("the order is located in the list")
    public void theOrderIsLocatedInTheList() {
        verifyOrderLocated();
    }

    @Then("the tracking link {string} is available")
    public void theTrackingLinkIsAvailable(String trackingLink) {
        verifyTrackingLinkAvailable(trackingLink);
    }

    @Given("the user has located the order in the order history list")
    public void theUserHasLocatedTheOrderInTheOrderHistoryList() {
        verifyOrderLocated();
    }

    @When("the user clicks on the tracking link associated with the order")
    public void theUserClicksOnTheTrackingLinkAssociatedWithTheOrder() {
        clickTrackingLink();
    }

    @Then("the tracking link opens in a new window/tab")
    public void theTrackingLinkOpensInANewWindowTab() {
        verifyTrackingLinkOpensInNewTab();
    }

    @Then("the tracking information is displayed correctly")
    public void theTrackingInformationIsDisplayedCorrectly() {
        verifyTrackingInformationDisplayed();
    }

    @Given("the tracking information is displayed")
    public void theTrackingInformationIsDisplayed() {
        verifyTrackingInformationDisplayed();
    }

    @Then("the current status of the order is displayed")
    public void theCurrentStatusOfTheOrderIsDisplayed() {
        verifyOrderStatusDisplayed();
    }

    @Then("the estimated delivery date is displayed")
    public void theEstimatedDeliveryDateIsDisplayed() {
        verifyEstimatedDeliveryDateDisplayed();
    }

    @Then("the carrier information is displayed correctly")
    public void theCarrierInformationIsDisplayedCorrectly() {
        verifyCarrierInformationDisplayed();
    }

    @Then("any updates in the tracking information are displayed")
    public void anyUpdatesInTheTrackingInformationAreDisplayed() {
        verifyTrackingUpdatesDisplayed();
    }

    @Given("the user is viewing the tracking information")
    public void theUserIsViewingTheTrackingInformation() {
        verifyTrackingInformationDisplayed();
    }

    @When("the user returns to the order history page")
    public void theUserReturnsToTheOrderHistoryPage() {
        returnToOrderHistoryPage();
    }

    @Then("the order history page is displayed")
    public void theOrderHistoryPageIsDisplayedAgain() {
        verifyOrderHistoryPageDisplayed();
    }

    @Then("the order details such as product name, quantity, price, and total cost are displayed correctly")
    public void theOrderDetailsAreDisplayedCorrectly() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the order status in the order history matches the tracking status")
    public void theOrderStatusInTheOrderHistoryMatchesTheTrackingStatus() {
        verifyOrderStatusMatchesTrackingStatus();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPageAgain() {
        verifyOrderHistoryPageDisplayed();
    }

    @When("the user attempts to track another order using a different tracking link")
    public void theUserAttemptsToTrackAnotherOrderUsingADifferentTrackingLink() {
        trackAnotherOrder();
    }

    @Then("the tracking link opens and displays information correctly")
    public void theTrackingLinkOpensAndDisplaysInformationCorrectly() {
        verifyTrackingLinkOpensAndDisplaysInformation();
    }

    @Given("the user has tracked orders using tracking links")
    public void theUserHasTrackedOrdersUsingTrackingLinks() {
        verifyTrackingLinksUsed();
    }

    @When("the system logs are checked")
    public void theSystemLogsAreChecked() {
        checkSystemLogs();
    }

    @Then("the system logs show order tracking activity")
    public void theSystemLogsShowOrderTrackingActivity() {
        verifyOrderTrackingActivityInLogs();
    }

    @Given("the user has tracked orders using tracking links")
    public void theUserHasTrackedOrdersUsingTrackingLinksAgain() {
        verifyTrackingLinksUsed();
    }

    @When("the system is checked for security alerts")
    public void theSystemIsCheckedForSecurityAlerts() {
        checkForSecurityAlerts();
    }

    @Then("no security alerts are triggered")
    public void noSecurityAlertsAreTriggered() {
        verifyNoSecurityAlertsTriggered();
    }

    @Given("the user is on a mobile device")
    public void theUserIsOnAMobileDevice() {
        verifyUserOnMobileDevice();
    }

    @When("the user accesses the tracking link")
    public void theUserAccessesTheTrackingLink() {
        accessTrackingLinkOnMobile();
    }

    @Then("the tracking link is accessible and functional on mobile devices")
    public void theTrackingLinkIsAccessibleAndFunctionalOnMobileDevices() {
        verifyTrackingLinkAccessibleOnMobile();
    }
}