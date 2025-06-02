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
        launchApplication();
    }

    @When("I open the application on a browser with a window size of 800x600")
    public void iOpenTheApplicationOnABrowserWithAWindowSizeOf800x600() {
        setWindowSize(800, 600);
    }

    @Then("the application adjusts to fit the window size without distortion")
    public void theApplicationAdjustsToFitTheWindowSizeWithoutDistortion() {
        verifyWindowAdjustment();
    }

    @Given("the browser window size is 1024x768")
    public void theBrowserWindowSizeIs1024x768() {
        setWindowSize(1024, 768);
    }

    @When("I navigate through the homepage")
    public void iNavigateThroughTheHomepage() {
        navigateHomepage();
    }

    @Then("homepage elements are displayed correctly without overlapping")
    public void homepageElementsAreDisplayedCorrectlyWithoutOverlapping() {
        verifyHomepageLayout();
    }

    @Given("I have opened the application")
    public void iHaveOpenedTheApplication() {
        launchApplication();
    }

    @When("I resize the window to 1024x768")
    public void iResizeTheWindowTo1024x768() {
        setWindowSize(1024, 768);
    }

    @Then("the application adjusts to the new window size smoothly")
    public void theApplicationAdjustsToTheNewWindowSizeSmoothly() {
        verifySmoothAdjustment();
    }

    @Given("a form is available in the application")
    public void aFormIsAvailableInTheApplication() {
        locateForm();
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        submitForm();
    }

    @Then("form fields are aligned correctly within the window size")
    public void formFieldsAreAlignedCorrectlyWithinTheWindowSize() {
        verifyFormAlignment();
    }

    @Given("media content is present in the application")
    public void mediaContentIsPresentInTheApplication() {
        locateMediaContent();
    }

    @When("I load the media content")
    public void iLoadTheMediaContent() {
        loadMediaContent();
    }

    @Then("the media content loads without distortion or error")
    public void theMediaContentLoadsWithoutDistortionOrError() {
        verifyMediaContentLoading();
    }

    @Given("interactive elements are present")
    public void interactiveElementsArePresent() {
        locateInteractiveElements();
    }

    @When("I interact with sliders and dropdowns")
    public void iInteractWithSlidersAndDropdowns() {
        interactWithElements();
    }

    @Then("interactive elements function correctly within the window size")
    public void interactiveElementsFunctionCorrectlyWithinTheWindowSize() {
        verifyElementFunctionality();
    }

    @Given("the application supports accessibility features")
    public void theApplicationSupportsAccessibilityFeatures() {
        checkAccessibilitySupport();
    }

    @When("I use the application at minimum window size")
    public void iUseTheApplicationAtMinimumWindowSize() {
        setWindowSize(800, 600);
    }

    @Then("accessibility features are functional")
    public void accessibilityFeaturesAreFunctional() {
        verifyAccessibilityFeatures();
    }

    @Given("CSS styles and responsive design elements are implemented")
    public void cssStylesAndResponsiveDesignElementsAreImplemented() {
        checkCSSImplementation();
    }

    @When("I view the application")
    public void iViewTheApplication() {
        viewApplication();
    }

    @Then("CSS styles and responsive elements adjust correctly")
    public void cssStylesAndResponsiveElementsAdjustCorrectly() {
        verifyCSSAdjustment();
    }

    @Given("I am navigating through the application")
    public void iAmNavigatingThroughTheApplication() {
        navigateApplication();
    }

    @When("I check the console")
    public void iCheckTheConsole() {
        checkConsole();
    }

    @Then("no critical console errors are present")
    public void noCriticalConsoleErrorsArePresent() {
        verifyConsoleErrors();
    }

    @Given("the application is running")
    public void theApplicationIsRunning() {
        launchApplication();
    }

    @When("I use the application at minimum window size")
    public void iUseTheApplicationAtMinimumWindowSizeAgain() {
        setWindowSize(800, 600);
    }

    @Then("the application performs efficiently without lag")
    public void theApplicationPerformsEfficientlyWithoutLag() {
        verifyPerformance();
    }

    @Given("JavaScript functions are used in the application")
    public void javascriptFunctionsAreUsedInTheApplication() {
        checkJavaScriptUsage();
    }

    @When("I execute JavaScript functions")
    public void iExecuteJavaScriptFunctions() {
        executeJavaScriptFunctions();
    }

    @Then("JavaScript functions execute correctly")
    public void javascriptFunctionsExecuteCorrectly() {
        verifyJavaScriptExecution();
    }

    @Given("I am using a browser to access the application")
    public void iAmUsingABrowserToAccessTheApplication() {
        launchApplication();
    }

    @When("I check for warnings or suggestions")
    public void iCheckForWarningsOrSuggestions() {
        checkBrowserWarnings();
    }

    @Then("no browser-specific warnings are shown")
    public void noBrowserSpecificWarningsAreShown() {
        verifyBrowserWarnings();
    }

    @Given("the application is open")
    public void theApplicationIsOpen() {
        launchApplication();
    }

    @When("I navigate through the application")
    public void iNavigateThroughTheApplication() {
        navigateApplication();
    }

    @Then("navigation is smooth and intuitive")
    public void navigationIsSmoothAndIntuitive() {
        verifyNavigation();
    }

    @Given("the application has multiple pages")
    public void theApplicationHasMultiplePages() {
        checkMultiplePages();
    }

    @When("I navigate across different pages")
    public void iNavigateAcrossDifferentPages() {
        navigateAcrossPages();
    }

    @Then("layout is consistent across all pages")
    public void layoutIsConsistentAcrossAllPages() {
        verifyLayoutConsistency();
    }

    @Given("the application uses HTML/CSS")
    public void theApplicationUsesHTMLCSS() {
        checkHTMLCSSUsage();
    }

    @When("I inspect the application")
    public void iInspectTheApplication() {
        inspectApplication();
    }

    @Then("the application does not rely on deprecated features")
    public void theApplicationDoesNotRelyOnDeprecatedFeatures() {
        verifyNoDeprecatedFeatures();
    }
}