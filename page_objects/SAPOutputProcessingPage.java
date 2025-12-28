package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPOutputProcessingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By homeScreen = By.id("homeScreen");
    protected By billingDocumentCreationScreen = By.id("billingDocumentCreationScreen");
    protected By outputProcessingScreen = By.id("outputProcessingScreen");
    protected By billingDocumentTypeDropdown = By.id("billingDocumentType");
    protected By txtCustomer = By.id("customer");
    protected By txtItems = By.id("items");
    protected By txtAmounts = By.id("amounts");
    protected By btnSaveBillingDocument = By.id("saveBillingDocument");
    protected By btnTriggerOutputProcess = By.id("triggerOutputProcess");
    protected By errorLogs = By.id("errorLogs");
    protected By finalOutput = By.id("finalOutput");

    public void authorizeUser(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void loginToSAP() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomeScreenNavigation() {
        waitUntilElementVisible(homeScreen, 3);
        Assert.assertTrue(isElementDisplayed(homeScreen), "User is not on the SAP home screen.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(homeScreen), "User is not logged into the SAP system.");
    }

    public void navigateToBillingDocumentCreation() {
        clickElement(billingDocumentCreationScreen);
    }

    public void verifyBillingDocumentCreationScreen() {
        waitUntilElementVisible(billingDocumentCreationScreen, 3);
        Assert.assertTrue(isElementDisplayed(billingDocumentCreationScreen), "Billing document creation screen is not displayed.");
    }

    public void enterBillingDocumentDetails(String billingDocumentType, String customer, String items, String amounts) {
        waitUntilElementVisible(billingDocumentTypeDropdown, 3);
        selectByValue(billingDocumentTypeDropdown, billingDocumentType);
        enterText(txtCustomer, customer);
        enterText(txtItems, items);
        enterText(txtAmounts, amounts);
    }

    public void saveBillingDocument() {
        waitUntilElementVisible(btnSaveBillingDocument, 3);
        clickElement(btnSaveBillingDocument);
    }

    public void verifyBillingDocumentCreation() {
        Assert.assertTrue(isElementDisplayed(By.id("documentNumber")), "Billing document creation failed.");
    }

    public void navigateToOutputProcessingScreen() {
        clickElement(outputProcessingScreen);
    }

    public void verifyOutputProcessingScreen() {
        waitUntilElementVisible(outputProcessingScreen, 3);
        Assert.assertTrue(isElementDisplayed(outputProcessingScreen), "Output processing screen is not displayed.");
    }

    public void triggerOutputProcess() {
        waitUntilElementVisible(btnTriggerOutputProcess, 3);
        clickElement(btnTriggerOutputProcess);
    }

    public void verifyOutputProcessTriggered() {
        Assert.assertTrue(isElementDisplayed(By.id("outputSuccess")), "Output process was not triggered successfully.");
    }

    public void simulateSDInvoicePrintError() {
        disableProgram("SD_INVOICE_PRINT01");
    }

    public void verifySDInvoicePrintFailure() {
        Assert.assertTrue(isElementDisplayed(By.id("programFailure")), "SD_INVOICE_PRINT01 program did not fail as expected.");
    }

    public void checkSystemResponse() {
        Assert.assertTrue(isElementDisplayed(By.id("errorMessage")), "System response does not indicate print program failure.");
    }

    public void verifyErrorMessagesLogged() {
        Assert.assertTrue(isElementDisplayed(errorLogs), "Error messages are not logged.");
    }

    public void checkFallbackMechanisms() {
        Assert.assertTrue(isElementDisplayed(By.id("fallbackMechanisms")), "Fallback mechanisms are not provided.");
    }

    public void verifyFallbackMechanisms() {
        Assert.assertTrue(isElementDisplayed(By.id("fallbackSuccess")), "Fallback mechanisms are not functioning correctly.");
    }

    public void verifyErrorLogs() {
        waitUntilElementVisible(errorLogs, 3);
        Assert.assertTrue(isElementDisplayed(errorLogs), "Error logs are not visible.");
    }

    public void verifyErrorLogsInsights() {
        String errorDetails = getTextFromElement(errorLogs);
        Assert.assertTrue(errorDetails.contains("SD_INVOICE_PRINT01 failure"), "Error logs do not provide detailed insights.");
    }

    public void resolveSDInvoicePrintIssue() {
        enableProgram("SD_INVOICE_PRINT01");
    }

    public void reTriggerOutputProcess() {
        triggerOutputProcess();
    }

    public void verifyOutputProcessReTriggered() {
        Assert.assertTrue(isElementDisplayed(By.id("outputReTriggered")), "Output process was not re-triggered successfully.");
    }

    public void verifyFinalOutput() {
        String finalOutputData = getTextFromElement(finalOutput);
        Assert.assertTrue(finalOutputData.contains("ZPB1"), "Final output does not match the ZPB1 form template.");
    }
}