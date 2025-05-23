package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentPage extends WebReusableComponents {
    private WebDriver driver;
    private WebDriverWait wait;

    private By trackingPage = By.id(trackingPage);
    private By shipmentIDField = By.id(shipmentID);
    private By currentStatus = By.id(currentStatus);
    private By timestamp = By.id(timestamp);
    private By notifications = By.id(notifications);
    private By errorMessages = By.id(errorMessages);

    public ShipmentPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void login(String userID) {
        WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginField)));
        loginField.clear();
        loginField.sendKeys(userID);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(loginButton)));
        loginButton.click();
        Assert.assertTrue(isTrackingPageDisplayed(), Login failed, tracking page not displayed.);
    }

    public void navigateToShipmentTrackingPage() {
        WebElement trackingLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(trackingLink)));
        trackingLink.click();
        Assert.assertTrue(isTrackingPageDisplayed(), Failed to navigate to shipment tracking page.);
    }

    public boolean isTrackingPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(trackingPage)).isDisplayed();
    }

    public void enterShipmentID(String shipmentID) {
        WebElement shipmentIDElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentIDField));
        shipmentIDElement.clear();
        shipmentIDElement.sendKeys(shipmentID);
        Assert.assertTrue(isShipmentDetailsDisplayed(shipmentID), Shipment details not displayed for ID:  + shipmentID);
    }

    public boolean isShipmentDetailsDisplayed(String shipmentID) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipmentDetails)));
        return shipmentDetails.getText().contains(shipmentID);
    }

    public String checkCurrentStatus() {
        String status = wait.until(ExpectedConditions.visibilityOfElementLocated(currentStatus)).getText();
        Assert.assertNotNull(status, Current status is null.);
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement statusUpdateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(statusUpdateField)));
        statusUpdateField.clear();
        statusUpdateField.sendKeys(newStatus);
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(updateButton)));
        updateButton.click();
        Assert.assertEquals(checkCurrentStatus(), newStatus, Status update failed.);
    }

    public String verifyLatestStatusTimestamp() {
        String latestTimestamp = wait.until(ExpectedConditions.visibilityOfElementLocated(timestamp)).getText();
        Assert.assertNotNull(latestTimestamp, Timestamp is null.);
        return latestTimestamp;
    }

    public boolean isTimestampCurrent(String timestamp) {
        String currentTimestamp = verifyLatestStatusTimestamp();
        boolean isCurrent = currentTimestamp.equals(timestamp);
        Assert.assertTrue(isCurrent, Timestamp is not current.);
        return isCurrent;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), Page refresh failed, tracking page not displayed.);
    }

    public void logout() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(logoutButton)));
        logoutButton.click();
        Assert.assertFalse(isTrackingPageDisplayed(), Logout failed, tracking page still displayed.);
    }

    public boolean areNotificationsEnabled() {
        boolean notificationsEnabled = wait.until(ExpectedConditions.visibilityOfElementLocated(notifications)).isDisplayed();
        Assert.assertTrue(notificationsEnabled, Notifications are not enabled.);
        return notificationsEnabled;
    }

    public void simulateNetworkIssue() {
        WebElement networkIssueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(networkIssueButton)));
        networkIssueButton.click();
        Assert.assertTrue(isNetworkIssueHandledGracefully(), Network issue not handled gracefully.);
    }

    public boolean isNetworkIssueHandledGracefully() {
        WebElement networkError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(networkError)));
        boolean isHandled = networkError.isDisplayed();
        Assert.assertTrue(isHandled, Network issue not handled gracefully.);
        return isHandled;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(historyLog)));
        boolean isLogVerified = historyLog.isDisplayed();
        Assert.assertTrue(isLogVerified, Shipment history log verification failed.);
        return isLogVerified;
    }

    public boolean areErrorMessagesDisplayed() {
        boolean errorsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages)).isDisplayed();
        Assert.assertTrue(errorsDisplayed, Error messages are not displayed.);
        return errorsDisplayed;
    }

    public void updateStatusFromDifferentDevice() {
        WebElement updateDeviceButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(updateDeviceButton)));
        updateDeviceButton.click();
        Assert.assertTrue(isStatusSynchronizedAcrossDevices(), Status update from different device failed.);
    }

    public boolean isStatusSynchronizedAcrossDevices() {
        WebElement syncStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(syncStatus)));
        boolean isSynchronized = syncStatus.isDisplayed();
        Assert.assertTrue(isSynchronized, Status is not synchronized across devices.);
        return isSynchronized;
    }

    public boolean verifyStatusOnMobileDevice() {
        WebElement mobileStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mobileStatus)));
        boolean isVerified = mobileStatus.isDisplayed();
        Assert.assertTrue(isVerified, Status verification on mobile device failed.);
        return isVerified;
    }

    public void rebootSystem() {
        WebElement rebootButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(rebootButton)));
        rebootButton.click();
        Assert.assertTrue(isTrackingPageDisplayed(), System reboot failed, tracking page not displayed.);
    }
}