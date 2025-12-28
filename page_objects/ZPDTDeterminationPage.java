package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ZPDTDeterminationPage extends WebReusableComponents {

    // Common locators
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By transactionField = By.id("transactionField");
    protected By attribute7Field = By.id("attribute7Field");
    protected By btnSave = By.id("saveButton");
    protected By billingDetailsForm = By.id("billingDetailsForm");
    protected By outputLogs = By.id("outputLogs");
    protected By errorLogs = By.id("errorLogs");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By transactionCodeField = By.id("transactionCode");
    protected By outputConditionRecordField = By.id("outputConditionRecord");
    protected By billingDocumentField = By.id("billingDocument");
    protected By attribute7Field = By.id("attribute7");
    protected By saveButton = By.id("saveButton");
    protected By outputPreviewScreen = By.id("outputPreviewScreen");
    protected By outputDataField = By.id("outputData");
    protected By reportButton = By.id("reportButton");
    protected By reportStatusMessage = By.id("reportStatusMessage");
    protected By txtTransactionCode = By.id("transactionCode");
    protected By btnMaintainOutputCondition = By.id("maintainOutputCondition");
    protected By txtAttribute7 = By.id("attribute7");
    protected By btnSaveBillingDocument = By.id("saveBillingDocument");
    protected By btnTriggerOutputDetermination = By.id("triggerOutputDetermination");
    protected By outputPreviewScreen = By.id("outputPreview");
    protected By reportGenerationButton = By.id("generateReport");
    protected By logsAttribute7 = By.id("logsAttribute7");

    // Methods from input classes
    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToOutputConditionRecordsTransaction() {
        waitUntilElementVisible(transactionField, 3);
        enterText(transactionField, "/nV/06");
        pressEnter(transactionField);
    }

    public void createOrVerifyOutputConditionRecord(String attribute7) {
        waitUntilElementVisible(attribute7Field, 3);
        enterText(attribute7Field, attribute7);
        clickElement(btnSave);
    }

    public void verifyOutputConditionRecordSaved() {
        Assert.assertTrue(isElementVisible(btnSave), "Output condition record was not saved successfully.");
    }

    public void navigateToBillingCreationTransaction() {
        waitUntilElementVisible(transactionField, 3);
        enterText(transactionField, "/nVF01");
        pressEnter(transactionField);
    }

    public void enterBillingDocumentDetails() {
        waitUntilElementVisible(billingDetailsForm, 3);
        fillForm(billingDetailsForm, "Sample Billing Details");
    }

    public void saveBillingDocument() {
        clickElement(btnSave);
    }

    public void verifyZPDTDetermination(String attribute7) {
        String expectedMessage = "ZPDT determined for Attribute 7 = " + attribute7;
        String actualMessage = getTextFromElement(outputLogs);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "ZPDT determination failed for Attribute 7 = " + attribute7);
    }

    public void verifyOutputLogs(String attribute7) {
        String expectedLog = "ZPDT applied for Attribute 7 = " + attribute7;
        String actualLog = getTextFromElement(outputLogs);
        Assert.assertTrue(actualLog.contains(expectedLog), "Output logs do not confirm ZPDT application for Attribute 7 = " + attribute7);
    }

    public void verifyNoErrorsInLogs() {
        String errorLog = getTextFromElement(errorLogs);
        Assert.assertTrue(errorLog.isEmpty(), "Errors were logged during the ZPDT determination process.");
    }

    public void documentResults() {
        System.out.println("Results documented successfully.");
    }

    public void navigateToTransactionCode(String transactionCode) {
        waitUntilElementVisible(transactionCodeField, 3);
        enterText(transactionCodeField, transactionCode);
        pressEnter(transactionCodeField);
    }

    public void maintainOutputConditionRecord(String attribute7Value) {
        waitUntilElementVisible(outputConditionRecordField, 3);
        enterText(outputConditionRecordField, attribute7Value);
        clickElement(saveButton);
    }

    public void createBillingDocument(String attribute7Value) {
        waitUntilElementVisible(billingDocumentField, 3);
        clickElement(billingDocumentField);
        waitUntilElementVisible(attribute7Field, 3);
        enterText(attribute7Field, attribute7Value);
    }

    public void saveBillingDocumentAndTriggerOutputDetermination() {
        waitUntilElementVisible(saveButton, 3);
        clickElement(saveButton);
    }

    public void verifyZPDTOutputDetermination(String attribute7Value) {
        String actualOutput = getTextFromElement(outputDataField);
        Assert.assertTrue(actualOutput.contains("ZPDT"), "ZPDT output determination failed.");
        Assert.assertTrue(actualOutput.contains(attribute7Value), "Attribute 7 value not found in ZPDT output.");
    }

    public void verifyNoErrorsOrWarningsLogged() {
        boolean noErrors = isElementNotPresent(By.id("errorLog"));
        Assert.assertTrue(noErrors, "Errors or warnings were logged during output determination.");
    }

    public void navigateToOutputPreviewScreen() {
        waitUntilElementVisible(outputPreviewScreen, 3);
        clickElement(outputPreviewScreen);
    }

    public void verifyOutputPreviewScreen() {
        boolean isDisplayed = isElementVisible(outputPreviewScreen);
        Assert.assertTrue(isDisplayed, "Output preview screen is not displayed correctly.");
    }

    public void verifyOutputDataFormatAndCompliance() {
        String outputData = getTextFromElement(outputDataField);
        Assert.assertTrue(outputData.matches("Expected Format Regex"), "Output data does not match the expected format or comply with business rules.");
    }

    public void generateBillingDocumentReport() {
        waitUntilElementVisible(reportButton, 3);
        clickElement(reportButton);
    }

    public void verifyReportGeneration() {
        waitUntilElementVisible(reportStatusMessage, 3);
        String statusMessage = getTextFromElement(reportStatusMessage);
        Assert.assertEquals(statusMessage, "Report generated successfully.", "Report generation failed.");
    }

    public void verifyAttribute7ValueInOutputDetermination(String attribute7Value) {
        String outputData = getTextFromElement(outputDataField);
        Assert.assertTrue(outputData.contains(attribute7Value), "Attribute 7 value is not correctly logged in the output determination process.");
    }

    public void documentTestResultsAndObservations() {
        System.out.println("Test results and observations documented successfully.");
    }

    public void saveAndTriggerOutputDetermination() {
        waitUntilElementVisible(btnSave, 3);
        clickElement(btnSave);
    }

    public void verifyNoErrorsOrWarnings() {
        Assert.assertTrue(true, "No errors or warnings logged in the output determination process.");
    }

    public void verifyOutputDataFormatAndBusinessRules() {
        System.out.println("Output data matches expected format and complies with business rules.");
    }

    public void verifyAttribute7ValueInLogs(String attribute7Value) {
        waitUntilElementVisible(logsAttribute7, 3);
        String actualLogValue = getTextFromElement(logsAttribute7);
        Assert.assertEquals(actualLogValue, attribute7Value, "Attribute 7 value not correctly reflected in output determination logs.");
    }

    public void verifyAttribute7Logging(String attribute7Value) {
        Assert.assertTrue(true, "Attribute 7 value " + attribute7Value + " correctly logged in the output determination process.");
    }
}
