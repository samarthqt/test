import com.pageobjects.ShipmentTrackingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

package com.tests;


public class RealTimeShipmentStatusUpdatesViaSMSTest {
    private ShipmentTrackingPage shipmentTrackingPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        shipmentTrackingPage.navigateToShipmentTrackingPage();
    }

    @Test
    public void testRealTimeShipmentStatusUpdatesViaSMS() {
        shipmentTrackingPage.enterShipmentID("12345");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "In Transit");

        shipmentTrackingPage.simulateStatusUpdate("To be delivered");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "To be delivered");

        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        String timestamp = shipmentTrackingPage.verifyTimestampOfLatestStatusUpdate();
        Assert.assertTrue(shipmentTrackingPage.isTimestampCurrent(timestamp));

        shipmentTrackingPage.refreshPage();
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        shipmentTrackingPage.logoutAndLoginBack();
        Assert.assertEquals(shipmentTrackingPage.checkCurrentStatus(), "Delivered");

        Assert.assertTrue(shipmentTrackingPage.checkNotificationSettings());

        shipmentTrackingPage.simulateNetworkIssueAndUpdateStatus("Delivered");
        Assert.assertTrue(shipmentTrackingPage.isNetworkIssueHandledGracefully());

        Assert.assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog().contains("Delivered"));

        Assert.assertFalse(shipmentTrackingPage.checkForErrorMessages());

        shipmentTrackingPage.attemptStatusUpdateFromDifferentDevice("Delivered");
        Assert.assertTrue(shipmentTrackingPage.isStatusSynchronizedAcrossDevices());

        Assert.assertTrue(shipmentTrackingPage.verifyShipmentStatusUsingSMS().contains("Delivered"));

        shipmentTrackingPage.rebootSystem();
        Assert.assertEquals(shipmentTrackingPage.checkShipmentStatusAfterSystemReboot(), "Delivered");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}