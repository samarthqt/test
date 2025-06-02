package com.cucumber.steps;

import com.page_objects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends SearchPage {

    @Given("the product database is populated with a large dataset")
    public void theProductDatabaseIsPopulatedWithALargeDataset() {
        populateDatabaseWithLargeDataset();
    }

    @When("I navigate to the product search page")
    public void iNavigateToTheProductSearchPage() {
        navigateToSearchPage();
    }

    @Then("the product search page is displayed")
    public void theProductSearchPageIsDisplayed() {
        verifySearchPageDisplayed();
    }

    @Given("I am on the product search page")
    public void iAmOnTheProductSearchPage() {
        verifySearchPageDisplayed();
    }

    @When("I enter the keyword 'electronics' in the search bar")
    public void iEnterTheKeywordElectronicsInTheSearchBar() {
        enterKeywordInSearchBar("electronics");
    }

    @Then("the keyword is entered successfully")
    public void theKeywordIsEnteredSuccessfully() {
        verifyKeywordEntered("electronics");
    }

    @Given("I have entered the keyword 'electronics'")
    public void iHaveEnteredTheKeywordElectronics() {
        verifyKeywordEntered("electronics");
    }

    @When("I select 'All Categories' from the category filter")
    public void iSelectAllCategoriesFromTheCategoryFilter() {
        applyCategoryFilter("All Categories");
    }

    @Then("the category filter is applied")
    public void theCategoryFilterIsApplied() {
        verifyCategoryFilterApplied("All Categories");
    }

    @When("I apply the price filter for 'All Prices'")
    public void iApplyThePriceFilterForAllPrices() {
        applyPriceFilter("All Prices");
    }

    @Then("the price filter is applied")
    public void thePriceFilterIsApplied() {
        verifyPriceFilterApplied("All Prices");
    }

    @When("I apply the rating filter for 'All Ratings'")
    public void iApplyTheRatingFilterForAllRatings() {
        applyRatingFilter("All Ratings");
    }

    @Then("the rating filter is applied")
    public void theRatingFilterIsApplied() {
        verifyRatingFilterApplied("All Ratings");
    }

    @Given("I have applied all necessary filters")
    public void iHaveAppliedAllNecessaryFilters() {
        verifyAllFiltersApplied();
    }

    @When("I click on the 'Search' button")
    public void iClickOnTheSearchButton() {
        initiateSearch();
    }

    @Then("the search process is initiated")
    public void theSearchProcessIsInitiated() {
        verifySearchInitiated();
    }

    @Then("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Given("the search results are displayed")
    public void theSearchResultsAreDisplayedAgain() {
        verifySearchResultsDisplayed();
    }

    @When("I measure the time taken to display search results")
    public void iMeasureTheTimeTakenToDisplaySearchResults() {
        measureSearchResultsDisplayTime();
    }

    @Then("the search results are displayed within acceptable time limits")
    public void theSearchResultsAreDisplayedWithinAcceptableTimeLimits() {
        verifySearchResultsDisplayTime();
    }

    @When("I verify the relevance of search results to the keyword 'electronics'")
    public void iVerifyTheRelevanceOfSearchResultsToTheKeywordElectronics() {
        verifySearchResultsRelevance("electronics");
    }

    @Then("the results are relevant to the keyword 'electronics'")
    public void theResultsAreRelevantToTheKeywordElectronics() {
        verifyResultsRelevance("electronics");
    }

    @When("I sort the search results by price")
    public void iSortTheSearchResultsByPrice() {
        sortSearchResultsByPrice();
    }

    @Then("the search results are sorted by price")
    public void theSearchResultsAreSortedByPrice() {
        verifySearchResultsSortedByPrice();
    }

    @Then("the sorting order is correct")
    public void theSortingOrderIsCorrect() {
        verifySortingOrder();
    }

    @When("I filter the search results by rating")
    public void iFilterTheSearchResultsByRating() {
        filterSearchResultsByRating();
    }

    @Then("the rating filter is applied")
    public void theRatingFilterIsAppliedAgain() {
        verifyRatingFilterApplied();
    }

    @Then("the results are filtered by rating")
    public void theResultsAreFilteredByRating() {
        verifyResultsFilteredByRating();
    }

    @Given("the search results are filtered by rating")
    public void theSearchResultsAreFilteredByRatingAgain() {
        verifyResultsFilteredByRating();
    }

    @When("I verify the number of results matches the applied filters")
    public void iVerifyTheNumberOfResultsMatchesTheAppliedFilters() {
        verifyNumberOfResultsMatchesFilters();
    }

    @Then("the number of results matches filters")
    public void theNumberOfResultsMatchesFilters() {
        verifyResultsCountMatchesFilters();
    }

    @Given("I have search results displayed")
    public void iHaveSearchResultsDisplayed() {
        verifySearchResultsDisplayed();
    }

    @When("I add a product from the search results to the cart")
    public void iAddAProductFromTheSearchResultsToTheCart() {
        addProductToCartFromSearchResults();
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        verifyProductAddedToCart();
    }

    @Then("the cart displays the added product")
    public void theCartDisplaysTheAddedProduct() {
        verifyCartDisplaysAddedProduct();
    }

    @Given("I have added a product to the cart")
    public void iHaveAddedAProductToTheCart() {
        verifyProductAddedToCart();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("I am using the search functionality")
    public void iAmUsingTheSearchFunctionality() {
        verifySearchFunctionalityInUse();
    }

    @When("I perform multiple search operations")
    public void iPerformMultipleSearchOperations() {
        performMultipleSearchOperations();
    }

    @Then("the system performance remains stable")
    public void theSystemPerformanceRemainsStable() {
        verifySystemPerformanceStability();
    }
}