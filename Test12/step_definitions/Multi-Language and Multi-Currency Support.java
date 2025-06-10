package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SettingsPage;

public class MultiLanguageCurrencySteps extends SettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the settings page")
    public void theUserIsOnTheSettingsPage() {
        navigateToSettingsPage();
    }

    @When("the user selects a language from the list of supported languages")
    public void theUserSelectsALanguageFromTheListOfSupportedLanguages() {
        String language = testHarness.getData("SettingsData", "Language");
        selectLanguage(language);
    }

    @Then("the system should update the content to the selected language")
    public void theSystemShouldUpdateTheContentToTheSelectedLanguage() {
        String expectedLanguage = testHarness.getData("SettingsData", "Language");
        verifyContentLanguage(expectedLanguage);
    }

    @When("the user selects a currency from the list of supported currencies")
    public void theUserSelectsACurrencyFromTheListOfSupportedCurrencies() {
        String currency = testHarness.getData("SettingsData", "Currency");
        selectCurrency(currency);
    }

    @Then("the system should update the prices to the selected currency")
    public void theSystemShouldUpdateThePricesToTheSelectedCurrency() {
        String expectedCurrency = testHarness.getData("SettingsData", "Currency");
        verifyPricesCurrency(expectedCurrency);
    }

    @Given("the user has selected a language and currency")
    public void theUserHasSelectedALanguageAndCurrency() {
        String language = testHarness.getData("SettingsData", "Language");
        String currency = testHarness.getData("SettingsData", "Currency");
        selectLanguage(language);
        selectCurrency(currency);
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplication() {
        navigateThroughApplication();
    }

    @Then("the system should display all content and prices in the selected language and currency")
    public void theSystemShouldDisplayAllContentAndPricesInTheSelectedLanguageAndCurrency() {
        String expectedLanguage = testHarness.getData("SettingsData", "Language");
        String expectedCurrency = testHarness.getData("SettingsData", "Currency");
        verifyContentLanguage(expectedLanguage);
        verifyPricesCurrency(expectedCurrency);
    }

    @Given("the user changes the language or currency settings")
    public void theUserChangesTheLanguageOrCurrencySettings() {
        String newLanguage = testHarness.getData("SettingsData", "NewLanguage");
        String newCurrency = testHarness.getData("SettingsData", "NewCurrency");
        selectLanguage(newLanguage);
        selectCurrency(newCurrency);
    }

    @When("the user confirms the changes")
    public void theUserConfirmsTheChanges() {
        confirmSettingsChanges();
    }

    @Then("the system should immediately reflect the changes across all interfaces")
    public void theSystemShouldImmediatelyReflectTheChangesAcrossAllInterfaces() {
        String expectedLanguage = testHarness.getData("SettingsData", "NewLanguage");
        String expectedCurrency = testHarness.getData("SettingsData", "NewCurrency");
        verifyContentLanguage(expectedLanguage);
        verifyPricesCurrency(expectedCurrency);
    }

    @Given("the user selects a currency for transactions")
    public void theUserSelectsACurrencyForTransactions() {
        String currency = testHarness.getData("SettingsData", "Currency");
        selectCurrency(currency);
    }

    @When("there is a need for currency conversion")
    public void thereIsANeedForCurrencyConversion() {
        triggerCurrencyConversion();
    }

    @Then("the system should apply accurate conversion rates")
    public void theSystemShouldApplyAccurateConversionRates() {
        verifyConversionRates();
    }

    @Given("the user selects a language or currency not supported by the system")
    public void theUserSelectsALanguageOrCurrencyNotSupportedByTheSystem() {
        String unsupportedLanguage = testHarness.getData("SettingsData", "UnsupportedLanguage");
        String unsupportedCurrency = testHarness.getData("SettingsData", "UnsupportedCurrency");
        selectLanguage(unsupportedLanguage);
        selectCurrency(unsupportedCurrency);
    }

    @When("the user tries to apply the settings")
    public void theUserTriesToApplyTheSettings() {
        applyUnsupportedSettings();
    }

    @Then("the system should provide a fallback option to the default language or currency")
    public void theSystemShouldProvideAFallbackOptionToTheDefaultLanguageOrCurrency() {
        verifyFallbackToDefaultSettings();
    }

    @Given("the user has selected language and currency settings")
    public void theUserHasSelectedLanguageAndCurrencySettings() {
        String language = testHarness.getData("SettingsData", "Language");
        String currency = testHarness.getData("SettingsData", "Currency");
        selectLanguage(language);
        selectCurrency(currency);
    }

    @When("the user accesses different interfaces of the application")
    public void theUserAccessesDifferentInterfacesOfTheApplication() {
        accessDifferentInterfaces();
    }

    @Then("the system should maintain consistency with the selected settings")
    public void theSystemShouldMaintainConsistencyWithTheSelectedSettings() {
        verifyConsistencyAcrossInterfaces();
    }

    @Given("the user accesses the application on a desktop or mobile device")
    public void theUserAccessesTheApplicationOnADesktopOrMobileDevice() {
        accessApplicationOnDevice();
    }

    @When("the user navigates to the settings page")
    public void theUserNavigatesToTheSettingsPage() {
        navigateToSettingsPage();
    }

    @Then("the localization features should be available and functional on both types of devices")
    public void theLocalizationFeaturesShouldBeAvailableAndFunctionalOnBothTypesOfDevices() {
        verifyLocalizationFeaturesOnDevices();
    }
}