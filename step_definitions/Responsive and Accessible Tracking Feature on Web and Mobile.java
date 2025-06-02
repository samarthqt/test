package com.cucumber.steps;

import com.page_objects.TrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TrackingFeatureSteps extends TrackingPage {

    @Given("I access the tracking feature on {string} using {string}")
    public void iAccessTheTrackingFeatureOnDeviceUsingBrowser(String device, String browser) {
        setDeviceAndBrowser(device, browser);
        openTrackingFeature();
    }

    @Then("the tracking feature should be accessible and display correctly")
    public void theTrackingFeatureShouldBeAccessibleAndDisplayCorrectly() {
        verifyTrackingFeatureAccessibility();
    }

    @Then("the tracking feature should adapt to various screen sizes")
    public void theTrackingFeatureShouldAdaptToVariousScreenSizes() {
        verifyResponsiveDesign();
    }

    @Then("accessibility features should be functional and meet standards")
    public void accessibilityFeaturesShouldBeFunctionalAndMeetStandards() {
        verifyAccessibilityFeatures();
    }

    @Given("I enter tracking number {string} on {string} using {string}")
    public void iEnterTrackingNumberOnDeviceUsingBrowser(String trackingNumber, String device, String browser) {
        setDeviceAndBrowser(device, browser);
        enterTrackingNumber(trackingNumber);
    }

    @Then("tracking information should be displayed correctly")
    public void trackingInformationShouldBeDisplayedCorrectly() {
        verifyTrackingInformationDisplay();
    }

    @Given("I simulate slow network conditions on {string} using {string}")
    public void iSimulateSlowNetworkConditionsOnDeviceUsingBrowser(String device, String browser) {
        setDeviceAndBrowser(device, browser);
        simulateSlowNetworkConditions();
    }

    @Then("tracking feature should load gracefully under slow network conditions")
    public void trackingFeatureShouldLoadGracefullyUnderSlowNetworkConditions() {
        verifyGracefulLoadingUnderSlowNetwork();
    }

    @Given("I access the tracking feature using an older version of {string} on {string}")
    public void iAccessTheTrackingFeatureUsingAnOlderVersionOfBrowserOnDevice(String browser, String device) {
        setDeviceAndOlderBrowserVersion(device, browser);
        openTrackingFeature();
    }

    @Then("the tracking feature should be compatible with older browser versions")
    public void theTrackingFeatureShouldBeCompatibleWithOlderBrowserVersions() {
        verifyCompatibilityWithOlderBrowsers();
    }

    @Given("I access the tracking feature on any device")
    public void iAccessTheTrackingFeatureOnAnyDevice() {
        openTrackingFeature();
    }

    @Then("accessibility feedback should be provided to users")
    public void accessibilityFeedbackShouldBeProvidedToUsers() {
        verifyAccessibilityFeedback();
    }

    @Given("the mobile platform experiences high load")
    public void theMobilePlatformExperiencesHighLoad() {
        simulateHighLoadOnMobilePlatform();
    }

    @Then("the system should remain responsive and accessible")
    public void theSystemShouldRemainResponsiveAndAccessible() {
        verifySystemPerformanceUnderHighLoad();
    }

    @Given("the web platform experiences high load")
    public void theWebPlatformExperiencesHighLoad() {
        simulateHighLoadOnWebPlatform();
    }
}