package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailCommunicationPage extends WebReusableComponents {

    protected By loginPageIdentifier = By.id("loginPage");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By dashboardIdentifier = By.id("dashboard");
    protected By billingDocumentModuleLink = By.id("billingDocumentModule");
    protected By billingDocumentSearchField = By.id("billingDocumentSearch");
    protected By billingDocumentDetailsIdentifier = By.id("billingDocumentDetails");
    protected By emailCommunicationModuleLink = By.id("emailCommunicationModule");
    protected By emailRecordSearchField = By.id("emailRecordSearch");
    protected By emailRecordStatusField = By.id("emailRecordStatus");
    protected By errorMessageField = By.id("errorMessage");
    protected By systemLogsLink = By.id("systemLogs");
    protected By manualResendButton = By.id("manualResendButton");
    protected By emailSettingsField = By.id("emailSettings");
    protected By emailResendButton = By.id("emailResendButton");

    public void navigateToLoginPage() {
        launchUrl("https://sap-s4hana-cloud-login.com");
        waitUntilElementVisible(loginPageIdentifier, 5);
    }

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboardIdentifier, 5);
        Assert.assertTrue(isElementDisplayed(dashboardIdentifier), "Dashboard is not displayed.");
    }

    public void navigateToBillingDocumentModule() {
        waitUntilElementVisible(billingDocumentModuleLink, 3);
        clickElement(billingDocumentModuleLink);
    }

    public void verifyBillingDocumentModuleDisplayed() {
        waitUntilElementVisible(billingDocumentSearchField, 3);
        Assert.assertTrue(isElementDisplayed(billingDocumentSearchField), "Billing document module is not displayed.");
    }

    public void searchBillingDocument(String billingDocumentID) {
        waitUntilElementVisible(billingDocumentSearchField, 3);
        enterText(billingDocumentSearchField, billingDocumentID);
        pressEnter(billingDocumentSearchField);
    }

    public void verifyBillingDocumentDetails(String billingDocumentID) {
        waitUntilElementVisible(billingDocumentDetailsIdentifier, 3);
        Assert.assertTrue(getTextFromElement(billingDocumentDetailsIdentifier).contains(billingDocumentID), "Billing document details are not displayed correctly.");
    }

    public void verifyBillingDocumentDetailsPageDisplayed() {
        waitUntilElementVisible(billingDocumentDetailsIdentifier, 3);
        Assert.assertTrue(isElementDisplayed(billingDocumentDetailsIdentifier), "Billing document details page is not displayed.");
    }

    public void navigateToEmailCommunicationModule() {
        waitUntilElementVisible(emailCommunicationModuleLink, 3);
        clickElement(emailCommunicationModuleLink);
    }

    public void verifyEmailCommunicationModuleDisplayed() {
        waitUntilElementVisible(emailRecordSearchField, 3);
        Assert.assertTrue(isElementDisplayed(emailRecordSearchField), "Email communication module is not displayed.");
    }

    public void searchEmailRecord(String billingDocumentID) {
        waitUntilElementVisible(emailRecordSearchField, 3);
        enterText(emailRecordSearchField, billingDocumentID);
        pressEnter(emailRecordSearchField);
    }

    public void verifyEmailRecordStatus(String status) {
        waitUntilElementVisible(emailRecordStatusField, 3);
        Assert.assertEquals(getTextFromElement(emailRecordStatusField), status, "Email record status does not match.");
    }

    public void viewErrorMessage() {
        waitUntilElementVisible(errorMessageField, 3);
        clickElement(errorMessageField);
    }

    public void verifyErrorMessageContent(String expectedMessage) {
        waitUntilElementVisible(errorMessageField, 3);
        Assert.assertEquals(getTextFromElement(errorMessageField), expectedMessage, "Error message content does not match.");
    }

    public void reviewSystemLogsForError() {
        waitUntilElementVisible(systemLogsLink, 3);
        clickElement(systemLogsLink);
    }

    public void verifySystemLogsForMisconfigurationDetails() {
        waitUntilElementVisible(systemLogsLink, 3);
        Assert.assertTrue(getTextFromElement(systemLogsLink).contains("Misconfiguration"), "System logs do not provide detailed information on the misconfiguration.");
    }

    public void attemptManualResend() {
        waitUntilElementVisible(manualResendButton, 3);
        clickElement(manualResendButton);
    }

    public void verifyManualResendBlocked() {
        waitUntilElementVisible(errorMessageField, 3);
        Assert.assertTrue(getTextFromElement(errorMessageField).contains("Manual resend blocked"), "System did not prevent manual resend.");
    }

    public void correctEmailSettings() {
        waitUntilElementVisible(emailSettingsField, 3);
        enterText(emailSettingsField, "CorrectSettings");
        clickElement(emailResendButton);
    }

    public void verifyEmailResentSuccessfully() {
        waitUntilElementVisible(emailRecordStatusField, 3);
        Assert.assertEquals(getTextFromElement(emailRecordStatusField), "Sent", "Email was not successfully resent.");
    }

    public void verifyEmailBillingDocumentLinkage(String billingDocumentID) {
        waitUntilElementVisible(emailRecordSearchField, 3);
        Assert.assertTrue(getTextFromElement(emailRecordSearchField).contains(billingDocumentID), "Linkage between email and Billing document is not accurate.");
    }

    public void verifyErrorHandlingForBillingDocument(String billingDocumentID) {
        waitUntilElementVisible(emailRecordSearchField, 3);
        Assert.assertTrue(getTextFromElement(emailRecordSearchField).contains(billingDocumentID), "Error handling for Billing document is not verified.");
    }

    public void reviewErrorHandlingWorkflow() {
        waitUntilElementVisible(systemLogsLink, 3);
        clickElement(systemLogsLink);
    }

    public void verifyWorkflowErrorHandling() {
        waitUntilElementVisible(systemLogsLink, 3);
        Assert.assertTrue(getTextFromElement(systemLogsLink).contains("Error handling workflow verified"), "Workflow error handling is not functioning correctly.");
    }

    public void verifyEmailSettingsCorrected(String billingDocumentID) {
        waitUntilElementVisible(emailSettingsField, 3);
        Assert.assertTrue(getTextFromElement(emailSettingsField).contains("CorrectSettings"), "Email settings for Billing document " + billingDocumentID + " have not been corrected.");
    }

    public void reviewSystemLogs() {
        waitUntilElementVisible(systemLogsLink, 3);
        clickElement(systemLogsLink);
    }

    public void verifyLogsForCorrectionsAndDispatch() {
        waitUntilElementVisible(systemLogsLink, 3);
        Assert.assertTrue(getTextFromElement(systemLogsLink).contains("Corrections and successful email dispatch confirmed"), "System logs do not confirm corrections and successful email dispatch.");
    }
}