package com.cucumber.steps;

import com.page_objects.LocalizationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocalizationSteps extends LocalizationPage {

    @Given("the application is launched")
    public void theApplicationIsLaunched() {
        launchApplication();
    }

    @When("the user navigates to the language settings")
    public void theUserNavigatesToTheLanguageSettings() {
        navigateToLanguageSettings();
    }

    @Then("the user should see a list of available languages")
    public void theUserShouldSeeAListOfAvailableLanguages() {
        verifyAvailableLanguages();
    }

    @Then("the application should display the interface in the selected language")
    public void theApplicationShouldDisplayTheInterfaceInTheSelectedLanguage() {
        verifyInterfaceLanguage();
    }

    @When("the user navigates to the currency settings")
    public void theUserNavigatesToTheCurrencySettings() {
        navigateToCurrencySettings();
    }

    @Then("the system should automatically detect and set the currency based on the user's region")
    public void theSystemShouldAutomaticallyDetectAndSetTheCurrencyBasedOnTheUsersRegion() {
        verifyCurrencyDetection();
    }

    @When("the user navigates to the settings")
    public void theUserNavigatesToTheSettings() {
        navigateToSettings();
    }

    @When("selects their preferred language and currency")
    public void selectsTheirPreferredLanguageAndCurrency() {
        selectPreferredLanguageAndCurrency();
    }

    @Then("the application should update the interface to the selected language")
    public void theApplicationShouldUpdateTheInterfaceToTheSelectedLanguage() {
        verifyInterfaceUpdate();
    }

    @Then("display prices in the selected currency")
    public void displayPricesInTheSelectedCurrency() {
        verifyPriceDisplay();
    }

    @When("there is a localization error")
    public void thereIsALocalizationError() {
        simulateLocalizationError();
    }

    @Then("the application should display an error message")
    public void theApplicationShouldDisplayAnErrorMessage() {
        verifyErrorMessageDisplay();
    }

    @Then("allow the user to continue using the application")
    public void allowTheUserToContinueUsingTheApplication() {
        verifyApplicationContinuity();
    }

    @When("the user switches between languages and currencies")
    public void theUserSwitchesBetweenLanguagesAndCurrencies() {
        switchLanguagesAndCurrencies();
    }

    @Then("the data displayed should remain consistent")
    public void theDataDisplayedShouldRemainConsistent() {
        verifyDataConsistency();
    }

    @Then("the language and currency selection interface should be intuitive and easy to use")
    public void theLanguageAndCurrencySelectionInterfaceShouldBeIntuitiveAndEasyToUse() {
        verifyInterfaceUsability();
    }

    @When("the user changes language or currency settings")
    public void theUserChangesLanguageOrCurrencySettings() {
        changeLanguageOrCurrencySettings();
    }

    @Then("the system should log these interactions for tracking purposes")
    public void theSystemShouldLogTheseInteractionsForTrackingPurposes() {
        verifyInteractionLogging();
    }

    @Then("the application should update these settings in real-time without requiring a restart")
    public void theApplicationShouldUpdateTheseSettingsInRealTimeWithoutRequiringARestart() {
        verifyRealTimeUpdate();
    }

    @Given("the application is launched on a desktop or mobile device")
    public void theApplicationIsLaunchedOnADesktopOrMobileDevice() {
        launchApplicationOnDevice();
    }

    @Then("the application should support localization features consistently across both platforms")
    public void theApplicationShouldSupportLocalizationFeaturesConsistentlyAcrossBothPlatforms() {
        verifyCrossPlatformLocalization();
    }
}