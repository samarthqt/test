
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShipmentTrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = trackingField)
    private WebElement trackingField;

    @FindBy(id = trackButton)
    private WebElement trackButton;

    @FindBy(id = statusField)
    private WebElement statusField;

    @FindBy(id = updateStatusButton)
    private WebElement updateStatusButton;

    @FindBy(id = timestampField)
    private WebElement timestampField;

    @FindBy(id = refreshButton)
    private WebElement refreshButton;

    @FindBy(id = logoutButton)
    private WebElement logoutButton;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    @FindBy(id = notificationSettings)
    private WebElement notificationSettings;

    @FindBy(id = networkIssueButton)
    private WebElement networkIssueButton;

    @FindBy(id = shipmentHistoryLog)
    private WebElement shipmentHistoryLog;

    @FindBy(id = errorMessage)
    private WebElement errorMessage;

    @FindBy(id = smsVerificationButton)
    private WebElement smsVerificationButton;

    @FindBy(id = systemRebootCheck)
    private WebElement systemRebootCheck;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilVisible(trackingField);
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
    }

    public void clickTrackButton() {
        waitUntilClickable(trackButton);
        trackButton.click();
    }

    public String getCurrentStatus() {
        waitUntilVisible(statusField);
        String status = statusField.getText();
        Assert.assertNotNull(status, Status should not be null);
        return status;
    }

    public void updateStatus(String newStatus) {
        waitUntilVisible(statusField);
        statusField.clear();
        statusField.sendKeys(newStatus);
        waitUntilClickable(updateStatusButton);
        updateStatusButton.click();
    }

    public String getLatestTimestamp() {
        waitUntilVisible(timestampField);
        String timestamp = timestampField.getText();
        Assert.assertNotNull(timestamp, Timestamp should not be null);
        return timestamp;
    }

    public void refreshPage() {
        waitUntilClickable(refreshButton);
        refreshButton.click();
    }

    public void logoutAndLogin() {
        waitUntilClickable(logoutButton);
        logoutButton.click();
        waitUntilClickable(loginButton);
        loginButton.click();
    }

    public boolean checkNotificationSettings() {
        waitUntilVisible(notificationSettings);
        boolean isDisplayed = notificationSettings.isDisplayed();
        Assert.assertTrue(isDisplayed, Notification settings should be displayed);
        return isDisplayed;
    }

    public void simulateNetworkIssue() {
        waitUntilClickable(networkIssueButton);
        networkIssueButton.click();
    }

    public String getShipmentHistoryLog() {
        waitUntilVisible(shipmentHistoryLog);
        String historyLog = shipmentHistoryLog.getText();
        Assert.assertNotNull(historyLog, Shipment history log should not be null);
        return historyLog;
    }

    public String getErrorMessage() {
        waitUntilVisible(errorMessage);
        String error = errorMessage.getText();
        Assert.assertNotNull(error, Error message should not be null);
        return error;
    }

    public void verifyStatusViaSMS() {
        waitUntilClickable(smsVerificationButton);
        smsVerificationButton.click();
    }

    public void checkStatusAfterSystemReboot() {
        waitUntilClickable(systemRebootCheck);
        systemRebootCheck.click();
    }

    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
