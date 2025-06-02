package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrdersPage;

public class AlertsSteps extends OrdersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is logged in to the Dynamics 365 system with valid credentials")
    public void userLoggedInWithValidCredentials() {
        loginToSystem(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Given("the dashboard is displayed")
    public void dashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Given("a shipment order with ID 54321 exists")
    public void shipmentOrderExists() {
        verifyOrderExists("54321");
    }

    @Given("the customer has subscribed to shipment alerts")
    public void customerSubscribedToAlerts() {
        verifyCustomerSubscription();
    }

    @When("the user navigates to the 'Orders' module")
    public void navigateToOrdersModule() {
        navigateToOrders();
    }

    @When("the orders module is displayed with a list of orders")
    public void ordersModuleDisplayed() {
        verifyOrdersModuleDisplayed();
    }

    @When("the customer's email address is invalid as \"invalidemail@.com\"")
    public void customerEmailIsInvalid() {
        verifyInvalidEmail("invalidemail@.com");
    }

    @Then("the user selects the order with ID 54321")
    public void selectOrderWithID() {
        selectOrder("54321");
    }

    @Then("the order details for order ID 54321 are displayed")
    public void orderDetailsDisplayed() {
        verifyOrderDetailsDisplayed("54321");
    }

    @Then("the shipment status is 'Delivered'")
    public void shipmentStatusIsDelivered() {
        verifyShipmentStatus("Delivered");
    }

    @When("the user updates the shipment status to 'Delivered'")
    public void updateShipmentStatus() {
        updateShipmentStatusToDelivered();
    }

    @Then("the shipment status is updated to 'Delivered'")
    public void shipmentStatusUpdated() {
        verifyShipmentStatusUpdated("Delivered");
    }

    @Then("the alert system is checked for outgoing alerts")
    public void checkAlertSystem() {
        checkAlertSystemForOutgoingAlerts();
    }

    @Then("no alert is sent due to invalid email address")
    public void noAlertSent() {
        verifyNoAlertSent();
    }

    @Then("the error logs are verified for alert sending failures")
    public void verifyErrorLogs() {
        verifyErrorLogsForFailures();
    }

    @Then("an error is logged indicating failure to send alert to \"invalidemail@.com\"")
    public void errorLoggedForInvalidEmail() {
        verifyErrorLoggedForInvalidEmail("invalidemail@.com");
    }
}