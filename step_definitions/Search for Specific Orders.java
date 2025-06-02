package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;
import com.page_objects.LoginPage;

public class OrderSearchSteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.launchUrl(getAppUrl());
        loginPage.maximizeWindow();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        LoginPage loginPage = new LoginPage();
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        LoginPage loginPage = new LoginPage();
        String expectedURL = testHarness.getData("LoginData", "ExpectedDashboardURL");
        loginPage.verifyHomePageRedirection(expectedURL);
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theUserNavigatesToTheLoginPage();
        theUserEntersValidCredentials();
        theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed with a list of past orders")
    public void theOrderHistoryPageIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user enters an order ID in the search bar")
    public void theUserEntersAnOrderIDInTheSearchBar() {
        String orderID = testHarness.getData("OrderData", "OrderID");
        enterOrderIDInSearch(orderID);
    }

    @Then("the system filters and displays the order matching the entered ID")
    public void theSystemFiltersAndDisplaysTheOrderMatchingTheEnteredID() {
        verifyOrderDisplayedByID();
    }

    @When("the user searches for orders by date range")
    public void theUserSearchesForOrdersByDateRange() {
        String startDate = testHarness.getData("OrderData", "StartDate");
        String endDate = testHarness.getData("OrderData", "EndDate");
        searchOrdersByDateRange(startDate, endDate);
    }

    @Then("orders within the specified date range are displayed")
    public void ordersWithinTheSpecifiedDateRangeAreDisplayed() {
        verifyOrdersDisplayedByDateRange();
    }

    @When("the user searches for orders using product name")
    public void theUserSearchesForOrdersUsingProductName() {
        String productName = testHarness.getData("OrderData", "ProductName");
        searchOrdersByProductName(productName);
    }

    @Then("orders containing the specified product are displayed")
    public void ordersContainingTheSpecifiedProductAreDisplayed() {
        verifyOrdersDisplayedByProductName();
    }

    @When("the user combines multiple search criteria \(e.g., date and product name\)")
    public void theUserCombinesMultipleSearchCriteria() {
        String startDate = testHarness.getData("OrderData", "StartDate");
        String endDate = testHarness.getData("OrderData", "EndDate");
        String productName = testHarness.getData("OrderData", "ProductName");
        combineSearchCriteria(startDate, endDate, productName);
    }

    @Then("the system accurately filters orders based on combined criteria")
    public void theSystemAccuratelyFiltersOrdersBasedOnCombinedCriteria() {
        verifyOrdersDisplayedByCombinedCriteria();
    }

    @When("the user attempts a search with invalid or non-existent criteria")
    public void theUserAttemptsASearchWithInvalidOrNonExistentCriteria() {
        String invalidCriteria = testHarness.getData("OrderData", "InvalidCriteria");
        searchWithInvalidCriteria(invalidCriteria);
    }

    @Then("the system displays a message indicating no matching orders found")
    public void theSystemDisplaysAMessageIndicatingNoMatchingOrdersFound() {
        verifyNoMatchingOrdersMessage();
    }

    @When("the user clears the search criteria")
    public void theUserClearsTheSearchCriteria() {
        clearSearchCriteria();
    }

    @Then("all orders are displayed, indicating the search criteria were cleared successfully")
    public void allOrdersAreDisplayedIndicatingTheSearchCriteriaWereClearedSuccessfully() {
        verifyAllOrdersDisplayed();
    }

    @When("the user performs search operations on different browsers")
    public void theUserPerformsSearchOperationsOnDifferentBrowsers() {
        performSearchOnDifferentBrowsers();
    }

    @Then("search functionality works consistently across different web browsers")
    public void searchFunctionalityWorksConsistentlyAcrossDifferentWebBrowsers() {
        verifySearchConsistencyAcrossBrowsers();
    }

    @When("the user performs search operations")
    public void theUserPerformsSearchOperations() {
        performSearchOperations();
    }

    @Then("search operations complete quickly and efficiently without delays")
    public void searchOperationsCompleteQuicklyAndEfficientlyWithoutDelays() {
        verifySearchPerformance();
    }

    @When("the user searches through a large number of orders")
    public void theUserSearchesThroughALargeNumberOfOrders() {
        searchThroughLargeNumberOfOrders();
    }

    @Then("the system handles large datasets effectively without performance degradation")
    public void theSystemHandlesLargeDatasetsEffectivelyWithoutPerformanceDegradation() {
        verifyLargeDatasetHandling();
    }

    @When("the user searches for orders using partial criteria \(e.g., part of the product name\)")
    public void theUserSearchesForOrdersUsingPartialCriteria() {
        String partialCriteria = testHarness.getData("OrderData", "PartialCriteria");
        searchWithPartialCriteria(partialCriteria);
    }

    @Then("the system suggests possible matches based on partial criteria")
    public void theSystemSuggestsPossibleMatchesBasedOnPartialCriteria() {
        verifyPartialCriteriaSuggestions();
    }

    @When("the user performs a search")
    public void theUserPerformsASearch() {
        performASearch();
    }

    @Then("search results accurately reflect the entered criteria")
    public void searchResultsAccuratelyReflectTheEnteredCriteria() {
        verifySearchResultsAccuracy();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logoutUser();
    }

    @When("the user attempts to search for orders")
    public void theUserAttemptsToSearchForOrders() {
        attemptSearchWhileLoggedOut();
    }

    @Then("the system prevents search operations when the user is not logged in")
    public void theSystemPreventsSearchOperationsWhenTheUserIsNotLoggedIn() {
        verifySearchPreventionWhenLoggedOut();
    }

    @When("the user performs search operations")
    public void theUserPerformsSearchOperationsAgain() {
        performSearchOperations();
    }

    @Then("no error messages are displayed, indicating a smooth search process")
    public void noErrorMessagesAreDisplayedIndicatingASmoothSearchProcess() {
        verifyNoErrorMessagesDuringSearch();
    }
}