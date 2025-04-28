package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationSelectionSteps extends LocationPage {

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
        confirmLocationServicesEnabled();
    }

    @Then("location services should be confirmed as enabled")
    public void locationServicesShouldBeConfirmed() {
        verifyLocationServicesEnabled();
    }

    @When("the user navigates to the location selection screen")
    public void theUserNavigatesToLocationSelectionScreen() {
        navigateToLocationSelection();
    }

    @Then("the location selection screen should be displayed with available locations")
    public void locationSelectionScreenShouldBeDisplayed() {
        verifyLocationSelectionScreen();
    }

    @When("the user selects a location at the boundary of service coverage {string}")
    public void theUserSelectsBoundaryLocation(String location) {
        selectBoundaryLocation(location);
    }

    @Then("the system should process the selection and attempt to navigate to the Menu screen")
    public void systemShouldProcessSelection() {
        verifyMenuScreenNavigation();
    }

    @When("the user verifies the system's response time for boundary location selection")
    public void theUserVerifiesResponseTime() {
        checkResponseTime();
    }

    @Then("the system should respond within acceptable time limits")
    public void systemShouldRespondWithinLimits() {
        verifyResponseTimeLimits();
    }

    @When("the user checks for any unusual delays or errors during navigation")
    public void theUserChecksForDelaysOrErrors() {
        checkForNavigationDelaysOrErrors();
    }

    @Then("navigation should be smooth without unusual delays or errors")
    public void navigationShouldBeSmooth() {
        verifySmoothNavigation();
    }

    @When("the user verifies the Menu screen displays options for {string}")
    public void theUserVerifiesMenuOptions(String location) {
        verifyMenuOptionsForLocation(location);
    }

    @Then("the Menu screen should display options relevant to {string}")
    public void menuScreenShouldDisplayRelevantOptions(String location) {
        verifyRelevantMenuOptions(location);
    }

    @When("the user attempts to select another boundary location immediately after")
    public void theUserSelectsAnotherBoundaryLocation() {
        selectAnotherBoundaryLocation();
    }

    @Then("the system should process the new selection and update the Menu screen accordingly")
    public void systemShouldUpdateMenuScreen() {
        verifyMenuScreenUpdate();
    }

    @When("the user checks for any system warnings or alerts when selecting boundary locations")
    public void theUserChecksForWarningsOrAlerts() {
        checkForSystemWarningsOrAlerts();
    }

    @Then("no system warnings or alerts should be displayed")
    public void noWarningsOrAlertsShouldBeDisplayed() {
        verifyNoWarningsOrAlerts();
    }

    @When("the user verifies the accuracy of location data for boundary locations")
    public void theUserVerifiesLocationDataAccuracy() {
        verifyLocationDataAccuracy();
    }

    @Then("location data should be accurate and match the selected boundary location")
    public void locationDataShouldBeAccurate() {
        verifyAccurateLocationData();
    }

    @When("the user tests the system's behavior during peak hours with boundary location selection")
    public void theUserTestsDuringPeakHours() {
        testSystemDuringPeakHours();
    }

    @Then("the system should maintain performance and accuracy during peak hours")
    public void systemShouldMaintainPerformance() {
        verifyPerformanceDuringPeakHours();
    }

    @When("the user checks if the system logs the boundary location selections for audit purposes")
    public void theUserChecksSystemLogs() {
        checkSystemLogsForAudit();
    }

    @Then("boundary location selections should be logged in the system for auditing")
    public void boundarySelectionsShouldBeLogged() {
        verifyBoundarySelectionsLogged();
    }

    @When("the user verifies the UI/UX consistency for boundary location selections")
    public void theUserVerifiesUIUXConsistency() {
        verifyUIUXConsistency();
    }

    @Then("UI/UX should be consistent and adhere to design standards")
    public void uiuxShouldBeConsistent() {
        verifyConsistentUIUX();
    }

    @When("the user tests the scenario with a boundary location that has recently changed status")
    public void theUserTestsWithChangedStatusLocation() {
        testWithChangedStatusLocation();
    }

    @Then("the system should update and reflect the current status of the boundary location")
    public void systemShouldUpdateLocationStatus() {
        verifyUpdatedLocationStatus();
    }
}