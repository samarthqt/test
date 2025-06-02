package com.cucumber.steps;

import com.page_objects.ResponsivenessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResponsivenessSteps extends ResponsivenessPage {

    @Given("the application is installed on an iOS device")
    public void theApplicationIsInstalledOnAnIOSDevice() {
        installApplicationOnIOS();
    }

    @When("the application is opened")
    public void theApplicationIsOpened() {
        openApplication();
    }

    @Then("the application opens successfully on the iOS device")
    public void theApplicationOpensSuccessfullyOnTheIOSDevice() {
        verifyApplicationOpenedSuccessfully("iOS");
    }

    @Given("the application is opened on an iOS device")
    public void theApplicationIsOpenedOnAnIOSDevice() {
        openApplicationOnIOS();
    }

    @When("navigating through different sections of the application")
    public void navigatingThroughDifferentSectionsOfTheApplication() {
        navigateThroughSections();
    }

    @Then("navigation through sections is smooth and responsive")
    public void navigationThroughSectionsIsSmoothAndResponsive() {
        verifySmoothNavigation("iOS");
    }

    @When("checking the application layout on small screen size")
    public void checkingTheApplicationLayoutOnSmallScreenSize() {
        checkLayoutOnSmallScreen();
    }

    @Then("the application layout adjusts correctly on small screen size")
    public void theApplicationLayoutAdjustsCorrectlyOnSmallScreenSize() {
        verifyLayoutAdjustment("small", "iOS");
    }

    @When("checking the application layout on medium screen size")
    public void checkingTheApplicationLayoutOnMediumScreenSize() {
        checkLayoutOnMediumScreen();
    }

    @Then("the application layout adjusts correctly on medium screen size")
    public void theApplicationLayoutAdjustsCorrectlyOnMediumScreenSize() {
        verifyLayoutAdjustment("medium", "iOS");
    }

    @When("checking the application layout on large screen size")
    public void checkingTheApplicationLayoutOnLargeScreenSize() {
        checkLayoutOnLargeScreen();
    }

    @Then("the application layout adjusts correctly on large screen size")
    public void theApplicationLayoutAdjustsCorrectlyOnLargeScreenSize() {
        verifyLayoutAdjustment("large", "iOS");
    }

    @Given("the application is installed on an Android device")
    public void theApplicationIsInstalledOnAnAndroidDevice() {
        installApplicationOnAndroid();
    }

    @Then("the application opens successfully on the Android device")
    public void theApplicationOpensSuccessfullyOnTheAndroidDevice() {
        verifyApplicationOpenedSuccessfully("Android");
    }

    @Given("the application is opened on an Android device")
    public void theApplicationIsOpenedOnAnAndroidDevice() {
        openApplicationOnAndroid();
    }

    @Then("navigation through sections is smooth and responsive on Android")
    public void navigationThroughSectionsIsSmoothAndResponsiveOnAndroid() {
        verifySmoothNavigation("Android");
    }

    @Then("the application layout adjusts correctly on small screen size on Android")
    public void theApplicationLayoutAdjustsCorrectlyOnSmallScreenSizeOnAndroid() {
        verifyLayoutAdjustment("small", "Android");
    }

    @Then("the application layout adjusts correctly on medium screen size on Android")
    public void theApplicationLayoutAdjustsCorrectlyOnMediumScreenSizeOnAndroid() {
        verifyLayoutAdjustment("medium", "Android");
    }

    @Then("the application layout adjusts correctly on large screen size on Android")
    public void theApplicationLayoutAdjustsCorrectlyOnLargeScreenSizeOnAndroid() {
        verifyLayoutAdjustment("large", "Android");
    }

    @Given("the application is opened on a mobile device")
    public void theApplicationIsOpenedOnAMobileDevice() {
        openApplicationOnMobileDevice();
    }

    @When("testing responsiveness of interactive elements like buttons and menus")
    public void testingResponsivenessOfInteractiveElementsLikeButtonsAndMenus() {
        testInteractiveElements();
    }

    @Then("interactive elements respond correctly on all devices")
    public void interactiveElementsRespondCorrectlyOnAllDevices() {
        verifyInteractiveElementsResponse();
    }

    @When("checking the application performance during network fluctuations")
    public void checkingTheApplicationPerformanceDuringNetworkFluctuations() {
        testPerformanceDuringNetworkFluctuations();
    }

    @Then("application performance remains stable during network fluctuations")
    public void applicationPerformanceRemainsStableDuringNetworkFluctuations() {
        verifyPerformanceStability();
    }

    @When("verifying touch gestures like swipe, pinch, and zoom")
    public void verifyingTouchGesturesLikeSwipePinchAndZoom() {
        testTouchGestures();
    }

    @Then("touch gestures work correctly across all devices")
    public void touchGesturesWorkCorrectlyAcrossAllDevices() {
        verifyTouchGestures();
    }

    @When("testing application loading speed on mobile data")
    public void testingApplicationLoadingSpeedOnMobileData() {
        testLoadingSpeedOnMobileData();
    }

    @Then("the application loads within acceptable time on mobile data")
    public void theApplicationLoadsWithinAcceptableTimeOnMobileData() {
        verifyLoadingSpeed();
    }

    @When("checking application behavior on device rotation")
    public void checkingApplicationBehaviorOnDeviceRotation() {
        testBehaviorOnDeviceRotation();
    }

    @Then("the application adjusts layout correctly on device rotation")
    public void theApplicationAdjustsLayoutCorrectlyOnDeviceRotation() {
        verifyLayoutOnRotation();
    }
}