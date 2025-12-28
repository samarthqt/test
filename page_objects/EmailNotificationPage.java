package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailNotificationPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By automatedLoadProcessModule = By.id("automatedLoadProcessModule");
    protected By btnUploadFile = By.id("uploadFileButton");
    protected By uploadedFile = By.id("uploadedFile");
    protected By btnTriggerProcess = By.id("triggerProcessButton");
    protected By processingStatus = By.id("processingStatus");
    protected By errorLog = By.id("errorLog");
    protected By emailNotificationQueue = By.id("emailNotificationQueue");
    protected By emailDispatchLogs = By.id("emailDispatchLogs");
    protected By emailContent = By.id("emailContent");
    protected By recipientList = By.id("recipientList");
    protected By systemLogs = By.id("systemLogs");
    protected By performanceMetrics = By.id("performanceMetrics");

    public void loginToSAPSystem() {
        launchUrl("https://sap-system-url.com");
        waitUntilElementVisible(txtUsername, 5);
        enterText(txtUsername, "validUsername");
        enterText(txtPassword, "validPassword");
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(automatedLoadProcessModule), "Login failed or user not redirected to dashboard.");
    }

    public void verifyAccessToSystem() {
        Assert.assertTrue(isElementVisible(automatedLoadProcessModule), "User does not have access to the system.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(automatedLoadProcessModule), "User is not logged in.");
    }

    public void navigateToAutomatedLoadProcessModule() {
        clickElement(automatedLoadProcessModule);
        waitUntilElementVisible(btnUploadFile, 5);
    }

    public void verifyAutomatedLoadProcessModuleDisplayed() {
        Assert.assertTrue(isElementVisible(btnUploadFile), "Automated load process module is not displayed.");
    }

    public void verifyInAutomatedLoadProcessModule() {
        Assert.assertTrue(isElementVisible(btnUploadFile), "User is not in the automated load process module.");
    }

    public void verifyPreparedInputFile(String fileName) {
        Assert.assertTrue(fileName.equals("error_file_01.txt"), "Prepared input file is not valid.");
    }

    public void uploadFile() {
        clickElement(btnUploadFile);
        waitUntilElementVisible(uploadedFile, 5);
    }

    public void verifyFileUploaded() {
        Assert.assertTrue(isElementVisible(uploadedFile), "File is not successfully uploaded.");
    }

    public void verifyFileUploadedWithErrors() {
        Assert.assertTrue(isElementVisible(uploadedFile), "Uploaded file does not contain errors.");
    }

    public void triggerAutomatedLoadProcess() {
        clickElement(btnTriggerProcess);
        waitUntilElementVisible(processingStatus, 5);
    }

    public void verifyFileProcessingStarted() {
        Assert.assertTrue(isElementVisible(processingStatus), "File processing did not start.");
    }

    public void verifyFileProcessingInProgress() {
        Assert.assertTrue(isElementVisible(processingStatus), "File is not being processed.");
    }

    public void verifyErrorsDetected() {
        Assert.assertTrue(isElementVisible(errorLog), "Errors were not detected in the file.");
    }

    public void verifyErrorsLogged() {
        Assert.assertTrue(isElementVisible(errorLog), "Errors were not logged by the system.");
    }

    public void verifyErrorsLoggedFromFile() {
        Assert.assertTrue(isElementVisible(errorLog), "Errors from the uploaded file were not logged.");
    }

    public void generateEmailNotifications() {
        clickElement(emailNotificationQueue);
        waitUntilElementVisible(emailNotificationQueue, 5);
    }

    public void verifyNotificationsQueued() {
        Assert.assertTrue(isElementVisible(emailNotificationQueue), "Notifications are not queued for dispatch.");
    }

    public void verifyNotificationsQueuedForDispatch() {
        Assert.assertTrue(isElementVisible(emailNotificationQueue), "Notifications are not queued for dispatch.");
    }

    public void checkEmailDispatchLogs() {
        clickElement(emailDispatchLogs);
        waitUntilElementVisible(emailDispatchLogs, 5);
    }

    public void verifyNotificationsSentToRecipients(String recipients) {
        String actualRecipients = getTextFromElement(emailDispatchLogs);
        Assert.assertEquals(actualRecipients, recipients, "Notifications were not sent to the intended recipients.");
    }

    public void verifyNotificationsSent() {
        Assert.assertTrue(isElementVisible(emailDispatchLogs), "Notifications were not sent.");
    }

    public void reviewEmailContent() {
        clickElement(emailContent);
        waitUntilElementVisible(emailContent, 5);
    }

    public void verifyEmailContentDetails() {
        String content = getTextFromElement(emailContent);
        Assert.assertTrue(content.contains("error details"), "Email content does not include error details.");
        Assert.assertTrue(content.contains("troubleshooting steps"), "Email content does not include troubleshooting steps.");
    }

    public void verifyEmailContentClarity() {
        String content = getTextFromElement(emailContent);
        Assert.assertTrue(content.contains("clear and actionable"), "Email content is not clear and actionable.");
    }

    public void verifyEmailNotificationsSent() {
        Assert.assertTrue(isElementVisible(emailDispatchLogs), "Email notifications were not sent.");
    }

    public void validateRecipientList() {
        clickElement(recipientList);
        waitUntilElementVisible(recipientList, 5);
    }

    public void verifyRecipientListMatchesConfiguredUsers(String configuredUsers) {
        String actualRecipients = getTextFromElement(recipientList);
        Assert.assertEquals(actualRecipients, configuredUsers, "Recipient list does not match configured users.");
    }

    public void verifyEmailNotificationsGenerated() {
        Assert.assertTrue(isElementVisible(emailNotificationQueue), "Email notifications were not generated.");
    }

    public void checkSystemLogs() {
        clickElement(systemLogs);
        waitUntilElementVisible(systemLogs, 5);
    }

    public void verifyNotificationEventLogged() {
        String logDetails = getTextFromElement(systemLogs);
        Assert.assertTrue(logDetails.contains("timestamp"), "Notification generation event is not logged with a timestamp.");
        Assert.assertTrue(logDetails.contains("error details"), "Notification generation event is not logged with error details.");
    }

    public void verifyEmailNotificationsDispatched() {
        Assert.assertTrue(isElementVisible(emailDispatchLogs), "Email notifications were not dispatched.");
    }

    public void reviewDispatchLogs() {
        clickElement(emailDispatchLogs);
        waitUntilElementVisible(emailDispatchLogs, 5);
    }

    public void verifyNoDuplicateOrMissingNotifications() {
        String dispatchLogs = getTextFromElement(emailDispatchLogs);
        Assert.assertFalse(dispatchLogs.contains("duplicate"), "Duplicate notifications found in dispatch logs.");
        Assert.assertFalse(dispatchLogs.contains("missing"), "Missing notifications found in dispatch logs.");
    }

    public void verifyEmailGenerationAndDispatching() {
        Assert.assertTrue(isElementVisible(emailNotificationQueue), "Email generation and dispatching is not in progress.");
    }

    public void monitorSystemPerformance() {
        clickElement(performanceMetrics);
        waitUntilElementVisible(performanceMetrics, 5);
    }

    public void verifySystemPerformanceLimits() {
        String performanceData = getTextFromElement(performanceMetrics);
        Assert.assertTrue(performanceData.contains("acceptable limits"), "System performance is not within acceptable limits.");
    }

    public EmailNotificationPage() {
        PageFactory.initElements(driver, this);
    }
}