import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("a shipment order exists in the system with Order ID {string}", (orderId) => {
 ShipmentPage.verifyOrderExists(orderId);
});

Given("the customer has subscribed to shipment alerts", () => {
 ShipmentPage.verifyCustomerSubscription();
});

When("the user logs in to the Dynamics 365 system with valid credentials", () => {
 ShipmentPage.login();
});

Then("the dashboard is displayed", () => {
 ShipmentPage.verifyDashboardDisplayed();
});

When("the user navigates to the {string} module", (module) => {
 ShipmentPage.navigateToModule(module);
});

Then("the Orders module is displayed with a list of orders", () => {
 ShipmentPage.verifyOrdersModuleDisplayed();
});

When("the user selects the order with ID {string}", (orderId) => {
 ShipmentPage.selectOrder(orderId);
});

Then("the order details for order ID {string} are displayed", (orderId) => {
 ShipmentPage.verifyOrderDetailsDisplayed(orderId);
});

Then("the shipment status is {string}", (status) => {
 ShipmentPage.verifyShipmentStatus(status);
});

When("the user updates the shipment status to {string}", (status) => {
 ShipmentPage.updateShipmentStatus(status);
});

Then("the shipment status is updated to {string}", (status) => {
 ShipmentPage.verifyShipmentStatusUpdated(status);
});

When("the alert system is checked for outgoing alerts", () => {
 ShipmentPage.checkAlertSystem();
});

Then("an alert is sent to {string} notifying them of the {string} status", (email, status) => {
 ShipmentPage.verifyAlertSent(email, status);
});

When("the alert received by the customer is verified", () => {
 ShipmentPage.verifyCustomerAlertReceived();
});

Then("the customer receives an alert with the message: {string}", (message) => {
 ShipmentPage.verifyAlertMessage(message);
});