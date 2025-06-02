package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrdersPage;

public class NoAlertSteps extends OrdersPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into the Dynamics 365 system with valid credentials")
    public void iAmLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Given("a shipment order with ID 67890 exists in the system")
    public void aShipmentOrderWithIDExistsInTheSystem() {
        verifyOrderExists("67890");
    }

    @Given("the customer has not subscribed to shipment alerts")
    public void theCustomerHasNotSubscribedToShipmentAlerts() {
        verifyCustomerSubscriptionStatus("67890", false);
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

    @Then("no alert should be sent to nonsubscriber@example.com")
    public void noAlertShouldBeSentToNonsubscriber() {
        verifyNoAlertSent("nonsubscriber@example.com");
    }

    @Then("no alert should be received by nonsubscriber@example.com in their email inbox")
    public void noAlertShouldBeReceivedByNonsubscriberInTheirEmailInbox() {
        verifyNoEmailReceived("nonsubscriber@example.com");
    }
}