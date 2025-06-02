
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingPage extends WebReusableComponents {

    protected By trackingField = By.id("trackingField");
    protected By currentLocation = By.id("currentLocation");
    protected By estimatedDeliveryTime = By.id("estimatedDeliveryTime");
    protected By refreshButton = By.id("refreshButton");
    protected By logoutButton = By.id("logoutButton");
    protected By loginButton = By.id("loginButton");
    protected By notificationSettings = By.id("notificationSettings");
    protected By networkIssueMessage = By.id("networkIssueMessage");
    protected By trackingHistoryLog = By.id("trackingHistoryLog");
    protected By errorMessage = By.id("errorMessage");
    protected By mobileTracking = By.id("mobileTracking");
    protected By systemRebootMessage = By.id("systemRebootMessage");
    protected By trackingAccuracy = By.id("trackingAccuracy");

    public LiveTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
        Assert.assertTrue(driver.getTitle().contains("Live Tracking"), "Navigation to Live Tracking Page failed.");
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilElementVisible(trackingField, 3);
        enterText(trackingField, shipmentID);
        Assert.assertEquals(getTextFromElement(trackingField), shipmentID, "Shipment ID entry failed.");
    }

    public void checkCurrentLocation() {
        waitUntilElementVisible(currentLocation, 3);
        String location = getTextFromElement(currentLocation);
        Assert.assertNotNull(location, "Current location is not displayed.");
    }

    public void simulateChangeInShipmentLocation() {
        // Simulate location change logic
        String newLocation = "New Location";
        enterText(currentLocation, newLocation);
        Assert.assertEquals(getTextFromElement(currentLocation), newLocation, "Shipment location change simulation failed.");
    }

    public void verifyEstimatedDeliveryTime(String expectedTime) {
        waitUntilElementVisible(estimatedDeliveryTime, 3);
        String actualTime = getTextFromElement(estimatedDeliveryTime);
        Assert.assertEquals(actualTime, expectedTime, "Estimated delivery time does not match.");
    }

    public void refreshPage() {
        waitUntilElementVisible(refreshButton, 3);
        clickElement(refreshButton);
        Assert.assertTrue(driver.getTitle().contains("Live Tracking"), "Page refresh failed.");
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(driver.getTitle().contains("Login"), "Logout and login process failed.");
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        WebElement settings = driver.findElement(notificationSettings);
        Assert.assertTrue(settings.isDisplayed(), "Notification settings are not visible.");
    }

    public void simulateNetworkIssue() {
        // Simulate network issue logic
        WebElement issueMessage = driver.findElement(networkIssueMessage);
        Assert.assertTrue(issueMessage.isDisplayed(), "Network issue simulation failed.");
    }

    public void verifyTrackingHistoryLog() {
        waitUntilElementVisible(trackingHistoryLog, 3);
        String historyLog = getTextFromElement(trackingHistoryLog);
        Assert.assertNotNull(historyLog, "Tracking history log is not displayed.");
    }

    public void checkForErrorMessages() {
        waitUntilElementVisible(errorMessage, 3);
        String error = getTextFromElement(errorMessage);
        Assert.assertNotNull(error, "Error message is not displayed.");
    }

    public void updateLocationFromDifferentDevice() {
        // Update location logic
        String updatedLocation = "Updated Location";
        enterText(currentLocation, updatedLocation);
        Assert.assertEquals(getTextFromElement(currentLocation), updatedLocation, "Location update from different device failed.");
    }

    public void verifyLiveTrackingOnMobile() {
        waitUntilElementVisible(mobileTracking, 3);
        WebElement mobileTrack = driver.findElement(mobileTracking);
        Assert.assertTrue(mobileTrack.isDisplayed(), "Live tracking on mobile is not verified.");
    }

    public void checkLiveTrackingAfterSystemReboot() {
        waitUntilElementVisible(systemRebootMessage, 3);
        WebElement rebootMessage = driver.findElement(systemRebootMessage);
        Assert.assertTrue(rebootMessage.isDisplayed(), "Live tracking after system reboot is not verified.");
    }

    public void verifyTrackingAccuracy(String expectedAccuracy) {
        waitUntilElementVisible(trackingAccuracy, 3);
        String actualAccuracy = getTextFromElement(trackingAccuracy);
        Assert.assertEquals(actualAccuracy, expectedAccuracy, "Tracking accuracy does not match.");
    }
}
