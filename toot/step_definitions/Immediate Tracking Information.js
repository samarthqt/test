import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid customer account", () => {
 // Assume user has a valid account setup
});

And("the user logs in using valid credentials", () => {
 TrackingPage.login("validUsername", "validPassword");
});

When("the user navigates to the 'Track Shipment' section", () => {
 TrackingPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 TrackingPage.verifyTrackShipmentSectionDisplayed();
});

And("the user enters the Shipment ID {string} in the search bar", (shipmentId) => {
 TrackingPage.enterShipmentId(shipmentId);
});

Then("the shipment details are displayed for {string}", (shipmentId) => {
 TrackingPage.verifyShipmentDetailsDisplayed(shipmentId);
});

And("the current status of the shipment is displayed as {string}", (status) => {
 TrackingPage.verifyShipmentStatus(status);
});

When("the user refreshes the tracking information", () => {
 TrackingPage.refreshTrackingInformation();
});

Then("the tracking information updates immediately to reflect real-time changes", () => {
 TrackingPage.verifyRealTimeTrackingUpdates();
});

And("the user logs out of the customer account", () => {
 TrackingPage.logout();
});

Then("the user is successfully logged out", () => {
 TrackingPage.verifySuccessfulLogout();
});