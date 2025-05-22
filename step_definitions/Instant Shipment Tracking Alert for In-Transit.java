package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShipmentTrackingSteps extends ShipmentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order with ID {int} exists in the system")
    public void aShipmentOrderWithIDExistsInTheSystem(int orderId) {
        verifyOrderExists(orderId);
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @When("I log in to the Dynamics 365 system with valid credentials")
    public void iLogInToTheDynamics365SystemWithValidCredentials() {
        loginToSystem(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the dashboard is displayed")
    public void theDashboardIsDisplayed() {
        verifyDashboardDisplayed();
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
        selectOrder(orderId);
    }

    @Then("order details for order ID {int} are displayed")
    public void orderDetailsForOrderIDAreDisplayed(int orderId) {
        verifyOrderDetailsDisplayed(orderId);
    }

    @When("I update the shipment status to 'In Transit'")
    public void iUpdateTheShipmentStatusToInTransit() {
        updateShipmentStatus("In Transit");
    }

    @Then("the shipment status is updated to 'In Transit'")
    public void theShipmentStatusIsUpdatedToInTransit() {
        verifyShipmentStatusUpdated("In Transit");
    }

    @When("I check the alert system for outgoing alerts")
    public void iCheckTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("an alert is sent to customer@example.com notifying them of the 'In Transit' status")
    public void anAlertIsSentToCustomerExampleComNotifyingThemOfTheInTransitStatus() {
        verifyAlertSent("customer@example.com", "In Transit");
    }

    @When("I verify the alert received by the customer")
    public void iVerifyTheAlertReceivedByTheCustomer() {
        verifyCustomerAlertReceived();
    }

    @Then("the customer receives an alert with the message: 'Your shipment is now in transit'")
    public void theCustomerReceivesAnAlertWithTheMessageYourShipmentIsNowInTransit() {
        verifyAlertMessage("Your shipment is now in transit");
    }
}