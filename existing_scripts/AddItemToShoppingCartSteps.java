package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemToShoppingCartSteps extends AddItemToShoppingCartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the web application")
    public void theUserIsLoggedIntoTheWebApplication() {
        loginUser();
    }

    @Given("the user navigates to the product page of the item with ID {string}")
    public void theUserNavigatesToTheProductPageOfTheItemWithID(String productID) {
        navigateToProductPage(productID);
    }

    @When("the user selects the 'Add to Cart' option")
    public void theUserSelectsTheAddToCartOption() {
        selectAddToCart();
    }

    @Then("the item is added to the shopping cart")
    public void theItemIsAddedToTheShoppingCart() {
        verifyItemAddedToCart();
    }

    @Then("the item with ID {string} appears in the shopping cart with correct details")
    public void theItemWithIDAppearsInTheShoppingCartWithCorrectDetails(String productID) {
        verifyItemDetailsInCart(productID);
    }
}
