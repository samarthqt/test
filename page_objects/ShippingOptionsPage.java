package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShippingOptionsPage extends WebReusableComponents {

    protected By checkoutPage = By.id("checkoutPage");
    protected By shippingOptionsList = By.id("shippingOptionsList");
    protected By deliverySpeedOptions = By.cssSelector(".delivery-speed-option");
    protected By locationInput = By.id("locationInput");
    protected By locationBasedOptions = By.cssSelector(".location-based-option");
    protected By orderSummary = By.id("orderSummary");
    protected By shippingOptionCost = By.cssSelector(".shipping-option-cost");

    public void navigateToCheckoutPage() {
        waitUntilElementVisible(checkoutPage, 3);
        clickElement(checkoutPage);
    }

    public void displayShippingOptions() {
        waitUntilElementVisible(shippingOptionsList, 3);
    }

    public void verifyDeliverySpeedOptions() {
        waitUntilElementVisible(deliverySpeedOptions, 3);
        Assert.assertTrue(getWebElementList(deliverySpeedOptions).size() > 0, "Delivery speed options are not available.");
    }

    public void selectShippingOptionBySpeed(String speed) {
        selectByValue(deliverySpeedOptions, speed);
    }

    public void verifySelectedShippingOptionInSummary() {
        waitUntilElementVisible(orderSummary, 3);
        String summaryText = getTextFromElement(orderSummary);
        Assert.assertTrue(summaryText.contains("Selected Shipping Option"), "Selected shipping option is not displayed in the order summary.");
    }

    public void enterDeliveryLocation(String location) {
        waitUntilElementVisible(locationInput, 3);
        enterText(locationInput, location);
    }

    public void verifyLocationBasedShippingOptions() {
        waitUntilElementVisible(locationBasedOptions, 3);
        Assert.assertTrue(getWebElementList(locationBasedOptions).size() > 0, "Location-based shipping options are not available.");
    }

    public void selectShippingOptionByLocation(String location) {
        selectByValue(locationBasedOptions, location);
    }

    public void selectItemsForPurchase() {
        // Implementation for selecting items
    }

    public void proceedToCheckout() {
        // Implementation for proceeding to checkout
    }

    public void displayAvailableShippingOptions() {
        waitUntilElementVisible(shippingOptionsList, 3);
    }

    public void reviewShippingOptions() {
        // Implementation for reviewing shipping options
    }

    public void selectMostSuitableShippingOption() {
        // Implementation for selecting the most suitable shipping option
    }

    public void selectInitialShippingOption() {
        // Implementation for selecting initial shipping option
    }

    public void changeShippingOption() {
        // Implementation for changing shipping option
    }

    public void navigateToShippingOptionsPage() {
        // Implementation for navigating to shipping options page
    }

    public void reviewAvailableShippingOptions() {
        // Implementation for reviewing available shipping options
    }

    public void verifyShippingOptionCosts() {
        waitUntilElementVisible(shippingOptionCost, 3);
        Assert.assertTrue(getWebElementList(shippingOptionCost).size() > 0, "Shipping option costs are not displayed.");
    }

    public void selectShippingOptionByCost(String cost) {
        selectByValue(shippingOptionCost, cost);
    }

    public void verifySelectedShippingOptionCostInSummary() {
        waitUntilElementVisible(orderSummary, 3);
        String summaryText = getTextFromElement(orderSummary);
        Assert.assertTrue(summaryText.contains("Shipping Option Cost"), "Selected shipping option cost is not displayed in the order summary.");
    }
}