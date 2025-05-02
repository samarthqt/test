package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewCartSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the retail website")
    public void theUserIsLoggedIntoTheRetailWebsite() {
        loginToRetailWebsite();
    }

    @Given("the user has added products to the shopping cart")
    public void theUserHasAddedProductsToTheShoppingCart() {
        addProductsToCart();
    }

    @Given("the shopping cart is empty")
    public void theShoppingCartIsEmpty() {
        ensureCartIsEmpty();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToCartPage();
    }

    @Then("the user should see a list of all products in the shopping cart")
    public void theUserShouldSeeAListOfAllProductsInTheShoppingCart() {
        verifyProductsInCart();
    }

    @Then("the user should see the total price of all products in the cart")
    public void theUserShouldSeeTheTotalPriceOfAllProductsInTheCart() {
        verifyTotalPriceInCart();
    }

    @Then("the user should see an option to proceed to checkout")
    public void theUserShouldSeeAnOptionToProceedToCheckout() {
        verifyProceedToCheckoutOption();
    }

    @Then("the user should see a message indicating the cart is empty")
    public void theUserShouldSeeAMessageIndicatingTheCartIsEmpty() {
        verifyCartIsEmptyMessage();
    }

    @Then("the user should see an option to continue shopping")
    public void theUserShouldSeeAnOptionToContinueShopping() {
        verifyContinueShoppingOption();
    }

    @When("the user changes the quantity of a product in the cart")
    public void theUserChangesTheQuantityOfAProductInTheCart() {
        changeProductQuantityInCart();
    }

    @Then("the shopping cart should update to reflect the new quantity")
    public void theShoppingCartShouldUpdateToReflectTheNewQuantity() {
        verifyUpdatedQuantityInCart();
    }

    @Then("the total price should adjust accordingly")
    public void theTotalPriceShouldAdjustAccordingly() {
        verifyAdjustedTotalPrice();
    }

    @When("the user removes a product from the cart")
    public void theUserRemovesAProductFromTheCart() {
        removeProductFromCart();
    }

    @Then("the shopping cart should update to exclude the removed product")
    public void theShoppingCartShouldUpdateToExcludeTheRemovedProduct() {
        verifyProductRemovedFromCart();
    }

    @When("the user clicks on the proceed to checkout button")
    public void theUserClicksOnTheProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("the user should be redirected to the checkout page")
    public void theUserShouldBeRedirectedToTheCheckoutPage() {
        verifyRedirectionToCheckoutPage();
    }

    @Then("the cart details should be available on the checkout page")
    public void theCartDetailsShouldBeAvailableOnTheCheckoutPage() {
        verifyCartDetailsOnCheckoutPage();
    }
}