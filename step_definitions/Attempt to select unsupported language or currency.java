package com.cucumber.steps;

import com.page_objects.UserSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSettingsSteps extends UserSettingsPage {

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

    @When("the user locates the language selection dropdown")
    public void theUserLocatesTheLanguageSelectionDropdown() {
        locateLanguageDropdown();
    }

    @Then("the language dropdown is visible")
    public void theLanguageDropdownIsVisible() {
        verifyLanguageDropdownVisible();
    }

    @When("the user attempts to select 'Klingon' from the language dropdown")
    public void theUserAttemptsToSelectKlingonFromTheLanguageDropdown() {
        selectUnsupportedLanguage("Klingon");
    }

    @Then("an error message 'Language not supported' is displayed")
    public void anErrorMessageLanguageNotSupportedIsDisplayed() {
        verifyLanguageNotSupportedError();
    }

    @When("the user locates the currency selection dropdown")
    public void theUserLocatesTheCurrencySelectionDropdown() {
        locateCurrencyDropdown();
    }

    @Then("the currency dropdown is visible")
    public void theCurrencyDropdownIsVisible() {
        verifyCurrencyDropdownVisible();
    }

    @When("the user attempts to select 'Bitcoin' from the currency dropdown")
    public void theUserAttemptsToSelectBitcoinFromTheCurrencyDropdown() {
        selectUnsupportedCurrency("Bitcoin");
    }

    @Then("an error message 'Currency not supported' is displayed")
    public void anErrorMessageCurrencyNotSupportedIsDisplayed() {
        verifyCurrencyNotSupportedError();
    }

    @Given("the user has attempted to select unsupported language and currency")
    public void theUserHasAttemptedToSelectUnsupportedLanguageAndCurrency() {
        attemptUnsupportedSelections();
    }

    @When("the user attempts to save the changes")
    public void theUserAttemptsToSaveTheChanges() {
        attemptToSaveChanges();
    }

    @Then("changes are not saved and error persists")
    public void changesAreNotSavedAndErrorPersists() {
        verifyChangesNotSaved();
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        refreshPage();
    }

    @Then("settings revert to last valid selection")
    public void settingsRevertToLastValidSelection() {
        verifySettingsReverted();
    }

    @When("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        navigateToHomePage();
    }

    @Then("the home page displays in previously set valid language and currency")
    public void theHomePageDisplaysInPreviouslySetValidLanguageAndCurrency() {
        verifyHomePageLanguageAndCurrency();
    }

    @When("the user checks product listings")
    public void theUserChecksProductListings() {
        checkProductListings();
    }

    @Then("product prices are displayed in last valid currency")
    public void productPricesAreDisplayedInLastValidCurrency() {
        verifyProductPricesCurrency();
    }

    @When("the user accesses the help section")
    public void theUserAccessesTheHelpSection() {
        accessHelpSection();
    }

    @Then("the help section is displayed in last valid language")
    public void theHelpSectionIsDisplayedInLastValidLanguage() {
        verifyHelpSectionLanguage();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("language and currency settings persist as last valid selection")
    public void languageAndCurrencySettingsPersistAsLastValidSelection() {
        verifySettingsPersist();
    }

    @When("the user attempts to select a combination of unsupported language and currency")
    public void theUserAttemptsToSelectACombinationOfUnsupportedLanguageAndCurrency() {
        selectUnsupportedCombination();
    }

    @Then("error messages for both selections are displayed")
    public void errorMessagesForBothSelectionsAreDisplayed() {
        verifyCombinationErrors();
    }

    @When("the user checks notifications")
    public void theUserChecksNotifications() {
        checkNotifications();
    }

    @Then("notifications remain in last valid language")
    public void notificationsRemainInLastValidLanguage() {
        verifyNotificationsLanguage();
    }

    @When("the user attempts to enter unsupported values manually")
    public void theUserAttemptsToEnterUnsupportedValuesManually() {
        enterUnsupportedValuesManually();
    }

    @Then("the system rejects unsupported values with error messages")
    public void theSystemRejectsUnsupportedValuesWithErrorMessages() {
        verifyManualEntryErrors();
    }

    @When("the user checks system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("errors are logged appropriately for unsupported selections")
    public void errorsAreLoggedAppropriatelyForUnsupportedSelections() {
        verifyErrorLogs();
    }
}