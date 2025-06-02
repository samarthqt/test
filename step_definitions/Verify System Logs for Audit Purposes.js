import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SystemLogsPage from "../pages/systemLogsPage";

Given("the admin is logged in with User ID {string}", (userID) => {
 SystemLogsPage.loginAsAdmin(userID);
});

When("the admin navigates to the system logs section", () => {
 SystemLogsPage.navigateToSystemLogs();
});

Then("the system logs page should be displayed", () => {
 SystemLogsPage.verifySystemLogsPage();
});

Given("the admin is on the system logs page", () => {
 SystemLogsPage.verifySystemLogsPage();
});

When("the admin performs a password update", () => {
 SystemLogsPage.performPasswordUpdate();
});

Then("the user action should be completed successfully", () => {
 SystemLogsPage.verifyPasswordUpdateSuccess();
});

Then("the system logs should be updated with the latest entry", () => {
 SystemLogsPage.verifyLatestLogEntry();
});

Given("the system logs are updated", () => {
 SystemLogsPage.verifyLogsUpdated();
});

When("the admin refreshes the system logs page", () => {
 SystemLogsPage.refreshSystemLogsPage();
});

Then("the log entry should include user ID, action type, and timestamp", () => {
 SystemLogsPage.verifyLogEntryDetails();
});

Then("all log entries should be accurate and complete", () => {
 SystemLogsPage.verifyLogEntriesAccuracy();
});

Given("a non-admin account attempts to access system logs", () => {
 SystemLogsPage.attemptAccessAsNonAdmin();
});

Then("the non-admin account should be denied access to system logs", () => {
 SystemLogsPage.verifyAccessDenied();
});

Then("logs should be retained according to policy guidelines", () => {
 SystemLogsPage.verifyLogRetentionPolicy();
});

Then("log data should be secured against unauthorized access", () => {
 SystemLogsPage.verifyLogDataSecurity();
});

Then("timestamps should reflect the exact time of user actions", () => {
 SystemLogsPage.verifyTimestampsAccuracy();
});

Given("the admin performs multiple user actions", () => {
 SystemLogsPage.performMultipleUserActions();
});

Then("each action should generate a separate log entry", () => {
 SystemLogsPage.verifySeparateLogEntries();
});

Then("no duplicate entries should be present in the logs", () => {
 SystemLogsPage.verifyNoDuplicateEntries();
});

Then("logs should be exportable for audit purposes", () => {
 SystemLogsPage.verifyLogExportFunctionality();
});

Then("logs should be searchable and filterable by user ID", () => {
 SystemLogsPage.verifySearchableLogs();
});

Then("all log entries should be consistently formatted", () => {
 SystemLogsPage.verifyLogEntryFormatting();
});