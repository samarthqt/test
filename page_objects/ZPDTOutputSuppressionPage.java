package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ZPDTOutputSuppressionPage extends WebReusableComponents {

    protected By sapLoginUsername = By.id("sapUsername");
    protected By sapLoginPassword = By.id("sapPassword");
    protected By btnLogin = By.id("loginButton");
    protected By masterDataScreen = By.id("masterDataScreen");
    protected By attribute7Field = By.id("attribute7");
    protected By btnSaveChanges = By.id("saveChanges");
    protected By btnCreateBillingDocument = By.id("createBillingDocument");
    protected By btnTriggerOutputDetermination = By.id("triggerOutputDetermination");
    protected By outputLog = By.id("outputLog");
    protected By documentFlow = By.id("documentFlow");
    protected By systemLogs = By.id("systemLogs");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(sapLoginUsername, 3);
        enterText(sapLoginUsername, username);
        enterText(sapLoginPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToPayerBusinessPartnerMasterData(String payerBusinessPartnerID) {
        waitUntilElementVisible(masterDataScreen, 3);
        enterText(masterDataScreen, payerBusinessPartnerID);
        clickElement(masterDataScreen);
    }

    public void openMasterDataScreen() {
        waitUntilElementVisible(masterDataScreen, 3);
        clickElement(masterDataScreen);
    }

    public void locateAttribute7Field() {
        waitUntilElementVisible(attribute7Field, 3);
    }

    public void setAttribute7Value(String value) {
        waitUntilElementVisible(attribute7Field, 3);
        enterText(attribute7Field, value);
    }

    public void saveChanges() {
        waitUntilElementVisible(btnSaveChanges, 3);
        clickElement(btnSaveChanges);
    }

    public void createBillingDocument() {
        waitUntilElementVisible(btnCreateBillingDocument, 3);
        clickElement(btnCreateBillingDocument);
    }

    public void triggerOutputDetermination() {
        waitUntilElementVisible(btnTriggerOutputDetermination, 3);
        clickElement(btnTriggerOutputDetermination);
    }

    public void verifyOutputLog(String expectedStatus) {
        waitUntilElementVisible(outputLog, 3);
        String actualStatus = getTextFromElement(outputLog);
        Assert.assertEquals(actualStatus, expectedStatus, "Output suppression status does not match.");
    }

    public void verifyDocumentFlowNoInvoice() {
        waitUntilElementVisible(documentFlow, 3);
        String documentFlowText = getTextFromElement(documentFlow);
        Assert.assertFalse(documentFlowText.contains("Invoice"), "Document flow shows an invoice sent to the customer.");
    }

    public void verifySystemLogsNoErrors() {
        waitUntilElementVisible(systemLogs, 3);
        String systemLogsText = getTextFromElement(systemLogs);
        Assert.assertFalse(systemLogsText.contains("Error"), "System logs indicate errors in the process.");
    }
}