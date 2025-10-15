package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PayerMasterDataPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By transactionInput = By.id("transactionInput");
    protected By attribute7Field = By.id("attribute7");
    protected By btnSave = By.id("saveButton");
    protected By fieldCatalogScreen = By.id("fieldCatalogScreen");
    protected By attribute7InCatalog = By.xpath("//td[text()='Attribute 7']");
    protected By newBillingDocumentButton = By.id("newBillingDocument");
    protected By outputDeterminationButton = By.id("outputDetermination");
    protected By systemLogs = By.id("systemLogs");
    protected By errorLogs = By.id("errorLogs");
    protected By btnCloseSession = By.id("closeSession");

    public void loginToSAP() {
        waitUntilElementVisible(txtUsername, 5);
        enterText(txtUsername, "validUser");
        enterText(txtPassword, "validPassword");
        clickElement(btnLogin);
    }

    public void navigateToPayerMasterDataTransaction() {
        waitUntilElementVisible(transactionInput, 5);
        enterText(transactionInput, "PayerMasterDataTransaction");
        pressEnter(transactionInput);
    }

    public void populateAttribute7(String attribute7Value) {
        waitUntilElementVisible(attribute7Field, 5);
        enterText(attribute7Field, attribute7Value);
    }

    public void savePayerMasterDataChanges() {
        waitUntilElementVisible(btnSave, 5);
        clickElement(btnSave);
    }

    public void navigateToFieldCatalogConfiguration() {
        waitUntilElementVisible(fieldCatalogScreen, 5);
        clickElement(fieldCatalogScreen);
    }

    public void verifyAttribute7InFieldCatalog() {
        waitUntilElementVisible(attribute7InCatalog, 5);
        Assert.assertTrue(isElementDisplayed(attribute7InCatalog), "Attribute 7 is not present in the field catalog.");
    }

    public void createNewBillingDocument() {
        waitUntilElementVisible(newBillingDocumentButton, 5);
        clickElement(newBillingDocumentButton);
    }

    public void triggerOutputDetermination() {
        waitUntilElementVisible(outputDeterminationButton, 5);
        clickElement(outputDeterminationButton);
    }

    public void verifySystemLogs(String expectedLogMessage) {
        waitUntilElementVisible(systemLogs, 5);
        String actualLogMessage = getTextFromElement(systemLogs);
        Assert.assertTrue(actualLogMessage.contains(expectedLogMessage), "System logs do not contain the expected message.");
    }

    public void verifyNoOutputGenerated() {
        waitUntilElementVisible(systemLogs, 5);
        String actualLogMessage = getTextFromElement(systemLogs);
        Assert.assertTrue(actualLogMessage.contains("no output"), "Output was generated despite invalid Attribute 7 values.");
    }

    public void verifyErrorMessageInLogs(String expectedErrorMessage) {
        waitUntilElementVisible(errorLogs, 5);
        String actualErrorMessage = getTextFromElement(errorLogs);
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Error message not found in logs.");
    }

    public void documentTestResultsAndCloseSession() {
        // Logic to document test results can be implemented here
        waitUntilElementVisible(btnCloseSession, 5);
        clickElement(btnCloseSession);
    }

    public void verifySessionClosed() {
        Assert.assertTrue(isBrowserClosed(), "Session was not closed successfully.");
    }
}