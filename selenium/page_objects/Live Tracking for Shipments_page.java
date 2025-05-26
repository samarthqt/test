package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {
    WebDriver driver;

    @FindBy(id = "trackingField")
    WebElement trackingField;

    @FindBy(id = "currentLocation")
    WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    WebElement refreshButton;

    @FindBy(id = "logoutButton")
    WebElement logoutButton;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "notificationSettings")
    WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulate")
    WebElement networkIssueSimulate;

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    @FindBy(id = "updateLocationDifferentDevice")
    WebElement updateLocationDifferentDevice;

    @FindBy(id = "mobileTrackingCheck")
    WebElement mobileTrackingCheck;

    @FindBy(id = "systemRebootCheck")
    WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
    }

    public void enterShipmentID(String shipmentID) {
        trackingField.sendKeys(shipmentID);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
    }

    public void simulateLocationChange() {
        // Simulate location change logic
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public void login() {
        loginButton.click();
    }

    public String getNotificationSettings() {
        return notificationSettings.getText();
    }

    public void simulateNetworkIssue() {
        networkIssueSimulate.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void updateLocationFromDifferentDevice() {
        updateLocationDifferentDevice.click();
    }

    public void verifyLiveTrackingOnMobile() {
        mobileTrackingCheck.click();
    }

    public void checkLiveTrackingAfterReboot() {
        systemRebootCheck.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}