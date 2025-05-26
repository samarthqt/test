import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebDriver;
import com.pageobjects.Dynamics365Page;

package com.tests;


public class ShipmentTrackingTest extends WebReusableComponents {

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrder12345();
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertSent = dynamics365Page.verifyCustomerAlert();
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

    private Dynamics365Page dynamics365Page;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        dynamics365Page = new Dynamics365Page(driver);
        loginToSystem("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrder98765(); // Updated to select correct order ID
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertSent = dynamics365Page.verifyCustomerAlert();
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = dynamics365Page.verifyCustomerAlert();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}