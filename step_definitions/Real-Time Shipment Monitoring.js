import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 cy.wrap(customerId).as('customerId');
});

Given("the shipment is in transit", () => {
 ShipmentPage.verifyShipmentInTransit();
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
 ShipmentPage.verifyTrackShipmentSectionDisplayed();
});

When("the user enters the Shipment ID {string} in the search bar", (shipmentId) => {
 ShipmentPage.enterShipmentId(shipmentId);
});

Then("shipment details are displayed for {string}", (shipmentId) => {
 ShipmentPage.verifyShipmentDetailsDisplayed(shipmentId);
});

Then("the current location of the shipment is displayed as {string}", (location) => {
 ShipmentPage.verifyCurrentLocationDisplayed(location);
});

Then("the estimated delivery time is displayed as {string}", (deliveryTime) => {
 ShipmentPage.verifyEstimatedDeliveryTimeDisplayed(deliveryTime);
});

When("the user refreshes the page", () => {
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