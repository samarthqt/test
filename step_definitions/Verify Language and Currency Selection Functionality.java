package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.UserSettingsPage;

public class LanguageCurrencySteps extends UserSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("User navigates to the user settings page")
    public void userNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Then("User settings page is displayed")
    public void userSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @Then("Language and currency selection feature is enabled")
    public void languageAndCurrencySelectionFeatureIsEnabled() {
        verifyLanguageCurrencyFeatureEnabled();
    }

    @When("User locates the language selection dropdown")
    public void userLocatesTheLanguageSelectionDropdown() {
        locateLanguageDropdown();
    }

    @Then("Language selection dropdown is visible")
    public void languageSelectionDropdownIsVisible() {
        verifyLanguageDropdownVisible();
    }

    @When("User selects 'English' from the language dropdown")
    public void userSelectsEnglishFromTheLanguageDropdown() {
        selectLanguage("English");
    }

    @Then("English is selected as the preferred language")
    public void englishIsSelectedAsThePreferredLanguage() {
        verifySelectedLanguage("English");
    }

    @When("User locates the currency selection dropdown")
    public void userLocatesTheCurrencySelectionDropdown() {
        locateCurrencyDropdown();
    }

    @Then("Currency selection dropdown is visible")
    public void currencySelectionDropdownIsVisible() {
        verifyCurrencyDropdownVisible();
    }

    @When("User selects 'USD' from the currency dropdown")
    public void userSelectsUSDFromTheCurrencyDropdown() {
        selectCurrency("USD");
    }

    @Then("USD is selected as the preferred currency")
    public void usdIsSelectedAsThePreferredCurrency() {
        verifySelectedCurrency("USD");
    }

    @When("User saves the changes made in the settings")
    public void userSavesTheChangesMadeInTheSettings() {
        saveSettingsChanges();
    }

    @Then("Settings are saved successfully")
    public void settingsAreSavedSuccessfully() {
        verifySettingsSavedSuccessfully();
    }

    @When("User refreshes the page or navigates to another page")
    public void userRefreshesThePageOrNavigatesToAnotherPage() {
        refreshOrNavigateToAnotherPage();
    }

    @Then("Selected language and currency persist after refresh")
    public void selectedLanguageAndCurrencyPersistAfterRefresh() {
        verifyLanguageCurrencyPersistAfterRefresh();
    }

    @When("User logs out and logs back into the application")
    public void userLogsOutAndLogsBackIntoTheApplication() {
        logoutAndLoginAgain();
    }

    @Then("Selected language and currency settings persist after re-login")
    public void selectedLanguageAndCurrencySettingsPersistAfterReLogin() {
        verifyLanguageCurrencyPersistAfterReLogin();
    }

    @When("User navigates to the product catalog page")
    public void userNavigatesToTheProductCatalogPage() {
        navigateToProductCatalogPage();
    }

    @Then("Product catalog is displayed in the selected language")
    public void productCatalogIsDisplayedInTheSelectedLanguage() {
        verifyProductCatalogLanguage();
    }

    @When("User checks the product prices on the catalog page")
    public void userChecksTheProductPricesOnTheCatalogPage() {
        checkProductPricesOnCatalogPage();
    }

    @Then("Product prices are displayed in the selected currency")
    public void productPricesAreDisplayedInTheSelectedCurrency() {
        verifyProductPricesCurrency();
    }

    @When("User navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("Checkout page is displayed in the selected language")
    public void checkoutPageIsDisplayedInTheSelectedLanguage() {
        verifyCheckoutPageLanguage();
    }

    @When("User verifies the currency displayed on the checkout page")
    public void userVerifiesTheCurrencyDisplayedOnTheCheckoutPage() {
        verifyCurrencyOnCheckoutPage();
    }

    @Then("Currency displayed on the checkout page matches the selected currency")
    public void currencyDisplayedOnTheCheckoutPageMatchesTheSelectedCurrency() {
        verifyCheckoutPageCurrency();
    }

    @When("User navigates to the user profile page")
    public void userNavigatesToTheUserProfilePage() {
        navigateToUserProfilePage();
    }

    @Then("User profile page is displayed in the selected language")
    public void userProfilePageIsDisplayedInTheSelectedLanguage() {
        verifyUserProfilePageLanguage();
    }

    @When("User verifies the currency settings in the user profile")
    public void userVerifiesTheCurrencySettingsInTheUserProfile() {
        verifyCurrencySettingsInUserProfile();
    }

    @Then("Currency settings in the user profile match the selected currency")
    public void currencySettingsInTheUserProfileMatchTheSelectedCurrency() {
        verifyUserProfileCurrencySettings();
    }

    @When("User performs a search for products")
    public void userPerformsASearchForProducts() {
        performProductSearch();
    }

    @Then("Search results are displayed in the selected language and currency")
    public void searchResultsAreDisplayedInTheSelectedLanguageAndCurrency() {
        verifySearchResultsLanguageCurrency();
    }
}