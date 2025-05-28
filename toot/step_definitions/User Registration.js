import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("I am on the registration page", () => {
 RegistrationPage.visit();
});

When("I enter valid details such as username, email, and password", () => {
 RegistrationPage.enterValidDetails();
});

When("I submit the registration form", () => {
 RegistrationPage.submitForm();
});

Then("I should see a confirmation message", () => {
 RegistrationPage.verifyConfirmationMessage();
});

Then("I should be redirected to the login page", () => {
 cy.url().should("include", "/login");
});

Given("I have an existing account with the email {string}", (email) => {
 RegistrationPage.setExistingEmail(email);
});

When("I enter {string} as my email", (email) => {
 RegistrationPage.enterEmail(email);
});

When("I fill in other valid details", () => {
 RegistrationPage.fillOtherValidDetails();
});

Then("I should see an error message indicating the email is already registered", () => {
 RegistrationPage.verifyEmailAlreadyRegisteredError();
});

When("I enter a password that does not meet the security requirements", () => {
 RegistrationPage.enterWeakPassword();
});

Then("I should see an error message indicating the password is too weak", () => {
 RegistrationPage.verifyWeakPasswordError();
});

When("I leave one or more required fields empty", () => {
 RegistrationPage.leaveRequiredFieldsEmpty();
});

Then("I should see an error message indicating the fields are required", () => {
 RegistrationPage.verifyRequiredFieldsError();
});

When("I enter an invalid email format", () => {
 RegistrationPage.enterInvalidEmailFormat();
});

Then("I should see an error message indicating the email format is invalid", () => {
 RegistrationPage.verifyInvalidEmailFormatError();
});

When("I enter a password and a different password in the confirmation field", () => {
 RegistrationPage.enterMismatchedPasswords();
});

Then("I should see an error message indicating the passwords do not match", () => {
 RegistrationPage.verifyPasswordsMismatchError();
});