package selenium1.test_scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import selenium1.page_objects.ShipmentTrackingPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RealTimeShipmentStatusTest {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        shipmentTrackingPage = new ShipmentTrackingPage();
        shipmentTrackingPage.navigateToShipmentTrackingPage();
    }

    @Test
    public void testShipmentStatusUpdates() {
        shipmentTrackingPage.enterShipmentID("12345");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "In Transit", "Initial status should be 'In Transit'.");

        shipmentTrackingPage.simulateStatusUpdate("Out for Delivery");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Out for Delivery", "Status should update to 'Out for Delivery'.");

        shipmentTrackingPage.simulateStatusUpdate("Delivered");
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status should update to 'Delivered'.");

        assertTrue(shipmentTrackingPage.verifyTimestamp(), "Timestamp should match the current time.");

        shipmentTrackingPage.refreshPage();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status should remain 'Delivered'.");

        shipmentTrackingPage.logOutAndLogIn();
        assertEquals(shipmentTrackingPage.getShipmentStatus(), "Delivered", "Status should remain 'Delivered' after re-login.");

        assertTrue(shipmentTrackingPage.checkNotificationSettings(), "Notifications should be enabled for real-time updates.");

        shipmentTrackingPage.simulateNetworkIssue();
        assertTrue(shipmentTrackingPage.handleNetworkIssue(), "System should handle network issues gracefully.");

        assertTrue(shipmentTrackingPage.verifyShipmentHistoryLog(), "Shipment history log should contain all updates.");

        assertTrue(shipmentTrackingPage.checkForErrorMessages(), "No error messages should be displayed during updates.");
    }

    @AfterMethod
    public void tearDown() {
        shipmentTrackingPage.closeBrowser();
    }
}