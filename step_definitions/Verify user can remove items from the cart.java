package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToCartPage();
    }

    @Given("the shopping cart page is displayed with current products")
    public void theShoppingCartPageIsDisplayedWithCurrentProducts() {
        verifyCartPageDisplayed();
    }

    @Given("at least one product is added to the cart")
    public void atLeastOneProductIsAddedToTheCart() {
        verifyProductInCart();
    }

    @When("the user locates the product to be removed from the cart")
    public void theUserLocatesTheProductToBeRemovedFromTheCart() {
        locateProductInCart();
    }

    @When("clicks the 'Remove' button next to the product")
    public void clicksTheRemoveButtonNextToTheProduct() {
        removeProductFromCart();
    }

    @Then("the product is removed from the cart")
    public void theProductIsRemovedFromTheCart() {
        verifyProductRemoved();
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessage();
    }

    @Then("the total price is recalculated after product removal")
    public void theTotalPriceIsRecalculatedAfterProductRemoval() {
        verifyTotalPriceRecalculated();
    }

    @Then("the cart updates immediately and accurately reflects current items")
    public void theCartUpdatesImmediatelyAndAccuratelyReflectsCurrentItems() {
        verifyCartUpdates();
    }

    @When("the user attempts to remove a product multiple times")
    public void theUserAttemptsToRemoveAProductMultipleTimes() {
        attemptMultipleRemovals();
    }

    @Then("the system prevents multiple removals")
    public void theSystemPreventsMultipleRemovals() {
        verifyMultipleRemovalsPrevented();
    }

    @Then("maintains cart integrity")
    public void maintainsCartIntegrity() {
        verifyCartIntegrity();
    }

    @Given("multiple products are added to the cart")
    public void multipleProductsAreAddedToTheCart() {
        verifyMultipleProductsInCart();
    }

    @When("the user removes all products from the cart")
    public void theUserRemovesAllProductsFromTheCart() {
        removeAllProductsFromCart();
    }

    @Then("the cart is empty")
    public void theCartIsEmpty() {
        verifyCartIsEmpty();
    }

    @Then("a message indicates no items in the cart")
    public void aMessageIndicatesNoItemsInTheCart() {
        verifyNoItemsMessage();
    }

    @When("the user removes products from the cart")
    public void theUserRemovesProductsFromTheCart() {
        removeProductsFromCart();
    }

    @When("logs out and logs back in")
    public void logsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the cart remains empty after re-login")
    public void theCartRemainsEmptyAfterReLogin() {
        verifyCartEmptyAfterReLogin();
    }

    @When("the user removes one product from the cart")
    public void theUserRemovesOneProductFromTheCart() {
        removeOneProductFromCart();
    }

    @Then("only the selected product is removed")
    public void onlyTheSelectedProductIsRemoved() {
        verifyOnlySelectedProductRemoved();
    }

    @Then("others remain in the cart")
    public void othersRemainInTheCart() {
        verifyOtherProductsRemain();
    }

    @Then("the cart icon displays the correct number of items")
    public void theCartIconDisplaysTheCorrectNumberOfItems() {
        verifyCartIconItemCount();
    }

    @Given("the user is not logged into the application")
    public void theUserIsNotLoggedIntoTheApplication() {
        verifyUserNotLoggedIn();
    }

    @When("the user tries to remove a product from the cart")
    public void theUserTriesToRemoveAProductFromTheCart() {
        tryRemoveProductNotLoggedIn();
    }

    @Then("the user is prompted to log in before removing products from the cart")
    public void theUserIsPromptedToLogInBeforeRemovingProductsFromTheCart() {
        verifyLoginPrompt();
    }

    @Given("a product with a special promotion is added to the cart")
    public void aProductWithASpecialPromotionIsAddedToTheCart() {
        verifyPromotionalProductInCart();
    }

    @When("the user removes the promotional product from the cart")
    public void theUserRemovesThePromotionalProductFromTheCart() {
        removePromotionalProduct();
    }

    @Then("the promotional product is removed successfully")
    public void thePromotionalProductIsRemovedSuccessfully() {
        verifyPromotionalProductRemoved();
    }

    @Then("promotions are recalculated")
    public void promotionsAreRecalculated() {
        verifyPromotionsRecalculated();
    }

    @Given("bundled products are added to the cart")
    public void bundledProductsAreAddedToTheCart() {
        verifyBundledProductsInCart();
    }

    @When("the user removes a bundled product from the cart")
    public void theUserRemovesABundledProductFromTheCart() {
        removeBundledProduct();
    }

    @Then("the system permits removal of bundled products")
    public void theSystemPermitsRemovalOfBundledProducts() {
        verifyBundledProductRemoval();
    }

    @When("the user removes a product from the cart")
    public void theUserRemovesAProductFromTheCart() {
        removeProductFromCart();
    }

    @When("undoes the removal")
    public void undoesTheRemoval() {
        undoProductRemoval();
    }

    @Then("the product is restored to the cart")
    public void theProductIsRestoredToTheCart() {
        verifyProductRestored();
    }

    @Then("the system logs the removal action for auditing purposes")
    public void theSystemLogsTheRemovalActionForAuditingPurposes() {
        verifyRemovalLogged();
    }
}