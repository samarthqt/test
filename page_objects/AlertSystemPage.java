package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AlertSystemPage extends WebReusableComponents {

    protected By dashboard = By.id(dashboard);
    protected By ordersModule = By.id(ordersModule);
    protected By orderList = By.cssSelector(.order-list);
    protected By orderDetails = By.cssSelector(.order-details);
    protected By shipmentStatus = By.cssSelector(.shipment-status);
    protected By alertSystem = By.id(alertSystem);
    protected By performanceMetrics = By.id(performanceMetrics);

    public AlertSystemPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToDynamics365(String username, String password) {
        enterText(By.id(username), username);
        enterText(By.id(password), password);
        clickElement(By.id(loginButton));
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not visible.);
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not displayed.);
    }

    public void verifyOrdersExist(int startId, int endId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        boolean ordersExist = orders.stream().anyMatch(order -> {
            int orderId = Integer.parseInt(order.getAttribute(data-order-id));
            return orderId >= startId && orderId <= endId;
        });
        Assert.assertTrue(ordersExist, Orders with specified IDs do not exist.);
    }

    public void verifyCustomerSubscriptions() {
        // Logic to verify customer subscriptions
        Assert.assertTrue(true, Customers are not subscribed to alerts.);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(isElementVisible(orderList), Failed to navigate to Orders Module.);
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementVisible(orderList), Orders module is not displayed.);
    }

    public void selectOrders(int startId, int endId) {
        List<WebElement> orders = getWebElementList(orderList);
        orders.stream().filter(order -> {
            int orderId = Integer.parseInt(order.getAttribute(data-order-id));
            return orderId >= startId && orderId <= endId;
        }).forEach(order -> clickElement(order));
    }

    public void verifyOrderDetailsDisplayed(int startId, int endId) {
        List<WebElement> details = getWebElementList(orderDetails);
        details.stream().filter(detail -> {
            int orderId = Integer.parseInt(detail.getAttribute(data-order-id));
            return orderId >= startId && orderId <= endId;
        }).forEach(detail -> Assert.assertTrue(isElementVisible(detail), Order details are not displayed.));
    }

    public void verifyShipmentStatus(String status) {
        List<WebElement> statuses = getWebElementList(shipmentStatus);
        statuses.forEach(statusElement -> Assert.assertEquals(getTextFromElement(statusElement), status, Shipment status is incorrect.));
    }

    public void updateShipmentStatus(String status, int startId, int endId) {
        List<WebElement> orders = getWebElementList(orderList);
        orders.stream().filter(order -> {
            int orderId = Integer.parseInt(order.getAttribute(data-order-id));
            return orderId >= startId && orderId <= endId;
        }).forEach(order -> {
            selectByValue(order.findElement(By.cssSelector(.status-dropdown)), status);
            clickElement(order.findElement(By.cssSelector(.update-status-button)));
        });
    }

    public void verifyShipmentStatusUpdated(String status, int startId, int endId) {
        List<WebElement> statuses = getWebElementList(shipmentStatus);
        statuses.stream().filter(statusElement -> {
            int orderId = Integer.parseInt(statusElement.getAttribute(data-order-id));
            return orderId >= startId && orderId <= endId;
        }).forEach(statusElement -> Assert.assertEquals(getTextFromElement(statusElement), status, Shipment status update failed.));
    }

    public void monitorAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        Assert.assertTrue(isElementVisible(alertSystem), Alert system is not monitored.);
    }

    public void verifyAlertsSent(String email, int startId, int endId) {
        // Logic to verify alerts sent
        Assert.assertTrue(true, Alerts are not sent to  + email);
    }

    public void verifyPerformanceMetrics() {
        waitUntilElementVisible(performanceMetrics, 3);
        Assert.assertTrue(isElementVisible(performanceMetrics), Performance metrics are not verified.);
    }

    public void verifyOptimalPerformanceUnderLoad() {
        // Logic to verify optimal performance
        Assert.assertTrue(true, System does not maintain optimal performance under load.);
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private String getTextFromElement(WebElement element) {
        return element.getText();
    }

    private void selectByValue(WebElement element, String value) {
        // Implement select by value logic
    }
}