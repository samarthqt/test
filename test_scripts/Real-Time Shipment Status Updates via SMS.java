package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShipmentTrackingPage;
import org.testng.Assert;

public class RealTimeShipmentStatusTest {
    private WebDriver driver;
    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        driver.get("http://example.com/login");
        // Assume login is successful
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.navigateToShipmentTrackingPage();
        Assert.assertTrue(shipmentTrackingPage.isShipmentTrackingPageDisplayed());
        shipmentTrackingPage.enterShipmentID("12345");
        Assert.assertTrue(shipmentTrackingPage.isShipmentDetailsDisplayed("12345"));
        shipmentTrackingPage.selectLocation();
        shipmentTrackingPage.clickOkButton();
        Assert.assertEquals(shipmentTrackingPage.getCurrentShipmentStatus(), "In Transit");
        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        Assert.assertEquals(shipmentTrackingPage.getCurrentShipmentStatus(), "Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        Assert.assertEquals(shipmentTrackingPage.getCurrentShipmentStatus(), "Delivered");
        Assert.assertTrue(shipmentTrackingPage.isTimestampCorrect());
        shipmentTrackingPage.refreshPage();
        Assert.assertEquals(shipmentTrackingPage.getCurrentShipmentStatus(), "Delivered");
        shipmentTrackingPage.logoutAndLogin();
        Assert.assertEquals(shipmentTrackingPage.getCurrentShipmentStatus(), "Delivered");
        Assert.assertTrue(shipmentTrackingPage.areNotificationsEnabled());
        shipmentTrackingPage.simulateNetworkIssue();
        Assert.assertTrue(shipmentTrackingPage.isNetworkIssueHandledGracefully());
        Assert.assertTrue(shipmentTrackingPage.isShipmentHistoryLogCorrect());
        Assert.assertFalse(shipmentTrackingPage.areErrorMessagesDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

public class LiveTrackingTest {
    private WebDriver driver;
    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        driver.get("http://example.com/login");
        // Assume login is successful
    }

    @Test
    public void testLiveTrackingForShipments() {
        shipmentTrackingPage.navigateToLiveTrackingPage();
        Assert.assertTrue(shipmentTrackingPage.isLiveTrackingPageDisplayed());
        shipmentTrackingPage.enterShipmentID("54321");
        Assert.assertTrue(shipmentTrackingPage.isLiveTrackingDetailsDisplayed("54321"));
        Assert.assertTrue(shipmentTrackingPage.isCurrentLocationDisplayedOnMap());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}