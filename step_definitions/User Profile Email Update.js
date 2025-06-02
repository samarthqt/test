import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("a user account with valid login credentials", () => {
 // Assume user credentials are set in environment variables
 cy.visit("/login");
 cy.get("#username").type(Cypress.env("username"));
 cy.get("#password").type(Cypress.env("password"));
 cy.get("#loginBtn").click();
});

When("the user logs in to the account", () => {
 cy.url().should("include", "/dashboard");
});

Then("the user is redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the profile settings page", () => {
 ProfilePage.visitProfileSettings();
});

Then("the profile settings page is displayed with current user details", () => {
 ProfilePage.verifyProfileDetails();
});

When("the user attempts to update the email field with {string}", (email) => {
 ProfilePage.updateEmail(email);
});

Then("the system displays an error message indicating invalid email format", () => {
 ProfilePage.verifyInvalidEmailError();
});

Then("changes cannot be saved with the invalid email", () => {
 ProfilePage.verifySaveButtonDisabled();
});

Then("the save button is disabled or error prevents saving changes", () => {
 ProfilePage.verifySaveButtonDisabled();
});

When("the user corrects the email format", () => {
 ProfilePage.correctEmail();
});

When("attempts to save changes", () => {
 ProfilePage.saveChanges();
});

Then("the changes are saved successfully after correcting the email format", () => {
 ProfilePage.verifyChangesSaved();
});