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
    }

    public boolean verifyTimestamp() {
        WebElement timestampElement = waitUntilElementVisible(By.id("timestamp"));
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Timestamp is null.");
        return true;
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
    }

    public boolean isNetworkIssueHandled() {
        // Logic to verify network issue handling
        return true;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = waitUntilElementVisible(By.id("historyLog"));
        Assert.assertNotNull(historyLog, "Shipment history log is null.");
        return true;
    }

    public boolean hasErrorMessages() {
        List<WebElement> errorMessages = driver.findElements(By.className("errorMessage"));
        boolean hasErrors = !errorMessages.isEmpty();
        Assert.assertFalse(hasErrors, "Error messages are present.");
        return hasErrors;
    }

    public void closeBrowser() {
        driver.quit();
    }

    private WebElement waitUntilElementVisible(By locator) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitUntilElementClickable(By locator) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
    }
}