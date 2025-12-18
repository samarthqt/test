package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CartStatePersistenceAcrossSessionsPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.id("cartItems");
    protected By btnLogout = By.id("logoutButton");
    protected By cartDetails = By.id("cartDetails");
    protected By orderConfirmation = By.id("orderConfirmation");

    public void navigateToApplication() {
        launchUrl(getAppUrl());
    }

    public void loginUser() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void addItemToCart(String item) {
        waitUntilElementVisible(btnAddToCart, 3);
        enterText(By.id("item"), item);
        clickElement(btnAddToCart);
    }

    public void verifyItemInCart(String item) {
        Assert.assertTrue(getTextFromElement(cartDetails).contains(item), "Item not found in cart.");
    }

    public void logoutUser() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(getTextFromElement(By.id("logoutMessage")).contains("logged out"), "Logout unsuccessful.");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(getTextFromElement(By.id("loginMessage")).contains("logged in"), "Login unsuccessful.");
    }

    public void navigateToCartPage() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyCartPageDisplay() {
        Assert.assertTrue(getTextFromElement(cartDetails).contains("cart"), "Cart page not displayed.");
    }

    public void verifyItemsInCart(String existingItem1, String existingItem2) {
        Assert.assertTrue(getTextFromElement(cartItems).contains(existingItem1) && getTextFromElement(cartItems).contains(existingItem2), "Items not found in cart.");
    }

    public void modifyItemQuantity(String existingItem1) {
        enterText(By.id("itemQuantity"), "Modified quantity");
    }

    public void verifyItemQuantity(String existingItem1) {
        Assert.assertTrue(getTextFromElement(cartItems).contains("Modified quantity"), "Item quantity incorrect.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(By.id("checkoutButton"), 3);
        clickElement(By.id("checkoutButton"));
    }

    public void verifyCheckoutDetails() {
        Assert.assertTrue(getTextFromElement(cartDetails).contains("checkout"), "Checkout details incorrect.");
    }

    public void confirmOrder() {
        waitUntilElementVisible(By.id("confirmOrderButton"), 3);
        clickElement(By.id("confirmOrderButton"));
    }

    public void verifyOrderConfirmation() {
        Assert.assertTrue(getTextFromElement(orderConfirmation).contains("confirmation"), "Order confirmation not displayed.");
    }
}
