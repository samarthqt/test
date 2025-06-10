import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SignUpPage from "../pages/signUpPage";
import SignInPage from "../pages/signInPage";

Given("the user is on the sign-up page", () => {
 SignUpPage.visit();
});

When("the user enters a valid email address and password", () => {
 SignUpPage.enterEmail("user@example.com");
 SignUpPage.enterPassword("password123");
});

When("the user submits the form", () => {
 SignUpPage.submitForm();
});

Then("the system should create a new account", () => {
 cy.url().should("include", "/welcome");
});

Then("the system should validate the email address", () => {
 SignUpPage.verifyEmailValidation();
});

Then("the user should be logged in", () => {
 cy.url().should("include", "/dashboard");
});

When("the user chooses to sign up with Google", () => {
 SignUpPage.signUpWithGoogle();
});

Then("the system should authenticate using Google credentials", () => {
 SignUpPage.verifyGoogleAuthentication();
});

When("the user chooses to sign up with Facebook", () => {
 SignUpPage.signUpWithFacebook();
});

Then("the system should authenticate using Facebook credentials", () => {
 SignUpPage.verifyFacebookAuthentication();
});

Given("the user has an existing account", () => {
 SignInPage.verifyExistingAccount();
});

Given("the user is on the sign-in page", () => {
 SignInPage.visit();
});

When("the user enters a valid email and password", () => {
 SignInPage.enterEmail("user@example.com");
 SignInPage.enterPassword("password123");
});

When("the user chooses to sign in with Google", () => {
 SignInPage.signInWithGoogle();
});

When("the user chooses to sign in with Facebook", () => {
 SignInPage.signInWithFacebook();
});

Then("the system should display an error message", () => {
 SignInPage.verifyErrorMessage();
});

When("the user clicks on \"Forgot Password\"", () => {
 SignInPage.clickForgotPassword();
});

Then("the system should send a password recovery email", () => {
 SignInPage.verifyPasswordRecoveryEmail();
});

Given("the user signs in successfully", () => {
 SignInPage.verifySuccessfulSignIn();
});

Then("the system should log the authentication activity for security purposes", () => {
 SignInPage.verifyAuthenticationLogging();
});

Given("the user signs up or signs in", () => {
 SignInPage.verifySignUpOrSignIn();
});

Then("the system should ensure compliance with GDPR for data protection", () => {
 SignInPage.verifyGDPRCompliance();
});