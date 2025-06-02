package com.cucumber.steps;

import com.page_objects.UILayoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UILayoutSteps extends UILayoutPage {

    @Given("the application is accessed on a desktop device")
    public void theApplicationIsAccessedOnADesktopDevice() {
        accessApplicationOnDevice("desktop");
    }

    @Then("the user interface should be clear and logical on desktop")
    public void theUserInterfaceShouldBeClearAndLogicalOnDesktop() {
        verifyUILayout("desktop");
    }

    @Given("the application is accessed on a tablet device")
    public void theApplicationIsAccessedOnATabletDevice() {
        accessApplicationOnDevice("tablet");
    }

    @Then("the user interface should be clear and logical on tablet")
    public void theUserInterfaceShouldBeClearAndLogicalOnTablet() {
        verifyUILayout("tablet");
    }

    @Given("the application is accessed on a mobile device")
    public void theApplicationIsAccessedOnAMobileDevice() {
        accessApplicationOnDevice("mobile");
    }

    @Then("the user interface should be clear and logical on mobile")
    public void theUserInterfaceShouldBeClearAndLogicalOnMobile() {
        verifyUILayout("mobile");
    }

    @Given("the application is accessed on Chrome, Firefox, and Safari")
    public void theApplicationIsAccessedOnChromeFirefoxAndSafari() {
        accessApplicationOnBrowsers();
    }

    @Then("the UI should remain consistent across these browsers")
    public void theUIShouldRemainConsistentAcrossTheseBrowsers() {
        verifyUIConsistencyAcrossBrowsers();
    }

    @Given("the application is viewed on screen resolutions 1920x1080, 1280x720, and 800x600")
    public void theApplicationIsViewedOnScreenResolutions() {
        viewApplicationOnScreenResolutions();
    }

    @Then("the UI should adapt seamlessly to these screen resolutions")
    public void theUIShouldAdaptSeamlesslyToTheseScreenResolutions() {
        verifyUIAdaptabilityToResolutions();
    }

    @Given("the application is accessed on desktop, tablet, and mobile devices")
    public void theApplicationIsAccessedOnDesktopTabletAndMobileDevices() {
        accessApplicationOnAllDevices();
    }

    @Then("navigation elements should be accessible and functional on all devices")
    public void navigationElementsShouldBeAccessibleAndFunctionalOnAllDevices() {
        verifyNavigationElementsFunctionality();
    }

    @Given("the application is viewed on different screen sizes")
    public void theApplicationIsViewedOnDifferentScreenSizes() {
        viewApplicationOnDifferentScreenSizes();
    }

    @Then("text should be readable and appropriately sized on all screen sizes")
    public void textShouldBeReadableAndAppropriatelySizedOnAllScreenSizes() {
        verifyTextReadability();
    }

    @Then("images should render correctly and align well on all devices")
    public void imagesShouldRenderCorrectlyAndAlignWellOnAllDevices() {
        verifyImageRenderingAndAlignment();
    }

    @Then("buttons should function correctly and be well-placed on all devices")
    public void buttonsShouldFunctionCorrectlyAndBeWellPlacedOnAllDevices() {
        verifyButtonFunctionalityAndPlacement();
    }

    @Then("form inputs should be responsive and easy to use on all devices")
    public void formInputsShouldBeResponsiveAndEasyToUseOnAllDevices() {
        verifyFormInputResponsiveness();
    }

    @Then("no elements or text should overlap on any device")
    public void noElementsOrTextShouldOverlapOnAnyDevice() {
        verifyNoOverlappingElements();
    }

    @Then("the UI should be aesthetically appealing and user-friendly")
    public void theUIShouldBeAestheticallyAppealingAndUserFriendly() {
        verifyUIAestheticAppeal();
    }

    @Then("accessibility features should work correctly on all devices")
    public void accessibilityFeaturesShouldWorkCorrectlyOnAllDevices() {
        verifyAccessibilityFeatures();
    }

    @Given("the application is accessed on devices capable of rotation")
    public void theApplicationIsAccessedOnDevicesCapableOfRotation() {
        accessApplicationOnRotatableDevices();
    }

    @When("the device is rotated")
    public void theDeviceIsRotated() {
        rotateDevice();
    }

    @Then("the UI should adjust appropriately during device rotation")
    public void theUIShouldAdjustAppropriatelyDuringDeviceRotation() {
        verifyUIAdjustmentOnRotation();
    }

    @Then("interactive elements should respond correctly on all devices")
    public void interactiveElementsShouldRespondCorrectlyOnAllDevices() {
        verifyInteractiveElementsResponse();
    }
}