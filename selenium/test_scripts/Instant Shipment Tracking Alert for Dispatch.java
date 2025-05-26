import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.Dynamics365Page;
import com.framework.reusable.WebReusableComponents;

package com.tests;

public class ShipmentTrackingTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        dynamics365Page.login("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById("98765");
        dynamics365Page.updateShipmentStatus("Dispatched");
        dynamics365Page.checkAlertSystem();
        boolean alertReceived = dynamics365Page.verifyCustomerAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}