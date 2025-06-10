package com.cucumber.steps;

import com.page_objects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps extends SearchPage {

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        navigateToHomepage();
    }

    @When("the user accesses the search functionality")
    public void theUserAccessesTheSearchFunctionality() {
        accessSearchFunctionality();
    }

    @Then("the search input field should be visible")
    public void theSearchInputFieldShouldBeVisible() {
        verifySearchInputFieldVisible();
    }

    @Given("the search functionality is accessible")
    public void theSearchFunctionalityIsAccessible() {
        verifySearchFunctionalityAccessible();
    }

    @When("the user enters a keyword in the search input field")
    public void theUserEntersAKeywordInTheSearchInputField() {
        enterSearchKeyword();
    }

    @Then("the user should be able to submit the search query")
    public void theUserShouldBeAbleToSubmitTheSearchQuery() {
        submitSearchQuery();
    }

    @Given("the user has entered a keyword in the search input field")
    public void theUserHasEnteredAKeywordInTheSearchInputField() {
        enterSearchKeyword();
    }

    @When("the user submits the search query")
    public void theUserSubmitsTheSearchQuery() {
        submitSearchQuery();
    }

    @Then("relevant products should be displayed based on the keyword")
    public void relevantProductsShouldBeDisplayedBasedOnTheKeyword() {
        verifyRelevantProductsDisplayed();
    }

    @Given("the user is entering a keyword in the search input field")
    public void theUserIsEnteringAKeywordInTheSearchInputField() {
        enterSearchKeyword();
    }

    @When("the user pauses typing")
    public void theUserPausesTyping() {
        pauseTyping();
    }

    @Then("the system should display suggestions for common search terms")
    public void theSystemShouldDisplaySuggestionsForCommonSearchTerms() {
        verifySuggestionsDisplayed();
    }

    @Given("the user enters an invalid search input")
    public void theUserEntersAnInvalidSearchInput() {
        enterInvalidSearchInput();
    }

    @When("the user submits the search query")
    public void theUserSubmitsTheSearchQuery() {
        submitSearchQuery();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user is using a desktop platform")
    public void theUserIsUsingADesktopPlatform() {
        verifyDesktopPlatform();
    }

    @When("the user accesses the search functionality")
    public void theUserAccessesTheSearchFunctionality() {
        accessSearchFunctionality();
    }

    @Then("the search functionality should be available")
    public void theSearchFunctionalityShouldBeAvailable() {
        verifySearchFunctionalityAvailable();
    }

    @Given("the user is using a mobile platform")
    public void theUserIsUsingAMobilePlatform() {
        verifyMobilePlatform();
    }

    @When("the user accesses the search functionality")
    public void theUserAccessesTheSearchFunctionality() {
        accessSearchFunctionality();
    }

    @Then("the search functionality should be available")
    public void theSearchFunctionalityShouldBeAvailable() {
        verifySearchFunctionalityAvailable();
    }

    @Given("the user enters a search query")
    public void theUserEntersASearchQuery() {
        enterSearchQuery();
    }

    @When("the query is processed by the system")
    public void theQueryIsProcessedByTheSystem() {
        processSearchQuery();
    }

    @Then("security measures should prevent SQL injection attacks")
    public void securityMeasuresShouldPreventSQLInjectionAttacks() {
        verifySQLInjectionPrevention();
    }

    @Given("the user submits a search query")
    public void theUserSubmitsASearchQuery() {
        submitSearchQuery();
    }

    @When("the query is processed by the system")
    public void theQueryIsProcessedByTheSystem() {
        processSearchQuery();
    }

    @Then("the search query should be logged for analytics purposes")
    public void theSearchQueryShouldBeLoggedForAnalyticsPurposes() {
        verifySearchQueryLogged();
    }

    @Given("the user submits a search query")
    public void theUserSubmitsASearchQuery() {
        submitSearchQuery();
    }

    @When("the query is processed by the system")
    public void theQueryIsProcessedByTheSystem() {
        processSearchQuery();
    }

    @Then("integration with the product database should ensure accurate search results")
    public void integrationWithTheProductDatabaseShouldEnsureAccurateSearchResults() {
        verifyDatabaseIntegration();
    }

    @Given("the user submits a search query")
    public void theUserSubmitsASearchQuery() {
        submitSearchQuery();
    }

    @When("the query is processed by the system")
    public void theQueryIsProcessedByTheSystem() {
        processSearchQuery();
    }

    @Then("search results should appear within 3 seconds")
    public void searchResultsShouldAppearWithin3Seconds() {
        verifySearchResultsPerformance();
    }
}