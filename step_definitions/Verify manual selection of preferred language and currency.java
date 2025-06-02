package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.UserSettingsPage;

public class UserSettingsSteps extends UserSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettings();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @Then("language options are available: English, Spanish, French")
    public void languageOptionsAreAvailable() {
        verifyLanguageOptions();
    }

    @Then("currency options are available: USD, EUR, GBP")
    public void currencyOptionsAreAvailable() {
        verifyCurrencyOptions();
    }

    @Given("the language dropdown is visible")
    public void theLanguageDropdownIsVisible() {
        verifyLanguageDropdownVisible();
    }

    @When("the user selects 'Spanish' from the language dropdown")
    public void theUserSelectsSpanishFromTheLanguageDropdown() {
        selectLanguage("Spanish");
    }

    @Then("the language is set to Spanish")
    public void theLanguageIsSetToSpanish() {
        verifyLanguageSetTo("Spanish");
    }

    @Then("the currency dropdown is visible")
    public void theCurrencyDropdownIsVisible() {
        verifyCurrencyDropdownVisible();
    }

    @When("the user selects 'EUR' from the currency dropdown")
    public void theUserSelectsEURFromTheCurrencyDropdown() {
        selectCurrency("EUR");
    }

    @Then("the currency is set to EUR")
    public void theCurrencyIsSetToEUR() {
        verifyCurrencySetTo("EUR");
    }

    @When("the user saves the changes")
    public void theUserSavesTheChanges() {
        saveChanges();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        verifyChangesSaved();
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("the settings remain unchanged")
    public void theSettingsRemainUnchanged() {
        verifySettingsUnchanged();
    }

    @Then("the language is Spanish")
    public void theLanguageIsSpanish() {
        verifyLanguageIsSpanish();
    }

    @Then("the currency is EUR")
    public void theCurrencyIsEUR() {
        verifyCurrencyIsEUR();
    }

    @When("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        navigateToHomePage();
    }

    @Then("the home page is displayed in Spanish")
    public void theHomePageIsDisplayedInSpanish() {
        verifyHomePageInSpanish();
    }

    @Then("prices are shown in EUR")
    public void pricesAreShownInEUR() {
        verifyPricesInEUR();
    }

    @When("checking products listed on the page")
    public void checkingProductsListedOnThePage() {
        checkProductsOnPage();
    }

    @Then("product prices are displayed in EUR")
    public void productPricesAreDisplayedInEUR() {
        verifyProductPricesInEUR();
    }

    @When("the user accesses the help section")
    public void theUserAccessesTheHelpSection() {
        accessHelpSection();
    }

    @Then("the help section is displayed in Spanish")
    public void theHelpSectionIsDisplayedInSpanish() {
        verifyHelpSectionInSpanish();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the language and currency settings persist")
    public void theLanguageAndCurrencySettingsPersist() {
        verifySettingsPersist();
    }

    @When("the user switches to 'French' and 'GBP'")
    public void theUserSwitchesToFrenchAndGBP() {
        switchLanguageAndCurrency("French", "GBP");
    }

    @Then("the language is set to French")
    public void theLanguageIsSetToFrench() {
        verifyLanguageSetTo("French");
    }

    @Then("the currency is set to GBP")
    public void theCurrencyIsSetToGBP() {
        verifyCurrencySetTo("GBP");
    }

    @When("the user repeats navigation steps to verify changes")
    public void theUserRepeatsNavigationStepsToVerifyChanges() {
        repeatNavigationSteps();
    }

    @Then("all pages display in French")
    public void allPagesDisplayInFrench() {
        verifyAllPagesInFrench();
    }

    @Then("prices are shown in GBP")
    public void pricesAreShownInGBP() {
        verifyPricesInGBP();
    }

    @When("checking if notifications are in the selected language")
    public void checkingIfNotificationsAreInTheSelectedLanguage() {
        checkNotificationsLanguage();
    }

    @Then("notifications are displayed in French")
    public void notificationsAreDisplayedInFrench() {
        verifyNotificationsInFrench();
    }

    @When("the user attempts to change settings back to default")
    public void theUserAttemptsToChangeSettingsBackToDefault() {
        changeSettingsToDefault();
    }

    @Then("settings revert to default language and currency")
    public void settingsRevertToDefaultLanguageAndCurrency() {
        verifySettingsRevertedToDefault();
    }
}