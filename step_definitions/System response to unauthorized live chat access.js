import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UnauthorizedAccessPage from "../pages/UnauthorizedAccessPage";

Given("a user with User ID {string} and invalid credentials", (userId) => {
  UnauthorizedAccessPage.setUserId(userId);
});

When("the user attempts to log in", () => {
  UnauthorizedAccessPage.attemptLogin();
});

Then("the login fails with error message {string}", (errorMessage) => {
  UnauthorizedAccessPage.verifyLoginError(errorMessage);
});

Given("a user not logged in", () => {
  UnauthorizedAccessPage.ensureUserNotLoggedIn();
});

When("the user navigates to the 'Help' section", () => {
  UnauthorizedAccessPage.navigateToHelpSection();
});

Then("access to the Help section is restricted", () => {
  UnauthorizedAccessPage.verifyHelpSectionAccessRestricted();
});

Given("a user in the 'Help' section without logging in", () => {
  UnauthorizedAccessPage.ensureUserInHelpSectionWithoutLogin();
});

When("the user tries to initiate live chat", () => {
  UnauthorizedAccessPage.initiateLiveChat();
});

Then("the system denies access to live chat feature with status {string}", (status) => {
  UnauthorizedAccessPage.verifyLiveChatAccessDenied(status);
});

Given("a user on a restricted network", () => {
  UnauthorizedAccessPage.setUserOnRestrictedNetwork();
});

When("the user attempts live chat access", () => {
  UnauthorizedAccessPage.attemptLiveChatAccess();
});

Then("access is denied with error message {string}", (errorMessage) => {
  UnauthorizedAccessPage.verifyNetworkAccessDenied(errorMessage);
});

When("checking the system logs", () => {
  UnauthorizedAccessPage.checkSystemLogs();
});

Then("logs contain entries for denied access attempts", () => {
  UnauthorizedAccessPage.verifyDeniedAccessLogs();
});

When("unauthorized access attempts occur", () => {
  UnauthorizedAccessPage.simulateUnauthorizedAccessAttempts();
});

Then("security alerts are triggered", () => {
  UnauthorizedAccessPage.verifySecurityAlertsTriggered();
});

Given("a user attempts to alter network settings", () => {
  UnauthorizedAccessPage.attemptNetworkSettingsAlteration();
});

When("the system detects unauthorized network changes", () => {
  UnauthorizedAccessPage.detectUnauthorizedNetworkChanges();
});

Then("the system prevents the changes", () => {
  UnauthorizedAccessPage.verifyNetworkChangePrevention();
});

Given("a user using a proxy server", () => {
  UnauthorizedAccessPage.setUserUsingProxyServer();
});

When("the user attempts to access live chat", () => {
  UnauthorizedAccessPage.attemptLiveChatAccess();
});

Then("access is denied with error message {string}", (errorMessage) => {
  UnauthorizedAccessPage.verifyProxyAccessDenied(errorMessage);
});

Given("multiple unauthorized access attempts", () => {
  UnauthorizedAccessPage.setMultipleUnauthorizedAttempts();
});

When("the attempts exceed the allowed limit", () => {
  UnauthorizedAccessPage.exceedAllowedAttemptsLimit();
});

Then("the system locks the account", () => {
  UnauthorizedAccessPage.verifyAccountLock();
});

When("unauthorized access is attempted", () => {
  UnauthorizedAccessPage.attemptUnauthorizedAccess();
});

Then("the UI provides clear feedback on access denial", () => {
  UnauthorizedAccessPage.verifyUIFeedbackOnAccessDenial();
});

Given("a user with an expired session", () => {
  UnauthorizedAccessPage.setUserWithExpiredSession();
});

When("the user attempts to access live chat", () => {
  UnauthorizedAccessPage.attemptLiveChatAccess();
});

Then("access is denied with error message {string}", (errorMessage) => {
  UnauthorizedAccessPage.verifySessionExpiredAccessDenied(errorMessage);
});

When("unauthorized access attempts occur", () => {
  UnauthorizedAccessPage.simulateUnauthorizedAccessAttempts();
});

Then("the user receives a notification for failed access attempts", () => {
  UnauthorizedAccessPage.verifyUserNotificationForFailedAttempts();
});

Given("a load of unauthorized access attempts", () => {
  UnauthorizedAccessPage.setLoadOfUnauthorizedAttempts();
});

When("the system is under load", () => {
  UnauthorizedAccessPage.simulateSystemUnderLoad();
});

Then("system performance remains unaffected", () => {
  UnauthorizedAccessPage.verifySystemPerformance();
});

When("reviewing the system logs", () => {
  UnauthorizedAccessPage.reviewSystemLogs();
});

Then("logs highlight unusual access patterns for further analysis", () => {
  UnauthorizedAccessPage.verifyUnusualAccessPatterns();
});

Given("a user with access issues", () => {
  UnauthorizedAccessPage.setUserWithAccessIssues();
});

When("the user contacts customer support", () => {
  UnauthorizedAccessPage.contactCustomerSupport();
});

Then("customer support is available to assist with access issues", () => {
  UnauthorizedAccessPage.verifyCustomerSupportAvailability();
});