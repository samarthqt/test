import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("I am on the user registration page", () => {
 RegistrationPage.visit();
});

When("I enter valid details such as {string} for name, {string} for email, {string} for password", (name, email, password) => {
 RegistrationPage.enterName(name);
 RegistrationPage.enterEmail(email);
 RegistrationPage.enterPassword(password);
});

When("I enter {string} for name, {string} for email, {string} for password", (name, email, password) => {
 RegistrationPage.enterName(name);
 RegistrationPage.enterEmail(email);
 RegistrationPage.enterPassword(password);
});

When("I leave the name field empty", () => {
 RegistrationPage.clearName();
});

When("I leave the email field empty", () => {
 RegistrationPage.clearEmail();
});

When("I leave the password field empty", () => {
 RegistrationPage.clearPassword();
});

And("I submit the registration form", () => {
 RegistrationPage.submitForm();
});

Then("I should see a confirmation message {string}", (message) => {
 RegistrationPage.confirmationMessage().should('contain', message);
});

Then("I should be redirected to the login page", () => {
 cy.url().should("include", "/login");
});

Then("I should see an error message {string}", (message) => {
 RegistrationPage.errorMessage().should('contain', message);
});

And("the email {string} is already registered", (email) => {
 // Assume an API call or database setup is done here to ensure the email is registered
 cy.request('POST', '/api/register', { email });
});