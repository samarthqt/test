package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderPage extends WebReusableComponents {

    private final By ordersModuleLink = By.id("ordersModule");
    private final By orderIdField = By.id("orderId");
    private final By shipmentStatusDropdown = By.id("shipmentStatus");
    private final By errorLog = By.id("errorLog");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginButton");
    private final By selectOrderButton = By.id("selectOrderButton");
    private final By updateStatusButton = By.id("updateStatusButton");

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToDynamics365(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void verifyShipmentOrderExists() {
        waitUntilElementVisible(orderIdField, 3);
        Assert.assertTrue(isElementPresent(orderIdField), "Shipment order does not exist.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModuleLink, 3);
        clickElement(ordersModuleLink);
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderIdField, 3);
        enterText(orderIdField, orderId);
        clickElement(selectOrderButton);
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, status);
        clickElement(updateStatusButton);
    }

    public void verifyNoAlertSent(String email) {
        Assert.assertFalse(isAlertSent(email), "Alert was sent to invalid email.");
    }

    public void verifyErrorLogged(String email) {
        waitUntilElementVisible(errorLog, 3);
        String errorMessage = getTextFromElement(errorLog);
        Assert.assertTrue(errorMessage.contains(email), "Error not logged for invalid email.");
    }

    private boolean isAlertSent(String email) {
        // Logic to check if alert was sent
        return false;
    }
}