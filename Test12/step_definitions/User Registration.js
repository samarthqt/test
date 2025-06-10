import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RegistrationPage from "../pages/registrationPage";

Given("the user is on the registration page", () => {
 RegistrationPage.visit();
});

When("the user enters valid email and password", () => {
 RegistrationPage.enterEmailAndPassword();
});

When("the user submits the registration form", () => {
 RegistrationPage.submitForm();
});

Then("the user should receive an email verification link", () => {
 RegistrationPage.verifyEmailSent();
});

Then("the user should be redirected to the home page upon successful verification", () => {
 cy.url().should("include", "/home");
});

When("the user chooses to register using Google", () => {
 RegistrationPage.registerWithGoogle();
});

When("the user completes the Google authentication process", () => {
 RegistrationPage.completeGoogleAuth();
});

Then("the user should be redirected to the home page", () => {
 cy.url().should("include", "/home");
});

When("the user chooses to register using Facebook", () => {
 RegistrationPage.registerWithFacebook();
});

When("the user completes the Facebook authentication process", () => {
 RegistrationPage.completeFacebookAuth();
});

When("the user submits the registration form with invalid details", () => {
 RegistrationPage.submitInvalidForm();
});

Then("the user should see an error message indicating the registration failed", () => {
 RegistrationPage.verifyErrorMessage();
});

Then("the user should see options to register using email, Google, and Facebook clearly", () => {
 RegistrationPage.verifyRegistrationOptions();
});

Given("the user completes the registration process", () => {
 RegistrationPage.completeRegistration();
});

Then("the system should log the registration activity for monitoring", () => {
 RegistrationPage.verifyLogging();
});

Given("the user has successfully registered", () => {
 RegistrationPage.successfulRegistration();
});

Then("the user's profile should be integrated with the user profile management system", () => {
 RegistrationPage.verifyProfileIntegration();
});

Given("the user is registering on the platform", () => {
 RegistrationPage.startRegistration();
});

Then("the registration process should comply with data protection regulations", () => {
 RegistrationPage.verifyDataProtectionCompliance();
});