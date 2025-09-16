package selenium1.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium1.page_objects.ShipmentTrackingPage;
import static org.testng.Assert.*;

public class RealTimeShipmentStatusTest {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.navigateToShipmentTrackingPage();
    }

    @Test
    public void testRealTimeShipmentStatusUpdates() {
        shipmentTrackingPage.enterShipmentID("12345");
        assertTrue(shipmentTrackingPage.isShipmentDetailsDisplayed("12345"));
        shipmentTrackingPage.selectLocation();
        shipmentTrackingPage.clickOkButton();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "In Transit");
        shipmentTrackingPage.simulateStatusUpdate("To be delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Out for Delivery");
        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertTrue(shipmentTrackingPage.isTimestampCorrect());
        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        shipmentTrackingPage.logOutAndLogIn();
        assertEquals(shipmentTrackingPage.getCurrentStatus(), "Delivered");
        assertTrue(shipmentTrackingPage.areNotificationsEnabled());
        shipmentTrackingPage.simulateNetworkIssueAndRetry();
        assertTrue(shipmentTrackingPage.isShipmentHistoryLogCorrect());
        assertFalse(shipmentTrackingPage.isErrorMessageDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.closeBrowser();
    }
}