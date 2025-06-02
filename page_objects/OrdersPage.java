package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrdersPage extends WebReusableComponents {

    protected By dashboard = By.id("dashboard");
    protected By ordersModule = By.id("ordersModule");
    protected By orderList = By.cssSelector(".order-list");
    protected By orderDetails = By.id("orderDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By alertSystem = By.id("alertSystem");
    protected By errorLogs = By.id("errorLogs");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        Assert.assertTrue(isElementDisplayed(dashboard), "Login failed, dashboard not displayed.");
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not displayed.");
    }

    public void verifyOrderExists(String orderId) {
        navigateToOrders();
        WebElement order = driver.findElement(By.xpath("//div[@data-order-id='" + orderId + "']"));
        Assert.assertTrue(order.isDisplayed(), "Order with ID " + orderId + " does not exist.");
    }

    public void verifyCustomerSubscription() {
        WebElement subscriptionStatus = driver.findElement(By.id("subscriptionStatus"));
        Assert.assertTrue(subscriptionStatus.isDisplayed(), "Customer subscription status is not displayed.");
    }

    public void navigateToOrders() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
        Assert.assertTrue(isElementDisplayed(orderList), "Failed to navigate to orders module.");
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementDisplayed(orderList), "Orders module is not displayed.");
    }

    public void verifyInvalidEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("emailError"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid email error message is not displayed.");
    }

    public void selectOrder(String orderId) {
        WebElement order = driver.findElement(By.xpath("//div[@data-order-id='" + orderId + "']"));
        order.click();
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed after selecting order.");
    }

    public void verifyOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetails, 3);
        WebElement orderDetail = driver.findElement(By.xpath("//div[@data-order-id='" + orderId + "']"));
        Assert.assertTrue(orderDetail.isDisplayed(), "Order details for ID " + orderId + " are not displayed.");
    }

    public void verifyShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status is incorrect.");
    }

    public void updateShipmentStatusToDelivered() {
        WebElement statusDropdown = driver.findElement(By.id("statusDropdown"));
        statusDropdown.click();
        WebElement deliveredOption = driver.findElement(By.xpath("//option[@value='Delivered']"));
        deliveredOption.click();
        WebElement updateButton = driver.findElement(By.id("updateStatus"));
        updateButton.click();
        Assert.assertEquals(getTextFromElement(shipmentStatus), "Delivered", "Failed to update shipment status to Delivered.");
    }

    public void verifyShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status update failed.");
    }

    public void checkAlertSystemForOutgoingAlerts() {
        WebElement alertTab = driver.findElement(By.id("alertTab"));
        alertTab.click();
        WebElement outgoingAlerts = driver.findElement(By.id("outgoingAlerts"));
        Assert.assertTrue(outgoingAlerts.isDisplayed(), "Outgoing alerts are not displayed.");
    }

    public void verifyNoAlertSent() {
        WebElement noAlertMessage = driver.findElement(By.id("noAlertMessage"));
        Assert.assertTrue(noAlertMessage.isDisplayed(), "No alert message is not displayed.");
    }

    public void verifyErrorLogsForFailures() {
        WebElement errorLogTab = driver.findElement(By.id("errorLogTab"));
        errorLogTab.click();
        WebElement errorLog = driver.findElement(By.id("errorLog"));
        Assert.assertTrue(errorLog.isDisplayed(), "Error logs are not displayed.");
    }

    public void verifyErrorLoggedForInvalidEmail(String email) {
        WebElement errorLogEntry = driver.findElement(By.xpath("//div[contains(text(), '" + email + "')]"));
        Assert.assertTrue(errorLogEntry.isDisplayed(), "Error log for invalid email " + email + " is not found.");
    }
}