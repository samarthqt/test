package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order with ID 12345 exists in the system")
    public void aShipmentOrderWithIDExistsInTheSystem() {
        verifyOrderExists("12345");
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamicsSystemWithValidCredentials() {
        loginToSystem(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the dashboard is displayed")
    public void theDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @When("the user selects the order with ID 12345")
    public void theUserSelectsTheOrderWithID() {
        selectOrderById("12345");
    }

    @Then("order details for order ID 12345 are displayed")
    public void orderDetailsForOrderIDAreDisplayed() {
        verifyOrderDetailsDisplayed("12345");
    }

    @Then("the shipment status is 'Dispatched'")
    public void theShipmentStatusIsDispatched() {
        verifyShipmentStatus("Dispatched");
    }

    @When("the user updates the shipment status to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatusToDispatched() {
        updateShipmentStatus("Dispatched");
    }

    @Then("the shipment status is updated to 'Dispatched'")
    public void theShipmentStatusIsUpdatedToDispatched() {
        verifyShipmentStatusUpdated("Dispatched");
    }

    @Then("the alert system sends an alert to customer@example.com notifying them of the dispatch status")
    public void theAlertSystemSendsAnAlertToCustomer() {
        verifyAlertSent("customer@example.com", "Your shipment has been dispatched.");
    }

    @Then("the customer receives an alert with the message: 'Your shipment has been dispatched.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyCustomerReceivedAlert("Your shipment has been dispatched.");
    }
}