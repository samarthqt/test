import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 // Assuming the customer account is already created
});

When("the user logs in to the customer account using valid credentials", () => {
 TrackingPage.login();
});

Then("the user is successfully logged in to their account", () => {
 cy.url().should("include", "/dashboard");
});

Given("the shipment is in transit", () => {
 // Assuming the shipment state is already set
});

When("the user navigates to the 'Track Shipment' section", () => {
 TrackingPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 TrackingPage.verifyTrackShipmentSection();
});

When("the user enters the Shipment ID {string} in the search bar", (shipmentId) => {
 TrackingPage.enterShipmentId(shipmentId);
});

Then("shipment details are displayed for {string}", (shipmentId) => {
 TrackingPage.verifyShipmentDetails(shipmentId);
});

And("the current status of the shipment is displayed as {string}", (status) => {
 TrackingPage.verifyShipmentStatus(status);
});

Then("the current status is accurately displayed as {string}", (status) => {
 TrackingPage.verifyShipmentStatus(status);
});

When("the user refreshes the tracking information", () => {
 TrackingPage.refreshTrackingInformation();
});

Then("the tracking information updates immediately to reflect real-time changes", () => {
 TrackingPage.verifyRealTimeUpdates();
});

When("the user logs out of the customer account", () => {
 TrackingPage.logout();
});

Then("the user is successfully logged out", () => {
 cy.url().should("include", "/login");
});