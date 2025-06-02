package com.cucumber.steps;

import com.page_objects.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends SearchPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        navigateToHomepage();
    }

    @When("the user navigates to the homepage of the application")
    public void theUserNavigatesToTheHomepageOfTheApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with a visible search bar")
    public void theHomepageIsDisplayedWithAVisibleSearchBar() {
        verifySearchBarVisibility();
    }

    @When("the user clicks on the search bar")
    public void theUserClicksOnTheSearchBar() {
        clickSearchBar();
    }

    @When("types 'laptop' into the search bar")
    public void typesLaptopIntoTheSearchBar() {
        typeIntoSearchBar("laptop");
    }

    @Then("search suggestions related to 'laptop' are displayed below the search bar")
    public void searchSuggestionsRelatedToLaptopAreDisplayedBelowTheSearchBar() {
        verifySearchSuggestions("laptop");
    }

    @Given("search suggestions for 'laptop' are displayed")
    public void searchSuggestionsForLaptopAreDisplayed() {
        verifySearchSuggestions("laptop");
    }

    @When("the user selects one of the autocomplete suggestions")
    public void theUserSelectsOneOfTheAutocompleteSuggestions() {
        selectAutocompleteSuggestion();
    }

    @Then("the selected suggestion is populated in the search bar")
    public void theSelectedSuggestionIsPopulatedInTheSearchBar() {
        verifySuggestionPopulated();
    }

    @Then("search results are displayed")
    public void searchResultsAreDisplayed() {
        verifySearchResults();
    }

    @When("the user types {string} into the search bar")
    public void theUserTypesKeywordIntoTheSearchBar(String keyword) {
        typeIntoSearchBar(keyword);
    }

    @Then("autocomplete suggestions related to {string} are displayed")
    public void autocompleteSuggestionsRelatedToKeywordAreDisplayed(String keyword) {
        verifySearchSuggestions(keyword);
    }

    @Then("suggestions are relevant and match the initial input")
    public void suggestionsAreRelevantAndMatchTheInitialInput() {
        verifySuggestionsRelevance("laptop");
    }

    @When("the user types a keyword quickly into the search bar")
    public void theUserTypesAKeywordQuicklyIntoTheSearchBar() {
        typeQuicklyIntoSearchBar("fastKeyword");
    }

    @Then("autocomplete suggestions appear swiftly without delay")
    public void autocompleteSuggestionsAppearSwiftlyWithoutDelay() {
        verifySuggestionsPerformance();
    }

    @When("the user types a partial keyword into the search bar")
    public void theUserTypesAPartialKeywordIntoTheSearchBar() {
        typeIntoSearchBar("partial");
    }

    @Then("suggestions appear even with partial input")
    public void suggestionsAppearEvenWithPartialInput() {
        verifyPartialInputSuggestions();
    }

    @Then("suggestions dynamically update and refine as more characters are input")
    public void suggestionsDynamicallyUpdateAndRefineAsMoreCharactersAreInput() {
        verifyDynamicSuggestionsUpdate();
    }

    @Then("the selected suggestion populates the search bar")
    public void theSelectedSuggestionPopulatesTheSearchBar() {
        verifySuggestionPopulated();
    }

    @Then("it leads to correct search results")
    public void itLeadsToCorrectSearchResults() {
        verifyCorrectSearchResults();
    }

    @Then("suggestions display correctly across mobile, tablet, and desktop")
    public void suggestionsDisplayCorrectlyAcrossMobileTabletAndDesktop() {
        verifySuggestionsDisplayAcrossDevices();
    }

    @When("the user types a keyword with special characters into the search bar")
    public void theUserTypesAKeywordWithSpecialCharactersIntoTheSearchBar() {
        typeIntoSearchBar("special@keyword");
    }

    @Then("autocomplete handles special characters correctly and provides suggestions")
    public void autocompleteHandlesSpecialCharactersCorrectlyAndProvidesSuggestions() {
        verifySpecialCharacterHandling();
    }

    @Then("autocomplete does not suggest irrelevant or unrelated items")
    public void autocompleteDoesNotSuggestIrrelevantOrUnrelatedItems() {
        verifyIrrelevantSuggestions();
    }

    @Then("autocomplete function operates within user privacy settings")
    public void autocompleteFunctionOperatesWithinUserPrivacySettings() {
        verifyPrivacySettingsCompliance();
    }
}