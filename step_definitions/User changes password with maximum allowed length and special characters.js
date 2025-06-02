import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("the user is logged into the account", () => {
 cy.login();
});

When("the user navigates to the account settings page", () => {
 AccountSettingsPage.visit();
});

Then("the account settings page is displayed", () => {
 AccountSettingsPage.verifyPageDisplayed();
});

And("the user knows the current password {string}", (currentPassword) => {
 cy.wrap(currentPassword).as('currentPassword');
});

When("the user clicks on the 'Change Password' option", () => {
 AccountSettingsPage.clickChangePassword();
});

Then("the change password form is displayed", () => {
 AccountSettingsPage.verifyChangePasswordFormDisplayed();
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

Then("the new password is entered successfully", () => {
 AccountSettingsPage.verifyNewPasswordEntered();
});

When("the user re-enters the new password {string} in the 'Confirm New Password' field", (newPassword) => {
 AccountSettingsPage.reEnterNewPassword(newPassword);
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

And("a success message is displayed confirming the password change", () => {
 AccountSettingsPage.verifySuccessMessageDisplayed();
});

When("the user logs out of the account", () => {
 cy.logout();
});

Then("the user is logged out successfully", () => {
 cy.verifyLogoutSuccessful();
});

When("the user logs in using the new password {string}", (newPassword) => {
 cy.loginWithNewPassword(newPassword);
});

Then("the user logs in successfully with the new password", () => {
 cy.verifyLoginSuccessful();
});

When("the user accesses account settings to verify password change", () => {
 AccountSettingsPage.visit();
});

Then("account settings reflect the new password change", () => {
 AccountSettingsPage.verifyPasswordChangeReflected();
});

And("the new password meets maximum length and special character criteria", () => {
 AccountSettingsPage.verifyPasswordCriteria();
});

When("the user checks if the old password {string} is no longer valid", (oldPassword) => {
 cy.checkOldPasswordInvalid(oldPassword);
});

Then("the old password does not allow login", () => {
 cy.verifyOldPasswordInvalid();
});

When("the user attempts to change password again using the same steps", () => {
 AccountSettingsPage.repeatPasswordChangeSteps();
});

Then("the password change process repeats successfully", () => {
 AccountSettingsPage.verifyPasswordChangeRepeated();
});

When("the user verifies the system logs for password change activity", () => {
 cy.verifySystemLogsForPasswordChange();
});

Then("the system logs show the password change activity", () => {
 cy.verifyPasswordChangeActivityLogged();
});

When("the user checks for any security alerts related to password change", () => {
 cy.checkSecurityAlertsForPasswordChange();
});

Then("no security alerts are triggered", () => {
 cy.verifyNoSecurityAlertsTriggered();
});