package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the shopping cart is empty")
    public void theShoppingCartIsEmpty() {
        openCart();
        verifyCartIsEmpty();
    }

    @When("the user attempts to remove a product not present in the cart")
    public void theUserAttemptsToRemoveAProductNotPresentInTheCart() {
        attemptToRemoveNonExistentProduct();
    }

    @Then("the cart should remain empty")
    public void theCartShouldRemainEmpty() {
        verifyCartIsEmpty();
    }

    @Then("a \"NoProduct in Cart\" message should be shown")
    public void aNoProductInCartMessageShouldBeShown() {
        verifyNoProductInCartMessage();
    }

    @Given("the shopping cart contains products")
    public void theShoppingCartContainsProducts() {
        addProductToCart();
        openCart();
        verifyCartIsNotEmpty();
    }

    @Given("the product to be removed is not in the cart")
    public void theProductToBeRemovedIsNotInTheCart() {
        verifyProductNotInCart("NonExistentProduct");
    }

    @When("the user attempts to remove the non-existent product")
    public void theUserAttemptsToRemoveTheNonExistentProduct() {
        attemptToRemoveNonExistentProduct();
    }

    @Then("the cart should remain unchanged with the existing products")
    public void theCartShouldRemainUnchangedWithTheExistingProducts() {
        verifyCartIsNotEmpty();
    }
}

