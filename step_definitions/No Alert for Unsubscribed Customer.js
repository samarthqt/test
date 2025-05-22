import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrdersPage from "../pages/ordersPage";

Given("a shipment order exists in the system with Order ID {string}", (orderId) => {
 OrdersPage.verifyOrderExists(orderId);
});

Given("the customer has not subscribed to shipment alerts", () => {
 OrdersPage.verifyCustomerUnsubscribed();
});

Given("I am logged into the Dynamics 365 system with valid credentials", () => {
 OrdersPage.loginToDynamics365();
});

When("I navigate to the 'Orders' module", () => {
 OrdersPage.navigateToOrdersModule();
});

When("I select the order with ID {string}", (orderId) => {
 OrdersPage.selectOrderById(orderId);
});

When("I update the shipment status to {string}", (status) => {
 OrdersPage.updateShipmentStatus(status);
});

Then("no alert is sent to {string}", (email) => {
 OrdersPage.verifyNoAlertSent(email);
});

Then("no alert is received by {string} in their email inbox", (email) => {
 OrdersPage.verifyNoAlertReceived(email);
});