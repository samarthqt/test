import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignupPage from "../pages/signupPage";

Given("the user is on the email marketing signup page", () => {
 SignupPage.visit();
});

When("the user enters a valid email address", () => {
 SignupPage.enterEmail('valid@example.com');
});

When("the user enters an invalid email address", () => {
 SignupPage.enterEmail('invalid-email');
});

When("the user enters an email address that is already registered", () => {
 SignupPage.enterEmail('registered@example.com');
});

When("the user submits the signup form", () => {
 SignupPage.submitForm();
});

When("the user submits the signup form without entering an email address", () => {
 SignupPage.submitForm();
});

When("the user clicks on the privacy policy link", () => {
 SignupPage.clickPrivacyPolicy();
});

Then("the user should see a confirmation message", () => {
 SignupPage.confirmationMessage().should('be.visible');
});

Then("the user should see an error message indicating the email is invalid", () => {
 SignupPage.errorMessage().should('contain', 'invalid email');
});

Then("the user should see a message indicating the email is already registered", () => {
 SignupPage.alreadyRegisteredMessage().should('contain', 'already registered');
});

Then("the user should see an error message indicating that an email address is required", () => {
 SignupPage.errorMessage().should('contain', 'email address is required');
});

Then("the user should be redirected to the privacy policy page", () => {
 cy.url().should('include', '/privacy-policy');
});

Then("the user should be able to return to the signup page", () => {
 SignupPage.returnToSignupPage();
 cy.url().should('include', '/signup');
});

Then("the user should be added to the email marketing list", () => {
 SignupPage.checkEmailAdded('valid@example.com');
});

Then("the user should not be added to the email marketing list", () => {
 SignupPage.checkEmailNotAdded('invalid-email');
});

Then("the user should not be added to the email marketing list again", () => {
 SignupPage.checkEmailNotAddedAgain('registered@example.com');
});