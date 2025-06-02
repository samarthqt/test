package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderStatusPage;

public class OrderStatusSteps extends OrderStatusPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @Given("an order has been placed")
    public void anOrderHasBeenPlaced() {
        verifyOrderPlaced();
    }

    @When("the user navigates to the 'Orders' section in the account dashboard")
    public void theUserNavigatesToTheOrdersSectionInTheAccountDashboard() {
        navigateToOrdersSection();
    }

    @Then("the 'Orders' section is displayed")
    public void theOrdersSectionIsDisplayed() {
        verifyOrdersSectionDisplayed();
    }

    @When("the user selects the most recent order from the list")
    public void theUserSelectsTheMostRecentOrderFromTheList() {
        selectMostRecentOrder();
    }

    @Then("the order details are displayed")
    public void theOrderDetailsAreDisplayed() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the order status matches the current status in the system")
    public void theOrderStatusMatchesTheCurrentStatusInTheSystem() {
        verifyOrderStatus();
    }

    @Then("the tracking number is displayed correctly")
    public void theTrackingNumberIsDisplayedCorrectly() {
        verifyTrackingNumber();
    }

    @When("the user clicks on the tracking number to view shipping details")
    public void theUserClicksOnTheTrackingNumberToViewShippingDetails() {
        clickTrackingNumber();
    }

    @Then("the shipping details are displayed with tracking information")
    public void theShippingDetailsAreDisplayedWithTrackingInformation() {
        verifyShippingDetails();
    }

    @Then("the estimated delivery date is displayed correctly")
    public void theEstimatedDeliveryDateIsDisplayedCorrectly() {
        verifyEstimatedDeliveryDate();
    }

    @Then("any updates or changes in delivery status are displayed")
    public void anyUpdatesOrChangesInDeliveryStatusAreDisplayed() {
        verifyDeliveryStatusUpdates();
    }

    @When("the user ensures the tracking link redirects to the carrier's website")
    public void theUserEnsuresTheTrackingLinkRedirectsToTheCarriersWebsite() {
        verifyTrackingLinkRedirection();
    }

    @Then("the tracking link redirects correctly to the carrier's website")
    public void theTrackingLinkRedirectsCorrectlyToTheCarriersWebsite() {
        verifyCarrierWebsiteRedirection();
    }

    @Then("the order summary matches the transaction details")
    public void theOrderSummaryMatchesTheTransactionDetails() {
        verifyOrderSummary();
    }

    @Then("all relevant notifications are displayed in the dashboard")
    public void allRelevantNotificationsAreDisplayedInTheDashboard() {
        verifyNotifications();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the order status and tracking details persist after logging back in")
    public void theOrderStatusAndTrackingDetailsPersistAfterLoggingBackIn() {
        verifyOrderStatusPersistence();
    }

    @Then("the order can be filtered by its current status")
    public void theOrderCanBeFilteredByItsCurrentStatus() {
        filterOrderByStatus();
    }

    @Then("the order can be archived successfully")
    public void theOrderCanBeArchivedSuccessfully() {
        archiveOrder();
    }

    @Then("archived orders remain accessible in the user dashboard")
    public void archivedOrdersRemainAccessibleInTheUserDashboard() {
        verifyArchivedOrdersAccessibility();
    }
}