package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID {int}")
    public void aShipmentOrderExistsInTheSystemWithOrderID(int orderId) {
        verifyOrderExists(orderId);
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @Given("I am logged into the Dynamics 365 system with valid credentials")
    public void iAmLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365();
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @When("I select the order with ID {int}")
    public void iSelectTheOrderWithID(int orderId) {
        selectOrderById(orderId);
    }

    @Then("the order details for order ID {int} are displayed")
    public void theOrderDetailsForOrderIDAreDisplayed(int orderId) {
        verifyOrderDetailsDisplayed(orderId);
    }

    @Then("the shipment status is \"Dispatched\"")
    public void theShipmentStatusIsDispatched() {
        verifyShipmentStatus("Dispatched");
    }

    @When("I update the shipment status to \"Dispatched\"")
    public void iUpdateTheShipmentStatusToDispatched() {
        updateShipmentStatus("Dispatched");
    }

    @Then("the shipment status is updated to \"Dispatched\"")
    public void theShipmentStatusIsUpdatedToDispatched() {
        verifyShipmentStatusUpdated("Dispatched");
    }

    @When("I check the alert system for outgoing alerts")
    public void iCheckTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("an alert is sent to customer@example.com notifying them of the dispatch status")
    public void anAlertIsSentToCustomerNotifyingThemOfTheDispatchStatus() {
        verifyAlertSent("customer@example.com");
    }

    @Then("the customer receives an alert with the message: \"Your shipment has been dispatched.\"")
    public void theCustomerReceivesAnAlertWithTheMessageYourShipmentHasBeenDispatched() {
        verifyAlertMessage("Your shipment has been dispatched.");
    }
}