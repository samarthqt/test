package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pageobjs.LiveTrackingPage;
import static org.testng.Assert.*;

public class LiveTrackingTest {

    private LiveTrackingPage liveTrackingPage;

    @BeforeMethod
    public void setUp() {
        liveTrackingPage = new LiveTrackingPage();
        liveTrackingPage.navigateToLiveTrackingPage();
    }

    @Test
    public void testLiveTrackingFunctionality() {
        liveTrackingPage.enterShipmentID("54321");
        assertTrue(liveTrackingPage.isTrackingDetailsDisplayed(), "Tracking details not displayed.");

        assertTrue(liveTrackingPage.isCurrentLocationDisplayed(), "Current location not displayed.");

        liveTrackingPage.simulateLocationChange();
        assertTrue(liveTrackingPage.isLocationUpdatedInRealTime(), "Location not updated in real-time.");

        assertTrue(liveTrackingPage.isEstimatedDeliveryTimeDisplayed(), "Estimated delivery time not displayed.");

        liveTrackingPage.refreshPage();
        assertTrue(liveTrackingPage.isTrackingInformationConsistent(), "Tracking information inconsistent after refresh.");

        liveTrackingPage.logOutAndLogIn();
        assertTrue(liveTrackingPage.isTrackingInformationAvailable(), "Tracking information not available after login.");

        assertTrue(liveTrackingPage.areNotificationsEnabled(), "Notifications not enabled for live tracking.");

        liveTrackingPage.simulateNetworkIssue();
        assertTrue(liveTrackingPage.isNetworkIssueHandledGracefully(), "Network issue not handled gracefully.");

        assertTrue(liveTrackingPage.isTrackingHistoryLogCorrect(), "Tracking history log incorrect.");

        assertFalse(liveTrackingPage.areErrorMessagesDisplayed(), "Error messages displayed during location updates.");

        liveTrackingPage.updateLocationFromDifferentDevice();
        assertTrue(liveTrackingPage.isLocationSynchronizedAcrossDevices(), "Location not synchronized across devices.");

        assertTrue(liveTrackingPage.isMobileTrackingConsistent(), "Mobile tracking inconsistent with desktop view.");

        liveTrackingPage.rebootSystem();
        assertTrue(liveTrackingPage.isTrackingInformationAvailableAfterReboot(), "Tracking information not available after reboot.");

        assertTrue(liveTrackingPage.isLiveTrackingAccurate(), "Live tracking information not accurate.");
    }

    @AfterMethod
    public void tearDown() {
        liveTrackingPage.closeBrowser();
    }
}