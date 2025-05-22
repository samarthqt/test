import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AlertSystemPage from "../pages/alertSystemPage";

Given("the user is logged into the Dynamics 365 system with valid credentials", () => {
 AlertSystemPage.login();
});

Given("the dashboard is displayed", () => {
 AlertSystemPage.verifyDashboard();
});

Given("multiple shipment orders exist with Order IDs ranging from 10001 to 10050", () => {
 AlertSystemPage.verifyShipmentOrdersExist();
});

Given("customers have subscribed to shipment alerts", () => {
 AlertSystemPage.verifyCustomerSubscription();
});

When("the user navigates to the 'Orders' module", () => {
 AlertSystemPage.navigateToOrdersModule();
});

Then("the orders module is displayed with a list of orders", () => {
 AlertSystemPage.verifyOrdersModuleDisplayed();
});

When("the user selects orders with IDs ranging from 10001 to 10050", () => {
 AlertSystemPage.selectOrdersByIdRange(10001, 10050);
});

Then("order details for each selected order are displayed", () => {
 AlertSystemPage.verifyOrderDetailsDisplayed();
});

Then("the shipment status is 'Dispatched'", () => {
 AlertSystemPage.verifyShipmentStatus('Dispatched');
});

When("the user updates the shipment status of all selected orders to 'Dispatched'", () => {
 AlertSystemPage.updateShipmentStatus('Dispatched');
});

Then("the shipment status for all selected orders is updated to 'Dispatched'", () => {
 AlertSystemPage.verifyShipmentStatusUpdated('Dispatched');
});

Then("the alert system is monitored for outgoing alerts", () => {
 AlertSystemPage.monitorAlertSystem();
});

Then("alerts are sent to customer@example.com for all orders without delay", () => {
 AlertSystemPage.verifyAlertsSent("customer@example.com");
});

When("the system's performance metrics are verified", () => {
 AlertSystemPage.verifyPerformanceMetrics();
});

Then("the system maintains optimal performance under high load conditions", () => {
 AlertSystemPage.verifyOptimalPerformance();
});