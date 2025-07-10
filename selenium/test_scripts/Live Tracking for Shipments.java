package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    protected By lblMobileTracking = By.id("mobileTracking");
    protected By btnRebootSystem = By.id("rebootSystem");
    protected By lblTrackingAccuracy = By.id("trackingAccuracy");

    public void navigateToLiveTrackingPage(WebDriver driver, String url) {
        driver.get(url);
    }

    public void enterShipmentId(String shipmentId) {
        waitUntilElementVisible(txtShipmentId, 3);
        enterText(txtShipmentId, shipmentId);
    }

    public void checkCurrentLocation() {
        waitUntilElementVisible(btnCheckLocation, 3);
        clickElement(btnCheckLocation);
    }

    public void simulateLocationChange() {
        waitUntilElementVisible(btnSimulateLocationChange, 3);
        clickElement(btnSimulateLocationChange);
    }

    public void verifyEstimatedDeliveryTime(String expectedTime) {
        waitUntilElementVisible(lblEstimatedDeliveryTime, 3);
        String actualTime = getTextFromElement(lblEstimatedDeliveryTime);
        Assert.assertEquals(actualTime, expectedTime, "Estimated delivery time does not match.");
    }

    public void refreshPage() {
        waitUntilElementVisible(btnRefreshPage, 3);
        clickElement(btnRefreshPage);
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(btnNotificationSettings, 3);
        clickElement(btnNotificationSettings);
    }

    public void simulateNetworkIssue() {
        waitUntilElementVisible(btnSimulateNetworkIssue, 3);
        clickElement(btnSimulateNetworkIssue);
    }

    public void verifyTrackingHistoryLog(String expectedLog) {
        waitUntilElementVisible(lblTrackingHistoryLog, 3);
        String actualLog = getTextFromElement(lblTrackingHistoryLog);
        Assert.assertEquals(actualLog, expectedLog, "Tracking history log does not match.");
    }

    public void checkForErrorMessages(String expectedError) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualError = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualError, expectedError, "Error message does not match.");
    }

    public void updateLocationFromDifferentDevice() {
        waitUntilElementVisible(btnUpdateLocationDifferentDevice, 3);
        clickElement(btnUpdateLocationDifferentDevice);
    }

    public void verifyLiveTrackingOnMobileDevice(String expectedStatus) {
        waitUntilElementVisible(lblMobileTracking, 3);
        String actualStatus = getTextFromElement(lblMobileTracking);
        Assert.assertEquals(actualStatus, expectedStatus, "Mobile tracking status does not match.");
    }

    public void checkLiveTrackingAfterReboot() {
        waitUntilElementVisible(btnRebootSystem, 3);
        clickElement(btnRebootSystem);
    }

    public void verifyTrackingAccuracy(String expectedAccuracy) {
        waitUntilElementVisible(lblTrackingAccuracy, 3);
        String actualAccuracy = getTextFromElement(lblTrackingAccuracy);
        Assert.assertEquals(actualAccuracy, expectedAccuracy, "Tracking accuracy does not match.");
    }
}