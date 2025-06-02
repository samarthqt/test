package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account with multiple past orders")
    public void theUserIsLoggedIntoTheirAccountWithMultiplePastOrders() {
        loginToAccountWithOrders();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the Order History page is displayed")
    public void theOrderHistoryPageIsDisplayed() {
        verifyOrderHistoryPageDisplayed();
    }

    @Given("the user is on the Order History page")
    public void theUserIsOnTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @Then("all past orders are accurately listed")
    public void allPastOrdersAreAccuratelyListed() {
        verifyAllPastOrdersListed();
    }

    @Given("the user selects a random order from the Order History")
    public void theUserSelectsARandomOrderFromTheOrderHistory() {
        selectRandomOrder();
    }

    @Then("the displayed order date matches the date in the order confirmation email")
    public void theDisplayedOrderDateMatchesTheDateInTheOrderConfirmationEmail() {
        verifyOrderDateMatches();
    }

    @Then("the order status is consistent with the status in the order confirmation email")
    public void theOrderStatusIsConsistentWithTheStatusInTheOrderConfirmationEmail() {
        verifyOrderStatusConsistency();
    }

    @Then("the payment details match those in the order confirmation email")
    public void thePaymentDetailsMatchThoseInTheOrderConfirmationEmail() {
        verifyPaymentDetailsMatch();
    }

    @Then("the product details are consistent with those in the order confirmation email")
    public void theProductDetailsAreConsistentWithThoseInTheOrderConfirmationEmail() {
        verifyProductDetailsConsistency();
    }

    @Then("the total cost matches the amount in the order confirmation email")
    public void theTotalCostMatchesTheAmountInTheOrderConfirmationEmail() {
        verifyTotalCostMatches();
    }

    @Then("no discrepancies are found; data is accurate and consistent")
    public void noDiscrepanciesAreFoundDataIsAccurateAndConsistent() {
        verifyNoDiscrepanciesInData();
    }

    @Given("the user applies filters in the Order History section")
    public void theUserAppliesFiltersInTheOrderHistorySection() {
        applyFiltersInOrderHistory();
    }

    @Then("the filtered data remains accurate and consistent")
    public void theFilteredDataRemainsAccurateAndConsistent() {
        verifyFilteredDataAccuracy();
    }

    @Then("all orders are present; no orders are missing")
    public void allOrdersArePresentNoOrdersAreMissing() {
        verifyNoMissingOrders();
    }

    @When("the user attempts to manipulate data through the browser console")
    public void theUserAttemptsToManipulateDataThroughTheBrowserConsole() {
        attemptDataManipulation();
    }

    @Then("data manipulation is not possible; data integrity is maintained")
    public void dataManipulationIsNotPossibleDataIntegrityIsMaintained() {
        verifyDataIntegrity();
    }

    @Given("the system has been updated")
    public void theSystemHasBeenUpdated() {
        systemUpdate();
    }

    @When("the user accesses the Order History section")
    public void theUserAccessesTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("data remains accurate and consistent post-update")
    public void dataRemainsAccurateAndConsistentPostUpdate() {
        verifyDataPostUpdate();
    }

    @Given("the user logs out of their account")
    public void theUserLogsOutOfTheirAccount() {
        logout();
    }

    @When("the user attempts to view the Order History")
    public void theUserAttemptsToViewTheOrderHistory() {
        attemptToViewOrderHistory();
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        verifyRedirectionToLoginPage();
    }

    @Given("the user accesses the Order History section on different devices")
    public void theUserAccessesTheOrderHistorySectionOnDifferentDevices() {
        accessOrderHistoryOnDifferentDevices();
    }

    @Then("data is accurate and consistent across all devices")
    public void dataIsAccurateAndConsistentAcrossAllDevices() {
        verifyDataConsistencyAcrossDevices();
    }
}