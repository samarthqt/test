import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SessionPage from "../pages/sessionPage";

Given("a user is logged into their account", () => {
 SessionPage.login();
});

When("the user remains inactive for a specified period", () => {
 SessionPage.simulateInactivity();
});

Then("the user should be automatically logged out", () => {
 SessionPage.verifyAutoLogout();
});

Given("a user is logged into their account", () => {
 SessionPage.login();
});

And("the user is inactive", () => {
 SessionPage.simulateInactivity();
});

When("the session is about to timeout", () => {
 SessionPage.checkSessionTimeoutWarning();
});

Then("the user should receive a warning notification", () => {
 SessionPage.verifyWarningNotification();
});

Given("a user is logged into their account", () => {
 SessionPage.login();
});

When("the user performs any activity within the session", () => {
 SessionPage.performActivity();
});

Then("the session timeout should be reset", () => {
 SessionPage.verifyTimeoutReset();
});

Given("a user is logged into their account", () => {
 SessionPage.login();
});

And("the user is inactive for a specified period", () => {
 SessionPage.simulateInactivity();
});

When("the session times out", () => {
 SessionPage.verifySessionTimeout();
});

Then("the user should be redirected to the login page", () => {
 cy.url().should("include", "/login");
});

Given("a system administrator accesses the session settings", () => {
 SessionPage.accessSessionSettings();
});

When("the administrator adjusts the session timeout duration", () => {
 SessionPage.adjustTimeoutDuration();
});

Then("the new session timeout duration should be applied to all user accounts", () => {
 SessionPage.verifyTimeoutDurationApplied();
});

Given("a user is logged into their account on multiple devices", () => {
 SessionPage.loginMultipleDevices();
});

And("the user is inactive on one device", () => {
 SessionPage.simulateInactivityOnOneDevice();
});

When("the session times out on that device", () => {
 SessionPage.verifySessionTimeoutOnDevice();
});

Then("the user should remain logged in on the other devices", () => {
 SessionPage.verifyUserLoggedInOnOtherDevices();
});