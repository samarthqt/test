package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SearchPage;

public class SearchSteps extends SearchPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the product catalog is populated with sample products")
    public void theProductCatalogIsPopulatedWithSampleProducts() {
        populateProductCatalog();
    }

    @When("I open the search page")
    public void iOpenTheSearchPage() {
        openSearchPage();
    }

    @Then("the search page is displayed")
    public void theSearchPageIsDisplayed() {
        verifySearchPageDisplayed();
    }

    @When("I enter the keyword {string} in the search bar")
    public void iEnterTheKeywordInTheSearchBar(String keyword) {
        enterKeywordInSearchBar(keyword);
    }

    @Then("the search bar is populated with {string}")
    public void theSearchBarIsPopulatedWith(String keyword) {
        verifySearchBarPopulated(keyword);
    }

    @When("I click the 'Search' button")
    public void iClickTheSearchButton() {
        clickSearchButton();
    }

    @Then("the system displays search results for {string}")
    public void theSystemDisplaysSearchResultsFor(String keyword) {
        verifySearchResultsDisplayed(keyword);
    }

    @Then("the search results include products related to {string}")
    public void theSearchResultsIncludeProductsRelatedTo(String keyword) {
        verifyProductsRelatedToKeyword(keyword);
    }

    @When("I perform a search using any keyword")
    public void iPerformASearchUsingAnyKeyword() {
        performSearchWithAnyKeyword();
    }

    @Then("the search results are accurate and relevant")
    public void theSearchResultsAreAccurateAndRelevant() {
        verifySearchResultsAccuracy();
    }

    @Then("the search results are displayed within acceptable time")
    public void theSearchResultsAreDisplayedWithinAcceptableTime() {
        verifySearchPerformance();
    }

    @Then("the logs reflect all search queries and outcomes")
    public void theLogsReflectAllSearchQueriesAndOutcomes() {
        verifySearchLogs();
    }

    @When("I enter a keyword not present in the catalog")
    public void iEnterAKeywordNotPresentInTheCatalog() {
        enterNonExistentKeyword();
    }

    @Then("the system displays no results found message")
    public void theSystemDisplaysNoResultsFoundMessage() {
        verifyNoResultsFoundMessage();
    }

    @Then("the search results are paginated correctly")
    public void theSearchResultsArePaginatedCorrectly() {
        verifySearchResultsPagination();
    }

    @When("I perform a search using any keyword on different devices")
    public void iPerformASearchUsingAnyKeywordOnDifferentDevices() {
        performSearchOnDifferentDevices();
    }

    @Then("the search works consistently across devices")
    public void theSearchWorksConsistentlyAcrossDevices() {
        verifySearchConsistencyAcrossDevices();
    }

    @Then("the search results can be sorted by relevance, price, etc.")
    public void theSearchResultsCanBeSortedByRelevancePriceEtc() {
        verifySearchResultsSortingOptions();
    }
}