package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceDiscountSteps extends PriceDiscountPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a product has an original price")
    public void aProductHasAnOriginalPrice() {
        String productName = testHarness.getData("ProductData", "ProductName");
        navigateToProductPage(productName);
    }

    @Given("the product has a discount applied")
    public void theProductHasADiscountApplied() {
        applyDiscountToProduct();
    }

    @Given("no discount is applied to the product")
    public void noDiscountIsAppliedToTheProduct() {
        ensureNoDiscountOnProduct();
    }

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginUser();
    }

    @Given("the user is not logged into an account")
    public void theUserIsNotLoggedIntoAnAccount() {
        logoutUser();
    }

    @When("the product is displayed on the retail platform")
    public void theProductIsDisplayedOnTheRetailPlatform() {
        displayProductOnPlatform();
    }

    @Then("the original price should be displayed")
    public void theOriginalPriceShouldBeDisplayed() {
        verifyOriginalPriceDisplayed();
    }

    @Then("the discounted price should be displayed alongside the original price")
    public void theDiscountedPriceShouldBeDisplayedAlongsideTheOriginalPrice() {
        verifyDiscountedPriceDisplayed();
    }

    @Then("the savings should be highlighted to the customer")
    public void theSavingsShouldBeHighlightedToTheCustomer() {
        verifySavingsHighlighted();
    }

    @Then("only the original price should be displayed")
    public void onlyTheOriginalPriceShouldBeDisplayed() {
        verifyOnlyOriginalPriceDisplayed();
    }

    @Then("no discounted price should be shown")
    public void noDiscountedPriceShouldBeShown() {
        verifyNoDiscountedPriceDisplayed();
    }

    @Then("the original price and discounted price should be displayed in USD")
    public void theOriginalPriceAndDiscountedPriceShouldBeDisplayedInUSD() {
        verifyPricesDisplayedInUSD();
    }
}