package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductSearchPage;

public class ProductSearchSteps extends ProductSearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the product database is populated")
    public void theProductDatabaseIsPopulated() {
        // Assume database is populated
    }

    @When("I navigate to the product search page")
    public void iNavigateToTheProductSearchPage() {
        navigateToProductSearchPage();
    }

    @Then("the product search page is displayed")
    public void theProductSearchPageIsDisplayed() {
        verifyProductSearchPageDisplayed();
    }

    @Given("I am on the product search page")
    public void iAmOnTheProductSearchPage() {
        navigateToProductSearchPage();
    }

    @When("I enter the keyword 'smartphone' in the search bar")
    public void iEnterTheKeywordInTheSearchBar() {
        enterKeywordInSearchBar("smartphone");
    }

    @Then("the keyword is entered successfully")
    public void theKeywordIsEnteredSuccessfully() {
        verifyKeywordEntered("smartphone");
    }

    @Given("the keyword 'smartphone' is entered")
    public void theKeywordIsEntered() {
        enterKeywordInSearchBar("smartphone");
    }

    @When("I apply the price filter for the range '$200-$500'")
    public void iApplyThePriceFilterForTheRange() {
        applyPriceFilter("200", "500");
    }

    @Then("the price filter is applied")
    public void thePriceFilterIsApplied() {
        verifyPriceFilterApplied("200", "500");
    }

    @Given("the price filter is applied")
    public void thePriceFilterIsAppliedGiven() {
        applyPriceFilter("200", "500");
    }

    @When("I click on the 'Search' button")
    public void iClickOnTheSearchButton() {
        clickSearchButton();
    }

    @Then("the search process is initiated")
    public void theSearchProcessIsInitiated() {
        verifySearchInitiated();
    }

    @Given("the search process is initiated")
    public void theSearchProcessIsInitiatedGiven() {
        clickSearchButton();
    }

    @Then("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Given("the search results are displayed")
    public void theSearchResultsAreDisplayedGiven() {
        verifySearchResultsDisplayed();
    }

    @Then("all results are within the specified price range")
    public void allResultsAreWithinTheSpecifiedPriceRange() {
        verifyResultsWithinPriceRange("200", "500");
    }

    @Then("results are relevant to the keyword 'smartphone'")
    public void resultsAreRelevantToTheKeyword() {
        verifyResultsRelevance("smartphone");
    }

    @When("I sort the search results by category")
    public void iSortTheSearchResultsByCategory() {
        sortResultsByCategory();
    }

    @Then("the search results are sorted by category")
    public void theSearchResultsAreSortedByCategory() {
        verifyResultsSortedByCategory();
    }

    @Given("the search results are sorted by category")
    public void theSearchResultsAreSortedByCategoryGiven() {
        sortResultsByCategory();
    }

    @Then("the sorting order is correct")
    public void theSortingOrderIsCorrect() {
        verifySortingOrder();
    }

    @When("I filter the search results by rating")
    public void iFilterTheSearchResultsByRating() {
        filterResultsByRating();
    }

    @Then("the rating filter is applied")
    public void theRatingFilterIsApplied() {
        verifyRatingFilterApplied();
    }

    @Given("the rating filter is applied")
    public void theRatingFilterIsAppliedGiven() {
        filterResultsByRating();
    }

    @Then("results are filtered by rating")
    public void resultsAreFilteredByRating() {
        verifyResultsFilteredByRating();
    }

    @Given("the results are filtered by rating")
    public void theResultsAreFilteredByRating() {
        verifyResultsFilteredByRating();
    }

    @Then("the number of results matches filters")
    public void theNumberOfResultsMatchesFilters() {
        verifyNumberOfResultsMatchesFilters();
    }

    @When("I add a product from the search results to the cart")
    public void iAddAProductFromTheSearchResultsToTheCart() {
        addProductToCartFromResults();
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        verifyProductAddedToCart();
    }

    @Given("the product is added to the cart")
    public void theProductIsAddedToTheCartGiven() {
        addProductToCartFromResults();
    }

    @When("I check the cart")
    public void iCheckTheCart() {
        checkCartForProduct();
    }

    @Then("the cart displays the added product")
    public void theCartDisplaysTheAddedProduct() {
        verifyCartDisplaysProduct();
    }

    @Given("the cart displays the added product")
    public void theCartDisplaysTheAddedProductGiven() {
        verifyCartDisplaysProduct();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}