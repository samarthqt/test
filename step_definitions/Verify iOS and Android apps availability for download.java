package com.cucumber.steps;

import com.page_objects.AppStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppStoreSteps extends AppStorePage {

    @Given("I have access to the iOS App Store on an iOS device")
    public void iHaveAccessToTheIOSAppStoreOnAnIOSDevice() {
        verifyIOSAppStoreAccess();
    }

    @When("I open the iOS App Store")
    public void iOpenTheIOSAppStore() {
        openIOSAppStore();
    }

    @Then("the iOS App Store opens successfully")
    public void theIOSAppStoreOpensSuccessfully() {
        verifyIOSAppStoreOpened();
    }

    @When("I search for the application using its name")
    public void iSearchForTheApplicationUsingItsName() {
        searchApplication();
    }

    @Then("the application appears in the search results")
    public void theApplicationAppearsInTheSearchResults() {
        verifyApplicationInSearchResults();
    }

    @When("I select the application from the search results")
    public void iSelectTheApplicationFromTheSearchResults() {
        selectApplicationFromResults();
    }

    @Then("the application details page is displayed")
    public void theApplicationDetailsPageIsDisplayed() {
        verifyApplicationDetailsPage();
    }

    @Then("the download button is present and clickable")
    public void theDownloadButtonIsPresentAndClickable() {
        verifyDownloadButton();
    }

    @When("I initiate the download of the application")
    public void iInitiateTheDownloadOfTheApplication() {
        initiateDownload();
    }

    @Then("the download starts successfully without errors")
    public void theDownloadStartsSuccessfullyWithoutErrors() {
        verifyDownloadStarted();
    }

    @Then("the application installs successfully and is accessible")
    public void theApplicationInstallsSuccessfullyAndIsAccessible() {
        verifyApplicationInstalled();
    }

    @Given("I have access to the Google Play Store on an Android device")
    public void iHaveAccessToTheGooglePlayStoreOnAnAndroidDevice() {
        verifyGooglePlayStoreAccess();
    }

    @When("I open the Google Play Store")
    public void iOpenTheGooglePlayStore() {
        openGooglePlayStore();
    }

    @Then("the Google Play Store opens successfully")
    public void theGooglePlayStoreOpensSuccessfully() {
        verifyGooglePlayStoreOpened();
    }

    @Given("the application is installed on both iOS and Android devices")
    public void theApplicationIsInstalledOnBothIOSAndAndroidDevices() {
        verifyApplicationInstalledOnBothDevices();
    }

    @When("I open the application on both iOS and Android devices")
    public void iOpenTheApplicationOnBothIOSAndAndroidDevices() {
        openApplicationOnBothDevices();
    }

    @Then("the application launches successfully on both devices")
    public void theApplicationLaunchesSuccessfullyOnBothDevices() {
        verifyApplicationLaunchOnBothDevices();
    }

    @Then("the initial setup screens appear correctly")
    public void theInitialSetupScreensAppearCorrectly() {
        verifyInitialSetupScreens();
    }

    @When("I complete the initial setup process on both devices")
    public void iCompleteTheInitialSetupProcessOnBothDevices() {
        completeInitialSetupOnBothDevices();
    }

    @Then("the setup completes successfully without errors")
    public void theSetupCompletesSuccessfullyWithoutErrors() {
        verifySetupCompletion();
    }
}