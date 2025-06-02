package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderPage;

public class OrderSteps extends OrderPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a shipment order exists in the system")
    public void aShipmentOrderExistsInTheSystem() {
        verifyShipmentOrderExists();
    }

    @Given("I am logged into the Dynamics 365 system with valid credentials")
    public void iAmLoggedIntoTheDynamics365SystemWithValidCredentials() {
        loginToDynamics365(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @When("I select the order with ID 54321")
    public void iSelectTheOrderWithID54321() {
        selectOrderById("54321");
    }

    @When("I update the shipment status to 'Delivered'")
    public void iUpdateTheShipmentStatusToDelivered() {
        updateShipmentStatus("Delivered");
    }

    @Then("no alert should be sent due to invalid email address \"invalidemail@.com\"")
    public void noAlertShouldBeSentDueToInvalidEmailAddress() {
        verifyNoAlertSent("invalidemail@.com");
    }

    @Then("an error should be logged indicating failure to send alert to \"invalidemail@.com\"")
    public void anErrorShouldBeLoggedIndicatingFailureToSendAlert() {
        verifyErrorLogged("invalidemail@.com");
    }
}