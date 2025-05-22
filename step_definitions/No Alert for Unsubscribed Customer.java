package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoAlertSteps extends DynamicsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID 67890")
    public void aShipmentOrderExistsInTheSystemWithOrderID() {
        boolean orderExists = checkOrderExists("67890");
        assert orderExists : "Order ID 67890 does not exist.";
    }

    @Given("the customer has not subscribed to shipment alerts")
    public void theCustomerHasNotSubscribedToShipmentAlerts() {
        boolean isSubscribed = checkCustomerSubscription("nonsubscriber@example.com");
        assert !isSubscribed : "Customer is subscribed to alerts.";
    }

    @Given("I am logged into the Dynamics 365 system with valid credentials")
    public void iAmLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics(testHarness.getData("LoginData", "Username"), testHarness.getData("LoginData", "Password"));
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @When("I select the order with ID 67890")
    public void iSelectTheOrderWithID() {
        selectOrder("67890");
    }

    @When("I update the shipment status to 'Dispatched'")
    public void iUpdateTheShipmentStatusToDispatched() {
        updateShipmentStatus("67890", "Dispatched");
    }

    @Then("no alert is sent to nonsubscriber@example.com")
    public void noAlertIsSentToNonsubscriber() {
        boolean alertSent = checkAlertSent("nonsubscriber@example.com");
        assert !alertSent : "Alert was sent to nonsubscriber@example.com.";
    }

    @Then("no alert is received by nonsubscriber@example.com in their email inbox")
    public void noAlertIsReceivedByNonsubscriberInTheirEmailInbox() {
        boolean alertReceived = checkEmailInbox("nonsubscriber@example.com");
        assert !alertReceived : "Alert was received by nonsubscriber@example.com.";
    }
}