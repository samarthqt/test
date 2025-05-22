import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShipmentPage from "../pages/shipmentPage";

Given("the user logs into the customer account using valid credentials", () => {
 ShipmentPage.login();
});

And("the user has Customer ID {string}", (customerId) => {
 ShipmentPage.verifyCustomerId(customerId);
});

When("the user navigates to the {string} section", (section) => {
 ShipmentPage.navigateToSection(section);
});

Then("the {string} section is displayed", (section) => {
 ShipmentPage.verifySectionDisplayed(section);
});

When("the user enters the invalid shipment ID {string} in the search bar", (shipmentId) => {
 ShipmentPage.enterShipmentId(shipmentId);
});

Then("the system displays an error message indicating the shipment ID is invalid", () => {
 ShipmentPage.verifyErrorMessage();
});

When("the user attempts to refresh the page", () => {
 ShipmentPage.refreshPage();
});

Then("the error message persists and no shipment details are displayed", () => {
 ShipmentPage.verifyErrorMessagePersists();
 ShipmentPage.verifyNoShipmentDetails();
});

When("the user logs out of the customer account", () => {
 ShipmentPage.logout();
});

Then("the user is successfully logged out", () => {
 ShipmentPage.verifyLogoutSuccess();
});