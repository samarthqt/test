package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductCatalogPage;

public class ProductCatalogSteps extends ProductCatalogPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the product catalog page")
    public void theUserIsOnTheProductCatalogPage() {
        navigateToProductCatalog();
    }

    @When("the user searches for a product by keyword {string}")
    public void theUserSearchesForAProductByKeyword(String keyword) {
        searchProductByKeyword(keyword);
    }

    @Then("the search results should display products related to {string}")
    public void theSearchResultsShouldDisplayProductsRelatedTo(String keyword) {
        verifySearchResults(keyword);
    }

    @Then("the search results should be accurate and relevant")
    public void theSearchResultsShouldBeAccurateAndRelevant() {
        verifySearchAccuracyAndRelevance();
    }

    @When("the user filters products by category {string}")
    public void theUserFiltersProductsByCategory(String category) {
        filterProductsByCategory(category);
    }

    @Then("only products in the {string} category should be displayed")
    public void onlyProductsInTheCategoryShouldBeDisplayed(String category) {
        verifyCategoryFilterResults(category);
    }

    @When("the user filters products by price range {string}")
    public void theUserFiltersProductsByPriceRange(String priceRange) {
        filterProductsByPriceRange(priceRange);
    }

    @Then("only products within the price range {string} should be displayed")
    public void onlyProductsWithinThePriceRangeShouldBeDisplayed(String priceRange) {
        verifyPriceRangeFilterResults(priceRange);
    }

    @When("the user filters products by rating {string}")
    public void theUserFiltersProductsByRating(String rating) {
        filterProductsByRating(rating);
    }

    @Then("only products with a rating of {string} should be displayed")
    public void onlyProductsWithARatingOfShouldBeDisplayed(String rating) {
        verifyRatingFilterResults(rating);
    }

    @Given("the user has searched for products")
    public void theUserHasSearchedForProducts() {
        performSearch();
    }

    @When("the user sorts the products by price")
    public void theUserSortsTheProductsByPrice() {
        sortProductsByPrice();
    }

    @Then("the products should be displayed in ascending order of price")
    public void theProductsShouldBeDisplayedInAscendingOrderOfPrice() {
        verifyPriceSortOrder();
    }

    @When("the user sorts the products by popularity")
    public void theUserSortsTheProductsByPopularity() {
        sortProductsByPopularity();
    }

    @Then("the products should be displayed in order of popularity")
    public void theProductsShouldBeDisplayedInOrderOfPopularity() {
        verifyPopularitySortOrder();
    }

    @When("the user sorts the products by newest arrivals")
    public void theUserSortsTheProductsByNewestArrivals() {
        sortProductsByNewestArrivals();
    }

    @Then("the products should be displayed with the newest arrivals first")
    public void theProductsShouldBeDisplayedWithTheNewestArrivalsFirst() {
        verifyNewestArrivalsSortOrder();
    }

    @When("the user selects a product")
    public void theUserSelectsAProduct() {
        selectProduct();
    }

    @Then("the user should see detailed information including name, description, price, image, stock, and category")
    public void theUserShouldSeeDetailedInformationIncludingNameDescriptionPriceImageStockAndCategory() {
        verifyProductDetails();
    }

    @When("the user enters an invalid search query {string}")
    public void theUserEntersAnInvalidSearchQuery(String query) {
        searchProductByKeyword(query);
    }

    @Then("an error message should be displayed indicating no results found")
    public void anErrorMessageShouldBeDisplayedIndicatingNoResultsFound() {
        verifyErrorMessageForInvalidSearch();
    }

    @Then("the interface should be responsive")
    public void theInterfaceShouldBeResponsive() {
        verifyInterfaceResponsiveness();
    }

    @Then("the user should be able to navigate easily")
    public void theUserShouldBeAbleToNavigateEasily() {
        verifyEasyNavigation();
    }

    @When("the user performs a search")
    public void theUserPerformsASearch() {
        performSearch();
    }

    @Then("the search functionality should be optimized for performance")
    public void theSearchFunctionalityShouldBeOptimizedForPerformance() {
        verifySearchPerformanceOptimization();
    }

    @Given("the user performs a search on the product catalog page")
    public void theUserPerformsASearchOnTheProductCatalogPage() {
        performSearch();
    }

    @Then("the system should log the search interaction for analytics purposes")
    public void theSystemShouldLogTheSearchInteractionForAnalyticsPurposes() {
        logSearchInteractionForAnalytics();
    }

    @When("a change is made to the product catalog")
    public void aChangeIsMadeToTheProductCatalog() {
        simulateCatalogChange();
    }

    @Then("the system should update the catalog dynamically without requiring a page refresh")
    public void theSystemShouldUpdateTheCatalogDynamicallyWithoutRequiringAPageRefresh() {
        verifyDynamicCatalogUpdate();
    }
}