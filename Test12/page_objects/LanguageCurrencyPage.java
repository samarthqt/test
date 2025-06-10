package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LanguageCurrencyPage extends WebReusableComponents {

    protected By regionDetection = By.id("regionDetection");
    protected By languageCurrencySettings = By.id("languageCurrencySettings");
    protected By conversionRates = By.id("conversionRates");
    protected By unsupportedSelectionError = By.id("unsupportedSelectionError");
    protected By notificationMessage = By.id("notificationMessage");

    public LanguageCurrencyPage() {
        PageFactory.initElements(driver, this);
    }

    public void openApplication() {
        navigateToUrl("http://application.url");
    }

    public void detectUserRegion() {
        waitUntilElementVisible(regionDetection, 3);
        clickElement(regionDetection);
    }

    public void verifyAutomaticAdjustment() {
        String language = getTextFromElement(By.id("language"));
        String currency = getTextFromElement(By.id("currency"));
        Assert.assertTrue(language.equals("English") && currency.equals("USD"), "Automatic adjustment failed.");
    }

    public void changeSettingsManually() {
        waitUntilElementVisible(languageCurrencySettings, 3);
        clickElement(languageCurrencySettings);
    }

    public void verifyManualSelection() {
        String selectedLanguage = getTextFromElement(By.id("selectedLanguage"));
        String selectedCurrency = getTextFromElement(By.id("selectedCurrency"));
        Assert.assertTrue(selectedLanguage.equals("French") && selectedCurrency.equals("EUR"), "Manual selection failed.");
    }

    public void viewConversionRates() {
        waitUntilElementVisible(conversionRates, 3);
        clickElement(conversionRates);
    }

    public void verifyConversionRatesAccuracy() {
        String conversionRate = getTextFromElement(By.id("conversionRate"));
        Assert.assertEquals(conversionRate, "1.12", "Conversion rate accuracy failed.");
    }

    public void selectLanguageAndRegion() {
        selectByValue(By.id("languageDropdown"), "Spanish");
        selectByValue(By.id("regionDropdown"), "Europe");
    }

    public void verifyTextAndCurrencyFormats() {
        String textFormat = getTextFromElement(By.id("textFormat"));
        String currencyFormat = getTextFromElement(By.id("currencyFormat"));
        Assert.assertTrue(textFormat.equals("Formatted Text") && currencyFormat.equals("€100"), "Text and currency formats display failed.");
    }

    public void selectUnsupportedLanguageOrCurrency() {
        selectByValue(By.id("languageDropdown"), "UnsupportedLanguage");
        selectByValue(By.id("currencyDropdown"), "UnsupportedCurrency");
    }

    public void verifyErrorMessageForUnsupportedSelection() {
        String errorMessage = getTextFromElement(unsupportedSelectionError);
        Assert.assertEquals(errorMessage, "Unsupported language or currency selected.", "Error message display failed.");
    }

    public void performConversion() {
        clickElement(By.id("performConversion"));
    }

    public void verifyDataIntegrity() {
        String dataIntegrityStatus = getTextFromElement(By.id("dataIntegrityStatus"));
        Assert.assertEquals(dataIntegrityStatus, "Secure", "Data integrity during conversion failed.");
    }

    public void changeLanguageAndCurrencySettings() {
        clickElement(By.id("changeSettings"));
    }

    public void verifyLoggingOfChanges() {
        String logStatus = getTextFromElement(By.id("logStatus"));
        Assert.assertEquals(logStatus, "Logged", "Logging of changes failed.");
    }

    public void requireCurrencyConversion() {
        clickElement(By.id("requireConversion"));
    }

    public void verifyThirdPartyIntegration() {
        String integrationStatus = getTextFromElement(By.id("integrationStatus"));
        Assert.assertEquals(integrationStatus, "Seamless", "Third-party integration failed.");
    }

    public void automaticRegionSettingsChange() {
        clickElement(By.id("automaticRegionChange"));
    }

    public void verifyNotificationsForRegionChange() {
        String notification = getTextFromElement(notificationMessage);
        Assert.assertEquals(notification, "Region settings changed.", "Notification for region change failed.");
    }

    public void verifySupportForLanguagesAndCurrencies() {
        String supportStatus = getTextFromElement(By.id("supportStatus"));
        Assert.assertEquals(supportStatus, "Supported", "Support for languages and currencies failed.");
    }

    public void performTesting() {
        clickElement(By.id("performTesting"));
    }

    public void verifyFunctionalityAcrossLanguagesAndCurrencies() {
        String functionalityStatus = getTextFromElement(By.id("functionalityStatus"));
        Assert.assertEquals(functionalityStatus, "Confirmed", "Functionality across languages and currencies failed.");
    }
}