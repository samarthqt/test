package com.cucumber.steps;

import com.page_objects.LoggingConfigurationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoggingConfigurationSteps extends LoggingConfigurationPage {

    @Given("I have access to the system's logging configuration")
    public void iHaveAccessToTheSystemsLoggingConfiguration() {
        verifyAccessToLoggingConfiguration();
    }

    @When("I navigate to the system's logging configuration page")
    public void iNavigateToTheSystemsLoggingConfigurationPage() {
        navigateToLoggingConfigurationPage();
    }

    @Then("the logging configuration page is displayed")
    public void theLoggingConfigurationPageIsDisplayed() {
        verifyLoggingConfigurationPageDisplayed();
    }

    @Given("I am on the logging configuration page")
    public void iAmOnTheLoggingConfigurationPage() {
        verifyOnLoggingConfigurationPage();
    }

    @When("I check the tracking queries setting")
    public void iCheckTheTrackingQueriesSetting() {
        checkTrackingQueriesSetting();
    }

    @Then("tracking queries are confirmed to be enabled")
    public void trackingQueriesAreConfirmedToBeEnabled() {
        verifyTrackingQueriesEnabled();
    }

    @Given("I have access to the application")
    public void iHaveAccessToTheApplication() {
        verifyAccessToApplication();
    }

    @When("I execute a product search query")
    public void iExecuteAProductSearchQuery() {
        executeProductSearchQuery();
    }

    @Then("the product search query is executed successfully")
    public void theProductSearchQueryIsExecutedSuccessfully() {
        verifyProductSearchQueryExecuted();
    }

    @Given("I have access to the system logs")
    public void iHaveAccessToTheSystemLogs() {
        verifyAccessToSystemLogs();
    }

    @When("I filter the logs by the current date")
    public void iFilterTheLogsByTheCurrentDate() {
        filterLogsByCurrentDate();
    }

    @Then("system logs for the current date are displayed")
    public void systemLogsForTheCurrentDateAreDisplayed() {
        verifyLogsForCurrentDateDisplayed();
    }

    @Given("I have the system logs for the current date")
    public void iHaveTheSystemLogsForTheCurrentDate() {
        verifySystemLogsForCurrentDate();
    }

    @When("I search for the log entry of the executed product search query")
    public void iSearchForTheLogEntryOfTheExecutedProductSearchQuery() {
        searchLogEntryForProductSearchQuery();
    }

    @Then("the log entry for the product search query is found")
    public void theLogEntryForTheProductSearchQueryIsFound() {
        verifyLogEntryFound();
    }

    @Given("I have located the log entry for the product search query")
    public void iHaveLocatedTheLogEntryForTheProductSearchQuery() {
        verifyLogEntryLocated();
    }

    @When("I check the details of the log entry")
    public void iCheckTheDetailsOfTheLogEntry() {
        checkLogEntryDetails();
    }

    @Then("log entry details match the executed query")
    public void logEntryDetailsMatchTheExecutedQuery() {
        verifyLogEntryDetailsMatch();
    }

    @Given("I have the log entry for the product search query")
    public void iHaveTheLogEntryForTheProductSearchQuery() {
        verifyLogEntryForProductSearchQuery();
    }

    @When("I verify the User ID in the log entry")
    public void iVerifyTheUserIDInTheLogEntry() {
        verifyUserIDInLogEntry();
    }

    @Then("User ID is correctly logged in the system")
    public void userIDIsCorrectlyLoggedInTheSystem() {
        verifyUserIDLoggedCorrectly();
    }

    @When("I check the Query Type information in the log entry")
    public void iCheckTheQueryTypeInformationInTheLogEntry() {
        checkQueryTypeInformationInLogEntry();
    }

    @Then("Query Type information is present in the log entry")
    public void queryTypeInformationIsPresentInTheLogEntry() {
        verifyQueryTypeInformationPresent();
    }

    @When("I examine the log entry for any error messages or warnings")
    public void iExamineTheLogEntryForAnyErrorMessagesOrWarnings() {
        examineLogEntryForErrorsOrWarnings();
    }

    @Then("no error messages or warnings are present")
    public void noErrorMessagesOrWarningsArePresent() {
        verifyNoErrorsOrWarningsPresent();
    }

    @When("I execute different types of queries and check their log entries")
    public void iExecuteDifferentTypesOfQueriesAndCheckTheirLogEntries() {
        executeAndCheckDifferentQueryTypes();
    }

    @Then("log entries are correctly recorded for all query types")
    public void logEntriesAreCorrectlyRecordedForAllQueryTypes() {
        verifyLogEntriesForAllQueryTypes();
    }

    @When("I check the logs for any unauthorized access attempts")
    public void iCheckTheLogsForAnyUnauthorizedAccessAttempts() {
        checkLogsForUnauthorizedAccessAttempts();
    }

    @Then("no unauthorized access attempts are logged")
    public void noUnauthorizedAccessAttemptsAreLogged() {
        verifyNoUnauthorizedAccessAttemptsLogged();
    }

    @When("I check the storage location of log entries")
    public void iCheckTheStorageLocationOfLogEntries() {
        checkLogEntriesStorageLocation();
    }

    @Then("log entries are stored securely")
    public void logEntriesAreStoredSecurely() {
        verifyLogEntriesStoredSecurely();
    }

    @When("I attempt to export log entries for audit purposes")
    public void iAttemptToExportLogEntriesForAuditPurposes() {
        attemptToExportLogEntries();
    }

    @Then("log entries are exportable for audits")
    public void logEntriesAreExportableForAudits() {
        verifyLogEntriesExportable();
    }

    @When("I check the retention period of system logs")
    public void iCheckTheRetentionPeriodOfSystemLogs() {
        checkSystemLogsRetentionPeriod();
    }

    @Then("system logs are retained as per the configured period")
    public void systemLogsAreRetainedAsPerTheConfiguredPeriod() {
        verifySystemLogsRetentionPeriod();
    }

    @When("I check accessibility of log entries")
    public void iCheckAccessibilityOfLogEntries() {
        checkLogEntriesAccessibility();
    }

    @Then("log entries are accessible only to authorized users")
    public void logEntriesAreAccessibleOnlyToAuthorizedUsers() {
        verifyLogEntriesAccessibility();
    }
}