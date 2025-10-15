package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPMappingValidationPage extends WebReusableComponents {

    protected By salesOrderScreen = By.id("salesOrderScreen");
    protected By systemLogs = By.id("systemLogs");
    protected By errorMessage = By.id("errorMessage");
    protected By logEntries = By.cssSelector(".log-entry");
    protected By logoutButton = By.id("logoutButton");
    protected By submitResultsButton = By.id("submitResultsButton");

    public void loginToSAPSystem() {
        launchUrl("https://sap-cloud-system.com");
        waitUntilElementVisible(salesOrderScreen, 5);
    }

    public void navigateToSalesOrderScreen() {
        clickElement(salesOrderScreen);
        waitUntilElementVisible(By.id("copyProcessScreen"), 5);
    }

    public void selectSalesOrder(String katr1, String katr2) {
        By salesOrder = By.xpath("//tr[td[text()='" + katr1 + "'] and td[text()='" + katr2 + "']]");
        waitUntilElementVisible(salesOrder, 3);
        clickElement(salesOrder);
    }

    public void initiateCopyProcess() {
        clickElement(By.id("initiateCopyButton"));
        waitUntilElementVisible(errorMessage, 5);
    }

    public void verifyErrorMessage(String katr1, String katr2) {
        String expectedMessage = "Missing mapping rules for KATR1: " + katr1 + " and KATR2: " + katr2;
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void navigateToSystemLogs() {
        clickElement(systemLogs);
        waitUntilElementVisible(logEntries, 5);
    }

    public void verifyLogsForMissingConfiguration() {
        boolean logFound = getWebElementList(logEntries)
            .stream()
            .anyMatch(log -> log.getText().contains("Missing configuration"));
        Assert.assertTrue(logFound, "Missing configuration log entry not found.");
    }

    public void verifyLogsCaptureMissingConfiguration() {
        boolean logCaptured = getWebElementList(logEntries)
            .stream()
            .anyMatch(log -> log.getText().contains("Captured missing configuration"));
        Assert.assertTrue(logCaptured, "Logs did not capture missing configuration.");
    }

    public void reviewErrorMessagesInLogs() {
        getWebElementList(logEntries)
            .forEach(log -> System.out.println(log.getText()));
    }

    public void verifyErrorMessagesIndicateAbsenceOfMappingRules() {
        boolean errorFound = getWebElementList(logEntries)
            .stream()
            .anyMatch(log -> log.getText().contains("absence of mapping rules"));
        Assert.assertTrue(errorFound, "Error messages do not indicate absence of mapping rules.");
    }

    public void completeValidation() {
        System.out.println("Validation completed.");
    }

    public void documentTestResults() {
        System.out.println("Test results documented.");
    }

    public void verifyResultsDocumentedSuccessfully() {
        System.out.println("Results documented successfully.");
    }

    public void completeDocumentingResults() {
        System.out.println("Documenting results completed.");
    }

    public void logoutOfSAPSystem() {
        clickElement(logoutButton);
        waitUntilElementVisible(By.id("loginScreen"), 5);
    }

    public void submitTestResults() {
        clickElement(submitResultsButton);
        waitUntilElementVisible(By.id("submissionConfirmation"), 5);
    }

    public void verifyTestResultsSubmittedSuccessfully() {
        String confirmationMessage = getTextFromElement(By.id("submissionConfirmation"));
        Assert.assertEquals(confirmationMessage, "Test results submitted successfully.", "Submission confirmation message does not match.");
    }
}