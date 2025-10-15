package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailDispatchPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingPlanModule = By.id("billingPlanModule");
    protected By lastBillingPlanStatus = By.id("lastBillingPlanStatus");
    protected By btnCreateBillingDocument = By.id("createBillingDocument");
    protected By emailDispatchLogs = By.id("emailDispatchLogs");
    protected By emailAttachment = By.id("emailAttachment");
    protected By emailSubject = By.id("emailSubject");
    protected By emailBody = By.id("emailBody");
    protected By recipientEmail = By.id("recipientEmail");
    protected By emailTimestamp = By.id("emailTimestamp");
    protected By emailQueue = By.id("emailQueue");
    protected By systemLogs = By.id("systemLogs");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void loginToSystem() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(billingPlanModule), "Login was not successful.");
    }

    public void ensureUserIsLoggedIn() {
        if (!isElementVisible(billingPlanModule)) {
            loginToSystem();
        }
    }

    public void navigateToBillingPlanModule() {
        waitUntilElementVisible(billingPlanModule, 3);
        clickElement(billingPlanModule);
    }

    public void verifyLastBillingPlanStatus(String status) {
        String actualStatus = getTextFromElement(lastBillingPlanStatus);
        Assert.assertEquals(actualStatus, status, "Last billing plan status does not match.");
    }

    public void ensureLastBillingPlanIsDue() {
        verifyLastBillingPlanStatus("Due");
    }

    public void triggerBillingDocumentCreation() {
        waitUntilElementVisible(btnCreateBillingDocument, 3);
        clickElement(btnCreateBillingDocument);
    }

    public void verifyBillingDocumentCreation() {
        Assert.assertTrue(isElementVisible(emailDispatchLogs), "Billing document creation was not successful.");
    }

    public void ensureBillingDocumentIsCreated() {
        verifyBillingDocumentCreation();
    }

    public void checkEmailDispatchLogs() {
        waitUntilElementVisible(emailDispatchLogs, 3);
        clickElement(emailDispatchLogs);
    }

    public void verifyEmailDispatchLogs() {
        Assert.assertTrue(isElementVisible(emailAttachment), "Email dispatch logs do not display successful dispatch.");
    }

    public void ensureEmailDispatchLogsSuccess() {
        verifyEmailDispatchLogs();
    }

    public void verifyCustomerEmailReceipt() {
        Assert.assertTrue(isElementVisible(emailAttachment), "Customer did not receive the email.");
    }

    public void verifyBillingFormAttachment() {
        Assert.assertTrue(isElementVisible(emailAttachment), "Billing form attachment is not present.");
    }

    public void ensureEmailWithBillingFormReceived() {
        verifyBillingFormAttachment();
    }

    public void validateBillingFormAttachment() {
        Assert.assertTrue(isElementVisible(emailAttachment), "Billing form attachment validation failed.");
    }

    public void verifyBillingFormDetails() {
        Assert.assertTrue(isElementVisible(emailAttachment), "Billing form details are not accurate.");
    }

    public void ensureEmailDispatchedToCustomer() {
        Assert.assertTrue(isElementVisible(emailSubject), "Email was not dispatched to the customer.");
    }

    public void reviewEmailSubjectAndBody() {
        Assert.assertTrue(isElementVisible(emailSubject), "Email subject is not visible.");
        Assert.assertTrue(isElementVisible(emailBody), "Email body is not visible.");
    }

    public void verifyEmailSubjectAndBody() {
        Assert.assertTrue(isElementVisible(emailSubject), "Email subject is not accurate.");
        Assert.assertTrue(isElementVisible(emailBody), "Email body is not accurate.");
    }

    public void validateRecipientEmailAddress() {
        Assert.assertTrue(isElementVisible(recipientEmail), "Recipient email address validation failed.");
    }

    public void verifyCorrectRecipientEmailAddress() {
        Assert.assertTrue(isElementVisible(recipientEmail), "Email was not sent to the correct address.");
    }

    public void checkEmailTimestamp() {
        Assert.assertTrue(isElementVisible(emailTimestamp), "Email timestamp is not visible.");
    }

    public void verifyEmailTimestamp() {
        Assert.assertTrue(isElementVisible(emailTimestamp), "Email timestamp does not align with billing document creation time.");
    }

    public void ensureEmailDispatchProcessCompleted() {
        Assert.assertTrue(isElementVisible(emailQueue), "Email dispatch process is not completed.");
    }

    public void checkEmailQueue() {
        Assert.assertTrue(isElementVisible(emailQueue), "Email queue is not visible.");
    }

    public void verifyNoPendingOrFailedEmails() {
        Assert.assertTrue(isElementVisible(emailQueue), "Pending or failed emails found in the queue.");
    }

    public void initiateEmailDispatchProcess() {
        Assert.assertTrue(isElementVisible(emailQueue), "Email dispatch process initiation failed.");
    }

    public void monitorEmailDispatchProcess() {
        Assert.assertTrue(isElementVisible(emailQueue), "Email dispatch process monitoring failed.");
    }

    public void verifyNoSystemErrorsInEmailDispatch() {
        Assert.assertTrue(isElementVisible(emailQueue), "System errors occurred during email dispatch.");
    }

    public void checkSystemLogs() {
        Assert.assertTrue(isElementVisible(systemLogs), "System logs are not visible.");
    }

    public void verifyEmailDispatchLogged() {
        Assert.assertTrue(isElementVisible(systemLogs), "Email dispatch is not logged in the system.");
    }
}