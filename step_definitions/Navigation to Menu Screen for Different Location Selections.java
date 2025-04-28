package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps extends NavigationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("location services are enabled")
    public void locationServicesAreEnabled() {
        enableLocationServices();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToTheLocationSelectionScreen() {
        navigateToLocationSelectionScreen();
    }

    @Then("the location selection screen is displayed")
    public void theLocationSelectionScreenIsDisplayed() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user selects {string} from the list")
    public void theUserSelectsLocationFromTheList(String location) {
        selectLocation(location);
    }

    @Then("the Menu screen is displayed for {string}")
    public void theMenuScreenIsDisplayedForLocation(String location) {
        verifyMenuScreenDisplayed(location);
    }

    @Given("the user changes the application settings to disable location services")
    public void theUserChangesTheApplicationSettingsToDisableLocationServices() {
        disableLocationServices();
    }

    @When("the user attempts to select a location from the list")
    public void theUserAttemptsToSelectALocationFromTheList() {
        attemptToSelectLocation();
    }

    @Then("the system prompts the user to enable location services")
    public void theSystemPromptsTheUserToEnableLocationServices() {
        verifyPromptToEnableLocationServices();
    }

    @Given("location services are disabled")
    public void locationServicesAreDisabled() {
        verifyLocationServicesDisabled();
    }

    @When("the user enables location services and selects a location again")
    public void theUserEnablesLocationServicesAndSelectsALocationAgain() {
        enableLocationServices();
        selectLocationAgain();
    }

    @Then("the Menu screen is displayed for the selected location")
    public void theMenuScreenIsDisplayedForTheSelectedLocation() {
        verifyMenuScreenForSelectedLocation();
    }

    @Given("the user is on the Menu screen")
    public void theUserIsOnTheMenuScreen() {
        verifyUserOnMenuScreen();
    }

    @When("a location is selected")
    public void aLocationIsSelected() {
        selectLocation();
    }

    @Then("the Menu options are tailored to the selected location")
    public void theMenuOptionsAreTailoredToTheSelectedLocation() {
        verifyMenuOptionsForLocation();
    }

    @Given("the user is switching locations")
    public void theUserIsSwitchingLocations() {
        switchLocations();
    }

    @Then("the Menu screen loads quickly and correctly for each location")
    public void theMenuScreenLoadsQuicklyAndCorrectlyForEachLocation() {
        verifyMenuScreenLoadPerformance();
    }

    @When("the user navigates back to the location selection screen")
    public void theUserNavigatesBackToTheLocationSelectionScreen() {
        navigateBackToLocationSelectionScreen();
    }

    @Then("the user can navigate back to the location selection screen")
    public void theUserCanNavigateBackToTheLocationSelectionScreen() {
        verifyNavigationBackToLocationSelectionScreen();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @Given("a different user account is used")
    public void aDifferentUserAccountIsUsed() {
        switchUserAccount();
    }

    @When("the test is repeated")
    public void theTestIsRepeated() {
        repeatTest();
    }

    @Then("the system behaves consistently across different user accounts")
    public void theSystemBehavesConsistentlyAcrossDifferentUserAccounts() {
        verifyConsistentBehaviorAcrossAccounts();
    }

    @When("the user selects a location")
    public void theUserSelectsALocation() {
        selectLocation();
    }

    @Then("no error messages or unusual logs are generated")
    public void noErrorMessagesOrUnusualLogsAreGenerated() {
        verifyNoErrorsOrLogs();
    }
}