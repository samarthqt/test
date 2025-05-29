package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.ShipmentTrackingPage;
import static org.testng.Assert.assertEquals;

public class ShipmentStatusTest {
    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.login("user", "password");
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        assertEquals(shipmentTrackingPage.getPageTitle(), "Shipment Tracking");
        shipmentTrackingPage.enterShipmentId("12345");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "In Transit");
        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered");
        assertEquals(shipmentTrackingPage.getTimestamp(), shipmentTrackingPage.getCurrentTime());
        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered");
        shipmentTrackingPage.logoutAndLogin();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered");
        assertEquals(shipmentTrackingPage.getNotificationSettings(), "Enabled");
        shipmentTrackingPage.simulateNetworkIssue();
        assertEquals(shipmentTrackingPage.getErrorMessages(), "");
        assertEquals(shipmentTrackingPage.getShipmentHistoryLog(), "Complete");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.logout();
    }
}