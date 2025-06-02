package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ResponsivenessPage;

public class ResponsivenessSteps extends ResponsivenessPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is deployed on the stage environment")
    public void theApplicationIsDeployedOnTheStageEnvironment() {
        launchStageEnvironment();
    }

    @When("the application is opened on a browser with a window size of 1920x1080")
    public void theApplicationIsOpenedOnABrowserWithAWindowSizeOf1920x1080() {
        setWindowSize(1920, 1080);
    }

    @Then("the application should adjust correctly to fit the window size")
    public void theApplicationShouldAdjustCorrectlyToFitTheWindowSize() {
        verifyWindowAdjustment();
    }

    @When("navigating through the homepage")
    public void navigatingThroughTheHomepage() {
        navigateHomepage();
    }

    @Then("homepage elements should not overlap or be misaligned")
    public void homepageElementsShouldNotOverlapOrBeMisaligned() {
        verifyHomepageLayout();
    }

    @When("resizing the window to 2560x1440")
    public void resizingTheWindowTo2560x1440() {
        setWindowSize(2560, 1440);
    }

    @Then("the application should adjust smoothly to the new window size")
    public void theApplicationShouldAdjustSmoothlyToTheNewWindowSize() {
        verifySmoothAdjustment();
    }

    @When("testing form submissions")
    public void testingFormSubmissions() {
        submitForm();
    }

    @Then("form fields should be aligned within the window size")
    public void formFieldsShouldBeAlignedWithinTheWindowSize() {
        verifyFormAlignment();
    }

    @When("verifying media content loading")
    public void verifyingMediaContentLoading() {
        checkMediaContent();
    }

    @Then("media content should load without distortion or error")
    public void mediaContentShouldLoadWithoutDistortionOrError() {
        verifyMediaLoading();
    }

    @When("checking interactive elements")
    public void checkingInteractiveElements() {
        testInteractiveElements();
    }

    @Then("interactive elements should function correctly within the window size")
    public void interactiveElementsShouldFunctionCorrectlyWithinTheWindowSize() {
        verifyInteractiveFunctionality();
    }

    @When("testing accessibility features")
    public void testingAccessibilityFeatures() {
        checkAccessibilityFeatures();
    }

    @Then("accessibility features should be functional")
    public void accessibilityFeaturesShouldBeFunctional() {
        verifyAccessibility();
    }

    @When("verifying CSS styles and responsive design elements")
    public void verifyingCSSStylesAndResponsiveDesignElements() {
        checkCSSAndResponsiveDesign();
    }

    @Then("CSS styles and responsive elements should adjust correctly")
    public void cssStylesAndResponsiveElementsShouldAdjustCorrectly() {
        verifyCSSAdjustment();
    }

    @When("checking for console errors during navigation")
    public void checkingForConsoleErrorsDuringNavigation() {
        checkConsoleErrors();
    }

    @Then("no critical console errors should be present")
    public void noCriticalConsoleErrorsShouldBePresent() {
        verifyNoConsoleErrors();
    }

    @When("testing application performance at maximum window size")
    public void testingApplicationPerformanceAtMaximumWindowSize() {
        testPerformance();
    }

    @Then("the application should perform efficiently without lag")
    public void theApplicationShouldPerformEfficientlyWithoutLag() {
        verifyPerformance();
    }

    @When("verifying compatibility with JavaScript functions")
    public void verifyingCompatibilityWithJavaScriptFunctions() {
        checkJavaScriptCompatibility();
    }

    @Then("JavaScript functions should execute correctly")
    public void javascriptFunctionsShouldExecuteCorrectly() {
        verifyJavaScriptExecution();
    }

    @When("checking for browser-specific warnings or suggestions")
    public void checkingForBrowserSpecificWarningsOrSuggestions() {
        checkBrowserWarnings();
    }

    @Then("no browser-specific warnings should be shown")
    public void noBrowserSpecificWarningsShouldBeShown() {
        verifyNoBrowserWarnings();
    }

    @When("testing application navigation at maximum window size")
    public void testingApplicationNavigationAtMaximumWindowSize() {
        testNavigation();
    }

    @Then("navigation should be smooth and intuitive")
    public void navigationShouldBeSmoothAndIntuitive() {
        verifyNavigation();
    }

    @When("verifying application layout across different pages")
    public void verifyingApplicationLayoutAcrossDifferentPages() {
        checkLayoutConsistency();
    }

    @Then("layout should be consistent across pages")
    public void layoutShouldBeConsistentAcrossPages() {
        verifyLayoutConsistency();
    }

    @When("checking for deprecated HTML/CSS features")
    public void checkingForDeprecatedHTMLCSSFeatures() {
        checkDeprecatedFeatures();
    }

    @Then("the application should not rely on deprecated features")
    public void theApplicationShouldNotRelyOnDeprecatedFeatures() {
        verifyNoDeprecatedFeatures();
    }
}