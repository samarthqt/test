package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.CartPage;

public class AddToCartSteps extends CartPage {

    @Given("the user navigates to {string} product detail page")
    public void theUserNavigatesToProductDetailPage(String productName) {
        navigateToProductDetailPage(productName);
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        verifyProductDetailPage();
    }

    @When("the user selects the 'Add to Cart' button")
    public void theUserSelectsTheAddToCartButton() {
        addProductToCart();
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        verifyProductAddedToCart();
    }
}