package com.tests;
import com.pageobjects.Dynamics365Page;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.ShipmentTrackingPage;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingTest extends WebReusableComponents {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        shipmentTrackingPage.navigateToOrdersModule();
        shipmentTrackingPage.selectOrderById("12345");
        shipmentTrackingPage.updateShipmentStatusToDispatched();
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
package com.tests;


public class InstantShipmentTrackingAlertTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        dynamics365Page.login("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlertForDispatch() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById();
        dynamics365Page.updateShipmentStatusToDispatched();
        boolean alertSent = dynamics365Page.checkAlertSystem();
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = dynamics365Page.verifyCustomerAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
package com.tests;


public class ShipmentTrackingTest extends WebReusableComponents {

    private ShipmentTrackingPage shipmentTrackingPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        shipmentTrackingPage = new ShipmentTrackingPage(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlertForDispatchViaSMS() {
        shipmentTrackingPage.navigateToOrdersModule();
        shipmentTrackingPage.selectOrderById("98765");
        shipmentTrackingPage.updateShipmentStatusToDispatched();
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

package com.tests;



public class UniqueInstantShipmentTrackingAlertTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        dynamics365Page.login("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlertForDispatchViaSMS() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById("98765");
        dynamics365Page.updateShipmentStatusToDispatched();
        boolean alertSent = dynamics365Page.checkAlertSystem();
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = dynamics365Page.verifyCustomerAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}