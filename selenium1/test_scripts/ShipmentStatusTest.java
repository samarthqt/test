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

        shipmentPage.checkCurrentStatus();

        shipmentPage.simulateStatusUpdate("To be delivered");
        Assert.assertEquals(shipmentPage.checkCurrentStatus(), "To be delivered");

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
    }

    @AfterMethod
    public void tearDown() {
        shipmentPage.logout();
    }
}