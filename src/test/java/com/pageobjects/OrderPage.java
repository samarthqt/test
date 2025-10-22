package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By productPageLink = By.id("productPageLink");
    protected By addToCartButton = By.id("addToCart");
    protected By proceedToCheckoutButton = By.id("proceedToCheckout");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By confirmOrderButton = By.id("confirmOrder");
    protected By errorMessage = By.id("errorMessage");

    public void loginUser() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void navigateToProductPage(String productID) {
        waitUntilElementVisible(productPageLink, 3);
        clickElement(productPageLink);
    }

    public void verifyProductDetailsPage() {
        // Logic to verify product details page
        Assert.assertTrue(isElementVisible(By.id("stockStatus")), "Product details page is not displayed correctly.");
    }

    public void addProductToCart(int quantity) {
        waitUntilElementVisible(addToCartButton, 3);
        clickElement(addToCartButton);
    }

    public void verifyCartUpdate() {
        // Logic to verify cart update
        Assert.assertTrue(isElementVisible(By.id("cartUpdate")), "Cart is not updated correctly.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(proceedToCheckoutButton, 3);
        clickElement(proceedToCheckoutButton);
    }

    public void verifyCheckoutPage() {
        // Logic to verify checkout page
        Assert.assertTrue(isElementVisible(By.id("orderDetails")), "Checkout page is not displayed correctly.");
    }

    public void selectInvalidPaymentMethod() {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, "Invalid Card");
    }

    public void verifyInvalidPaymentError() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid payment method.", "Error message does not match.");
    }

    public void attemptToConfirmOrder() {
        waitUntilElementVisible(confirmOrderButton, 3);
        clickElement(confirmOrderButton);
    }

    public void verifyOrderNotConfirmed() {
        // Logic to verify order not confirmed
        Assert.assertTrue(isElementVisible(By.id("orderNotConfirmed")), "Order was incorrectly confirmed.");
    }
}