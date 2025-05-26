import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.framework.reusable.WebReusableComponents;
import com.pageobjects.Dynamics365Page;

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
        dynamics365Page.selectOrderById("12345");
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertSent = dynamics365Page.isCustomerAlertReceived();
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = dynamics365Page.isCustomerAlertReceived();
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
        dynamics365Page.login("validUsername", "validPassword");
    }

    @Test
    public void verifyInstantShipmentTrackingAlert() {
        dynamics365Page.navigateToOrdersModule();
        dynamics365Page.selectOrderById("98765");
        dynamics365Page.updateShipmentStatusToDispatched();
        dynamics365Page.checkAlertSystem();
        boolean alertSent = dynamics365Page.isCustomerAlertReceived();
        assert alertSent : "Alert was not sent to the customer.";
        boolean alertReceived = dynamics365Page.isCustomerAlertReceived();
        assert alertReceived : "Customer did not receive the expected alert.";
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}