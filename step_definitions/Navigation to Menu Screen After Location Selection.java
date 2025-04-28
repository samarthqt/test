package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps extends MenuPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application with username {string} and password {string}")
    public void theUserIsLoggedIntoTheApplication(String username, String password) {
        login(username, password);
    }

    @Given("location services are enabled on the device")
    public void locationServicesAreEnabled() {
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

    @Given("the user is on the home screen")
    public void theUserIsOnTheHomeScreen() {
        verifyHomeScreenDisplayed();
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
        ensureLocationServicesEnabled();
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

    @When("the user selects 'Downtown Cafe' from the list of locations")
    public void theUserSelectsDowntownCafe() {
        selectLocation("Downtown Cafe");
    }

    @Then("the location is selected, and a confirmation prompt appears")
    public void locationSelectedAndConfirmationPromptAppears() {
        verifyLocationSelectedAndPromptAppears();
    }

    @When("the user confirms the location selection")
    public void theUserConfirmsLocationSelection() {
        confirmLocationSelection();
    }

    @Then("the system processes the selection and navigates to the Menu screen")
    public void systemProcessesSelectionAndNavigatesToMenuScreen() {
        verifyNavigationToMenuScreen();
    }

    @Given("the user is on the Menu screen")
    public void theUserIsOnTheMenuScreen() {
        verifyMenuScreenDisplayed();
    }

    @Then("the Menu screen is displayed with options specific to 'Downtown Cafe'")
    public void menuScreenDisplayedWithOptions() {
        verifyMenuOptionsForLocation("Downtown Cafe");
    }

    @Then("no error messages or alerts are displayed")
    public void noErrorMessagesOrAlertsDisplayed() {
        verifyNoErrorMessagesOrAlerts();
    }

    @Then("the header shows 'Downtown Cafe'")
    public void headerShowsDowntownCafe() {
        verifyHeaderShowsLocation("Downtown Cafe");
    }

    @Then("menu items are relevant to 'Downtown Cafe'")
    public void menuItemsRelevantToLocation() {
        verifyMenuItemsForLocation("Downtown Cafe");
    }

    @Then("navigation bar options are functional and contextually relevant")
    public void navigationBarOptionsFunctional() {
        verifyNavigationBarOptions();
    }

    @When("the user attempts to navigate to another screen")
    public void theUserAttemptsToNavigateToAnotherScreen() {
        navigateToAnotherScreen();
    }

    @Then("navigation to another screen is successful without errors")
    public void navigationToAnotherScreenSuccessful() {
        verifyNavigationToAnotherScreen();
    }

    @When("the user returns to the Menu screen")
    public void theUserReturnsToTheMenuScreen() {
        returnToMenuScreen();
    }

    @Then("the Menu screen still displays options for 'Downtown Cafe'")
    public void menuScreenStillDisplaysOptions() {
        verifyMenuOptionsForLocation("Downtown Cafe");
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("upon re-login, 'Downtown Cafe' is still the selected location")
    public void uponReLoginLocationIsStillSelected() {
        verifyLocationPersistence("Downtown Cafe");
    }

    @Given("the user is on the location selection screen")
    public void theUserIsOnTheLocationSelectionScreen() {
        verifyLocationSelectionScreenDisplayed();
    }

    @When("the user repeats the test with a different location")
    public void theUserRepeatsTestWithDifferentLocation() {
        repeatTestWithDifferentLocation();
    }

    @Then("the system consistently navigates to the Menu screen for different locations")
    public void systemConsistentlyNavigatesToMenuScreen() {
        verifyConsistentNavigationToMenuScreen();
    }
}