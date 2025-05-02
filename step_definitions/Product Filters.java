package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductFiltersSteps extends SearchResultsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the search results page")
    public void theUserIsOnTheSearchResultsPage() {
        String searchResultsURL = testHarness.getData("SearchData", "SearchResultsPageURL");
        navigateToPage(searchResultsURL);
    }

    @When("the user selects a price range filter")
    public void theUserSelectsAPriceRangeFilter() {
        String priceRange = testHarness.getData("FilterData", "PriceRange");
        applyPriceFilter(priceRange);
    }

    @Then("the search results should only display products within the selected price range")
    public void theSearchResultsShouldOnlyDisplayProductsWithinTheSelectedPriceRange() {
        String expectedPriceRange = testHarness.getData("FilterData", "PriceRange");
        verifyProductsWithinPriceRange(expectedPriceRange);
    }

    @When("the user selects a rating filter")
    public void theUserSelectsARatingFilter() {
        String rating = testHarness.getData("FilterData", "Rating");
        applyRatingFilter(rating);
    }

    @Then("the search results should only display products with the selected rating or higher")
    public void theSearchResultsShouldOnlyDisplayProductsWithTheSelectedRatingOrHigher() {
        String expectedRating = testHarness.getData("FilterData", "Rating");
        verifyProductsWithRatingOrHigher(expectedRating);
    }

    @When("the user selects multiple filters such as price and rating")
    public void theUserSelectsMultipleFiltersSuchAsPriceAndRating() {
        String priceRange = testHarness.getData("FilterData", "PriceRange");
        String rating = testHarness.getData("FilterData", "Rating");
        applyMultipleFilters(priceRange, rating);
    }

    @Then("the search results should only display products that match all selected criteria")
    public void theSearchResultsShouldOnlyDisplayProductsThatMatchAllSelectedCriteria() {
        String expectedPriceRange = testHarness.getData("FilterData", "PriceRange");
        String expectedRating = testHarness.getData("FilterData", "Rating");
        verifyProductsMatchAllCriteria(expectedPriceRange, expectedRating);
    }

    @Given("the user has applied filters on the search results page")
    public void theUserHasAppliedFiltersOnTheSearchResultsPage() {
        String priceRange = testHarness.getData("FilterData", "PriceRange");
        String rating = testHarness.getData("FilterData", "Rating");
        applyMultipleFilters(priceRange, rating);
    }

    @When("the user clicks on the clear filters option")
    public void theUserClicksOnTheClearFiltersOption() {
        clearAllFilters();
    }

    @Then("all filters should be removed and the search results should display all products")
    public void allFiltersShouldBeRemovedAndTheSearchResultsShouldDisplayAllProducts() {
        verifyAllProductsDisplayed();
    }

    @Then("the user should see filter options for price, rating, and other criteria")
    public void theUserShouldSeeFilterOptionsForPriceRatingAndOtherCriteria() {
        verifyFilterOptionsVisible();
    }

    @When("the user selects a filter by a specific criterion \(e.g., brand, category\)")
    public void theUserSelectsAFilterByASpecificCriterion() {
        String criterion = testHarness.getData("FilterData", "Criterion");
        applySpecificCriterionFilter(criterion);
    }

    @Then("the search results should only display products that match the selected criterion")
    public void theSearchResultsShouldOnlyDisplayProductsThatMatchTheSelectedCriterion() {
        String expectedCriterion = testHarness.getData("FilterData", "Criterion");
        verifyProductsMatchCriterion(expectedCriterion);
    }
}