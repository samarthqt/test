package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AttributeProcessingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By transactionField = By.id("transactionField");
    protected By attribute7Field = By.id("attribute7");
    protected By btnSave = By.id("saveButton");
    protected By fieldCatalogScreen = By.id("fieldCatalogScreen");
    protected By billingDocumentScreen = By.id("billingDocumentScreen");
    protected By outputLogs = By.id("outputLogs");
    protected By testResultsField = By.id("testResultsField");
    protected By btnCloseSession = By.id("closeSessionButton");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToPayerMasterDataTransaction() {
        waitUntilElementVisible(transactionField, 3);
        enterText(transactionField, "PayerMasterDataTransaction");
        pressEnter(transactionField);
    }

    public void populateAttribute7(String attributeValue) {
        waitUntilElementVisible(attribute7Field, 3);
        enterText(attribute7Field, attributeValue);
    }

    public void savePayerMasterDataChanges() {
        waitUntilElementVisible(btnSave, 3);
        clickElement(btnSave);
    }

    public void navigateToFieldCatalogConfiguration() {
        waitUntilElementVisible(fieldCatalogScreen, 3);
        clickElement(fieldCatalogScreen);
    }

    public void verifyAttribute7InFieldCatalog() {
        waitUntilElementVisible(fieldCatalogScreen, 3);
        boolean isAttribute7Present = isElementPresent(By.xpath("//td[contains(text(),'Attribute 7')]"));
        Assert.assertTrue(isAttribute7Present, "Attribute 7 is not included in the field catalog.");
    }

    public void createNewBillingDocument() {
        waitUntilElementVisible(billingDocumentScreen, 3);
        clickElement(billingDocumentScreen);
    }

    public void triggerOutputDetermination() {
        waitUntilElementVisible(outputLogs, 3);
        clickElement(outputLogs);
    }

    public void verifyOutputDeterminationLogs(String attributeValue) {
        waitUntilElementVisible(outputLogs, 3);
        boolean isLogCorrect = getTextFromElement(outputLogs).contains(attributeValue);
        Assert.assertTrue(isLogCorrect, "Output determination logs do not show the correct processing of Attribute 7.");
    }

    public void verifyGeneratedOutputForAttribute7() {
        waitUntilElementVisible(outputLogs, 3);
        boolean isOutputCorrect = getTextFromElement(outputLogs).contains("Processed Attribute 7 values correctly");
        Assert.assertTrue(isOutputCorrect, "Generated output does not reflect the processed Attribute 7 values correctly.");
    }

    public void verifyNoDataIntegrityIssues() {
        waitUntilElementVisible(outputLogs, 3);
        boolean noIssues = !getTextFromElement(outputLogs).contains("Data Integrity Issue");
        Assert.assertTrue(noIssues, "Data integrity issues are identified in the output.");
    }

    public void verifyOutputDeterminationCompletion() {
        waitUntilElementVisible(outputLogs, 3);
        boolean isProcessComplete = getTextFromElement(outputLogs).contains("Output determination process completed");
        Assert.assertTrue(isProcessComplete, "Output determination process is not completed.");
    }

    public void documentTestResults() {
        waitUntilElementVisible(testResultsField, 3);
        enterText(testResultsField, "Test results documented successfully.");
    }

    public void closeSession() {
        waitUntilElementVisible(btnCloseSession, 3);
        clickElement(btnCloseSession);
    }
}