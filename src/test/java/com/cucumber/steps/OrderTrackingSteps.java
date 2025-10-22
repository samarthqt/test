package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.AccountDashboardPage;

public class OrderTrackingSteps extends AccountDashboardPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToAccountDashboard();
    }

    @Then("the account dashboard should display with order history for User ID {string}")
    public void theAccountDashboardShouldDisplayWithOrderHistoryForUserID(String userID) {
        verifyOrderHistoryDisplayed(userID);
    }

    @When("the user locates Order ID {string} in the order history")
    public void theUserLocatesOrderIDInTheOrderHistory(String orderID) {
        locateOrderInHistory(orderID);
    }

    @Then("Order ID {string} should be listed with current status {string}")
    public void orderIDShouldBeListedWithCurrentStatus(String orderID, String currentStatus) {
        verifyOrderStatus(orderID, currentStatus);
    }

    @When("a status change is simulated in the backend system")
    public void aStatusChangeIsSimulatedInTheBackendSystem() {
        simulateStatusChange();
    }

    @Then("the order status should update in real-time on the account dashboard")
    public void theOrderStatusShouldUpdateInRealTimeOnTheAccountDashboard() {
        verifyRealTimeStatusUpdate();
    }

    @Then("the user should receive a notification about the status change")
    public void theUserShouldReceiveANotificationAboutTheStatusChange() {
        verifyNotificationReceived();
    }
}