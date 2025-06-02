import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProfilePage from "../pages/profilePage";

Given("a user account with valid login credentials", () => {
 // Assume user credentials are stored in environment variables
 cy.login(Cypress.env('username'), Cypress.env('password'));
});

When("the user logs in to the user account", () => {
 ProfilePage.visitDashboard();
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

When("the user updates the name field with {string}", (name) => {
 ProfilePage.updateName(name);
});

Then("the name field is updated with {string}", (name) => {
 ProfilePage.verifyNameUpdated(name);
});

When("the user updates the email field with {string}", (email) => {
 ProfilePage.updateEmail(email);
});

Then("the email field is updated with {string}", (email) => {
 ProfilePage.verifyEmailUpdated(email);
});

When("the user updates the shipping address field with {string}", (address) => {
 ProfilePage.updateShippingAddress(address);
});

Then("the shipping address field is updated with {string}", (address) => {
 ProfilePage.verifyShippingAddressUpdated(address);
});

When("the user updates the billing address field with {string}", (address) => {
 ProfilePage.updateBillingAddress(address);
});

Then("the billing address field is updated with {string}", (address) => {
 ProfilePage.verifyBillingAddressUpdated(address);
});

When("the user updates the phone number field with {string}", (phoneNumber) => {
 ProfilePage.updatePhoneNumber(phoneNumber);
});

Then("the phone number field is updated with {string}", (phoneNumber) => {
 ProfilePage.verifyPhoneNumberUpdated(phoneNumber);
});

When("the user saves the changes made to the profile", () => {
 ProfilePage.saveChanges();
});

Then("the changes are saved successfully and a confirmation message is displayed", () => {
 ProfilePage.verifyChangesSaved();
});

When("the user logs out and logs back in to verify updates", () => {
 cy.logout();
 cy.login(Cypress.env('username'), Cypress.env('password'));
 ProfilePage.navigateToProfileSettings();
});

Then("the updated details are displayed correctly on the profile settings page", () => {
 ProfilePage.verifyUpdatedDetails();
});

When("the user checks email for confirmation of changes", () => {
 // Placeholder for email checking logic
});

Then("email confirmation for each updated detail is received", () => {
 // Placeholder for email verification logic
});