package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID 12345")
    public void aShipmentOrderExistsInTheSystemWithOrderID() {
        verifyOrderExists("12345");
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @Given("the user is logged into the Dynamics 365 system with valid credentials")
    public void theUserIsLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365();
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

    @When("the user updates the shipment status to 'Delivered'")
    public void theUserUpdatesTheShipmentStatusToDelivered() {
        updateShipmentStatusToDelivered();
    }

    @Then("the shipment status is updated to 'Delivered'")
    public void theShipmentStatusIsUpdatedToDelivered() {
        verifyShipmentStatusUpdatedToDelivered();
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        checkAlertSystemForOutgoingAlerts();
    }

    @Then("an alert is sent to customer@example.com notifying them of the delivery confirmation")
    public void anAlertIsSentToCustomerEmail() {
        verifyAlertSentToCustomer("customer@example.com");
    }

    @Then("the customer receives an alert with the message: 'Your shipment has been delivered.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyCustomerReceivedAlert("Your shipment has been delivered.");
    }
}