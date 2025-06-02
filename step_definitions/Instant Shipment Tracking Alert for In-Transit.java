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

    @Given("the customer's email is customer@example.com")
    public void theCustomersEmailIs() {
        verifyCustomerEmail("customer@example.com");
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamicsSystemWithValidCredentials() {
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

    @When("the user updates the shipment status to 'In Transit'")
    public void theUserUpdatesTheShipmentStatusToInTransit() {
        updateShipmentStatus("In Transit");
    }

    @Then("the shipment status is updated to 'In Transit'")
    public void theShipmentStatusIsUpdatedToInTransit() {
        verifyShipmentStatusUpdated("In Transit");
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("an alert is sent to customer@example.com notifying them of the 'In Transit' status")
    public void anAlertIsSentToCustomerEmail() {
        verifyAlertSent("customer@example.com", "In Transit");
    }

    @When("the user verifies the alert received by the customer")
    public void theUserVerifiesTheAlertReceivedByTheCustomer() {
        verifyCustomerAlertReceived();
    }

    @Then("the customer receives an alert with the message: 'Your shipment is now in transit.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyAlertMessage("Your shipment is now in transit.");
    }
}