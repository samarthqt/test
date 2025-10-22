package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.AccountDashboardPage;

public class AccessTrackingLinkSteps extends AccountDashboardPage {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginToAccount();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        navigateToAccountDashboard();
    }

    @Then("the account dashboard is displayed with order history")
    public void theAccountDashboardIsDisplayedWithOrderHistory() {
        verifyAccountDashboardDisplayed();
    }

    @When("the user locates Order ID 66666 in the order history")
    public void theUserLocatesOrderIDInTheOrderHistory() {
        locateOrderInHistory("66666");
    }

    @Then("Order ID 66666 is listed with status 'Shipped'")
    public void orderIDIsListedWithStatusShipped() {
        verifyOrderStatus("66666", "Shipped");
    }

    @When("the user selects Order ID 66666 to view details")
    public void theUserSelectsOrderIDToViewDetails() {
        selectOrderToViewDetails("66666");
    }

    @Then("order details are displayed, including status and tracking link")
    public void orderDetailsAreDisplayedIncludingStatusAndTrackingLink() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user selects the tracking link")
    public void theUserSelectsTheTrackingLink() {
        selectTrackingLink();
    }

    @Then("the tracking page is opened, displaying real-time shipment status")
    public void theTrackingPageIsOpenedDisplayingRealTimeShipmentStatus() {
        verifyTrackingPageOpened();
    }
}