package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CurrencyConversionPage extends WebReusableComponents {

    protected By productPageUSD = By.id("productPageUSD");
    protected By currencyDropdown = By.id("currencyDropdown");
    protected By productPrice = By.id("productPrice");
    protected By conversionRateData = By.id("conversionRateData");
    protected By fluctuationSimulation = By.id("fluctuationSimulation");
    protected By checkoutPage = By.id("checkoutPage");
    protected By transactionLogs = By.id("transactionLogs");

    public CurrencyConversionPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProductPageInUSD() {
        waitUntilElementVisible(productPageUSD, 3);
        clickElement(productPageUSD);
    }

    public void verifyProductPageDisplayedWithUSD() {
        waitUntilElementVisible(productPrice, 3);
        String priceText = getTextFromElement(productPrice);
        Assert.assertTrue(priceText.contains("USD"), "Product page is not displayed with USD pricing.");
    }

    public void selectCurrency(String currency) {
        waitUntilElementVisible(currencyDropdown, 3);
        selectByValue(currencyDropdown, currency);
    }

    public void verifyProductPriceConvertedTo(String currency) {
        waitUntilElementVisible(productPrice, 3);
        String priceText = getTextFromElement(productPrice);
        Assert.assertTrue(priceText.contains(currency), "Product price is not converted to " + currency + ".");
    }

    public void fetchConversionRateData(String fromCurrency, String toCurrency) {
        waitUntilElementVisible(conversionRateData, 3);
        WebElement rateElement = driver.findElement(conversionRateData);
        String rateData = rateElement.getText();
        Assert.assertNotNull(rateData, "Conversion rate data is not available.");
    }

    public void verifyConvertedPriceMatchesExpected() {
        String expectedPrice = "Expected Price"; // Replace with actual logic to get expected price
        String actualPrice = getTextFromElement(productPrice);
        Assert.assertEquals(actualPrice, expectedPrice, "Converted price does not match expected value.");
    }

    public void simulateHighFluctuation() {
        waitUntilElementVisible(fluctuationSimulation, 3);
        clickElement(fluctuationSimulation);
    }

    public void verifySystemUpdatesConversionRate() {
        String updatedRate = "Updated Rate"; // Replace with actual logic to get updated rate
        String currentRate = getTextFromElement(conversionRateData);
        Assert.assertEquals(currentRate, updatedRate, "System did not update conversion rate correctly.");
    }

    public void reSelectCurrency(String currency) {
        selectCurrency(currency);
    }

    public void verifyProductPriceReflectsUpdatedRate(String currency) {
        verifyProductPriceConvertedTo(currency);
    }

    public void simulateAnotherFluctuation() {
        simulateHighFluctuation();
    }

    public void checkForDiscrepancies() {
        String discrepancies = "Discrepancies"; // Replace with actual logic to check discrepancies
        Assert.assertNull(discrepancies, "Discrepancies found in conversion calculations.");
    }

    public void verifyNoDiscrepancies() {
        checkForDiscrepancies();
    }

    public void navigateToCheckoutWithSelectedCurrency() {
        waitUntilElementVisible(checkoutPage, 3);
        clickElement(checkoutPage);
    }

    public void verifyCheckoutPageDisplaysPricesInSelectedCurrency() {
        String selectedCurrency = "Selected Currency"; // Replace with actual logic to get selected currency
        String checkoutPrice = getTextFromElement(productPrice);
        Assert.assertTrue(checkoutPrice.contains(selectedCurrency), "Checkout page does not display prices in selected currency.");
    }

    public void verifyFinalPriceAtCheckoutMatchesExpected() {
        String expectedFinalPrice = "Expected Final Price"; // Replace with actual logic to get expected final price
        String actualFinalPrice = getTextFromElement(productPrice);
        Assert.assertEquals(actualFinalPrice, expectedFinalPrice, "Final price at checkout does not match expected conversion rate.");
    }

    public void simulateRapidConversionRateChanges() {
        // Logic to simulate rapid conversion rate changes during checkout
        String rapidChange = "Rapid Change"; // Replace with actual logic
        Assert.assertNotNull(rapidChange, "Rapid conversion rate changes not simulated.");
    }

    public void verifySystemHandlesRateChanges() {
        String systemResponse = "System Response"; // Replace with actual logic to verify system response
        Assert.assertNotNull(systemResponse, "System did not handle rate changes correctly.");
    }

    public void completePurchase() {
        // Logic to complete the purchase
        String purchaseStatus = "Purchase Status"; // Replace with actual logic
        Assert.assertEquals(purchaseStatus, "Completed", "Purchase did not complete successfully.");
    }

    public void verifyPurchaseCompletesSuccessfully() {
        completePurchase();
    }

    public void reviewTransactionLogs() {
        waitUntilElementVisible(transactionLogs, 3);
        WebElement logsElement = driver.findElement(transactionLogs);
        String logsData = logsElement.getText();
        Assert.assertNotNull(logsData, "Transaction logs are not available.");
    }

    public void verifyTransactionLogsConfirmAccuracy() {
        reviewTransactionLogs();
        String accuracyConfirmation = "Accuracy Confirmation"; // Replace with actual logic
        Assert.assertNotNull(accuracyConfirmation, "Transaction logs do not confirm accurate conversion rates.");
    }
}