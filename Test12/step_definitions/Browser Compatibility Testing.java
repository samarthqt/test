package com.cucumber.steps;

import com.page_objects.BrowserCompatibilityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowserCompatibilitySteps extends BrowserCompatibilityPage {

    @Given("the application is opened in the latest version of Chrome")
    public void theApplicationIsOpenedInTheLatestVersionOfChrome() {
        openApplicationInBrowser("Chrome");
    }

    @Given("the application is opened in the latest version of Firefox")
    public void theApplicationIsOpenedInTheLatestVersionOfFirefox() {
        openApplicationInBrowser("Firefox");
    }

    @Given("the application is opened in the latest version of Safari")
    public void theApplicationIsOpenedInTheLatestVersionOfSafari() {
        openApplicationInBrowser("Safari");
    }

    @Given("the application is opened in the latest version of Edge")
    public void theApplicationIsOpenedInTheLatestVersionOfEdge() {
        openApplicationInBrowser("Edge");
    }

    @Given("a major update has been released for the application")
    public void aMajorUpdateHasBeenReleasedForTheApplication() {
        prepareForMajorUpdate();
    }

    @Given("the application is opened in different browsers")
    public void theApplicationIsOpenedInDifferentBrowsers() {
        openApplicationInAllBrowsers();
    }

    @Given("the application uses features not supported by all browsers")
    public void theApplicationUsesFeaturesNotSupportedByAllBrowsers() {
        checkUnsupportedFeatures();
    }

    @When("the user navigates through the application")
    public void theUserNavigatesThroughTheApplication() {
        navigateThroughApplication();
    }

    @When("browser compatibility tests are executed across Chrome, Firefox, Safari, and Edge")
    public void browserCompatibilityTestsAreExecutedAcrossAllBrowsers() {
        executeCompatibilityTests();
    }

    @When("the user resizes the browser window")
    public void theUserResizesTheBrowserWindow() {
        resizeBrowserWindow();
    }

    @When("a user accesses the application with a browser that does not support certain features")
    public void aUserAccessesTheApplicationWithUnsupportedBrowserFeatures() {
        accessWithUnsupportedBrowser();
    }

    @Then("the application should function correctly without any layout or functionality issues")
    public void theApplicationShouldFunctionCorrectlyWithoutAnyIssues() {
        verifyApplicationFunctionality();
    }

    @Then("the responsive design should adapt correctly to each browser's requirements")
    public void theResponsiveDesignShouldAdaptCorrectly() {
        verifyResponsiveDesign();
    }

    @Then("the application should provide appropriate fallback solutions to ensure functionality is maintained")
    public void theApplicationShouldProvideFallbackSolutions() {
        verifyFallbackSolutions();
    }
}