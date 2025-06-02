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
        verifyOrderExists();
    }

    @When("I log in to the Dynamics 365 system with valid credentials")
    public void iLogInToTheDynamics365SystemWithValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToSystem(username, password);
    }

    @Then("the user is logged in and the dashboard is displayed")
    public void theUserIsLoggedInAndTheDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Then("the customer with Order ID \"67890\" has not subscribed to shipment alerts")
    public void theCustomerWithOrderIDHasNotSubscribedToShipmentAlerts() {
        verifyCustomerSubscriptionStatus("67890", false);
    }

    @When("I navigate to the 'Orders' module")
    public void iNavigateToTheOrdersModule() {
        navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        verifyOrdersModuleDisplayed();
    }

    @Then("the customer's email is \"nonsubscriber@example.com\"")
    public void theCustomerSEmailIs() {
        verifyCustomerEmail("67890", "nonsubscriber@example.com");
    }

    @When("I select the order with ID \"67890\"")
    public void iSelectTheOrderWithID() {
        selectOrderById("67890");
    }

    @Then("the order details for order ID \"67890\" are displayed")
    public void theOrderDetailsForOrderIDAreDisplayed() {
        verifyOrderDetailsDisplayed("67890");
    }

    @Then("the shipment status is \"Dispatched\"")
    public void theShipmentStatusIs() {
        verifyShipmentStatus("67890", "Dispatched");
    }

    @When("I update the shipment status to \"Dispatched\"")
    public void iUpdateTheShipmentStatusTo() {
        updateShipmentStatus("67890", "Dispatched");
    }

    @Then("the shipment status is updated to \"Dispatched\"")
    public void theShipmentStatusIsUpdatedTo() {
        verifyShipmentStatusUpdated("67890", "Dispatched");
    }

    @When("I check the alert system for outgoing alerts")
    public void iCheckTheAlertSystemForOutgoingAlerts() {
        checkAlertSystemForOutgoingAlerts();
    }

    @Then("no alert is sent to \"nonsubscriber@example.com\"")
    public void noAlertIsSentTo() {
        verifyNoAlertSent("nonsubscriber@example.com");
    }

    @When("I verify the customer's email inbox")
    public void iVerifyTheCustomerSEmailInbox() {
        verifyCustomerEmailInbox("nonsubscriber@example.com");
    }

    @Then("no alert is received by \"nonsubscriber@example.com\"")
    public void noAlertIsReceivedBy() {
        verifyNoAlertReceived("nonsubscriber@example.com");
    }
}