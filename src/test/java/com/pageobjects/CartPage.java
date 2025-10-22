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
    protected By couponField = By.id("couponField");
    protected By btnSubmitCoupon = By.id("submitCoupon");
    protected By couponSuccessMessage = By.id("couponSuccessMessage");
    protected By couponErrorMessage = By.id("couponErrorMessage");
    protected By discountSummary = By.id("discountSummary");
    protected By discountedTotal = By.id("discountedTotal");

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

    public void verifyCartIsNotEmpty() {
        waitUntilElementVisible(cartItems, 3);
        Assert.assertTrue(getWebElementList(cartItems).size() > 0, "Cart is empty.");
    }

    public void enterCouponCode(String couponCode) {
        waitUntilElementVisible(couponField, 3);
        enterText(couponField, couponCode);
    }

    public void submitCouponCode() {
        waitUntilElementVisible(btnSubmitCoupon, 3);
        clickElement(btnSubmitCoupon);
    }

    public void verifyCouponAccepted() {
        waitUntilElementVisible(couponSuccessMessage, 3);
        String successMessage = getTextFromElement(couponSuccessMessage);
        Assert.assertTrue(successMessage.contains("Coupon applied successfully"), "Coupon was not accepted.");
    }

    public void verifyDiscountDisplayed() {
        waitUntilElementVisible(discountSummary, 3);
        String discountText = getTextFromElement(discountSummary);
        Assert.assertTrue(discountText.contains("Discount"), "Discount not displayed in summary.");
    }

    public void verifyDiscountedTotalDisplayed() {
        waitUntilElementVisible(discountedTotal, 3);
        String totalText = getTextFromElement(discountedTotal);
        Assert.assertTrue(totalText.contains("Total"), "Discounted total not displayed.");
    }

    public void verifyCouponExpiredMessage() {
        waitUntilElementVisible(couponErrorMessage, 3);
        String errorMessage = getTextFromElement(couponErrorMessage);
        Assert.assertTrue(errorMessage.contains("expired"), "Expired coupon error message not displayed.");
    }

    public void verifyCouponInvalidMessage() {
        waitUntilElementVisible(couponErrorMessage, 3);
        String errorMessage = getTextFromElement(couponErrorMessage);
        Assert.assertTrue(errorMessage.contains("invalid"), "Invalid coupon error message not displayed.");
    }

    public void verifyCheckoutPageIsDisplayed() {
        // Implementation to verify checkout page is displayed
    }
}