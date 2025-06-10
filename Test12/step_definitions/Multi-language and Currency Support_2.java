package com.cucumber.steps;

import com.page_objects.LanguageCurrencyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageCurrencySteps extends LanguageCurrencyPage {

    @Given("the user accesses the application")
    public void theUserAccessesTheApplication() {
        openApplication();
    }

    @When("the application detects the user's region")
    public void theApplicationDetectsTheUsersRegion() {
        detectUserRegion();
    }

    @Then("the application should automatically adjust language and currency settings")
    public void theApplicationShouldAutomaticallyAdjustLanguageAndCurrencySettings() {
        verifyAutomaticAdjustment();
    }

    @When("the user chooses to change language and currency settings manually")
    public void theUserChoosesToChangeLanguageAndCurrencySettingsManually() {
        changeSettingsManually();
    }

    @Then("the application should allow the user to select their preferred language and currency")
    public void theApplicationShouldAllowTheUserToSelectTheirPreferredLanguageAndCurrency() {
        verifyManualSelection();
    }

    @When("the user views currency conversion rates")
    public void theUserViewsCurrencyConversionRates() {
        viewConversionRates();
    }

    @Then("the system should provide accurate currency conversion rates")
    public void theSystemShouldProvideAccurateCurrencyConversionRates() {
        verifyConversionRatesAccuracy();
    }

    @When("the user selects a language and region")
    public void theUserSelectsALanguageAndRegion() {
        selectLanguageAndRegion();
    }

    @Then("all text and currency formats must be appropriately displayed according to the selected language and region")
    public void allTextAndCurrencyFormatsMustBeAppropriatelyDisplayedAccordingToTheSelectedLanguageAndRegion() {
        verifyTextAndCurrencyFormats();
    }

    @When("the user selects an unsupported language or currency")
    public void theUserSelectsAnUnsupportedLanguageOrCurrency() {
        selectUnsupportedLanguageOrCurrency();
    }

    @Then("the application should display an error message indicating the unsupported selection")
    public void theApplicationShouldDisplayAnErrorMessageIndicatingTheUnsupportedSelection() {
        verifyErrorMessageForUnsupportedSelection();
    }

    @When("language and currency conversion is performed")
    public void languageAndCurrencyConversionIsPerformed() {
        performConversion();
    }

    @Then("security measures should ensure data integrity during the conversion process")
    public void securityMeasuresShouldEnsureDataIntegrityDuringTheConversionProcess() {
        verifyDataIntegrity();
    }

    @When("the user changes language and currency settings")
    public void theUserChangesLanguageAndCurrencySettings() {
        changeLanguageAndCurrencySettings();
    }

    @Then("the application should log these changes for auditing purposes")
    public void theApplicationShouldLogTheseChangesForAuditingPurposes() {
        verifyLoggingOfChanges();
    }

    @When("currency conversion is required")
    public void currencyConversionIsRequired() {
        requireCurrencyConversion();
    }

    @Then("integration with third-party services for currency conversion must be seamless")
    public void integrationWithThirdPartyServicesForCurrencyConversionMustBeSeamless() {
        verifyThirdPartyIntegration();
    }

    @When("the application automatically changes region settings")
    public void theApplicationAutomaticallyChangesRegionSettings() {
        automaticRegionSettingsChange();
    }

    @Then("the user should receive notifications about the change")
    public void theUserShouldReceiveNotificationsAboutTheChange() {
        verifyNotificationsForRegionChange();
    }

    @Given("the application supports multiple languages and currencies")
    public void theApplicationSupportsMultipleLanguagesAndCurrencies() {
        verifySupportForLanguagesAndCurrencies();
    }

    @When("testing is performed")
    public void testingIsPerformed() {
        performTesting();
    }

    @Then("functionality should be confirmed across all supported languages and currencies")
    public void functionalityShouldBeConfirmedAcrossAllSupportedLanguagesAndCurrencies() {
        verifyFunctionalityAcrossLanguagesAndCurrencies();
    }
}