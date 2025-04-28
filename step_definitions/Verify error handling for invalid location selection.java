package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationErrorHandlingSteps extends LocationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application with username {string} and password {string}")
    public void theUserIsLoggedIntoTheApplication(String username, String password) {
        login(username, password);
    }

    @Given("location services are enabled on the device")
    public void locationServicesAreEnabledOnTheDevice() {
        enableLocationServices();
    }

    @When("the user launches the application on a supported device")
    public void theUserLaunchesTheApplication() {
        launchApplication();
    }

    @Then("the application opens successfully and displays the home screen")
    public void theApplicationOpensSuccessfully() {
        verifyHomeScreenDisplayed();
    }

    @Given("the user is on the login screen")
    public void theUserIsOnTheLoginScreen() {
        navigateToLoginScreen();
    }

    @When("the user logs in using valid credentials")
    public void theUserLogsInUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user is successfully logged in and the main dashboard is displayed")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyMainDashboardDisplayed();
    }

    @Given("the user is on the main dashboard")
    public void theUserIsOnTheMainDashboard() {
        verifyMainDashboardDisplayed();
    }

    @When("the user ensures location services are enabled on the device")
    public void theUserEnsuresLocationServicesEnabled() {
        confirmLocationServicesEnabled();
    }

    @Then("location services are confirmed as enabled")
    public void locationServicesConfirmedAsEnabled() {
        verifyLocationServicesEnabled();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToLocationSelectionScreen() {
        navigateToLocationSelectionScreen();
    }

    @Then("the location selection screen is displayed with available locations")
    public void locationSelectionScreenDisplayed() {
        verifyLocationSelectionScreenDisplayed();
    }

    @Given("the user is on the location selection screen")
    public void theUserIsOnTheLocationSelectionScreen() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user attempts to select an invalid location {string}")
    public void theUserAttemptsToSelectAnInvalidLocation(String location) {
        selectInvalidLocation(location);
    }

    @Then("the system displays an error message indicating the location is invalid")
    public void systemDisplaysErrorMessage() {
        verifyInvalidLocationErrorMessage();
    }

    @Given("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @When("the user checks the error message details")
    public void theUserChecksErrorMessageDetails() {
        checkErrorMessageDetails();
    }

    @Then("the error message provides clear guidance on selecting a valid location")
    public void errorMessageProvidesGuidance() {
        verifyErrorMessageGuidance();
    }

    @When("the user attempts to proceed to the Menu screen despite the error")
    public void theUserAttemptsToProceedDespiteError() {
        attemptNavigationToMenuScreen();
    }

    @Then("the system prevents navigation to the Menu screen and re-prompts for a valid location")
    public void systemPreventsNavigation() {
        verifyNavigationPrevention();
    }

    @Given("the user is re-prompted for a valid location")
    public void theUserIsRePromptedForValidLocation() {
        verifyRePromptForValidLocation();
    }

    @When("the user selects a valid location")
    public void theUserSelectsAValidLocation() {
        selectValidLocation();
    }

    @Then("the system accepts the valid location and navigates to the Menu screen")
    public void systemAcceptsValidLocation() {
        verifyNavigationToMenuScreen();
    }

    @Given("the user is on the Menu screen")
    public void theUserIsOnTheMenuScreen() {
        verifyMenuScreenDisplayed();
    }

    @When("the user checks for any residual error messages or alerts")
    public void theUserChecksForResidualErrors() {
        checkForResidualErrors();
    }

    @Then("no residual error messages or alerts are displayed")
    public void noResidualErrorsDisplayed() {
        verifyNoResidualErrors();
    }

    @When("the user verifies the Menu screen displays options for the newly selected valid location")
    public void theUserVerifiesMenuScreenOptions() {
        verifyMenuScreenOptions();
    }

    @Then("the Menu screen displays options relevant to the valid location")
    public void menuScreenDisplaysRelevantOptions() {
        verifyRelevantMenuOptions();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("upon re-login, the valid location is retained without error")
    public void validLocationRetained() {
        verifyLocationRetention();
    }

    @When("the user tests the scenario with multiple invalid locations")
    public void theUserTestsMultipleInvalidLocations() {
        testMultipleInvalidLocations();
    }

    @Then("the system consistently handles errors for different invalid locations")
    public void systemHandlesErrorsConsistently() {
        verifyConsistentErrorHandling();
    }

    @When("the user checks if the error message is logged for audit purposes")
    public void theUserChecksErrorMessageLogging() {
        checkErrorMessageLogging();
    }

    @Then("the error message is logged in the system for auditing")
    public void errorMessageLoggedForAuditing() {
        verifyErrorMessageLogged();
    }

    @When("the user verifies the error message adheres to the UI/UX guidelines")
    public void theUserVerifiesErrorMessageUIUX() {
        verifyErrorMessageUIUX();
    }

    @Then("the error message design is consistent with UI/UX standards")
    public void errorMessageDesignConsistent() {
        verifyErrorMessageDesignConsistency();
    }

    @When("the user attempts to select a location with special characters or numbers")
    public void theUserAttemptsToSelectLocationWithSpecialCharacters() {
        selectLocationWithSpecialCharacters();
    }

    @Then("the system displays an error for invalid characters and prompts for a valid selection")
    public void systemDisplaysErrorForInvalidCharacters() {
        verifyInvalidCharacterError();
    }
}