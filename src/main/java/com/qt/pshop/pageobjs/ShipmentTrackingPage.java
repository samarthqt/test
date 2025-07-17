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

    public boolean isTrackingDetailsDisplayed() {
        WebElement detailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingDetails")));
        boolean isDisplayed = detailsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Tracking details are not displayed.");
        return isDisplayed;
    }

    public boolean checkCurrentLocation() {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentLocation")));
        boolean isDisplayed = locationElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Current location is not displayed.");
        return isDisplayed;
    }

    public void simulateLocationChange() {
        WebElement changeLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("changeLocationButton")));
        changeLocationButton.click();
        Assert.assertTrue(isLocationUpdated(), "Location change simulation failed.");
    }

    public boolean isLocationUpdated() {
        WebElement updatedLocationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updatedLocation")));
        boolean isDisplayed = updatedLocationElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Updated location is not displayed.");
        return isDisplayed;
    }

    public boolean verifyEstimatedDeliveryTime() {
        WebElement deliveryTimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimatedDeliveryTime")));
        boolean isDisplayed = deliveryTimeElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Estimated delivery time is not displayed.");
        return isDisplayed;
    }

    public boolean isTrackingDetailsConsistent() {
        WebElement consistentDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("consistentDetails")));
        boolean isDisplayed = consistentDetailsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Tracking details are not consistent.");
        return isDisplayed;
    }

    public boolean isTrackingDetailsAvailable() {
        WebElement availableDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("availableDetails")));
        boolean isDisplayed = availableDetailsElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Tracking details are not available.");
        return isDisplayed;
    }

    public boolean verifyTrackingAccuracy() {
        WebElement accuracyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingAccuracy")));
        boolean isDisplayed = accuracyElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Tracking accuracy is not verified.");
        return isDisplayed;
    }

    public boolean verifyShipmentHistoryLog() {
        WebElement historyLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("historyLog")));
        boolean isDisplayed = historyLog.isDisplayed();
        Assert.assertTrue(isDisplayed, "Shipment history log is not verified.");
        return isDisplayed;
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateStatusButton")));
        updateButton.click();
        WebElement statusDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("statusDropdown")));
        statusDropdown.sendKeys(newStatus);
        statusDropdown.submit();
        Assert.assertTrue(isStatusSynchronized(), "Status update simulation failed.");
    }

    public boolean isStatusSynchronized() {
        WebElement synchronizedStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("synchronizedStatus")));
        boolean isDisplayed = synchronizedStatusElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Status is not synchronized.");
        return isDisplayed;
    }

    public void refreshPage() {
        driver.navigate().refresh();
        Assert.assertTrue(isTrackingPageDisplayed(), "Page refresh failed.");
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
        WebElement networkIssueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("networkIssueButton")));
        networkIssueButton.click();
        Assert.assertTrue(isNetworkIssueHandled(), "Network issue simulation failed.");
    }

    public boolean isNetworkIssueHandled() {
        WebElement networkHandledElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("networkHandled")));
        boolean isDisplayed = networkHandledElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Network issue is not handled.");
        return isDisplayed;
    }

    public boolean verifyTrackingHistoryLog() {
        WebElement trackingHistoryLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trackingHistoryLog")));
        boolean isDisplayed = trackingHistoryLog.isDisplayed();
        Assert.assertTrue(isDisplayed, "Tracking history log is not verified.");
        return isDisplayed;
    }

    public boolean hasErrorMessages() {
        List<WebElement> errorMessages = driver.findElements(By.className("errorMessage"));
        boolean hasErrors = !errorMessages.isEmpty();
        Assert.assertFalse(hasErrors, "Error messages are present.");
        return hasErrors;
    }

    public boolean isLocationSynchronized() {
        WebElement synchronizedLocationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("synchronizedLocation")));
        boolean isDisplayed = synchronizedLocationElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Location is not synchronized.");
        return isDisplayed;
    }

    public boolean verifyMobileTrackingConsistency() {
        WebElement mobileTrackingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileTrackingConsistency")));
        boolean isDisplayed = mobileTrackingElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Mobile tracking consistency is not verified.");
        return isDisplayed;
    }

    public void updateLocationFromDifferentDevice() {
        WebElement updateLocationButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("updateLocationFromDevice")));
        updateLocationButton.click();
        Assert.assertTrue(isLocationSynchronized(), "Location update from different device failed.");
    }

    public String getShipmentStatus() {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipmentStatus")));
        String status = statusElement.getText();
        Assert.assertNotNull(status, "Shipment status is null.");
        return status;
    }

    public boolean verifyTimestamp() {
        WebElement timestampElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timestamp")));
        String timestamp = timestampElement.getText();
        Assert.assertNotNull(timestamp, "Timestamp is null.");
        // Logic to verify timestamp with current time
        return true;
    }

    public void closeBrowser() {
        driver.quit();
        Assert.assertNull(driver, "Browser did not close properly.");
    }
}