package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AlertSystemPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By ordersModule = By.id("ordersModule");
    protected By orderList = By.cssSelector(".order-list");
    protected By orderDetails = By.cssSelector(".order-details");
    protected By shipmentStatusDropdown = By.id("shipmentStatus");
    protected By alertSystemMonitor = By.id("alertSystemMonitor");
    protected By performanceMetrics = By.id("performanceMetrics");

    public AlertSystemPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyShipmentOrdersExist() {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        Assert.assertFalse(orders.isEmpty(), "No shipment orders exist.");
    }

    public void loginToDynamics365(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void verifyDashboardIsDisplayed() {
        waitUntilElementVisible(ordersModule, 3);
        Assert.assertTrue(isElementDisplayed(ordersModule), "Dashboard is not displayed.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
    }

    public void verifyOrdersModuleIsDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementDisplayed(orderList), "Orders module is not displayed.");
    }

    public void selectOrdersByIdRange(int startId, int endId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        for (WebElement order : orders) {
            int orderId = Integer.parseInt(order.getAttribute("data-order-id"));
            if (orderId >= startId && orderId <= endId) {
                order.click();
            }
        }
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed.");
    }

    public void updateShipmentStatusToDispatched() {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        selectByValue(shipmentStatusDropdown, "Dispatched");
    }

    public void verifyShipmentStatusUpdatedToDispatched() {
        waitUntilElementVisible(shipmentStatusDropdown, 3);
        String selectedValue = getSelectedValue(shipmentStatusDropdown);
        Assert.assertEquals(selectedValue, "Dispatched", "Shipment status is not updated to Dispatched.");
    }

    public void monitorOutgoingAlerts() {
        waitUntilElementVisible(alertSystemMonitor, 3);
        List<WebElement> alerts = getWebElementList(alertSystemMonitor);
        Assert.assertFalse(alerts.isEmpty(), "No outgoing alerts are being monitored.");
    }

    public void verifyAlertsSentWithoutDelay() {
        waitUntilElementVisible(alertSystemMonitor, 3);
        List<WebElement> alerts = getWebElementList(alertSystemMonitor);
        for (WebElement alert : alerts) {
            String status = alert.getAttribute("data-status");
            Assert.assertEquals(status, "Sent", "Alert was not sent without delay.");
        }
    }

    public void verifyPerformanceMetrics() {
        waitUntilElementVisible(performanceMetrics, 3);
        String metrics = getTextFromElement(performanceMetrics);
        Assert.assertNotNull(metrics, "Performance metrics are not available.");
    }

    public void verifyOptimalPerformanceUnderLoad() {
        waitUntilElementVisible(performanceMetrics, 3);
        String metrics = getTextFromElement(performanceMetrics);
        Assert.assertTrue(metrics.contains("Optimal"), "Performance is not optimal under load.");
    }
}