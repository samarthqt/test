import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import VerificationPage from '../../pageObjects/VerificationPage';

const verificationPage = new VerificationPage();

Given('system logging is enabled', () => {
  cy.enableSystemLogging();
});

When('a verification attempt is initiated by entering the code', () => {
  verificationPage.enterVerificationCode();
});

Then('the system logs the attempt with a timestamp and user ID', () => {
  cy.verifyLogEntryContainsTimestampAndUserID();
});

When('an incorrect code is entered and retried', () => {
  verificationPage.enterIncorrectCodeAndRetry();
});

Then('the system logs each attempt separately', () => {
  cy.verifySeparateLogEntriesForAttempts();
});

When('a verification attempt is initiated', () => {
  verificationPage.initiateVerificationAttempt();
});

Then('the log entry includes IP address and device information', () => {
  cy.verifyLogEntryContainsIPAndDeviceInfo();
});

When('verification attempts are made', () => {
  verificationPage.makeVerificationAttempts();
});

Then('both successful and failed attempts are logged', () => {
  cy.verifySuccessfulAndFailedAttemptsLogged();
});

When('a verification code expires', () => {
  verificationPage.expireVerificationCode();
});

Then('the code expiration is logged with a timestamp', () => {
  cy.verifyCodeExpirationLoggedWithTimestamp();
});

When('verification attempts are made from different locations', () => {
  verificationPage.makeAttemptsFromDifferentLocations();
});

Then('log entries show location details for each attempt', () => {
  cy.verifyLogEntriesShowLocationDetails();
});

When('multiple verification attempts are made within a short time frame', () => {
  verificationPage.makeMultipleAttemptsInShortTimeFrame();
});

Then('each attempt is logged with precise timestamps', () => {
  cy.verifyAttemptsLoggedWithPreciseTimestamps();
});

When('verification attempts are made using different methods', () => {
  verificationPage.makeAttemptsUsingDifferentMethods();
});

Then('log entries indicate the method used for each attempt', () => {
  cy.verifyLogEntriesIndicateMethodUsed();
});

When('verification attempts are made during peak activity periods', () => {
  verificationPage.makeAttemptsDuringPeakActivity();
});

Then('logs are maintained accurately without loss of data', () => {
  cy.verifyLogsMaintainedAccurately();
});

When('logs are filtered by user ID', () => {
  verificationPage.filterLogsByUserID();
});

Then('logs display attempts for a specific user ID', () => {
  cy.verifyLogsDisplayAttemptsForUserID();
});

When('logs are exported for audit purposes', () => {
  verificationPage.exportLogsForAudit();
});

Then('logs can be exported in a readable format for audits', () => {
  cy.verifyLogsExportedInReadableFormat();
});

When('log entries contain incorrect data', () => {
  verificationPage.handleIncorrectLogData();
});

Then('the system alerts for incorrect log data without affecting the logging process', () => {
  cy.verifySystemAlertsForIncorrectData();
});

When('old log entries are archived', () => {
  verificationPage.archiveOldLogEntries();
});

Then('old log entries are archived without affecting current logging', () => {
  cy.verifyOldLogEntriesArchived();
});

When('log entry errors occur (e.g., missing data)', () => {
  verificationPage.handleLogEntryErrors();
});

Then('the system alerts for errors and maintains log integrity', () => {
  cy.verifySystemAlertsForLogErrors();
});

When('simultaneous verification attempts are made from multiple users', () => {
  verificationPage.makeSimultaneousAttemptsFromMultipleUsers();
});

Then('each user's attempt is logged separately and accurately', () => {
  cy.verifyEachUserAttemptLoggedSeparately();
});