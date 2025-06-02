package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SearchPage;

public class SearchSteps extends SearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the search bar")
    public void theUserNavigatesToTheSearchBar() {
        navigateToSearchBar();
    }

    @When("the search bar is accessible and ready for input")
    public void theSearchBarIsAccessibleAndReadyForInput() {
        verifySearchBarAccessibility();
    }

    @When("the user enters the keyword {string} into the search bar")
    public void theUserEntersTheKeywordIntoTheSearchBar(String keyword) {
        enterKeywordIntoSearchBar(keyword);
    }

    @When("initiates the search")
    public void initiatesTheSearch() {
        initiateSearch();
    }

    @Then("search results relevant to {string} are displayed")
    public void searchResultsRelevantToAreDisplayed(String keyword) {
        verifySearchResultsRelevance(keyword);
    }

    @Then("all search results contain products related to {string}")
    public void allSearchResultsContainProductsRelatedTo(String keyword) {
        verifyProductsRelatedToKeyword(keyword);
    }

    @When("the user performs a search")
    public void theUserPerformsASearch() {
        performSearch();
    }

    @Then("search results are ranked accurately based on relevance")
    public void searchResultsAreRankedAccuratelyBasedOnRelevance() {
        verifySearchResultsRanking();
    }

    @When("the user enters a partial keyword into the search bar")
    public void theUserEntersAPartialKeywordIntoTheSearchBar() {
        enterPartialKeywordIntoSearchBar();
    }

    @Then("relevant suggestions and results are displayed for partial keywords")
    public void relevantSuggestionsAndResultsAreDisplayedForPartialKeywords() {
        verifySuggestionsAndResultsForPartialKeywords();
    }

    @When("the user enters a keyword synonym into the search bar")
    public void theUserEntersAKeywordSynonymIntoTheSearchBar() {
        enterKeywordSynonymIntoSearchBar();
    }

    @Then("search results include products related to synonyms of the keyword")
    public void searchResultsIncludeProductsRelatedToSynonymsOfTheKeyword() {
        verifyProductsRelatedToKeywordSynonyms();
    }

    @When("the user enters a misspelled keyword into the search bar")
    public void theUserEntersAMisspelledKeywordIntoTheSearchBar() {
        enterMisspelledKeywordIntoSearchBar();
    }

    @Then("search results include suggestions or corrections for misspelled keywords")
    public void searchResultsIncludeSuggestionsOrCorrectionsForMisspelledKeywords() {
        verifySuggestionsOrCorrectionsForMisspelledKeywords();
    }

    @Then("search results are displayed promptly without delay")
    public void searchResultsAreDisplayedPromptlyWithoutDelay() {
        verifySearchPerformance();
    }

    @When("the user navigates through search results")
    public void theUserNavigatesThroughSearchResults() {
        navigateThroughSearchResults();
    }

    @Then("pagination and navigation through search results function correctly")
    public void paginationAndNavigationThroughSearchResultsFunctionCorrectly() {
        verifyPaginationAndNavigation();
    }

    @When("the user performs a search on different devices and screen sizes")
    public void theUserPerformsASearchOnDifferentDevicesAndScreenSizes() {
        performSearchOnDifferentDevices();
    }

    @Then("search results are consistent across various devices and screen sizes")
    public void searchResultsAreConsistentAcrossVariousDevicesAndScreenSizes() {
        verifyConsistencyAcrossDevices();
    }

    @When("the user enters multiple keywords and applies filters")
    public void theUserEntersMultipleKeywordsAndAppliesFilters() {
        enterMultipleKeywordsAndApplyFilters();
    }

    @Then("search results accurately reflect the combination of keywords and filters")
    public void searchResultsAccuratelyReflectTheCombinationOfKeywordsAndFilters() {
        verifyResultsForKeywordsAndFilters();
    }
}