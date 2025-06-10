import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";
import PasswordResetPage from "../pages/passwordResetPage";

Given("the user is logged into their account", () => {
 AccountSettingsPage.verifyUserLoggedIn();
});

When("the user navigates to the account settings", () => {
 AccountSettingsPage.navigateToSettings();
});

When("the user enters the correct current password", () => {
 AccountSettingsPage.enterCurrentPassword("correctPassword");
});

When("the user enters a new password that meets complexity requirements", () => {
 AccountSettingsPage.enterNewPassword("newComplexPassword");
});

When("the user confirms the new password", () => {
 AccountSettingsPage.confirmNewPassword("newComplexPassword");
});

Then("the system changes the password", () => {
 AccountSettingsPage.verifyPasswordChanged();
});

Then("the user receives a confirmation message", () => {
 AccountSettingsPage.verifyConfirmationMessage();
});

Then("the password change request is logged for security auditing", () => {
 AccountSettingsPage.verifyPasswordChangeLogged();
});

When("the user enters an incorrect current password", () => {
 AccountSettingsPage.enterCurrentPassword("incorrectPassword");
});

Then("the system displays an error message", () => {
 AccountSettingsPage.verifyErrorMessage();
});

Then("the password change request is not processed", () => {
 AccountSettingsPage.verifyPasswordNotChanged();
});

Given("the user has forgotten their password", () => {
 PasswordResetPage.verifyUserForgotPassword();
});

When("the user navigates to the password reset page", () => {
 PasswordResetPage.navigateToResetPage();
});

When("the user enters their email address", () => {
 PasswordResetPage.enterEmailAddress("user@example.com");
});

Then("the system sends a password reset link to the user's email", () => {
 PasswordResetPage.verifyResetLinkSent();
});

Then("the user can set a new password using the reset link", () => {
 PasswordResetPage.verifyPasswordResetLinkFunctionality();
});

Given("the user is changing their password", () => {
 AccountSettingsPage.verifyUserChangingPassword();
});

Then("the system ensures the password change process complies with GDPR and other data protection regulations", () => {
 AccountSettingsPage.verifyGDPRCompliance();
});