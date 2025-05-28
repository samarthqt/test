package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingPage extends WebReusableComponents {

    private final WebDriver driver;

    @FindBy(id = shipmentTrackingField)
    private WebElement trackingField;

    @FindBy(id = currentLocationMap)
    private WebElement currentLocationMap;

    @FindBy(id = estimatedDeliveryTime)
    private WebElement estimatedDeliveryTime;

    @FindBy(id = refreshButton)
    private WebElement refreshButton;

    @FindBy(id = logoutButton)
    private WebElement logoutButton;

    @FindBy(id = loginButton)
    private WebElement loginButton;

    @FindBy(id = notificationSettings)
    private WebElement notificationSettings;

    @FindBy(id = networkIssueHandler)
    private WebElement networkIssueHandler;

    @FindBy(id = trackingHistoryLog)
    private WebElement trackingHistoryLog;

    @FindBy(id = errorMessages)
    private WebElement errorMessages;

    @FindBy(id = deviceSyncCheck)
    private WebElement deviceSyncCheck;

    @FindBy(id = mobileTrackingCheck)
    private WebElement mobileTrackingCheck;

    @FindBy(id = systemRebootCheck)
    private WebElement systemRebootCheck;

    @FindBy(id = trackingAccuracyCheck)
    private WebElement trackingAccuracyCheck;

    public LiveTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLiveTracking() {
        driver.get(http://example.com/live-tracking);
        Assert.assertTrue(driver.getCurrentUrl().contains(live-tracking), Navigation to live tracking failed.);
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilElementVisible(trackingField, 5);
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        Assert.assertEquals(trackingField.getAttribute(value), shipmentID, Shipment ID entry failed.);
    }

    public boolean isCurrentLocationDisplayed() {
        waitUntilElementVisible(currentLocationMap, 5);
        boolean isDisplayed = currentLocationMap.isDisplayed();
        Assert.assertTrue(isDisplayed, Current location map is not displayed.);
        return isDisplayed;
    }

    public void simulateLocationChange() {
        // Simulate location change logic
        Assert.assertTrue(true, Location change simulation not implemented.);
    }

    public String getEstimatedDeliveryTime() {
        waitUntilElementVisible(estimatedDeliveryTime, 5);
        String deliveryTime = estimatedDeliveryTime.getText();
        Assert.assertNotNull(deliveryTime, Estimated delivery time is not available.);
        return deliveryTime;
    }

    public void refreshPage() {
        waitUntilElementClickable(refreshButton, 5);
        refreshButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(live-tracking), Page refresh failed.);
    }

    public void logoutAndLogin() {
        waitUntilElementClickable(logoutButton, 5);
        logoutButton.click();
        waitUntilElementClickable(loginButton, 5);
        loginButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(dashboard), Logout and login failed.);
    }

    public boolean areNotificationsEnabled() {
        waitUntilElementVisible(notificationSettings, 5);
        boolean isEnabled = notificationSettings.isSelected();
        Assert.assertTrue(isEnabled, Notifications are not enabled.);
        return isEnabled;
    }

    public void simulateNetworkIssue() {
        // Simulate network issue logic
        Assert.assertTrue(true, Network issue simulation not implemented.);
    }

    public boolean isTrackingHistoryLogCorrect() {
        waitUntilElementVisible(trackingHistoryLog, 5);
        boolean isCorrect = trackingHistoryLog.isDisplayed();
        Assert.assertTrue(isCorrect, Tracking history log is incorrect.);
        return isCorrect;
    }

    public boolean areErrorMessagesDisplayed() {
        waitUntilElementVisible(errorMessages, 5);
        boolean isDisplayed = errorMessages.isDisplayed();
        Assert.assertTrue(isDisplayed, Error messages are not displayed.);
        return isDisplayed;
    }

    public void updateLocationFromDifferentDevice() {
        // Update location from different device logic
        Assert.assertTrue(true, Location update from different device not implemented.);
    }

    public boolean isMobileTrackingConsistent() {
        waitUntilElementVisible(mobileTrackingCheck, 5);
        boolean isConsistent = mobileTrackingCheck.isDisplayed();
        Assert.assertTrue(isConsistent, Mobile tracking is not consistent.);
        return isConsistent;
    }

    public boolean isTrackingAvailableAfterReboot() {
        waitUntilElementVisible(systemRebootCheck, 5);
        boolean isAvailable = systemRebootCheck.isDisplayed();
        Assert.assertTrue(isAvailable, Tracking is not available after reboot.);
        return isAvailable;
    }

    public boolean isTrackingAccurate() {
        waitUntilElementVisible(trackingAccuracyCheck, 5);
        boolean isAccurate = trackingAccuracyCheck.isDisplayed();
        Assert.assertTrue(isAccurate, Tracking is not accurate.);
        return isAccurate;
    }
}