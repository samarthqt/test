package com.cucumber.steps;

import com.page_objects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends SearchPage {

    @Given("the product database is populated")
    public void theProductDatabaseIsPopulated() {
        verifyDatabaseIsPopulated();
    }

    @Given("I navigate to the product search page")
    public void iNavigateToTheProductSearchPage() {
        navigateToSearchPage();
    }

    @When("I enter the invalid keyword \"nonexistentproduct123\" in the search bar")
    public void iEnterTheInvalidKeywordInTheSearchBar() {
        enterSearchKeyword("nonexistentproduct123");
    }

    @When("I click on the \"Search\" button")
    public void iClickOnTheSearchButton() {
        clickSearchButton();
    }

    @Then("the system displays an appropriate message for no results found")
    public void theSystemDisplaysAnAppropriateMessageForNoResultsFound() {
        verifyNoResultsMessage();
    }

    @Then("no search results are displayed")
    public void noSearchResultsAreDisplayed() {
        verifyNoSearchResults();
    }

    @Given("I have performed a search with the invalid keyword \"nonexistentproduct123\"")
    public void iHavePerformedASearchWithTheInvalidKeyword() {
        performInvalidSearch("nonexistentproduct123");
    }

    @When("I attempt to apply a category filter to the invalid search")
    public void iAttemptToApplyACategoryFilterToTheInvalidSearch() {
        applyCategoryFilter();
    }

    @Then("the filter application does not change the no results message")
    public void theFilterApplicationDoesNotChangeTheNoResultsMessage() {
        verifyNoResultsMessageUnchanged();
    }

    @When("I attempt to apply a price filter to the invalid search")
    public void iAttemptToApplyAPriceFilterToTheInvalidSearch() {
        applyPriceFilter();
    }

    @When("I attempt to apply a rating filter to the invalid search")
    public void iAttemptToApplyARatingFilterToTheInvalidSearch() {
        applyRatingFilter();
    }

    @When("I check the system logs for any errors during the search")
    public void iCheckTheSystemLogsForAnyErrorsDuringTheSearch() {
        checkSystemLogsForErrors();
    }

    @Then("no errors are logged for the invalid keyword search")
    public void noErrorsAreLoggedForTheInvalidKeywordSearch() {
        verifyNoErrorsLogged();
    }

    @When("I verify that the search bar allows re-entry of valid keywords")
    public void iVerifyThatTheSearchBarAllowsReEntryOfValidKeywords() {
        verifySearchBarAllowsReEntry();
    }

    @Then("the search bar allows new keyword entry")
    public void theSearchBarAllowsNewKeywordEntry() {
        verifySearchBarAllowsNewEntry();
    }

    @Given("the search bar allows new keyword entry")
    public void theSearchBarAllowsNewKeywordEntryGiven() {
        verifySearchBarAllowsNewEntry();
    }

    @When("I enter a valid keyword and perform the search again")
    public void iEnterAValidKeywordAndPerformTheSearchAgain() {
        enterSearchKeyword("validKeyword");
        clickSearchButton();
    }

    @Then("search results are displayed for the valid keyword")
    public void searchResultsAreDisplayedForTheValidKeyword() {
        verifySearchResultsDisplayed();
    }

    @When("I add a product from the valid search results to the cart")
    public void iAddAProductFromTheValidSearchResultsToTheCart() {
        addProductToCart();
    }

    @Then("the product is added to the cart")
    public void theProductIsAddedToTheCart() {
        verifyProductAddedToCart();
    }

    @When("I check the cart for the added product")
    public void iCheckTheCartForTheAddedProduct() {
        checkCartForProduct();
    }

    @Then("the cart displays the added product")
    public void theCartDisplaysTheAddedProduct() {
        verifyCartDisplaysProduct();
    }

    @Given("I have added a product to the cart")
    public void iHaveAddedAProductToTheCart() {
        verifyProductAddedToCart();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOut();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @When("I ensure system performance is unaffected by invalid searches")
    public void iEnsureSystemPerformanceIsUnaffectedByInvalidSearches() {
        checkSystemPerformance();
    }

    @Then("system performance remains stable")
    public void systemPerformanceRemainsStable() {
        verifySystemPerformanceStable();
    }
}