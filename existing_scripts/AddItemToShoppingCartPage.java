package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AddItemToShoppingCartPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartDetails = By.id("cartDetails");

    public void loginUser() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToProductPage(String productID) {
        launchUrl(getAppUrl() + "/product/" + productID);
    }

    public void selectAddToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void verifyItemAddedToCart() {
        Assert.assertTrue(getTextFromElement(cartDetails).contains("added"), "Item not added to cart.");
    }

    public void verifyItemDetailsInCart(String productID) {
        Assert.assertTrue(getTextFromElement(cartDetails).contains(productID), "Item details incorrect in cart.");
    }
}
