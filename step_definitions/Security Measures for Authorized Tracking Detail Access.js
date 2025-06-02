import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SecurityPage from "../pages/securityPage";

Given("the user authentication module is active", () => {
 SecurityPage.checkAuthModuleActive();
});

When("I log in as an authorized user with User ID {string}", (userId) => {
 SecurityPage.logInAsAuthorizedUser(userId);
});

Then("I should be successfully logged in", () => {
 SecurityPage.verifySuccessfulLogin();
});

Given("I am logged in as an authorized user", () => {
 SecurityPage.logInAsAuthorizedUser("12345");
});

When("I navigate to the tracking details page", () => {
 SecurityPage.navigateToTrackingDetailsPage();
});

Then("the tracking details page should be accessible", () => {
 SecurityPage.verifyTrackingDetailsPageAccess();
});

Given("I am on the tracking details page", () => {
 SecurityPage.verifyTrackingDetailsPageAccess();
});

When("I enter a valid tracking number {string}", (trackingNumber) => {
 SecurityPage.enterTrackingNumber(trackingNumber);
});

Then("the tracking details should be displayed correctly", () => {
 SecurityPage.verifyTrackingDetailsDisplay();
});

Given("I am logged out", () => {
 SecurityPage.logOut();
});

When("I attempt to access tracking details", () => {
 SecurityPage.attemptAccessTrackingDetails();
});

Then("the system should prompt for login and deny access with the message {string}", (message) => {
 SecurityPage.verifyAccessDeniedMessage(message);
});

When("I log in as an unauthorized user with User ID {string}", (userId) => {
 SecurityPage.logInAsUnauthorizedUser(userId);
});

Then("I should be logged in as an unauthorized user", () => {
 SecurityPage.verifyUnauthorizedUserLogin();
});

Then("access should be denied with an appropriate error message", () => {
 SecurityPage.verifyUnauthorizedAccessErrorMessage();
});

Given("there are unauthorized access attempts", () => {
 SecurityPage.logUnauthorizedAccessAttempts();
});

When("I check the system logs", () => {
 SecurityPage.checkSystemLogs();
});

Then("unauthorized access attempts should be recorded", () => {
 SecurityPage.verifyUnauthorizedAttemptsRecorded();
});

Given("I am denied access", () => {
 SecurityPage.denyAccess();
});

When("I seek guidance for gaining access", () => {
 SecurityPage.seekAccessGuidance();
});

Then("the system should suggest contacting support for access issues", () => {
 SecurityPage.verifySupportSuggestion();
});

When("the session times out", () => {
 SecurityPage.simulateSessionTimeout();
});

Then("I should be logged out and must re-authenticate", () => {
 SecurityPage.verifySessionTimeoutLogout();
});

Given("tracking details are being transmitted", () => {
 SecurityPage.transmitTrackingDetails();
});

When("I check the transmission security", () => {
 SecurityPage.checkTransmissionSecurity();
});

Then("tracking details should be securely transmitted", () => {
 SecurityPage.verifySecureTransmission();
});

Given("I am accessing tracking details", () => {
 SecurityPage.accessTrackingDetails();
});

When("I log in", () => {
 SecurityPage.logIn();
});

Then("multi-factor authentication should be required for access", () => {
 SecurityPage.verifyMultiFactorAuthentication();
});

Given("I have incorrect login credentials", () => {
 SecurityPage.useIncorrectCredentials();
});

Then("access should be denied with an error message for incorrect credentials", () => {
 SecurityPage.verifyIncorrectCredentialsErrorMessage();
});

Then("only users with appropriate roles should be able to access tracking details", () => {
 SecurityPage.verifyRoleBasedAccess();
});

Given("there are repeated unauthorized access attempts", () => {
 SecurityPage.logRepeatedUnauthorizedAttempts();
});

When("I check for system alerts", () => {
 SecurityPage.checkSystemAlerts();
});

Then("system alerts should be triggered for repeated unauthorized attempts", () => {
 SecurityPage.verifySystemAlertsTriggered();
});

Given("a user needs access revoked", () => {
 SecurityPage.identifyUserForAccessRevocation();
});

When("the system administrator revokes access", () => {
 SecurityPage.revokeUserAccess();
});

Then("access should be revoked by the system administrator", () => {
 SecurityPage.verifyAccessRevocation();
});