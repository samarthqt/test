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

    @When("the user navigates to the product page using the product ID {string}")
    public void theUserNavigatesToTheProductPageUsingTheProductID(String productId) {
        navigateToProductPageById(productId);
    }

    @Then("the product page is displayed with product details")
    public void theProductPageIsDisplayedWithProductDetails() {
        verifyProductPageDisplayed();
    }

    @Then("the product must be available in stock")
    public void theProductMustBeAvailableInStock() {
        verifyProductInStock();
    }

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        navigateToProductPage();
    }

    @Then("the 'Add to Cart' button is visible and enabled")
    public void theAddToCartButtonIsVisibleAndEnabled() {
        verifyAddToCartButtonVisibleAndEnabled();
    }

    @When("the user clicks on the 'Add to Cart' button")
    public void theUserClicksOnTheAddToCartButton() {
        clickAddToCartButton();
    }

    @Then("the product is added to the shopping cart")
    public void theProductIsAddedToTheShoppingCart() {
        verifyProductAddedToCart();
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the product is added to the shopping cart")
    public void theProductIsAddedToTheShoppingCart() {
        addProductToCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @Then("the shopping cart page displays the added product with correct details")
    public void theShoppingCartPageDisplaysTheAddedProductWithCorrectDetails() {
        verifyProductDetailsInCart();
    }

    @Given("the product is in the shopping cart")
    public void theProductIsInTheShoppingCart() {
        verifyProductInCart();
    }

    @Then("the product name, price, and quantity are displayed correctly")
    public void theProductNamePriceAndQuantityAreDisplayedCorrectly() {
        verifyProductDetailsCorrect();
    }

    @Then("the product details match the selected product")
    public void theProductDetailsMatchTheSelectedProduct() {
        verifyProductDetailsMatch();
    }

    @Then("the total price is calculated correctly based on the product price and quantity")
    public void theTotalPriceIsCalculatedCorrectlyBasedOnTheProductPriceAndQuantity() {
        verifyTotalPriceCalculation();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("the product remains in the cart after re-login")
    public void theProductRemainsInTheCartAfterReLogin() {
        verifyProductInCartAfterReLogin();
    }

    @When("the user attempts to add the same product multiple times")
    public void theUserAttemptsToAddTheSameProductMultipleTimes() {
        addSameProductMultipleTimes();
    }

    @Then("the product quantity in the cart increases accordingly")
    public void theProductQuantityInTheCartIncreasesAccordingly() {
        verifyProductQuantityIncreases();
    }

    @Given("the user is on a different product page")
    public void theUserIsOnADifferentProductPage() {
        navigateToDifferentProductPage();
    }

    @When("the user adds another product to the cart")
    public void theUserAddsAnotherProductToTheCart() {
        addAnotherProductToCart();
    }

    @Then("both products are present in the cart with correct details")
    public void bothProductsArePresentInTheCartWithCorrectDetails() {
        verifyBothProductsInCart();
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the product is successfully removed from the cart")
    public void theProductIsSuccessfullyRemovedFromTheCart() {
        verifyProductRemovedFromCart();
    }

    @Given("the product is removed from the shopping cart")
    public void theProductIsRemovedFromTheShoppingCart() {
        removeProductFromCart();
    }

    @Then("the cart is empty and displays a message indicating no items")
    public void theCartIsEmptyAndDisplaysAMessageIndicatingNoItems() {
        verifyCartIsEmpty();
    }

    @Given("the user is on the shopping cart page")
    public void theUserIsOnTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @When("a product is added or removed")
    public void aProductIsAddedOrRemoved() {
        addOrRemoveProduct();
    }

    @Then("the cart updates in real-time with accurate product details")
    public void theCartUpdatesInRealTimeWithAccurateProductDetails() {
        verifyRealTimeCartUpdates();
    }

    @Given("the user is not logged into the application")
    public void theUserIsNotLoggedIntoTheApplication() {
        ensureUserNotLoggedIn();
    }

    @When("the user attempts to add a product to the cart")
    public void theUserAttemptsToAddAProductToTheCart() {
        attemptToAddProductWithoutLogin();
    }

    @Then("the user is prompted to log in before adding products to the cart")
    public void theUserIsPromptedToLogInBeforeAddingProductsToTheCart() {
        verifyLoginPromptDisplayed();
    }

    @Given("the user is on the product page with a discount applied")
    public void theUserIsOnTheProductPageWithADiscountApplied() {
        navigateToDiscountedProductPage();
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        addProductToCart();
    }

    @Then("the discounted price is reflected correctly in the cart")
    public void theDiscountedPriceIsReflectedCorrectlyInTheCart() {
        verifyDiscountedPriceInCart();
    }

    @Given("products are added to the shopping cart")
    public void productsAreAddedToTheShoppingCart() {
        addProductsToCart();
    }

    @Then("the cart icon displays the correct number of items")
    public void theCartIconDisplaysTheCorrectNumberOfItems() {
        verifyCartIconItemCount();
    }
}