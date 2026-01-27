package com.step_definitions;
import com.pageobjects.LoginPage;
import com.pageobjects.DashboardPage;
import com.pageobjects.OrdersPage;
import com.pageobjects.OrderDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class ShipmentTrackingSteps {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage;
    private OrdersPage ordersPage;
    private OrderDetailsPage orderDetailsPage;

    @Given("a shipment order exists in the system with Order ID {int}")
    public void aShipmentOrderExistsInTheSystemWithOrderID(int orderId) {
        // Assume order exists in the system
    }

    @Given("the customer has subscribed to shipment alerts")
    public void theCustomerHasSubscribedToShipmentAlerts() {
        // Assume customer subscription
    }

    @When("the user logs in to the Dynamics 365 system with valid credentials")
    public void theUserLogsInToTheDynamics365SystemWithValidCredentials() {
        loginPage.enterUserName("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage();
    }

    @Then("the dashboard is displayed")
    public void theDashboardIsDisplayed() {
        dashboardPage.verifyDashboardDisplayed();
    }

    @When("the user navigates to the 'Orders' module")
    public void theUserNavigatesToTheOrdersModule() {
        ordersPage = dashboardPage.navigateToOrdersModule();
    }

    @Then("the Orders module is displayed with a list of orders")
    public void theOrdersModuleIsDisplayedWithAListOfOrders() {
        ordersPage.verifyOrdersModuleDisplayed();
    }

    @When("the user selects the order with ID {int}")
    public void theUserSelectsTheOrderWithID(int orderId) {
        orderDetailsPage = ordersPage.selectOrderById(orderId);
    }

    @Then("the order details for order ID {int} are displayed")
    public void theOrderDetailsForOrderIDAreDisplayed(int orderId) {
        orderDetailsPage.verifyOrderDetailsDisplayed(orderId);
    }

    @Then("the shipment status is 'Dispatched'")
    public void theShipmentStatusIsDispatched() {
        orderDetailsPage.verifyShipmentStatus("Dispatched");
    }

    @When("the user updates the shipment status to 'Dispatched'")
    public void theUserUpdatesTheShipmentStatusToDispatched() {
        orderDetailsPage.updateShipmentStatus("Dispatched");
    }

    @Then("the shipment status is updated to 'Dispatched'")
    public void theShipmentStatusIsUpdatedToDispatched() {
        orderDetailsPage.verifyShipmentStatusUpdated("Dispatched");
    }

    @When("the user checks the alert system for outgoing alerts")
    public void theUserChecksTheAlertSystemForOutgoingAlerts() {
        orderDetailsPage.checkAlertSystem();
    }

    @Then("an alert is sent to customer@example.com notifying them of the dispatch status")
    public void anAlertIsSentToCustomerExampleComNotifyingThemOfTheDispatchStatus() {
        orderDetailsPage.verifyAlertSent("customer@example.com");
    }

    @Then("the customer receives an alert with the message: 'Your shipment has been dispatched.'")
    public void theCustomerReceivesAnAlertWithTheMessageYourShipmentHasBeenDispatched() {
        orderDetailsPage.verifyAlertMessage("Your shipment has been dispatched.");
    }
}
