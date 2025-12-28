package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class Attribute3Page extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By txtTransactionCode = By.id("transactionCode");
    protected By btnExecute = By.id("executeButton");
    protected By sectionAttribute3 = By.id("attribute3Section");
    protected By txtFrequency = By.id("frequencyInput");
    protected By btnSave = By.id("saveButton");
    protected By errorMessage = By.id("errorMessage");
    protected By successMessage = By.id("successMessage");
    protected By billingDocuments = By.id("billingDocuments");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToBillingDueProgram(String transactionCode) {
        waitUntilElementVisible(txtTransactionCode, 3);
        enterText(txtTransactionCode, transactionCode);
        clickElement(btnExecute);
    }

    public void locateConfigurationSectionForAttribute3() {
        waitUntilElementVisible(sectionAttribute3, 3);
    }

    public void setAttribute3Frequency(String frequencyValue) {
        waitUntilElementVisible(txtFrequency, 3);
        enterText(txtFrequency, frequencyValue);
    }

    public void verifySystemBehavior(String expectedBehavior) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedBehavior), "System behavior does not match expected behavior.");
    }

    public void attemptToSaveConfigurationChanges() {
        clickElement(btnSave);
    }

    public void verifySaveBehavior(String expectedBehavior) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedBehavior), "Save behavior does not match expected behavior.");
    }

    public void verifyNoBillingDocumentsGenerated() {
        boolean documentsGenerated = isElementPresent(billingDocuments);
        Assert.assertFalse(documentsGenerated, "Billing documents were generated despite invalid frequency value.");
    }

    public void verifyErrorLogBehavior(String expectedBehavior) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedBehavior), "Error log behavior does not match expected behavior.");
    }

    public void verifyErrorHandlingBehavior(String expectedBehavior) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedBehavior), "Error handling behavior does not match expected behavior.");
    }

    public void saveConfigurationChanges() {
        clickElement(btnSave);
        waitUntilElementVisible(successMessage, 3);
    }

    public void verifyBillingDocumentsGeneration() {
        boolean documentsGenerated = isElementPresent(billingDocuments);
        Assert.assertTrue(documentsGenerated, "Billing documents were not generated despite valid frequency value.");
    }
}