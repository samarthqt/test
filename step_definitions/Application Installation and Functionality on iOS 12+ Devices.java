package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ApplicationPage;

public class ApplicationSteps extends ApplicationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is available for download in the App Store")
    public void theApplicationIsAvailableForDownloadInTheAppStore() {
        verifyAppAvailability();
    }

    @When("the user downloads the application on iPhone 8 with iOS 12")
    public void theUserDownloadsTheApplicationOnIPhone8WithIOS12() {
        downloadApplication("iPhone 8", "iOS 12");
    }

    @Then("the application downloads successfully")
    public void theApplicationDownloadsSuccessfully() {
        verifyDownloadSuccess();
    }

    @Given("the application is downloaded on iPhone 11 with iOS 14")
    public void theApplicationIsDownloadedOnIPhone11WithIOS14() {
        verifyDownload("iPhone 11", "iOS 14");
    }

    @When("the user installs and opens the application")
    public void theUserInstallsAndOpensTheApplication() {
        installAndOpenApplication();
    }

    @Then("the application installs and opens without errors")
    public void theApplicationInstallsAndOpensWithoutErrors() {
        verifyInstallationAndOpenSuccess();
    }

    @Given("the application is installed and opened")
    public void theApplicationIsInstalledAndOpened() {
        verifyInstallationAndOpen();
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplication() {
        navigateApplication();
    }

    @Then("basic functionalities work as expected")
    public void basicFunctionalitiesWorkAsExpected() {
        verifyBasicFunctionalities();
    }

    @Given("the application is installed")
    public void theApplicationIsInstalled() {
        verifyInstallation();
    }

    @When("the user tests the application performance")
    public void theUserTestsTheApplicationPerformance() {
        testApplicationPerformance();
    }

    @Then("the application performs efficiently without lag")
    public void theApplicationPerformsEfficientlyWithoutLag() {
        verifyPerformanceEfficiency();
    }

    @When("the user tests the application responsiveness across iOS 12+ versions")
    public void theUserTestsTheApplicationResponsivenessAcrossIOS12Versions() {
        testApplicationResponsiveness();
    }

    @Then("the application is responsive across iOS 12+ versions")
    public void theApplicationIsResponsiveAcrossIOS12Versions() {
        verifyResponsivenessAcrossVersions();
    }

    @Given("the application is being installed")
    public void theApplicationIsBeingInstalled() {
        monitorInstallationProcess();
    }

    @When("the installation process is monitored")
    public void theInstallationProcessIsMonitored() {
        checkForNotificationsDuringInstallation();
    }

    @Then("no unexpected notifications are shown")
    public void noUnexpectedNotificationsAreShown() {
        verifyNoUnexpectedNotifications();
    }

    @When("the user loads media content such as images and videos")
    public void theUserLoadsMediaContentSuchAsImagesAndVideos() {
        loadMediaContent();
    }

    @Then("media content loads without distortion or error")
    public void mediaContentLoadsWithoutDistortionOrError() {
        verifyMediaContentLoading();
    }

    @When("the user interacts with elements like sliders and dropdowns")
    public void theUserInteractsWithElementsLikeSlidersAndDropdowns() {
        interactWithInteractiveElements();
    }

    @Then("interactive elements function correctly")
    public void interactiveElementsFunctionCorrectly() {
        verifyInteractiveElementsFunctionality();
    }

    @When("the user tests accessibility features")
    public void theUserTestsAccessibilityFeatures() {
        testAccessibilityFeatures();
    }

    @Then("accessibility features are functional")
    public void accessibilityFeaturesAreFunctional() {
        verifyAccessibilityFeatures();
    }

    @When("the user tests iOS-specific functions")
    public void theUserTestsIOSSpecificFunctions() {
        testIOSSpecificFunctions();
    }

    @Then("iOS-specific functions execute correctly")
    public void iOSSpecificFunctionsExecuteCorrectly() {
        verifyIOSSpecificFunctions();
    }

    @When("the user checks for deprecated iOS features")
    public void theUserChecksForDeprecatedIOSFeatures() {
        checkForDeprecatedFeatures();
    }

    @Then("the application does not rely on deprecated features")
    public void theApplicationDoesNotRelyOnDeprecatedFeatures() {
        verifyNoDeprecatedFeatures();
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplicationAgain() {
        navigateApplication();
    }

    @Then("navigation is smooth and intuitive")
    public void navigationIsSmoothAndIntuitive() {
        verifyNavigationSmoothness();
    }

    @When("the user views the application layout on different screens")
    public void theUserViewsTheApplicationLayoutOnDifferentScreens() {
        viewApplicationLayoutOnDifferentScreens();
    }

    @Then("layout is consistent across all screens")
    public void layoutIsConsistentAcrossAllScreens() {
        verifyLayoutConsistency();
    }

    @When("the user checks for system-specific warnings or suggestions")
    public void theUserChecksForSystemSpecificWarningsOrSuggestions() {
        checkForSystemSpecificWarnings();
    }

    @Then("no system-specific warnings are shown")
    public void noSystemSpecificWarningsAreShown() {
        verifyNoSystemSpecificWarnings();
    }
}