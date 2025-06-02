import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("I am on the registration page", () => {
 RegistrationPage.visit();
});

When("I enter email {string} and password {string} in the registration form", (email, password) => {
 RegistrationPage.enterEmail(email);
 RegistrationPage.enterPassword(password);
});

When("I submit the registration form", () => {
 RegistrationPage.submitForm();
});

Then("I should see an error message indicating the email is already registered", () => {
 RegistrationPage.verifyEmailAlreadyRegisteredError();
});

Then("I should be registered successfully with a new email", () => {
 RegistrationPage.verifySuccessfulRegistration();
});

Then("the error logs should contain messages about the already registered email", () => {
 RegistrationPage.verifyErrorLogsContainEmail();
});

Then("I should not be able to proceed with registration using the same email", () => {
 RegistrationPage.verifyCannotProceedWithSameEmail();
});

Then("the system should handle multiple errors gracefully and display appropriate messages", () => {
 RegistrationPage.verifyGracefulErrorHandling();
});

Then("the system should return to a stable state after handling errors", () => {
 RegistrationPage.verifySystemStableAfterErrors();
});

Then("I should receive clear and informative feedback about the registration error", () => {
 RegistrationPage.verifyClearFeedback();
});

Then("there should be no unhandled exceptions present", () => {
 RegistrationPage.verifyNoUnhandledExceptions();
});

Then("the system logs should not contain critical errors", () => {
 RegistrationPage.verifyNoCriticalErrorsInLogs();
});

Then("I should receive information about alternative registration methods", () => {
 RegistrationPage.verifyAlternativeRegistrationInfo();
});

Then("the system should scale resources appropriately to handle multiple attempts", () => {
 RegistrationPage.verifySystemScalability();
});

Then("the system should remain stable and responsive", () => {
 RegistrationPage.verifySystemStability();
});