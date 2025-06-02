package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class Dynamics365Page extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By ordersModule = By.id("ordersModule");
    protected By orderIdField = By.id("orderId");
    protected By btnSearchOrder = By.id("searchOrder");
    protected By shipmentStatusDropdown = By.id("shipmentStatus");
    protected By btnUpdateStatus = By.id("updateStatus");
    protected By alertSystem = By.id("alertSystem");
    protected By customerAlert = By.id("customerAlert");

    public Dynamics365Page() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs into Dynamics 365 using the provided username and password.
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void loginToDynamics365(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(ordersModule), "Login failed, orders module not visible.");
    }

    /**
     * Navigates to the Orders module.
     */
    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(isElementVisible(orderIdField), "Navigation to orders module failed.");
    }

    /**
     * Selects an order by its ID.
     * @param orderId The ID of the order to select.
     */
    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderIdField, 3);
        enterText(orderIdField, orderId);
        clickElement(btnSearchOrder);
        Assert.assertTrue(isElementVisible(shipmentStatusDropdown), "Order selection failed.");
    }

    /**
     * Updates the shipment status of an order.
     * @param status The new shipment status to set.
     */
    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, status);
        clickElement(btnUpdateStatus);
        Assert.assertTrue(isElementVisible(alertSystem), "Shipment status update failed.");
    }

    /**
     * Checks the alert system for any notifications.
     */
    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        Assert.assertTrue(isElementVisible(alertSystem), "Alert system check failed.");
    }

    /**
     * Verifies the customer alert message.
     * @param expectedAlert The expected alert message.
     */
    public void verifyCustomerAlert(String expectedAlert) {
        waitUntilElementVisible(customerAlert, 3);
        String actualAlert = getTextFromElement(customerAlert);
        Assert.assertEquals(actualAlert, expectedAlert, "Customer alert does not match.");
    }
}