package com.cucumber.steps;

import com.page_objects.ApplicationLoadTimePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationLoadTimeSteps extends ApplicationLoadTimePage {

    @Given("the application is deployed on the web platform")
    public void theApplicationIsDeployedOnTheWebPlatform() {
        deployWebPlatform();
    }

    @When("a user accesses the application using a web browser")
    public void aUserAccessesTheApplicationUsingAWebBrowser() {
        accessApplicationWebBrowser();
    }

    @Then("the application should load within 3 seconds")
    public void theApplicationShouldLoadWithin3Seconds() {
        verifyLoadTimeWithin3Seconds();
    }

    @Given("the application is deployed on the mobile platform")
    public void theApplicationIsDeployedOnTheMobilePlatform() {
        deployMobilePlatform();
    }

    @When("a user accesses the application using a mobile device")
    public void aUserAccessesTheApplicationUsingAMobileDevice() {
        accessApplicationMobileDevice();
    }

    @Given("the application is deployed on both web and mobile platforms")
    public void theApplicationIsDeployedOnBothWebAndMobilePlatforms() {
        deployBothPlatforms();
    }

    @When("a user accesses the application using {string} on {string}")
    public void aUserAccessesTheApplicationUsingDeviceOnBrowser(String device, String browser) {
        accessApplicationDeviceBrowser(device, browser);
    }

    @Given("the application load time is being monitored")
    public void theApplicationLoadTimeIsBeingMonitored() {
        monitorLoadTime();
    }

    @When("the load time exceeds 3 seconds")
    public void theLoadTimeExceeds3Seconds() {
        checkLoadTimeExceeds();
    }

    @Then("a performance optimization process should be triggered")
    public void aPerformanceOptimizationProcessShouldBeTriggered() {
        triggerPerformanceOptimization();
    }

    @Given("the application is accessed under different network conditions")
    public void theApplicationIsAccessedUnderDifferentNetworkConditions() {
        accessUnderDifferentNetworkConditions();
    }

    @When("a user accesses the application")
    public void aUserAccessesTheApplication() {
        accessApplication();
    }

    @Then("the load time should remain consistent within 3 seconds")
    public void theLoadTimeShouldRemainConsistentWithin3Seconds() {
        verifyConsistentLoadTime();
    }

    @Then("user experience should not be compromised")
    public void userExperienceShouldNotBeCompromised() {
        ensureUserExperienceNotCompromised();
    }
}