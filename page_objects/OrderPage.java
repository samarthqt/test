package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By ordersModule = By.id("ordersModule");
    protected By orderList = By.cssSelector(".order-list");
    protected By orderDetails = By.cssSelector(".order-details");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By alertSystem = By.id("alertSystem");
    protected By emailInbox = By.id("emailInbox");

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem(String username, String password) {
        WebElement loginBtn = waitUntilElementVisible(loginButton, 3);
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        loginBtn.click();
        Assert.assertTrue(isElementDisplayed(dashboard), "Login failed, dashboard not displayed.");
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not displayed.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(isElementDisplayed(orderList), "Failed to navigate to Orders module.");
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementDisplayed(orderList), "Orders module is not displayed.");
    }

    public void selectOrderById(String orderId) {
        WebElement order = findElement(By.xpath("//div[@data-order-id='" + orderId + "']"));
        order.click();
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed.");
    }

    public void verifyOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed for order ID: " + orderId);
    }

    public void verifyShipmentStatus(String orderId, String expectedStatus) {
        selectOrderById(orderId);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Shipment status does not match for order ID: " + orderId);
    }

    public void updateShipmentStatus(String orderId, String newStatus) {
        selectOrderById(orderId);
        enterText(shipmentStatus, newStatus);
        clickElement(By.id("updateStatusButton"));
        Assert.assertEquals(getTextFromElement(shipmentStatus), newStatus, "Shipment status update failed for order ID: " + orderId);
    }

    public void verifyShipmentStatusUpdated(String orderId, String expectedStatus) {
        verifyShipmentStatus(orderId, expectedStatus);
    }

    public void verifyCustomerSubscriptionStatus(String orderId, boolean isSubscribed) {
        selectOrderById(orderId);
        boolean actualStatus = Boolean.parseBoolean(getTextFromElement(By.id("subscriptionStatus")));
        Assert.assertEquals(actualStatus, isSubscribed, "Subscription status does not match for order ID: " + orderId);
    }

    public void verifyCustomerEmail(String orderId, String expectedEmail) {
        selectOrderById(orderId);
        String actualEmail = getTextFromElement(By.id("customerEmail"));
        Assert.assertEquals(actualEmail, expectedEmail, "Customer email does not match for order ID: " + orderId);
    }

    public void verifyCustomerEmailInbox(String email) {
        navigateToEmailInbox(email);
        Assert.assertTrue(isElementDisplayed(emailInbox), "Email inbox is not displayed for email: " + email);
    }

    public void verifyNoAlertSent(String email) {
        navigateToEmailInbox(email);
        Assert.assertFalse(isElementDisplayed(alertSystem), "Unexpected alert found in email inbox for email: " + email);
    }

    public void verifyNoAlertReceived(String email) {
        verifyNoAlertSent(email);
    }

    public void checkAlertSystemForOutgoingAlerts() {
        navigateToAlertSystem();
        Assert.assertFalse(isElementDisplayed(alertSystem), "Unexpected outgoing alerts found.");
    }

    public void verifyOrderExists() {
        Assert.assertTrue(isElementDisplayed(orderList), "No orders found.");
    }

    private void navigateToEmailInbox(String email) {
        // Logic to navigate to email inbox
    }

    private void navigateToAlertSystem() {
        // Logic to navigate to alert system
    }
}