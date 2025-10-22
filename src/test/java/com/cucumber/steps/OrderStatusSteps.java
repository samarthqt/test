package com.cucumber.steps;

import com.pageobjects.OrderStatusPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class OrderStatusSteps {

    private OrderStatusPage orderStatusPage = new OrderStatusPage();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        orderStatusPage.loginToAccount();
    }

    @When("the user navigates to the account dashboard")
    public void theUserNavigatesToTheAccountDashboard() {
        orderStatusPage.navigateToAccountDashboard();
    }

    @Then("the account dashboard is displayed with order history")
    public void theAccountDashboardIsDisplayedWithOrderHistory() {
        orderStatusPage.verifyAccountDashboardDisplayed();
    }

    @When("the user locates Order ID 22222 in the order history")
    public void theUserLocatesOrderID22222InTheOrderHistory() {
        orderStatusPage.locateOrderInHistory("22222");
    }

    @Then("Order ID 22222 is listed with status 'Shipped'")
    public void orderID22222IsListedWithStatusShipped() {
        orderStatusPage.verifyOrderStatus("22222", "Shipped");
    }

    @When("the user selects Order ID 22222 to view details")
    public void theUserSelectsOrderID22222ToViewDetails() {
        orderStatusPage.selectOrderToViewDetails("22222");
    }

    @Then("order details are displayed, including status and tracking link")
    public void orderDetailsAreDisplayedIncludingStatusAndTrackingLink() {
        orderStatusPage.verifyOrderDetailsDisplayed();
    }

    @When("the user selects the tracking link")
    public void theUserSelectsTheTrackingLink() {
        orderStatusPage.selectTrackingLink();
    }

    @Then("the tracking page is opened, displaying real-time shipment status")
    public void theTrackingPageIsOpenedDisplayingRealTimeShipmentStatus() {
        orderStatusPage.verifyTrackingPageDisplayed();
    }

    @When("the user locates Order ID 33333 in the order history")
    public void theUserLocatesOrderID33333InTheOrderHistory() {
        orderStatusPage.locateOrderInHistory("33333");
    }

    @Then("Order ID 33333 is listed with status 'Delivered'")
    public void orderID33333IsListedWithStatusDelivered() {
        orderStatusPage.verifyOrderStatus("33333", "Delivered");
    }

    @When("the user selects Order ID 33333 to view details")
    public void theUserSelectsOrderID33333ToViewDetails() {
        orderStatusPage.selectOrderToViewDetails("33333");
    }

    @Then("order details are displayed, including status and delivery confirmation")
    public void orderDetailsAreDisplayedIncludingStatusAndDeliveryConfirmation() {
        orderStatusPage.verifyOrderDetailsDisplayed();
    }
}
