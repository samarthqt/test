package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.OrderHistoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class OrderHistoryMaintenanceSteps extends OrderHistoryPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        // Implement login logic here
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToOrderHistory();
    }

    @Then("the account dashboard is displayed with order history")
    public void theAccountDashboardIsDisplayedWithOrderHistory() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is on the account dashboard with past orders")
    public void theUserIsOnTheAccountDashboardWithPastOrders() {
        navigateToOrderHistory();
    }

    @When("the user reviews the order history")
    public void theUserReviewsTheOrderHistory() {
        verifyOrderHistoryDisplayed();
    }

    @Then("all past orders are displayed with their respective statuses")
    public void allPastOrdersAreDisplayedWithTheirRespectiveStatuses() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is on the order history page")
    public void theUserIsOnTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @When("the user selects a past order")
    public void theUserSelectsAPastOrder() {
        selectOrder("sampleOrderID"); // Replace with actual order ID logic
    }

    @Then("the order details are displayed, including status and other relevant information")
    public void theOrderDetailsAreDisplayedIncludingStatusAndOtherRelevantInformation() {
        verifyOrderDetailsDisplayed();
    }
}