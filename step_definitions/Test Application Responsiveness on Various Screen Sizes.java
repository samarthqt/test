package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import com.page_objects.ResponsivenessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResponsivenessSteps extends ResponsivenessPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have a device with screen size {int}x{int} pixels")
    public void iHaveADeviceWithScreenSizePixels(int width, int height) {
        setScreenSize(width, height);
    }

    @Given("I have opened the application on a device with screen size {int}x{int} pixels")
    public void iHaveOpenedTheApplicationOnADeviceWithScreenSizePixels(int width, int height) {
        setScreenSize(width, height);
        openApplication();
    }

    @Given("I have devices with various screen sizes")
    public void iHaveDevicesWithVariousScreenSizes() {
        setVariousScreenSizes();
    }

    @Given("I have devices with portrait and landscape orientations")
    public void iHaveDevicesWithPortraitAndLandscapeOrientations() {
        setOrientationModes();
    }

    @When("I open the application")
    public void iOpenTheApplication() {
        openApplication();
    }

    @When("I navigate through the application")
    public void iNavigateThroughTheApplication() {
        navigateApplication();
    }

    @When("I check the layout and alignment of UI elements")
    public void iCheckTheLayoutAndAlignmentOfUIElements() {
        checkLayoutAndAlignment();
    }

    @When("I check images and multimedia content")
    public void iCheckImagesAndMultimediaContent() {
        checkImagesAndMultimedia();
    }

    @When("I test interactive elements such as buttons and links")
    public void iTestInteractiveElementsSuchAsButtonsAndLinks() {
        testInteractiveElements();
    }

    @When("I scroll through the application")
    public void iScrollThroughTheApplication() {
        scrollApplication();
    }

    @When("I check font sizes and readability")
    public void iCheckFontSizesAndReadability() {
        checkFontSizesAndReadability();
    }

    @When("I identify any responsiveness issues")
    public void iIdentifyAnyResponsivenessIssues() {
        identifyResponsivenessIssues();
    }

    @When("I switch between orientations")
    public void iSwitchBetweenOrientations() {
        switchOrientation();
    }

    @Then("the application should load correctly")
    public void theApplicationShouldLoadCorrectly() {
        verifyApplicationLoad();
    }

    @Then("navigation should be smooth and all UI elements should be accessible")
    public void navigationShouldBeSmoothAndAllUIElementsShouldBeAccessible() {
        verifyNavigationSmoothness();
    }

    @Then("UI elements should be correctly aligned and not overlap")
    public void uiElementsShouldBeCorrectlyAlignedAndNotOverlap() {
        verifyUIAlignment();
    }

    @Then("they should resize appropriately to fit the screen")
    public void theyShouldResizeAppropriatelyToFitTheScreen() {
        verifyImageAndMultimediaResponsiveness();
    }

    @Then("interactive elements should be easily clickable and responsive")
    public void interactiveElementsShouldBeEasilyClickableAndResponsive() {
        verifyInteractiveElementResponsiveness();
    }

    @Then("scrolling should be smooth without any abrupt stops or jumps")
    public void scrollingShouldBeSmoothWithoutAnyAbruptStopsOrJumps() {
        verifyScrollingSmoothness();
    }

    @Then("font sizes should be consistent and text should be easily readable")
    public void fontSizesShouldBeConsistentAndTextShouldBeEasilyReadable() {
        verifyFontConsistencyAndReadability();
    }

    @Then("I should document and report them to the development team")
    public void iShouldDocumentAndReportThemToTheDevelopmentTeam() {
        documentAndReportIssues();
    }

    @Then("the application should display correctly without layout issues")
    public void theApplicationShouldDisplayCorrectlyWithoutLayoutIssues() {
        verifyOrientationAdaptability();
    }
}