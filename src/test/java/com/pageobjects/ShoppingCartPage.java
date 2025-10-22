package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShoppingCartPage extends WebReusableComponents {

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    protected By productDetailPage = By.id("productDetailPage");
    protected By quantityDropdown = By.id("quantityDropdown");
    protected By btnAddToCart = By.id("addToCart");
    protected By cartPage = By.id("cartPage");
    protected By cartProduct = By.cssSelector(".cart-product");
    protected By cartQuantity = By.cssSelector(".cart-quantity");
    protected By cartPrice = By.cssSelector(".cart-price");
    protected By cartPageHeader = By.id("cartPageHeader");
    protected By productQuantityField = By.cssSelector(".product-quantity");
    protected By updateCartButton = By.id("updateCartButton");
    protected By totalPrice = By.id("totalPrice");
    protected By cartItems = By.cssSelector(".cart-item");
    protected By priceTotal = By.id("priceTotal");

    public void loginToApplication() {
        // Implement login logic here
    }

    public void navigateToProductDetailPage(String productID) {
        waitUntilElementVisible(productDetailPage, 3);
        // Logic to navigate to product detail page using productID
    }

    public void selectProductQuantity(String quantity) {
        waitUntilElementVisible(quantityDropdown, 3);
        selectByValue(quantityDropdown, quantity);
    }

    public void addProductToShoppingCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void verifyProductInShoppingCart() {
        waitUntilElementVisible(cartPage, 3);
        boolean productFound = getWebElementList(cartProduct)
            .stream()
            .anyMatch(item -> item.isDisplayed());
        Assert.assertTrue(productFound, "Product is not in the shopping cart.");
        // Additional logic to verify quantity and price
    }

    public void verifyItemsInCart() {
        // Logic to verify items are present in the cart
    }

    public void navigateToShoppingCartPage() {
        // Logic to navigate to the shopping cart page
    }

    public void verifyShoppingCartPageDisplayed() {
        waitUntilElementVisible(cartPageHeader, 3);
        Assert.assertTrue(isElementDisplayed(cartPageHeader), "Shopping cart page is not displayed.");
    }

    public void updateProductQuantity(String productID, String newQuantity) {
        By productQuantityInput = By.cssSelector("#product-" + productID + " .quantity-input");
        waitUntilElementVisible(productQuantityInput, 3);
        enterText(productQuantityInput, newQuantity);
    }

    public void verifyQuantityUpdated(String newQuantity) {
        String actualQuantity = getTextFromElement(productQuantityField);
        Assert.assertEquals(actualQuantity, newQuantity, "Quantity update failed.");
    }

    public void selectUpdateCartOption() {
        waitUntilElementVisible(updateCartButton, 3);
        clickElement(updateCartButton);
    }

    public void verifyCartUpdatedAndPriceRecalculated() {
        // Logic to verify cart is updated and price is recalculated
    }

    public void addItemsToCart() {
        // Logic to add items to the cart
    }

    public void openShoppingCartPage() {
        waitUntilElementVisible(cartPage, 3);
        clickElement(cartPage);
    }

    public void verifyItemsListedInCart() {
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(getWebElementList(cartItems).size() > 0, "No items listed in the cart.");
    }

    public void verifyDiscountsAndTaxesDefined() {
        // Logic to verify discounts and taxes are defined
    }

    public void verifyDisplayedPriceTotal() {
        waitUntilElementVisible(priceTotal, 3);
        // Logic to verify displayed price total
    }

    public void verifyPriceTotalCalculation() {
        // Logic to verify price total calculation including discounts and taxes
    }
}
