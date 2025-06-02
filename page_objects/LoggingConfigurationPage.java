package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoggingConfigurationPage extends WebReusableComponents {

    protected By loggingConfigPage = By.id("loggingConfigPage");
    protected By trackingQueriesSetting = By.id("trackingQueriesSetting");
    protected By productSearchQuery = By.id("productSearchQuery");
    protected By systemLogs = By.id("systemLogs");
    protected By logEntry = By.id("logEntry");
    protected By userID = By.id("userID");
    protected By queryTypeInfo = By.id("queryTypeInfo");
    protected By errorMessages = By.id("errorMessages");
    protected By storageLocation = By.id("storageLocation");
    protected By exportButton = By.id("exportButton");
    protected By retentionPeriod = By.id("retentionPeriod");
    protected By accessibility = By.id("accessibility");

    public LoggingConfigurationPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAccessToLoggingConfiguration() {
        Assert.assertTrue(isElementPresent(loggingConfigPage), "Access to logging configuration is not available.");
    }

    public void navigateToLoggingConfigurationPage() {
        clickElement(loggingConfigPage);
    }

    public void verifyLoggingConfigurationPageDisplayed() {
        Assert.assertTrue(isElementVisible(loggingConfigPage), "Logging configuration page is not displayed.");
    }

    public void verifyOnLoggingConfigurationPage() {
        Assert.assertTrue(isElementVisible(loggingConfigPage), "Not on logging configuration page.");
    }

    public void checkTrackingQueriesSetting() {
        Assert.assertTrue(isElementVisible(trackingQueriesSetting), "Tracking queries setting is not visible.");
    }

    public void verifyTrackingQueriesEnabled() {
        Assert.assertTrue(isElementSelected(trackingQueriesSetting), "Tracking queries are not enabled.");
    }

    public void verifyAccessToApplication() {
        Assert.assertTrue(isElementPresent(productSearchQuery), "Access to application is not available.");
    }

    public void executeProductSearchQuery() {
        clickElement(productSearchQuery);
    }

    public void verifyProductSearchQueryExecuted() {
        Assert.assertTrue(isElementVisible(logEntry), "Product search query execution failed.");
    }

    public void verifyAccessToSystemLogs() {
        Assert.assertTrue(isElementPresent(systemLogs), "Access to system logs is not available.");
    }

    public void filterLogsByCurrentDate() {
        selectByValue(systemLogs, getCurrentDate());
    }

    public void verifyLogsForCurrentDateDisplayed() {
        Assert.assertTrue(isElementVisible(logEntry), "Logs for current date are not displayed.");
    }

    public void verifySystemLogsForCurrentDate() {
        Assert.assertTrue(isElementVisible(logEntry), "System logs for current date are not available.");
    }

    public void searchLogEntryForProductSearchQuery() {
        enterText(logEntry, "Product Search Query");
    }

    public void verifyLogEntryFound() {
        Assert.assertTrue(isElementVisible(logEntry), "Log entry for product search query is not found.");
    }

    public void verifyLogEntryLocated() {
        Assert.assertTrue(isElementVisible(logEntry), "Log entry is not located.");
    }

    public void checkLogEntryDetails() {
        Assert.assertTrue(isElementVisible(logEntry), "Log entry details are not visible.");
    }

    public void verifyLogEntryDetailsMatch() {
        Assert.assertTrue(getTextFromElement(logEntry).contains("Product Search Query"), "Log entry details do not match.");
    }

    public void verifyLogEntryForProductSearchQuery() {
        Assert.assertTrue(isElementVisible(logEntry), "Log entry for product search query is not available.");
    }

    public void verifyUserIDInLogEntry() {
        Assert.assertTrue(getTextFromElement(userID).equals("ExpectedUserID"), "User ID is not correctly logged.");
    }

    public void checkQueryTypeInformationInLogEntry() {
        Assert.assertTrue(isElementVisible(queryTypeInfo), "Query Type information is not visible.");
    }

    public void verifyQueryTypeInformationPresent() {
        Assert.assertTrue(getTextFromElement(queryTypeInfo).contains("ExpectedQueryType"), "Query Type information is not present.");
    }

    public void examineLogEntryForErrorsOrWarnings() {
        Assert.assertFalse(isElementVisible(errorMessages), "Error messages or warnings are present.");
    }

    public void verifyNoErrorsOrWarningsPresent() {
        Assert.assertFalse(isElementVisible(errorMessages), "Error messages or warnings are present.");
    }

    public void executeAndCheckDifferentQueryTypes() {
        executeProductSearchQuery();
        verifyLogEntryFound();
    }

    public void verifyLogEntriesForAllQueryTypes() {
        Assert.assertTrue(isElementVisible(logEntry), "Log entries for all query types are not correctly recorded.");
    }

    public void checkLogsForUnauthorizedAccessAttempts() {
        Assert.assertFalse(isElementVisible(logEntry), "Unauthorized access attempts are logged.");
    }

    public void verifyNoUnauthorizedAccessAttemptsLogged() {
        Assert.assertFalse(isElementVisible(logEntry), "Unauthorized access attempts are logged.");
    }

    public void checkLogEntriesStorageLocation() {
        Assert.assertTrue(isElementVisible(storageLocation), "Log entries storage location is not visible.");
    }

    public void verifyLogEntriesStoredSecurely() {
        Assert.assertTrue(getTextFromElement(storageLocation).contains("SecureLocation"), "Log entries are not stored securely.");
    }

    public void attemptToExportLogEntries() {
        clickElement(exportButton);
    }

    public void verifyLogEntriesExportable() {
        Assert.assertTrue(isElementVisible(exportButton), "Log entries are not exportable.");
    }

    public void checkSystemLogsRetentionPeriod() {
        Assert.assertTrue(isElementVisible(retentionPeriod), "Retention period is not visible.");
    }

    public void verifySystemLogsRetentionPeriod() {
        Assert.assertTrue(getTextFromElement(retentionPeriod).contains("ExpectedRetentionPeriod"), "System logs are not retained as per the configured period.");
    }

    public void checkLogEntriesAccessibility() {
        Assert.assertTrue(isElementVisible(accessibility), "Log entries accessibility is not visible.");
    }

    public void verifyLogEntriesAccessibility() {
        Assert.assertTrue(getTextFromElement(accessibility).contains("AuthorizedUsers"), "Log entries are not accessible only to authorized users.");
    }
}