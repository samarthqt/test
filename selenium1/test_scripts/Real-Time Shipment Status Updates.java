package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.ShipmentTrackingPage;
import static org.testng.Assert.*;
import java.util.*;

public class ShipmentStatusTest {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.login("67890");
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        assertTrue(shipmentTrackingPage.isTrackingPageDisplayed());
        shipmentTrackingPage.enterShipmentID("12345");
        assertTrue(shipmentTrackingPage.isShipmentDetailsDisplayed("12345"));
        shipmentTrackingPage.selectLocation();
        shipmentTrackingPage.clickOkButton();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "In Transit");
        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertEquals(shipmentTrackingPage.getLatestTimestamp(), shipmentTrackingPage.getCurrentTime());
        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        shipmentTrackingPage.logout();
        shipmentTrackingPage.login("67890");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertTrue(shipmentTrackingPage.areNotificationsEnabled());
        shipmentTrackingPage.simulateNetworkIssue();
        assertTrue(shipmentTrackingPage.handleNetworkIssueGracefully());
        assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog());
        assertFalse(shipmentTrackingPage.isErrorMessageDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.logout();
    }
}

package com.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.pageobjects.LiveTrackingPage;
import static org.testng.Assert.*;
import java.util.*;

public class LiveTrackingTest {

    private LiveTrackingPage liveTrackingPage;

    @BeforeMethod
    public void setUp() {
        liveTrackingPage = new LiveTrackingPage();
        liveTrackingPage.login("09876");
    }

    @Test
    public void testLiveTrackingForShipments() {
        liveTrackingPage.navigateToLiveTrackingPage();
        assertTrue(liveTrackingPage.isLiveTrackingPageDisplayed());
        liveTrackingPage.enterShipmentID("54321");
        assertTrue(liveTrackingPage.isLiveTrackingDetailsDisplayed("54321"));
        assertEquals(liveTrackingPage.getCurrentLocation(), liveTrackingPage.getExpectedLocationOnMap());
    }

    @AfterMethod
    public void tearDown() {
        liveTrackingPage.logout();
    }
}