package com.qt.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class OrdersPage extends WebReusableComponents {

    private final By ordersModule = By.id("ordersModule");
    private final By orderDetails = By.id("orderDetails");
    private final By shipmentStatus = By.id("shipmentStatus");
    private final By btnProceedToCheckout = By.id("proceedToCheckout");
    private final By txtFullName = By.id("fullName");
    private final By txtAddress = By.id("address");
    private final By txtCity = By.id("city");
    private final By txtPostalCode = By.id("postalCode");
    private final By txtPhone = By.id("phone");
    private final By paymentMethodDropdown = By.id("paymentMethod");
    private final By txtCardNumber = By.id("cardNumber");
    private final By txtExpiryDate = By.id("expiryDate");
    private final By txtCVV = By.id("cvv");
    private final By btnPlaceOrder = By.id("placeOrder");
    private final By orderConfirmationMessage = By.id("orderConfirmationMessage");
    private final By btnAddToCart = By.id("addToCart");
    private final By cartIcon = By.id("cartIcon");
    private final By cartItems = By.cssSelector(".cart-item");
    private final By productQuantity = By.cssSelector(".cart-item-quantity");
    private final By btnRemoveItem = By.cssSelector(".remove-item");
    private final By cartEmptyMessage = By.id("cartEmptyMessage");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
    }

    public boolean isOrdersModuleDisplayed() {
        waitUntilElementVisible(ordersModule, 3);
        return isElementVisible(ordersModule);
    }

    public void selectOrderById(String orderId) {
        By orderLocator = By.id(orderId);
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        By orderLocator = By.id(orderId);
        waitUntilElementVisible(orderLocator, 3);
        return isElementVisible(orderLocator);
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        selectByValue(shipmentStatus, status);
    }

    public String getShipmentStatus() {
        waitUntilElementVisible(shipmentStatus, 3);
        return getTextFromElement(shipmentStatus);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void addProductToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyProductInCart(String expectedProductName) {
        waitUntilElementVisible(cartItems, 3);
        List<WebElement> items = getWebElementList(cartItems);
        boolean productFound = items.stream().anyMatch(item -> item.getText().contains(expectedProductName));
        Assert.assertTrue(productFound, "Product is not in the cart.");
    }

    public void updateProductQuantity(String quantity) {
        waitUntilElementVisible(productQuantity, 3);
        selectByValue(productQuantity, quantity);
    }

    public void verifyProductQuantity(String expectedQuantity) {
        waitUntilElementVisible(productQuantity, 3);
        String actualQuantity = getTextFromElement(productQuantity);
        Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity update failed.");
    }

    public void removeProductFromCart() {
        waitUntilElementVisible(btnRemoveItem, 3);
        clickElement(btnRemoveItem);
    }

    public void verifyCartIsEmpty() {
        waitUntilElementVisible(cartEmptyMessage, 3);
        String actualMessage = getTextFromElement(cartEmptyMessage);
        Assert.assertEquals(actualMessage, "Your cart is empty.", "Cart is not empty.");
    }
}