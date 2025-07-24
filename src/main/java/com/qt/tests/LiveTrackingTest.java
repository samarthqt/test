package com.qt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.pshop.pageobjs.LiveTrackingPage;
import com.framework.reusable.WebReusableComponents;

public class LiveTrackingTest {

    private LiveTrackingPage liveTrackingPage;

    @BeforeMethod
    public void setUp() {
        WebReusableComponents.initializeDriver();
        liveTrackingPage = new LiveTrackingPage();
    }

    @Test
    public void testLiveTrackingForShipments() {
        liveTrackingPage.navigateToLiveTrackingPage();
        liveTrackingPage.enterShipmentId("54321");
        liveTrackingPage.verifyCurrentLocation();
        liveTrackingPage.simulateLocationChange();
        liveTrackingPage.verifyEstimatedDeliveryTime();
        liveTrackingPage.refreshPage();
        liveTrackingPage.logOutAndLogIn();
        liveTrackingPage.checkNotificationSettings();
        liveTrackingPage.simulateNetworkIssue();
        liveTrackingPage.verifyTrackingHistoryLog();
        liveTrackingPage.checkForErrorMessages();
        liveTrackingPage.updateLocationFromDifferentDevice();
        liveTrackingPage.verifyMobileTrackingConsistency();
        liveTrackingPage.checkTrackingAfterReboot();
        liveTrackingPage.verifyTrackingAccuracy();
    }

    @AfterMethod
    public void tearDown() {
        WebReusableComponents.quitDriver();
    }
}