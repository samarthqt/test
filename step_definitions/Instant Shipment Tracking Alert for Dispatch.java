package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID 12345")
    public void aShipmentOrderExistsInTheSystemWithOrderID() {
        verifyOrderExists("12345");
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription("customer@example.com");
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the dashboard is displayed")
    public void theDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @When("the user selects the order with ID 12345")
    public void theUserSelectsTheOrderWithID() {
        selectOrderById("12345");
    }

    @Then("the order details for order ID 12345 are displayed")
    public void theOrderDetailsForOrderIDAreDisplayed() {
        verifyOrderDetailsDisplayed("12345");
    }

    @Then("the shipment status is 'Dispatched'")
    public void theShipmentStatusIsDispatched() {
        verifyShipmentStatus("Dispatched");
    }

    @When("the user updates the shipment status to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatusToDispatched() {
        updateShipmentStatus("12345", "Dispatched");
    }

    @Then("the shipment status is updated to 'Dispatched'")
    public void theShipmentStatusIsUpdatedToDispatched() {
        verifyShipmentStatusUpdated("12345", "Dispatched");
    }

    @Then("an alert is sent to customer@example.com notifying them of the dispatch status")
    public void anAlertIsSentToCustomerNotifyingThemOfTheDispatchStatus() {
        verifyAlertSent("customer@example.com", "Your shipment has been dispatched.");
    }

    @When("the alert system is checked for outgoing alerts")
    public void theAlertSystemIsCheckedForOutgoingAlerts() {
        checkOutgoingAlerts();
    }

    @Then("the customer receives an alert with the message: 'Your shipment has been dispatched.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyCustomerReceivedAlert("customer@example.com", "Your shipment has been dispatched.");
    }
}