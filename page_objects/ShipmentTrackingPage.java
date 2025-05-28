package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipmentTrackingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = trackingField)
    private WebElement trackingField;

    @FindBy(id = locationField)
    private WebElement locationField;

    @FindBy(id = okButton)
    private WebElement okButton;

    @FindBy(id = currentStatus)
    private WebElement currentStatus;

    @FindBy(id = statusUpdateField)
    private WebElement statusUpdateField;

    @FindBy(id = timestamp)
    private WebElement timestamp;

    @FindBy(id = refreshButton)
    private WebElement refreshButton;

    @FindBy(id = logoutButton)
    private WebElement logoutButton;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    @FindBy(id = notificationSettings)
    private WebElement notificationSettings;

    @FindBy(id = networkIssueSimulateButton)
    private WebElement networkIssueSimulateButton;

    @FindBy(id = shipmentHistoryLog)
    private WebElement shipmentHistoryLog;

    @FindBy(id = errorMessages)
    private WebElement errorMessages;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilVisible(trackingField);
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        Assert.assertFalse(trackingField.getText().isEmpty(), Shipment ID field should not be empty after entering data.);
    }

    public void selectLocation(String location) {
        waitUntilVisible(locationField);
        locationField.clear();
        locationField.sendKeys(location);
        Assert.assertFalse(locationField.getText().isEmpty(), Location field should not be empty after entering data.);
    }

    public void clickOkButton() {
        waitUntilClickable(okButton);
        okButton.click();
        Assert.assertTrue(okButton.isDisplayed(), OK button should be displayed after clicking.);
    }

    public String getCurrentStatus() {
        waitUntilVisible(currentStatus);
        String status = currentStatus.getText();
        Assert.assertNotNull(status, Current status should not be null.);
        return status;
    }

    public void simulateStatusUpdate(String status) {
        waitUntilVisible(statusUpdateField);
        statusUpdateField.clear();
        statusUpdateField.sendKeys(status);
        Assert.assertFalse(statusUpdateField.getText().isEmpty(), Status update field should not be empty after entering data.);
    }

    public String getTimestamp() {
        waitUntilVisible(timestamp);
        String time = timestamp.getText();
        Assert.assertNotNull(time, Timestamp should not be null.);
        return time;
    }

    public void refreshPage() {
        waitUntilClickable(refreshButton);
        refreshButton.click();
        Assert.assertTrue(refreshButton.isDisplayed(), Refresh button should be displayed after clicking.);
    }

    public void logout() {
        waitUntilClickable(logoutButton);
        logoutButton.click();
        Assert.assertTrue(logoutButton.isDisplayed(), Logout button should be displayed after clicking.);
    }

    public void login() {
        waitUntilClickable(loginButton);
        loginButton.click();
        Assert.assertTrue(loginButton.isDisplayed(), Login button should be displayed after clicking.);
    }

    public String getNotificationSettings() {
        waitUntilVisible(notificationSettings);
        String settings = notificationSettings.getText();
        Assert.assertNotNull(settings, Notification settings should not be null.);
        return settings;
    }

    public void simulateNetworkIssue() {
        waitUntilClickable(networkIssueSimulateButton);
        networkIssueSimulateButton.click();
        Assert.assertTrue(networkIssueSimulateButton.isDisplayed(), Network issue simulate button should be displayed after clicking.);
    }

    public String getShipmentHistoryLog() {
        waitUntilVisible(shipmentHistoryLog);
        String historyLog = shipmentHistoryLog.getText();
        Assert.assertNotNull(historyLog, Shipment history log should not be null.);
        return historyLog;
    }

    public String getErrorMessages() {
        waitUntilVisible(errorMessages);
        String errors = errorMessages.getText();
        Assert.assertNotNull(errors, Error messages should not be null.);
        return errors;
    }

    private void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}