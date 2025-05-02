package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product page")
    public void theUserIsOnTheProductPage() {
        String productURL = testHarness.getData("CartData", "ProductPageURL");
        navigateToPage(productURL);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        addProductToCart();
    }

    @Then("the product should be added to the shopping cart")
    public void theProductShouldBeAddedToTheShoppingCart() {
        openCart();
        verifyProductInCart(testHarness.getData("CartData", "ProductName"));
    }

    @Then("the shopping cart icon should display the updated number of items")
    public void theShoppingCartIconShouldDisplayTheUpdatedNumberOfItems() {
        verifyCartItemCount(testHarness.getData("CartData", "ExpectedItemCount"));
    }

    @Given("the user has added products to the shopping cart")
    public void theUserHasAddedProductsToTheShoppingCart() {
        addProductToCart();
        openCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the user should see a list of all products added to the cart")
    public void theUserShouldSeeAListOfAllProductsAddedToTheCart() {
        verifyCartContainsProducts();
    }

    @Then("each product should display its name, quantity, price, and total cost")
    public void eachProductShouldDisplayItsNameQuantityPriceAndTotalCost() {
        verifyProductDetailsInCart();
    }

    @Given("the user is on the shopping cart page")
    public void theUserIsOnTheShoppingCartPage() {
        openCart();
    }

    @Given("the shopping cart contains products")
    public void theShoppingCartContainsProducts() {
        verifyCartContainsProducts();
    }

    @When("the user changes the quantity of a product")
    public void theUserChangesTheQuantityOfAProduct() {
        updateProductQuantity(testHarness.getData("CartData", "NewQuantity"));
    }

    @When("clicks on the {string} button")
    public void clicksOnTheButton(String buttonName) {
        clickUpdateCartButton();
    }

    @Then("the product quantity should be updated in the shopping cart")
    public void theProductQuantityShouldBeUpdatedInTheShoppingCart() {
        verifyProductQuantity(testHarness.getData("CartData", "NewQuantity"));
    }

    @Then("the total cost should be recalculated and displayed")
    public void theTotalCostShouldBeRecalculatedAndDisplayed() {
        verifyTotalCostUpdated();
    }

    @When("the user clicks on the {string} button next to a product")
    public void theUserClicksOnTheButtonNextToAProduct(String buttonName) {
        removeProductFromCart();
    }

    @Then("the product should be removed from the shopping cart")
    public void theProductShouldBeRemovedFromTheShoppingCart() {
        verifyProductRemovedFromCart(testHarness.getData("CartData", "ProductName"));
    }

    @Then("the shopping cart should update to reflect the removal")
    public void theShoppingCartShouldUpdateToReflectTheRemoval() {
        verifyCartUpdatedAfterRemoval();
    }

    @Given("the user has removed all products from the shopping cart")
    public void theUserHasRemovedAllProductsFromTheShoppingCart() {
        removeAllProductsFromCart();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the user should see a message indicating the cart is empty")
    public void theUserShouldSeeAMessageIndicatingTheCartIsEmpty() {
        verifyCartIsEmpty();
    }

    @Then("no products should be displayed in the shopping cart")
    public void noProductsShouldBeDisplayedInTheShoppingCart() {
        verifyNoProductsInCart();
    }
}