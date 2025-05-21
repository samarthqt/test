import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 cy.wrap(customerId).as('customerId');
});

Given("the shipment is in transit", () => {
 cy.wrap(true).as('shipmentInTransit');
});

When("the user logs in to the customer account using valid credentials", () => {
 ShipmentPage.login();
});

Then("the user is successfully logged in to their account", () => {
 ShipmentPage.verifyLoginSuccess();
});

When("the user navigates to the 'Track Shipment' section", () => {
 ShipmentPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 ShipmentPage.verifyTrackShipmentSection();
});

When("the user enters the Shipment ID {string} in the search bar", (shipmentId) => {
 ShipmentPage.enterShipmentId(shipmentId);
});

Then("the shipment details are displayed for {string}", (shipmentId) => {
 ShipmentPage.verifyShipmentDetails(shipmentId);
});

Then("the current location of the shipment is displayed as {string}", (location) => {
 ShipmentPage.verifyCurrentLocation(location);
});

Then("the current location is accurately displayed as {string}", (location) => {
 ShipmentPage.verifyCurrentLocation(location);
});

Then("the estimated delivery time is displayed as {string}", (deliveryTime) => {
 ShipmentPage.verifyEstimatedDeliveryTime(deliveryTime);
});

Then("the estimated delivery time is shown as {string}", (deliveryTime) => {
 ShipmentPage.verifyEstimatedDeliveryTime(deliveryTime);
});

When("the user waits for 5 minutes and refreshes the page", () => {
 cy.wait(300000);
 cy.reload();
});

Then("any changes in location or delivery time are updated in real-time", () => {
 ShipmentPage.verifyRealTimeUpdates();
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 ShipmentPage.verifyLogoutSuccess();
});