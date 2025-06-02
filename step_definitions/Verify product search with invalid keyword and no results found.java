package com.cucumber.steps;

import com.page_objects.ProductSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps extends ProductSearchPage {

    @Given("the product database is populated")
    public void theProductDatabaseIsPopulated() {
        verifyDatabaseIsPopulated();
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

    @When("I enter the invalid keyword {string} in the search bar")
    public void iEnterTheInvalidKeywordInTheSearchBar(String keyword) {
        enterKeywordInSearchBar(keyword);
    }

    @Then("the keyword is entered successfully")
    public void theKeywordIsEnteredSuccessfully() {
        verifyKeywordEntered();
    }

    @Given("the invalid keyword {string} is entered in the search bar")
    public void theInvalidKeywordIsEnteredInTheSearchBar(String keyword) {
        enterKeywordInSearchBar(keyword);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String button) {
        clickSearchButton(button);
    }

    @Then("the search process is initiated")
    public void theSearchProcessIsInitiated() {
        verifySearchInitiated();
    }

    @Given("the search process is initiated with an invalid keyword")
    public void theSearchProcessIsInitiatedWithAnInvalidKeyword() {
        verifySearchInitiated();
    }

    @Then("an appropriate message for no results found is displayed")
    public void anAppropriateMessageForNoResultsFoundIsDisplayed() {
        verifyNoResultsMessageDisplayed();
    }

    @Given("the message for no results found is displayed")
    public void theMessageForNoResultsFoundIsDisplayed() {
        verifyNoResultsMessageDisplayed();
    }

    @Then("no search results are displayed")
    public void noSearchResultsAreDisplayed() {
        verifyNoSearchResultsDisplayed();
    }

    @Given("no search results are displayed")
    public void noSearchResultsAreDisplayedAgain() {
        verifyNoSearchResultsDisplayed();
    }

    @When("I attempt to apply category filter to the invalid search")
    public void iAttemptToApplyCategoryFilterToTheInvalidSearch() {
        applyCategoryFilter();
    }

    @Then("filter application does not change the no results message")
    public void filterApplicationDoesNotChangeTheNoResultsMessage() {
        verifyNoResultsMessageUnchanged();
    }

    @When("I attempt to apply price filter to the invalid search")
    public void iAttemptToApplyPriceFilterToTheInvalidSearch() {
        applyPriceFilter();
    }

    @Then("filter application does not change the no results message")
    public void filterApplicationDoesNotChangeTheNoResultsMessageAgain() {
        verifyNoResultsMessageUnchanged();
    }

    @When("I attempt to apply rating filter to the invalid search")
    public void iAttemptToApplyRatingFilterToTheInvalidSearch() {
        applyRatingFilter();
    }

    @Then("filter application does not change the no results message")
    public void filterApplicationDoesNotChangeTheNoResultsMessageOnceMore() {
        verifyNoResultsMessageUnchanged();
    }

    @When("I check the system logs for any errors during the search")
    public void iCheckTheSystemLogsForAnyErrorsDuringTheSearch() {
        checkSystemLogsForErrors();
    }

    @Then("no errors are logged for the invalid keyword search")
    public void noErrorsAreLoggedForTheInvalidKeywordSearch() {
        verifyNoErrorsLogged();
    }

    @When("I attempt to enter a valid keyword in the search bar")
    public void iAttemptToEnterAValidKeywordInTheSearchBar() {
        enterValidKeywordInSearchBar();
    }

    @Then("search bar allows new keyword entry")
    public void searchBarAllowsNewKeywordEntry() {
        verifySearchBarAllowsEntry();
    }

    @Given("the search bar allows new keyword entry")
    public void theSearchBarAllowsNewKeywordEntry() {
        verifySearchBarAllowsEntry();
    }

    @When("I enter a valid keyword and perform the search again")
    public void iEnterAValidKeywordAndPerformTheSearchAgain() {
        enterValidKeywordAndSearch();
    }

    @Then("search results are displayed for the valid keyword")
    public void searchResultsAreDisplayedForTheValidKeyword() {
        verifySearchResultsDisplayed();
    }

    @Given("search results are displayed for the valid keyword")
    public void searchResultsAreDisplayedForTheValidKeywordAgain() {
        verifySearchResultsDisplayed();
    }

    @When("I add a product from the valid search results to the cart")
    public void iAddAProductFromTheValidSearchResultsToTheCart() {
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
        checkCartForAddedProduct();
    }

    @Then("cart displays the added product")
    public void cartDisplaysTheAddedProduct() {
        verifyCartDisplaysProduct();
    }

    @Given("cart displays the added product")
    public void cartDisplaysTheAddedProductAgain() {
        verifyCartDisplaysProduct();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("user is logged out successfully")
    public void userIsLoggedOutSuccessfullyAgain() {
        verifyUserLoggedOut();
    }

    @When("I perform invalid searches")
    public void iPerformInvalidSearches() {
        performInvalidSearches();
    }

    @Then("system performance remains stable")
    public void systemPerformanceRemainsStable() {
        verifySystemPerformanceStable();
    }
}