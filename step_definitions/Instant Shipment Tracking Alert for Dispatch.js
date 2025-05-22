import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("a shipment order exists in the system with Order ID 12345", () => {
 // Assume the order exists in the system
});

Given("the customer has subscribed to shipment alerts", () => {
 // Assume the customer is subscribed to alerts
});

When("the user logs in to the Dynamics 365 system with valid credentials", () => {
 ShipmentPage.login();
});

Then("the dashboard is displayed", () => {
 ShipmentPage.verifyDashboard();
});

When("the user navigates to the 'Orders' module", () => {
 ShipmentPage.navigateToOrdersModule();
});

Then("the Orders module is displayed with a list of orders", () => {
 ShipmentPage.verifyOrdersModule();
});

When("the user selects the order with ID 12345", () => {
 ShipmentPage.selectOrderById('12345');
});

Then("the order details for order ID 12345 are displayed", () => {
 ShipmentPage.verifyOrderDetails('12345');
});

Then("the shipment status is 'Dispatched'", () => {
 ShipmentPage.verifyShipmentStatus('Dispatched');
});

When("the user updates the shipment status to 'Dispatched'", () => {
 ShipmentPage.updateShipmentStatus('Dispatched');
});

Then("the shipment status is updated to 'Dispatched'", () => {
 ShipmentPage.verifyShipmentStatusUpdated('Dispatched');
});

Then("an alert is sent to customer@example.com notifying them of the dispatch status", () => {
 ShipmentPage.verifyAlertSent('customer@example.com');
});

When("the alert system is checked for outgoing alerts", () => {
 ShipmentPage.checkOutgoingAlerts();
});

Then("the customer receives an alert with the message: 'Your shipment has been dispatched.'", () => {
 ShipmentPage.verifyCustomerAlertMessage('Your shipment has been dispatched.');
});