import com.pageobjects.ShipmentTrackingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

package com.tests;


public class ShipmentStatusTest {
    private WebDriver driver;
    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        shipmentTrackingPage.logoutAndLogin();
    }

    @Test
    public void testRealTimeShipmentStatusUpdatesViaSMS() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        shipmentTrackingPage.enterShipmentId("12345");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "In Transit");

        shipmentTrackingPage.simulateStatusUpdate("To be delivered");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "To be delivered");

        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        String timestamp = shipmentTrackingPage.verifyTimestampOfLatestStatusUpdate();
        Assert.assertTrue(shipmentTrackingPage.isTimestampCurrent(timestamp));

        shipmentTrackingPage.refreshPage();
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        shipmentTrackingPage.logoutAndLogin();
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        String notifications = shipmentTrackingPage.checkNotificationSettings();
        Assert.assertTrue(notifications.contains("Enabled"));

        shipmentTrackingPage.simulateNetworkIssueAndAttemptUpdate();
        Assert.assertTrue(shipmentTrackingPage.isNetworkIssueHandledGracefully());

        String historyLog = shipmentTrackingPage.verifyShipmentHistoryLog();
        Assert.assertTrue(historyLog.contains("12345"));

        String errorMessage = shipmentTrackingPage.checkErrorMessagesDuringStatusUpdates();
        Assert.assertFalse(errorMessage.contains("Error"));

        shipmentTrackingPage.attemptUpdateStatusFromDifferentDevice();
        Assert.assertTrue(shipmentTrackingPage.isStatusSynchronizedAcrossDevices());

        String smsStatus = shipmentTrackingPage.verifyShipmentStatusUsingSMS();
        Assert.assertEquals(smsStatus, "Delivered");

        shipmentTrackingPage.rebootSystem();
        Assert.assertEquals(shipmentTrackingPage.checkShipmentStatusAfterSystemReboot(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.logoutAndLogin();
        driver.quit();
    }
}