import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PasswordRecoveryPage from "../pages/passwordRecoveryPage";

Given("the user is on the login page", () => {
 PasswordRecoveryPage.visitLoginPage();
});

When("the user clicks on the 'Forgot Password' link", () => {
 PasswordRecoveryPage.clickForgotPasswordLink();
});

Then("the 'Forgot Password' page is displayed", () => {
 PasswordRecoveryPage.verifyForgotPasswordPage();
});

Given("the user is on the 'Forgot Password' page", () => {
 PasswordRecoveryPage.verifyForgotPasswordPage();
});

When("the user enters the registered email address {string}", (email) => {
 PasswordRecoveryPage.enterEmailAddress(email);
});

Then("the email address is accepted", () => {
 PasswordRecoveryPage.verifyEmailAccepted();
});

Given("the user has entered a registered email address", () => {
 PasswordRecoveryPage.verifyEmailAccepted();
});

When("the user submits the password recovery request", () => {
 PasswordRecoveryPage.submitRecoveryRequest();
});

Then("a confirmation message for password recovery is displayed", () => {
 PasswordRecoveryPage.verifyConfirmationMessage();
});

Given("the user has submitted a password recovery request", () => {
 PasswordRecoveryPage.verifyConfirmationMessage();
});

When("the user checks the registered email inbox", () => {
 PasswordRecoveryPage.checkEmailInbox();
});

Then("the password recovery email is received", () => {
 PasswordRecoveryPage.verifyRecoveryEmailReceived();
});

Given("the password recovery email is received", () => {
 PasswordRecoveryPage.verifyRecoveryEmailReceived();
});

When("the user opens the email", () => {
 PasswordRecoveryPage.openRecoveryEmail();
});

Then("the email contains a secure recovery link", () => {
 PasswordRecoveryPage.verifySecureRecoveryLink();
});

Given("the user has a secure recovery link from the email", () => {
 PasswordRecoveryPage.verifySecureRecoveryLink();
});

When("the user attempts to use the recovery link", () => {
 PasswordRecoveryPage.useRecoveryLink();
});

Then("the recovery link leads to the password reset page", () => {
 PasswordRecoveryPage.verifyPasswordResetPage();
});

Given("the user is logged in", () => {
 PasswordRecoveryPage.verifyUserLoggedIn();
});

When("the user logs out of any active sessions", () => {
 PasswordRecoveryPage.logoutOfActiveSessions();
});

Then("the user is logged out successfully", () => {
 PasswordRecoveryPage.verifyLogoutSuccess();
});