package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TaxCalculationPage extends WebReusableComponents {

    protected By regionDropdown = By.id("regionDropdown");
    protected By btnAddToCart = By.id("addToCart");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By taxCalculationMessage = By.id("taxCalculationMessage");
    protected By pricingDetails = By.id("pricingDetails");
    protected By discountField = By.id("discountField");

    public void setUserRegion(String region) {
        waitUntilElementVisible(regionDropdown, 3);
        selectByValue(regionDropdown, region);
    }

    public void addItemsToCart() {
        waitUntilElementVisible(btnAddToCart, 3);
        clickElement(btnAddToCart);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void calculateTaxes() {
        waitUntilElementVisible(taxCalculationMessage, 3);
        // Logic to calculate taxes based on region
    }

    public void verifyPricingWithTaxes() {
        waitUntilElementVisible(pricingDetails, 3);
        String pricing = getTextFromElement(pricingDetails);
        Assert.assertTrue(pricing.contains("Taxes included"), "Pricing does not include taxes.");
    }

    public void verifyTaxCalculation(String taxRate) {
        waitUntilElementVisible(taxCalculationMessage, 3);
        String message = getTextFromElement(taxCalculationMessage);
        Assert.assertTrue(message.contains(taxRate + "%"), "Tax calculation is incorrect.");
    }

    public void verifyNoTaxApplied() {
        waitUntilElementVisible(taxCalculationMessage, 3);
        String message = getTextFromElement(taxCalculationMessage);
        Assert.assertTrue(message.contains("No taxes"), "Taxes were applied incorrectly.");
    }

    public void verifyPricingWithoutTaxes() {
        waitUntilElementVisible(pricingDetails, 3);
        String pricing = getTextFromElement(pricingDetails);
        Assert.assertFalse(pricing.contains("Taxes included"), "Pricing incorrectly includes taxes.");
    }

    public void changeUserRegion(String newRegion) {
        setUserRegion(newRegion);
    }

    public void updateTaxCalculation() {
        waitUntilElementVisible(taxCalculationMessage, 3);
        // Logic to update tax calculation based on new region
    }

    public void verifyUpdatedPricingWithTaxes() {
        waitUntilElementVisible(pricingDetails, 3);
        String pricing = getTextFromElement(pricingDetails);
        Assert.assertTrue(pricing.contains("Updated taxes included"), "Updated pricing does not include taxes.");
    }

    public void applyPromotionalDiscount() {
        waitUntilElementVisible(discountField, 3);
        // Logic to apply discount
    }

    public void applyDiscountToCart() {
        // Logic to apply discount to cart
    }

    public void calculateTaxesAfterDiscount() {
        waitUntilElementVisible(taxCalculationMessage, 3);
        // Logic to calculate taxes after discount
    }

    public void verifyFinalPricingWithTaxesAndDiscount() {
        waitUntilElementVisible(pricingDetails, 3);
        String pricing = getTextFromElement(pricingDetails);
        Assert.assertTrue(pricing.contains("Final pricing with taxes and discount"), "Final pricing is incorrect.");
    }
}