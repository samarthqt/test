package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.DevicePage;

public class DeviceSteps extends DevicePage {

    private TestHarness testHarness = new TestHarness();

    @Given("Device {int} with screen size {double} inches and resolution {int}x{int}")
    public void deviceWithScreenSizeAndResolution(int deviceNumber, double screenSize, int width, int height) {
        setDeviceSpecifications(deviceNumber, screenSize, width, height);
    }

    @When("I launch the application")
    public void iLaunchTheApplication() {
        launchApplication();
    }

    @Then("the application UI should load correctly without any distortion")
    public void theApplicationUIShouldLoadCorrectlyWithoutAnyDistortion() {
        verifyUILoadsCorrectly();
    }

    @When("I navigate through the main menu")
    public void iNavigateThroughTheMainMenu() {
        navigateMainMenu();
    }

    @Then("all menu items should be visible and accessible")
    public void allMenuItemsShouldBeVisibleAndAccessible() {
        verifyMenuItemsVisibility();
    }

    @When("I adjust the screen brightness and contrast settings")
    public void iAdjustTheScreenBrightnessAndContrastSettings() {
        adjustScreenSettings();
    }

    @Then("UI elements should remain visible and distinguishable")
    public void uiElementsShouldRemainVisibleAndDistinguishable() {
        verifyUIElementsVisibility();
    }

    @When("I perform a swipe gesture on the main screen")
    public void iPerformASwipeGestureOnTheMainScreen() {
        performSwipeGesture();
    }

    @Then("the swipe gesture should be recognized and executed smoothly")
    public void theSwipeGestureShouldBeRecognizedAndExecutedSmoothly() {
        verifySwipeGestureExecution();
    }

    @Given("devices with extreme screen sizes and resolutions")
    public void devicesWithExtremeScreenSizesAndResolutions() {
        setExtremeDeviceSpecifications();
    }

    @When("I rotate the screen to portrait and landscape orientations")
    public void iRotateTheScreenToPortraitAndLandscapeOrientations() {
        rotateScreen();
    }

    @Then("UI should adapt without loss of functionality")
    public void uiShouldAdaptWithoutLossOfFunctionality() {
        verifyUIAdaptability();
    }

    @When("I interact with buttons, sliders, and input fields")
    public void iInteractWithButtonsSlidersAndInputFields() {
        interactWithInteractiveElements();
    }

    @Then("all interactive elements should be operable and responsive")
    public void allInteractiveElementsShouldBeOperableAndResponsive() {
        verifyInteractiveElementsFunctionality();
    }

    @When("I operate the application")
    public void iOperateTheApplication() {
        operateApplication();
    }

    @Then("the application should run smoothly without lag or crashes")
    public void theApplicationShouldRunSmoothlyWithoutLagOrCrashes() {
        verifyApplicationPerformance();
    }
}