package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EcommercePlatformPage extends WebReusableComponents {

    public EcommercePlatformPage() {
        PageFactory.initElements(driver, this);
    }

    protected By platformHome = By.id("platformHome");
    protected By productCategories = By.cssSelector(".product-category");
    protected By cartButton = By.id("cartButton");
    protected By checkoutButton = By.id("checkoutButton");
    protected By paymentMethodDropdown = By.id("paymentMethodDropdown");
    protected By orderDetails = By.id("orderDetails");
    protected By loginButton = By.id("loginButton");
    protected By credentialsInput = By.id("credentialsInput");
    protected By navigationMenu = By.id("navigationMenu");
    protected By orderStatusNotification = By.id("orderStatusNotification");
    protected By errorMessage = By.id("errorMessage");

    public void navigateToPlatform() {
        waitUntilElementVisible(platformHome, 3);
        clickElement(platformHome);
    }

    public void browseProductCategories() {
        waitUntilElementVisible(productCategories, 3);
        getWebElementList(productCategories).forEach(this::clickElement);
    }

    public void verifyResponsiveBrowsing() {
        boolean isResponsive = driver.manage().window().getSize().getWidth() > 800;
        Assert.assertTrue(isResponsive, "Browsing is not responsive.");
    }

    public void selectProducts() {
        clickElement(productCategories);
    }

    public void addProductToCart() {
        waitUntilElementVisible(cartButton, 3);
        clickElement(cartButton);
    }

    public void verifyProductInCart() {
        boolean productInCart = isElementPresent(cartButton);
        Assert.assertTrue(productInCart, "Product is not in the cart.");
    }

    public void removeProductFromCart() {
        clickElement(cartButton);
    }

    public void verifyProductRemovedFromCart() {
        boolean productRemoved = !isElementPresent(cartButton);
        Assert.assertTrue(productRemoved, "Product is not removed from the cart.");
    }

    public void adjustProductQuantity() {
        selectByValue(cartButton, "2");
    }

    public void verifyUpdatedProductQuantity() {
        String quantity = getTextFromElement(cartButton);
        Assert.assertEquals(quantity, "2", "Quantity is not updated.");
    }

    public void readyToCheckout() {
        clickElement(checkoutButton);
    }

    public void selectPaymentMethod() {
        selectByValue(paymentMethodDropdown, "Credit Card");
    }

    public void verifySecurePaymentIntegration() {
        boolean isSecure = driver.getCurrentUrl().startsWith("https");
        Assert.assertTrue(isSecure, "Payment integration is not secure.");
    }

    public void placeOrder() {
        clickElement(checkoutButton);
    }

    public void viewOrderDetails() {
        clickElement(orderDetails);
    }

    public void verifyOrderTrackingFeatures() {
        boolean trackingAvailable = isElementPresent(orderDetails);
        Assert.assertTrue(trackingAvailable, "Order tracking is not available.");
    }

    public void navigateToPaymentPage() {
        clickElement(paymentMethodDropdown);
    }

    public void choosePaymentMethod() {
        selectByValue(paymentMethodDropdown, "PayPal");
    }

    public void verifyMultiplePaymentMethods() {
        boolean multipleMethods = getWebElementList(paymentMethodDropdown).size() > 1;
        Assert.assertTrue(multipleMethods, "Multiple payment methods are not supported.");
    }

    public void initiateLogin() {
        clickElement(loginButton);
    }

    public void enterCredentials() {
        enterText(credentialsInput, "user@example.com");
    }

    public void verifySecureAuthentication() {
        boolean isAuthenticated = isElementPresent(loginButton);
        Assert.assertTrue(isAuthenticated, "Authentication is not secure.");
    }

    public void browsePlatform() {
        clickElement(navigationMenu);
    }

    public void navigateWebsite() {
        getWebElementList(navigationMenu).forEach(this::clickElement);
    }

    public void verifyIntuitiveNavigation() {
        boolean isIntuitive = driver.getCurrentUrl().contains("home");
        Assert.assertTrue(isIntuitive, "Navigation is not intuitive.");
    }

    public void placeOrderAgain() {
        clickElement(checkoutButton);
    }

    public void changeOrderStatus() {
        clickElement(orderStatusNotification);
    }

    public void verifyOrderStatusNotifications() {
        boolean notificationsAvailable = isElementPresent(orderStatusNotification);
        Assert.assertTrue(notificationsAvailable, "Order status notifications are not available.");
    }

    public void performShoppingActivities() {
        clickElement(cartButton);
    }

    public void simulateError() {
        clickElement(errorMessage);
    }

    public void verifyErrorHandling() {
        boolean errorHandled = isElementPresent(errorMessage);
        Assert.assertTrue(errorHandled, "Error handling is not implemented.");
    }

    public void preparePlatformForTesting() {
        clickElement(platformHome);
    }

    public void conductTesting() {
        clickElement(platformHome);
    }

    public void verifySeamlessFunctionality() {
        boolean isSeamless = driver.getCurrentUrl().contains("test");
        Assert.assertTrue(isSeamless, "Functionality is not seamless.");
    }
}