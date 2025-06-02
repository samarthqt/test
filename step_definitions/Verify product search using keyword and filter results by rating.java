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

    @Then("the product search page should be displayed")
    public void theProductSearchPageShouldBeDisplayed() {
        verifyProductSearchPageDisplayed();
    }

    @Given("I am on the product search page")
    public void iAmOnTheProductSearchPage() {
        navigateToProductSearchPage();
    }

    @When("I enter the keyword \"headphones\" in the search bar")
    public void iEnterTheKeywordInTheSearchBar() {
        enterKeywordInSearchBar("headphones");
    }

    @Then("the keyword should be entered successfully")
    public void theKeywordShouldBeEnteredSuccessfully() {
        verifyKeywordEntered("headphones");
    }

    @When("I apply the rating filter for \"4 stars and above\"")
    public void iApplyTheRatingFilter() {
        applyRatingFilter("4 stars and above");
    }

    @Then("the rating filter should be applied")
    public void theRatingFilterShouldBeApplied() {
        verifyRatingFilterApplied("4 stars and above");
    }

    @Given("the keyword and rating filter are applied")
    public void theKeywordAndRatingFilterAreApplied() {
        enterKeywordInSearchBar("headphones");
        applyRatingFilter("4 stars and above");
    }

    @When("I click on the \"Search\" button")
    public void iClickOnTheSearchButton() {
        clickSearchButton();
    }

    @Then("the search process should be initiated")
    public void theSearchProcessShouldBeInitiated() {
        verifySearchInitiated();
    }

    @Then("the search results should be displayed")
    public void theSearchResultsShouldBeDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Given("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Then("all search results should have a rating of \"4 stars and above\"")
    public void allSearchResultsShouldHaveARatingOf() {
        verifyResultsRating("4 stars and above");
    }

    @Then("the results should be relevant to the keyword \"headphones\"")
    public void theResultsShouldBeRelevantToTheKeyword() {
        verifyResultsRelevance("headphones");
    }

    @When("I sort the search results by price")
    public void iSortTheSearchResultsByPrice() {
        sortResultsByPrice();
    }

    @Then("the search results should be sorted by price")
    public void theSearchResultsShouldBeSortedByPrice() {
        verifyResultsSortedByPrice();
    }

    @Then("the sorting order should be correct")
    public void theSortingOrderShouldBeCorrect() {
        verifySortingOrder();
    }

    @When("I filter the search results by category")
    public void iFilterTheSearchResultsByCategory() {
        filterResultsByCategory();
    }

    @Then("the category filter should be applied")
    public void theCategoryFilterShouldBeApplied() {
        verifyCategoryFilterApplied();
    }

    @Then("the results should be filtered by category")
    public void theResultsShouldBeFilteredByCategory() {
        verifyResultsFilteredByCategory();
    }

    @Given("the search results are filtered by category")
    public void theSearchResultsAreFilteredByCategory() {
        filterResultsByCategory();
    }

    @Then("the number of results should match the applied filters")
    public void theNumberOfResultsShouldMatchTheAppliedFilters() {
        verifyNumberOfResults();
    }

    @When("I add a product from the search results to the cart")
    public void iAddAProductFromTheSearchResultsToTheCart() {
        addProductToCartFromResults();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        verifyProductAddedToCart();
    }

    @Given("a product is added to the cart")
    public void aProductIsAddedToTheCart() {
        addProductToCartFromResults();
    }

    @When("I check the cart for the added product")
    public void iCheckTheCartForTheAddedProduct() {
        checkCartForAddedProduct();
    }

    @Then("the cart should display the added product")
    public void theCartShouldDisplayTheAddedProduct() {
        verifyCartDisplaysAddedProduct();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}