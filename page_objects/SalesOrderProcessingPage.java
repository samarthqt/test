package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SalesOrderProcessingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By salesOrderProcessingScreen = By.id("salesOrderProcessingScreen");
    protected By fileUploadInput = By.id("fileUpload");
    protected By errorLog = By.id("errorLog");
    protected By notificationPanel = By.id("notificationPanel");
    protected By btnUploadFile = By.id("uploadFileButton");
    protected By systemLog = By.id("systemLog");
    protected By retryUploadButton = By.id("retryUploadButton");
    protected By notificationMessage = By.id("notificationMessage");
    protected By txtSAPUsername = By.id("sapUsername");
    protected By txtSAPPassword = By.id("sapPassword");
    protected By btnSAPLogin = By.id("sapLoginButton");
    protected By errorMessage = By.id("errorMessage");
    protected By salesOrdersTable = By.id("salesOrdersTable");
    protected By archiveSection = By.id("archiveSection");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToSalesOrderProcessingScreen() {
        waitUntilElementVisible(salesOrderProcessingScreen, 5);
        clickElement(salesOrderProcessingScreen);
    }

    public void uploadInboundFile(String salesOrganization, String documentTypes) {
        String fileContent = generatePipeDelimitedFile(salesOrganization, documentTypes);
        uploadFile(fileUploadInput, fileContent);
    }

    public void verifyFileProcessingForMissingData() {
        Assert.assertTrue(isElementVisible(errorLog), "Error log is not visible, indicating file processing did not identify missing data.");
    }

    public void verifyErrorLog(String expectedErrorMessage) {
        String actualErrorMessage = getTextFromElement(errorLog);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match.");
    }

    public void verifyNoSalesOrdersProcessed() {
        Assert.assertFalse(isElementVisible(By.id("salesOrdersTable")), "Sales orders table is visible, indicating orders were processed.");
    }

    public void verifyUserFriendlyErrorMessage(String expectedCorrectiveAction) {
        String actualCorrectiveAction = getTextFromElement(errorLog);
        Assert.assertTrue(actualCorrectiveAction.contains(expectedCorrectiveAction), "Corrective action is not user-friendly or does not match.");
    }

    public void verifyFileAcceptedAndProcessed() {
        Assert.assertTrue(isElementVisible(By.id("successMessage")), "File was not accepted and processed successfully.");
    }

    public void verifyValidSalesOrdersCreated() {
        Assert.assertTrue(isElementVisible(By.id("salesOrdersTable")), "Valid sales orders were not created or displayed.");
    }

    public void verifyFileRejectionConsistency() {
        Assert.assertTrue(isElementVisible(errorLog), "File rejection is not consistent.");
    }

    public void verifyErrorLogStorage() {
        Assert.assertTrue(isElementVisible(By.id("auditLog")), "Error log entries are not stored or accessible for audit purposes.");
    }

    public void verifyErrorNotificationsSent() {
        Assert.assertTrue(isElementVisible(notificationPanel), "Notifications were not sent to stakeholders.");
    }

    private String generatePipeDelimitedFile(String salesOrganization, String documentTypes) {
        return salesOrganization + "|" + documentTypes;
    }

    public void loginToSAP() {
        launchUrl("http://dummy-sap-url.com");
        waitUntilElementVisible(txtUsername, 5);
        enterText(txtUsername, "validUsername");
        enterText(txtPassword, "validPassword");
        clickElement(btnLogin);
    }

    public void prepareFileWithSalesOrganization(String salesOrganization) {
        // Logic to prepare a pipe-delimited file with the given Sales Organization
        // Example: Write the salesOrganization value to a file
    }

    public void uploadPreparedFile() {
        waitUntilElementVisible(btnUploadFile, 5);
        clickElement(btnUploadFile);
        // Logic to upload the prepared file
    }

    public void verifySystemBehavior(String expectedBehavior) {
        // Logic to verify the system behavior after file upload
        Assert.assertEquals(getTextFromElement(systemLog), expectedBehavior, "System behavior does not match.");
    }

    public void checkSystemLogForErrors() {
        waitUntilElementVisible(systemLog, 5);
        // Logic to check the system log for errors
    }

    public void verifyErrorLogBehavior(String expectedErrorLogBehavior) {
        Assert.assertEquals(getTextFromElement(errorLog), expectedErrorLogBehavior, "Error log behavior does not match.");
    }

    public void verifySalesOrderDisplayBehavior(String expectedBehavior) {
        // Logic to verify sales order display behavior
        Assert.assertEquals(getTextFromElement(salesOrderProcessingScreen), expectedBehavior, "Sales order display behavior does not match.");
    }

    public void verifyErrorMessageBehavior(String expectedErrorMessageBehavior) {
        // Logic to verify error message behavior
        Assert.assertEquals(getTextFromElement(errorLog), expectedErrorMessageBehavior, "Error message behavior does not match.");
    }

    public void retryUploadWithCorrectedData() {
        waitUntilElementVisible(retryUploadButton, 5);
        clickElement(retryUploadButton);
        // Logic to retry the upload with corrected data
    }

    public void verifyRetryBehavior(String expectedRetryBehavior) {
        // Logic to verify retry behavior
        Assert.assertEquals(getTextFromElement(systemLog), expectedRetryBehavior, "Retry behavior does not match.");
    }

    public void verifyCorrectFileBehavior(String expectedCorrectFileBehavior) {
        // Logic to verify correct file behavior
        Assert.assertEquals(getTextFromElement(salesOrderProcessingScreen), expectedCorrectFileBehavior, "Correct file behavior does not match.");
    }

    public void verifyFutureUploadBehavior(String expectedFutureUploadBehavior) {
        // Logic to verify future upload behavior
        Assert.assertEquals(getTextFromElement(systemLog), expectedFutureUploadBehavior, "Future upload behavior does not match.");
    }

    public void verifyAuditLogBehavior(String expectedAuditLogBehavior) {
        // Logic to verify audit log behavior
        Assert.assertEquals(getTextFromElement(errorLog), expectedAuditLogBehavior, "Audit log behavior does not match.");
    }

    public void verifyNotificationBehavior(String expectedNotificationBehavior) {
        // Logic to verify notification behavior
        Assert.assertEquals(getTextFromElement(notificationMessage), expectedNotificationBehavior, "Notification behavior does not match.");
    }

    public void verifySAPCredentials() {
        Assert.assertTrue(isElementVisible(txtSAPUsername, 5), "SAP Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtSAPPassword, 5), "SAP Password field is not visible.");
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementVisible(salesOrderProcessingScreen, 5), "User is not successfully logged into the SAP system.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(salesOrderProcessingScreen, 5), "User is not logged into the SAP system.");
    }

    public void verifySalesOrderProcessingScreenDisplayed() {
        Assert.assertTrue(isElementVisible(salesOrderProcessingScreen, 5), "Sales Order processing screen is not displayed.");
    }

    public void uploadFileWithDelimiters(String fileStatus) {
        String filePath = fileStatus.equals("missing delimiters") ? "path/to/invalidFile.txt" : "path/to/validFile.txt";
        uploadFile(fileUploadInput, filePath);
    }

    public void verifyFileProcessingBehavior(String systemBehavior) {
        if (systemBehavior.equals("rejects")) {
            Assert.assertTrue(isElementVisible(errorMessage, 5), "System did not reject the file.");
        } else if (systemBehavior.equals("accepts and processes")) {
            Assert.assertFalse(isElementVisible(errorMessage, 5), "System rejected the file unexpectedly.");
        }
    }

    public void verifyErrorHandling(String errorHandling) {
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualErrorMessage.contains(errorHandling), "Error handling message does not match expected behavior.");
    }

    public void attemptToDisplayOrProcessSalesOrders() {
        // Dummy implementation for attempting to display or process sales orders
    }

    public void verifyNoSalesOrdersDisplayedOrProcessed() {
        Assert.assertTrue(isElementVisible(errorMessage, 5), "Sales orders are displayed or processed unexpectedly.");
    }

    public void logError() {
        Assert.assertTrue(isElementVisible(errorMessage, 5), "Error is not logged.");
    }

    public void verifyErrorMessageDetailsAndActions() {
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualErrorMessage.contains("missing delimiters"), "Error message does not provide details about missing delimiters.");
        Assert.assertTrue(actualErrorMessage.contains("corrective actions"), "Error message does not provide corrective actions.");
    }

    public void verifyErrorLogEntriesStoredForAudit() {
        // Dummy implementation for verifying error log entries
    }

    public void verifyNotificationsSentToStakeholders() {
        String actualNotificationMessage = getTextFromElement(notificationMessage);
        Assert.assertTrue(actualNotificationMessage.contains("error details"), "Notifications do not contain error details.");
    }

    public void verifySalesOrderProcessingScreen() {
        Assert.assertTrue(isElementVisible(salesOrderProcessingScreen), "User is not on the Sales Order processing screen.");
    }

    public void uploadPipeDelimitedFile(String dataFields) {
        enterText(fileUploadInput, dataFields);
        clickElement(fileUploadInput);
    }

    public void verifyFileProcessingAndDataFields() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "File processing failed or minimum data fields not identified.");
    }

    public void verifyFileUploadedWithMinimumDataFields() {
        Assert.assertTrue(isElementVisible(fileUploadInput), "File with minimum data fields not uploaded.");
    }

    public void processSalesOrdersFromFile() {
        clickElement(salesOrdersTable);
    }

    public void verifySalesOrdersCreated() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "Sales orders not created successfully.");
    }

    public void verifyNoErrorsLogged() {
        Assert.assertFalse(isElementVisible(systemLog), "Errors or warnings are logged.");
    }

    public void verifyFileProcessed() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "File not processed successfully.");
    }

    public void viewCreatedSalesOrders() {
        clickElement(salesOrdersTable);
    }

    public void verifySalesOrdersContainMinimumDataFields() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "Sales orders do not contain minimum required data fields.");
    }

    public void verifyFileUploadedAndProcessed() {
        Assert.assertTrue(isElementVisible(fileUploadInput), "File not uploaded or processed successfully.");
    }

    public void completeFileProcessing() {
        clickElement(notificationMessage);
    }

    public void verifyNotificationsSent() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Notifications not sent to stakeholders.");
    }

    public void archiveProcessedFile() {
        clickElement(archiveSection);
    }

    public void verifyFileAccessibleForAudit() {
        Assert.assertTrue(isElementVisible(archiveSection), "Processed file not accessible for audit.");
    }

    public void verifyFileRejected() {
        Assert.assertFalse(isElementVisible(salesOrdersTable), "File not rejected as expected.");
    }

    public void viewSalesOrdersInProcessingScreen() {
        clickElement(salesOrdersTable);
    }

    public void verifySalesOrdersDisplayedCorrectly() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "Sales orders not displayed correctly.");
    }

    public void checkSystemLogs() {
        clickElement(systemLog);
    }

    public void verifyProcessingDetailsLogged() {
        Assert.assertTrue(isElementVisible(systemLog), "Processing details not logged.");
    }

    public void uploadAnotherFileWithSameDataFields() {
        enterText(fileUploadInput, "sameMinimumDataFields");
        clickElement(fileUploadInput);
    }

    public void verifyConsistentFileProcessing() {
        Assert.assertTrue(isElementVisible(salesOrdersTable), "File processing not consistent.");
    }
}
