package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends AlertPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system with Order ID 54321")
    public void aShipmentOrderExistsInTheSystemWithOrderID() {
        verifyOrderExists("54321");
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        verifyCustomerSubscription();
    }

    @Given("the customer's email address is \"invalidemail@.com\"")
    public void theCustomerSEmailAddressIsInvalid() {
        verifyCustomerEmail("invalidemail@.com");
    }

    @When("I log in to the Dynamics 365 system with valid credentials")
    public void iLogInToTheDynamicsSystem() {
        loginToSystem();
    }

    @Then("the dashboard should be displayed")
    public void theDashboardShouldBeDisplayed() {
        verifyDashboardDisplayed();
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module should be displayed with a list of orders")
    public void theOrdersModuleShouldBeDisplayed() {
        verifyOrdersModuleDisplayed();
    }

    @When("I select the order with ID 54321")
    public void iSelectTheOrderWithID() {
        selectOrderById("54321");
    }

    @Then("the order details for order ID 54321 should be displayed")
    public void theOrderDetailsForOrderIDShouldBeDisplayed() {
        verifyOrderDetailsDisplayed("54321");
    }

    @Then("the shipment status should be \"Delivered\"")
    public void theShipmentStatusShouldBeDelivered() {
        verifyShipmentStatus("Delivered");
    }

    @When("I update the shipment status to \"Delivered\"")
    public void iUpdateTheShipmentStatusToDelivered() {
        updateShipmentStatus("Delivered");
    }

    @Then("the shipment status should be updated to \"Delivered\"")
    public void theShipmentStatusShouldBeUpdatedToDelivered() {
        verifyShipmentStatusUpdated("Delivered");
    }

    @When("I check the alert system for outgoing alerts")
    public void iCheckTheAlertSystemForOutgoingAlerts() {
        checkAlertSystem();
    }

    @Then("no alert should be sent due to the invalid email address")
    public void noAlertShouldBeSentDueToInvalidEmail() {
        verifyNoAlertSent();
    }

    @Then("an error should be logged indicating failure to send alert to \"invalidemail@.com\"")
    public void anErrorShouldBeLogged() {
        verifyErrorLogged("invalidemail@.com");
    }
}