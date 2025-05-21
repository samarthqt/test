import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import Dynamics365Page from "../pages/dynamics365Page";

Given("a shipment order exists in the system with Order ID 67890", () => {
 Dynamics365Page.verifyOrderExists(67890);
});

Given("the customer with email nonsubscriber@example.com has not subscribed to shipment alerts", () => {
 Dynamics365Page.verifyCustomerNotSubscribed("nonsubscriber@example.com");
});

When("I log in to the Dynamics 365 system with valid credentials", () => {
 Dynamics365Page.login();
});

Then("the dashboard is displayed", () => {
 Dynamics365Page.verifyDashboardDisplayed();
});

When("I navigate to the 'Orders' module", () => {
 Dynamics365Page.navigateToOrdersModule();
});

Then("the Orders module is displayed with a list of orders", () => {
 Dynamics365Page.verifyOrdersModuleDisplayed();
});

When("I select the order with ID 67890", () => {
 Dynamics365Page.selectOrder(67890);
});

Then("the order details for order ID 67890 are displayed", () => {
 Dynamics365Page.verifyOrderDetailsDisplayed(67890);
});

Then("the shipment status is 'Dispatched'", () => {
 Dynamics365Page.verifyShipmentStatus("Dispatched");
});

When("I update the shipment status to 'Dispatched'", () => {
 Dynamics365Page.updateShipmentStatus("Dispatched");
});

Then("the shipment status is updated to 'Dispatched'", () => {
 Dynamics365Page.verifyShipmentStatusUpdated("Dispatched");
});

When("I check the alert system for outgoing alerts", () => {
 Dynamics365Page.checkAlertSystem();
});

Then("no alert is sent to nonsubscriber@example.com", () => {
 Dynamics365Page.verifyNoAlertSent("nonsubscriber@example.com");
});

When("I verify the customer's email inbox", () => {
 Dynamics365Page.verifyCustomerInbox("nonsubscriber@example.com");
});

Then("no alert is received by nonsubscriber@example.com", () => {
 Dynamics365Page.verifyNoAlertReceived("nonsubscriber@example.com");
});