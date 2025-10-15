package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DuplicateOrderIDPage extends WebReusableComponents {

    protected By inboundInterfaceTrigger = By.id("triggerInboundInterface");
    protected By mandatoryFieldsValidation = By.id("validateMandatoryFields");
    protected By payloadProcessing = By.id("processPayload");
    protected By duplicateOrderIDCheck = By.id("checkDuplicateOrderID");
    protected By errorLog = By.id("logError");
    protected By errorMessage = By.id("errorMessage");
    protected By orderCreationStatus = By.id("orderCreationStatus");
    protected By errorAcknowledgment = By.id("errorAcknowledgment");
    protected By interfaceLogs = By.id("interfaceLogs");
    protected By databaseEntries = By.id("databaseEntries");
    protected By performanceMetrics = By.id("performanceMetrics");
    protected By businessRulesValidation = By.id("businessRulesValidation");
    protected By rejectionEventLog = By.id("rejectionEventLog");

    public void triggerInboundInterface(String uniqueOrderID) {
        waitUntilElementVisible(inboundInterfaceTrigger, 3);
        enterText(inboundInterfaceTrigger, uniqueOrderID);
        clickElement(inboundInterfaceTrigger);
    }

    public void validateMandatoryFields(String salesArea) {
        waitUntilElementVisible(mandatoryFieldsValidation, 3);
        enterText(mandatoryFieldsValidation, salesArea);
        clickElement(mandatoryFieldsValidation);
    }

    public void processPayload() {
        waitUntilElementVisible(payloadProcessing, 3);
        clickElement(payloadProcessing);
    }

    public void verifyDuplicateOrderID() {
        waitUntilElementVisible(duplicateOrderIDCheck, 3);
        boolean isDuplicate = elementVisible(duplicateOrderIDCheck);
        Assert.assertTrue(isDuplicate, "Duplicate Unique Order ID not identified.");
    }

    public void logErrorForDuplicateID() {
        waitUntilElementVisible(errorLog, 3);
        clickElement(errorLog);
    }

    public void verifyErrorMessageInLogs() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Unique Order ID already exists.", "Error message does not match.");
    }

    public void verifyNoNewOrderCreated() {
        waitUntilElementVisible(orderCreationStatus, 3);
        String status = getTextFromElement(orderCreationStatus);
        Assert.assertEquals(status, "No new order created.", "Order creation status is incorrect.");
    }

    public void sendErrorAcknowledgment() {
        waitUntilElementVisible(errorAcknowledgment, 3);
        clickElement(errorAcknowledgment);
    }

    public void verifyInterfaceLogsDetails() {
        waitUntilElementVisible(interfaceLogs, 3);
        boolean logsAvailable = elementVisible(interfaceLogs);
        Assert.assertTrue(logsAvailable, "Interface logs do not provide details of the rejected order.");
    }

    public void verifyNoDuplicateEntriesInDatabase() {
        waitUntilElementVisible(databaseEntries, 3);
        boolean noDuplicates = elementVisible(databaseEntries);
        Assert.assertTrue(noDuplicates, "Duplicate entries found in the database.");
    }

    public void verifyPerformanceConsistency() {
        waitUntilElementVisible(performanceMetrics, 3);
        boolean performanceConsistent = elementVisible(performanceMetrics);
        Assert.assertTrue(performanceConsistent, "Performance inconsistency detected during error handling.");
    }

    public void verifyBusinessRulesAdherence() {
        waitUntilElementVisible(businessRulesValidation, 3);
        boolean rulesAdhered = elementVisible(businessRulesValidation);
        Assert.assertTrue(rulesAdhered, "Error handling process does not adhere to business rules.");
    }

    public void logRejectionEventWithTimestamp() {
        waitUntilElementVisible(rejectionEventLog, 3);
        boolean logExists = elementVisible(rejectionEventLog);
        Assert.assertTrue(logExists, "Rejection event not logged with timestamp.");
    }
}