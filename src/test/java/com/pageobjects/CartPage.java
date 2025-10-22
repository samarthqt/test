package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CartPage extends WebReusableComponents {

    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By productQuantity = By.cssSelector(".cart-item-quantity");
    protected By btnRemoveItem = By.cssSelector(".remove-item");
    protected By cartEmptyMessage = By.id("cartEmptyMessage");

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

    public void verifyPriceTotalCalculation() {
        // Implementation to verify price total calculation
    }

    public void enterPromoCode(String promoCode) {
        // Implementation to enter promo code
    }

    public void verifyPromoCodeApplied() {
        // Implementation to verify promo code application
    }
}