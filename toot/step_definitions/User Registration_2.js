import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user is on the registration page", () => {
 RegistrationPage.visit();
});

When("the user enters a valid username", () => {
 RegistrationPage.enterUsername('validUsername');
});

When("the user enters a valid email address", () => {
 RegistrationPage.enterEmail('valid@example.com');
});

When("the user enters a valid password", () => {
 RegistrationPage.enterPassword('ValidPass123');
});

When("the user confirms the password", () => {
 RegistrationPage.confirmPassword('ValidPass123');
});

When("the user submits the registration form", () => {
 RegistrationPage.submitForm();
});

Then("the user should see a confirmation message", () => {
 RegistrationPage.verifyConfirmationMessage();
});

Then("the user account should be created successfully", () => {
 RegistrationPage.verifyAccountCreation();
});

When("the user enters an email address that is already registered", () => {
 RegistrationPage.enterEmail('registered@example.com');
});

Then("the user should see an error message indicating the email is already in use", () => {
 RegistrationPage.verifyEmailInUseError();
});

When("the user enters an invalid email address", () => {
 RegistrationPage.enterEmail('invalidEmail');
});

Then("the user should see an error message indicating the email format is invalid", () => {
 RegistrationPage.verifyInvalidEmailFormatError();
});

When("the user enters a password", () => {
 RegistrationPage.enterPassword('SomePass123');
});

When("the user enters a different password in the confirm password field", () => {
 RegistrationPage.confirmPassword('DifferentPass123');
});

Then("the user should see an error message indicating the passwords do not match", () => {
 RegistrationPage.verifyPasswordsMismatchError();
});

When("the user leaves the username field empty", () => {
 RegistrationPage.enterUsername('');
});

When("the user leaves the email field empty", () => {
 RegistrationPage.enterEmail('');
});

When("the user leaves the password field empty", () => {
 RegistrationPage.enterPassword('');
});

When("the user leaves the confirm password field empty", () => {
 RegistrationPage.confirmPassword('');
});

Then("the user should see an error message indicating that all fields are required", () => {
 RegistrationPage.verifyAllFieldsRequiredError();
});

When("the user enters a password that does not meet complexity requirements", () => {
 RegistrationPage.enterPassword('simple');
});

Then("the user should see an error message indicating the password does not meet complexity requirements", () => {
 RegistrationPage.verifyPasswordComplexityError();
});