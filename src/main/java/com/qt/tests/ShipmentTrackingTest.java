package com.qt.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.qt.pshop.pageobjs.LoginPage;
import com.qt.pshop.pageobjs.OrdersPage;
import com.qt.pshop.pageobjs.AlertPage;
import static org.testng.Assert.assertTrue;

public class ShipmentTrackingTest {

    private LoginPage loginPage;
    private OrdersPage ordersPage;
    private AlertPage alertPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        ordersPage = new OrdersPage();
        alertPage = new AlertPage();
    }

    @Test
    public void testShipmentTrackingAlert() {
        loginPage.login("validUsername", "validPassword");
        assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed.");

        ordersPage.navigateToOrdersModule();
        assertTrue(ordersPage.isOrdersModuleDisplayed(), "Orders module is not displayed.");

        ordersPage.selectOrderById("12345");
        assertTrue(ordersPage.isOrderDetailsDisplayed("12345"), "Order details for ID 12345 are not displayed.");

        ordersPage.updateShipmentStatus("Dispatched");
        assertTrue(ordersPage.isShipmentStatusUpdated("Dispatched"), "Shipment status is not updated to 'Dispatched'.");

        alertPage.checkOutgoingAlerts();
        assertTrue(alertPage.isAlertSent("customer@example.com"), "Alert is not sent to customer@example.com.");

        assertTrue(alertPage.verifyAlertReceived("Your shipment has been dispatched."), "Customer did not receive the correct alert.");
    }

    @AfterMethod
    public void tearDown() {
        // Clean up resources
    }
}