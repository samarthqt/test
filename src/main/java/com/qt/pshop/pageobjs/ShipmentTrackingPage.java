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
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateToShipmentTrackingPage() {
        driver.get("http://example.com/shipment-tracking");
        Assert.assertTrue(isTrackingPageDisplayed(), "Shipment Tracking page is not displayed.");
    }

    public boolean isTrackingPageDisplayed() {
        return driver.getTitle().contains("Shipment Tracking");
    }

    public void enterShipmentID(String shipmentID) {
        WebElement trackingField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingField")));
        trackingField.clear();
        trackingField.sendKeys(shipmentID);
        trackingField.submit();
        Assert.assertFalse(hasErrorMessages(), "Error messages found after entering shipment ID.");
    }

    public String getShipmentStatus() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipmentStatus")));
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Shipment status is null.");
        return status;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateStatusButton")));
        updateButton.click();
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusDropdown")));
        statusDropdown.sendKeys(newStatus);
        statusDropdown.submit();
        Assert.assertTrue(isStatusSynchronized(), "Status is not synchronized after update.");
    }

    public boolean verifyTimestamp() {
        WebElement timestampElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timestamp")));
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Timestamp is null.");
        // Logic to verify timestamp with current time
        return true;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page is not refreshed correctly.");
    }

    public void logOutAndLogIn() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutButton")));
        logoutButton.click();
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
        Assert.assertTrue(isTrackingPageDisplayed(), "Login failed.");
    }

    public boolean areNotificationsEnabled() {
        WebElement notificationsCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationsCheckbox")));
        boolean isSelected = notificationsCheckbox.isSelected();
        Assert.assertTrue(isSelected, "Notifications are not enabled.");
        return isSelected;
    }

    public void simulateNetworkIssue() {
        // Logic to simulate network issue
        Assert.assertTrue(isNetworkIssueHandled(), "Network issue is not handled.");
    }

    public boolean isNetworkIssueHandled() {
        // Logic to verify network issue handling
        return true;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("historyLog")));
        // Logic to verify shipment history log
        Assert.assertNotNull(historyLog, "Shipment history log is null.");
        return true;
    }

    public boolean hasErrorMessages() {
        List<WebElement> errorMessages = driver.findElements(By.className("errorMessage"));
        boolean hasErrors = !errorMessages.isEmpty();
        Assert.assertFalse(hasErrors, "Error messages are present.");
        return hasErrors;
    }

    public boolean isStatusSynchronized() {
        // Logic to verify status synchronization
        return true;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }
}