package com.cucumber.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.pageobjects.SearchPage;

public class SearchSteps {

    private SearchPage searchPage = new SearchPage();

    @Given("the product database is populated")
    public void theProductDatabaseIsPopulated() {
        // Assume the database is already populated for testing purposes
    }

    @Given("the product database is available")
    public void theProductDatabaseIsAvailable() {
        // Assume database is always available for this test
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String searchKeyword) {
        searchPage.enterSearchKeyword(searchKeyword);
    }

    @When("the user applies the {string} filter")
    public void theUserAppliesTheFilter(String brandFilter) {
        searchPage.applyBrandFilter(brandFilter);
    }

    @When("the user selects the 'Search' button")
    public void theUserSelectsTheSearchButton() {
        searchPage.clickSearchButton();
    }

    @Then("the search results should update dynamically to show {string} products")
    public void theSearchResultsShouldUpdateDynamicallyToShowProducts(String brandFilter) {
        searchPage.verifySearchResultsUpdate(brandFilter);
    }

    @Then("the user should see a 'no results' message")
    public void theUserShouldSeeANoResultsMessage() {
        searchPage.verifyNoResultsMessage();
    }
}
