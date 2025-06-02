package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AlertSystemPage extends WebReusableComponents {

    protected By dashboard = By.id("dashboard");
    protected By ordersModule = By.id("ordersModule");
    protected By orderList = By.cssSelector(".order-list");
    protected By orderDetails = By.cssSelector(".order-details");
    protected By shipmentStatus = By.cssSelector(".shipment-status");
    protected By alertSystem = By.id("alertSystem");
    protected By performanceMetrics = By.id("performanceMetrics");

    public AlertSystemPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToDynamics365(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(By.id("loginButton"));
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not displayed.");
    }

    public void verifyOrdersExist(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            Assert.assertTrue(isElementVisible(By.id("order" + i)), "Order ID " + i + " does not exist.");
        }
    }

    public void verifyCustomerSubscriptions() {
        Assert.assertTrue(isElementVisible(By.id("customerSubscriptions")), "Customers are not subscribed to alerts.");
    }

    public void navigateToOrdersModule() {
        clickElement(ordersModule);
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementVisible(orderList), "Orders module is not displayed.");
    }

    public void selectOrders(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            clickElement(By.id("order" + i));
        }
    }

    public void verifyOrderDetailsDisplayed(String status) {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(getTextFromElement(orderDetails).contains(status), "Order details do not show status as " + status);
    }

    public void updateShipmentStatus(String status) {
        for (WebElement order : getWebElementList(orderDetails)) {
            selectByValue(shipmentStatus, status);
        }
    }

    public void verifyShipmentStatusUpdated(String status) {
        for (WebElement order : getWebElementList(orderDetails)) {
            Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status not updated to " + status);
        }
    }

    public void monitorAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        Assert.assertTrue(isElementVisible(alertSystem), "Alert system is not visible.");
    }

    public void verifyAlertsSent(String email) {
        Assert.assertTrue(getTextFromElement(alertSystem).contains(email), "Alerts not sent to " + email);
    }

    public void verifyPerformanceMetrics() {
        waitUntilElementVisible(performanceMetrics, 3);
        Assert.assertTrue(isElementVisible(performanceMetrics), "Performance metrics are not visible.");
    }

    public void verifyOptimalPerformance() {
        Assert.assertTrue(getTextFromElement(performanceMetrics).contains("Optimal"), "System is not maintaining optimal performance.");
    }
}