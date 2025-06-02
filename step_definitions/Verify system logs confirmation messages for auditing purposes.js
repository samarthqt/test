import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SystemLogsPage from "../pages/systemLogsPage";

Given("the system is configured to log confirmation messages", () => {
 SystemLogsPage.verifyLoggingConfiguration();
});

When("the user initiates a transaction with User ID {string}", (userId) => {
 SystemLogsPage.initiateTransaction(userId);
});

Then("the transaction is successfully initiated", () => {
 SystemLogsPage.verifyTransactionInitiation();
});

Given("a transaction has been initiated", () => {
 SystemLogsPage.verifyTransactionInitiation();
});

When("the user completes the transaction with Transaction ID {string}", (transactionId) => {
 SystemLogsPage.completeTransaction(transactionId);
});

Then("a confirmation message is generated", () => {
 SystemLogsPage.verifyConfirmationMessageGenerated();
});

Given("the system's logging module is available", () => {
 SystemLogsPage.verifyLoggingModuleAvailability();
});

When("the user accesses the logging module", () => {
 SystemLogsPage.accessLoggingModule();
});

Then("the logging module is accessible", () => {
 SystemLogsPage.verifyLoggingModuleAccessibility();
});

Given("the logging module is accessible", () => {
 SystemLogsPage.verifyLoggingModuleAccessibility();
});

When("the user searches for the confirmation message using Transaction ID {string}", (transactionId) => {
 SystemLogsPage.searchConfirmationMessage(transactionId);
});

Then("the confirmation message is found in the logs", () => {
 SystemLogsPage.verifyConfirmationMessageInLogs();
});

Given("the confirmation message is found in the logs", () => {
 SystemLogsPage.verifyConfirmationMessageInLogs();
});

When("the user checks the details of the confirmation message", () => {
 SystemLogsPage.checkConfirmationMessageDetails();
});

Then("the details match the transaction details", () => {
 SystemLogsPage.verifyConfirmationMessageDetails();
});

Given("the confirmation message is logged", () => {
 SystemLogsPage.verifyConfirmationMessageLogged();
});

When("the user checks the timestamp of the logged message", () => {
 SystemLogsPage.checkLoggedMessageTimestamp();
});

Then("the timestamp matches the time of transaction completion", () => {
 SystemLogsPage.verifyTimestampMatches();
});

When("the user checks the format of the log entry", () => {
 SystemLogsPage.checkLogEntryFormat();
});

Then("the log entry format is correct and consistent", () => {
 SystemLogsPage.verifyLogEntryFormat();
});

When("authorized personnel attempt to access the log entry", () => {
 SystemLogsPage.attemptAccessByAuthorizedPersonnel();
});

Then("the log entry is accessible", () => {
 SystemLogsPage.verifyLogEntryAccessibility();
});

When("unauthorized personnel attempt to access the log entry", () => {
 SystemLogsPage.attemptAccessByUnauthorizedPersonnel();
});

Then("access is denied due to insufficient permissions", () => {
 SystemLogsPage.verifyAccessDenied();
});

When("the user modifies the confirmation message", () => {
 SystemLogsPage.modifyConfirmationMessage();
});

Then("any modifications are logged", () => {
 SystemLogsPage.verifyModificationsLogged();
});

When("the user deletes the confirmation message log entry", () => {
 SystemLogsPage.deleteConfirmationMessageLogEntry();
});

Then("deletion of the log entry is recorded", () => {
 SystemLogsPage.verifyDeletionRecorded();
});

Given("the system is logging confirmation messages", () => {
 SystemLogsPage.verifyLoggingConfiguration();
});

When("a failure occurs in logging the confirmation message", () => {
 SystemLogsPage.simulateLoggingFailure();
});

Then("the system generates an error and alerts the administrator", () => {
 SystemLogsPage.verifyErrorAndAlert();
});

Given("a logging failure has occurred", () => {
 SystemLogsPage.verifyLoggingFailure();
});

When("the system attempts to recover", () => {
 SystemLogsPage.attemptSystemRecovery();
});

Then("the system recovers and resumes logging without data loss", () => {
 SystemLogsPage.verifyRecoveryAndLogging();
});

When("the user checks the retention policy for log entries", () => {
 SystemLogsPage.checkRetentionPolicy();
});

Then("log entries are retained according to the policy", () => {
 SystemLogsPage.verifyRetentionPolicy();
});

When("the user checks the backup schedule for log entries", () => {
 SystemLogsPage.checkBackupSchedule();
});

Then("log entries are backed up as per the schedule", () => {
 SystemLogsPage.verifyBackupSchedule();
});