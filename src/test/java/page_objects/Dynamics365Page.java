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

    public void login(final String username, final String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
    }

    public void selectOrderById(final String orderId) {
        waitUntilElementVisible(orderIdField, 3);
        enterText(orderIdField, orderId);
        clickElement(btnSearchOrder);
    }

    public void updateShipmentStatus(final String status) {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, status);
        clickElement(btnUpdateStatus);
    }

    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        WebElement alertElement = driver.findElement(alertSystem);
        Assert.assertTrue(alertElement.isDisplayed(), "Alert system is not visible.");
    }

    public void verifyCustomerAlert(final String expectedAlert) {
        waitUntilElementVisible(customerAlert, 3);
        String actualAlert = getTextFromElement(customerAlert);
        Assert.assertEquals(actualAlert, expectedAlert, "Customer alert does not match.");
    }
}