import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";
import LoginPage from "../pages/loginPage";

Given("the user is logged into the account", () => {
 LoginPage.login('username', 'password');
});

When("the user navigates to the account settings page", () => {
 AccountSettingsPage.visit();
});

Then("the account settings page is displayed", () => {
 AccountSettingsPage.verifyPageDisplayed();
});

When("the user clicks on the 'Change Password' option", () => {
 AccountSettingsPage.clickChangePassword();
});

Then("the change password form is displayed", () => {
 AccountSettingsPage.verifyChangePasswordFormDisplayed();
});

When("the user enters {string} in the 'Current Password' field", (currentPassword) => {
 AccountSettingsPage.enterCurrentPassword(currentPassword);
});

When("the user enters {string} in the 'New Password' field", (newPassword) => {
 AccountSettingsPage.enterNewPassword(newPassword);
});

When("the user re-enters {string} in the 'Confirm New Password' field", (confirmNewPassword) => {
 AccountSettingsPage.enterConfirmNewPassword(confirmNewPassword);
});

When("the user clicks on the 'Submit' button", () => {
 AccountSettingsPage.submitChangePassword();
});

Then("an error message is displayed indicating incorrect current password", () => {
 AccountSettingsPage.verifyIncorrectPasswordError();
});

When("the user attempts to log out of the account", () => {
 AccountSettingsPage.logout();
});

Then("the user is logged out successfully", () => {
 LoginPage.verifyLoggedOut();
});

When("the user attempts to log in using the new password", () => {
 LoginPage.login('username', 'NewPassword456@');
});

Then("login fails with the new password", () => {
 LoginPage.verifyLoginFailed();
});

When("the user attempts to log in using the old password", () => {
 LoginPage.login('username', 'password');
});

Then("the user logs in successfully with the old password", () => {
 LoginPage.verifyLoginSuccessful();
});

When("the user accesses account settings to verify password change attempt", () => {
 AccountSettingsPage.visit();
});

Then("account settings do not reflect any password change", () => {
 AccountSettingsPage.verifyNoPasswordChange();
});

When("the system logs are checked for the failed password change attempt", () => {
 AccountSettingsPage.checkSystemLogs();
});

Then("system logs show the failed password change attempt", () => {
 AccountSettingsPage.verifySystemLogsForFailedAttempt();
});

When("ensuring no security alerts are triggered by the failed attempt", () => {
 AccountSettingsPage.checkSecurityAlerts();
});

Then("no security alerts are triggered", () => {
 AccountSettingsPage.verifyNoSecurityAlerts();
});

When("the user attempts to change password using the correct current password", () => {
 AccountSettingsPage.changePassword('password', 'NewPassword456@');
});

Then("the password change process succeeds with correct current password", () => {
 AccountSettingsPage.verifyPasswordChangeSuccess();
});

When("verifying system behavior after multiple incorrect attempts", () => {
 AccountSettingsPage.verifySystemBehaviorAfterMultipleAttempts();
});

Then("the system locks the account or prompts security questions after multiple failed attempts", () => {
 AccountSettingsPage.verifyAccountLockOrSecurityPrompt();
});