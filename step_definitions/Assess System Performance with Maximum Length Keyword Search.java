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

    @When("the user navigates to the homepage of the application")
    public void theUserNavigatesToTheHomepageOfTheApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with a visible search bar")
    public void theHomepageIsDisplayedWithAVisibleSearchBar() {
        verifySearchBarVisibility();
    }

    @Given("the search bar is visible on the homepage")
    public void theSearchBarIsVisibleOnTheHomepage() {
        verifySearchBarVisibility();
    }

    @When("the user clicks on the search bar")
    public void theUserClicksOnTheSearchBar() {
        clickOnSearchBar();
    }

    @Then("the cursor is placed in the search bar, ready for input")
    public void theCursorIsPlacedInTheSearchBarReadyForInput() {
        verifyCursorInSearchBar();
    }

    @Given("the cursor is placed in the search bar")
    public void theCursorIsPlacedInTheSearchBar() {
        verifyCursorInSearchBar();
    }

    @When("the user types '{string}' repeated 255 times into the search bar")
    public void theUserTypesRepeated255TimesIntoTheSearchBar(String character) {
        typeMaxLengthKeyword(character);
    }

    @Then("the system processes the input without crashing and provides feedback")
    public void theSystemProcessesTheInputWithoutCrashingAndProvidesFeedback() {
        verifySystemFeedback();
    }

    @Given("the user has entered maximum length input into the search bar")
    public void theUserHasEnteredMaximumLengthInputIntoTheSearchBar() {
        enterMaxLengthInput();
    }

    @Then("the system handles the input efficiently and provides feedback")
    public void theSystemHandlesTheInputEfficientlyAndProvidesFeedback() {
        verifySystemFeedback();
    }

    @Then("the system remains responsive and does not freeze")
    public void theSystemRemainsResponsiveAndDoesNotFreeze() {
        verifySystemResponsiveness();
    }

    @Then("the system remains stable and does not crash")
    public void theSystemRemainsStableAndDoesNotCrash() {
        verifySystemStability();
    }

    @Then("the system handles input efficiently across devices")
    public void theSystemHandlesInputEfficientlyAcrossDevices() {
        verifyCrossDeviceHandling();
    }

    @Then("the system processes full input without truncation")
    public void theSystemProcessesFullInputWithoutTruncation() {
        verifyNoInputTruncation();
    }

    @Then("the system provides appropriate feedback for input")
    public void theSystemProvidesAppropriateFeedbackForInput() {
        verifySystemFeedback();
    }

    @Then("the system logs input correctly for auditing")
    public void theSystemLogsInputCorrectlyForAuditing() {
        verifySystemLogging();
    }

    @Then("the system prevents security vulnerabilities with input")
    public void theSystemPreventsSecurityVulnerabilitiesWithInput() {
        verifySecurityHandling();
    }
}