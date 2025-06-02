package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.HelpCenterPage;

public class HelpCenterSteps extends HelpCenterPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in with valid credentials")
    public void theUserIsLoggedInWithValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the homepage")
    public void theUserNavigatesToTheHomepage() {
        navigateToHomepage();
    }

    @Then("the main navigation bar is visible and accessible")
    public void theMainNavigationBarIsVisibleAndAccessible() {
        verifyMainNavigationBar();
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        verifyUserOnHomepage();
    }

    @When("the user clicks on the 'Help Center' link in the main navigation")
    public void theUserClicksOnTheHelpCenterLinkInTheMainNavigation() {
        clickHelpCenterLink();
    }

    @Then("the user is redirected to the Help Center page")
    public void theUserIsRedirectedToTheHelpCenterPage() {
        verifyHelpCenterPageRedirection();
    }

    @Given("the user is on the Help Center page")
    public void theUserIsOnTheHelpCenterPage() {
        verifyUserOnHelpCenterPage();
    }

    @Then("the Help Center page displays FAQs and guides options")
    public void theHelpCenterPageDisplaysFAQsAndGuidesOptions() {
        verifyFAQsAndGuidesOptions();
    }

    @When("the user enters 'returns' in the FAQ search bar and clicks search")
    public void theUserEntersReturnsInTheFAQSearchBarAndClicksSearch() {
        searchFAQ("returns");
    }

    @Then("relevant FAQ results for 'returns' are displayed")
    public void relevantFAQResultsForReturnsAreDisplayed() {
        verifyFAQResults("returns");
    }

    @When("the user enters 'setup' in the guide search bar and clicks search")
    public void theUserEntersSetupInTheGuideSearchBarAndClicksSearch() {
        searchGuide("setup");
    }

    @Then("relevant guide results for 'setup' are displayed")
    public void relevantGuideResultsForSetupAreDisplayed() {
        verifyGuideResults("setup");
    }

    @Given("relevant FAQ results are displayed")
    public void relevantFAQResultsAreDisplayed() {
        verifyFAQResultsDisplayed();
    }

    @When("the user selects a FAQ from the search results")
    public void theUserSelectsAFAQFromTheSearchResults() {
        selectFAQFromResults();
    }

    @Then("the selected FAQ content is displayed correctly")
    public void theSelectedFAQContentIsDisplayedCorrectly() {
        verifySelectedFAQContent();
    }

    @Given("relevant guide results are displayed")
    public void relevantGuideResultsAreDisplayed() {
        verifyGuideResultsDisplayed();
    }

    @When("the user selects a guide from the search results")
    public void theUserSelectsAGuideFromTheSearchResults() {
        selectGuideFromResults();
    }

    @Then("the selected guide content is displayed correctly")
    public void theSelectedGuideContentIsDisplayedCorrectly() {
        verifySelectedGuideContent();
    }

    @When("the user checks the page on different devices")
    public void theUserChecksThePageOnDifferentDevices() {
        checkPageResponsiveness();
    }

    @Then("the Help Center page is responsive and displays correctly on all devices")
    public void theHelpCenterPageIsResponsiveAndDisplaysCorrectlyOnAllDevices() {
        verifyPageResponsiveness();
    }

    @When("the user tests the search functionality with multiple keywords")
    public void theUserTestsTheSearchFunctionalityWithMultipleKeywords() {
        testSearchWithMultipleKeywords();
    }

    @Then("search results are accurate and relevant to the keywords entered")
    public void searchResultsAreAccurateAndRelevantToTheKeywordsEntered() {
        verifySearchResultsAccuracy();
    }

    @When("the user accesses FAQ and guide content")
    public void theUserAccessesFAQAndGuideContent() {
        accessFAQAndGuideContent();
    }

    @Then("content loads within acceptable time limits")
    public void contentLoadsWithinAcceptableTimeLimits() {
        verifyContentLoadingTime();
    }

    @When("the user checks for accessibility features")
    public void theUserChecksForAccessibilityFeatures() {
        checkAccessibilityFeatures();
    }

    @Then("accessibility features are present and functional")
    public void accessibilityFeaturesArePresentAndFunctional() {
        verifyAccessibilityFeatures();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        logoutUser();
    }

    @When("the user attempts to access the Help Center")
    public void theUserAttemptsToAccessTheHelpCenter() {
        attemptAccessHelpCenter();
    }

    @Then("the user is prompted to log in to access the Help Center")
    public void theUserIsPromptedToLogInToAccessTheHelpCenter() {
        verifyLoginPrompt();
    }

    @When("the user enters special characters in the search bar")
    public void theUserEntersSpecialCharactersInTheSearchBar() {
        enterSpecialCharactersInSearch();
    }

    @Then("the system handles special characters gracefully and returns relevant results")
    public void theSystemHandlesSpecialCharactersGracefullyAndReturnsRelevantResults() {
        verifySpecialCharacterHandling();
    }

    @When("the user accesses the Help Center during peak hours")
    public void theUserAccessesTheHelpCenterDuringPeakHours() {
        accessHelpCenterDuringPeakHours();
    }

    @Then("the Help Center remains accessible and performs well during peak hours")
    public void theHelpCenterRemainsAccessibleAndPerformsWellDuringPeakHours() {
        verifyHelpCenterPerformance();
    }

    @When("the user searches using synonyms")
    public void theUserSearchesUsingSynonyms() {
        searchUsingSynonyms();
    }

    @Then("search results include relevant synonyms")
    public void searchResultsIncludeRelevantSynonyms() {
        verifySynonymSearchResults();
    }
}