package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.DevicePage;

public class DeviceSteps extends DevicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("a device with minimum supported OS version")
    public void aDeviceWithMinimumSupportedOSVersion() {
        verifyMinimumOSVersion();
    }

    @When("the device is powered on")
    public void theDeviceIsPoweredOn() {
        powerOnDevice();
    }

    @Then("the device powers on successfully")
    public void theDevicePowersOnSuccessfully() {
        verifyDevicePowerOn();
    }

    @Given("the default browser is available")
    public void theDefaultBrowserIsAvailable() {
        checkDefaultBrowserAvailability();
    }

    @When("the user navigates to the application's URL")
    public void theUserNavigatesToTheApplicationSURL() {
        navigateToApplicationURL();
    }

    @Then("the application URL is entered correctly")
    public void theApplicationURLIsEnteredCorrectly() {
        verifyApplicationURLEntry();
    }

    @When("the user attempts to load the application in the browser")
    public void theUserAttemptsToLoadTheApplicationInTheBrowser() {
        loadApplicationInBrowser();
    }

    @Then("the application loads successfully without errors")
    public void theApplicationLoadsSuccessfullyWithoutErrors() {
        verifyApplicationLoad();
    }

    @When("the user verifies the application's login screen")
    public void theUserVerifiesTheApplicationSLoginScreen() {
        verifyLoginScreen();
    }

    @Then("the login screen appears correctly")
    public void theLoginScreenAppearsCorrectly() {
        assertLoginScreenAppearance();
    }

    @When("the user enters valid user credentials to log in")
    public void theUserEntersValidUserCredentialsToLogIn() {
        enterValidUserCredentials();
    }

    @Then("the user logs in successfully without errors")
    public void theUserLogsInSuccessfullyWithoutErrors() {
        verifySuccessfulLogin();
    }

    @When("the user navigates through the application menus and features")
    public void theUserNavigatesThroughTheApplicationMenusAndFeatures() {
        navigateApplicationMenus();
    }

    @Then("the menus and features are accessible and functional")
    public void theMenusAndFeaturesAreAccessibleAndFunctional() {
        verifyMenusAndFeatures();
    }

    @When("the user performs a sample transaction within the application")
    public void theUserPerformsASampleTransactionWithinTheApplication() {
        performSampleTransaction();
    }

    @Then("the transaction completes successfully without errors")
    public void theTransactionCompletesSuccessfullyWithoutErrors() {
        verifyTransactionCompletion();
    }

    @When("the user verifies application responsiveness and speed")
    public void theUserVerifiesApplicationResponsivenessAndSpeed() {
        checkApplicationResponsiveness();
    }

    @Then("the application responds quickly and efficiently")
    public void theApplicationRespondsQuicklyAndEfficiently() {
        assertApplicationSpeed();
    }

    @When("the user checks for any OS-specific notifications or warnings")
    public void theUserChecksForAnyOSSpecificNotificationsOrWarnings() {
        checkOSSpecificNotifications();
    }

    @Then("no OS-specific notifications or warnings appear")
    public void noOSSpecificNotificationsOrWarningsAppear() {
        verifyNoOSNotifications();
    }

    @When("the user attempts to update any application settings")
    public void theUserAttemptsToUpdateAnyApplicationSettings() {
        updateApplicationSettings();
    }

    @Then("the settings update successfully without errors")
    public void theSettingsUpdateSuccessfullyWithoutErrors() {
        verifySettingsUpdate();
    }

    @When("the user logs out of the application")
    public void theUserLogsOutOfTheApplication() {
        logoutApplication();
    }

    @Then("the user logs out successfully")
    public void theUserLogsOutSuccessfully() {
        verifyLogout();
    }

    @When("the user closes the application and reopens it")
    public void theUserClosesTheApplicationAndReopensIt() {
        closeAndReopenApplication();
    }

    @Then("the application reopens successfully without errors")
    public void theApplicationReopensSuccessfullyWithoutErrors() {
        verifyApplicationReopen();
    }

    @When("the user verifies application stability over extended use")
    public void theUserVerifiesApplicationStabilityOverExtendedUse() {
        checkApplicationStability();
    }

    @Then("the application remains stable and functional")
    public void theApplicationRemainsStableAndFunctional() {
        assertApplicationStability();
    }

    @When("the user documents any issues encountered during testing")
    public void theUserDocumentsAnyIssuesEncounteredDuringTesting() {
        documentTestingIssues();
    }

    @Then("no issues are documented; application works as expected")
    public void noIssuesAreDocumentedApplicationWorksAsExpected() {
        verifyNoDocumentedIssues();
    }

    @When("the user confirms application functionality with the development team")
    public void theUserConfirmsApplicationFunctionalityWithTheDevelopmentTeam() {
        confirmFunctionalityWithDevTeam();
    }

    @Then("the development team confirms application is supported on minimum OS version")
    public void theDevelopmentTeamConfirmsApplicationIsSupportedOnMinimumOSVersion() {
        verifyDevTeamConfirmation();
    }
}