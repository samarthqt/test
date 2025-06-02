import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PasswordRecoveryPage from "../pages/passwordRecoveryPage";

Given("a user account with a registered email {string}", (email) => {
 cy.wrap(email).as('registeredEmail');
});

When("the user navigates to the login page", () => {
 PasswordRecoveryPage.visitLoginPage();
});

Then("the login page is displayed", () => {
 PasswordRecoveryPage.verifyLoginPageDisplayed();
});

When("the user clicks on the {string} link", (linkText) => {
 PasswordRecoveryPage.clickForgotPasswordLink(linkText);
});

Then("the {string} page is displayed", (pageTitle) => {
 PasswordRecoveryPage.verifyPageDisplayed(pageTitle);
});

When("the user enters the registered email address {string}", (email) => {
 PasswordRecoveryPage.enterEmailAddress(email);
});

Then("the email address is accepted", () => {
 PasswordRecoveryPage.verifyEmailAccepted();
});

When("the user submits the password recovery request", () => {
 PasswordRecoveryPage.submitRecoveryRequest();
});

Then("a confirmation message for password recovery is displayed", () => {
 PasswordRecoveryPage.verifyConfirmationMessage();
});

When("the user checks the registered email inbox for the recovery email", () => {
 PasswordRecoveryPage.checkRecoveryEmail();
});

Then("the password recovery email is received", () => {
 PasswordRecoveryPage.verifyRecoveryEmailReceived();
});

When("the user opens the password recovery email", () => {
 PasswordRecoveryPage.openRecoveryEmail();
});

Then("the email content is displayed", () => {
 PasswordRecoveryPage.verifyEmailContentDisplayed();
});

When("the user verifies the presence of a secure link in the email", () => {
 PasswordRecoveryPage.verifySecureLinkInEmail();
});

Then("a secure link is present in the email", () => {
 PasswordRecoveryPage.verifySecureLinkPresent();
});

When("the user clicks on the secure link", () => {
 PasswordRecoveryPage.clickSecureLink();
});

Then("the link redirects to the password reset page", () => {
 PasswordRecoveryPage.verifyRedirectToPasswordResetPage();
});

When("the user ensures the password reset page is secure (HTTPS)", () => {
 PasswordRecoveryPage.verifyPageIsSecure();
});

Then("the password reset page is secured with HTTPS", () => {
 PasswordRecoveryPage.verifyPageSecuredWithHTTPS();
});

When("the user logs out of any active sessions", () => {
 PasswordRecoveryPage.logoutActiveSessions();
});

Then("the user is logged out successfully", () => {
 PasswordRecoveryPage.verifyUserLoggedOut();
});