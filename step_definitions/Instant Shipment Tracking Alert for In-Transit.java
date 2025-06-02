package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ShipmentTrackingPage;

public class ShipmentTrackingSteps extends ShipmentTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system")
    public void aShipmentOrderExistsInTheSystem() {
        verifyShipmentOrderExists();
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

    @When("selects the order with ID 12345")
    public void selectsTheOrderWithID12345() {
        selectOrderById("12345");
    }

    @When("updates the shipment status to 'In Transit'")
    public void updatesTheShipmentStatusToInTransit() {
        updateShipmentStatusToInTransit();
    }

    @Then("the alert system sends an alert to customer@example.com notifying them of the 'In Transit' status")
    public void theAlertSystemSendsAnAlertToCustomer() {
        verifyAlertSentToCustomer("customer@example.com", "In Transit");
    }

    @Then("the customer receives an alert with the message: 'Your shipment is now in transit.'")
    public void theCustomerReceivesAnAlertWithTheMessage() {
        verifyCustomerReceivedAlert("Your shipment is now in transit.");
    }
}