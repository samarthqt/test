
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingPage extends WebReusableComponents {

    protected By txtShipmentId = By.id("shipmentId");
    protected By locationDropdown = By.id("location");
    protected By btnOk = By.id("okButton");
    protected By lblCurrentStatus = By.id("currentStatus");
    protected By lblTimestamp = By.id("timestamp");
    protected By btnRefresh = By.id("refreshButton");
    protected By btnLogout = By.id("logoutButton");
    protected By notificationSettings = By.id("notificationSettings");
    protected By errorMessage = By.id("errorMessage");
    protected By shipmentHistoryLog = By.id("shipmentHistoryLog");

    public ShipmentTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToShipmentTrackingPage() {
        launchUrl("http://example.com/shipment-tracking");
        maximizeWindow();
    }

    public void enterShipmentId(String shipmentId) {
        waitUntilElementVisible(txtShipmentId, 3);
        enterText(txtShipmentId, shipmentId);
    }

    public void selectLocation(String location) {
        waitUntilElementVisible(locationDropdown, 3);
        selectByValue(locationDropdown, location);
    }

    public void clickOkButton() {
        waitUntilElementVisible(btnOk, 3);
        clickElement(btnOk);
    }

    public void checkCurrentStatus(String expectedStatus) {
        waitUntilElementVisible(lblCurrentStatus, 3);
        String actualStatus = getTextFromElement(lblCurrentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Current status does not match.");
    }

    public void simulateStatusUpdate(String newStatus) {
        // Simulate status update logic
        WebElement statusElement = driver.findElement(lblCurrentStatus);
        statusElement.clear();
        statusElement.sendKeys(newStatus);
        clickElement(btnOk);
    }

    public void verifyTimestamp(String expectedTimestamp) {
        waitUntilElementVisible(lblTimestamp, 3);
        String actualTimestamp = getTextFromElement(lblTimestamp);
        Assert.assertEquals(actualTimestamp, expectedTimestamp, "Timestamp does not match.");
    }

    public void refreshPage() {
        waitUntilElementVisible(btnRefresh, 3);
        clickElement(btnRefresh);
    }

    public void logoutAndLogin() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        // Logic to log back in
        launchUrl("http://example.com/login");
        enterText(By.id("username"), "user");
        enterText(By.id("password"), "pass");
        clickElement(By.id("loginButton"));
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        clickElement(notificationSettings);
        // Verify notification settings logic
        Assert.assertTrue(driver.findElement(By.id("notificationEnabled")).isSelected(), "Notification is not enabled.");
    }

    public void simulateNetworkIssueAndUpdateStatus() {
        // Simulate network issue and update status logic
        try {
            driver.findElement(lblCurrentStatus).sendKeys("Network Issue");
            clickElement(btnOk);
        } catch (Exception e) {
            System.out.println("Network issue encountered.");
        }
    }

    public void verifyShipmentHistoryLog() {
        waitUntilElementVisible(shipmentHistoryLog, 3);
        String logText = getTextFromElement(shipmentHistoryLog);
        Assert.assertTrue(logText.contains("Shipment updated"), "Shipment history log does not contain expected text.");
    }

    public void checkForErrorMessages() {
        waitUntilElementVisible(errorMessage, 3);
        String errorText = getTextFromElement(errorMessage);
        Assert.assertTrue(errorText.isEmpty(), "Error message is displayed: " + errorText);
    }
}
