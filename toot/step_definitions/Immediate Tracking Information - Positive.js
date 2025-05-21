import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 TrackingPage.verifyCustomerAccount(customerId);
});

Given("the shipment with Shipment ID {string} is in transit", (shipmentId) => {
 TrackingPage.verifyShipmentInTransit(shipmentId);
});

When("the user logs in to the customer account using valid credentials", () => {
 TrackingPage.login();
});

Then("the user is successfully logged in to their account", () => {
 TrackingPage.verifyLoginSuccess();
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

Then("the current status of the shipment is displayed as {string}", (status) => {
 TrackingPage.verifyShipmentStatus(status);
});

Then("the current status is accurately displayed as {string}", (status) => {
 TrackingPage.verifyAccurateShipmentStatus(status);
});

When("the user refreshes the page to check for immediate updates", () => {
 TrackingPage.refreshPage();
});

Then("the tracking information updates immediately to reflect any changes", () => {
 TrackingPage.verifyImmediateTrackingUpdates();
});

When("the user logs out of the customer account", () => {
 TrackingPage.logout();
});

Then("the user is successfully logged out", () => {
 TrackingPage.verifyLogoutSuccess();
});