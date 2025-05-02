package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PriceDiscountPage extends WebReusableComponents {

    protected By originalPrice = By.id("originalPrice");
    protected By discountedPrice = By.id("discountedPrice");
    protected By savingsHighlight = By.id("savingsHighlight");

    public void navigateToProductPage(String productName) {
        // Implementation to navigate to product page
    }

    public void applyDiscountToProduct() {
        // Implementation to apply discount
    }

    public void ensureNoDiscountOnProduct() {
        // Implementation to ensure no discount
    }

    public void loginUser() {
        // Implementation to log in user
    }

    public void logoutUser() {
        // Implementation to log out user
    }

    public void displayProductOnPlatform() {
        // Implementation to display product
    }

    public void verifyOriginalPriceDisplayed() {
        waitUntilElementVisible(originalPrice, 3);
        Assert.assertTrue(elementVisible(originalPrice), "Original price is not displayed.");
    }

    public void verifyDiscountedPriceDisplayed() {
        waitUntilElementVisible(discountedPrice, 3);
        Assert.assertTrue(elementVisible(discountedPrice), "Discounted price is not displayed.");
    }

    public void verifySavingsHighlighted() {
        waitUntilElementVisible(savingsHighlight, 3);
        Assert.assertTrue(elementVisible(savingsHighlight), "Savings are not highlighted.");
    }

    public void verifyOnlyOriginalPriceDisplayed() {
        waitUntilElementVisible(originalPrice, 3);
        Assert.assertTrue(elementVisible(originalPrice), "Original price is not displayed.");
        Assert.assertFalse(elementVisible(discountedPrice), "Discounted price should not be displayed.");
    }

    public void verifyNoDiscountedPriceDisplayed() {
        Assert.assertFalse(elementVisible(discountedPrice), "Discounted price should not be displayed.");
    }

    public void verifyPricesDisplayedInUSD() {
        // Implementation to verify prices in USD
    }
}