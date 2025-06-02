package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CurrencySettingsPage;

public class CurrencySettingsSteps extends CurrencySettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("the user logs in to the application")
    public void theUserLogsInToTheApplication() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Then("the user has access to currency settings")
    public void theUserHasAccessToCurrencySettings() {
        verifyAccessToCurrencySettings();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theUserIsOnTheLoginPage();
        theUserLogsInToTheApplication();
        theUserIsSuccessfullyLoggedIn();
    }

    @When("the user navigates to the currency settings page")
    public void theUserNavigatesToTheCurrencySettingsPage() {
        navigateToCurrencySettingsPage();
    }

    @Then("the currency settings page is displayed")
    public void theCurrencySettingsPageIsDisplayed() {
        verifyCurrencySettingsPageDisplayed();
    }

    @Given("the user is on the currency settings page")
    public void theUserIsOnTheCurrencySettingsPage() {
        theUserIsLoggedIn();
        theUserNavigatesToTheCurrencySettingsPage();
    }

    @When("the user selects a different currency from the default")
    public void theUserSelectsADifferentCurrencyFromTheDefault() {
        selectDifferentCurrency();
    }

    @Then("the currency selection is updated")
    public void theCurrencySelectionIsUpdated() {
        verifyCurrencySelectionUpdated();
    }

    @Given("the user has selected a different currency")
    public void theUserHasSelectedADifferentCurrency() {
        theUserIsOnTheCurrencySettingsPage();
        theUserSelectsADifferentCurrencyFromTheDefault();
    }

    @When("the application updates prices")
    public void theApplicationUpdatesPrices() {
        updatePrices();
    }

    @Then("prices are displayed in the selected currency")
    public void pricesAreDisplayedInTheSelectedCurrency() {
        verifyPricesInSelectedCurrency();
    }

    @When("the application displays product prices")
    public void theApplicationDisplaysProductPrices() {
        displayProductPrices();
    }

    @Then("all product prices are correctly converted")
    public void allProductPricesAreCorrectlyConverted() {
        verifyProductPricesConvertedCorrectly();
    }

    @When("the application displays currency symbols")
    public void theApplicationDisplaysCurrencySymbols() {
        displayCurrencySymbols();
    }

    @Then("currency symbols are displayed correctly")
    public void currencySymbolsAreDisplayedCorrectly() {
        verifyCurrencySymbolsDisplayedCorrectly();
    }

    @When("the user views transaction amounts")
    public void theUserViewsTransactionAmounts() {
        viewTransactionAmounts();
    }

    @Then("transaction amounts are in the selected currency")
    public void transactionAmountsAreInTheSelectedCurrency() {
        verifyTransactionAmountsInSelectedCurrency();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logout();
        theUserLogsInToTheApplication();
    }

    @Then("the selected currency persists after re-login")
    public void theSelectedCurrencyPersistsAfterReLogin() {
        verifyCurrencyPersistenceAfterReLogin();
    }

    @When("the user accesses the application on different devices")
    public void theUserAccessesTheApplicationOnDifferentDevices() {
        accessApplicationOnDifferentDevices();
    }

    @Then("currency settings are consistent across different devices")
    public void currencySettingsAreConsistentAcrossDifferentDevices() {
        verifyCurrencyConsistencyAcrossDevices();
    }

    @When("the user accesses the application on different browsers")
    public void theUserAccessesTheApplicationOnDifferentBrowsers() {
        accessApplicationOnDifferentBrowsers();
    }

    @Then("currency settings are consistent across different browsers")
    public void currencySettingsAreConsistentAcrossDifferentBrowsers() {
        verifyCurrencyConsistencyAcrossBrowsers();
    }

    @When("the user accesses the mobile app")
    public void theUserAccessesTheMobileApp() {
        accessMobileApp();
    }

    @Then("currency settings are accessible on the mobile app")
    public void currencySettingsAreAccessibleOnTheMobileApp() {
        verifyCurrencySettingsOnMobileApp();
    }

    @When("the application performs currency conversion")
    public void theApplicationPerformsCurrencyConversion() {
        performCurrencyConversion();
    }

    @Then("no discrepancies in currency conversion rates are found")
    public void noDiscrepanciesInCurrencyConversionRatesAreFound() {
        verifyNoDiscrepanciesInConversionRates();
    }

    @When("the user interacts with the application")
    public void theUserInteractsWithTheApplication() {
        interactWithApplication();
    }

    @Then("application performance remains unaffected by currency selection")
    public void applicationPerformanceRemainsUnaffectedByCurrencySelection() {
        verifyApplicationPerformanceUnaffected();
    }

    @When("the user switches back to the default currency")
    public void theUserSwitchesBackToTheDefaultCurrency() {
        switchBackToDefaultCurrency();
    }

    @Then("currency can be switched back to the default successfully")
    public void currencyCanBeSwitchedBackToTheDefaultSuccessfully() {
        verifySwitchBackToDefaultCurrency();
    }

    @Given("the user selects an unsupported currency")
    public void theUserSelectsAnUnsupportedCurrency() {
        selectUnsupportedCurrency();
    }

    @When("the application processes the currency selection")
    public void theApplicationProcessesTheCurrencySelection() {
        processCurrencySelection();
    }

    @Then("the system provides a fallback or notification for unsupported currencies")
    public void theSystemProvidesAFallbackOrNotificationForUnsupportedCurrencies() {
        verifyFallbackForUnsupportedCurrencies();
    }
}