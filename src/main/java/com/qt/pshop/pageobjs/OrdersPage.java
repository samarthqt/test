package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

public class OrdersPage {

    protected By ordersModule = By.id("ordersModule");
    protected By orderDetailsSection = By.id("orderDetails");
    protected By shipmentStatusDropdown = By.id("shipmentStatus");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By wishlistLink = By.id("wishlistLink");
    protected By wishlistItems = By.cssSelector(".wishlist-item");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule);
        driver.findElement(ordersModule).click();
    }

    public boolean isOrdersModuleDisplayed() {
        waitUntilElementVisible(ordersModule);
        boolean isDisplayed = driver.findElement(ordersModule).isDisplayed();
        Assert.assertTrue(isDisplayed, "Orders Module is not displayed.");
        return isDisplayed;
    }

    public void selectOrderById(String orderId) {
        By orderLocator = By.id(orderId);
        waitUntilElementVisible(orderLocator);
        driver.findElement(orderLocator).click();
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetailsSection);
        String detailsText = driver.findElement(orderDetailsSection).getText();
        boolean isDisplayed = detailsText.contains(orderId);
        Assert.assertTrue(isDisplayed, "Order details are not displayed for order ID: " + orderId);
        return isDisplayed;
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatusDropdown);
        WebElement dropdown = driver.findElement(shipmentStatusDropdown);
        dropdown.sendKeys(status);
        Assert.assertEquals(dropdown.getText(), status, "Shipment status was not updated to: " + status);
    }

    public boolean isShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatusDropdown);
        String currentStatus = driver.findElement(shipmentStatusDropdown).getText();
        boolean isUpdated = currentStatus.equals(status);
        Assert.assertTrue(isUpdated, "Shipment status is not updated to: " + status);
        return isUpdated;
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        driver.findElement(btnPlaceOrder).click();
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = driver.findElement(orderConfirmationMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void navigateToWishlist() {
        waitUntilElementVisible(wishlistLink);
        driver.findElement(wishlistLink).click();
    }

    public boolean isWishlistNotEmpty() {
        waitUntilElementVisible(wishlistItems);
        List<WebElement> items = driver.findElements(wishlistItems);
        boolean isNotEmpty = !items.isEmpty();
        Assert.assertTrue(isNotEmpty, "Wishlist is empty.");
        return isNotEmpty;
    }

    private void waitUntilElementVisible(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}