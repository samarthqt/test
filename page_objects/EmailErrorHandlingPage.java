package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailErrorHandlingPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By billingPlanModule = By.id("billingPlanModule");
    protected By billingPlanIDField = By.id("billingPlanID");
    protected By billingStatusDropdown = By.id("billingStatus");
    protected By triggerBillingDocumentButton = By.id("triggerBillingDocument");
    protected By emailCommunicationModule = By.id("emailCommunicationModule");
    protected By emailSearchField = By.id("emailSearchField");
    protected By emailStatusField = By.id("emailStatusField");
    protected By emailErrorMessageField = By.id("emailErrorMessageField");
    protected By systemLogsButton = By.id("systemLogsButton");
    protected By manualResendButton = By.id("manualResendButton");
    protected By correctEmailSettingsButton = By.id("correctEmailSettingsButton");
    protected By resendEmailButton = By.id("resendEmailButton");
    protected By emailBillingLinkageField = By.id("emailBillingLinkageField");

    public void loginToSystem() {
        waitUntilElementVisible(loginButton, 5);
        clickElement(loginButton);
    }

    public void navigateToBillingPlanModule() {
        waitUntilElementVisible(billingPlanModule, 5);
        clickElement(billingPlanModule);
    }

    public void setBillingPlanID(String billingPlanID, String billingStatus) {
        waitUntilElementVisible(billingPlanIDField, 3);
        enterText(billingPlanIDField, billingPlanID);
        selectByValue(billingStatusDropdown, billingStatus);
    }

    public void triggerBillingDocumentCreation() {
        waitUntilElementVisible(triggerBillingDocumentButton, 3);
        clickElement(triggerBillingDocumentButton);
    }

    public void verifyBillingDocumentCreation() {
        // Add logic to verify billing document creation
        Assert.assertTrue(isElementPresent(By.id("billingDocumentSuccess")), "Billing document creation failed.");
    }

    public void navigateToEmailCommunicationModule() {
        waitUntilElementVisible(emailCommunicationModule, 3);
        clickElement(emailCommunicationModule);
    }

    public void searchEmailRecord(String billingPlanID) {
        waitUntilElementVisible(emailSearchField, 3);
        enterText(emailSearchField, billingPlanID);
        pressEnter(emailSearchField);
    }

    public void verifyEmailRecordStatus(String emailStatus) {
        waitUntilElementVisible(emailStatusField, 3);
        String actualStatus = getTextFromElement(emailStatusField);
        Assert.assertEquals(actualStatus, emailStatus, "Email status does not match.");
    }

    public void verifyEmailErrorMessage(String errorMessage) {
        waitUntilElementVisible(emailErrorMessageField, 3);
        String actualMessage = getTextFromElement(emailErrorMessageField);
        Assert.assertEquals(actualMessage, errorMessage, "Error message does not match.");
    }

    public void reviewSystemLogs() {
        waitUntilElementVisible(systemLogsButton, 3);
        clickElement(systemLogsButton);
    }

    public void verifySystemLogsForMisconfiguration() {
        // Add logic to verify system logs for misconfiguration
        Assert.assertTrue(isElementPresent(By.id("misconfigurationLog")), "System logs do not provide details on misconfiguration.");
    }

    public void attemptManualEmailResend() {
        waitUntilElementVisible(manualResendButton, 3);
        clickElement(manualResendButton);
    }

    public void verifyManualResendPrevention() {
        // Add logic to verify manual resend prevention
        Assert.assertTrue(isElementPresent(By.id("resendPreventionMessage")), "Manual resend was not prevented.");
    }

    public void correctEmailSettingsAndResend() {
        waitUntilElementVisible(correctEmailSettingsButton, 3);
        clickElement(correctEmailSettingsButton);
        waitUntilElementVisible(resendEmailButton, 3);
        clickElement(resendEmailButton);
    }

    public void verifyEmailResentSuccessfully() {
        // Add logic to verify email was successfully resent
        Assert.assertTrue(isElementPresent(By.id("emailResentSuccess")), "Email was not successfully resent.");
    }

    public void verifyEmailBillingLinkage(String linkageStatus) {
        waitUntilElementVisible(emailBillingLinkageField, 3);
        String actualLinkageStatus = getTextFromElement(emailBillingLinkageField);
        Assert.assertEquals(actualLinkageStatus, linkageStatus, "Email and Billing document linkage status does not match.");
    }

    public void verifyErrorHandlingWorkflow() {
        // Add logic to verify overall workflow
        Assert.assertTrue(isElementPresent(By.id("workflowVerification")), "Error handling workflow verification failed.");
    }
}