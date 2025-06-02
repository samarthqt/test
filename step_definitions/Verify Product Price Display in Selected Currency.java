package com.cucumber.steps;

import com.page_objects.CurrencySettingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CurrencySettingsSteps extends CurrencySettingsPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the user settings page")
    public void theUserNavigatesToTheUserSettingsPage() {
        navigateToUserSettingsPage();
    }

    @Then("the user settings page is displayed")
    public void theUserSettingsPageIsDisplayed() {
        verifyUserSettingsPageDisplayed();
    }

    @Then("the preferred currency is set to EUR")
    public void thePreferredCurrencyIsSetToEUR() {
        setPreferredCurrencyToEUR();
    }

    @Then("the currency selection feature is enabled")
    public void theCurrencySelectionFeatureIsEnabled() {
        enableCurrencySelectionFeature();
    }

    @Given("the currency selection dropdown is visible")
    public void theCurrencySelectionDropdownIsVisible() {
        verifyCurrencyDropdownVisible();
    }

    @When("the user selects 'EUR' from the currency dropdown")
    public void theUserSelectsEURFromTheCurrencyDropdown() {
        selectCurrencyEUR();
    }

    @Then("EUR is selected as the preferred currency")
    public void eurIsSelectedAsThePreferredCurrency() {
        verifyCurrencySelectedEUR();
    }

    @When("the user saves the changes made in the settings")
    public void theUserSavesTheChangesMadeInTheSettings() {
        saveSettingsChanges();
    }

    @Then("the settings are saved successfully")
    public void theSettingsAreSavedSuccessfully() {
        verifySettingsSavedSuccessfully();
    }

    @When("the user navigates to the product catalog page")
    public void theUserNavigatesToTheProductCatalogPage() {
        navigateToProductCatalogPage();
    }

    @Then("the product catalog is displayed")
    public void theProductCatalogIsDisplayed() {
        verifyProductCatalogDisplayed();
    }

    @Then("product prices are displayed in EUR")
    public void productPricesAreDisplayedInEUR() {
        verifyProductPricesInEUR();
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        addProductToCart();
    }

    @Then("the product is added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully() {
        verifyProductAddedToCartSuccessfully();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed")
    public void theCartPageIsDisplayed() {
        verifyCartPageDisplayed();
    }

    @Then("the product price in the cart is displayed in EUR")
    public void theProductPriceInTheCartIsDisplayedInEUR() {
        verifyProductPriceInCartInEUR();
    }

    @When("the user proceeds to the checkout page")
    public void theUserProceedsToTheCheckoutPage() {
        proceedToCheckoutPage();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Then("the total price in the checkout page is displayed in EUR")
    public void theTotalPriceInTheCheckoutPageIsDisplayedInEUR() {
        verifyTotalPriceInCheckoutInEUR();
    }

    @When("the user completes the purchase")
    public void theUserCompletesThePurchase() {
        completePurchase();
    }

    @Then("the purchase is completed successfully")
    public void thePurchaseIsCompletedSuccessfully() {
        verifyPurchaseCompletedSuccessfully();
    }

    @When("the user checks the order confirmation email")
    public void theUserChecksTheOrderConfirmationEmail() {
        checkOrderConfirmationEmail();
    }

    @Then("the order confirmation email displays prices in EUR")
    public void theOrderConfirmationEmailDisplaysPricesInEUR() {
        verifyOrderConfirmationEmailPricesInEUR();
    }

    @When("the user navigates to the order history page")
    public void theUserNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistoryPage();
    }

    @Then("the order history page is displayed")
    public void theOrderHistoryPageIsDisplayed() {
        verifyOrderHistoryPageDisplayed();
    }

    @Then("the currency in the order details is displayed as EUR")
    public void theCurrencyInTheOrderDetailsIsDisplayedAsEUR() {
        verifyCurrencyInOrderDetailsAsEUR();
    }
}