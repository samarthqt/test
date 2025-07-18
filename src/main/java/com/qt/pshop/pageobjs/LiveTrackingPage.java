package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LiveTrackingPage {

    protected By trackingField = By.id("trackingField");
    protected By currentLocationMap = By.id("currentLocationMap");
    protected By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    protected By notificationSettings = By.id("notificationSettings");
    protected By trackingHistoryLog = By.id("trackingHistoryLog");
    protected By errorMessage = By.id("errorMessage");

    public LiveTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
        Assert.assertTrue(isLiveTrackingPageDisplayed(), "Live Tracking page is not displayed.");
    }

    public boolean isLiveTrackingPageDisplayed() {
        return driver.getTitle().contains("Live Tracking");
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingFieldElement = driver.findElement(trackingField);
        trackingFieldElement.clear();
        trackingFieldElement.sendKeys(shipmentID);
        Assert.assertTrue(isTrackingDetailsDisplayed(shipmentID), "Tracking details are not displayed for shipment ID: " + shipmentID);
    }

    public boolean isTrackingDetailsDisplayed(String shipmentID) {
        WebElement trackingDetails = driver.findElement(By.id("trackingDetails"));
        return trackingDetails.getText().contains(shipmentID);
    }

    public boolean isCurrentLocationDisplayed() {
        WebElement locationMap = driver.findElement(currentLocationMap);
        return locationMap.isDisplayed();
    }

    public void simulateLocationChange() {
        refreshPage();
        Assert.assertTrue(isLocationUpdatedInRealTime(), "Location is not updated in real-time.");
    }

    public boolean isLocationUpdatedInRealTime() {
        WebElement locationMap = driver.findElement(currentLocationMap);
        return locationMap.getAttribute("data-updated").equals("true");
    }

    public boolean isEstimatedDeliveryTimeDisplayed() {
        WebElement deliveryTimeElement = driver.findElement(estimatedDeliveryTime);
        return deliveryTimeElement.isDisplayed();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isLiveTrackingPageDisplayed(), "Live Tracking page is not displayed after refresh.");
    }

    public boolean isLiveTrackingInfoConsistent() {
        WebElement trackingDetails = driver.findElement(By.id("trackingDetails"));
        return trackingDetails.getText().contains("Consistent Data");
    }

    public void logOutAndLogIn() {
        driver.findElement(By.id("logoutButton")).click();
        driver.findElement(By.id("loginButton")).click();
        navigateToLiveTrackingPage();
        Assert.assertTrue(isLiveTrackingInfoAvailable(), "Live tracking info is not available after log out and log in.");
    }

    public boolean isLiveTrackingInfoAvailable() {
        WebElement trackingDetails = driver.findElement(By.id("trackingDetails"));
        return trackingDetails.isDisplayed();
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationElement = driver.findElement(notificationSettings);
        return notificationElement.isSelected();
    }

    public void simulateNetworkIssueAndUpdateLocation() {
        driver.findElement(By.id("simulateNetworkIssue")).click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), "Network issue is not handled gracefully.");
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.getText().contains("Network issue resolved");
    }

    public boolean isTrackingHistoryLogCorrect() {
        WebElement historyLogElement = driver.findElement(trackingHistoryLog);
        return historyLogElement.getText().contains("Location updates");
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.isDisplayed();
    }

    public void updateLocationFromDifferentDevice() {
        driver.findElement(By.id("updateLocation")).click();
        Assert.assertTrue(isLocationSynchronizedAcrossDevices(), "Location is not synchronized across devices.");
    }

    public boolean isLocationSynchronizedAcrossDevices() {
        WebElement locationMap = driver.findElement(currentLocationMap);
        return locationMap.getAttribute("data-synchronized").equals("true");
    }

    public boolean isMobileTrackingConsistent() {
        WebElement mobileTrackingElement = driver.findElement(By.id("mobileTracking"));
        return mobileTrackingElement.getText().contains("Consistent");
    }

    public void rebootSystem() {
        driver.findElement(By.id("rebootButton")).click();
        navigateToLiveTrackingPage();
        Assert.assertTrue(isTrackingInfoAvailableAfterReboot(), "Tracking info is not available after reboot.");
    }

    public boolean isTrackingInfoAvailableAfterReboot() {
        WebElement trackingDetails = driver.findElement(By.id("trackingDetails"));
        return trackingDetails.isDisplayed();
    }

    public boolean isLiveTrackingAccurate() {
        WebElement accuracyElement = driver.findElement(By.id("accuracy"));
        return accuracyElement.getText().contains("Accurate");
    }
}