package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SearchPage;

public class SearchSteps extends SearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the retail application is open")
    public void theRetailApplicationIsOpen() {
        launchApplication();
    }

    @When("the user navigates to the search bar")
    public void theUserNavigatesToTheSearchBar() {
        navigateToSearchBar();
    }

    @Then("the search bar should be accessible and ready for input")
    public void theSearchBarShouldBeAccessibleAndReadyForInput() {
        verifySearchBarAccessibility();
    }

    @Given("the product catalog is populated with searchable products")
    public void theProductCatalogIsPopulatedWithSearchableProducts() {
        verifyProductCatalog();
    }

    @When("the user enters the keyword {string} in the search bar")
    public void theUserEntersTheKeywordInTheSearchBar(String keyword) {
        enterSearchKeyword(keyword);
    }

    @When("submits the search query")
    public void submitsTheSearchQuery() {
        submitSearchQuery();
    }

    @Then("relevant product results should be displayed based on the keyword {string}")
    public void relevantProductResultsShouldBeDisplayedBasedOnTheKeyword(String keyword) {
        verifySearchResults(keyword);
    }

    @Given("the search results are displayed")
    public void theSearchResultsAreDisplayed() {
        verifySearchResultsDisplayed();
    }

    @Then("the search results should be relevant and accurately match the keyword {string}")
    public void theSearchResultsShouldBeRelevantAndAccuratelyMatchTheKeyword(String keyword) {
        verifyRelevanceOfSearchResults(keyword);
    }

    @When("the user submits the search query")
    public void theUserSubmitsTheSearchQuery() {
        submitSearchQuery();
    }

    @Then("search results should be displayed quickly, within acceptable time limits")
    public void searchResultsShouldBeDisplayedQuicklyWithinAcceptableTimeLimits() {
        verifySearchSpeed();
    }

    @Given("search results for {string} and {string} are displayed")
    public void searchResultsForAndAreDisplayed(String keyword1, String keyword2) {
        verifySearchResultsForKeywords(keyword1, keyword2);
    }

    @Then("the search results should be consistent and accurately match different keywords")
    public void theSearchResultsShouldBeConsistentAndAccuratelyMatchDifferentKeywords() {
        verifyConsistencyOfSearchResults();
    }

    @Given("the retail application is open on a mobile device")
    public void theRetailApplicationIsOpenOnAMobileDevice() {
        launchApplicationOnMobile();
    }

    @When("the user enters a keyword in the search bar")
    public void theUserEntersAKeywordInTheSearchBar() {
        enterSearchKeywordOnMobile();
    }

    @Then("search functionality should work well on mobile, displaying relevant results quickly")
    public void searchFunctionalityShouldWorkWellOnMobileDisplayingRelevantResultsQuickly() {
        verifyMobileSearchFunctionality();
    }

    @Given("search results are displayed on both desktop and mobile")
    public void searchResultsAreDisplayedOnBothDesktopAndMobile() {
        verifySearchResultsOnBothPlatforms();
    }

    @Then("no discrepancies should be found; search results should be consistent across platforms")
    public void noDiscrepanciesShouldBeFoundSearchResultsShouldBeConsistentAcrossPlatforms() {
        verifyConsistencyAcrossPlatforms();
    }

    @Then("search results should include product details such as name, price, and image")
    public void searchResultsShouldIncludeProductDetailsSuchAsNamePriceAndImage() {
        verifyProductDetailsInSearchResults();
    }

    @Then("Add to Cart button should function correctly in search results")
    public void addToCartButtonShouldFunctionCorrectlyInSearchResults() {
        verifyAddToCartFunctionality();
    }

    @When("the user enters a complex search query with multiple keywords")
    public void theUserEntersAComplexSearchQueryWithMultipleKeywords() {
        enterComplexSearchQuery();
    }

    @Then("the system should handle complex search queries well, displaying relevant results")
    public void theSystemShouldHandleComplexSearchQueriesWellDisplayingRelevantResults() {
        verifyComplexSearchHandling();
    }

    @Then("no error messages or broken links should be present in search results")
    public void noErrorMessagesOrBrokenLinksShouldBePresentInSearchResults() {
        verifyNoErrorsInSearchResults();
    }

    @When("the user applies filters by categories or price ranges")
    public void theUserAppliesFiltersByCategoriesOrPriceRanges() {
        applyFiltersToSearchResults();
    }

    @Then("search results should be filtered successfully")
    public void searchResultsShouldBeFilteredSuccessfully() {
        verifyFilteredSearchResults();
    }

    @Given("the retail application has a large dataset")
    public void theRetailApplicationHasALargeDataset() {
        verifyLargeDatasetHandling();
    }

    @Then("the system should handle large datasets efficiently, maintaining performance during searches")
    public void theSystemShouldHandleLargeDatasetsEfficientlyMaintainingPerformanceDuringSearches() {
        verifyPerformanceWithLargeDatasets();
    }
}