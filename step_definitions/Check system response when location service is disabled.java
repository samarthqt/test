package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationServiceSteps extends LocationServicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginWithValidCredentials();
    }

    @When("the user launches the application and logs in using valid credentials")
    public void theUserLaunchesTheApplicationAndLogsInUsingValidCredentials() {
        launchApplication();
        loginWithValidCredentials();
    }

    @Then("the user is logged into the application successfully")
    public void theUserIsLoggedIntoTheApplicationSuccessfully() {
        verifyLoginSuccess();
    }

    @Given("location services are enabled")
    public void locationServicesAreEnabled() {
        enableLocationServices();
    }

    @When("the user disables location services from the device settings")
    public void theUserDisablesLocationServicesFromTheDeviceSettings() {
        disableLocationServices();
    }

    @Then("location services are disabled")
    public void locationServicesAreDisabled() {
        verifyLocationServicesDisabled();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToTheLocationSelectionScreen() {
        navigateToLocationSelectionScreen();
    }

    @Then("the location selection screen is displayed")
    public void theLocationSelectionScreenIsDisplayed() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user attempts to select a location from the list")
    public void theUserAttemptsToSelectALocationFromTheList() {
        attemptToSelectLocation();
    }

    @Then("the system prompts the user to enable location services")
    public void theSystemPromptsTheUserToEnableLocationServices() {
        verifyPromptToEnableLocationServices();
    }

    @When("the user receives an error message after attempting to select a location")
    public void theUserReceivesAnErrorMessageAfterAttemptingToSelectALocation() {
        receiveErrorMessage();
    }

    @Then("the error message content and format should be clear and informative")
    public void theErrorMessageContentAndFormatShouldBeClearAndInformative() {
        verifyErrorMessageContentAndFormat();
    }

    @When("the user enables location services and selects a location again")
    public void theUserEnablesLocationServicesAndSelectsALocationAgain() {
        enableLocationServices();
        selectLocationAgain();
    }

    @Then("the menu screen is displayed for the selected location")
    public void theMenuScreenIsDisplayedForTheSelectedLocation() {
        verifyMenuScreenDisplayed();
    }

    @When("the user disables location services and attempts to navigate to the Menu screen directly")
    public void theUserDisablesLocationServicesAndAttemptsToNavigateToTheMenuScreenDirectly() {
        disableLocationServices();
        attemptToNavigateToMenuScreen();
    }

    @When("the user checks system logs for any errors related to location services")
    public void theUserChecksSystemLogsForAnyErrorsRelatedToLocationServices() {
        checkSystemLogsForErrors();
    }

    @Then("logs indicate location services are disabled")
    public void logsIndicateLocationServicesAreDisabled() {
        verifyLogsIndicateLocationServicesDisabled();
    }

    @When("the user verifies system stability and performance when location services are disabled")
    public void theUserVerifiesSystemStabilityAndPerformanceWhenLocationServicesAreDisabled() {
        verifySystemStabilityAndPerformance();
    }

    @Then("the system remains stable and responsive")
    public void theSystemRemainsStableAndResponsive() {
        verifySystemStability();
    }

    @When("the user attempts to perform other actions within the app with location services disabled")
    public void theUserAttemptsToPerformOtherActionsWithinTheAppWithLocationServicesDisabled() {
        performOtherActions();
    }

    @Then("other actions are unaffected by location services status")
    public void otherActionsAreUnaffectedByLocationServicesStatus() {
        verifyOtherActionsUnaffected();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user repeats the test with a different user account")
    public void theUserRepeatsTheTestWithADifferentUserAccount() {
        repeatTestWithDifferentAccount();
    }

    @Then("the system behaves consistently across different user accounts")
    public void theSystemBehavesConsistentlyAcrossDifferentUserAccounts() {
        verifyConsistentBehaviorAcrossAccounts();
    }

    @When("the user checks for any error messages or logs generated during location service disablement")
    public void theUserChecksForAnyErrorMessagesOrLogsGeneratedDuringLocationServiceDisablement() {
        checkForUnexpectedErrorMessagesOrLogs();
    }

    @Then("no unexpected error messages or logs are generated")
    public void noUnexpectedErrorMessagesOrLogsAreGenerated() {
        verifyNoUnexpectedErrorMessagesOrLogs();
    }

    @When("the user attempts to access location-dependent features with disabled location services")
    public void theUserAttemptsToAccessLocationDependentFeaturesWithDisabledLocationServices() {
        accessLocationDependentFeatures();
    }

    @Then("the system correctly prompts the user to enable location services")
    public void theSystemCorrectlyPromptsTheUserToEnableLocationServices() {
        verifyCorrectPromptForLocationServices();
    }

    @When("the user re-enables location services")
    public void theUserReEnablesLocationServices() {
        reEnableLocationServices();
    }

    @Then("the system recovers and functions normally with location services enabled")
    public void theSystemRecoversAndFunctionsNormallyWithLocationServicesEnabled() {
        verifySystemRecoveryWithLocationServicesEnabled();
    }
}