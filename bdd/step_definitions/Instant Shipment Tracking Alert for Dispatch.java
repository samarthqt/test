package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentPage;
import java.util.List;

public class ShipmentSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID {int}")
    public void aShipmentOrderExistsInTheSystemWithOrderID(int orderId) {
        verifyOrderExists(orderId);
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @Given("the customer email is {string}")
    public void theCustomerEmailIs(String email) {
        verifyCustomerEmail(email);
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        loginToSystem();
    }

    @Then("the dashboard should be displayed")
    public void theDashboardShouldBeDisplayed() {
        verifyDashboardDisplayed();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module should be displayed with a list of orders")
    public void theOrdersModuleShouldBeDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @When("the user selects the order with ID {int}")
    public void theUserSelectsTheOrderWithID(int orderId) {
        selectOrderById(orderId);
    }

    @Then("the order details for order ID {int} should be displayed")
    public void theOrderDetailsForOrderIDShouldBeDisplayed(int orderId) {
        verifyOrderDetailsDisplayed(orderId);
    }

    @Then("the shipment status should be 'Dispatched'")
    public void theShipmentStatusShouldBeDispatched() {
        verifyShipmentStatus("Dispatched");
    }

    @When("the user updates the shipment status to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatusToDispatched() {
        updateShipmentStatus("Dispatched");
    }

    @Then("the shipment status should be updated to 'Dispatched'")
    public void theShipmentStatusShouldBeUpdatedToDispatched() {
        verifyShipmentStatusUpdated("Dispatched");
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("an alert should be sent to {string} notifying them of the dispatch status")
    public void anAlertShouldBeSentToNotifyingThemOfTheDispatchStatus(String email) {
        verifyAlertSent(email);
    }

    @Then("the customer should receive an alert with the message: 'Your shipment has been dispatched.'")
    public void theCustomerShouldReceiveAnAlertWithTheMessageYourShipmentHasBeenDispatched() {
        verifyAlertMessage("Your shipment has been dispatched.");
    }

    @Then("the shipment status should be 'Shipped'")
    public void theShipmentStatusShouldBeShipped() {
        verifyShipmentStatus("Shipped");
    }

    @When("the user updates the shipment status to 'Shipped'")
    public void theUserUpdatesTheShipmentStatusToShipped() {
        updateShipmentStatus("Shipped");
    }

    @Then("the shipment status should be updated to 'Shipped'")
    public void theShipmentStatusShouldBeUpdatedToShipped() {
        verifyShipmentStatusUpdated("Shipped");
    }

    @Then("the customer should receive an alert with the message: 'Your shipment has been shipped.'")
    public void theCustomerShouldReceiveAnAlertWithTheMessageYourShipmentHasBeenShipped() {
        verifyAlertMessage("Your shipment has been shipped.");
    }
}