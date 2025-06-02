package com.cucumber.steps;

import com.page_objects.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps extends CartPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("at least one product is added to the cart")
    public void atLeastOneProductIsAddedToTheCart() {
        addProductToCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed with current products")
    public void theShoppingCartPageIsDisplayedWithCurrentProducts() {
        verifyCartPageDisplayed();
    }

    @Given("the product with Product ID: {int} is visible in the cart")
    public void theProductWithProductIDIsVisibleInTheCart(int productId) {
        verifyProductInCart(productId);
    }

    @When("the user enters a new quantity in the quantity field")
    public void theUserEntersANewQuantityInTheQuantityField() {
        enterNewQuantity();
    }

    @Then("the quantity field accepts the new value")
    public void theQuantityFieldAcceptsTheNewValue() {
        verifyQuantityFieldAcceptsValue();
    }

    @Given("the user has entered a new quantity")
    public void theUserHasEnteredANewQuantity() {
        enterNewQuantity();
    }

    @When("the user clicks the 'Update' button")
    public void theUserClicksTheUpdateButton() {
        clickUpdateButton();
    }

    @Then("the product quantity is updated in the cart")
    public void theProductQuantityIsUpdatedInTheCart() {
        verifyProductQuantityUpdated();
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the product quantity is updated")
    public void theProductQuantityIsUpdated() {
        verifyProductQuantityUpdated();
    }

    @When("the user checks the total price")
    public void theUserChecksTheTotalPrice() {
        checkTotalPrice();
    }

    @Then("the total price reflects the new quantity")
    public void theTotalPriceReflectsTheNewQuantity() {
        verifyTotalPriceReflectsQuantity();
    }

    @Given("the user attempts to set the quantity to zero")
    public void theUserAttemptsToSetTheQuantityToZero() {
        attemptToSetQuantityToZero();
    }

    @Then("the system prevents setting quantity to zero")
    public void theSystemPreventsSettingQuantityToZero() {
        verifySystemPreventsZeroQuantity();
    }

    @Then("displays an error message")
    public void displaysAnErrorMessage() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user enters a non-numeric value in the quantity field")
    public void theUserEntersANonNumericValueInTheQuantityField() {
        enterNonNumericValue();
    }

    @Then("the system displays an error message indicating invalid input")
    public void theSystemDisplaysAnErrorMessageIndicatingInvalidInput() {
        verifyInvalidInputErrorMessage();
    }

    @Given("the user increases the quantity to a number greater than available stock")
    public void theUserIncreasesTheQuantityToANumberGreaterThanAvailableStock() {
        increaseQuantityBeyondStock();
    }

    @Then("the system displays a warning about insufficient stock")
    public void theSystemDisplaysAWarningAboutInsufficientStock() {
        verifyInsufficientStockWarning();
    }

    @Given("the user decreases the quantity to a lower number")
    public void theUserDecreasesTheQuantityToALowerNumber() {
        decreaseQuantity();
    }

    @Then("the quantity is updated successfully")
    public void theQuantityIsUpdatedSuccessfully() {
        verifyQuantityUpdatedSuccessfully();
    }

    @Then("the total price is recalculated")
    public void theTotalPriceIsRecalculated() {
        verifyTotalPriceRecalculated();
    }

    @Given("the user changes the quantity")
    public void theUserChangesTheQuantity() {
        changeQuantity();
    }

    @Then("the cart reflects the updated quantity immediately")
    public void theCartReflectsTheUpdatedQuantityImmediately() {
        verifyCartReflectsUpdatedQuantity();
    }

    @Given("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the cart retains updated quantities after re-login")
    public void theCartRetainsUpdatedQuantitiesAfterReLogin() {
        verifyCartPersistenceAfterReLogin();
    }

    @Given("the user adds a new product to the cart")
    public void theUserAddsANewProductToTheCart() {
        addNewProductToCart();
    }

    @When("the user adjusts its quantity")
    public void theUserAdjustsItsQuantity() {
        adjustNewProductQuantity();
    }

    @Then("the new product quantity can be adjusted successfully")
    public void theNewProductQuantityCanBeAdjustedSuccessfully() {
        verifyNewProductQuantityAdjusted();
    }

    @Given("the user attempts to adjust quantity for a product with a special promotion")
    public void theUserAttemptsToAdjustQuantityForAProductWithASpecialPromotion() {
        attemptToAdjustPromotionalProductQuantity();
    }

    @Then("quantity adjustment works correctly with promotional products")
    public void quantityAdjustmentWorksCorrectlyWithPromotionalProducts() {
        verifyPromotionalProductQuantityAdjustment();
    }

    @Given("the user changes the quantity of items in the cart")
    public void theUserChangesTheQuantityOfItemsInTheCart() {
        changeItemQuantityInCart();
    }

    @Then("the cart icon displays the correct number of items")
    public void theCartIconDisplaysTheCorrectNumberOfItems() {
        verifyCartIconItemCount();
    }

    @Given("the user checks the system for quantity adjustment for bundled products")
    public void theUserChecksTheSystemForQuantityAdjustmentForBundledProducts() {
        checkBundledProductQuantityAdjustment();
    }

    @Then("the system permits quantity adjustment for bundled products")
    public void theSystemPermitsQuantityAdjustmentForBundledProducts() {
        verifyBundledProductQuantityAdjustment();
    }
}