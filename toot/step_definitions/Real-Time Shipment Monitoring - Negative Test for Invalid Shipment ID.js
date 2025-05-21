import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 // Assume user is already registered with customerId
});

When("the user logs in using valid credentials", () => {
 ShipmentPage.login();
});

Then("the user is successfully logged into their account", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the {string} section", (section) => {
 ShipmentPage.navigateToSection(section);
});

Then("the {string} section is displayed", (section) => {
 cy.contains(section).should("be.visible");
});

When("the user enters the invalid Shipment ID {string} in the search bar", (shipmentId) => {
 ShipmentPage.enterShipmentId(shipmentId);
});

Then("the system displays an error message indicating the shipment ID is invalid", () => {
 cy.contains("Invalid Shipment ID").should("be.visible");
});

When("the user attempts to refresh the page", () => {
 cy.reload();
});

Then("the error message persists and no shipment details are displayed", () => {
 cy.contains("Invalid Shipment ID").should("be.visible");
 cy.contains("Shipment Details").should("not.exist");
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 cy.url().should("include", "/login");
});