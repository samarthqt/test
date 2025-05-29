package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By btnAddToCart = By.id(addToCart);
    private final By cartIcon = By.id(cartIcon);
    private final By cartItems = By.cssSelector(.cart-item);
    private final By productQuantity = By.cssSelector(.cart-item-quantity);
    private final By btnRemoveItem = By.cssSelector(.remove-item);
    private final By cartEmptyMessage = By.id(cartEmptyMessage);

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void navigateToProductDetailsPage() {
        driver.get(http://example.com/product-details);
    }

    public void addProductToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddToCart));
        addToCartButton.click();
    }

    public void openCart() {
        WebElement cartIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        cartIconElement.click();
    }

    public void verifyProductInCart(String expectedProductName) {
        boolean productFound = isProductInCart(expectedProductName);
        Assert.assertTrue(productFound, Product is not in the cart.);
    }

    public boolean isProductInCart(String productName) {
        for (WebElement item : driver.findElements(cartItems)) {
            if (item.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    public void updateProductQuantity(String quantity) {
        WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity));
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }

    public void verifyProductQuantity(String expectedQuantity) {
        boolean quantityUpdated = isProductQuantityUpdated(expectedQuantity);
        Assert.assertTrue(quantityUpdated, Quantity update failed.);
    }

    public boolean isProductQuantityUpdated(String expectedQuantity) {
        String actualQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantity)).getAttribute(value);
        return actualQuantity.equals(expectedQuantity);
    }

    public void removeProductFromCart() {
        WebElement removeItemButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnRemoveItem));
        removeItemButton.click();
    }

    public void verifyCartIsEmpty() {
        boolean cartEmpty = isCartEmpty();
        Assert.assertTrue(cartEmpty, Cart is not empty.);
    }

    public boolean isCartEmpty() {
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(cartEmptyMessage)).getText();
        return message.equals(Your cart is empty.);
    }

    public void closeBrowser() {
        driver.quit();
    }
}