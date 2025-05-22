import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CustomerAccountPage from "../pages/customerAccountPage";

Given("the user has a valid customer account with Customer ID {string}", (customerId) => {
 // Assume the account setup is done externally
});

When("the user logs in to the customer account using valid credentials", () => {
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

When("the user enters the Long Shipment ID {string} in the search bar", (shipmentId) => {
 CustomerAccountPage.enterShipmentId(shipmentId);
});

Then("the system processes the input without crashing or displaying errors", () => {
 CustomerAccountPage.verifyNoCrashOrError();
});

When("the user checks if the system provides any feedback or error message for the long ID", () => {
 CustomerAccountPage.checkFeedbackOrErrorMessage();
});

Then("the system either displays an error message or handles the input gracefully", () => {
 CustomerAccountPage.verifyGracefulHandlingOrErrorMessage();
});

When("the user logs out of the customer account", () => {
 CustomerAccountPage.logout();
});

Then("the user is successfully logged out", () => {
 CustomerAccountPage.verifyLogoutSuccess();
});