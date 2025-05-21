import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid customer account with Customer ID {string}", (customerID) => {
 // Assume user is set up with the given customer ID
});

When("the user logs in using valid credentials", () => {
 TrackingPage.login();
});

Then("the user is successfully logged in to their account", () => {
 TrackingPage.verifyLogin();
});

When("the user navigates to the {string} section", (section) => {
 TrackingPage.navigateToSection(section);
});

Then("the {string} section is displayed", (section) => {
 TrackingPage.verifySectionDisplayed(section);
});

When("the user enters the invalid Shipment ID {string} in the search bar", (shipmentID) => {
 TrackingPage.enterShipmentID(shipmentID);
});

Then("the system displays an error message indicating the shipment ID is invalid", () => {
 TrackingPage.verifyInvalidShipmentError();
});

When("the user attempts to refresh the page", () => {
 cy.reload();
});

Then("the error message persists and no shipment details are displayed", () => {
 TrackingPage.verifyErrorMessagePersists();
});

When("the user logs out of the customer account", () => {
 TrackingPage.logout();
});

Then("the user is successfully logged out", () => {
 TrackingPage.verifyLogout();
});