package com.cucumber.steps;

import com.page_objects.LanguageCurrencyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageCurrencySteps extends LanguageCurrencyPage {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        verifySuccessfulLogin();
    }

    @Then("the application should detect the user's region")
    public void theApplicationShouldDetectTheUsersRegion() {
        detectUserRegion();
    }

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the settings section")
    public void theUserNavigatesToTheSettingsSection() {
        navigateToSettingsSection();
    }

    @Then("the user should be able to access the settings section without errors")
    public void theUserShouldBeAbleToAccessTheSettingsSectionWithoutErrors() {
        verifySettingsSectionAccess();
    }

    @When("the region is detected")
    public void theRegionIsDetected() {
        detectUserRegion();
    }

    @Then("the language should be automatically set to the user's regional language")
    public void theLanguageShouldBeAutomaticallySetToTheUsersRegionalLanguage() {
        verifyAutomaticLanguageAdjustment();
    }

    @Then("the currency should be automatically set to the user's regional currency")
    public void theCurrencyShouldBeAutomaticallySetToTheUsersRegionalCurrency() {
        verifyAutomaticCurrencyAdjustment();
    }

    @Then("the UI should display all text and currency values in the correct language and currency")
    public void theUIShouldDisplayAllTextAndCurrencyValuesInTheCorrectLanguageAndCurrency() {
        verifyUIReflectsCorrectLanguageAndCurrency();
    }

    @Then("no error messages should be displayed related to language or currency settings")
    public void noErrorMessagesShouldBeDisplayedRelatedToLanguageOrCurrencySettings() {
        verifyNoErrorMessagesForLanguageCurrencySettings();
    }

    @When("the user changes language or currency settings during the session")
    public void theUserChangesLanguageOrCurrencySettingsDuringTheSession() {
        changeLanguageCurrencySettingsDuringSession();
    }

    @Then("the changes should be reflected immediately")
    public void theChangesShouldBeReflectedImmediately() {
        verifyImmediateReflectionOfChanges();
    }

    @When("region detection fails")
    public void regionDetectionFails() {
        simulateRegionDetectionFailure();
    }

    @Then("the system should revert to default language and currency settings")
    public void theSystemShouldRevertToDefaultLanguageAndCurrencySettings() {
        verifyReversionToDefaultSettings();
    }

    @When("the user makes a purchase")
    public void theUserMakesAPurchase() {
        simulateUserPurchase();
    }

    @Then("logs should accurately reflect the language and currency settings during the transaction")
    public void logsShouldAccuratelyReflectTheLanguageAndCurrencySettingsDuringTheTransaction() {
        verifyTransactionLogsForLanguageCurrencySettings();
    }

    @Then("the system should comply with all relevant regional regulations regarding language and currency settings")
    public void theSystemShouldComplyWithAllRelevantRegionalRegulationsRegardingLanguageAndCurrencySettings() {
        verifyComplianceWithRegionalRegulations();
    }

    @When("the user selects unsupported language or currency settings")
    public void theUserSelectsUnsupportedLanguageOrCurrencySettings() {
        selectUnsupportedLanguageCurrencySettings();
    }

    @Then("the system should display an error message")
    public void theSystemShouldDisplayAnErrorMessage() {
        verifyErrorMessageForUnsupportedSettings();
    }

    @When("the user navigates to language and currency settings")
    public void theUserNavigatesToLanguageAndCurrencySettings() {
        navigateToLanguageCurrencySettings();
    }

    @Then("the user should be able to manually adjust language and currency settings")
    public void theUserShouldBeAbleToManuallyAdjustLanguageAndCurrencySettings() {
        verifyManualAdjustmentOfSettings();
    }

    @Then("the UI should clearly display information about language and currency settings and options")
    public void theUIShouldClearlyDisplayInformationAboutLanguageAndCurrencySettingsAndOptions() {
        verifyUIDisplaysSettingsInformation();
    }

    @When("the user adjusts language and currency settings")
    public void theUserAdjustsLanguageAndCurrencySettings() {
        adjustLanguageCurrencySettings();
    }

    @Then("no security vulnerabilities should be exposed")
    public void noSecurityVulnerabilitiesShouldBeExposed() {
        verifyNoSecurityVulnerabilities();
    }

    @When("the user accesses the application from different devices and browsers")
    public void theUserAccessesTheApplicationFromDifferentDevicesAndBrowsers() {
        accessApplicationFromDifferentDevicesBrowsers();
    }

    @Then("language and currency settings should be consistent across all supported devices and browsers")
    public void languageAndCurrencySettingsShouldBeConsistentAcrossAllSupportedDevicesAndBrowsers() {
        verifyConsistencyAcrossDevicesBrowsers();
    }
}