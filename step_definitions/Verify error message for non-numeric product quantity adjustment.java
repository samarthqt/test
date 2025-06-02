package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("a user is logged in")
    public void aUserIsLoggedIn() {
        loginUser();
    }

    @Given("a product is added to the cart")
    public void aProductIsAddedToTheCart() {
        addProductToCart();
    }

    @Given("multiple products are added to the cart")
    public void multipleProductsAreAddedToTheCart() {
        addMultipleProductsToCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutUser();
        loginUser();
    }

    @When("the user switches browser")
    public void theUserSwitchesBrowser() {
        switchBrowser();
    }

    @When("selects a product to adjust its quantity")
    public void selectsAProductToAdjustItsQuantity() {
        selectProductForQuantityAdjustment();
    }

    @When("selects different products to adjust their quantities")
    public void selectsDifferentProductsToAdjustTheirQuantities() {
        selectMultipleProductsForQuantityAdjustment();
    }

    @When("enters a non-numeric value {string} in the quantity field")
    public void entersANonNumericValueInTheQuantityField(String value) {
        enterNonNumericQuantity(value);
    }

    @When("enters a space ' ' in the quantity field")
    public void entersASpaceInTheQuantityField() {
        enterNonNumericQuantity(" ");
    }

    @When("attempts to save the changes")
    public void attemptsToSaveTheChanges() {
        saveQuantityChanges();
    }

    @When("refreshes the page")
    public void refreshesThePage() {
        refreshPage();
    }

    @Then("an error message indicating invalid quantity input is displayed")
    public void anErrorMessageIndicatingInvalidQuantityInputIsDisplayed() {
        verifyInvalidQuantityErrorMessage();
    }

    @Then("the system prevents saving and displays an error message")
    public void theSystemPreventsSavingAndDisplaysAnErrorMessage() {
        verifySavePreventionAndErrorMessage();
    }

    @Then("the cart should retain the original quantity before the invalid input was attempted")
    public void theCartShouldRetainTheOriginalQuantityBeforeTheInvalidInputWasAttempted() {
        verifyCartRetainsOriginalQuantity();
    }

    @Then("the error message should suggest entering a numeric value")
    public void theErrorMessageShouldSuggestEnteringANumericValue() {
        verifyErrorMessageGuidance();
    }

    @Then("consistent error message behavior should be observed across different products")
    public void consistentErrorMessageBehaviorShouldBeObservedAcrossDifferentProducts() {
        verifyConsistentErrorMessageAcrossProducts();
    }

    @Then("error message behavior remains consistent after relogging")
    public void errorMessageBehaviorRemainsConsistentAfterRelogging() {
        verifyErrorMessageConsistencyAfterRelogging();
    }

    @Then("error message should be consistent across different browsers")
    public void errorMessageShouldBeConsistentAcrossDifferentBrowsers() {
        verifyErrorMessageConsistencyAcrossBrowsers();
    }

    @Then("the cart should revert to original quantities and error messages should reset")
    public void theCartShouldRevertToOriginalQuantitiesAndErrorMessagesShouldReset() {
        verifyCartRevertsAndErrorMessagesReset();
    }

    @Then("no console errors should appear during the test execution")
    public void noConsoleErrorsShouldAppearDuringTheTestExecution() {
        verifyNoConsoleErrors();
    }
}