package com.cucumber.steps;

import com.page_objects.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends OrderHistoryPage {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        enterCredentials();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Then("the user is redirected to the dashboard")
    public void theUserIsRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
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
        verifyOrderHistoryPageDisplayed();
    }

    @When("the user views the filter options")
    public void theUserViewsTheFilterOptions() {
        viewFilterOptions();
    }

    @Then("filter options for date, status, and payment method are visible")
    public void filterOptionsForDateStatusAndPaymentMethodAreVisible() {
        verifyFilterOptionsVisible();
    }

    @When("the user applies a filter for a specific date range")
    public void theUserAppliesAFilterForASpecificDateRange() {
        applyDateRangeFilter();
    }

    @Then("the order history updates to show only orders within the specified date range")
    public void theOrderHistoryUpdatesToShowOnlyOrdersWithinTheSpecifiedDateRange() {
        verifyDateRangeFilterApplied();
    }

    @Given("the user has applied a date filter")
    public void theUserHasAppliedADateFilter() {
        applyDateRangeFilter();
    }

    @When("the user clears the date filter")
    public void theUserClearsTheDateFilter() {
        clearDateFilter();
    }

    @Then("the order history reverts to showing all orders")
    public void theOrderHistoryRevertsToShowingAllOrders() {
        verifyAllOrdersDisplayed();
    }

    @When("the user applies a filter for a specific status")
    public void theUserAppliesAFilterForASpecificStatus() {
        applyStatusFilter();
    }

    @Then("the order history updates to show only orders with the selected status")
    public void theOrderHistoryUpdatesToShowOnlyOrdersWithTheSelectedStatus() {
        verifyStatusFilterApplied();
    }

    @Given("the user has applied a status filter")
    public void theUserHasAppliedAStatusFilter() {
        applyStatusFilter();
    }

    @When("the user clears the status filter")
    public void theUserClearsTheStatusFilter() {
        clearStatusFilter();
    }

    @When("the user applies a filter for a specific payment method")
    public void theUserAppliesAFilterForASpecificPaymentMethod() {
        applyPaymentMethodFilter();
    }

    @Then("the order history updates to show only orders with the selected payment method")
    public void theOrderHistoryUpdatesToShowOnlyOrdersWithTheSelectedPaymentMethod() {
        verifyPaymentMethodFilterApplied();
    }

    @Given("the user has applied a payment method filter")
    public void theUserHasAppliedAPaymentMethodFilter() {
        applyPaymentMethodFilter();
    }

    @When("the user clears the payment method filter")
    public void theUserClearsThePaymentMethodFilter() {
        clearPaymentMethodFilter();
    }

    @When("the user applies multiple filters simultaneously")
    public void theUserAppliesMultipleFiltersSimultaneously() {
        applyMultipleFilters();
    }

    @Then("the order history updates to show orders matching all selected filter criteria")
    public void theOrderHistoryUpdatesToShowOrdersMatchingAllSelectedFilterCriteria() {
        verifyMultipleFiltersApplied();
    }

    @Given("the user has applied multiple filters")
    public void theUserHasAppliedMultipleFilters() {
        applyMultipleFilters();
    }

    @When("the user clears all filters")
    public void theUserClearsAllFilters() {
        clearAllFilters();
    }

    @When("the user applies a filter with an invalid date range")
    public void theUserAppliesAFilterWithAnInvalidDateRange() {
        applyInvalidDateRangeFilter();
    }

    @Then("the system displays an error message indicating an invalid date range")
    public void theSystemDisplaysAnErrorMessageIndicatingAnInvalidDateRange() {
        verifyInvalidDateRangeErrorMessage();
    }

    @Given("the user has applied filters on the Order History page")
    public void theUserHasAppliedFiltersOnTheOrderHistoryPage() {
        applyMultipleFilters();
    }

    @When("the user navigates away and then returns to the Order History page")
    public void theUserNavigatesAwayAndThenReturnsToTheOrderHistoryPage() {
        navigateAwayAndReturnToOrderHistory();
    }

    @Then("the filters remain applied")
    public void theFiltersRemainApplied() {
        verifyFiltersRetained();
    }

    @Given("the user is accessing the Order History page on different devices")
    public void theUserIsAccessingTheOrderHistoryPageOnDifferentDevices() {
        accessOrderHistoryOnDifferentDevices();
    }

    @When("the user views the filter options")
    public void theUserViewsTheFilterOptionsOnDifferentDevices() {
        viewFilterOptions();
    }

    @Then("the filter options are accessible and functional across devices")
    public void theFilterOptionsAreAccessibleAndFunctionalAcrossDevices() {
        verifyFilterOptionsResponsive();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logoutUser();
    }

    @When("the user attempts to apply filters on the Order History page")
    public void theUserAttemptsToApplyFiltersOnTheOrderHistoryPage() {
        attemptToApplyFiltersWhileLoggedOut();
    }

    @Then("the user is prompted to log in before applying filters")
    public void theUserIsPromptedToLogInBeforeApplyingFilters() {
        verifyLoginPromptDisplayed();
    }
}