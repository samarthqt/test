package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.HomePage;

public class SearchQuerySteps extends HomePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("the user is on the homepage with a visible search bar")
    public void theUserIsOnTheHomepageWithAVisibleSearchBar() {
        navigateToHomePage();
        verifySearchBarVisibility();
    }

    @When("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
        navigateToHomePage();
    }

    @When("the user clicks on the search bar")
    public void theUserClicksOnTheSearchBar() {
        clickSearchBar();
    }

    @When("the user types {string} into the search bar")
    public void theUserTypesIntoTheSearchBar(String query) {
        enterSearchQuery(query);
    }

    @When("the user enters a query with special characters")
    public void theUserEntersAQueryWithSpecialCharacters() {
        String query = testHarness.getData("SearchData", "SpecialCharactersQuery");
        enterSearchQuery(query);
    }

    @When("the user enters an empty search query")
    public void theUserEntersAnEmptySearchQuery() {
        enterSearchQuery("");
    }

    @When("the user enters a query with only spaces")
    public void theUserEntersAQueryWithOnlySpaces() {
        enterSearchQuery("   ");
    }

    @When("the user enters a query with mixed valid and invalid characters")
    public void theUserEntersAQueryWithMixedValidAndInvalidCharacters() {
        String query = testHarness.getData("SearchData", "MixedCharactersQuery");
        enterSearchQuery(query);
    }

    @When("the user enters a query exceeding maximum length")
    public void theUserEntersAQueryExceedingMaximumLength() {
        String query = testHarness.getData("SearchData", "ExceedingLengthQuery");
        enterSearchQuery(query);
    }

    @When("the user enters a query with repetitive characters")
    public void theUserEntersAQueryWithRepetitiveCharacters() {
        String query = testHarness.getData("SearchData", "RepetitiveCharactersQuery");
        enterSearchQuery(query);
    }

    @When("the user enters a query with non-ASCII characters")
    public void theUserEntersAQueryWithNonASCIICharacters() {
        String query = testHarness.getData("SearchData", "NonASCIICharactersQuery");
        enterSearchQuery(query);
    }

    @When("the user enters a query with HTML tags")
    public void theUserEntersAQueryWithHTMLTags() {
        String query = testHarness.getData("SearchData", "HTMLTagsQuery");
        enterSearchQuery(query);
    }

    @Then("the homepage is displayed with a visible search bar")
    public void theHomepageIsDisplayedWithAVisibleSearchBar() {
        verifySearchBarVisibility();
    }

    @Then("the system provides a message indicating no results or invalid query")
    public void theSystemProvidesAMessageIndicatingNoResultsOrInvalidQuery() {
        verifyInvalidQueryMessage();
    }

    @Then("the system handles the long input gracefully and provides appropriate feedback")
    public void theSystemHandlesTheLongInputGracefullyAndProvidesAppropriateFeedback() {
        verifyLongInputHandling();
    }

    @Then("the system prevents script execution and provides a message indicating invalid query")
    public void theSystemPreventsScriptExecutionAndProvidesAMessageIndicatingInvalidQuery() {
        verifyScriptPreventionMessage();
    }

    @Then("the system prevents SQL injection and provides a message indicating invalid query")
    public void theSystemPreventsSQLInjectionAndProvidesAMessageIndicatingInvalidQuery() {
        verifySQLInjectionPreventionMessage();
    }

    @Then("the system provides feedback indicating invalid query")
    public void theSystemProvidesFeedbackIndicatingInvalidQuery() {
        verifyInvalidQueryMessage();
    }

    @Then("the system prompts the user to enter a valid search query")
    public void theSystemPromptsTheUserToEnterAValidSearchQuery() {
        verifyEmptyQueryPrompt();
    }

    @Then("the system truncates input and provides feedback indicating invalid query")
    public void theSystemTruncatesInputAndProvidesFeedbackIndicatingInvalidQuery() {
        verifyTruncatedInputFeedback();
    }
}