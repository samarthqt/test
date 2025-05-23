package com.tests;

import com.pageobjects.ShipmentPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ShipmentStatusTest {
    private ShipmentPage shipmentPage;

    @BeforeMethod
    public void setUp() {
        shipmentPage = new ShipmentPage();
        shipmentPage.login("67890");
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentPage.navigateToShipmentTrackingPage();
        Assert.assertTrue(shipmentPage.isTrackingPageDisplayed());

        shipmentPage.enterShipmentID("12345");
        Assert.assertTrue(shipmentPage.isShipmentDetailsDisplayed("12345"));

        String currentStatus = shipmentPage.checkCurrentStatus();
        Assert.assertEquals(currentStatus, "In Transit");

        shipmentPage.simulateStatusUpdate("Out for Delivery");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Out for Delivery");

        shipmentPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");

        String timestamp = shipmentPage.verifyLatestStatusTimestamp();
        Assert.assertTrue(shipmentPage.isTimestampCurrent(timestamp));

        shipmentPage.refreshPage();
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");

        shipmentPage.logout();
        shipmentPage.login("67890");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");

        Assert.assertTrue(shipmentPage.areNotificationsEnabled());

        shipmentPage.simulateNetworkIssue();
        Assert.assertTrue(shipmentPage.isNetworkIssueHandledGracefully());

        Assert.assertTrue(shipmentPage.verifyShipmentHistoryLog());

        Assert.assertFalse(shipmentPage.areErrorMessagesDisplayed());

        shipmentPage.updateStatusFromDifferentDevice();
        Assert.assertTrue(shipmentPage.isStatusSynchronizedAcrossDevices());

        Assert.assertTrue(shipmentPage.verifyStatusOnMobileDevice());

        shipmentPage.rebootSystem();
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        shipmentPage.logout();
    }
}```java
// Page Object Model Class: ShipmentTrackingPage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShipmentTrackingPage {
    private WebDriver driver;

    private By trackingField = By.id("trackingField");
    private By statusField = By.id("statusField");
    private By updateButton = By.id("updateButton");
    private By timestamp = By.id("timestamp");
    private By refreshButton = By.id("refreshButton");
    private By logoutButton = By.id("logoutButton");
    private By loginButton = By.id("loginButton");
    private By notificationSettings = By.id("notificationSettings");
    private By historyLog = By.id("historyLog");
    private By errorMessage = By.id("errorMessage");

    public ShipmentTrackingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterShipmentID(String shipmentID) {
        driver.findElement(trackingField).sendKeys(shipmentID);
    }

    public String checkCurrentStatus() {
        return driver.findElement(statusField).getText();
    }

    public void simulateStatusUpdate(String newStatus) {
        WebElement status = driver.findElement(statusField);
        status.clear();
        status.sendKeys(newStatus);
        driver.findElement(updateButton).click();
    }

    public String getTimestamp() {
        return driver.findElement(timestamp).getText();
    }

    public void refreshPage() {
        driver.findElement(refreshButton).click();
    }

    public void logoutAndLogin() {
        driver.findElement(logoutButton).click();
        driver.findElement(loginButton).click();
    }

    public void checkNotificationSettings() {
        driver.findElement(notificationSettings).click();
    }

    public String verifyShipmentHistoryLog() {
        return driver.findElement(historyLog).getText();
    }

    public String checkForErrorMessages() {
        return driver.findElement(errorMessage).getText();
    }
}

// Test Script: ShipmentTrackingTest.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShipmentTrackingTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/shipment-tracking");

        ShipmentTrackingPage shipmentPage = new ShipmentTrackingPage(driver);

        shipmentPage.enterShipmentID("12345");
        System.out.println("Current Status: " + shipmentPage.checkCurrentStatus());

        shipmentPage.simulateStatusUpdate("Out for Delivery");
        shipmentPage.simulateStatusUpdate("Delivered");

        System.out.println("Latest Timestamp: " + shipmentPage.getTimestamp());

        shipmentPage.refreshPage();
        shipmentPage.logoutAndLogin();

        shipmentPage.checkNotificationSettings();

        // Simulate network issue and attempt to update status
        // This part would require additional setup to simulate network issues

        System.out.println("Shipment History Log: " + shipmentPage.verifyShipmentHistoryLog());
        System.out.println("Error Messages: " + shipmentPage.checkForErrorMessages());

        // Attempt to update status from a different device
        // This part would require additional setup involving multiple devices

        // Verify shipment status on a mobile device
        // This part would require additional setup for mobile testing

        // Check shipment status after a system reboot
        // This part would require additional setup to simulate system reboot

        driver.quit();
    }
}
```