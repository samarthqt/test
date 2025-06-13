package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class CartPage extends WebReusableComponents {

    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By btnRemoveItem = By.cssSelector(".remove-item");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");
    protected By productPrice = By.cssSelector(".cart-item-price");
    protected By loginPrompt = By.id("loginPrompt");
    protected By noProductInCartMessage = By.id("noProductInCartMessage");

    public CartPage() {
        PageFactory.initElements(driver, this);
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

    public void verifyProductPrice() {
        waitUntilElementVisible(productPrice, 3);
        String actualPrice = getTextFromElement(productPrice);
        Assert.assertNotNull(actualPrice, "Product price is not displayed.");
    }

    public void verifyProductQuantity(String expectedQuantity) {
        waitUntilElementVisible(productQuantity, 3);
        String actualQuantity = getTextFromElement(productQuantity);
        Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity update failed.");
    }

    public void removeProductFromCart(String productName) {
        By removeButton = By.xpath("//div[@class='cart-item' and contains(text(), '" + productName + "')]/following-sibling::button[@class='remove-item']");
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyProductRemoved(String productName) {
        By productLocator = By.xpath("//div[@class='cart-item' and contains(text(), '" + productName + "')]");
        boolean isProductPresent = elementVisible(productLocator);
        Assert.assertFalse(isProductPresent, "Product was not removed from the cart.");
    }

    public void verifyCartIsEmpty() {
        waitUntilElementVisible(cartEmptyMessage, 3);
        String actualMessage = getTextFromElement(cartEmptyMessage);
        Assert.assertEquals(actualMessage, "Your cart is empty.", "Cart is not empty.");
    }

    public void verifyCartIsNotEmpty() {
        waitUntilElementVisible(cartItems, 3);
        List<WebElement> items = getWebElementList(cartItems);
        Assert.assertFalse(items.isEmpty(), "Cart is empty.");
    }

    public void attemptToRemoveNonExistentProduct() {
        // Simulate the action of attempting to remove a non-existent product
        // This could be a click on a remove button that doesn't exist
        By nonExistentRemoveButton = By.xpath("//button[@class='remove-item' and not(ancestor::div[@class='cart-item'])]");
        boolean isButtonVisible = elementVisible(nonExistentRemoveButton);
        Assert.assertFalse(isButtonVisible, "Non-existent product remove button is visible.");
    }

    public void verifyNoProductInCartMessage() {
        waitUntilElementVisible(noProductInCartMessage, 3);
        String actualMessage = getTextFromElement(noProductInCartMessage);
        Assert.assertEquals(actualMessage, "NoProduct in Cart", "NoProduct in Cart message not shown.");
    }

    public void verifyProductNotInCart(String productName) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(productName));
        Assert.assertFalse(productFound, "Product is in the cart.");
    }

    public void verifyLoginPrompt() {
        waitUntilElementVisible(loginPrompt, 3);
        String actualMessage = getTextFromElement(loginPrompt);
        Assert.assertEquals(actualMessage, "Please log in to add products to your cart.", "Login prompt is not displayed.");
    }

    public void loginUser() {
        // Implement login functionality
        // Example: enter credentials and submit login form
        // Assert login success
    }

    public void logoutUser() {
        // Implement logout functionality
        // Example: click logout button and verify logout success
    }

    public void navigateToProductPage(String productName) {
        // Implement navigation to product page
        // Example: search for product and click on product link
    }
}