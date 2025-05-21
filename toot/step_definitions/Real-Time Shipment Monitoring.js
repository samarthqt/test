import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 // Assume customer account is pre-validated
});

And("the shipment with Shipment ID {string} is in transit", (shipmentId) => {
 // Assume shipment status is pre-set
});

When("the user logs in to the customer account using valid credentials", () => {
 ShipmentPage.login();
});

Then("the user is successfully logged in to their account", () => {
 ShipmentPage.verifyLogin();
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

When("the user verifies the current location of the shipment", () => {
 ShipmentPage.verifyCurrentLocation();
});

Then("the current location is accurately displayed as {string}", (location) => {
 ShipmentPage.checkCurrentLocation(location);
});

When("the user checks the estimated delivery time", () => {
 ShipmentPage.verifyEstimatedDeliveryTime();
});

Then("the estimated delivery time is shown as {string}", (time) => {
 ShipmentPage.checkEstimatedDeliveryTime(time);
});

When("the user refreshes the page to ensure real-time updates are reflected", () => {
 ShipmentPage.refreshPage();
});

Then("any changes in location or delivery time are updated in real-time", () => {
 ShipmentPage.verifyRealTimeUpdates();
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 ShipmentPage.verifyLogout();
});