import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import Dynamics365Page from "../pages/dynamics365Page";

Given("a shipment order exists in the system", () => {
 Dynamics365Page.verifyShipmentOrderExists();
});

Given("I log in to the Dynamics 365 system with valid credentials", () => {
 Dynamics365Page.login();
});

Then("the user is logged in and the dashboard is displayed", () => {
 Dynamics365Page.verifyDashboardDisplayed();
});

Given("the customer has subscribed to shipment alerts", () => {
 Dynamics365Page.verifyCustomerSubscribedToAlerts();
});

When("I navigate to the 'Orders' module", () => {
 Dynamics365Page.navigateToOrdersModule();
});

Then("the orders module is displayed with a list of orders", () => {
 Dynamics365Page.verifyOrdersModuleDisplayed();
});

Then("the customer's email address is invalid \"invalidemail@.com\"", () => {
 Dynamics365Page.verifyInvalidEmailAddress("invalidemail@.com");
});

When("I select the order with ID 54321", () => {
 Dynamics365Page.selectOrderById("54321");
});

Then("the order details for order ID 54321 are displayed", () => {
 Dynamics365Page.verifyOrderDetailsDisplayed("54321");
});

Then("the shipment status is \"Delivered\"", () => {
 Dynamics365Page.verifyShipmentStatus("Delivered");
});

When("I update the shipment status to \"Delivered\"", () => {
 Dynamics365Page.updateShipmentStatus("Delivered");
});

Then("the shipment status is updated to \"Delivered\"", () => {
 Dynamics365Page.verifyShipmentStatusUpdated("Delivered");
});

When("I check the alert system for outgoing alerts", () => {
 Dynamics365Page.checkAlertSystemForOutgoingAlerts();
});

Then("no alert is sent due to the invalid email address", () => {
 Dynamics365Page.verifyNoAlertSent();
});

When("I verify the error logs for alert sending failures", () => {
 Dynamics365Page.verifyErrorLogsForAlertFailures();
});

Then("an error is logged indicating failure to send alert to invalidemail@.com", () => {
 Dynamics365Page.verifyErrorLoggedForInvalidEmail("invalidemail@.com");
});