package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PlantPartnerPage extends WebReusableComponents {

    protected By uploadFileButton = By.id("uploadFile");
    protected By triggerProcessingButton = By.id("triggerProcessing");
    protected By logsSection = By.id("logs");
    protected By processedDataSection = By.id("processedData");
    protected By databaseSection = By.id("database");

    public void uploadInboundFileWithDetails(String cmoId, String siteId) {
        waitUntilElementVisible(uploadFileButton, 3);
        clickElement(uploadFileButton);
        enterText(By.id("cmoId"), cmoId);
        enterText(By.id("siteId"), siteId);
        clickElement(By.id("submitFile"));
    }

    public void validateFileUpload() {
        Assert.assertTrue(isElementPresent(By.id("uploadSuccess")), "File upload failed.");
    }

    public void triggerInterfaceProcessing() {
        waitUntilElementVisible(triggerProcessingButton, 3);
        clickElement(triggerProcessingButton);
    }

    public void validateInterfaceProcessing() {
        Assert.assertTrue(isElementPresent(By.id("processingSuccess")), "Interface processing failed.");
    }

    public void uploadAndTriggerFileProcessing() {
        uploadInboundFileWithDetails("12345", "98765");
        triggerInterfaceProcessing();
    }

    public void validatePlantDetermination() {
        Assert.assertTrue(isElementPresent(By.id("plantDetermined")), "Plant determination failed.");
    }

    public void validatePartnerResolution() {
        Assert.assertTrue(isElementPresent(By.id("partnerResolved")), "Partner resolution failed.");
    }

    public void validateBillToAndPayerAssignment() {
        Assert.assertTrue(isElementPresent(By.id("billToPayerAssigned")), "Bill To and Payer assignment failed.");
    }

    public void validateThirdPartyPartnerRow() {
        Assert.assertTrue(isElementPresent(By.id("thirdPartyRowAdded")), "3rd party partner row addition failed.");
    }

    public void checkLogsForProcessing() {
        waitUntilElementVisible(logsSection, 3);
    }

    public void validateLogs() {
        Assert.assertFalse(isElementPresent(By.id("errorLog")), "Errors found in logs.");
    }

    public void reviewProcessedDataInSystem() {
        waitUntilElementVisible(processedDataSection, 3);
    }

    public void validateProcessedData() {
        Assert.assertTrue(isElementPresent(By.id("dataMatches")), "Processed data does not match input file.");
    }

    public void checkDatabaseForUpdates() {
        waitUntilElementVisible(databaseSection, 3);
    }

    public void validateDatabaseUpdates() {
        Assert.assertTrue(isElementPresent(By.id("databaseUpdated")), "Database updates are incorrect.");
    }

    public void crossCheckPlantAndPartnerAssignments() {
        waitUntilElementVisible(By.id("assignmentsSection"), 3);
    }

    public void validateAssignmentsCompliance() {
        Assert.assertTrue(isElementPresent(By.id("assignmentsCompliant")), "Assignments do not comply with business rules.");
    }

    public void uploadFileWithRecords(String recordCount) {
        waitUntilElementVisible(uploadFileButton, 3);
        clickElement(uploadFileButton);
        enterText(By.id("recordCount"), recordCount);
        clickElement(By.id("submitFile"));
    }

    public void triggerProcessingOfFile() {
        triggerInterfaceProcessing();
    }

    public void validateMultipleRecordsProcessing() {
        Assert.assertTrue(isElementPresent(By.id("allRecordsProcessed")), "Not all records were processed successfully.");
    }

    public void reviewDataForWorkflows() {
        reviewProcessedDataInSystem();
    }

    public void validateDataPreparation() {
        Assert.assertTrue(isElementPresent(By.id("dataReady")), "Processed data is not ready for further workflows.");
    }
}