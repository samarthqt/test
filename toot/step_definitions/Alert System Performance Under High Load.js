import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AlertSystemPage from "../pages/alertSystemPage";

Given("I am logged into the Dynamics 365 system with valid credentials", () => {
 AlertSystemPage.login();
});

Given("the dashboard is displayed", () => {
 AlertSystemPage.verifyDashboardDisplayed();
});

Given("multiple shipment orders exist with IDs ranging from 10001 to 10050", () => {
 AlertSystemPage.verifyShipmentOrdersExist();
});

Given("customers have subscribed to shipment alerts", () => {
 AlertSystemPage.verifyCustomerSubscription();
});

When("I navigate to the 'Orders' module", () => {
 AlertSystemPage.navigateToOrdersModule();
});

Then("the Orders module is displayed with a list of orders", () => {
 AlertSystemPage.verifyOrdersModuleDisplayed();
});

Then("the customer email is customer@example.com", () => {
 AlertSystemPage.verifyCustomerEmail();
});

When("I select orders with IDs ranging from 10001 to 10050", () => {
 AlertSystemPage.selectOrders();
});

Then("order details for each selected order are displayed", () => {
 AlertSystemPage.verifyOrderDetailsDisplayed();
});

Then("the shipment status is 'Dispatched'", () => {
 AlertSystemPage.verifyShipmentStatusDispatched();
});

When("I update the shipment status of all selected orders to 'Dispatched'", () => {
 AlertSystemPage.updateShipmentStatus();
});

Then("the shipment status for all selected orders is updated to 'Dispatched'", () => {
 AlertSystemPage.verifyShipmentStatusUpdated();
});

When("I monitor the alert system for outgoing alerts", () => {
 AlertSystemPage.monitorAlertSystem();
});

Then("alerts are sent to customer@example.com for all orders without delay", () => {
 AlertSystemPage.verifyAlertsSent();
});

Then("the system maintains optimal performance under high load conditions", () => {
 AlertSystemPage.verifySystemPerformance();
});