package com.qt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.pshop.pageobjs.ShipmentTrackingPage;
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
        assertTrue(shipmentTrackingPage.isTrackingPageDisplayed(), "Shipment tracking page is not displayed.");
        shipmentTrackingPage.enterShipmentID("12345");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "In Transit", "Initial status is incorrect.");
        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Out for Delivery", "Status did not update to 'Out for Delivery'.");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status did not update to 'Delivered'.");
        assertTrue(shipmentTrackingPage.verifyTimestamp(), "Timestamp does not match current time.");
        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status changed after refresh.");
        shipmentTrackingPage.logOutAndLogIn();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status changed after re-login.");
        assertTrue(shipmentTrackingPage.areNotificationsEnabled(), "Notifications are not enabled.");
        shipmentTrackingPage.simulateNetworkIssue();
        assertTrue(shipmentTrackingPage.isNetworkIssueHandled(), "Network issue was not handled gracefully.");
        assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog(), "Shipment history log is incorrect.");
        assertFalse(shipmentTrackingPage.hasErrorMessages(), "Error messages were displayed during updates.");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.closeBrowser();
    }
}