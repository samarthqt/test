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

    @Then("the application opens successfully and displays the home screen")
    public void theApplicationOpensSuccessfully() {
        verifyHomeScreenDisplayed();
    }

    @When("the user logs in using valid user credentials")
    public void theUserLogsInUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("the user is successfully logged in and the main dashboard is displayed")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyDashboardDisplayed();
    }

    @Given("the user navigates to the location selection screen")
    public void theUserNavigatesToLocationSelectionScreen() {
        navigateToLocationSelection();
    }

    @When("the user selects {string} from the list of locations")
    public void theUserSelectsLocation(String location) {
        selectLocation(location);
    }

    @Then("a confirmation prompt appears")
    public void aConfirmationPromptAppears() {
        verifyConfirmationPrompt();
    }

    @When("the user confirms the location selection")
    public void theUserConfirmsTheLocationSelection() {
        confirmLocationSelection();
    }

    @Then("the system processes the selection and navigates to the Menu screen")
    public void theSystemProcessesTheSelection() {
        verifyMenuScreenDisplayed();
    }

    @Given("the Menu screen is displayed")
    public void theMenuScreenIsDisplayed() {
        verifyMenuScreenDisplayed();
    }

    @Then("the Menu screen displays options specific to {string}")
    public void theMenuScreenDisplaysOptions(String location) {
        verifyMenuOptionsForLocation(location);
    }

    @Then("no error messages or alerts are displayed")
    public void noErrorMessagesOrAlertsAreDisplayed() {
        verifyNoErrorsOrAlerts();
    }

    @Then("the header shows {string}")
    public void theHeaderShows(String location) {
        verifyHeaderShowsLocation(location);
    }

    @Then("menu items are relevant to {string}")
    public void menuItemsAreRelevantTo(String location) {
        verifyMenuItemsForLocation(location);
    }

    @When("the user navigates away from the Menu screen and returns")
    public void theUserNavigatesAwayAndReturns() {
        navigateAwayAndReturnToMenu();
    }

    @Then("the Menu screen still displays options for {string}")
    public void theMenuScreenStillDisplaysOptions(String location) {
        verifyMenuOptionsForLocation(location);
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLoginAgain();
    }

    @Then("{string} is still the selected location")
    public void locationIsStillSelected(String location) {
        verifySelectedLocation(location);
    }

    @When("the user tests the scenario with a different location")
    public void theUserTestsWithDifferentLocation() {
        testWithDifferentLocation();
    }

    @Then("the system consistently retains the selected location for different locations")
    public void theSystemConsistentlyRetainsLocation() {
        verifyLocationRetentionConsistency();
    }

    @Then("the selected location is logged in the system for auditing")
    public void theSelectedLocationIsLogged() {
        verifyLocationLoggedForAudit();
    }

    @Then("UI/UX is consistent and adheres to design standards")
    public void uiUxIsConsistent() {
        verifyUIUXConsistency();
    }
}