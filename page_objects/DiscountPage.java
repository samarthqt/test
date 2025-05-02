package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DiscountPage extends WebReusableComponents {

    protected By cartIcon = By.id("cartIcon");
    protected By eligibleProduct = By.cssSelector(".eligible-product");
    protected By discountDetails = By.cssSelector(".discount-details");
    protected By totalSavings = By.id("totalSavings");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By updatedTotalPrice = By.id("updatedTotalPrice");

    public void addProductToCart(String productName) {
        // Implementation to add product to cart
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void verifyDiscountsApplied() {
        waitUntilElementVisible(discountDetails, 3);
        boolean discountsApplied = getWebElementList(discountDetails)
            .stream()
            .anyMatch(detail -> detail.getText().contains("Discount Applied"));
        Assert.assertTrue(discountsApplied, "Discounts are not applied.");
    }

    public void verifyUpdatedTotalPrice() {
        waitUntilElementVisible(updatedTotalPrice, 3);
        String actualPrice = getTextFromElement(updatedTotalPrice);
        Assert.assertTrue(actualPrice.contains("Discounted Price"), "Total price is not updated.");
    }

    public void verifyDiscountDetails() {
        waitUntilElementVisible(discountDetails, 3);
        boolean detailsVisible = getWebElementList(discountDetails)
            .stream()
            .anyMatch(detail -> detail.getText().contains("Discount Details"));
        Assert.assertTrue(detailsVisible, "Discount details are not visible.");
    }

    public void verifyTotalSavingsDisplayed() {
        waitUntilElementVisible(totalSavings, 3);
        String savings = getTextFromElement(totalSavings);
        Assert.assertTrue(savings.contains("Total Savings"), "Total savings are not displayed.");
    }

    public void verifyNoDiscountsApplied() {
        waitUntilElementVisible(discountDetails, 3);
        boolean noDiscounts = getWebElementList(discountDetails)
            .stream()
            .noneMatch(detail -> detail.getText().contains("Discount Applied"));
        Assert.assertTrue(noDiscounts, "Discounts are incorrectly applied.");
    }

    public void verifyTotalPriceWithoutDiscounts() {
        waitUntilElementVisible(updatedTotalPrice, 3);
        String actualPrice = getTextFromElement(updatedTotalPrice);
        Assert.assertFalse(actualPrice.contains("Discounted Price"), "Total price incorrectly includes discounts.");
    }

    public void verifyMultipleDiscountsApplied() {
        waitUntilElementVisible(discountDetails, 3);
        boolean multipleDiscounts = getWebElementList(discountDetails)
            .stream()
            .anyMatch(detail -> detail.getText().contains("Multiple Discounts Applied"));
        Assert.assertTrue(multipleDiscounts, "Multiple discounts are not applied.");
    }

    public void verifyLoyaltyDiscountsApplied() {
        waitUntilElementVisible(discountDetails, 3);
        boolean loyaltyDiscounts = getWebElementList(discountDetails)
            .stream()
            .anyMatch(detail -> detail.getText().contains("Loyalty Discount Applied"));
        Assert.assertTrue(loyaltyDiscounts, "Loyalty discounts are not applied.");
    }

    public void verifyPromotionalDiscountsApplied() {
        waitUntilElementVisible(discountDetails, 3);
        boolean promotionalDiscounts = getWebElementList(discountDetails)
            .stream()
            .anyMatch(detail -> detail.getText().contains("Promotional Discount Applied"));
        Assert.assertTrue(promotionalDiscounts, "Promotional discounts are not applied.");
    }

    public void verifyNoDuplicateDiscounts() {
        waitUntilElementVisible(discountDetails, 3);
        boolean noDuplicates = getWebElementList(discountDetails)
            .stream()
            .noneMatch(detail -> detail.getText().contains("Duplicate Discount"));
        Assert.assertTrue(noDuplicates, "Duplicate discounts are applied.");
    }

    public void verifyTotalPriceWithoutDuplicateDiscounts() {
        waitUntilElementVisible(updatedTotalPrice, 3);
        String actualPrice = getTextFromElement(updatedTotalPrice);
        Assert.assertTrue(actualPrice.contains("Correct Price"), "Total price incorrectly includes duplicate discounts.");
    }
}