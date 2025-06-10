package com.cucumber.steps;

import com.page_objects.LocalizationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocalizationSteps extends LocalizationPage {

    @Given("the application supports multiple languages and currencies")
    public void theApplicationSupportsMultipleLanguagesAndCurrencies() {
        verifyLanguageAndCurrencySupport();
    }

    @When("a user selects a preferred language and currency")
    public void aUserSelectsAPreferredLanguageAndCurrency() {
        selectLanguageAndCurrency();
    }

    @Then("the application should display content in the selected language")
    public void theApplicationShouldDisplayContentInTheSelectedLanguage() {
        verifyContentLanguage();
    }

    @Then("prices should be shown in the selected currency")
    public void pricesShouldBeShownInTheSelectedCurrency() {
        verifyCurrencyDisplay();
    }

    @Given("the application supports region-based content adjustment")
    public void theApplicationSupportsRegionBasedContentAdjustment() {
        verifyRegionSupport();
    }

    @When("a user accesses the application from a specific region")
    public void aUserAccessesTheApplicationFromASpecificRegion() {
        accessApplicationFromRegion();
    }

    @Then("the content should be adjusted to match the user's region")
    public void theContentShouldBeAdjustedToMatchTheUsersRegion() {
        verifyRegionContentAdjustment();
    }

    @Given("the application supports currency conversion")
    public void theApplicationSupportsCurrencyConversion() {
        verifyCurrencyConversionSupport();
    }

    @When("a user views prices in a different currency")
    public void aUserViewsPricesInADifferentCurrency() {
        viewPricesInDifferentCurrency();
    }

    @Then("the currency conversion should be accurate and up-to-date")
    public void theCurrencyConversionShouldBeAccurateAndUpToDate() {
        verifyCurrencyConversionAccuracy();
    }

    @Given("the application supports multiple language translations")
    public void theApplicationSupportsMultipleLanguageTranslations() {
        verifyLanguageTranslationSupport();
    }

    @When("a user selects a language")
    public void aUserSelectsALanguage() {
        selectLanguage();
    }

    @Then("the translations should be accurate and enhance the user experience")
    public void theTranslationsShouldBeAccurateAndEnhanceTheUserExperience() {
        verifyTranslationAccuracy();
    }

    @Given("the application supports localization")
    public void theApplicationSupportsLocalization() {
        verifyLocalizationSupport();
    }

    @When("a user changes the language or currency")
    public void aUserChangesTheLanguageOrCurrency() {
        changeLanguageOrCurrency();
    }

    @Then("the interface should remain responsive and support localization")
    public void theInterfaceShouldRemainResponsiveAndSupportLocalization() {
        verifyInterfaceResponsiveness();
    }

    @When("a user selects an invalid language or currency")
    public void aUserSelectsAnInvalidLanguageOrCurrency() {
        selectInvalidLanguageOrCurrency();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessageDisplay();
    }

    @When("a user interacts with localized features")
    public void aUserInteractsWithLocalizedFeatures() {
        interactWithLocalizedFeatures();
    }

    @Then("the application should comply with data privacy and security standards")
    public void theApplicationShouldComplyWithDataPrivacyAndSecurityStandards() {
        verifyDataPrivacyCompliance();
    }

    @Given("the application supports localization logging")
    public void theApplicationSupportsLocalizationLogging() {
        verifyLocalizationLoggingSupport();
    }

    @Then("the interactions should be logged for analytics")
    public void theInteractionsShouldBeLoggedForAnalytics() {
        verifyLocalizationLogging();
    }

    @Then("the localization should be optimized for performance")
    public void theLocalizationShouldBeOptimizedForPerformance() {
        verifyLocalizationPerformance();
    }

    @When("a user wants to switch the language or currency")
    public void aUserWantsToSwitchTheLanguageOrCurrency() {
        switchLanguageOrCurrency();
    }

    @Then("the user should be able to do so easily without any hassle")
    public void theUserShouldBeAbleToDoSoEasilyWithoutAnyHassle() {
        verifyEasySwitching();
    }
}