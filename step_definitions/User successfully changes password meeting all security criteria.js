import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("the user is logged into the account", () => {
 // Assume user is already logged in
});

When("the user navigates to the account settings page", () => {
 AccountSettingsPage.visit();
});

Then("the account settings page is displayed", () => {
 AccountSettingsPage.verifyPage();
});

When("the user clicks on the 'Change Password' option", () => {
 AccountSettingsPage.clickChangePassword();
});

Then("the change password form is displayed", () => {
 AccountSettingsPage.verifyChangePasswordForm();
});

When("the user enters the current password {string} in the 'Current Password' field", (currentPassword) => {
 AccountSettingsPage.enterCurrentPassword(currentPassword);
});

Then("the current password is entered successfully", () => {
 AccountSettingsPage.verifyCurrentPasswordEntered();
});

When("the user enters the new password {string} in the 'New Password' field", (newPassword) => {
 AccountSettingsPage.enterNewPassword(newPassword);
});

When("the user re-enters the new password {string} in the 'Confirm New Password' field", (newPassword) => {
 AccountSettingsPage.enterConfirmNewPassword(newPassword);
});

Then("the new password is confirmed successfully", () => {
 AccountSettingsPage.verifyNewPasswordConfirmed();
});

When("the user clicks on the 'Submit' button", () => {
 AccountSettingsPage.submitPasswordChange();
});

Then("the password change request is submitted", () => {
 AccountSettingsPage.verifyPasswordChangeSubmitted();
});

Then("a success message is displayed confirming the password change", () => {
 AccountSettingsPage.verifySuccessMessage();
});

When("the user logs out of the account", () => {
 AccountSettingsPage.logout();
});

Then("the user is logged out successfully", () => {
 AccountSettingsPage.verifyLogoutSuccessful();
});

When("the user logs in using the new password {string}", (newPassword) => {
 AccountSettingsPage.loginWithNewPassword(newPassword);
});

Then("the user logs in successfully with the new password", () => {
 AccountSettingsPage.verifyLoginSuccessful();
});

When("the user accesses account settings to verify password change", () => {
 AccountSettingsPage.verifyPasswordChangeInSettings();
});

Then("the account settings reflect the new password change", () => {
 AccountSettingsPage.verifyPasswordChangeReflected();
});

When("the user ensures the new password meets security criteria", () => {
 AccountSettingsPage.verifyPasswordSecurityCriteria();
});

Then("the new password meets all security criteria", () => {
 AccountSettingsPage.verifySecurityCriteriaMet();
});

When("the user checks if the old password {string} is no longer valid", (oldPassword) => {
 AccountSettingsPage.verifyOldPasswordInvalid(oldPassword);
});

Then("the old password does not allow login", () => {
 AccountSettingsPage.verifyOldPasswordRejected();
});

When("the user attempts to change the password again using the same steps", () => {
 AccountSettingsPage.repeatPasswordChangeProcess();
});

Then("the password change process repeats successfully", () => {
 AccountSettingsPage.verifyPasswordChangeProcessRepeated();
});

When("the user verifies the system logs for password change activity", () => {
 AccountSettingsPage.verifySystemLogsForPasswordChange();
});

Then("the system logs show the password change activity", () => {
 AccountSettingsPage.verifyLogsShowActivity();
});

When("the user checks for any security alerts related to password change", () => {
 AccountSettingsPage.checkForSecurityAlerts();
});

Then("no security alerts are triggered", () => {
 AccountSettingsPage.verifyNoSecurityAlerts();
});