package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentTrackingPage {

    WebDriver driver;

    @FindBy(id = "trackingField")
    WebElement trackingField;

    @FindBy(id = "currentStatus")
    WebElement currentStatus;

    @FindBy(id = "updateStatus")
    WebElement updateStatusButton;

    @FindBy(id = "latestTimestamp")
    WebElement latestTimestamp;

    @FindBy(id = "refreshPage")
    WebElement refreshPageButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "networkIssueButton")
    WebElement networkIssueButton;

    @FindBy(id = "shipmentHistoryLog")
    WebElement shipmentHistoryLog;

    @FindBy(id = "errorMessages")
    WebElement errorMessages;

    @FindBy(id = "updateFromDifferentDevice")
    WebElement updateFromDifferentDeviceButton;

    @FindBy(id = "mobileStatus")
    WebElement mobileStatus;

    @FindBy(id = "systemRebootStatus")
    WebElement systemRebootStatus;

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage(String url) {
        driver.get(url);
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentStatus() {
        return currentStatus.getText();
    }

    public void simulateStatusUpdate(String status) {
        updateStatusButton.click();
        // Additional logic to select status
    }

    public String getLatestTimestamp() {
        return latestTimestamp.getText();
    }

    public void refreshPage() {
        refreshPageButton.click();
    }

    public void logoutAndLogin() {
        logoutButton.click();
        loginButton.click();
    }

    public String checkNotificationSettings() {
        return notificationSettings.getText();
    }

    public void simulateNetworkIssue() {
        networkIssueButton.click();
    }

    public String verifyShipmentHistoryLog() {
        return shipmentHistoryLog.getText();
    }

    public String checkErrorMessages() {
        return errorMessages.getText();
    }

    public void updateStatusFromDifferentDevice() {
        updateFromDifferentDeviceButton.click();
    }

    public String verifyShipmentStatusOnMobile() {
        return mobileStatus.getText();
    }

    public String checkShipmentStatusAfterReboot() {
        return systemRebootStatus.getText();
    }
}