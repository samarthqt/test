package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AccountDashboardPage extends WebReusableComponents {

    protected By accountDashboardLink = By.id("accountDashboard");
    protected By orderHistorySection = By.id("orderHistorySection");
    protected By orderDetailsSection = By.id("orderDetailsSection");
    protected By orderIDLocator = By.cssSelector(".order-id");
    protected By orderStatusLocator = By.cssSelector(".order-status");
    protected By notificationMessage = By.id("notificationMessage");
    protected By trackingLink = By.id("trackingLink");

    protected By specificOrderInHistory(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']");
    }

    protected By orderStatus(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']//span[@class='status']");
    }

    protected By specificOrder(String orderID) {
        return By.xpath("//div[@data-order-id='" + orderID + "']");
    }

    public void loginToAccount() {
        // Implement login logic here
    }

    public void navigateToAccountDashboard() {
        waitUntilElementVisible(accountDashboardLink, 3);
        clickElement(accountDashboardLink);
    }

    public void verifyAccountDashboardDisplayed() {
        waitUntilElementVisible(orderHistorySection, 3);
        Assert.assertTrue(elementVisible(orderHistorySection), "Account dashboard is not displayed.");
    }

    public void locateOrderInHistory(String orderID) {
        By orderLocator = specificOrderInHistory(orderID);
        waitUntilElementVisible(orderLocator, 3);
        Assert.assertTrue(elementVisible(orderLocator), "Order ID " + orderID + " is not found in the order history.");
    }

    public void verifyOrderStatus(String orderID, String expectedStatus) {
        By statusLocator = orderStatus(orderID);
        waitUntilElementVisible(statusLocator, 3);
        String actualStatus = getTextFromElement(statusLocator);
        Assert.assertEquals(actualStatus, expectedStatus, "Order status does not match.");
    }

    public void selectOrderToViewDetails(String orderID) {
        By orderLocator = specificOrderInHistory(orderID);
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection, 3);
        Assert.assertTrue(elementVisible(orderDetailsSection), "Order details are not displayed.");
    }

    public void verifyOrderHistoryDisplayed(String userID) {
        waitUntilElementVisible(orderHistorySection, 3);
        Assert.assertTrue(isElementPresent(orderHistorySection), "Order history is not displayed for User ID: " + userID);
    }

    public void locateOrderInHistory(int orderID) {
        By orderLocator = specificOrder(String.valueOf(orderID));
        waitUntilElementVisible(orderLocator, 3);
        WebElement orderElement = getWebElement(orderLocator);
        Assert.assertNotNull(orderElement, "Order ID " + orderID + " not found in order history.");
    }

    public void verifyOrderStatus(int orderID, String expectedStatus) {
        By statusLocator = orderStatus(String.valueOf(orderID));
        waitUntilElementVisible(statusLocator, 3);
        String actualStatus = getTextFromElement(statusLocator);
        Assert.assertEquals(actualStatus, expectedStatus, "Order status does not match.");
    }

    public void selectOrderToViewDetails(int orderID) {
        By orderLocator = specificOrder(String.valueOf(orderID));
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void simulateStatusChange() {
        // Dummy implementation for simulating status change
    }

    public void verifyRealTimeStatusUpdate() {
        // Dummy implementation for verifying real-time update
    }

    public void verifyNotificationReceived() {
        waitUntilElementVisible(notificationMessage, 3);
        Assert.assertTrue(isElementPresent(notificationMessage), "Notification about status change not received.");
    }

    public void selectTrackingLink() {
        waitUntilElementVisible(trackingLink, 3);
        clickElement(trackingLink);
    }

    public void verifyTrackingPageOpened() {
        // Dummy implementation for verifying tracking page
    }
}
