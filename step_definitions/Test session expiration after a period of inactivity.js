import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SessionPage from "../pages/sessionPage";

Given("User is logged into the system using valid credentials", () => {
 SessionPage.login();
});

When("User navigates to the dashboard and performs no action", () => {
 SessionPage.goToDashboard();
});

Then("Dashboard is displayed without any interaction", () => {
 SessionPage.verifyDashboardDisplayed();
});

Given("User remains inactive for 30 minutes", () => {
 SessionPage.waitForInactivity(30);
});

When("User attempts to perform an action after 30 minutes", () => {
 SessionPage.performActionAfterInactivity();
});

Then("User session expires and is redirected to the login page", () => {
 SessionPage.verifySessionExpired();
});

Then("Notification is displayed indicating session expiration", () => {
 SessionPage.verifySessionExpirationNotification();
});

Given("User session has expired", () => {
 SessionPage.mockSessionExpired();
});

When("User attempts to log in again", () => {
 SessionPage.relogin();
});

Then("User successfully logs in again", () => {
 SessionPage.verifyLoginSuccess();
});

Given("Session timeout configuration is accessible", () => {
 SessionPage.accessTimeoutConfiguration();
});

Then("Session timeout is correctly set to 30 minutes", () => {
 SessionPage.verifyTimeoutSetting(30);
});

Given("System logs are accessible", () => {
 SessionPage.accessSystemLogs();
});

Then("Logs contain entries for session expiration at the 30-minute mark", () => {
 SessionPage.verifyLogEntriesForExpiration(30);
});

Given("Session timeout configuration is set to 15 minutes", () => {
 SessionPage.setTimeoutConfiguration(15);
});

When("User remains inactive for 15 minutes", () => {
 SessionPage.waitForInactivity(15);
});

Then("User session expires after 15 minutes of inactivity", () => {
 SessionPage.verifySessionExpired();
});

When("User attempts to access a restricted page", () => {
 SessionPage.accessRestrictedPage();
});

Then("Access is denied and redirected to the login page", () => {
 SessionPage.verifyAccessDenied();
});

Given("Different browsers are used to access the system", () => {
 SessionPage.useDifferentBrowsers();
});

Then("Session expiration behaves consistently across different browsers", () => {
 SessionPage.verifyConsistentBehaviorAcrossBrowsers();
});

Given("User session expires", () => {
 SessionPage.mockSessionExpired();
});

Then("No error messages are displayed during session expiration", () => {
 SessionPage.verifyNoErrorMessages();
});

Given("Multiple user accounts are logged in simultaneously", () => {
 SessionPage.loginMultipleUsers();
});

When("Users remain inactive for the specified inactivity period", () => {
 SessionPage.waitForInactivity(SessionPage.getConfiguredTimeout());
});

Then("All sessions expire correctly after the inactivity period", () => {
 SessionPage.verifyAllSessionsExpired();
});

Given("Mobile devices are used to access the system", () => {
 SessionPage.useMobileDevices();
});

Then("Session expiration behaves consistently on mobile devices", () => {
 SessionPage.verifyConsistentBehaviorOnMobileDevices();
});

Given("Session expiration occurs", () => {
 SessionPage.mockSessionExpired();
});

Then("Session expiration does not expose any security vulnerabilities", () => {
 SessionPage.verifyNoSecurityVulnerabilities();
});