package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {

    private WebDriver driver;

    @FindBy(id = "trackingField")
    private WebElement trackingField;

    @FindBy(id = "currentLocation")
    private WebElement currentLocation;

    @FindBy(id = "estimatedDeliveryTime")
    private WebElement estimatedDeliveryTime;

    @FindBy(id = "refreshButton")
    private WebElement refreshButton;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "notificationSettings")
    private WebElement notificationSettings;

    @FindBy(id = "networkIssueSimulation")
    private WebElement networkIssueSimulation;

    @FindBy(id = "trackingHistoryLog")
    private WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "differentDeviceUpdate")
    private WebElement differentDeviceUpdate;

    @FindBy(id = "mobileDeviceTracking")
    private WebElement mobileDeviceTracking;

    @FindBy(id = "systemRebootTracking")
    private WebElement systemRebootTracking;

    @FindBy(id = "trackingAccuracy")
    private WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        trackingField.clear();
        trackingField.sendKeys(shipmentId);
    }

    public String getCurrentLocation() {
        return currentLocation.getText();
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

    public void checkNotificationSettings() {
        notificationSettings.click();
    }

    public void simulateNetworkIssue() {
        networkIssueSimulation.click();
    }

    public String getTrackingHistoryLog() {
        return trackingHistoryLog.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void updateLocationFromDifferentDevice() {
        differentDeviceUpdate.click();
    }

    public String verifyMobileDeviceTracking() {
        return mobileDeviceTracking.getText();
    }

    public String verifySystemRebootTracking() {
        return systemRebootTracking.getText();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}