package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

public class OrdersPage {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By orderDetailsSection = By.id("orderDetailsSection");
    protected By wishlistLink = By.id("wishlistLink");
    protected By wishlistItems = By.cssSelector(".wishlist-item");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(wishlistLink);
        clickElement(wishlistLink);
    }

    public boolean isOrdersModuleDisplayed() {
        waitUntilElementVisible(wishlistLink);
        boolean isDisplayed = elementVisible(wishlistLink);
        Assert.assertTrue(isDisplayed, "Orders Module is not displayed.");
        return isDisplayed;
    }

    public void selectOrderById(String orderId) {
        By orderLocator = specificOrder(orderId);
        waitUntilElementVisible(orderLocator);
        clickElement(orderLocator);
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetailsSection);
        boolean isVisible = elementVisible(orderDetailsSection);
        Assert.assertTrue(isVisible, "Order details are not displayed for order ID: " + orderId);
        return isVisible;
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(paymentMethodDropdown);
        selectByValue(paymentMethodDropdown, status);
        Assert.assertEquals(getTextFromElement(paymentMethodDropdown), status, "Shipment status was not updated to: " + status);
    }

    public boolean isShipmentStatusUpdated(String status) {
        waitUntilElementVisible(paymentMethodDropdown);
        String currentStatus = getTextFromElement(paymentMethodDropdown);
        boolean isUpdated = currentStatus.equals(status);
        Assert.assertTrue(isUpdated, "Shipment status is not updated to: " + status);
        return isUpdated;
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(orderDetailsSection);
        boolean isVisible = elementVisible(orderDetailsSection);
        Assert.assertTrue(isVisible, "Order details are not displayed.");
    }

    public void addProductToWishlist() {
        waitUntilElementVisible(wishlistLink);
        clickElement(wishlistLink);
    }

    public boolean isWishlistNotEmpty() {
        waitUntilElementVisible(wishlistItems);
        List<WebElement> items = getWebElementList(wishlistItems);
        boolean isNotEmpty = !items.isEmpty();
        Assert.assertTrue(isNotEmpty, "Wishlist is empty.");
        return isNotEmpty;
    }

    public void verifyWishlistContainsItems() {
        Assert.assertTrue(isWishlistNotEmpty(), "Wishlist is empty.");
    }

    public void removeProductFromWishlist(String productName) {
        By removeButton = removeWishlistItem(productName);
        waitUntilElementVisible(removeButton);
        clickElement(removeButton);
    }

    public void verifyProductRemoved(String productName) {
        By productLocator = removeWishlistItem(productName);
        boolean isProductPresent = elementVisible(productLocator);
        Assert.assertFalse(isProductPresent, "Product was not removed from the wishlist.");
    }

    private void waitUntilElementVisible(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    private void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.sendKeys(value);
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private boolean elementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    private List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }

    private By specificOrder(String orderId) {
        return By.id(orderId);
    }

    private By removeWishlistItem(String productName) {
        return By.xpath("//div[@class='wishlist-item' and contains(text(), '" + productName + "')]/following-sibling::button[@class='remove']");
    }
}