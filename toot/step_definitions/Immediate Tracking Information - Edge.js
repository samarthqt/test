import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CustomerPage from "../pages/customerPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 CustomerPage.setCustomerId(customerId);
});

When("the user logs in to the customer account using valid credentials", () => {
 CustomerPage.login();
});

Then("the user is successfully logged in to their account", () => {
 CustomerPage.verifyLoginSuccess();
});

And("the user navigates to the 'Track Shipment' section", () => {
 CustomerPage.navigateToTrackShipment();
});

Then("the 'Track Shipment' section is displayed", () => {
 CustomerPage.verifyTrackShipmentDisplayed();
});

When("the user enters the Long Shipment ID {string} in the search bar", (shipmentId) => {
 CustomerPage.enterShipmentId(shipmentId);
});

Then("the system processes the input without crashing or displaying errors", () => {
 CustomerPage.verifyInputProcessing();
});

And("the system provides feedback or an error message for the long ID", () => {
 CustomerPage.verifyFeedbackForLongId();
});

Then("the system either displays an error message or handles the input gracefully", () => {
 CustomerPage.verifyGracefulHandling();
});

When("the user logs out of the customer account", () => {
 CustomerPage.logout();
});

Then("the user is successfully logged out", () => {
 CustomerPage.verifyLogoutSuccess();
});