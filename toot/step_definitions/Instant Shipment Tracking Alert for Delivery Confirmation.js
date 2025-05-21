import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("a shipment order exists in the system", () => {
 // Assume the system has the order
});

Given("the customer has subscribed to shipment alerts", () => {
 // Assume subscription is active
});

Given("the order ID is {int}", (orderId) => {
 ShipmentPage.setOrderId(orderId);
});

Given("the customer email is {string}", (email) => {
 ShipmentPage.setCustomerEmail(email);
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

When("the user selects the order with ID {int}", (orderId) => {
 ShipmentPage.selectOrder(orderId);
});

Then("the order details for order ID {int} are displayed", (orderId) => {
 ShipmentPage.verifyOrderDetails(orderId);
});

Then("the shipment status is {string}", (status) => {
 ShipmentPage.verifyShipmentStatus(status);
});

When("the user updates the shipment status to {string}", (status) => {
 ShipmentPage.updateShipmentStatus(status);
});

Then("the shipment status is updated to {string}", (status) => {
 ShipmentPage.verifyUpdatedShipmentStatus(status);
});

When("the user checks the alert system for outgoing alerts", () => {
 ShipmentPage.checkAlertSystem();
});

Then("an alert is sent to {string} notifying them of the delivery confirmation", (email) => {
 ShipmentPage.verifyAlertSent(email);
});

Then("the customer receives an alert with the message: {string}", (message) => {
 ShipmentPage.verifyAlertMessage(message);
});