package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the order history page")
    public void theUserNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @Then("the user should see a list of their past orders")
    public void theUserShouldSeeAListOfTheirPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects an order from the list")
    public void theUserSelectsAnOrderFromTheList() {
        selectOrderFromList();
    }

    @Then("the user should see the order status, payment method, and transaction date")
    public void theUserShouldSeeTheOrderStatusPaymentMethodAndTransactionDate() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user filters orders by a specific date range")
    public void theUserFiltersOrdersByASpecificDateRange() {
        filterOrdersByDateRange();
    }

    @Then("the user should see orders within that date range")
    public void theUserShouldSeeOrdersWithinThatDateRange() {
        verifyFilteredOrdersDisplayed();
    }

    @When("the user filters orders by a specific status")
    public void theUserFiltersOrdersByASpecificStatus() {
        filterOrdersByStatus();
    }

    @Then("the user should see orders with that status")
    public void theUserShouldSeeOrdersWithThatStatus() {
        verifyFilteredOrdersDisplayed();
    }

    @When("the user selects an order for detailed view")
    public void theUserSelectsAnOrderForDetailedView() {
        selectOrderForDetailedView();
    }

    @Then("the user should see detailed information for that order")
    public void theUserShouldSeeDetailedInformationForThatOrder() {
        verifyDetailedOrderInformationDisplayed();
    }

    @Given("the user is using a web browser")
    public void theUserIsUsingAWebBrowser() {
        verifyWebPlatform();
    }

    @When("the user logs into their account and navigates to the order history page")
    public void theUserLogsIntoTheirAccountAndNavigatesToTheOrderHistoryPage() {
        loginToAccount();
        navigateToOrderHistory();
    }

    @Then("the user should see their order history")
    public void theUserShouldSeeTheirOrderHistory() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is using a mobile device")
    public void theUserIsUsingAMobileDevice() {
        verifyMobilePlatform();
    }
}