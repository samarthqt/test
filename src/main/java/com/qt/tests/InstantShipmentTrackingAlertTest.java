package com.qt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qt.pshop.pageobjs.LoginPage;
import com.qt.pshop.pageobjs.OrdersPage;
import com.qt.pshop.pageobjs.AlertSystemPage;
import static org.testng.Assert.assertTrue;

public class InstantShipmentTrackingAlertTest {

    private LoginPage loginPage;
    private OrdersPage ordersPage;
    private AlertSystemPage alertSystemPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        ordersPage = new OrdersPage();
        alertSystemPage = new AlertSystemPage();
    }

    @Test
    public void testInstantShipmentTrackingAlert() {
        loginPage.login("validUsername", "validPassword");
        assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed.");

        ordersPage.navigateToOrdersModule();
        assertTrue(ordersPage.isOrdersModuleDisplayed(), "Orders module is not displayed.");

        ordersPage.selectOrderById("333");
        assertTrue(ordersPage.isOrderDetailsDisplayed("333"), "Order details for ID 333 are not displayed.");

        ordersPage.updateShipmentStatusToShipped();
        assertTrue(ordersPage.isShipmentStatusUpdatedToShipped(), "Shipment status is not updated to 'Shipped'.");

        alertSystemPage.checkOutgoingAlerts();
        assertTrue(alertSystemPage.isAlertSentToCustomer("customer@qualitest.com"), "Alert is not sent to customer@qualitest.com.");

        assertTrue(alertSystemPage.verifyCustomerAlert("Your shipment has been shipped."), "Customer did not receive the correct alert.");
    }

    @AfterMethod
    public void tearDown() {
        // Code to close browser or clean up resources
    }
}
