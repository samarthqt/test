import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ForgotPasswordPage from "../pages/forgotPasswordPage";

Given("a registered user has forgotten their password", () => {
 ForgotPasswordPage.visit();
});

When("the user chooses to recover their password via email", () => {
 ForgotPasswordPage.recoverViaEmail();
});

Then("the system should send a password recovery email to the user's registered email address", () => {
 ForgotPasswordPage.verifyEmailSent();
});

When("the user chooses to recover their password via SMS", () => {
 ForgotPasswordPage.recoverViaSMS();
});

Then("the system should send a password recovery SMS to the user's registered phone number", () => {
 ForgotPasswordPage.verifySMSSent();
});

Given("the user has initiated a password recovery request", () => {
 ForgotPasswordPage.initiateRecoveryRequest();
});

When("the system sends a secure token to the user", () => {
 ForgotPasswordPage.sendSecureToken();
});

Then("the system should validate the user's identity using the secure token", () => {
 ForgotPasswordPage.validateIdentityWithToken();
});

Given("the system has sent a secure token to the user", () => {
 ForgotPasswordPage.sendSecureToken();
});

When("the user attempts to use the token after its expiration time", () => {
 ForgotPasswordPage.useExpiredToken();
});

Then("the system should display an error message for the expired token", () => {
 ForgotPasswordPage.displayExpiredTokenError();
});

Given("the user has successfully reset their password", () => {
 ForgotPasswordPage.successfulPasswordReset();
});

When("the password reset process is completed", () => {
 ForgotPasswordPage.completePasswordReset();
});

Then("the user should receive a confirmation of successful password reset", () => {
 ForgotPasswordPage.confirmSuccessfulReset();
});

Given("the user has an invalid token", () => {
 ForgotPasswordPage.invalidToken();
});

When("the user attempts to reset their password with the invalid token", () => {
 ForgotPasswordPage.resetWithInvalidToken();
});

Then("the system should display an error message for the invalid token", () => {
 ForgotPasswordPage.displayInvalidTokenError();
});

Given("a user has initiated a password reset request", () => {
 ForgotPasswordPage.initiateResetRequest();
});

When("the request is processed", () => {
 ForgotPasswordPage.processRequest();
});

Then("the system should log the password reset request for security auditing", () => {
 ForgotPasswordPage.logResetRequest();
});

Given("the system handles user data for password recovery", () => {
 ForgotPasswordPage.handleUserData();
});

When("processing password reset requests", () => {
 ForgotPasswordPage.processResetRequests();
});

Then("the system must comply with GDPR and other data protection regulations", () => {
 ForgotPasswordPage.complyWithGDPR();
});