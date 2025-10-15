package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OutputTypePage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By sapHomeScreen = By.id("homeScreen");
    protected By transactionVF03 = By.id("transactionVF03");
    protected By documentDetails = By.id("documentDetails");
    protected By errorMessage = By.id("errorMessage");
    protected By logDetails = By.id("logDetails");
    protected By errorLogs = By.id("errorLogs");
    protected By invalidOutputs = By.id("invalidOutputs");
    protected By guidanceMessage = By.id("guidanceMessage");
    protected By reconfigureButton = By.id("reconfigureButton");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomeScreenNavigation(String expectedScreen) {
        waitUntilElementVisible(sapHomeScreen, 3);
        String actualScreen = getTextFromElement(sapHomeScreen);
        Assert.assertEquals(actualScreen, expectedScreen, "User is not on the SAP home screen.");
    }

    public void verifyDocumentExistence(String documentNumber) {
        waitUntilElementVisible(transactionVF03, 3);
        enterText(transactionVF03, documentNumber);
    }

    public void navigateToTransactionVF03() {
        clickElement(transactionVF03);
    }

    public void verifyDocumentDetails(String outputType) {
        waitUntilElementVisible(documentDetails, 3);
        String actualOutputType = getTextFromElement(documentDetails);
        Assert.assertEquals(actualOutputType, outputType, "Output Type does not match.");
    }

    public void verifyIncorrectConfiguration(String outputType) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(outputType), "Output Type configuration is not incorrect.");
    }

    public void executeRenderingProcess(String outputType) {
        waitUntilElementVisible(transactionVF03, 3);
        enterText(transactionVF03, outputType);
        clickElement(transactionVF03);
    }

    public void verifyPrintProgramExecution(String printProgram) {
        waitUntilElementVisible(logDetails, 3);
        String actualLogDetails = getTextFromElement(logDetails);
        Assert.assertTrue(actualLogDetails.contains(printProgram), "Print program execution failed.");
    }

    public void attemptRenderingProcess(String outputType) {
        waitUntilElementVisible(transactionVF03, 3);
        enterText(transactionVF03, outputType);
        clickElement(transactionVF03);
    }

    public void detectIncorrectConfiguration() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("Incorrect configuration"), "System did not detect incorrect configuration.");
    }

    public void verifyErrorMessage(String errorMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, errorMessage, "Error message does not match.");
    }

    public void verifyLogDetails(String logDetails) {
        waitUntilElementVisible(logDetails, 3);
        String actualLogDetails = getTextFromElement(logDetails);
        Assert.assertEquals(actualLogDetails, logDetails, "Log details do not match.");
    }

    public void verifyRenderingProcessHalted() {
        waitUntilElementVisible(invalidOutputs, 3);
        String actualOutput = getTextFromElement(invalidOutputs);
        Assert.assertTrue(actualOutput.isEmpty(), "Rendering process was not halted.");
    }

    public void verifyErrorNotification() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("Error"), "User was not notified about the error.");
    }

    public void verifyGuidanceProvided() {
        waitUntilElementVisible(guidanceMessage, 3);
        String actualMessage = getTextFromElement(guidanceMessage);
        Assert.assertTrue(actualMessage.contains("guidance"), "System did not provide guidance.");
    }

    public void verifyErrorLogsExist() {
        waitUntilElementVisible(errorLogs, 3);
        String actualLogs = getTextFromElement(errorLogs);
        Assert.assertTrue(!actualLogs.isEmpty(), "Error logs do not exist.");
    }

    public void saveErrorLogs() {
        clickElement(errorLogs);
    }

    public void verifyErrorLogsSaved() {
        waitUntilElementVisible(errorLogs, 3);
        String actualLogs = getTextFromElement(errorLogs);
        Assert.assertTrue(!actualLogs.isEmpty(), "Error logs were not saved successfully.");
    }

    public void checkInvalidOutputs() {
        waitUntilElementVisible(invalidOutputs, 3);
        String actualOutput = getTextFromElement(invalidOutputs);
        Assert.assertTrue(actualOutput.isEmpty(), "Invalid outputs were generated.");
    }

    public void reconfigureOutputType() {
        clickElement(reconfigureButton);
    }

    public void verifyReconfigurationAllowed() {
        waitUntilElementVisible(reconfigureButton, 3);
        Assert.assertTrue(isElementEnabled(reconfigureButton), "Reconfiguration is not allowed.");
    }

    public void verifyConfigurationCorrected() {
        waitUntilElementVisible(guidanceMessage, 3);
        String actualMessage = getTextFromElement(guidanceMessage);
        Assert.assertTrue(actualMessage.contains("corrected"), "Output Type configuration is not corrected.");
    }

    public void reattemptRenderingProcess() {
        clickElement(transactionVF03);
    }

    public void verifyRenderingProcessSuccess() {
        waitUntilElementVisible(documentDetails, 3);
        String actualOutputType = getTextFromElement(documentDetails);
        Assert.assertTrue(!actualOutputType.isEmpty(), "Rendering process was not successfully executed.");
    }
}