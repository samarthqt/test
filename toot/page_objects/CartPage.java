package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartItemsLocator = By.id(cart_items);
    private final By removeButtonLocator = By.id(remove_button);
    private final By checkoutButtonLocator = By.id(checkout_button);
    private final By couponCodeLocator = By.id(coupon_code);
    private final By applyCouponButtonLocator = By.id(apply_coupon_button);
    private final By percentageDiscountAppliedLocator = By.id(percentage_discount_applied);
    private final By fixedDiscountAppliedLocator = By.id(fixed_discount_applied);
    private final By highestDiscountAppliedLocator = By.id(highest_discount_applied);
    private final By invalidCouponErrorLocator = By.id(invalid_coupon_error);
    private final By discountSummaryLocator = By.id(discount_summary);
    private final By fullPriceSummaryLocator = By.id(full_price_summary);
    private final By loginButtonLocator = By.id(login_button);
    private final By usernameLocator = By.id(username);
    private final By passwordLocator = By.id(password);
    private final By priceThresholdLocator = By.id(price_threshold);
    private final By totalPriceLocator = By.id(total_price);
    private final By addItemButtonLocator = By.id(add_item_button);
    private final By itemPriceLocator = By.id(item_price);
    private final By notificationLocator = By.id(notification);

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        driver.get(http://example.com/cart);
    }

    public boolean isCartNotEmpty() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return cartItems.isDisplayed();
    }

    public void setPriceThreshold(String threshold) {
        WebElement thresholdInput = driver.findElement(priceThresholdLocator);
        thresholdInput.clear();
        thresholdInput.sendKeys(threshold);
    }

    public void setCurrentTotalPrice(String currentTotal) {
        WebElement totalPrice = driver.findElement(totalPriceLocator);
        totalPrice.clear();
        totalPrice.sendKeys(currentTotal);
    }

    public void addItemToCart(String itemPrice) {
        WebElement addItemButton = driver.findElement(addItemButtonLocator);
        WebElement itemPriceInput = driver.findElement(itemPriceLocator);
        itemPriceInput.clear();
        itemPriceInput.sendKeys(itemPrice);
        addItemButton.click();
    }

    public void removeItemFromCart(String itemPrice) {
        WebElement removeItemButton = driver.findElement(removeButtonLocator);
        WebElement itemPriceInput = driver.findElement(itemPriceLocator);
        itemPriceInput.clear();
        itemPriceInput.sendKeys(itemPrice);
        removeItemButton.click();
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
        checkoutButton.click();
    }

    public void enterCouponCode(String couponCode) {
        WebElement couponField = driver.findElement(couponCodeLocator);
        couponField.clear();
        couponField.sendKeys(couponCode);
        WebElement applyButton = driver.findElement(applyCouponButtonLocator);
        applyButton.click();
    }

    public boolean isPercentageDiscountApplied() {
        WebElement discountApplied = driver.findElement(percentageDiscountAppliedLocator);
        return discountApplied.isDisplayed();
    }

    public boolean isFixedDiscountApplied() {
        WebElement discountApplied = driver.findElement(fixedDiscountAppliedLocator);
        return discountApplied.isDisplayed();
    }

    public boolean isHighestDiscountApplied() {
        WebElement highestDiscount = driver.findElement(highestDiscountAppliedLocator);
        return highestDiscount.isDisplayed();
    }

    public boolean isInvalidCouponErrorDisplayed() {
        WebElement error = driver.findElement(invalidCouponErrorLocator);
        return error.isDisplayed();
    }

    public boolean isDiscountDisplayedInSummary() {
        WebElement discountSummary = driver.findElement(discountSummaryLocator);
        return discountSummary.isDisplayed();
    }

    public boolean isFullPriceDisplayedInSummary() {
        WebElement fullPriceSummary = driver.findElement(fullPriceSummaryLocator);
        return fullPriceSummary.isDisplayed();
    }

    public void login(String username, String password) {
        driver.get(http://example.com/login);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        WebElement passwordField = driver.findElement(passwordLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isNotificationDisplayed() {
        WebElement notification = driver.findElement(notificationLocator);
        return notification.isDisplayed();
    }

    public boolean isProductInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return cartItems.isDisplayed();
    }

    public int getCartItemCount() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return Integer.parseInt(cartItems.getText());
    }

    public boolean areAllProductsInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return cartItems.isDisplayed();
    }

    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains(/cart);
    }

    public boolean isProductDisplayedInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return cartItems.isDisplayed();
    }

    public boolean isOutOfStockProductInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return !cartItems.getText().contains(Out of Stock);
    }

    public boolean hasProductsInCart() {
        WebElement cartItems = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemsLocator));
        return cartItems.isDisplayed();
    }

    public void selectProductToRemove() {
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtonLocator));
        removeButton.click();
    }

    public void clickRemoveButton() {
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtonLocator));
        removeButton.click();
    }

    public void updateProductQuantity(String quantity) {
        WebElement quantityInput = driver.findElement(By.id(quantity));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public boolean isQuantityUpdated() {
        WebElement quantityInput = driver.findElement(By.id(quantity));
        return quantityInput.getAttribute(value).equals(Updated);
    }

    public boolean isTotalPriceRecalculated() {
        WebElement totalPrice = driver.findElement(totalPriceLocator);
        return totalPrice.getText().equals(Recalculated);
    }

    public boolean qualifiesForPercentageDiscount() {
        WebElement discountLabel = driver.findElement(By.id(percentage_discount_label));
        return discountLabel.isDisplayed();
    }

    public boolean qualifiesForFixedDiscount() {
        WebElement discountLabel = driver.findElement(By.id(fixed_discount_label));
        return discountLabel.isDisplayed();
    }

    public boolean qualifiesForAnyDiscount() {
        return qualifiesForPercentageDiscount() || qualifiesForFixedDiscount();
    }

    public boolean qualifiesForMultipleDiscounts() {
        return qualifiesForPercentageDiscount() && qualifiesForFixedDiscount();
    }

    public boolean hasValidCouponCode() {
        WebElement couponField = driver.findElement(couponCodeLocator);
        return couponField.getAttribute(value).equals(VALID_COUPON);
    }

    public boolean hasExpiredCouponCode() {
        WebElement couponField = driver.findElement(couponCodeLocator);
        return couponField.getAttribute(value).equals(EXPIRED_COUPON);
    }

    public boolean isCouponDiscountApplied() {
        WebElement couponDiscount = driver.findElement(By.id(coupon_discount_applied));
        return couponDiscount.isDisplayed();
    }

    public boolean isAnyDiscountApplied() {
        return isPercentageDiscountApplied() || isFixedDiscountApplied();
    }

    public boolean isFullPriceDisplayedInSummary() {
        WebElement fullPriceSummary = driver.findElement(fullPriceSummaryLocator);
        return fullPriceSummary.isDisplayed();
    }
}