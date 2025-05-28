import com.pageobjects.LiveTrackingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;
package com.tests;


public class LiveTrackingTest {
    private LiveTrackingPage liveTrackingPage;

    @BeforeMethod
    public void setUp() {
        liveTrackingPage = new LiveTrackingPage();
        liveTrackingPage.login("09876");
    }

    @Test
    public void testLiveTracking() {
        liveTrackingPage.navigateToLiveTrackingPage();
        assertTrue(liveTrackingPage.isLiveTrackingPageDisplayed(), "Live tracking page is not displayed.");

        liveTrackingPage.enterShipmentID("54321");
        assertTrue(liveTrackingPage.isTrackingDetailsDisplayed("54321"), "Tracking details are not displayed.");

        assertTrue(liveTrackingPage.isCurrentLocationDisplayed(), "Current location is not displayed.");

        liveTrackingPage.simulateLocationChange();
        assertTrue(liveTrackingPage.isLocationUpdatedInRealTime(), "Location is not updated in real-time.");

        assertTrue(liveTrackingPage.isEstimatedDeliveryTimeDisplayed(), "Estimated delivery time is not displayed.");

        liveTrackingPage.refreshPage();
        assertTrue(liveTrackingPage.isTrackingInformationConsistent(), "Tracking information is not consistent after refresh.");

        liveTrackingPage.logout();
        liveTrackingPage.login("09876");
        assertTrue(liveTrackingPage.isTrackingInformationAvailable(), "Tracking information is not available after re-login.");

        assertTrue(liveTrackingPage.areNotificationsEnabled(), "Notifications are not enabled for live tracking updates.");

        liveTrackingPage.simulateNetworkIssue();
        assertTrue(liveTrackingPage.isNetworkIssueHandledGracefully(), "Network issue is not handled gracefully.");

        assertTrue(liveTrackingPage.isTrackingHistoryLogCorrect(), "Tracking history log is incorrect.");

        assertFalse(liveTrackingPage.areErrorMessagesDisplayed(), "Error messages are displayed during location updates.");

        liveTrackingPage.updateLocationFromDifferentDevice();
        assertTrue(liveTrackingPage.isLocationSynchronizedAcrossDevices(), "Location is not synchronized across devices.");

        assertTrue(liveTrackingPage.isMobileTrackingConsistent(), "Mobile tracking is not consistent with desktop view.");

        liveTrackingPage.rebootSystem();
        assertTrue(liveTrackingPage.isTrackingInformationAvailableAfterReboot(), "Tracking information is not available after system reboot.");

        assertTrue(liveTrackingPage.isLiveTrackingAccurate(), "Live tracking information is not accurate.");
    }

    @AfterMethod
    public void tearDown() {
        liveTrackingPage.logout();
    }
}