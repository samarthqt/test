package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerificationLoggingSteps extends LoggingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("system logging is enabled")
    public void systemLoggingIsEnabled() {
        enableLogging();
    }

    @When("a verification attempt is initiated by entering the code")
    public void aVerificationAttemptIsInitiatedByEnteringTheCode() {
        enterVerificationCode(testHarness.getData("VerificationData", "Code"));
    }

    @Then("the system logs the attempt with a timestamp and user ID")
    public void theSystemLogsTheAttemptWithATimestampAndUserID() {
        verifyLogEntryWithTimestampAndUserID();
    }

    @When("an incorrect code is entered and retried")
    public void anIncorrectCodeIsEnteredAndRetried() {
        enterIncorrectCode(testHarness.getData("VerificationData", "IncorrectCode"));
        retryVerification();
    }

    @Then("the system logs each attempt separately")
    public void theSystemLogsEachAttemptSeparately() {
        verifySeparateLogEntriesForAttempts();
    }

    @When("a verification attempt is initiated")
    public void aVerificationAttemptIsInitiated() {
        initiateVerificationAttempt();
    }

    @Then("the log entry includes IP address and device information")
    public void theLogEntryIncludesIPAddressAndDeviceInformation() {
        verifyLogEntryContainsIPAndDeviceInfo();
    }

    @When("verification attempts are made")
    public void verificationAttemptsAreMade() {
        makeVerificationAttempts();
    }

    @Then("both successful and failed attempts are logged")
    public void bothSuccessfulAndFailedAttemptsAreLogged() {
        verifyLogEntriesForSuccessAndFailure();
    }

    @When("a verification code expires")
    public void aVerificationCodeExpires() {
        expireVerificationCode();
    }

    @Then("the code expiration is logged with a timestamp")
    public void theCodeExpirationIsLoggedWithATimestamp() {
        verifyLogEntryForCodeExpiration();
    }

    @When("verification attempts are made from different locations")
    public void verificationAttemptsAreMadeFromDifferentLocations() {
        makeVerificationAttemptsFromDifferentLocations();
    }

    @Then("log entries show location details for each attempt")
    public void logEntriesShowLocationDetailsForEachAttempt() {
        verifyLogEntriesContainLocationDetails();
    }

    @When("multiple verification attempts are made within a short time frame")
    public void multipleVerificationAttemptsAreMadeWithinAShortTimeFrame() {
        makeMultipleVerificationAttemptsQuickly();
    }

    @Then("each attempt is logged with precise timestamps")
    public void eachAttemptIsLoggedWithPreciseTimestamps() {
        verifyLogEntriesWithPreciseTimestamps();
    }

    @When("verification attempts are made using different methods")
    public void verificationAttemptsAreMadeUsingDifferentMethods() {
        makeVerificationAttemptsUsingDifferentMethods();
    }

    @Then("log entries indicate the method used for each attempt")
    public void logEntriesIndicateTheMethodUsedForEachAttempt() {
        verifyLogEntriesIndicateVerificationMethod();
    }

    @When("verification attempts are made during peak activity periods")
    public void verificationAttemptsAreMadeDuringPeakActivityPeriods() {
        makeVerificationAttemptsDuringPeakActivity();
    }

    @Then("logs are maintained accurately without loss of data")
    public void logsAreMaintainedAccuratelyWithoutLossOfData() {
        verifyLogIntegrityDuringPeakActivity();
    }

    @When("logs are filtered by user ID")
    public void logsAreFilteredByUserID() {
        filterLogsByUserID(testHarness.getData("UserData", "UserID"));
    }

    @Then("logs display attempts for a specific user ID")
    public void logsDisplayAttemptsForASpecificUserID() {
        verifyFilteredLogsDisplayCorrectUserID();
    }

    @When("logs are exported for audit purposes")
    public void logsAreExportedForAuditPurposes() {
        exportLogsForAudit();
    }

    @Then("logs can be exported in a readable format for audits")
    public void logsCanBeExportedInAReadableFormatForAudits() {
        verifyLogsExportedInReadableFormat();
    }

    @When("log entries contain incorrect data")
    public void logEntriesContainIncorrectData() {
        createIncorrectLogEntries();
    }

    @Then("the system alerts for incorrect log data without affecting the logging process")
    public void theSystemAlertsForIncorrectLogDataWithoutAffectingTheLoggingProcess() {
        verifySystemAlertsForIncorrectLogData();
    }

    @When("old log entries are archived")
    public void oldLogEntriesAreArchived() {
        archiveOldLogEntries();
    }

    @Then("old log entries are archived without affecting current logging")
    public void oldLogEntriesAreArchivedWithoutAffectingCurrentLogging() {
        verifyArchivingDoesNotAffectCurrentLogging();
    }

    @When("log entry errors occur (e.g., missing data)")
    public void logEntryErrorsOccur() {
        simulateLogEntryErrors();
    }

    @Then("the system alerts for errors and maintains log integrity")
    public void theSystemAlertsForErrorsAndMaintainsLogIntegrity() {
        verifySystemAlertsForLogEntryErrors();
    }

    @When("simultaneous verification attempts are made from multiple users")
    public void simultaneousVerificationAttemptsAreMadeFromMultipleUsers() {
        makeSimultaneousVerificationAttempts();
    }

    @Then("each user's attempt is logged separately and accurately")
    public void eachUsersAttemptIsLoggedSeparatelyAndAccurately() {
        verifySeparateLogEntriesForMultipleUsers();
    }
}