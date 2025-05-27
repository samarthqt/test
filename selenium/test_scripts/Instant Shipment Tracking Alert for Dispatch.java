import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.ShipmentTrackingPage;
import com.framework.reusable.WebReusableComponents;
import com.pageobjects.Dynamics365Page;

package com.tests;

public class ShipmentTrackingTest extends WebReusableComponents {

    private ShipmentTrackingPage shipmentTrackingPage;
    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        dynamics365Page = new Dynamics365Page(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlertForDispatchViaSMS() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrder98765();
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertSent = shipmentTrackingPage.checkAlertSystemForOutgoingAlerts("customer@example.com");
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = shipmentTrackingPage.verifyAlertReceivedByCustomer("Your shipment has been dispatched.");
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}