package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSortingSteps extends ProductSortingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a list of products displayed on the website")
    public void aListOfProductsDisplayedOnTheWebsite() {
        navigateToProductListPage();
    }

    @When("the user selects the option to sort by price in ascending order")
    public void theUserSelectsTheOptionToSortByPriceInAscendingOrder() {
        sortByPriceAscending();
    }

    @Then("the products should be displayed in ascending order of their prices")
    public void theProductsShouldBeDisplayedInAscendingOrderOfTheirPrices() {
        verifyProductsSortedByPriceAscending();
    }

    @When("the user selects the option to sort by price in descending order")
    public void theUserSelectsTheOptionToSortByPriceInDescendingOrder() {
        sortByPriceDescending();
    }

    @Then("the products should be displayed in descending order of their prices")
    public void theProductsShouldBeDisplayedInDescendingOrderOfTheirPrices() {
        verifyProductsSortedByPriceDescending();
    }

    @When("the user selects the option to sort by popularity")
    public void theUserSelectsTheOptionToSortByPopularity() {
        sortByPopularity();
    }

    @Then("the products should be displayed in order of their popularity")
    public void theProductsShouldBeDisplayedInOrderOfTheirPopularity() {
        verifyProductsSortedByPopularity();
    }

    @When("the user selects the option to sort by rating in ascending order")
    public void theUserSelectsTheOptionToSortByRatingInAscendingOrder() {
        sortByRatingAscending();
    }

    @Then("the products should be displayed in ascending order of their ratings")
    public void theProductsShouldBeDisplayedInAscendingOrderOfTheirRatings() {
        verifyProductsSortedByRatingAscending();
    }

    @When("the user selects the option to sort by rating in descending order")
    public void theUserSelectsTheOptionToSortByRatingInDescendingOrder() {
        sortByRatingDescending();
    }

    @Then("the products should be displayed in descending order of their ratings")
    public void theProductsShouldBeDisplayedInDescendingOrderOfTheirRatings() {
        verifyProductsSortedByRatingDescending();
    }

    @When("the user does not select any sorting option")
    public void theUserDoesNotSelectAnySortingOption() {
        // No action needed
    }

    @Then("the products should be displayed in the default sorting order")
    public void theProductsShouldBeDisplayedInTheDefaultSortingOrder() {
        verifyDefaultSortingOrder();
    }

    @When("the user views the sorting options")
    public void theUserViewsTheSortingOptions() {
        viewSortingOptions();
    }

    @Then("the options to sort by price, popularity, and rating should be available")
    public void theOptionsToSortByPricePopularityAndRatingShouldBeAvailable() {
        verifySortingOptionsAvailability();
    }
}