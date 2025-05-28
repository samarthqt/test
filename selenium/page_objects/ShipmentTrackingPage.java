package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShipmentTrackingPage {

    private final WebDriver driver;

    @FindBy(id = trackingField)
    private WebElement trackingField;

    @FindBy(id = locationField)
    private WebElement locationField;

    @FindBy(id = okButton)
    private WebElement okButton;

    @FindBy(id = statusField)
    private WebElement statusField;

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

    @FindBy(id = errorMessageField)
    private WebElement errorMessageField;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        waitUntilElementVisible(loginButton, 5);
        loginButton.click();
        Assert.assertTrue(isElementVisible(logoutButton), Login failed, logout button not visible.);
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilElementVisible(trackingField, 5);
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        Assert.assertEquals(trackingField.getAttribute(value), shipmentID, Shipment ID not entered correctly.);
    }

    public void selectLocation(String location) {
        waitUntilElementVisible(locationField, 5);
        locationField.clear();
        locationField.sendKeys(location);
        Assert.assertEquals(locationField.getAttribute(value), location, Location not selected correctly.);
    }

    public void clickOkButton() {
        waitUntilElementVisible(okButton, 5);
        okButton.click();
        Assert.assertTrue(isElementVisible(statusField), OK button click failed, status field not visible.);
    }

    public String getCurrentStatus() {
        waitUntilElementVisible(statusField, 5);
        String status = statusField.getText();
        Assert.assertFalse(status.isEmpty(), Status field is empty.);
        return status;
    }

    public void simulateStatusUpdate(String status) {
        waitUntilElementVisible(statusField, 5);
        statusField.clear();
        statusField.sendKeys(status);
        Assert.assertEquals(statusField.getAttribute(value), status, Status not updated correctly.);
    }

    public String getTimestamp() {
        waitUntilElementVisible(timestampField, 5);
        String timestamp = timestampField.getText();
        Assert.assertFalse(timestamp.isEmpty(), Timestamp field is empty.);
        return timestamp;
    }

    public void refreshPage() {
        waitUntilElementVisible(refreshButton, 5);
        refreshButton.click();
        Assert.assertTrue(isElementVisible(trackingField), Page refresh failed, tracking field not visible.);
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 5);
        logoutButton.click();
        Assert.assertTrue(isElementVisible(loginButton), Logout failed, login button not visible.);
    }

    public boolean checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 5);
        boolean isDisplayed = notificationSettings.isDisplayed();
        Assert.assertTrue(isDisplayed, Notification settings not visible.);
        return isDisplayed;
    }

    public void simulateNetworkIssue() {
        waitUntilElementVisible(networkIssueButton, 5);
        networkIssueButton.click();
        Assert.assertTrue(isElementVisible(errorMessageField), Network issue simulation failed, error message not visible.);
    }

    public String getShipmentHistoryLog() {
        waitUntilElementVisible(shipmentHistoryLog, 5);
        String historyLog = shipmentHistoryLog.getText();
        Assert.assertFalse(historyLog.isEmpty(), Shipment history log is empty.);
        return historyLog;
    }

    public String checkErrorMessages() {
        waitUntilElementVisible(errorMessageField, 5);
        String errorMessage = errorMessageField.getText();
        Assert.assertFalse(errorMessage.isEmpty(), Error message field is empty.);
        return errorMessage;
    }

    private void waitUntilElementVisible(WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}