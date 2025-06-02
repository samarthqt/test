package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a User ID {string}")
    public void theUserHasAUserID(String userID) {
        loginWithUserID(userID);
    }

    @When("the user logs into the account")
    public void theUserLogsIntoTheAccount() {
        verifyUserLoggedIn();
    }

    @Then("the user is successfully logged in and navigated to the account dashboard")
    public void theUserIsSuccessfullyLoggedInAndNavigatedToTheAccountDashboard() {
        verifyAccountDashboardDisplayed();
    }

    @Given("the user is on the account dashboard")
    public void theUserIsOnTheAccountDashboard() {
        verifyAccountDashboardDisplayed();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed with a list of past orders")
    public void theOrderHistoryPageIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user enters the date range from {string} to {string} in the search filter")
    public void theUserEntersTheDateRangeInTheSearchFilter(String startDate, String endDate) {
        enterDateRange(startDate, endDate);
    }

    @Then("the date range filter is applied successfully")
    public void theDateRangeFilterIsAppliedSuccessfully() {
        verifyDateRangeFilterApplied();
    }

    @Given("the date range filter is applied")
    public void theDateRangeFilterIsApplied() {
        verifyDateRangeFilterApplied();
    }

    @When("the user clicks the 'Search' button")
    public void theUserClicksTheSearchButton() {
        clickSearchButton();
    }

    @Then("orders within the specified date range are displayed")
    public void ordersWithinTheSpecifiedDateRangeAreDisplayed() {
        verifyOrdersDisplayedWithinDateRange();
    }

    @Given("orders are displayed based on the date range")
    public void ordersAreDisplayedBasedOnTheDateRange() {
        verifyOrdersDisplayedWithinDateRange();
    }

    @Then("all displayed orders fall within the date range from {string} to {string}")
    public void allDisplayedOrdersFallWithinTheDateRange(String startDate, String endDate) {
        verifyOrdersMatchDateRange(startDate, endDate);
    }

    @Then("order details are accurate and complete for each order displayed")
    public void orderDetailsAreAccurateAndCompleteForEachOrderDisplayed() {
        verifyOrderDetailsAccuracy();
    }

    @Given("orders are filtered based on the date range")
    public void ordersAreFilteredBasedOnTheDateRange() {
        verifyOrdersDisplayedWithinDateRange();
    }

    @When("the user attempts to export the filtered order list")
    public void theUserAttemptsToExportTheFilteredOrderList() {
        exportFilteredOrderList();
    }

    @Then("the filtered order list is exported successfully")
    public void theFilteredOrderListIsExportedSuccessfully() {
        verifyOrderListExported();
    }

    @Given("the filtered order list is exported")
    public void theFilteredOrderListIsExported() {
        verifyOrderListExported();
    }

    @Then("the exported list contains the same orders as displayed on the screen")
    public void theExportedListContainsTheSameOrdersAsDisplayedOnTheScreen() {
        verifyExportedListMatchesDisplayedOrders();
    }

    @When("the user changes the date range to a different set of dates and repeats the search")
    public void theUserChangesTheDateRangeAndRepeatsTheSearch() {
        changeDateRangeAndSearch();
    }

    @Then("orders within the new date range are displayed")
    public void ordersWithinTheNewDateRangeAreDisplayed() {
        verifyOrdersDisplayedWithinNewDateRange();
    }

    @Given("the user performs a search with a date range")
    public void theUserPerformsASearchWithADateRange() {
        performDateRangeSearch();
    }

    @When("the user changes the date range and performs another search")
    public void theUserChangesTheDateRangeAndPerformsAnotherSearch() {
        changeDateRangeAndSearch();
    }

    @Then("the system supports consecutive searches with different date ranges without errors")
    public void theSystemSupportsConsecutiveSearchesWithoutErrors() {
        verifyConsecutiveSearchesSupported();
    }

    @Given("the user enters a date range with no orders")
    public void theUserEntersADateRangeWithNoOrders() {
        enterDateRangeWithNoOrders();
    }

    @Then("the system displays a message indicating no orders found for the specified date range")
    public void theSystemDisplaysAMessageIndicatingNoOrdersFound() {
        verifyNoOrdersFoundMessageDisplayed();
    }

    @Given("the user performs a search and filter operation")
    public void theUserPerformsASearchAndFilterOperation() {
        performSearchAndFilterOperation();
    }

    @Then("the system responds promptly to the search and filter operation")
    public void theSystemRespondsPromptlyToTheSearchAndFilterOperation() {
        verifySystemResponseTime();
    }

    @Then("system logs indicate the search and filter operation and any results returned")
    public void systemLogsIndicateTheSearchAndFilterOperation() {
        verifySystemLogsForSearchAndFilter();
    }

    @Then("user account details remain unchanged and secure")
    public void userAccountDetailsRemainUnchangedAndSecure() {
        verifyUserAccountSecurity();
    }

    @Given("the user enters invalid date formats in the search filter")
    public void theUserEntersInvalidDateFormatsInTheSearchFilter() {
        enterInvalidDateFormats();
    }

    @Then("the system displays an error message indicating invalid date formats")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidDateFormats() {
        verifyInvalidDateFormatErrorMessage();
    }
}