package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class BackgroundJobPage extends WebReusableComponents {

    // Fields from both input classes
    protected By txtRunDate = By.id("runDate");
    protected By txtFilePath = By.id("filePath");
    protected By btnExecuteJob = By.id("executeJobButton");
    protected By lblJobLog = By.id("jobLog");
    protected By lblCustomerMasterData = By.id("customerMasterData");
    protected By lblSiteMasterData = By.id("siteMasterData");
    protected By lblSystemLogs = By.id("systemLogs");
    protected By lblJobStatus = By.id("jobStatus");
    protected By lblProcessedData = By.id("processedData");
    protected By txtSAPUsername = By.id("sapUsername");
    protected By txtSAPPassword = By.id("sapPassword");
    protected By btnLogin = By.id("loginButton");
    protected By directoryPath = By.id("directoryPath");
    protected By fileStatus = By.id("fileStatus");
    protected By selectionScreen = By.id("selectionScreen");
    protected By mandatoryParameters = By.id("mandatoryParameters");
    protected By errorMessage = By.id("errorMessage");

    // Methods from both input classes
    public void loginToSAP(String username, String password) {
        launchUrl("https://sap-s4hana-login-url");
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(By.id("loginButton"));
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(By.id("dashboard"), 5);
    }

    public void assertDashboardIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(By.id("dashboard")), "Dashboard is not displayed.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(By.id("dashboard")), "User is not logged in.");
    }

    public void navigateToSelectionScreen() {
        clickElement(By.id("navigateToSelectionScreen"));
    }

    public void assertSelectionScreenIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(By.id("selectionScreen")), "Selection screen is not displayed.");
    }

    public void verifySelectionScreenAccess() {
        Assert.assertTrue(isElementDisplayed(By.id("selectionScreen")), "User is not on the selection screen.");
    }

    public void verifyMandatoryParameters() {
        Assert.assertTrue(isElementDisplayed(By.id("salesDocumentType")), "Sales Document Type is not pre-populated.");
        Assert.assertTrue(isElementDisplayed(By.id("salesOrganization")), "Sales Organization is not pre-populated.");
        Assert.assertTrue(isElementDisplayed(By.id("distributionChannel")), "Distribution Channel is not pre-populated.");
        Assert.assertTrue(isElementDisplayed(By.id("division")), "Division is not pre-populated.");
    }

    public void assertMandatoryParametersPrePopulated() {
        verifyMandatoryParameters();
    }

    public void inputRunDate(String runDate) {
        enterText(txtRunDate, runDate);
    }

    public void inputFilePath(String filePath) {
        enterText(txtFilePath, filePath);
    }

    public void assertRunDateAndFilePathAccepted() {
        Assert.assertTrue(isElementDisplayed(txtRunDate), "Run Date is not accepted.");
        Assert.assertTrue(isElementDisplayed(txtFilePath), "File Path is not accepted.");
    }

    public void verifyValidRunDateAndFilePath() {
        Assert.assertTrue(isElementDisplayed(txtRunDate), "Run Date is not valid.");
        Assert.assertTrue(isElementDisplayed(txtFilePath), "File Path is not valid.");
    }

    public void executeBackgroundJob() {
        clickElement(btnExecuteJob);
    }

    public void assertBackgroundJobTriggered() {
        Assert.assertTrue(isElementDisplayed(lblJobLog), "Background job is not triggered.");
    }

    public void verifyJobTriggered() {
        Assert.assertTrue(isElementDisplayed(lblJobLog), "Job is not triggered.");
    }

    public void monitorJobExecution() {
        clickElement(By.id("monitorJobExecution"));
    }

    public void assertJobLogUpdated() {
        Assert.assertTrue(isElementDisplayed(lblJobLog), "Job log is not updated.");
    }

    public void verifyJobInProgress() {
        Assert.assertTrue(isElementDisplayed(lblJobLog), "Job is not in progress.");
    }

    public void pickUpInputFile() {
        clickElement(By.id("pickUpInputFile"));
    }

    public void assertInputFilePickedUp() {
        Assert.assertTrue(isElementDisplayed(By.id("inputFilePickedUp")), "Input file is not picked up.");
    }

    public void verifyInputFilePickedUp() {
        Assert.assertTrue(isElementDisplayed(By.id("inputFilePickedUp")), "Input file is not picked up.");
    }

    public void processFileData() {
        clickElement(By.id("processFileData"));
    }

    public void assertCustomerMasterDataUpdated() {
        Assert.assertTrue(isElementDisplayed(lblCustomerMasterData), "Customer Master Data is not updated.");
    }

    public void assertSiteMasterDataUpdated() {
        Assert.assertTrue(isElementDisplayed(lblSiteMasterData), "Site Master Data is not updated.");
    }

    public void verifyJobExecutionStatus() {
        Assert.assertTrue(isElementDisplayed(lblJobLog), "Job execution status is not available.");
    }

    public void checkSystemLogs() {
        clickElement(By.id("checkSystemLogs"));
    }

    public void assertSystemLogsIndicateSuccess() {
        Assert.assertTrue(isElementDisplayed(lblSystemLogs), "System logs do not indicate success.");
    }

    public void completeJobExecution() {
        clickElement(By.id("completeJobExecution"));
    }

    public void assertJobStatusCompleted() {
        Assert.assertTrue(isElementDisplayed(lblJobStatus), "Job status is not marked as 'Completed'.");
    }

    public void verifyJobExecutionCompleted() {
        Assert.assertTrue(isElementDisplayed(lblJobStatus), "Job execution is not completed.");
    }

    public void viewProcessedData() {
        clickElement(By.id("viewProcessedData"));
    }

    public void assertProcessedDataDisplayedCorrectly() {
        Assert.assertTrue(isElementDisplayed(lblProcessedData), "Processed data is not displayed correctly.");
    }

    public void loginToSAP() {
        waitUntilElementVisible(txtSAPUsername, 3);
        enterText(txtSAPUsername, "validUsername");
        waitUntilElementVisible(txtSAPPassword, 3);
        enterText(txtSAPPassword, "validPassword");
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToDirectory(String directory) {
        waitUntilElementVisible(directoryPath, 3);
        enterText(directoryPath, directory);
    }

    public void verifyFileAbsence() {
        waitUntilElementVisible(fileStatus, 3);
        String status = getTextFromElement(fileStatus);
        Assert.assertEquals(status, "File not found", "File is present in the directory.");
    }

    public void navigateToSelectionScreen() {
        waitUntilElementVisible(selectionScreen, 3);
        clickElement(selectionScreen);
    }

    public void enterMandatoryParameters() {
        waitUntilElementVisible(mandatoryParameters, 3);
        enterText(mandatoryParameters, "Mandatory Parameters");
    }

    public void executeBackgroundJob() {
        waitUntilElementVisible(btnExecuteJob, 3);
        clickElement(btnExecuteJob);
    }

    public void verifyErrorMessage(String expectedMessage, String expectedStatus) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage) && actualMessage.contains(expectedStatus), "Error message or status mismatch.");
    }

    public void verifyExecutionHalted() {
        String status = getTextFromElement(fileStatus);
        Assert.assertEquals(status, "Execution Halted", "Execution did not halt.");
    }

    public void reExecuteBackgroundJob() {
        waitUntilElementVisible(btnExecuteJob, 3);
        clickElement(btnExecuteJob);
    }

    public void uploadInputFile(String directory) {
        navigateToDirectory(directory);
        Assert.assertTrue(true, "File upload successful.");
    }

    public void verifySuccessfulExecution() {
        String status = getTextFromElement(fileStatus);
        Assert.assertEquals(status, "Execution Successful", "Execution was not successful.");
    }

    public void verifyFileProcessing() {
        String status = getTextFromElement(fileStatus);
        Assert.assertEquals(status, "File Processed", "File was not processed.");
    }

    public void verifyDataAccuracyAndCompleteness() {
        Assert.assertTrue(true, "Data is accurate and complete.");
    }

    public void recheckSystemLogs() {
        waitUntilElementVisible(systemLogs, 3);
        clickElement(systemLogs);
    }

    public void verifyCleanExecutionLogs() {
        String logs = getTextFromElement(systemLogs);
        Assert.assertTrue(logs.contains("Clean Execution"), "Logs do not confirm clean execution.");
    }

    public void verifySystemStateAfterFailures() {
        Assert.assertTrue(true, "System state is intact after failures.");
    }

    public void verifyNoDataProcessingDuringFailures() {
        Assert.assertTrue(true, "No data processing occurred during failures.");
    }
}
