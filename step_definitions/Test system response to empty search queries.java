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

    @When("the user navigates to the search bar in the application")
    public void theUserNavigatesToTheSearchBarInTheApplication() {
        navigateToSearchBar();
    }

    @Then("the search bar is accessible and ready for input")
    public void theSearchBarIsAccessibleAndReadyForInput() {
        verifySearchBarAccessibility();
    }

    @When("the user leaves the search bar empty and initiates the search")
    public void theUserLeavesTheSearchBarEmptyAndInitiatesTheSearch() {
        initiateEmptySearch();
    }

    @Then("the system does not crash or display any error")
    public void theSystemDoesNotCrashOrDisplayAnyError() {
        verifyNoCrashOrError();
    }

    @Then("an appropriate message is shown indicating no search term was entered and suggests entering a keyword")
    public void anAppropriateMessageIsShown() {
        verifyNoSearchTermMessage();
    }

    @When("the user initiates an empty search query")
    public void theUserInitiatesAnEmptySearchQuery() {
        initiateEmptySearch();
    }

    @Then("the system performance remains stable and responsive")
    public void theSystemPerformanceRemainsStableAndResponsive() {
        verifySystemPerformance();
    }

    @When("the user initiates an empty search query on different devices and screen sizes")
    public void theUserInitiatesAnEmptySearchQueryOnDifferentDevicesAndScreenSizes() {
        initiateEmptySearchOnMultipleDevices();
    }

    @Then("the system response is consistent across various devices and screen sizes")
    public void theSystemResponseIsConsistentAcrossVariousDevicesAndScreenSizes() {
        verifyConsistentResponseAcrossDevices();
    }

    @Then("no search results are displayed")
    public void noSearchResultsAreDisplayed() {
        verifyNoSearchResults();
    }

    @Then("the search bar remains focused, ready for input")
    public void theSearchBarRemainsFocusedReadyForInput() {
        verifySearchBarFocus();
    }

    @When("the user performs multiple empty searches consecutively")
    public void theUserPerformsMultipleEmptySearchesConsecutively() {
        performMultipleEmptySearches();
    }

    @Then("the system continues to handle multiple empty searches without issue")
    public void theSystemContinuesToHandleMultipleEmptySearchesWithoutIssue() {
        verifyHandlingOfMultipleEmptySearches();
    }

    @Then("empty search queries are logged for future analysis")
    public void emptySearchQueriesAreLoggedForFutureAnalysis() {
        verifyLoggingOfEmptySearchQueries();
    }

    @When("the user initiates an empty search query followed by a valid search")
    public void theUserInitiatesAnEmptySearchQueryFollowedByAValidSearch() {
        initiateEmptyThenValidSearch();
    }

    @Then("the system recovers and performs a valid search without issue")
    public void theSystemRecoversAndPerformsAValidSearchWithoutIssue() {
        verifyRecoveryToValidSearch();
    }

    @When("the user initiates an empty search query with filters applied")
    public void theUserInitiatesAnEmptySearchQueryWithFiltersApplied() {
        initiateEmptySearchWithFilters();
    }

    @Then("an appropriate message is displayed and filters remain unaffected")
    public void anAppropriateMessageIsDisplayedAndFiltersRemainUnaffected() {
        verifyMessageAndFiltersUnaffected();
    }

    @Then("other functionalities remain unaffected by the empty search query")
    public void otherFunctionalitiesRemainUnaffectedByTheEmptySearchQuery() {
        verifyOtherFunctionalitiesUnaffected();
    }

    @When("the user initiates an empty search query after performing a valid search")
    public void theUserInitiatesAnEmptySearchQueryAfterPerformingAValidSearch() {
        initiateEmptySearchAfterValidSearch();
    }

    @Then("the system handles the transition from valid to empty search smoothly")
    public void theSystemHandlesTheTransitionFromValidToEmptySearchSmoothly() {
        verifySmoothTransition();
    }

    @When("the user initiates an empty search query in different application modules")
    public void theUserInitiatesAnEmptySearchQueryInDifferentApplicationModules() {
        initiateEmptySearchInDifferentModules();
    }

    @Then("the system response is consistent across different modules")
    public void theSystemResponseIsConsistentAcrossDifferentModules() {
        verifyConsistentResponseAcrossModules();
    }

    @Then("the user interface provides clear feedback for an empty search query")
    public void theUserInterfaceProvidesClearFeedbackForAnEmptySearchQuery() {
        verifyUIFeedbackForEmptySearch();
    }
}