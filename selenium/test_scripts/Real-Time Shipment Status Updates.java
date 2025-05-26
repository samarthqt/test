import com.pageobjects.ShipmentPage;
import com.pageobjects.ShipmentTrackingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

package com.tests;


public class ShipmentStatusTest {
    private ShipmentPage shipmentPage;
    private ShipmentTrackingPage shipmentTrackingPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        shipmentPage = new ShipmentPage();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        shipmentPage.login("67890");
        shipmentTrackingPage.navigateToShipmentTrackingPage("http://example.com/shipmentTracking");
        shipmentTrackingPage.logoutAndLogin("67890", "password");
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentPage.navigateToShipmentTrackingPage();
        shipmentTrackingPage.navigateToShipmentTrackingPage("http://example.com/shipmentTracking");
        Assert.assertTrue(shipmentPage.isTrackingPageDisplayed());
        Assert.assertTrue(shipmentTrackingPage.getCurrentStatus().contains("Tracking Page Displayed"));

        shipmentPage.enterShipmentID("12345");
        shipmentTrackingPage.enterShipmentID("12345");
        Assert.assertTrue(shipmentPage.isShipmentDetailsDisplayed("12345"));
        Assert.assertTrue(shipmentTrackingPage.getCurrentStatus().contains("Shipment Details Displayed"));

        String currentStatus = shipmentPage.checkCurrentStatus();
        String trackingStatus = shipmentTrackingPage.getCurrentStatus();
        Assert.assertEquals(currentStatus, "In Transit");
        Assert.assertEquals(trackingStatus, "In Transit");

        shipmentPage.simulateStatusUpdate("Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("To be delivered");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Out for Delivery");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "To be delivered");

        shipmentPage.simulateStatusUpdate("Delivered");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        String timestamp = shipmentPage.verifyLatestStatusTimestamp();
        String trackingTimestamp = shipmentTrackingPage.getLatestTimestamp();
        Assert.assertTrue(shipmentPage.isTimestampCurrent(timestamp));
        Assert.assertTrue(trackingTimestamp.contains("Current Timestamp"));

        shipmentPage.refreshPage();
        shipmentTrackingPage.refreshPage();
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        shipmentPage.logout();
        shipmentPage.login("67890");
        shipmentTrackingPage.logoutAndLogin("67890", "password");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        Assert.assertTrue(shipmentPage.areNotificationsEnabled());
        Assert.assertTrue(shipmentTrackingPage.checkNotificationSettings());

        shipmentPage.simulateNetworkIssue();
        shipmentTrackingPage.simulateNetworkIssueAndUpdateStatus();
        Assert.assertTrue(shipmentPage.isNetworkIssueHandledGracefully());
        Assert.assertTrue(shipmentTrackingPage.getErrorMessages().contains("Network Issue Handled"));

        Assert.assertTrue(shipmentPage.verifyShipmentHistoryLog());
        Assert.assertTrue(shipmentTrackingPage.getShipmentHistoryLog().contains("Shipment History Log Verified"));

        Assert.assertFalse(shipmentPage.areErrorMessagesDisplayed());
        Assert.assertFalse(shipmentTrackingPage.getErrorMessages().contains("Error Messages Displayed"));

        shipmentPage.updateStatusFromDifferentDevice();
        shipmentTrackingPage.updateStatusFromDifferentDevice();
        Assert.assertTrue(shipmentPage.isStatusSynchronizedAcrossDevices());
        Assert.assertTrue(shipmentTrackingPage.getCurrentStatus().contains("Status Synchronized Across Devices"));

        Assert.assertTrue(shipmentPage.verifyStatusOnMobileDevice());
        Assert.assertTrue(shipmentTrackingPage.verifyShipmentStatusViaSMS().contains("Status Verified via SMS"));

        shipmentPage.rebootSystem();
        shipmentTrackingPage.refreshPage(); // System reboot simulation
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "Delivered");
        Assert.assertEquals(shipmentTrackingPage.checkStatusAfterReboot(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        shipmentPage.logout();
        shipmentTrackingPage.logoutAndLogin("67890", "password");
    }
}