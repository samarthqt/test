import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user has a valid customer account", () => {
 // Assume user account is valid and pre-setup
});

When("the user logs in to the customer account using valid credentials", () => {
 ShipmentPage.login();
});

Then("the user is successfully logged in to their account", () => {
 ShipmentPage.verifyLoginSuccess();
});

And("the customer ID is {string}", (customerId) => {
 ShipmentPage.verifyCustomerId(customerId);
});

When("the user navigates to the 'Track Shipment' section", () => {
 ShipmentPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 ShipmentPage.verifyTrackShipmentSection();
});

When("the user enters the long shipment ID {string} in the search bar", (shipmentId) => {
 ShipmentPage.enterShipmentId(shipmentId);
});

Then("the system processes the input without crashing or displaying errors", () => {
 ShipmentPage.verifySystemHandlesLongId();
});

When("the user checks if the system provides any feedback or error message for the long ID", () => {
 ShipmentPage.checkForFeedbackOrErrorMessage();
});

Then("the system either displays an error message or handles the input gracefully", () => {
 ShipmentPage.verifyFeedbackOrGracefulHandling();
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 ShipmentPage.verifyLogoutSuccess();
});