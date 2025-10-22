package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ProductDetailPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class ProductDetailSteps extends ProductDetailPage {

    @Given("the product {string} is available in the catalog")
    public void theProductIsAvailableInTheCatalog(String productName) {
        verifyProductInCatalog(productName);
    }

    @When("the user searches for {string} and selects the product from the results")
    public void theUserSearchesForAndSelectsTheProductFromTheResults(String productName) {
        searchAndSelectProduct(productName);
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        verifyProductDetailPageDisplayed();
    }

    @Then("the product image, description, stock status, and price are all displayed correctly")
    public void theProductDetailsAreDisplayedCorrectly() {
        verifyProductDetails();
    }
}