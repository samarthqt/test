package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CartPage extends WebReusableComponents {

    protected By cartPageLink = By.id("cartPageLink");
    protected By productList = By.cssSelector(".product-list");
    protected By totalPrice = By.id("totalPrice");
    protected By proceedToCheckoutButton = By.id("proceedToCheckoutButton");
    protected By emptyCartMessage = By.id("emptyCartMessage");
    protected By continueShoppingButton = By.id("continueShoppingButton");
    protected By productQuantityInput = By.cssSelector(".product-quantity-input");
    protected By removeProductButton = By.cssSelector(".remove-product-button");

    public void navigateToCartPage() {
        waitUntilElementVisible(cartPageLink, 3);
        clickElement(cartPageLink);
    }

    public void verifyProductsInCart() {
        waitUntilElementVisible(productList, 3);
        Assert.assertTrue(isElementVisible(productList), "Product list is not visible.");
    }

    public void verifyTotalPriceInCart() {
        waitUntilElementVisible(totalPrice, 3);
        String price = getTextFromElement(totalPrice);
        Assert.assertNotNull(price, "Total price is not displayed.");
    }

    public void verifyProceedToCheckoutOption() {
        waitUntilElementVisible(proceedToCheckoutButton, 3);
        Assert.assertTrue(isElementVisible(proceedToCheckoutButton), "Proceed to checkout option is not visible.");
    }

    public void verifyCartIsEmptyMessage() {
        waitUntilElementVisible(emptyCartMessage, 3);
        String message = getTextFromElement(emptyCartMessage);
        Assert.assertEquals(message, "Your cart is empty.", "Empty cart message is incorrect.");
    }

    public void verifyContinueShoppingOption() {
        waitUntilElementVisible(continueShoppingButton, 3);
        Assert.assertTrue(isElementVisible(continueShoppingButton), "Continue shopping option is not visible.");
    }

    public void changeProductQuantityInCart() {
        waitUntilElementVisible(productQuantityInput, 3);
        enterText(productQuantityInput, "2");
    }

    public void verifyUpdatedQuantityInCart() {
        waitUntilElementVisible(productQuantityInput, 3);
        String quantity = getTextFromElement(productQuantityInput);
        Assert.assertEquals(quantity, "2", "Product quantity did not update.");
    }

    public void verifyAdjustedTotalPrice() {
        waitUntilElementVisible(totalPrice, 3);
        String price = getTextFromElement(totalPrice);
        Assert.assertNotNull(price, "Total price did not adjust.");
    }

    public void removeProductFromCart() {
        waitUntilElementVisible(removeProductButton, 3);
        clickElement(removeProductButton);
    }

    public void verifyProductRemovedFromCart() {
        waitUntilElementVisible(productList, 3);
        Assert.assertFalse(isElementVisible(productList), "Product was not removed from cart.");
    }

    public void clickProceedToCheckout() {
        waitUntilElementVisible(proceedToCheckoutButton, 3);
        clickElement(proceedToCheckoutButton);
    }

    public void verifyRedirectionToCheckoutPage() {
        // Implement verification for redirection
    }

    public void verifyCartDetailsOnCheckoutPage() {
        // Implement verification for cart details on checkout page
    }
}