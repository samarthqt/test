import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user is on the registration page", () => {
 RegistrationPage.visit();
});

When("the user enters valid details in all required fields", (dataTable) => {
 const data = dataTable.rowsHash();
 RegistrationPage.enterFirstName(data['First Name']);
 RegistrationPage.enterLastName(data['Last Name']);
 RegistrationPage.enterEmail(data['Email']);
 RegistrationPage.enterPassword(data['Password']);
 RegistrationPage.enterConfirmPassword(data['Confirm Password']);
});

When("the user submits the registration form", () => {
 RegistrationPage.submit();
});

Then("the user account should be created successfully", () => {
 RegistrationPage.verifyAccountCreation();
});

Then("the user should see a confirmation message \"Registration successful\"", () => {
 RegistrationPage.verifySuccessMessage();
});

When("the user leaves the {string} field empty", (field) => {
 RegistrationPage.leaveFieldEmpty(field);
});

Then("the user should see an error message \"{string}\"", (errorMessage) => {
 RegistrationPage.verifyErrorMessage(errorMessage);
});

When("the user enters an invalid email format {string}", (email) => {
 RegistrationPage.enterEmail(email);
});

When("the user enters {string} in the {string} field", (value, field) => {
 RegistrationPage.enterFieldValue(field, value);
});

When("the user enters an email {string} that is already registered", (email) => {
 RegistrationPage.enterEmail(email);
});