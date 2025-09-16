package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.ShipmentTrackingPage;
import static org.testng.Assert.*;

public class ShipmentTrackingTest {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.login();
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        assertTrue(shipmentTrackingPage.isShipmentTrackingPageDisplayed());
        shipmentTrackingPage.enterShipmentID("12345");
        assertTrue(shipmentTrackingPage.isShipmentDetailsDisplayed("12345"));
        shipmentTrackingPage.selectLocation();
        shipmentTrackingPage.clickOkButton();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "In Transit");
        shipmentTrackingPage.simulateStatusUpdate("To be delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertEquals(shipmentTrackingPage.getLatestTimestamp(), shipmentTrackingPage.getCurrentTime());
        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        shipmentTrackingPage.logoutAndLogin();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertTrue(shipmentTrackingPage.areNotificationsEnabled());
        shipmentTrackingPage.simulateNetworkIssue();
        assertTrue(shipmentTrackingPage.isSystemHandlingIssueGracefully());
        assertTrue(shipmentTrackingPage.isShipmentHistoryLogCorrect());
        assertFalse(shipmentTrackingPage.isErrorMessageDisplayed());
    }

    @Test
    public void testLiveTrackingForShipments() {
        shipmentTrackingPage.navigateToLiveTrackingPage();
        assertTrue(shipmentTrackingPage.isLiveTrackingPageDisplayed());
        shipmentTrackingPage.enterShipmentID("54321");
        assertTrue(shipmentTrackingPage.isLiveTrackingDetailsDisplayed("54321"));
        assertEquals(shipmentTrackingPage.getCurrentLocation(), shipmentTrackingPage.getExpectedLocation());
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.logout();
    }
}