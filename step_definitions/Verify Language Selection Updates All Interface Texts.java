package com.cucumber.steps;

import com.page_objects.LanguageSettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageSettingsSteps extends LanguageSettingsPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettings();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @And("the language selection feature is enabled")
    public void theLanguageSelectionFeatureIsEnabled() {
        verifyLanguageSelectionEnabled();
    }

    @When("the user locates the language selection dropdown")
    public void theUserLocatesTheLanguageSelectionDropdown() {
        locateLanguageDropdown();
    }

    @Then("the language selection dropdown is visible")
    public void theLanguageSelectionDropdownIsVisible() {
        verifyLanguageDropdownVisible();
    }

    @When("the user selects 'Spanish' from the language dropdown")
    public void theUserSelectsSpanishFromTheLanguageDropdown() {
        selectLanguage("Spanish");
    }

    @Then("Spanish is selected as the preferred language")
    public void spanishIsSelectedAsThePreferredLanguage() {
        verifyLanguageSelected("Spanish");
    }

    @When("the user saves the changes made in the settings")
    public void theUserSavesTheChangesMadeInTheSettings() {
        saveSettingsChanges();
    }

    @Then("settings are saved successfully")
    public void settingsAreSavedSuccessfully() {
        verifySettingsSaved();
    }

    @When("the user refreshes the page or navigates to another page")
    public void theUserRefreshesThePageOrNavigatesToAnotherPage() {
        refreshOrNavigate();
    }

    @Then("interface text is updated to Spanish")
    public void interfaceTextIsUpdatedToSpanish() {
        verifyInterfaceTextUpdated("Spanish");
    }

    @When("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        navigateToHomePage();
    }

    @Then("the home page is displayed in Spanish")
    public void theHomePageIsDisplayedInSpanish() {
        verifyHomePageDisplayedInSpanish();
    }

    @When("the user navigates to the product catalog page")
    public void theUserNavigatesToTheProductCatalogPage() {
        navigateToProductCatalogPage();
    }

    @Then("the product catalog is displayed in Spanish")
    public void theProductCatalogIsDisplayedInSpanish() {
        verifyProductCatalogDisplayedInSpanish();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed in Spanish")
    public void theCartPageIsDisplayedInSpanish() {
        verifyCartPageDisplayedInSpanish();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed in Spanish")
    public void theCheckoutPageIsDisplayedInSpanish() {
        verifyCheckoutPageDisplayedInSpanish();
    }

    @When("the user navigates to the user profile page")
    public void theUserNavigatesToTheUserProfilePage() {
        navigateToUserProfilePage();
    }

    @Then("the user profile page is displayed in Spanish")
    public void theUserProfilePageIsDisplayedInSpanish() {
        verifyUserProfilePageDisplayedInSpanish();
    }

    @When("the user navigates to the order history page")
    public void theUserNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistoryPage();
    }

    @Then("the order history page is displayed in Spanish")
    public void theOrderHistoryPageIsDisplayedInSpanish() {
        verifyOrderHistoryPageDisplayedInSpanish();
    }

    @When("the user performs a product search")
    public void theUserPerformsAProductSearch() {
        performProductSearch();
    }

    @Then("search results are displayed in Spanish")
    public void searchResultsAreDisplayedInSpanish() {
        verifySearchResultsDisplayedInSpanish();
    }

    @When("the user checks the help section")
    public void theUserChecksTheHelpSection() {
        checkHelpSection();
    }

    @Then("the help section is displayed in Spanish")
    public void theHelpSectionIsDisplayedInSpanish() {
        verifyHelpSectionDisplayedInSpanish();
    }

    @When("the user logs out and logs back into the application")
    public void theUserLogsOutAndLogsBackIntoTheApplication() {
        logoutAndLogin();
    }

    @Then("the login page and subsequent pages are displayed in Spanish")
    public void theLoginPageAndSubsequentPagesAreDisplayedInSpanish() {
        verifyLoginPageAndSubsequentPagesDisplayedInSpanish();
    }

    @When("the user verifies any error messages displayed")
    public void theUserVerifiesAnyErrorMessagesDisplayed() {
        verifyErrorMessages();
    }

    @Then("error messages are displayed in Spanish")
    public void errorMessagesAreDisplayedInSpanish() {
        verifyErrorMessagesDisplayedInSpanish();
    }
}