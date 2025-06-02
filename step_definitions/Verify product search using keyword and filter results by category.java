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

    @Then("I understand category filters available")
    public void iUnderstandCategoryFiltersAvailable() {
        verifyCategoryFiltersAvailable();
    }

    @Given("I am on the product search page")
    public void iAmOnTheProductSearchPage() {
        verifyProductSearchPageDisplayed();
    }

    @When("I enter the keyword 'laptop' in the search bar")
    public void iEnterTheKeywordInTheSearchBar() {
        enterKeywordInSearchBar("laptop");
    }

    @Then("the keyword is entered successfully")
    public void theKeywordIsEnteredSuccessfully() {
        verifyKeywordEntered("laptop");
    }

    @Given("I have entered a keyword in the search bar")
    public void iHaveEnteredAKeywordInTheSearchBar() {
        enterKeywordInSearchBar("laptop");
    }

    @When("I select 'Electronics' from the category filter")
    public void iSelectFromTheCategoryFilter() {
        selectCategoryFilter("Electronics");
    }

    @Then("the category filter is applied")
    public void theCategoryFilterIsApplied() {
        verifyCategoryFilterApplied("Electronics");
    }

    @Given("I have selected a category filter")
    public void iHaveSelectedACategoryFilter() {
        selectCategoryFilter("Electronics");
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
    public void theSearchProcessIsInitiatedAgain() {
        verifySearchInitiated();
    }

    @When("I check if the search results are displayed")
    public void iCheckIfTheSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Then("search results are displayed")
    public void searchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Given("search results are displayed")
    public void searchResultsAreDisplayedAgain() {
        verifySearchResultsDisplayed();
    }

    @When("I verify that all search results belong to the 'Electronics' category")
    public void iVerifyThatAllSearchResultsBelongToTheCategory() {
        verifyResultsCategory("Electronics");
    }

    @Then("all results are from the 'Electronics' category")
    public void allResultsAreFromTheCategory() {
        verifyResultsCategory("Electronics");
    }

    @When("I check the relevance of search results to the keyword 'laptop'")
    public void iCheckTheRelevanceOfSearchResultsToTheKeyword() {
        verifyResultsRelevance("laptop");
    }

    @Then("results are relevant to the keyword 'laptop'")
    public void resultsAreRelevantToTheKeyword() {
        verifyResultsRelevance("laptop");
    }

    @When("I sort the search results by price")
    public void iSortTheSearchResultsByPrice() {
        sortResultsByPrice();
    }

    @Then("search results are sorted by price")
    public void searchResultsAreSortedByPrice() {
        verifyResultsSortedByPrice();
    }

    @Given("search results are sorted by price")
    public void searchResultsAreSortedByPriceAgain() {
        verifyResultsSortedByPrice();
    }

    @When("I verify the sorting order is correct")
    public void iVerifyTheSortingOrderIsCorrect() {
        verifySortingOrder();
    }

    @Then("sorting order is correct")
    public void sortingOrderIsCorrect() {
        verifySortingOrder();
    }

    @When("I filter the search results by rating")
    public void iFilterTheSearchResultsByRating() {
        filterResultsByRating();
    }

    @Then("rating filter is applied")
    public void ratingFilterIsApplied() {
        verifyRatingFilterApplied();
    }

    @Given("rating filter is applied")
    public void ratingFilterIsAppliedAgain() {
        verifyRatingFilterApplied();
    }

    @When("I check if the search results are filtered by rating")
    public void iCheckIfTheSearchResultsAreFilteredByRating() {
        verifyResultsFilteredByRating();
    }

    @Then("results are filtered by rating")
    public void resultsAreFilteredByRating() {
        verifyResultsFilteredByRating();
    }

    @Given("search results are filtered")
    public void searchResultsAreFiltered() {
        verifyResultsFilteredByRating();
    }

    @When("I verify the number of results matches the applied filters")
    public void iVerifyTheNumberOfResultsMatchesTheAppliedFilters() {
        verifyResultsCountMatchesFilters();
    }

    @Then("number of results matches filters")
    public void numberOfResultsMatchesFilters() {
        verifyResultsCountMatchesFilters();
    }

    @When("I add a product from the search results to the cart")
    public void iAddAProductFromTheSearchResultsToTheCart() {
        addProductToCartFromResults();
    }

    @Then("product is added to the cart")
    public void productIsAddedToTheCart() {
        verifyProductAddedToCart();
    }

    @Given("product is added to the cart")
    public void productIsAddedToTheCartAgain() {
        verifyProductAddedToCart();
    }

    @When("I check the cart for the added product")
    public void iCheckTheCartForTheAddedProduct() {
        verifyProductInCart();
    }

    @Then("cart displays the added product")
    public void cartDisplaysTheAddedProduct() {
        verifyProductInCart();
    }

    @Given("I have checked the cart for the added product")
    public void iHaveCheckedTheCartForTheAddedProduct() {
        verifyProductInCart();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}