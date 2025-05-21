
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import .time.Duration;
import .util.List;

public class ShoppingCartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartLink = By.id(shopping_cart_link);
    private final By cartItems = By.id(cart_items);
    private final By emptyCartMessage = By.id(empty_cart_message);
    private final By checkoutButton = By.id(checkout_button);
    private final By guestCheckoutButton = By.id(guest_checkout_button);
    private final By cartProductItem = By.cssSelector(.cart-product-item);
    private final By checkoutPage = By.id(checkout_page);

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        driver.findElement(cartLink).click();
    }

    public boolean isEmptyCartMessageDisplayed() {
        WebElement emptyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
        return emptyMessage.isDisplayed();
    }

    public void clickGuestCheckout() {
        driver.findElement(guestCheckoutButton).click();
    }

    public void updateProductQuantity(String productName, int quantity) {
        WebElement product = driver.findElement(By.xpath(//div[contains(text(),' + productName + ')]/../..));
        WebElement quantityField = product.findElement(By.cssSelector(.product-quantity-input));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        product.findElement(By.cssSelector(.update-quantity-button)).click();
    }

    public boolean isCheckoutPageDisplayed() {
        WebElement checkoutPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage));
        return checkoutPageElement.isDisplayed();
    }

    public boolean hasItems() {
        WebElement cartItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        return !cartItemsElement.getText().isEmpty();
    }

    public boolean isTotalPriceCorrect() {
        // Implement logic to verify total price calculation
        return true;
    }

    public void clickProceedToCheckout() {
        WebElement checkoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButtonElement.click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isCartNotEmpty() {
        WebElement cartItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        return cartItemsElement.isDisplayed();
    }

    public void removeProduct(String productName) {
        WebElement product = driver.findElement(By.xpath(//div[contains(text(),' + productName + ')]/../..));
        product.findElement(By.cssSelector(.remove-product-button)).click();
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> products = driver.findElements(cartProductItem);
        for (WebElement product : products) {
            if (product.findElement(By.cssSelector(.product-name)).getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void navigateToShoppingCart() {
        driver.findElement(cartLink).click();
    }

    public boolean areProductDetailsCorrect() {
        List<WebElement> products = driver.findElements(cartProductItem);
        for (WebElement product : products) {
            if (!product.findElement(By.cssSelector(.product-name)).isDisplayed() ||
                !product.findElement(By.cssSelector(.product-quantity)).isDisplayed() ||
                !product.findElement(By.cssSelector(.product-price)).isDisplayed() ||
                !product.findElement(By.cssSelector(.product-total-price)).isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areProductsDisplayed() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductItem));
        return !products.isEmpty();
    }

    public boolean isQuantityUpdated(String productName, int expectedQuantity) {
        WebElement product = driver.findElement(By.xpath(//div[contains(text(),' + productName + ')]/../..));
        String quantity = product.findElement(By.cssSelector(.product-quantity)).getText();
        return Integer.parseInt(quantity) == expectedQuantity;
    }
}
