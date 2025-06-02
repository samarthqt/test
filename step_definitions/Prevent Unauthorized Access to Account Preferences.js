import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserAccountPage from "../pages/userAccountPage";

Given("a user with User ID {string} and restricted access", (userId) => {
  UserAccountPage.setUserId(userId);
  UserAccountPage.loginWithRestrictedAccess();
});

When("the user attempts to log in", () => {
  UserAccountPage.attemptLogin();
});

Then("the user should be successfully logged in with restricted access", () => {
  UserAccountPage.verifyRestrictedLoginSuccess();
});

Given("the user is logged in with restricted access", () => {
  UserAccountPage.verifyRestrictedLoginSuccess();
});

When("the user navigates to the account preferences page", () => {
  UserAccountPage.navigateToAccountPreferences();
});

Then("access to account preferences should be denied", () => {
  UserAccountPage.verifyAccessDenied();
});

When("the user attempts to change the account password", () => {
  UserAccountPage.attemptPasswordChange();
});

Then("the system should prevent password change and display an error message", () => {
  UserAccountPage.verifyPasswordChangeError();
});

Given("the user attempted unauthorized access", () => {
  UserAccountPage.simulateUnauthorizedAccess();
});

When("checking system logs", () => {
  UserAccountPage.checkSystemLogs();
});

Then("unauthorized attempt should be logged with user ID and timestamp", () => {
  UserAccountPage.verifyLogEntry();
});

When("checking for security notifications", () => {
  UserAccountPage.checkSecurityNotifications();
});

Then("the user should receive a notification about the unauthorized attempt", () => {
  UserAccountPage.verifySecurityNotification();
});

When("the user attempts to access other restricted settings", () => {
  UserAccountPage.attemptAccessRestrictedSettings();
});

Then("access should be denied for all restricted settings", () => {
  UserAccountPage.verifyAccessDeniedForAll();
});

Given("multiple unauthorized access attempts have been made", () => {
  UserAccountPage.simulateMultipleUnauthorizedAttempts();
});

When("evaluating security measures", () => {
  UserAccountPage.evaluateSecurityMeasures();
});

Then("security measures should effectively prevent unauthorized access", () => {
  UserAccountPage.verifySecurityEffectiveness();
});

When("checking user session status", () => {
  UserAccountPage.checkUserSessionStatus();
});

Then("session should be terminated to prevent further attempts", () => {
  UserAccountPage.verifySessionTermination();
});

Given("the user is attempting to bypass security", () => {
  UserAccountPage.simulateBypassAttempt();
});

When("using different methods", () => {
  UserAccountPage.attemptDifferentBypassMethods();
});

Then("all bypass attempts should be unsuccessful", () => {
  UserAccountPage.verifyBypassFailure();
});

Given("unauthorized access attempts from different devices", () => {
  UserAccountPage.simulateAccessFromDifferentDevices();
});

When("assessing system response", () => {
  UserAccountPage.assessSystemResponse();
});

Then("system should consistently prevent access from all devices", () => {
  UserAccountPage.verifyConsistentPrevention();
});

Given("repeated unauthorized access attempts", () => {
  UserAccountPage.simulateRepeatedAttempts();
});

When("checking account status", () => {
  UserAccountPage.checkAccountStatus();
});

Then("account should be locked after a specified number of attempts", () => {
  UserAccountPage.verifyAccountLockout();
});

Given("unauthorized access attempts are made", () => {
  UserAccountPage.simulateUnauthorizedAttempts();
});

When("reviewing system messages", () => {
  UserAccountPage.reviewSystemMessages();
});

Then("clear error messages should be displayed for each attempt", () => {
  UserAccountPage.verifyErrorMessages();
});

When("checking admin notifications", () => {
  UserAccountPage.checkAdminNotifications();
});

Then("admin should be notified of all unauthorized attempts", () => {
  UserAccountPage.verifyAdminNotification();
});

Given("unauthorized access attempts during peak times", () => {
  UserAccountPage.simulatePeakTimeAttempts();
});

When("evaluating system performance", () => {
  UserAccountPage.evaluateSystemPerformance();
});

Then("system should maintain security and prevent access during peak times", () => {
  UserAccountPage.verifyPeakTimeSecurity();
});

When("users attempt to report them", () => {
  UserAccountPage.attemptToReportUnauthorizedAttempts();
});

Then("users should be able to report unauthorized attempts easily", () => {
  UserAccountPage.verifyUserFeedbackMechanism();
});