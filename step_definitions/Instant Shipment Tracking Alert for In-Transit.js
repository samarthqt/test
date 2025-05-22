import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import Dynamics365Page from "../pages/dynamics365Page";

Given("a shipment order with ID {string} exists in the system", (orderId) => {
 Dynamics365Page.verifyOrderExists(orderId);
});

Given("the customer has subscribed to shipment alerts", () => {
 Dynamics365Page.verifyCustomerSubscription();
});

When("I log in to the Dynamics 365 system with valid credentials", () => {
 Dynamics365Page.login();
});

Then("the dashboard is displayed", () => {
 Dynamics365Page.verifyDashboardDisplayed();
});

When("I navigate to the {string} module", (moduleName) => {
 Dynamics365Page.navigateToModule(moduleName);
});

Then("the Orders module is displayed with a list of orders", () => {
 Dynamics365Page.verifyOrdersModuleDisplayed();
});

When("I select the order with ID {string}", (orderId) => {
 Dynamics365Page.selectOrder(orderId);
});

Then("order details for order ID {string} are displayed", (orderId) => {
 Dynamics365Page.verifyOrderDetailsDisplayed(orderId);
});

When("I update the shipment status to {string}", (status) => {
 Dynamics365Page.updateShipmentStatus(status);
});

Then("the shipment status is updated to {string}", (status) => {
 Dynamics365Page.verifyShipmentStatusUpdated(status);
});

When("I check the alert system for outgoing alerts", () => {
 Dynamics365Page.checkOutgoingAlerts();
});

Then("an alert is sent to {string} notifying them of the {string} status", (email, status) => {
 Dynamics365Page.verifyAlertSent(email, status);
});

When("I verify the alert received by the customer", () => {
 Dynamics365Page.verifyCustomerAlertReceived();
});

Then("the customer receives an alert with the message: {string}", (message) => {
 Dynamics365Page.verifyAlertMessage(message);
});