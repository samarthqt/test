package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID {string}")
    public void aShipmentOrderExistsInTheSystemWithOrderID(String orderId) {
        verifyOrderExists(orderId);
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        loginToSystem();
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

    @When("the user selects the order with ID {string}")
    public void theUserSelectsTheOrderWithID(String orderId) {
        selectOrderById(orderId);
    }

    @Then("the order details for order ID {string} are displayed")
    public void theOrderDetailsForOrderIDAreDisplayed(String orderId) {
        verifyOrderDetailsDisplayed(orderId);
    }

    @When("the user updates the shipment status to {string}")
    public void theUserUpdatesTheShipmentStatusTo(String status) {
        updateShipmentStatus(status);
    }

    @Then("the shipment status is updated to {string}")
    public void theShipmentStatusIsUpdatedTo(String status) {
        verifyShipmentStatusUpdated(status);
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("an alert is sent to {string} notifying them of the delivery confirmation")
    public void anAlertIsSentToNotifyingThemOfTheDeliveryConfirmation(String email) {
        verifyAlertSent(email);
    }

    @When("the user verifies the alert received by the customer")
    public void theUserVerifiesTheAlertReceivedByTheCustomer() {
        verifyCustomerAlertReceived();
    }

    @Then("the customer receives an alert with the message: {string}")
    public void theCustomerReceivesAnAlertWithTheMessage(String message) {
        verifyAlertMessage(message);
    }
}