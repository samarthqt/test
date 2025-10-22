package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.CartPage;

public class CartUpdateSteps extends CartPage {

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        openCart();
        verifyCartIsNotEmpty();
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        openCart();
    }

    @Then("the shopping cart page is displayed with items listed")
    public void theShoppingCartPageIsDisplayedWithItemsListed() {
        verifyCartIsNotEmpty();
    }

    @Given("the user is on the shopping cart page with Product ID {string}")
    public void theUserIsOnTheShoppingCartPageWithProductID(String productID) {
        openCart();
        verifyProductInCartByID(productID);
    }

    @When("the user updates the quantity of the product to {string}")
    public void theUserUpdatesTheQuantityOfTheProductTo(String newQuantity) {
        updateProductQuantity(newQuantity);
    }

    @Then("the cart page reflects the updated quantity and recalculated total price immediately")
    public void theCartPageReflectsTheUpdatedQuantityAndRecalculatedTotalPriceImmediately() {
        verifyUpdatedQuantityAndTotalPrice();
    }
}