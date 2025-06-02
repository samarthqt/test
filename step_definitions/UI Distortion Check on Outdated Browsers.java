package com.cucumber.steps;

import com.page_objects.UIDistortionCheckPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UIDistortionCheckSteps extends UIDistortionCheckPage {

    @Given("the application is deployed on the stage environment")
    public void theApplicationIsDeployedOnTheStageEnvironment() {
        deployApplicationOnStage();
    }

    @When("I open the application in Internet Explorer 11")
    public void iOpenTheApplicationInInternetExplorer11() {
        openApplicationInBrowser("Internet Explorer 11");
    }

    @Then("the application loads without UI distortions")
    public void theApplicationLoadsWithoutUIDistortions() {
        verifyNoUIDistortions();
    }

    @Given("the application is open in Firefox 45")
    public void theApplicationIsOpenInFirefox45() {
        openApplicationInBrowser("Firefox 45");
    }

    @When("I navigate through the homepage")
    public void iNavigateThroughTheHomepage() {
        navigateHomepage();
    }

    @Then("homepage elements are displayed correctly without overlapping")
    public void homepageElementsAreDisplayedCorrectlyWithoutOverlapping() {
        verifyHomepageElements();
    }

    @Given("the application is open in Chrome 49")
    public void theApplicationIsOpenInChrome49() {
        openApplicationInBrowser("Chrome 49");
    }

    @When("I click on various links and buttons")
    public void iClickOnVariousLinksAndButtons() {
        clickLinksAndButtons();
    }

    @Then("all links and buttons function as expected")
    public void allLinksAndButtonsFunctionAsExpected() {
        verifyLinksAndButtonsFunctionality();
    }

    @Given("the steps 1-3 are repeated using Firefox 45")
    public void theStepsAreRepeatedUsingFirefox45() {
        repeatStepsInBrowser("Firefox 45");
    }

    @Then("the application functions correctly without UI distortions")
    public void theApplicationFunctionsCorrectlyWithoutUIDistortions() {
        verifyApplicationFunctionality();
    }

    @Given("the steps 1-3 are repeated using Chrome 49")
    public void theStepsAreRepeatedUsingChrome49() {
        repeatStepsInBrowser("Chrome 49");
    }

    @Given("the application is open in an outdated browser")
    public void theApplicationIsOpenInAnOutdatedBrowser() {
        openApplicationInOutdatedBrowser();
    }

    @When("I navigate through the application")
    public void iNavigateThroughTheApplication() {
        navigateApplication();
    }

    @Then("no critical console errors are present")
    public void noCriticalConsoleErrorsArePresent() {
        verifyNoConsoleErrors();
    }

    @When("I observe the CSS styles")
    public void iObserveTheCSSStyles() {
        observeCSSStyles();
    }

    @Then("CSS styles are consistent across outdated browsers")
    public void cssStylesAreConsistentAcrossOutdatedBrowsers() {
        verifyCSSConsistency();
    }

    @When("I submit forms")
    public void iSubmitForms() {
        submitForms();
    }

    @Then("forms submit successfully without errors")
    public void formsSubmitSuccessfullyWithoutErrors() {
        verifyFormSubmission();
    }

    @When("I observe responsive design elements")
    public void iObserveResponsiveDesignElements() {
        observeResponsiveDesign();
    }

    @Then("responsive design elements adjust correctly")
    public void responsiveDesignElementsAdjustCorrectly() {
        verifyResponsiveDesignAdjustment();
    }

    @When("I load media content such as images and videos")
    public void iLoadMediaContentSuchAsImagesAndVideos() {
        loadMediaContent();
    }

    @Then("media content loads without distortion or error")
    public void mediaContentLoadsWithoutDistortionOrError() {
        verifyMediaContentLoading();
    }

    @When("I interact with elements such as sliders and dropdowns")
    public void iInteractWithElementsSuchAsSlidersAndDropdowns() {
        interactWithInteractiveElements();
    }

    @Then("interactive elements function correctly")
    public void interactiveElementsFunctionCorrectly() {
        verifyInteractiveElementsFunctionality();
    }

    @When("I check for HTML/CSS features")
    public void iCheckForHTMLCSSFeatures() {
        checkHTMLCSSFeatures();
    }

    @Then("the application does not rely on deprecated features")
    public void theApplicationDoesNotRelyOnDeprecatedFeatures() {
        verifyNoDeprecatedFeatures();
    }

    @When("I test accessibility features")
    public void iTestAccessibilityFeatures() {
        testAccessibilityFeatures();
    }

    @Then("accessibility features are functional")
    public void accessibilityFeaturesAreFunctional() {
        verifyAccessibilityFunctionality();
    }

    @When("I execute JavaScript functions")
    public void iExecuteJavaScriptFunctions() {
        executeJavaScriptFunctions();
    }

    @Then("JavaScript functions execute correctly")
    public void javascriptFunctionsExecuteCorrectly() {
        verifyJavaScriptExecution();
    }

    @When("I observe for warnings or suggestions")
    public void iObserveForWarningsOrSuggestions() {
        observeWarningsOrSuggestions();
    }

    @Then("no browser-specific warnings are shown")
    public void noBrowserSpecificWarningsAreShown() {
        verifyNoBrowserSpecificWarnings();
    }
}