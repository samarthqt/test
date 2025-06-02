package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a customer has subscribed to shipment alerts")
    public void aCustomerHasSubscribedToShipmentAlerts() {
        subscribeToShipmentAlerts();
    }

    @Given("a shipment order with ID 12345 exists in the system")
    public void aShipmentOrderWithIDExistsInTheSystem() {
        verifyOrderExists("12345");
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        loginToSystem(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the user is logged in and the dashboard is displayed")
    public void theUserIsLoggedInAndTheDashboardIsDisplayed() {
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

    @When("the user updates the shipment status to 'Delivered'")
    public void theUserUpdatesTheShipmentStatusToDelivered() {
        updateShipmentStatusToDelivered();
    }

    @Then("the shipment status is updated to 'Delivered'")
    public void theShipmentStatusIsUpdatedToDelivered() {
        verifyShipmentStatusUpdated("Delivered");
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        checkOutgoingAlerts();
    }

    @Then("an alert is sent to customer@example.com notifying them of the delivery confirmation")
    public void anAlertIsSentToCustomerNotifyingThemOfTheDeliveryConfirmation() {
        verifyAlertSent("customer@example.com", "Your shipment has been delivered.");
    }

    @When("the customer verifies the alert received")
    public void theCustomerVerifiesTheAlertReceived() {
        verifyCustomerAlertReceived();
    }

    @Then("the customer receives an alert with the message: 'Your shipment has been delivered.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyAlertMessage("Your shipment has been delivered.");
    }
}