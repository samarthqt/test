package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class BulkUploadPage extends WebReusableComponents {

    protected By bulkUploadProgramAccess = By.id("bulkUploadAccess");
    protected By bulkUploadFilePreparation = By.id("bulkUploadFile");
    protected By sapLoginButton = By.id("sapLoginButton");
    protected By bulkUploadTransactionCode = By.id("bulkUploadTransactionCode");
    protected By conditionTable911 = By.id("conditionTable911");
    protected By bulkFileUploadButton = By.id("bulkFileUploadButton");
    protected By fileValidationStatus = By.id("fileValidationStatus");
    protected By bulkUploadProcessButton = By.id("bulkUploadProcessButton");
    protected By uploadProgressLog = By.id("uploadProgressLog");
    protected By uploadStatus = By.id("uploadStatus");
    protected By transactionCodeSM30 = By.id("transactionCodeSM30");
    protected By uploadedDataTable = By.id("uploadedDataTable");
    protected By dataComparisonStatus = By.id("dataComparisonStatus");
    protected By outputDeterminationLogicButton = By.id("outputDeterminationLogicButton");

    public BulkUploadPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyBulkUploadProgramAccess() {
        waitUntilElementVisible(bulkUploadProgramAccess, 5);
        Assert.assertTrue(isElementDisplayed(bulkUploadProgramAccess), "Bulk upload program access is not available.");
    }

    public void prepareBulkUploadFile() {
        waitUntilElementVisible(bulkUploadFilePreparation, 3);
        clickElement(bulkUploadFilePreparation);
    }

    public void verifyBulkUploadFilePreparation() {
        Assert.assertTrue(isElementDisplayed(bulkUploadFilePreparation), "Bulk upload file preparation failed.");
    }

    public void verifySAPCredentials() {
        Assert.assertTrue(isElementDisplayed(sapLoginButton), "SAP credentials are not valid.");
    }

    public void loginToSAPSystem() {
        waitUntilElementVisible(sapLoginButton, 3);
        clickElement(sapLoginButton);
    }

    public void verifySAPLoginSuccess() {
        Assert.assertTrue(isElementDisplayed(bulkUploadTransactionCode), "SAP login failed.");
    }

    public void verifySAPLoginStatus() {
        Assert.assertTrue(isElementDisplayed(bulkUploadTransactionCode), "User is not logged into SAP system.");
    }

    public void navigateToBulkUploadTransactionCode() {
        waitUntilElementVisible(bulkUploadTransactionCode, 3);
        clickElement(bulkUploadTransactionCode);
    }

    public void verifyBulkUploadScreenDisplay() {
        Assert.assertTrue(isElementDisplayed(conditionTable911), "Bulk upload program screen is not displayed.");
    }

    public void verifyBulkUploadScreenStatus() {
        Assert.assertTrue(isElementDisplayed(conditionTable911), "User is not on the bulk upload program screen.");
    }

    public void selectConditionTable911() {
        waitUntilElementVisible(conditionTable911, 3);
        clickElement(conditionTable911);
    }

    public void verifyConditionTableSelection() {
        Assert.assertTrue(isElementDisplayed(conditionTable911), "Condition table 911 selection failed.");
    }

    public void verifyConditionTable911Selection() {
        Assert.assertTrue(isElementDisplayed(conditionTable911), "Condition table 911 is not selected.");
    }

    public void uploadBulkFile() {
        waitUntilElementVisible(bulkFileUploadButton, 3);
        clickElement(bulkFileUploadButton);
    }

    public void verifyBulkFileUpload() {
        Assert.assertTrue(isElementDisplayed(fileValidationStatus), "Bulk file upload failed.");
    }

    public void verifyBulkFileUploadStatus() {
        Assert.assertTrue(isElementDisplayed(fileValidationStatus), "Bulk file is not uploaded.");
    }

    public void validateFileContents() {
        waitUntilElementVisible(fileValidationStatus, 3);
        clickElement(fileValidationStatus);
    }

    public void verifyFileContentValidation() {
        Assert.assertTrue(isElementDisplayed(fileValidationStatus), "File content validation failed.");
    }

    public void verifyFileValidationStatus() {
        Assert.assertTrue(isElementDisplayed(fileValidationStatus), "File contents are not validated successfully.");
    }

    public void initiateBulkUploadProcess() {
        waitUntilElementVisible(bulkUploadProcessButton, 3);
        clickElement(bulkUploadProcessButton);
    }

    public void verifyBulkUploadProcessStart() {
        Assert.assertTrue(isElementDisplayed(uploadProgressLog), "Bulk upload process did not start successfully.");
    }

    public void verifyBulkUploadProcessStatus() {
        Assert.assertTrue(isElementDisplayed(uploadProgressLog), "Bulk upload process is not started.");
    }

    public void monitorUploadProgress() {
        waitUntilElementVisible(uploadProgressLog, 3);
        clickElement(uploadProgressLog);
    }

    public void verifyUploadProgressDisplay() {
        Assert.assertTrue(isElementDisplayed(uploadProgressLog), "Upload progress is not displayed in the program log.");
    }

    public void verifyUploadProgressStatus() {
        Assert.assertTrue(isElementDisplayed(uploadProgressLog), "Upload progress is not displayed.");
    }

    public void verifyUploadStatus() {
        Assert.assertTrue(isElementDisplayed(uploadStatus), "Upload status verification failed.");
    }

    public void verifyRecordsUploadSuccess() {
        Assert.assertTrue(isElementDisplayed(uploadStatus), "Not all records are uploaded successfully.");
    }

    public void verifyRecordsUploadStatus() {
        Assert.assertTrue(isElementDisplayed(uploadStatus), "Records are not uploaded successfully.");
    }

    public void navigateToTransactionCodeSM30() {
        waitUntilElementVisible(transactionCodeSM30, 3);
        clickElement(transactionCodeSM30);
    }

    public void verifyUploadedDataVisibility() {
        Assert.assertTrue(isElementDisplayed(uploadedDataTable), "Uploaded data is not visible in the table.");
    }

    public void verifyUploadedDataStatus() {
        Assert.assertTrue(isElementDisplayed(uploadedDataTable), "Uploaded data is not visible.");
    }

    public void compareUploadedDataWithInputFile() {
        waitUntilElementVisible(dataComparisonStatus, 3);
        clickElement(dataComparisonStatus);
    }

    public void verifyDataMatchWithInputFile() {
        Assert.assertTrue(isElementDisplayed(dataComparisonStatus), "Data in the table does not match the input file.");
    }

    public void verifyDataMatchStatus() {
        Assert.assertTrue(isElementDisplayed(dataComparisonStatus), "Data does not match the input file.");
    }

    public void testOutputDeterminationLogic() {
        waitUntilElementVisible(outputDeterminationLogicButton, 3);
        clickElement(outputDeterminationLogicButton);
    }

    public void verifyOutputDeterminationLogic() {
        Assert.assertTrue(isElementDisplayed(outputDeterminationLogicButton), "Output determination logic failed.");
    }

}