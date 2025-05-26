package com.example.trackingpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveTrackingPage {

    WebDriver driver;

    @FindBy(id = "shipmentIdField")
    WebElement shipmentIdField;

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

    @FindBy(id = "networkIssueSimulation")
    WebElement networkIssueSimulation;

    @FindBy(id = "trackingHistoryLog")
    WebElement trackingHistoryLog;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    @FindBy(id = "updateLocationDifferentDevice")
    WebElement updateLocationDifferentDevice;

    @FindBy(id = "liveTrackingMobile")
    WebElement liveTrackingMobile;

    @FindBy(id = "systemRebootCheck")
    WebElement systemRebootCheck;

    @FindBy(id = "trackingAccuracy")
    WebElement trackingAccuracy;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterShipmentId(String shipmentId) {
        shipmentIdField.clear();
        shipmentIdField.sendKeys(shipmentId);
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
        updateLocationDifferentDevice.click();
    }

    public void verifyLiveTrackingOnMobile() {
        liveTrackingMobile.click();
    }

    public void checkLiveTrackingAfterSystemReboot() {
        systemRebootCheck.click();
    }

    public String verifyTrackingAccuracy() {
        return trackingAccuracy.getText();
    }
}