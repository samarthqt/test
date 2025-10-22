package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.CartPage;

public class CartManagementSteps extends CartPage {

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

    @When("the user selects the 'Remove' option next to the product")
    public void theUserSelectsTheRemoveOptionNextToTheProduct() {
        removeProductFromCart();
    }

    @Then("the product is removed from the shopping cart")
    public void theProductIsRemovedFromTheShoppingCart() {
        verifyCartIsEmpty();
    }

    @Then("the shopping cart no longer displays the removed item")
    public void theShoppingCartNoLongerDisplaysTheRemovedItem() {
        verifyCartIsEmpty();
    }
}