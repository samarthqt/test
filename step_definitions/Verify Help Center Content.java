package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.HelpCenterPage;

public class HelpCenterSteps extends HelpCenterPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the help center section of the application")
    public void theUserNavigatesToTheHelpCenterSectionOfTheApplication() {
        navigateToHelpCenter();
    }

    @Then("the help center section is displayed with search functionality")
    public void theHelpCenterSectionIsDisplayedWithSearchFunctionality() {
        verifyHelpCenterDisplayed();
    }

    @Given("the user is in the help center section")
    public void theUserIsInTheHelpCenterSection() {
        verifyHelpCenterDisplayed();
    }

    @When("the user searches for a specific FAQ topic using the search bar")
    public void theUserSearchesForASpecificFAQTopicUsingTheSearchBar() {
        searchFAQTopic(testHarness.getData("HelpCenterData", "FAQTopic"));
    }

    @Then("relevant FAQ topics are listed based on the search query")
    public void relevantFAQTopicsAreListedBasedOnTheSearchQuery() {
        verifyFAQSearchResults();
    }

    @Given("the user has searched for a FAQ topic")
    public void theUserHasSearchedForAFAQTopic() {
        searchFAQTopic(testHarness.getData("HelpCenterData", "FAQTopic"));
    }

    @When("the user selects a FAQ topic from the list")
    public void theUserSelectsAFAQTopicFromTheList() {
        selectFAQTopic();
    }

    @Then("FAQ content is displayed with detailed information")
    public void faqContentIsDisplayedWithDetailedInformation() {
        verifyFAQContentDisplayed();
    }

    @When("the user navigates to the guides section")
    public void theUserNavigatesToTheGuidesSection() {
        navigateToGuidesSection();
    }

    @Then("the guides section is displayed with various guide topics")
    public void theGuidesSectionIsDisplayedWithVariousGuideTopics() {
        verifyGuidesSectionDisplayed();
    }

    @When("the user selects a guide topic")
    public void theUserSelectsAGuideTopic() {
        selectGuideTopic();
    }

    @Then("guide content is displayed with step-by-step instructions")
    public void guideContentIsDisplayedWithStepByStepInstructions() {
        verifyGuideContentDisplayed();
    }

    @When("the user checks for downloadable resources")
    public void theUserChecksForDownloadableResources() {
        checkDownloadableResources();
    }

    @Then("downloadable resources are available and accessible")
    public void downloadableResourcesAreAvailableAndAccessible() {
        verifyDownloadableResources();
    }

    @When("the user checks for broken links within FAQs and guides")
    public void theUserChecksForBrokenLinksWithinFAQsAndGuides() {
        checkForBrokenLinks();
    }

    @Then("no broken links are found")
    public void noBrokenLinksAreFound() {
        verifyNoBrokenLinks();
    }

    @Given("the user is not logged into the application")
    public void theUserIsNotLoggedIntoTheApplication() {
        logoutFromApplication();
    }

    @When("the user attempts to access help center content")
    public void theUserAttemptsToAccessHelpCenterContent() {
        accessHelpCenterWithoutLogin();
    }

    @Then("help center content is accessible without login")
    public void helpCenterContentIsAccessibleWithoutLogin() {
        verifyHelpCenterAccessWithoutLogin();
    }

    @Given("the user is using different browsers")
    public void theUserIsUsingDifferentBrowsers() {
        switchBrowser();
    }

    @When("the user accesses the help center")
    public void theUserAccessesTheHelpCenter() {
        navigateToHelpCenter();
    }

    @Then("the help center functions correctly across different browsers")
    public void theHelpCenterFunctionsCorrectlyAcrossDifferentBrowsers() {
        verifyHelpCenterFunctionalityAcrossBrowsers();
    }

    @Given("the user is using a mobile device")
    public void theUserIsUsingAMobileDevice() {
        switchToMobileView();
    }

    @Then("help center content is accessible and properly formatted on mobile devices")
    public void helpCenterContentIsAccessibleAndProperlyFormattedOnMobileDevices() {
        verifyHelpCenterOnMobile();
    }

    @When("the user checks the content")
    public void theUserChecksTheContent() {
        checkHelpCenterContentUpdates();
    }

    @Then("the content reflects recent updates and changes")
    public void theContentReflectsRecentUpdatesAndChanges() {
        verifyContentUpdates();
    }

    @When("the user uses the search bar")
    public void theUserUsesTheSearchBar() {
        useSearchBar(testHarness.getData("HelpCenterData", "SearchQuery"));
    }

    @Then("the search bar returns accurate results based on input")
    public void theSearchBarReturnsAccurateResultsBasedOnInput() {
        verifySearchResults();
    }

    @When("the help center loads")
    public void theHelpCenterLoads() {
        loadHelpCenter();
    }

    @Then("the help center loads within expected time frame")
    public void theHelpCenterLoadsWithinExpectedTimeFrame() {
        verifyHelpCenterLoadTime();
    }

    @When("the user performs actions within the help center")
    public void theUserPerformsActionsWithinTheHelpCenter() {
        performHelpCenterActions();
    }

    @Then("user interactions are logged in CRM systems")
    public void userInteractionsAreLoggedInCRMSytems() {
        verifyCRMIntegration();
    }

    @Given("the user is accessing the help center during peak times")
    public void theUserIsAccessingTheHelpCenterDuringPeakTimes() {
        simulatePeakTimeAccess();
    }

    @When("the user navigates through the help center")
    public void theUserNavigatesThroughTheHelpCenter() {
        navigateThroughHelpCenter();
    }

    @Then("the help center remains accessible and responsive during peak times")
    public void theHelpCenterRemainsAccessibleAndResponsiveDuringPeakTimes() {
        verifyHelpCenterPerformanceDuringPeak();
    }
}