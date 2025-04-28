package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationRetentionSteps extends MenuPage {

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

    @Then("the application should open successfully and display the home screen")
    public void theApplicationShouldOpenSuccessfully() {
        verifyHomeScreenDisplayed();
    }

    @When("the user logs in using valid user credentials")
    public void theUserLogsInUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user should be successfully logged in and the main dashboard should be displayed")
    public void theUserShouldBeLoggedIn() {
        verifyDashboardDisplayed();
    }

    @When("the user ensures location services are enabled on the device")
    public void theUserEnsuresLocationServicesEnabled() {
        verifyLocationServicesEnabled();
    }

    @Then("location services should be confirmed as enabled")
    public void locationServicesShouldBeConfirmed() {
        confirmLocationServicesEnabled();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToLocationSelectionScreen() {
        navigateToLocationSelection();
    }

    @Then("the location selection screen should be displayed with available locations")
    public void theLocationSelectionScreenShouldBeDisplayed() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user selects {string} from the list of locations")
    public void theUserSelectsLocation(String location) {
        selectLocation(location);
    }

    @Then("the location should be selected and a confirmation prompt should appear")
    public void theLocationShouldBeSelected() {
        verifyLocationSelected();
    }

    @When("the user confirms the location selection")
    public void theUserConfirmsLocationSelection() {
        confirmLocationSelection();
    }

    @Then("the system should process the selection and navigate to the Menu screen")
    public void theSystemShouldProcessSelection() {
        verifyMenuScreenDisplayed();
    }

    @When("the user verifies the Menu screen is displayed with the selected location retained")
    public void theUserVerifiesMenuScreen() {
        verifyMenuScreenWithLocation();
    }

    @Then("the Menu screen should display options specific to {string}")
    public void theMenuScreenShouldDisplayOptions(String location) {
        verifyMenuOptionsForLocation(location);
    }

    @When("the user navigates away from the Menu screen and selects a different location")
    public void theUserNavigatesAwayAndSelectsDifferentLocation() {
        changeLocation();
    }

    @Then("the system should process the new location selection")
    public void theSystemShouldProcessNewLocation() {
        verifyNewLocationProcessed();
    }

    @When("the user returns to the Menu screen and checks if the selected location is retained")
    public void theUserReturnsToMenuScreen() {
        checkLocationRetention();
    }

    @Then("the Menu screen should incorrectly display options for the previous location")
    public void theMenuScreenShouldDisplayPreviousLocationOptions() {
        verifyIncorrectLocationDisplayed();
    }

    @When("the user checks for any error messages or alerts regarding location retention")
    public void theUserChecksForErrors() {
        checkForLocationRetentionErrors();
    }

    @Then("no error messages or alerts should be displayed, indicating a failure in retention")
    public void noErrorsShouldBeDisplayed() {
        verifyNoErrorsDisplayed();
    }

    @When("the user logs out and logs back in to check if the location selection persists incorrectly")
    public void theUserLogsOutAndBackIn() {
        logoutAndLoginAgain();
    }

    @Then("upon re-login, the incorrect location should still be displayed")
    public void uponReLoginIncorrectLocationDisplayed() {
        verifyIncorrectLocationAfterReLogin();
    }

    @When("the user tests the scenario with multiple location changes to ensure consistent failure")
    public void theUserTestsMultipleLocationChanges() {
        testMultipleLocationChanges();
    }

    @Then("the system should consistently fail to retain the correct location after changes")
    public void theSystemShouldFailConsistently() {
        verifyConsistentFailure();
    }

    @When("the user verifies the system logs the incorrect location retention for audit purposes")
    public void theUserVerifiesSystemLogs() {
        verifySystemLogsForAudit();
    }

    @Then("incorrect location retention should be logged in the system for auditing")
    public void incorrectLocationRetentionLogged() {
        verifyAuditLogs();
    }

    @When("the user checks the UI/UX response to incorrect location retention")
    public void theUserChecksUIUXResponse() {
        checkUIUXResponse();
    }

    @Then("UI/UX should not indicate the incorrect retention, leading to user confusion")
    public void uiuxShouldNotIndicateIncorrectRetention() {
        verifyUIUXConfusion();
    }

    @When("the user attempts to manually reset the location and verifies the system's response")
    public void theUserAttemptsManualReset() {
        attemptManualReset();
    }

    @Then("manual reset should allow the correct location to be selected and retained")
    public void manualResetShouldAllowCorrectLocation() {
        verifyManualResetSuccess();
    }
}