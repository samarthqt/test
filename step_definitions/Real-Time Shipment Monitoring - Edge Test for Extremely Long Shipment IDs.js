import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account", () => {
 // Assume user account is valid
});

When("the user logs in to the customer account using valid credentials", () => {
 ShipmentPage.login();
});

Then("the user is successfully logged in to their account", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in to their account", () => {
 ShipmentPage.ensureLoggedIn();
});

When("the user navigates to the 'Track Shipment' section", () => {
 ShipmentPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 cy.get("#trackShipmentSection").should("be.visible");
});

Given("the user is in the 'Track Shipment' section", () => {
 ShipmentPage.ensureInTrackShipmentSection();
});

When("the user enters the long shipment ID \"SHIP12345678901234567890\" in the search bar", () => {
 ShipmentPage.enterShipmentID("SHIP12345678901234567890");
});

Then("the system processes the input without crashing or displaying errors", () => {
 cy.get("#errorMessage").should("not.exist");
});

Given("the user has entered a long shipment ID", () => {
 ShipmentPage.ensureShipmentIDEntered();
});

When("the system processes the input", () => {
 ShipmentPage.processShipmentID();
});

Then("the system either displays an error message or handles the input gracefully", () => {
 cy.get("#errorMessage").should("exist").or.cy.get("#shipmentDetails").should("be.visible");
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 cy.url().should("include", "/login");
});