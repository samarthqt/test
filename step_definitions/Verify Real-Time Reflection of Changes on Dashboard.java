package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.DashboardPage;

public class DashboardSteps extends DashboardPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchUrl(getAppUrl());
        maximizeWindow();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        String userName = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    @Then("the user is successfully logged in and directed to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndDirectedToTheDashboard() {
        verifyDashboardPageRedirection();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        theUserIsOnTheLoginPage();
        theUserLogsInWithValidCredentials();
    }

    @When("the user navigates to the dashboard section")
    public void theUserNavigatesToTheDashboardSection() {
        navigateToDashboard();
    }

    @Then("the dashboard is displayed with all components visible")
    public void theDashboardIsDisplayedWithAllComponentsVisible() {
        verifyDashboardComponentsVisibility();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        theUserIsLoggedIn();
        navigateToDashboard();
    }

    @When("the user selects a component to edit")
    public void theUserSelectsAComponentToEdit() {
        selectDashboardComponent();
    }

    @Then("the component is selected and options to edit are displayed")
    public void theComponentIsSelectedAndOptionsToEditAreDisplayed() {
        verifyEditOptionsDisplayed();
    }

    @Given("the user has selected a component to edit")
    public void theUserHasSelectedAComponentToEdit() {
        theUserIsOnTheDashboard();
        selectDashboardComponent();
    }

    @When("the user makes changes to the component \(e.g., update data, add widget\)")
    public void theUserMakesChangesToTheComponent() {
        makeChangesToComponent();
    }

    @Then("the changes are made successfully with no errors")
    public void theChangesAreMadeSuccessfullyWithNoErrors() {
        verifyChangesMadeSuccessfully();
    }

    @Given("changes have been made to a dashboard component")
    public void changesHaveBeenMadeToADashboardComponent() {
        theUserHasSelectedAComponentToEdit();
        makeChangesToComponent();
    }

    @When("the user saves the changes")
    public void theUserSavesTheChanges() {
        saveComponentChanges();
    }

    @Then("the changes are saved successfully without any errors")
    public void theChangesAreSavedSuccessfullyWithoutAnyErrors() {
        verifyChangesSavedSuccessfully();
    }

    @When("the user observes the dashboard")
    public void theUserObservesTheDashboard() {
        observeDashboard();
    }

    @Then("the dashboard updates in real-time to reflect the changes made")
    public void theDashboardUpdatesInRealTimeToReflectTheChangesMade() {
        verifyRealTimeUpdates();
    }

    @When("the user refreshes the dashboard page")
    public void theUserRefreshesTheDashboardPage() {
        refreshDashboardPage();
    }

    @Then("the dashboard retains the changes after refresh")
    public void theDashboardRetainsTheChangesAfterRefresh() {
        verifyChangesRetainedAfterRefresh();
    }

    @When("the user logs out and logs back into the application")
    public void theUserLogsOutAndLogsBackIntoTheApplication() {
        logoutAndLoginAgain();
    }

    @Then("the dashboard still reflects the changes after re-login")
    public void theDashboardStillReflectsTheChangesAfterReLogin() {
        verifyChangesAfterReLogin();
    }

    @When("the user checks the dashboard on a different device\/browser")
    public void theUserChecksTheDashboardOnADifferentDeviceBrowser() {
        checkDashboardOnDifferentDevice();
    }

    @Then("the changes are visible across different devices\/browsers in real-time")
    public void theChangesAreVisibleAcrossDifferentDevicesBrowsersInRealTime() {
        verifyChangesAcrossDevices();
    }

    @Given("the user is logged in on two different devices")
    public void theUserIsLoggedInOnTwoDifferentDevices() {
        loginOnMultipleDevices();
    }

    @When("the user makes simultaneous changes on both devices")
    public void theUserMakesSimultaneousChangesOnBothDevices() {
        makeSimultaneousChanges();
    }

    @Then("real-time sync is maintained and changes are reflected accurately")
    public void realTimeSyncIsMaintainedAndChangesAreReflectedAccurately() {
        verifyRealTimeSync();
    }

    @When("the user checks for error messages or logs")
    public void theUserChecksForErrorMessagesOrLogs() {
        checkForErrorMessages();
    }

    @Then("no error messages or logs indicate issues with real-time updates")
    public void noErrorMessagesOrLogsIndicateIssuesWithRealTimeUpdates() {
        verifyNoErrorMessages();
    }

    @Given("the dashboard is receiving multiple real-time updates")
    public void theDashboardIsReceivingMultipleRealTimeUpdates() {
        simulateMultipleRealTimeUpdates();
    }

    @When("the user observes the dashboard performance")
    public void theUserObservesTheDashboardPerformance() {
        observeDashboardPerformance();
    }

    @Then("the dashboard performance remains optimal")
    public void theDashboardPerformanceRemainsOptimal() {
        verifyOptimalPerformance();
    }

    @Given("the user wants to test different types of changes")
    public void theUserWantsToTestDifferentTypesOfChanges() {
        prepareForDifferentChanges();
    }

    @When("the user makes various changes \(e.g., data update, visual change\)")
    public void theUserMakesVariousChanges() {
        makeVariousChanges();
    }

    @Then("all types of changes are reflected in real-time without issues")
    public void allTypesOfChangesAreReflectedInRealTimeWithoutIssues() {
        verifyAllChangesReflected();
    }

    @Given("the user has a slow internet connection")
    public void theUserHasASlowInternetConnection() {
        simulateSlowInternetConnection();
    }

    @When("the user makes changes to the dashboard")
    public void theUserMakesChangesToTheDashboard() {
        makeChangesWithSlowConnection();
    }

    @Then("real-time updates are consistent even with a slow internet connection")
    public void realTimeUpdatesAreConsistentEvenWithASlowInternetConnection() {
        verifyRealTimeUpdatesWithSlowConnection();
    }

    @When("the user reverts the changes")
    public void theUserRevertsTheChanges() {
        revertDashboardChanges();
    }

    @Then("reverted changes are reflected in real-time accurately")
    public void revertedChangesAreReflectedInRealTimeAccurately() {
        verifyRevertedChanges();
    }
}