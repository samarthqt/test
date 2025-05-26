import com.pageobjects.ShipmentTrackingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

package com.tests;


public class ShipmentStatusTest {
    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.login();
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        Assert.assertTrue(shipmentTrackingPage.isTrackingPageDisplayed());

        shipmentTrackingPage.enterShipmentId("12345");
        Assert.assertTrue(shipmentTrackingPage.isShipmentDetailsDisplayed("12345"));

        String currentStatus = shipmentTrackingPage.getCurrentStatus();
        Assert.assertEquals(currentStatus, "In Transit");

        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Out for Delivery");

        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        String timestamp = shipmentTrackingPage.getLatestStatusTimestamp();
        Assert.assertTrue(shipmentTrackingPage.isTimestampCurrent(timestamp));

        shipmentTrackingPage.refreshPage();
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        shipmentTrackingPage.logout();
        shipmentTrackingPage.login();
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        shipmentTrackingPage.checkNotificationSettings();
        Assert.assertTrue(shipmentTrackingPage.areNotificationsEnabled());

        shipmentTrackingPage.simulateNetworkIssue();
        Assert.assertTrue(shipmentTrackingPage.isNetworkIssueHandledGracefully());

        Assert.assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog());

        Assert.assertFalse(shipmentTrackingPage.areErrorMessagesDisplayed());

        shipmentTrackingPage.updateStatusFromDifferentDevice();
        Assert.assertTrue(shipmentTrackingPage.isStatusSynchronizedAcrossDevices());

        shipmentTrackingPage.verifyShipmentStatusViaSMS();
        Assert.assertTrue(shipmentTrackingPage.verifyStatusOnMobileDevice());

        shipmentTrackingPage.checkShipmentStatusAfterReboot();
        Assert.assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.logout();
    }
}