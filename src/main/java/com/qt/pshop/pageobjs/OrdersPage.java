package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrdersPage {

    protected By ordersModule = By.id("ordersModule");
    protected By orderDetails = By.id("orderDetails");
    protected By shipmentStatusDropdown = By.id("shipmentStatus");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Orders Module.
     */
    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule);
        driver.findElement(ordersModule).click();
    }

    /**
     * Checks if the Orders Module is displayed.
     * @return true if displayed, false otherwise.
     */
    public boolean isOrdersModuleDisplayed() {
        waitUntilElementVisible(ordersModule);
        boolean isDisplayed = driver.findElement(ordersModule).isDisplayed();
        Assert.assertTrue(isDisplayed, "Orders Module is not displayed.");
        return isDisplayed;
    }

    /**
     * Selects an order by its ID.
     * @param orderId The ID of the order to select.
     */
    public void selectOrderById(String orderId) {
        By orderLocator = By.id(orderId);
        waitUntilElementVisible(orderLocator);
        driver.findElement(orderLocator).click();
    }

    /**
     * Checks if the order details are displayed for a given order ID.
     * @param orderId The ID of the order to check.
     * @return true if order details are displayed, false otherwise.
     */
    public boolean isOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetails);
        String detailsText = driver.findElement(orderDetails).getText();
        boolean isDisplayed = detailsText.contains(orderId);
        Assert.assertTrue(isDisplayed, "Order details are not displayed for order ID: " + orderId);
        return isDisplayed;
    }

    /**
     * Updates the shipment status.
     * @param status The new shipment status to set.
     */
    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatusDropdown);
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.sendKeys(status);
        Assert.assertEquals(dropdown.getText(), status, "Shipment status was not updated to: " + status);
    }

    /**
     * Checks if the shipment status is updated.
     * @param status The expected shipment status.
     * @return true if the shipment status is updated, false otherwise.
     */
    public boolean isShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatusDropdown);
        String currentStatus = driver.findElement(shipmentStatusDropdown).getText();
        boolean isUpdated = currentStatus.equals(status);
        Assert.assertTrue(isUpdated, "Shipment status is not updated to: " + status);
        return isUpdated;
    }

    /**
     * Waits until the specified element is visible.
     * @param locator The locator of the element to wait for.
     */
    public void waitUntilElementVisible(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}