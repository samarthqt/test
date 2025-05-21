import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("a shipment order exists in the system with Order ID {string}", (orderId) => {
 ShipmentPage.verifyOrderExists(orderId);
});

Given("the customer has subscribed to shipment alerts", () => {
 ShipmentPage.verifyCustomerSubscription();
});

Given("I am logged into the Dynamics 365 system with valid credentials", () => {
 ShipmentPage.login();
});

When("I navigate to the 'Orders' module", () => {
 ShipmentPage.navigateToOrdersModule();
});

When("I select the order with ID {string}", (orderId) => {
 ShipmentPage.selectOrder(orderId);
});

When("I update the shipment status to 'Dispatched'", () => {
 ShipmentPage.updateShipmentStatusToDispatched();
});

Then("the shipment status is updated to 'Dispatched'", () => {
 ShipmentPage.verifyShipmentStatusUpdated();
});

Then("an alert is sent to {string} notifying them of the dispatch status", (email) => {
 ShipmentPage.verifyAlertSent(email);
});

Then("the customer receives an alert with the message: {string}", (message) => {
 ShipmentPage.verifyAlertMessageReceived(message);
});