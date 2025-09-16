package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pageobjs.ShipmentTrackingPage;
import static org.testng.Assert.*;

public class ShipmentStatusTest {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.navigateToShipmentTrackingPage();
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.enterShipmentID("12345");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "In Transit");

        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Out for Delivery");

        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        assertTrue(shipmentTrackingPage.verifyTimestampMatchesCurrentTime());

        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        shipmentTrackingPage.logOutAndLogIn();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");

        assertTrue(shipmentTrackingPage.areNotificationsEnabled());

        shipmentTrackingPage.simulateNetworkIssueAndRetry();

        assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog());

        assertFalse(shipmentTrackingPage.areErrorMessagesDisplayed());

        shipmentTrackingPage.updateStatusFromDifferentDevice();
        assertTrue(shipmentTrackingPage.isStatusSynchronizedAcrossDevices());

        assertTrue(shipmentTrackingPage.verifyStatusOnMobileDevice());

        shipmentTrackingPage.rebootSystem();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.closeBrowser();
    }
}