import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("the user has valid login credentials", () => {
 // Assume login credentials are stored in environment variables
});

When("the user logs into the account", () => {
 ProfilePage.login(Cypress.env('username'), Cypress.env('password'));
});

Then("the user is logged in successfully and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the profile settings page", () => {
 ProfilePage.navigateToProfileSettings();
});

Then("the profile settings page is displayed with current user details", () => {
 ProfilePage.verifyProfilePageDisplayed();
});

When("the user attempts to update the email field with {string}", (email) => {
 ProfilePage.updateEmail(email);
});

Then("the system displays an error message indicating invalid email format", () => {
 ProfilePage.verifyEmailErrorMessage();
});

Then("the save button is disabled or error prevents saving changes", () => {
 ProfilePage.verifySaveButtonDisabled();
});

When("the user corrects the email format and attempts to save changes", () => {
 ProfilePage.updateEmail("john.doe@example.com");
 ProfilePage.saveChanges();
});

Then("the changes are saved successfully after correcting the email format", () => {
 ProfilePage.verifyChangesSaved();
});