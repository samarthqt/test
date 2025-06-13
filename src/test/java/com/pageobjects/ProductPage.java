package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProductPage extends WebReusableComponents {

    protected By productListingPage = By.id("productListingPage");
    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public By productLink(String productName) {
        return By.linkText(productName);
    }

    public void navigateToProductListingPage() {
        waitUntilElementVisible(productListingPage, 3);
        clickElement(productListingPage);
    }

    public void selectProduct(String productName) {
        By product = productLink(productName);
        waitUntilElementVisible(product, 3);
        clickElement(product);
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
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(expectedProductName));
        Assert.assertTrue(productFound, "Product is not in the cart.");
    }

    public void verifyOnProductPage(String productName) {
        By product = productLink(productName);
        boolean isOnPage = elementVisible(product);
        Assert.assertTrue(isOnPage, "Not on the correct product page.");
    }

    public void navigateToProductPage(String productName) {
        By product = productLink(productName);
        waitUntilElementVisible(product, 3);
        clickElement(product);
    }
}