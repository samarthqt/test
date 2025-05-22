package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AlertPage extends WebReusableComponents {

    protected By orderList = By.id(orderList);
    protected By orderDetails = By.id(orderDetails);
    protected By shipmentStatus = By.id(shipmentStatus);
    protected By alertSystem = By.id(alertSystem);
    protected By errorLog = By.id(errorLog);
    protected By loginButton = By.id(loginButton);
    protected By dashboard = By.id(dashboard);
    protected By ordersModule = By.id(ordersModule);
    protected By customerEmail = By.id(customerEmail);
    protected By subscriptionStatus = By.id(subscriptionStatus);

    public AlertPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem() {
        waitUntilElementVisible(loginButton, 5);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not displayed.);
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 5);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not displayed.);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 5);
        clickElement(ordersModule);
        Assert.assertTrue(isElementVisible(orderList), Failed to navigate to Orders module.);
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 5);
        Assert.assertTrue(isElementVisible(orderList), Orders module is not displayed.);
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderList, 5);
        WebElement order = getWebElementList(orderList)
            .stream()
            .filter(o -> o.getText().contains(orderId))
            .findFirst()
            .orElseThrow(() -> new AssertionError(Order ID not found.));
        order.click();
        Assert.assertTrue(isElementVisible(orderDetails), Order details not displayed.);
    }

    public void verifyOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetails, 5);
        Assert.assertTrue(getTextFromElement(orderDetails).contains(orderId), Order details are incorrect.);
    }

    public void verifyOrderExists(String orderId) {
        waitUntilElementVisible(orderList, 5);
        boolean orderExists = getWebElementList(orderList)
            .stream()
            .anyMatch(order -> order.getText().contains(orderId));
        Assert.assertTrue(orderExists, Order does not exist.);
    }

    public void verifyShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 5);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, Shipment status is incorrect.);
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 5);
        enterText(shipmentStatus, status);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, Failed to update shipment status.);
    }

    public void verifyShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatus, 5);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, Shipment status update failed.);
    }

    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystem, 5);
        Assert.assertTrue(isElementVisible(alertSystem), Alert system is not functioning.);
    }

    public void verifyNoAlertSent() {
        waitUntilElementVisible(alertSystem, 5);
        Assert.assertFalse(isElementVisible(alertSystem), Alert was sent unexpectedly.);
    }

    public void verifyErrorLogged(String email) {
        waitUntilElementVisible(errorLog, 5);
        Assert.assertTrue(getTextFromElement(errorLog).contains(email), Error log does not contain the expected email.);
    }

    public void verifyCustomerEmail(String email) {
        waitUntilElementVisible(customerEmail, 5);
        Assert.assertEquals(getTextFromElement(customerEmail), email, Customer email is incorrect.);
    }

    public void verifyCustomerSubscription() {
        waitUntilElementVisible(subscriptionStatus, 5);
        Assert.assertTrue(isElementVisible(subscriptionStatus), Customer subscription is not active.);
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private .util.List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }
}