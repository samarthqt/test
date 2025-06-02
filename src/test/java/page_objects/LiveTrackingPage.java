package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingPage extends WebReusableComponents {

    protected By txtShipmentId = By.id("shipmentId");
    protected By btnCheckLocation = By.id("checkLocation");
    protected By lblCurrentLocation = By.id("currentLocation");
    protected By btnSimulateLocationChange = By.id("simulateLocationChange");
    protected By lblEstimatedDeliveryTime = By.id("estimatedDeliveryTime");
    protected By btnRefreshPage = By.id("refreshPage");
    protected By btnLogout = By.id("logout");
    protected By btnLogin = By.id("login");
    protected By btnNotificationSettings = By.id("notificationSettings");
    protected By btnSimulateNetworkIssue = By.id("simulateNetworkIssue");
    protected By lblTrackingHistoryLog = By.id("trackingHistoryLog");
    protected By lblErrorMessage = By.id("errorMessage");
    protected By btnUpdateLocationDifferentDevice = By.id("updateLocationDifferentDevice");
    protected By lblLiveTrackingMobile = By.id("liveTrackingMobile");
    protected By btnSystemReboot = By.id("systemReboot");
    protected By lblTrackingAccuracy = By.id("trackingAccuracy");

    public LiveTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTrackingPage() {
        driver.get("http://example.com/live-tracking");
        Assert.assertTrue(driver.getTitle().contains("Live Tracking"), "Navigation to Live Tracking Page failed.");
    }

    public void enterShipmentId(String shipmentId) {
        waitUntilElementVisible(txtShipmentId, 3);
        enterText(txtShipmentId, shipmentId);
        Assert.assertEquals(getAttribute(txtShipmentId, "value"), shipmentId, "Shipment ID entry failed.");
    }

    public void checkCurrentLocation() {
        waitUntilElementVisible(btnCheckLocation, 3);
        clickElement(btnCheckLocation);
        Assert.assertTrue(isElementVisible(lblCurrentLocation), "Current location check failed.");
    }

    public void simulateLocationChange() {
        waitUntilElementVisible(btnSimulateLocationChange, 3);
        clickElement(btnSimulateLocationChange);
        Assert.assertTrue(isElementVisible(lblCurrentLocation), "Location change simulation failed.");
    }

    public void verifyEstimatedDeliveryTime(String expectedTime) {
        waitUntilElementVisible(lblEstimatedDeliveryTime, 3);
        String actualTime = getTextFromElement(lblEstimatedDeliveryTime);
        Assert.assertEquals(actualTime, expectedTime, "Estimated delivery time does not match.");
    }

    public void refreshPage() {
        waitUntilElementVisible(btnRefreshPage, 3);
        clickElement(btnRefreshPage);
        Assert.assertTrue(driver.getTitle().contains("Live Tracking"), "Page refresh failed.");
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogout), "Logout and login failed.");
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(btnNotificationSettings, 3);
        clickElement(btnNotificationSettings);
        Assert.assertTrue(isElementVisible(btnNotificationSettings), "Notification settings check failed.");
    }

    public void simulateNetworkIssue() {
        waitUntilElementVisible(btnSimulateNetworkIssue, 3);
        clickElement(btnSimulateNetworkIssue);
        Assert.assertTrue(isElementVisible(lblErrorMessage), "Network issue simulation failed.");
    }

    public void verifyTrackingHistoryLog(String expectedLog) {
        waitUntilElementVisible(lblTrackingHistoryLog, 3);
        String actualLog = getTextFromElement(lblTrackingHistoryLog);
        Assert.assertEquals(actualLog, expectedLog, "Tracking history log does not match.");
    }

    public void checkErrorMessages(String expectedError) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualError = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualError, expectedError, "Error message does not match.");
    }

    public void updateLocationFromDifferentDevice() {
        waitUntilElementVisible(btnUpdateLocationDifferentDevice, 3);
        clickElement(btnUpdateLocationDifferentDevice);
        Assert.assertTrue(isElementVisible(lblCurrentLocation), "Location update from different device failed.");
    }

    public void verifyLiveTrackingOnMobile() {
        waitUntilElementVisible(lblLiveTrackingMobile, 3);
        Assert.assertTrue(isElementVisible(lblLiveTrackingMobile), "Live tracking on mobile verification failed.");
    }

    public void checkLiveTrackingAfterReboot() {
        waitUntilElementVisible(btnSystemReboot, 3);
        clickElement(btnSystemReboot);
        Assert.assertTrue(isElementVisible(lblCurrentLocation), "Live tracking check after reboot failed.");
    }

    public void verifyTrackingAccuracy(String expectedAccuracy) {
        waitUntilElementVisible(lblTrackingAccuracy, 3);
        String actualAccuracy = getTextFromElement(lblTrackingAccuracy);
        Assert.assertEquals(actualAccuracy, expectedAccuracy, "Tracking accuracy does not match.");
    }
}