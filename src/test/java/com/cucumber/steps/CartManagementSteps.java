package com.cucumber.steps;

import com.pageobjects.CartPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartManagementSteps {

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
}
