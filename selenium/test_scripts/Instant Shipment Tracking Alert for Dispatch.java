package com.tests;
import org.testng.Assert;

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
```java

@Test
public void verifyInstantShipmentTrackingAlert() {
    shipmentTrackingPage.navigateToOrdersModule();
    shipmentTrackingPage.selectOrderById("12345");
    shipmentTrackingPage.updateShipmentStatusToDispatched();
    
    // Improved: Adding explicit wait to ensure the alert system has enough time to process
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(shipmentTrackingPage.getAlertSystemElement()));

    boolean alertSent = shipmentTrackingPage.checkAlertSystemForOutgoingAlerts("customer@example.com");
    Assert.assertTrue(alertSent, "Alert was not sent to the customer."); // Improved: Using TestNG Assert
    
    boolean alertReceived = shipmentTrackingPage.verifyAlertReceivedByCustomer("Your shipment has been dispatched.");
    Assert.assertTrue(alertReceived, "Customer did not receive the expected alert."); // Improved: Using TestNG Assert
}
```