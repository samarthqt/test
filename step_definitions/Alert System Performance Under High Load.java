package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSystemSteps extends AlertSystemPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the Dynamics 365 system with valid credentials")
    public void theUserIsLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Given("the dashboard is displayed")
    public void theDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Given("multiple shipment orders exist with Order IDs ranging from 10001 to 10050")
    public void multipleShipmentOrdersExistWithOrderIDs() {
        verifyOrdersExist(10001, 10050);
    }

    @Given("customers have subscribed to shipment alerts")
    public void customersHaveSubscribedToShipmentAlerts() {
        verifyCustomerSubscriptions();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @Then("the user selects orders with IDs ranging from 10001 to 10050")
    public void theUserSelectsOrdersWithIDs() {
        selectOrders(10001, 10050);
    }

    @Then("order details for each selected order are displayed")
    public void orderDetailsForEachSelectedOrderAreDisplayed() {
        verifyOrderDetailsDisplayed(10001, 10050);
    }

    @Then("the shipment status is 'Dispatched'")
    public void theShipmentStatusIsDispatched() {
        verifyShipmentStatus("Dispatched");
    }

    @When("the user updates the shipment status of all selected orders to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatus() {
        updateShipmentStatus("Dispatched", 10001, 10050);
    }

    @Then("the shipment status for all selected orders is updated to 'Dispatched'")
    public void theShipmentStatusForAllSelectedOrdersIsUpdated() {
        verifyShipmentStatusUpdated("Dispatched", 10001, 10050);
    }

    @Then("the alert system is monitored for outgoing alerts")
    public void theAlertSystemIsMonitoredForOutgoingAlerts() {
        monitorAlertSystem();
    }

    @Then("alerts are sent to customer@example.com for all orders without delay")
    public void alertsAreSentToCustomerWithoutDelay() {
        verifyAlertsSent("customer@example.com", 10001, 10050);
    }

    @When("the system's performance metrics are verified")
    public void theSystemsPerformanceMetricsAreVerified() {
        verifyPerformanceMetrics();
    }

    @Then("the system maintains optimal performance under high load conditions")
    public void theSystemMaintainsOptimalPerformance() {
        verifyOptimalPerformanceUnderLoad();
    }
}