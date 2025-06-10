package com.cucumber.steps;

import com.page_objects.MobileAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileAppSteps extends MobileAppPage {

    @Given("the user has an iOS device with version 12 or higher")
    public void theUserHasAnIOSDeviceWithVersion12OrHigher() {
        verifyIOSVersion();
    }

    @When("the user installs the mobile application")
    public void theUserInstallsTheMobileApplication() {
        installApplication();
    }

    @Then("the application should install successfully")
    public void theApplicationShouldInstallSuccessfully() {
        verifyInstallationSuccess();
    }

    @Then("the application should run without issues")
    public void theApplicationShouldRunWithoutIssues() {
        verifyApplicationRuns();
    }

    @Given("the user has an Android device with version 8.0 or higher")
    public void theUserHasAnAndroidDeviceWithVersion80OrHigher() {
        verifyAndroidVersion();
    }

    @Given("the user has installed the mobile application on a supported version")
    public void theUserHasInstalledTheMobileApplicationOnASupportedVersion() {
        verifySupportedVersionInstallation();
    }

    @When("the user uses the application")
    public void theUserUsesTheApplication() {
        useApplication();
    }

    @Then("there should be no functionality issues")
    public void thereShouldBeNoFunctionalityIssues() {
        verifyNoFunctionalityIssues();
    }

    @Given("the mobile application is installed on a supported version")
    public void theMobileApplicationIsInstalledOnASupportedVersion() {
        verifySupportedVersionInstallation();
    }

    @When("a new update is available")
    public void aNewUpdateIsAvailable() {
        checkForUpdates();
    }

    @Then("the application should prompt the user to update")
    public void theApplicationShouldPromptTheUserToUpdate() {
        verifyUpdatePrompt();
    }

    @Then("the update should install successfully")
    public void theUpdateShouldInstallSuccessfully() {
        installUpdate();
    }

    @Then("the application should maintain compatibility")
    public void theApplicationShouldMaintainCompatibility() {
        verifyCompatibility();
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplication() {
        navigateApplication();
    }

    @Then("the user experience should be seamless and consistent across all supported versions")
    public void theUserExperienceShouldBeSeamlessAndConsistentAcrossAllSupportedVersions() {
        verifySeamlessExperience();
    }
}