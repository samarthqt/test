package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SystemLogsPage;

public class SystemLogsSteps extends SystemLogsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin is logged in with User ID {string}")
    public void theAdminIsLoggedInWithUserID(String userID) {
        loginAsAdmin(userID);
    }

    @When("the admin navigates to the system logs section")
    public void theAdminNavigatesToTheSystemLogsSection() {
        navigateToSystemLogs();
    }

    @Then("the system logs page should be displayed")
    public void theSystemLogsPageShouldBeDisplayed() {
        verifySystemLogsPageDisplayed();
    }

    @Given("the admin is on the system logs page")
    public void theAdminIsOnTheSystemLogsPage() {
        verifySystemLogsPageDisplayed();
    }

    @When("the admin performs a password update")
    public void theAdminPerformsAPasswordUpdate() {
        performPasswordUpdate();
    }

    @Then("the user action should be completed successfully")
    public void theUserActionShouldBeCompletedSuccessfully() {
        verifyPasswordUpdateSuccess();
    }

    @Then("the system logs should be updated with the latest entry")
    public void theSystemLogsShouldBeUpdatedWithTheLatestEntry() {
        verifyLogEntryUpdated();
    }

    @Given("the system logs are updated")
    public void theSystemLogsAreUpdated() {
        verifyLogEntryUpdated();
    }

    @When("the admin refreshes the system logs page")
    public void theAdminRefreshesTheSystemLogsPage() {
        refreshSystemLogsPage();
    }

    @Then("the log entry should include user ID, action type, and timestamp")
    public void theLogEntryShouldIncludeUserIDActionTypeAndTimestamp() {
        verifyLogEntryDetails();
    }

    @Then("all log entries should be accurate and complete")
    public void allLogEntriesShouldBeAccurateAndComplete() {
        verifyLogEntriesAccuracy();
    }

    @Given("a non-admin account attempts to access system logs")
    public void aNonAdminAccountAttemptsToAccessSystemLogs() {
        attemptNonAdminAccess();
    }

    @Then("the non-admin account should be denied access to system logs")
    public void theNonAdminAccountShouldBeDeniedAccessToSystemLogs() {
        verifyNonAdminAccessDenied();
    }

    @Then("logs should be retained according to policy guidelines")
    public void logsShouldBeRetainedAccordingToPolicyGuidelines() {
        verifyLogRetentionPolicy();
    }

    @Then("log data should be secured against unauthorized access")
    public void logDataShouldBeSecuredAgainstUnauthorizedAccess() {
        verifyLogDataSecurity();
    }

    @Then("timestamps should reflect the exact time of user actions")
    public void timestampsShouldReflectTheExactTimeOfUserActions() {
        verifyTimestampsAccuracy();
    }

    @Given("the admin performs multiple user actions")
    public void theAdminPerformsMultipleUserActions() {
        performMultipleUserActions();
    }

    @Then("each action should generate a separate log entry")
    public void eachActionShouldGenerateASeparateLogEntry() {
        verifySeparateLogEntries();
    }

    @Then("no duplicate entries should be present in the logs")
    public void noDuplicateEntriesShouldBePresentInTheLogs() {
        verifyNoDuplicateEntries();
    }

    @Then("logs should be exportable for audit purposes")
    public void logsShouldBeExportableForAuditPurposes() {
        verifyLogExportFunctionality();
    }

    @Then("logs should be searchable and filterable by user ID")
    public void logsShouldBeSearchableAndFilterableByUserID() {
        verifyLogSearchabilityByUserID();
    }

    @Then("all log entries should be consistently formatted")
    public void allLogEntriesShouldBeConsistentlyFormatted() {
        verifyLogEntryFormattingConsistency();
    }
}