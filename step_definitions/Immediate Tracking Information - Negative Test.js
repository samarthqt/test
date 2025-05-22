import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CustomerAccountPage from "../pages/customerAccountPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 CustomerAccountPage.verifyCustomerAccount(customerId);
});

When("the user logs in using valid credentials", () => {
 CustomerAccountPage.login();
});

Then("the user is successfully logged in to their account", () => {
 CustomerAccountPage.verifyLoginSuccess();
});

When("the user navigates to the {string} section", (section) => {
 CustomerAccountPage.navigateToSection(section);
});

Then("the {string} section is displayed", (section) => {
 CustomerAccountPage.verifySectionDisplayed(section);
});

When("the user enters the invalid Shipment ID {string} in the search bar", (shipmentId) => {
 CustomerAccountPage.enterShipmentId(shipmentId);
});

Then("the system displays an error message indicating the shipment ID is invalid", () => {
 CustomerAccountPage.verifyInvalidShipmentError();
});

When("the user attempts to refresh the page", () => {
 cy.reload();
});

Then("the error message persists, and no shipment details are displayed", () => {
 CustomerAccountPage.verifyErrorMessagePersists();
});

When("the user logs out of the customer account", () => {
 CustomerAccountPage.logout();
});

Then("the user is successfully logged out", () => {
 CustomerAccountPage.verifyLogoutSuccess();
});