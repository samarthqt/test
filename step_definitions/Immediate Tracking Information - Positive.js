import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 // Assume the user account is already created and stored in the system
});

When("the user logs into the customer account using valid credentials", () => {
 TrackingPage.login();
});

Then("the user is successfully logged in to their account", () => {
 TrackingPage.verifyLoginSuccess();
});

Then("the shipment with Shipment ID {string} is in transit", (shipmentId) => {
 TrackingPage.verifyShipmentInTransit(shipmentId);
});

When("the user navigates to the 'Track Shipment' section", () => {
 TrackingPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 TrackingPage.verifyTrackShipmentSectionDisplayed();
});

When("the user enters the Shipment ID {string} in the search bar", (shipmentId) => {
 TrackingPage.enterShipmentId(shipmentId);
});

Then("the shipment details are displayed for {string}", (shipmentId) => {
 TrackingPage.verifyShipmentDetailsDisplayed(shipmentId);
});

Then("the current status of the shipment is {string}", (status) => {
 TrackingPage.verifyShipmentStatus(status);
});

When("the user verifies the current status of the shipment", () => {
 TrackingPage.verifyCurrentStatus();
});

Then("the current status is accurately displayed as {string}", (status) => {
 TrackingPage.verifyAccurateStatus(status);
});

When("the user refreshes the page to check for immediate updates", () => {
 TrackingPage.refreshPage();
});

Then("tracking information updates immediately to reflect any changes", () => {
 TrackingPage.verifyImmediateUpdates();
});

When("the user logs out of the customer account", () => {
 TrackingPage.logout();
});

Then("the user is successfully logged out", () => {
 TrackingPage.verifyLogoutSuccess();
});