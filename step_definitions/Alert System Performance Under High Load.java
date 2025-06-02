package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AlertSystemPage;

public class AlertSystemSteps extends AlertSystemPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToDynamics365(username, password);
    }

    @Then("the user is logged in and the dashboard is displayed")
    public void theUserIsLoggedInAndTheDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Then("multiple shipment orders exist in the system with Order IDs ranging from 10001 to 10050")
    public void multipleShipmentOrdersExistInTheSystemWithOrderIDs() {
        verifyOrdersExist(10001, 10050);
    }

    @Then("customers have subscribed to shipment alerts")
    public void customersHaveSubscribedToShipmentAlerts() {
        verifyCustomerSubscriptions();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @When("the user selects orders with IDs ranging from 10001 to 10050")
    public void theUserSelectsOrdersWithIDs() {
        selectOrders(10001, 10050);
    }

    @Then("order details for each selected order are displayed with Shipment Status as 'Dispatched'")
    public void orderDetailsForEachSelectedOrderAreDisplayed() {
        verifyOrderDetailsDisplayed("Dispatched");
    }

    @When("the user updates the shipment status of all selected orders to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatus() {
        updateShipmentStatus("Dispatched");
    }

    @Then("shipment status for all selected orders is updated to 'Dispatched'")
    public void shipmentStatusForAllSelectedOrdersIsUpdated() {
        verifyShipmentStatusUpdated("Dispatched");
    }

    @When("the user monitors the alert system for outgoing alerts")
    public void theUserMonitorsTheAlertSystem() {
        monitorAlertSystem();
    }

    @Then("alerts are sent to customer@example.com for all orders without delay")
    public void alertsAreSentToCustomer() {
        verifyAlertsSent("customer@example.com");
    }

    @When("the user verifies the system's performance metrics")
    public void theUserVerifiesTheSystemsPerformanceMetrics() {
        verifyPerformanceMetrics();
    }

    @Then("the system maintains optimal performance under high load conditions")
    public void theSystemMaintainsOptimalPerformance() {
        verifyOptimalPerformance();
    }
}