
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingPage extends WebReusableComponents {

    protected By txtShipmentId = By.id("shipmentId");
    protected By btnCheckStatus = By.id("checkStatus");
    protected By statusMessage = By.id("statusMessage");
    protected By btnSimulateOutForDelivery = By.id("simulateOutForDelivery");
    protected By btnSimulateDelivered = By.id("simulateDelivered");
    protected By timestamp = By.id("timestamp");
    protected By btnRefresh = By.id("refresh");
    protected By btnLogout = By.id("logout");
    protected By notificationSettings = By.id("notificationSettings");
    protected By btnSimulateNetworkIssue = By.id("simulateNetworkIssue");
    protected By shipmentHistoryLog = By.id("shipmentHistoryLog");
    protected By errorMessage = By.id("errorMessage");
    protected By btnUpdateFromDifferentDevice = By.id("updateFromDifferentDevice");
    protected By mobileDeviceStatus = By.id("mobileDeviceStatus");
    protected By systemRebootStatus = By.id("systemRebootStatus");

    public ShipmentTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage() {
        // Implementation to navigate to the shipment tracking page
        // Assuming a URL or navigation method is available
        driver.get("http://example.com/shipment-tracking");
        Assert.assertTrue(driver.getTitle().contains("Shipment Tracking"), "Failed to navigate to Shipment Tracking Page.");
    }

    public void enterShipmentId(String shipmentId) {
        waitUntilElementVisible(txtShipmentId, 3);
        enterText(txtShipmentId, shipmentId);
        Assert.assertEquals(getAttributeValue(txtShipmentId, "value"), shipmentId, "Shipment ID entry failed.");
    }

    public void checkCurrentStatus() {
        waitUntilElementVisible(btnCheckStatus, 3);
        clickElement(btnCheckStatus);
        waitUntilElementVisible(statusMessage, 3);
        String status = getTextFromElement(statusMessage);
        Assert.assertNotNull(status, "Status message is not displayed.");
    }

    public void simulateStatusUpdateOutForDelivery() {
        waitUntilElementVisible(btnSimulateOutForDelivery, 3);
        clickElement(btnSimulateOutForDelivery);
        Assert.assertTrue(getTextFromElement(statusMessage).contains("Out for Delivery"), "Status update to 'Out for Delivery' failed.");
    }

    public void simulateStatusUpdateDelivered() {
        waitUntilElementVisible(btnSimulateDelivered, 3);
        clickElement(btnSimulateDelivered);
        Assert.assertTrue(getTextFromElement(statusMessage).contains("Delivered"), "Status update to 'Delivered' failed.");
    }

    public void verifyTimestampOfLatestStatusUpdate(String expectedTimestamp) {
        waitUntilElementVisible(timestamp, 3);
        String actualTimestamp = getTextFromElement(timestamp);
        Assert.assertEquals(actualTimestamp, expectedTimestamp, "Timestamp does not match.");
    }

    public void refreshPage() {
        waitUntilElementVisible(btnRefresh, 3);
        clickElement(btnRefresh);
        Assert.assertTrue(driver.getTitle().contains("Shipment Tracking"), "Page refresh failed.");
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        // Assuming a login method is available
        login("username", "password");
        Assert.assertTrue(driver.getTitle().contains("Shipment Tracking"), "Logout and login failed.");
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        WebElement settings = driver.findElement(notificationSettings);
        Assert.assertTrue(settings.isDisplayed(), "Notification settings are not visible.");
    }

    public void simulateNetworkIssueAndAttemptUpdate() {
        waitUntilElementVisible(btnSimulateNetworkIssue, 3);
        clickElement(btnSimulateNetworkIssue);
        Assert.assertTrue(getTextFromElement(errorMessage).contains("Network Issue"), "Network issue simulation failed.");
    }

    public void verifyShipmentHistoryLog() {
        waitUntilElementVisible(shipmentHistoryLog, 3);
        WebElement log = driver.findElement(shipmentHistoryLog);
        Assert.assertTrue(log.isDisplayed(), "Shipment history log is not visible.");
    }

    public void checkForErrorMessagesDuringStatusUpdates() {
        waitUntilElementVisible(errorMessage, 3);
        String error = getTextFromElement(errorMessage);
        Assert.assertNotNull(error, "Error message is not displayed.");
    }

    public void attemptUpdateFromDifferentDevice() {
        waitUntilElementVisible(btnUpdateFromDifferentDevice, 3);
        clickElement(btnUpdateFromDifferentDevice);
        Assert.assertTrue(getTextFromElement(mobileDeviceStatus).contains("Updated"), "Update from different device failed.");
    }

    public void verifyShipmentStatusOnMobileDevice() {
        waitUntilElementVisible(mobileDeviceStatus, 3);
        String status = getTextFromElement(mobileDeviceStatus);
        Assert.assertNotNull(status, "Shipment status on mobile device is not displayed.");
    }

    public void checkShipmentStatusAfterSystemReboot() {
        waitUntilElementVisible(systemRebootStatus, 3);
        String status = getTextFromElement(systemRebootStatus);
        Assert.assertNotNull(status, "Shipment status after system reboot is not displayed.");
    }
}
