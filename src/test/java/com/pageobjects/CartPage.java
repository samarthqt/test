package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CartPage extends WebReusableComponents {

    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By btnRemoveItem = By.cssSelector(".remove-item");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By totalPrice = By.id("totalPrice");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By btnAddToCart = By.id("addToCart");
    protected By errorMessage = By.id("errorMessage");
    protected By checkoutPreventionMessage = By.id("checkoutPreventionMessage");
    protected By productDetailPage = By.id("productDetailPage");
    protected By cartConfirmationMessage = By.id("cartConfirmationMessage");

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void verifyCartIsNotEmpty() {
        waitUntilElementVisible(cartItems, 3);
        boolean itemsPresent = !getWebElementList(cartItems).isEmpty();
        Assert.assertTrue(itemsPresent, "Cart is empty.");
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

    public void verifyProductInCartByID(String productID) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getAttribute("data-product-id").equals(productID));
        Assert.assertTrue(productFound, "Product with ID " + productID + " is not in the cart.");
    }

    public void updateProductQuantity(String quantity) {
        waitUntilElementVisible(productQuantity, 3);
        selectByValue(productQuantity, quantity);
    }

    public void verifyUpdatedQuantityAndTotalPrice() {
        waitUntilElementVisible(productQuantity, 3);
        String actualQuantity = getTextFromElement(productQuantity);
        Assert.assertNotNull(actualQuantity, "Quantity update failed.");
        waitUntilElementVisible(totalPrice, 3);
        String actualTotalPrice = getTextFromElement(totalPrice);
        Assert.assertNotNull(actualTotalPrice, "Total price update failed.");
    }

    public void verifyProductInCart(String expectedProductName) {
        waitUntilElementVisible(cartItems, 3);
        boolean productFound = getWebElementList(cartItems)
            .stream()
            .anyMatch(item -> item.getText().contains(expectedProductName));
        Assert.assertTrue(productFound, "Product is not in the cart.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void addProductToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void verifyErrorMessage(String expectedErrorMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedErrorMessage, "Error message does not match.");
    }

    public void attemptToRemoveItemFromEmptyCart() {
        waitUntilElementVisible(btnRemoveItem, 3);
        clickElement(btnRemoveItem);
        verifyCartIsEmpty();
    }

    public void attemptProceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void verifyCheckoutPreventionMessage() {
        waitUntilElementVisible(checkoutPreventionMessage, 3);
        String actualMessage = getTextFromElement(checkoutPreventionMessage);
        Assert.assertEquals(actualMessage, "Cannot proceed to checkout. Your cart is empty.", "Checkout prevention message is incorrect.");
    }

    public void navigateToProductDetailPage(String productName) {
        driver.get("http://example.com/products/" + productName);
    }

    public void verifyProductDetailPage() {
        waitUntilElementVisible(productDetailPage, 3);
        Assert.assertTrue(isElementDisplayed(productDetailPage), "Product detail page is not displayed.");
    }

    public void verifyProductAddedToCart() {
        waitUntilElementVisible(cartConfirmationMessage, 3);
        String confirmationText = getTextFromElement(cartConfirmationMessage);
        Assert.assertEquals(confirmationText, "Product successfully added to cart.", "Product was not added to the cart.");
    }
}
