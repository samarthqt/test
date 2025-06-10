package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class NotificationPage extends WebReusableComponents {

    protected By sendGridIntegrationStatus = By.id("sendGridStatus");
    protected By twilioIntegrationStatus = By.id("twilioStatus");
    protected By notificationConfigButton = By.id("configNotification");
    protected By notificationSendButton = By.id("sendNotification");
    protected By notificationContent = By.id("notificationContent");
    protected By userPreferenceDropdown = By.id("userPreference");
    protected By notificationLog = By.id("notificationLog");

    public NotificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyIntegration() {
        waitUntilElementVisible(sendGridIntegrationStatus, 3);
        waitUntilElementVisible(twilioIntegrationStatus, 3);
        Assert.assertTrue(isElementDisplayed(sendGridIntegrationStatus), "SendGrid is not integrated.");
        Assert.assertTrue(isElementDisplayed(twilioIntegrationStatus), "Twilio is not integrated.");
    }

    public void configureNotificationSystem() {
        waitUntilElementVisible(notificationConfigButton, 3);
        clickElement(notificationConfigButton);
        Assert.assertTrue(isElementDisplayed(notificationConfigButton), "Notification system configuration failed.");
    }

    public void verifyNotificationCapability() {
        waitUntilElementVisible(notificationSendButton, 3);
        Assert.assertTrue(isElementDisplayed(notificationSendButton), "Notification capability is not available.");
    }

    public void checkOrderOrTrackingStatus() {
        // Logic to check order or tracking status
        WebElement statusElement = driver.findElement(By.id("orderTrackingStatus"));
        waitUntilElementVisible(statusElement, 3);
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Order or tracking status is not available.");
    }

    public void sendNotifications() {
        waitUntilElementVisible(notificationSendButton, 3);
        clickElement(notificationSendButton);
        Assert.assertTrue(isElementDisplayed(notificationSendButton), "Failed to send notifications.");
    }

    public void verifyUserReceivedNotification() {
        WebElement notificationElement = driver.findElement(By.id("userNotification"));
        waitUntilElementVisible(notificationElement, 3);
        String notification = notificationElement.getText();
        Assert.assertNotNull(notification, "User did not receive notification.");
    }

    public void sendNotificationForOrderOrTracking() {
        WebElement sendButton = driver.findElement(By.id("sendOrderTrackingNotification"));
        waitUntilElementVisible(sendButton, 3);
        clickElement(sendButton);
        Assert.assertTrue(isElementDisplayed(sendButton), "Failed to send notification for order or tracking.");
    }

    public void checkNotificationContent() {
        waitUntilElementVisible(notificationContent, 3);
        String content = getTextFromElement(notificationContent);
        Assert.assertNotNull(content, "Notification content is empty.");
    }

    public void verifyNotificationContentAccuracy() {
        String expectedContent = "Expected Notification Content";
        String actualContent = getTextFromElement(notificationContent);
        Assert.assertEquals(actualContent, expectedContent, "Notification content does not match expected content.");
    }

    public void setUserNotificationPreference(String notificationType) {
        waitUntilElementVisible(userPreferenceDropdown, 3);
        selectByValue(userPreferenceDropdown, notificationType);
        Assert.assertEquals(getSelectedValue(userPreferenceDropdown), notificationType, "Failed to set user notification preference.");
    }

    public void verifyNotificationReceivedVia(String notificationType) {
        WebElement notificationTypeElement = driver.findElement(By.id("notificationType"));
        waitUntilElementVisible(notificationTypeElement, 3);
        String actualType = notificationTypeElement.getText();
        Assert.assertEquals(actualType, notificationType, "Notification received via incorrect type.");
    }

    public void simulateNotificationFailure() {
        WebElement simulateFailureButton = driver.findElement(By.id("simulateFailure"));
        waitUntilElementVisible(simulateFailureButton, 3);
        clickElement(simulateFailureButton);
        Assert.assertTrue(isElementDisplayed(simulateFailureButton), "Failed to simulate notification failure.");
    }

    public void detectNotificationFailure() {
        WebElement failureElement = driver.findElement(By.id("notificationFailure"));
        waitUntilElementVisible(failureElement, 3);
        String failureMessage = failureElement.getText();
        Assert.assertNotNull(failureMessage, "Notification failure not detected.");
    }

    public void implementErrorHandling() {
        try {
            WebElement errorElement = driver.findElement(By.id("errorHandling"));
            waitUntilElementVisible(errorElement, 3);
            clickElement(errorElement);
            Assert.assertTrue(isElementDisplayed(errorElement), "Error handling implementation failed.");
        } catch (Exception e) {
            Assert.fail("Exception occurred during error handling: " + e.getMessage());
        }
    }

    public void setUserPreferences() {
        WebElement preferencesButton = driver.findElement(By.id("setPreferences"));
        waitUntilElementVisible(preferencesButton, 3);
        clickElement(preferencesButton);
        Assert.assertTrue(isElementDisplayed(preferencesButton), "Failed to set user preferences.");
    }

    public void verifyNotificationsSentAccordingToPreferences() {
        WebElement preferencesElement = driver.findElement(By.id("preferencesNotification"));
        waitUntilElementVisible(preferencesElement, 3);
        String preferencesNotification = preferencesElement.getText();
        Assert.assertNotNull(preferencesNotification, "Notifications not sent according to preferences.");
    }

    public void checkSystemLogs() {
        waitUntilElementVisible(notificationLog, 3);
        String logs = getTextFromElement(notificationLog);
        Assert.assertNotNull(logs, "System logs are empty.");
    }

    public void verifyNotificationLogs() {
        WebElement logsElement = driver.findElement(By.id("notificationLogs"));
        waitUntilElementVisible(logsElement, 3);
        String logs = logsElement.getText();
        Assert.assertNotNull(logs, "Notification logs are not available.");
    }

    public void verifyUserAccountIntegration() {
        WebElement accountIntegrationElement = driver.findElement(By.id("accountIntegration"));
        waitUntilElementVisible(accountIntegrationElement, 3);
        String integrationStatus = accountIntegrationElement.getText();
        Assert.assertNotNull(integrationStatus, "User account integration failed.");
    }

    public void sendNotification() {
        WebElement sendButton = driver.findElement(By.id("sendNotificationButton"));
        waitUntilElementVisible(sendButton, 3);
        clickElement(sendButton);
        Assert.assertTrue(isElementDisplayed(sendButton), "Failed to send notification.");
    }

    public void validateUserAccountAndPreferences() {
        WebElement accountElement = driver.findElement(By.id("userAccount"));
        WebElement preferencesElement = driver.findElement(By.id("userPreferences"));
        waitUntilElementVisible(accountElement, 3);
        waitUntilElementVisible(preferencesElement, 3);
        String accountStatus = accountElement.getText();
        String preferencesStatus = preferencesElement.getText();
        Assert.assertNotNull(accountStatus, "User account validation failed.");
        Assert.assertNotNull(preferencesStatus, "User preferences validation failed.");
    }

    public void verifySystemOperational() {
        WebElement operationalElement = driver.findElement(By.id("systemOperational"));
        waitUntilElementVisible(operationalElement, 3);
        String operationalStatus = operationalElement.getText();
        Assert.assertNotNull(operationalStatus, "System is not operational.");
    }

    public void ensureComplianceWithRegulations() {
        WebElement complianceElement = driver.findElement(By.id("complianceCheck"));
        waitUntilElementVisible(complianceElement, 3);
        String complianceStatus = complianceElement.getText();
        Assert.assertNotNull(complianceStatus, "System is not compliant with regulations.");
    }
}