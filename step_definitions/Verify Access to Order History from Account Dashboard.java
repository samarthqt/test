package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with previous orders")
    public void aUserAccountWithPreviousOrders() {
        // Assume user account setup with previous orders
    }

    @When("the user logs in to their account")
    public void theUserLogsInToTheirAccount() {
        loginToAccount();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToAccountDashboard();
    }

    @Then("the account dashboard is displayed")
    public void theAccountDashboardIsDisplayed() {
        verifyAccountDashboardDisplayed();
    }

    @Given("the account dashboard is displayed")
    public void theAccountDashboardIsDisplayedAgain() {
        verifyAccountDashboardDisplayed();
    }

    @When("the user locates the order history section on the dashboard")
    public void theUserLocatesTheOrderHistorySectionOnTheDashboard() {
        locateOrderHistorySection();
    }

    @Then("the order history section is visible on the dashboard")
    public void theOrderHistorySectionIsVisibleOnTheDashboard() {
        verifyOrderHistorySectionVisible();
    }

    @Given("the order history section is visible")
    public void theOrderHistorySectionIsVisible() {
        verifyOrderHistorySectionVisible();
    }

    @When("the user clicks on the order history section")
    public void theUserClicksOnTheOrderHistorySection() {
        clickOrderHistorySection();
    }

    @Then("the order history details are displayed")
    public void theOrderHistoryDetailsAreDisplayed() {
        verifyOrderHistoryDetailsDisplayed();
    }

    @Given("the order history details are displayed")
    public void theOrderHistoryDetailsAreDisplayedAgain() {
        verifyOrderHistoryDetailsDisplayed();
    }

    @Then("all past orders are listed with relevant details")
    public void allPastOrdersAreListedWithRelevantDetails() {
        verifyPastOrdersListed();
    }

    @Given("the list of past orders is displayed")
    public void theListOfPastOrdersIsDisplayed() {
        verifyPastOrdersListed();
    }

    @When("the user checks the details of a specific order from the list")
    public void theUserChecksTheDetailsOfASpecificOrderFromTheList() {
        checkSpecificOrderDetails();
    }

    @Then("the order details including items, quantities, prices, and status are displayed")
    public void theOrderDetailsIncludingItemsQuantitiesPricesAndStatusAreDisplayed() {
        verifySpecificOrderDetails();
    }

    @Then("orders are sorted from most recent to oldest")
    public void ordersAreSortedFromMostRecentToOldest() {
        verifyOrdersSortedByDate();
    }

    @When("the user filters orders by selecting a specific date range")
    public void theUserFiltersOrdersBySelectingASpecificDateRange() {
        filterOrdersByDateRange();
    }

    @Then("the user can filter orders by date range")
    public void theUserCanFilterOrdersByDateRange() {
        verifyOrdersFilteredByDateRange();
    }

    @When("the user searches for specific orders using keywords or order numbers")
    public void theUserSearchesForSpecificOrdersUsingKeywordsOrOrderNumbers() {
        searchOrders();
    }

    @Then("the user can search for specific orders")
    public void theUserCanSearchForSpecificOrders() {
        verifyOrderSearchResults();
    }

    @Then("each order displays its payment and delivery status clearly")
    public void eachOrderDisplaysItsPaymentAndDeliveryStatusClearly() {
        verifyPaymentAndDeliveryStatus();
    }

    @When("the user downloads invoices for past orders")
    public void theUserDownloadsInvoicesForPastOrders() {
        downloadOrderInvoices();
    }

    @Then("the user can download order invoices")
    public void theUserCanDownloadOrderInvoices() {
        verifyInvoicesDownloaded();
    }

    @When("the user logs out from their account")
    public void theUserLogsOutFromTheirAccount() {
        logoutFromAccount();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @When("the user logs back in")
    public void theUserLogsBackIn() {
        loginToAccount();
    }

    @Then("the order history remains accessible and unchanged")
    public void theOrderHistoryRemainsAccessibleAndUnchanged() {
        verifyOrderHistoryUnchanged();
    }

    @When("the user accesses the order history section on different devices")
    public void theUserAccessesTheOrderHistorySectionOnDifferentDevices() {
        accessOrderHistoryOnDifferentDevices();
    }

    @Then("the order history is accessible and displays correctly on various devices")
    public void theOrderHistoryIsAccessibleAndDisplaysCorrectlyOnVariousDevices() {
        verifyOrderHistoryResponsive();
    }

    @Then("the order history data is secure and accessible only to the authorized user")
    public void theOrderHistoryDataIsSecureAndAccessibleOnlyToTheAuthorizedUser() {
        verifyOrderHistoryDataSecurity();
    }
}