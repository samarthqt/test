package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class SettingsPage extends WebReusableComponents {

    protected By languageDropdown = By.id("languageDropdown");
    protected By currencyDropdown = By.id("currencyDropdown");
    protected By confirmButton = By.id("confirmButton");
    protected By contentArea = By.id("contentArea");
    protected By priceArea = By.id("priceArea");
    protected By applicationInterface = By.id("applicationInterface");
    protected By deviceAccess = By.id("deviceAccess");
    protected By conversionRateArea = By.id("conversionRateArea");
    protected By unsupportedSettingsArea = By.id("unsupportedSettingsArea");
    protected By defaultSettingsArea = By.id("defaultSettingsArea");

    public SettingsPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSettingsPage() {
        navigateToUrl("/settings");
    }

    public void selectLanguage(String language) {
        waitUntilElementVisible(languageDropdown, 3);
        selectByVisibleText(languageDropdown, language);
    }

    public void selectCurrency(String currency) {
        waitUntilElementVisible(currencyDropdown, 3);
        selectByVisibleText(currencyDropdown, currency);
    }

    public void confirmSettingsChanges() {
        waitUntilElementVisible(confirmButton, 3);
        clickElement(confirmButton);
    }

    public void verifyContentLanguage(String expectedLanguage) {
        waitUntilElementVisible(contentArea, 3);
        String actualLanguage = getTextFromElement(contentArea);
        Assert.assertTrue(actualLanguage.contains(expectedLanguage), "Content language is not updated.");
    }

    public void verifyPricesCurrency(String expectedCurrency) {
        waitUntilElementVisible(priceArea, 3);
        String actualCurrency = getTextFromElement(priceArea);
        Assert.assertTrue(actualCurrency.contains(expectedCurrency), "Prices currency is not updated.");
    }

    public void navigateThroughApplication() {
        waitUntilElementVisible(applicationInterface, 3);
        clickElement(applicationInterface);
        Assert.assertTrue(elementVisible(applicationInterface), "Failed to navigate through application.");
    }

    public void triggerCurrencyConversion() {
        waitUntilElementVisible(currencyDropdown, 3);
        selectByVisibleText(currencyDropdown, "USD");
        clickElement(confirmButton);
        Assert.assertTrue(elementVisible(conversionRateArea), "Currency conversion not triggered.");
    }

    public void verifyConversionRates() {
        waitUntilElementVisible(conversionRateArea, 3);
        String conversionRates = getTextFromElement(conversionRateArea);
        Assert.assertFalse(conversionRates.isEmpty(), "Conversion rates are not displayed.");
    }

    public void applyUnsupportedSettings() {
        waitUntilElementVisible(unsupportedSettingsArea, 3);
        clickElement(unsupportedSettingsArea);
        Assert.assertTrue(elementVisible(unsupportedSettingsArea), "Unsupported settings not applied.");
    }

    public void verifyFallbackToDefaultSettings() {
        waitUntilElementVisible(defaultSettingsArea, 3);
        String defaultSettings = getTextFromElement(defaultSettingsArea);
        Assert.assertTrue(defaultSettings.contains("Default"), "Fallback to default settings failed.");
    }

    public void accessDifferentInterfaces() {
        waitUntilElementVisible(applicationInterface, 3);
        clickElement(applicationInterface);
        Assert.assertTrue(elementVisible(applicationInterface), "Failed to access different interfaces.");
    }

    public void verifyConsistencyAcrossInterfaces() {
        waitUntilElementVisible(applicationInterface, 3);
        List<WebElement> interfaces = getWebElementList(applicationInterface);
        Assert.assertFalse(interfaces.isEmpty(), "Consistency across interfaces is not maintained.");
    }

    public void accessApplicationOnDevice() {
        waitUntilElementVisible(deviceAccess, 3);
        clickElement(deviceAccess);
        Assert.assertTrue(elementVisible(deviceAccess), "Failed to access application on device.");
    }

    public void verifyLocalizationFeaturesOnDevices() {
        waitUntilElementVisible(deviceAccess, 3);
        String localizationFeatures = getTextFromElement(deviceAccess);
        Assert.assertTrue(localizationFeatures.contains("Localized"), "Localization features on devices are not verified.");
    }
}