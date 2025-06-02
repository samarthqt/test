package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AlertSystemPage;

public class AlertSystemSteps extends AlertSystemPage {

    private TestHarness testHarness = new TestHarness();

    @Given("multiple shipment orders exist in the system")
    public void multipleShipmentOrdersExistInTheSystem() {
        verifyShipmentOrdersExist();
    }

    @When("I log in to the Dynamics 365 system with valid credentials")
    public void iLogInToTheDynamics365SystemWithValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToDynamics365(username, password);
    }

    @Then("the user is logged in and the dashboard is displayed")
    public void theUserIsLoggedInAndTheDashboardIsDisplayed() {
        verifyDashboardIsDisplayed();
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleIsDisplayed();
    }

    @When("I select orders with IDs ranging from 10001 to 10050")
    public void iSelectOrdersWithIDsRangingFrom10001To10050() {
        selectOrdersByIdRange(10001, 10050);
    }

    @Then("order details for each selected order are displayed")
    public void orderDetailsForEachSelectedOrderAreDisplayed() {
        verifyOrderDetailsDisplayed();
    }

    @When("I update the shipment status of all selected orders to 'Dispatched'")
    public void iUpdateTheShipmentStatusOfAllSelectedOrdersToDispatched() {
        updateShipmentStatusToDispatched();
    }

    @Then("shipment status for all selected orders is updated to 'Dispatched'")
    public void shipmentStatusForAllSelectedOrdersIsUpdatedToDispatched() {
        verifyShipmentStatusUpdatedToDispatched();
    }

    @When("I monitor the alert system for outgoing alerts")
    public void iMonitorTheAlertSystemForOutgoingAlerts() {
        monitorOutgoingAlerts();
    }

    @Then("alerts are sent to customer@example.com for all orders without delay")
    public void alertsAreSentToCustomerForAllOrdersWithoutDelay() {
        verifyAlertsSentWithoutDelay();
    }

    @When("I verify the system's performance metrics")
    public void iVerifyTheSystemsPerformanceMetrics() {
        verifyPerformanceMetrics();
    }

    @Then("the system maintains optimal performance under high load conditions")
    public void theSystemMaintainsOptimalPerformanceUnderHighLoadConditions() {
        verifyOptimalPerformanceUnderLoad();
    }
}