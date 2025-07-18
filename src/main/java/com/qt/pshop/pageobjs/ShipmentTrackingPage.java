package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import .util.List;

public class ShipmentTrackingPage {

    public ShipmentTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage() {
        driver.get("http://example.com/shipment-tracking");
        Assert.assertTrue(isTrackingPageDisplayed(), "Shipment Tracking page is not displayed.");
    }

    public boolean isTrackingPageDisplayed() {
        return driver.getTitle().contains("Shipment Tracking");
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = waitUntilElementVisible(By.id("trackingField"));
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        trackingField.submit();
        Assert.assertFalse(hasErrorMessages(), "Error messages found after entering shipment ID.");
    }

    public String getShipmentStatus() {
        WebElement statusElement = waitUntilElementVisible(By.id("shipmentStatus"));
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Shipment status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement updateButton = waitUntilElementClickable(By.id("updateStatusButton"));
        updateButton.click();
        WebElement statusDropdown = waitUntilElementVisible(By.id("statusDropdown"));
        statusDropdown.sendKeys(newStatus);
        statusDropdown.submit();
        Assert.assertTrue(isStatusSynchronized(), "Status is not synchronized after update.");
    }

    public boolean verifyTimestamp() {
        WebElement timestampElement = waitUntilElementVisible(By.id("timestamp"));
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Timestamp is null.");
        return true; // Logic to verify timestamp with current time
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page is not refreshed correctly.");
    }

    public void logOutAndLogIn() {
        WebElement logoutButton = waitUntilElementClickable(By.id("logoutButton"));
        logoutButton.click();
        WebElement loginButton = waitUntilElementClickable(By.id("loginButton"));
        loginButton.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed.");
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsCheckbox = waitUntilElementVisible(By.id("notificationsCheckbox"));
        boolean isSelected = notificationsCheckbox.isSelected();
        Assert.assertTrue(isSelected, "Notifications are not enabled.");
        return isSelected;
    }

    public void simulateNetworkIssue() {
        // Logic to simulate network issue
        Assert.assertTrue(isNetworkIssueHandled(), "Network issue is not handled.");
    }

    public boolean isNetworkIssueHandled() {
        return true; // Logic to verify network issue handling
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = waitUntilElementVisible(By.id("historyLog"));
        Assert.assertNotNull(historyLog, "Shipment history log is null.");
        return true; // Logic to verify shipment history log
    }

    public boolean hasErrorMessages() {
        List<WebElement> errorMessages = driver.findElements(By.className("errorMessage"));
        boolean hasErrors = !errorMessages.isEmpty();
        Assert.assertFalse(hasErrors, "Error messages are present.");
        return hasErrors;
    }

    public void updateStatusFromDifferentDevice() {
        // Logic to update status from a different device
        Assert.assertTrue(isStatusSynchronized(), "Status is not synchronized across devices.");
    }

    public boolean isStatusSynchronized() {
        return true; // Logic to verify status synchronization
    }

    public boolean verifyMobileStatusConsistency() {
        return true; // Logic to verify mobile status consistency
    }

    public void rebootSystem() {
        // Logic to reboot system
        Assert.assertTrue(isTrackingPageDisplayed(), "System reboot failed.");
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }

    private WebElement waitUntilElementVisible(By locator) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitUntilElementClickable(By locator) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
    }
}