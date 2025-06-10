package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductSearchPage;

public class ProductSearchSteps extends ProductSearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user navigates to the product search page")
    public void aUserNavigatesToTheProductSearchPage() {
        navigateToSearchPage();
    }

    @When("the user enters a keyword in the search bar")
    public void theUserEntersAKeywordInTheSearchBar() {
        String keyword = testHarness.getData("SearchData", "Keyword");
        enterSearchKeyword(keyword);
    }

    @When("clicks the search button")
    public void clicksTheSearchButton() {
        clickSearchButton();
    }

    @Then("the user should see a list of products matching the keyword")
    public void theUserShouldSeeAListOfProductsMatchingTheKeyword() {
        verifySearchResults();
    }

    @Given("search results are displayed")
    public void searchResultsAreDisplayed() {
        verifySearchResults();
    }

    @When("the user selects a category filter")
    public void theUserSelectsACategoryFilter() {
        selectCategoryFilter();
    }

    @Then("the search results should be updated to display products within the selected category")
    public void theSearchResultsShouldBeUpdatedToDisplayProductsWithinTheSelectedCategory() {
        verifyCategoryFilteredResults();
    }

    @When("the user selects a price range filter")
    public void theUserSelectsAPriceRangeFilter() {
        selectPriceRangeFilter();
    }

    @Then("the search results should be updated to display products within the selected price range")
    public void theSearchResultsShouldBeUpdatedToDisplayProductsWithinTheSelectedPriceRange() {
        verifyPriceFilteredResults();
    }

    @When("the user selects a rating filter")
    public void theUserSelectsARatingFilter() {
        selectRatingFilter();
    }

    @Then("the search results should be updated to display products within the selected rating")
    public void theSearchResultsShouldBeUpdatedToDisplayProductsWithinTheSelectedRating() {
        verifyRatingFilteredResults();
    }

    @Given("a user enters a keyword in the search bar")
    public void aUserEntersAKeywordInTheSearchBar() {
        String keyword = testHarness.getData("SearchData", "Keyword");
        enterSearchKeyword(keyword);
    }

    @When("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResults();
    }

    @Then("the results should accurately reflect products related to the keyword")
    public void theResultsShouldAccuratelyReflectProductsRelatedToTheKeyword() {
        verifyAccurateSearchResults();
    }

    @Given("a large product catalog is available")
    public void aLargeProductCatalogIsAvailable() {
        verifyLargeCatalogAvailability();
    }

    @When("a user performs a search")
    public void aUserPerformsASearch() {
        performSearch();
    }

    @Then("the search results should be displayed promptly without performance degradation")
    public void theSearchResultsShouldBeDisplayedPromptlyWithoutPerformanceDegradation() {
        verifySearchPerformance();
    }

    @Given("a user enters an invalid search query")
    public void aUserEntersAnInvalidSearchQuery() {
        String invalidQuery = testHarness.getData("SearchData", "InvalidQuery");
        enterSearchKeyword(invalidQuery);
    }

    @When("the user attempts to search")
    public void theUserAttemptsToSearch() {
        clickSearchButton();
    }

    @Then("an error message should be displayed indicating the query is invalid")
    public void anErrorMessageShouldBeDisplayedIndicatingTheQueryIsInvalid() {
        verifyInvalidQueryErrorMessage();
    }

    @Given("a user is on the product search page")
    public void aUserIsOnTheProductSearchPage() {
        navigateToSearchPage();
    }

    @When("the search options are displayed")
    public void theSearchOptionsAreDisplayed() {
        verifySearchOptionsVisibility();
    }

    @Then("the options should be clearly visible and easy to use")
    public void theOptionsShouldBeClearlyVisibleAndEasyToUse() {
        verifySearchOptionsUsability();
    }

    @Then("search results should be displayed in a clear and organized manner")
    public void searchResultsShouldBeDisplayedInAClearAndOrganizedManner() {
        verifySearchResultsDisplay();
    }

    @Given("a user performs a search action")
    public void aUserPerformsASearchAction() {
        performSearch();
    }

    @When("the search results are displayed")
    public void theSearchResultsAreDisplayedAgain() {
        verifySearchResults();
    }

    @Then("the search activity should be logged for analysis")
    public void theSearchActivityShouldBeLoggedForAnalysis() {
        verifySearchActivityLogging();
    }

    @Given("a product catalog is managed externally")
    public void aProductCatalogIsManagedExternally() {
        verifyExternalCatalogManagement();
    }

    @When("a search is performed")
    public void aSearchIsPerformed() {
        performSearch();
    }

    @Then("the search results should accurately reflect the current product catalog")
    public void theSearchResultsShouldAccuratelyReflectTheCurrentProductCatalog() {
        verifyCatalogIntegration();
    }

    @Given("a user navigates to the product search page")
    public void aUserNavigatesToTheProductSearchPageAgain() {
        navigateToSearchPage();
    }

    @When("interacting with search functionality")
    public void interactingWithSearchFunctionality() {
        performSearch();
    }

    @Then("the experience should comply with established user experience standards")
    public void theExperienceShouldComplyWithEstablishedUserExperienceStandards() {
        verifyUserExperienceCompliance();
    }
}