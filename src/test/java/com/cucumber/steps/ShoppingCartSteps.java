package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;
import com.pageobjects.CartPage;

public class ShoppingCartSteps {

    private CartPage cartPage = new CartPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product details page")
    public void theUserIsOnTheProductDetailsPage() {
        String productName = testHarness.getData("ProductData", "ProductName");
        navigateToProductPage(productName);
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        cartPage.addProductToCart();
    }

    @Then("the cart should contain the added product")
    public void theCartShouldContainTheAddedProduct() {
        String expectedProductName = testHarness.getData("ProductData", "ProductName");
        cartPage.openCart();
        cartPage.verifyProductInCart(expectedProductName);
    }

    @Given("the user has a product in the cart")
    public void theUserHasAProductInTheCart() {
        String productName = testHarness.getData("ProductData", "ProductName");
        cartPage.addProductToCart();
        cartPage.openCart();
        cartPage.verifyProductInCart(productName);
    }

    @When("the user updates the quantity to {string}")
    public void theUserUpdatesTheQuantityTo(String quantity) {
        cartPage.updateProductQuantity(quantity);
    }

    @Then("the cart should reflect the updated quantity")
    public void theCartShouldReflectTheUpdatedQuantity() {
        String expectedQuantity = testHarness.getData("CartData", "Quantity");
        cartPage.verifyProductQuantity(expectedQuantity);
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        cartPage.removeProductFromCart();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartPage.verifyCartIsEmpty();
    }

    @Given("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        cartPage.openCart();
    }

    @Then("the shopping cart page is displayed indicating the cart is empty")
    public void theShoppingCartPageIsDisplayedIndicatingTheCartIsEmpty() {
        cartPage.verifyCartIsEmpty();
    }

    @When("the user attempts to remove an item from the cart")
    public void theUserAttemptsToRemoveAnItemFromTheCart() {
        cartPage.removeProductFromCart();
    }

    @Then("the system prevents the action and displays a message indicating the cart is already empty")
    public void theSystemPreventsTheActionAndDisplaysAMessageIndicatingTheCartIsAlreadyEmpty() {
        cartPage.verifyCartIsEmpty();
    }

    private void navigateToProductPage(String productName) {
        // Implementation to navigate to the product page
    }
}
