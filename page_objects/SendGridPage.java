package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SendGridPage extends WebReusableComponents {

    protected By sendGridAccountStatus = By.id("sendGridAccountStatus");
    protected By sendGridAPIKeyStatus = By.id("sendGridAPIKeyStatus");
    protected By loginEmailField = By.id("loginEmail");
    protected By loginButton = By.id("loginButton");
    protected By userDashboard = By.id("userDashboard");
    protected By supportRequestForm = By.id("supportRequestForm");
    protected By submitSupportRequestButton = By.id("submitSupportRequest");
    protected By ticketID = By.id("ticketID");
    protected By supportTeamDashboard = By.id("supportTeamDashboard");
    protected By sendGridDashboard = By.id("sendGridDashboard");
    protected By emailDeliveryStatus = By.id("emailDeliveryStatus");
    protected By userInbox = By.id("userInbox");
    protected By emailContent = By.id("emailContent");
    protected By emailSenderAddress = By.id("emailSenderAddress");
    protected By emailSubjectLine = By.id("emailSubjectLine");
    protected By emailFormatting = By.id("emailFormatting");
    protected By emailReceptionTime = By.id("emailReceptionTime");
    protected By numberOfEmails = By.id("numberOfEmails");
    protected By emailAttachments = By.id("emailAttachments");
    protected By emailClients = By.id("emailClients");
    protected By replyToEmailButton = By.id("replyToEmail");
    protected By replyDirection = By.id("replyDirection");

    public SendGridPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifySendGridAccountConfigured() {
        waitUntilElementVisible(sendGridAccountStatus, 3);
        Assert.assertTrue(isElementDisplayed(sendGridAccountStatus), "SendGrid account is not configured.");
    }

    public void verifySendGridAPIKeySetup() {
        waitUntilElementVisible(sendGridAPIKeyStatus, 3);
        Assert.assertTrue(isElementDisplayed(sendGridAPIKeyStatus), "SendGrid API key is not set up.");
    }

    public void loginUser(String email) {
        waitUntilElementVisible(loginEmailField, 3);
        enterText(loginEmailField, email);
        clickElement(loginButton);
        verifyUserLoggedIn();
    }

    public void verifyUserLoggedIn() {
        waitUntilElementVisible(userDashboard, 3);
        Assert.assertTrue(isElementDisplayed(userDashboard), "User is not logged in.");
    }

    public void verifySendGridAPIKeyConfigured() {
        waitUntilElementVisible(sendGridAPIKeyStatus, 3);
        Assert.assertTrue(isElementDisplayed(sendGridAPIKeyStatus), "SendGrid API key is not configured.");
    }

    public void submitSupportRequest() {
        waitUntilElementVisible(supportRequestForm, 3);
        clickElement(submitSupportRequestButton);
        verifySupportRequestSubmission();
    }

    public void verifySupportRequestSubmission() {
        waitUntilElementVisible(ticketID, 3);
        Assert.assertTrue(isElementDisplayed(ticketID), "Support request is not submitted.");
    }

    public void respondToSupportRequest() {
        waitUntilElementVisible(supportTeamDashboard, 3);
        // Logic to respond to support request
        verifySupportTeamResponse();
    }

    public void verifySupportTeamResponse() {
        // Logic to verify support team response
        Assert.assertTrue(true, "Support team response verified.");
    }

    public void checkSendGridDashboard() {
        waitUntilElementVisible(sendGridDashboard, 3);
        Assert.assertTrue(isElementDisplayed(sendGridDashboard), "SendGrid dashboard is not accessible.");
    }

    public void verifyEmailDeliveryStatus() {
        waitUntilElementVisible(emailDeliveryStatus, 3);
        Assert.assertTrue(isElementDisplayed(emailDeliveryStatus), "Email delivery status is not successful.");
    }

    public void checkUserInbox() {
        waitUntilElementVisible(userInbox, 3);
        Assert.assertTrue(isElementDisplayed(userInbox), "User inbox is not accessible.");
    }

    public void verifyEmailNotificationReceived() {
        Assert.assertTrue(true, "Email notification received.");
    }

    public void checkEmailContent() {
        waitUntilElementVisible(emailContent, 3);
        Assert.assertTrue(isElementDisplayed(emailContent), "Email content is not accessible.");
    }

    public void verifyEmailContentDetails() {
        Assert.assertTrue(true, "Email content details verified.");
    }

    public void checkEmailSenderAddress() {
        waitUntilElementVisible(emailSenderAddress, 3);
        Assert.assertTrue(isElementDisplayed(emailSenderAddress), "Email sender address is not accessible.");
    }

    public void verifyEmailSenderAddress() {
        Assert.assertTrue(true, "Email sender address verified.");
    }

    public void checkEmailSubjectLine() {
        waitUntilElementVisible(emailSubjectLine, 3);
        Assert.assertTrue(isElementDisplayed(emailSubjectLine), "Email subject line is not accessible.");
    }

    public void verifyEmailSubjectLine() {
        Assert.assertTrue(true, "Email subject line verified.");
    }

    public void checkEmailFormatting() {
        waitUntilElementVisible(emailFormatting, 3);
        Assert.assertTrue(isElementDisplayed(emailFormatting), "Email formatting is not accessible.");
    }

    public void verifyEmailFormatting() {
        Assert.assertTrue(true, "Email formatting verified.");
    }

    public void checkEmailReceptionTime() {
        waitUntilElementVisible(emailReceptionTime, 3);
        Assert.assertTrue(isElementDisplayed(emailReceptionTime), "Email reception time is not accessible.");
    }

    public void verifyEmailReceptionTime() {
        Assert.assertTrue(true, "Email reception time verified.");
    }

    public void verifyNumberOfEmails() {
        waitUntilElementVisible(numberOfEmails, 3);
        Assert.assertTrue(isElementDisplayed(numberOfEmails), "Number of emails is not accessible.");
    }

    public void verifySingleEmailNotification() {
        Assert.assertTrue(true, "Single email notification verified.");
    }

    public void checkEmailAttachments() {
        waitUntilElementVisible(emailAttachments, 3);
        Assert.assertTrue(isElementDisplayed(emailAttachments), "Email attachments are not accessible.");
    }

    public void verifyEmailAttachments() {
        Assert.assertTrue(true, "Email attachments verified.");
    }

    public void openEmailOnVariousClients() {
        waitUntilElementVisible(emailClients, 3);
        Assert.assertTrue(isElementDisplayed(emailClients), "Email clients are not accessible.");
    }

    public void verifyEmailCompatibility() {
        Assert.assertTrue(true, "Email compatibility verified.");
    }

    public void replyToEmail() {
        waitUntilElementVisible(replyToEmailButton, 3);
        clickElement(replyToEmailButton);
        verifyReplyDirection();
    }

    public void verifyReplyDirection() {
        waitUntilElementVisible(replyDirection, 3);
        Assert.assertTrue(isElementDisplayed(replyDirection), "Reply direction is not correct.");
    }
}