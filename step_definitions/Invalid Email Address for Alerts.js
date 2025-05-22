import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import Dynamics365Page from "../pages/dynamics365Page";

Given("a shipment order exists in the system with Order ID {string}", (orderId) => {
 Dynamics365Page.verifyOrderExists(orderId);
});

Given("the customer has subscribed to shipment alerts", () => {
 Dynamics365Page.verifyCustomerSubscription();
});

Given("the customer's email address is {string}", (email) => {
 Dynamics365Page.verifyCustomerEmail(email);
});

When("I log in to the Dynamics 365 system with valid credentials", () => {
 Dynamics365Page.login();
});

Then("the dashboard should be displayed", () => {
 Dynamics365Page.verifyDashboardDisplayed();
});

When("I navigate to the 'Orders' module", () => {
 Dynamics365Page.navigateToOrdersModule();
});

Then("the Orders module should be displayed with a list of orders", () => {
 Dynamics365Page.verifyOrdersModuleDisplayed();
});

When("I select the order with ID {string}", (orderId) => {
 Dynamics365Page.selectOrder(orderId);
});

Then("the order details for order ID {string} should be displayed", (orderId) => {
 Dynamics365Page.verifyOrderDetailsDisplayed(orderId);
});

Then("the shipment status should be {string}", (status) => {
 Dynamics365Page.verifyShipmentStatus(status);
});

When("I update the shipment status to {string}", (status) => {
 Dynamics365Page.updateShipmentStatus(status);
});

Then("the shipment status should be updated to {string}", (status) => {
 Dynamics365Page.verifyShipmentStatusUpdated(status);
});

When("I check the alert system for outgoing alerts", () => {
 Dynamics365Page.checkAlertSystem();
});

Then("no alert should be sent due to the invalid email address", () => {
 Dynamics365Page.verifyNoAlertSent();
});

Then("an error should be logged indicating failure to send alert to {string}", (email) => {
 Dynamics365Page.verifyErrorLogged(email);
});