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
    public void testShipmentStatusChanges() {
        liveTrackingPage.navigateToLiveTrackingPage();
        liveTrackingPage.enterShipmentId("12345");
        liveTrackingPage.checkCurrentStatus();
        liveTrackingPage.simulateStatusUpdate("Out for Delivery");
        liveTrackingPage.simulateStatusUpdate("Delivered");
        liveTrackingPage.verifyLatestStatusTimestamp();
        liveTrackingPage.refreshPage();
        liveTrackingPage.logOutAndLogIn();
        liveTrackingPage.checkNotificationSettings();
        liveTrackingPage.simulateNetworkIssue();
        liveTrackingPage.verifyShipmentHistoryLog();
        liveTrackingPage.checkForErrorMessages();
        liveTrackingPage.updateStatusFromDifferentDevice();
        liveTrackingPage.verifyShipmentStatusOnMobile();
        liveTrackingPage.checkShipmentStatusAfterReboot();
    }

    @AfterMethod
    public void tearDown() {
        WebReusableComponents.quitDriver();
    }
}
