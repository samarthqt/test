package com.cucumber.steps;

import com.page_objects.FrontendPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FrontendSteps extends FrontendPage {

    @Given("a web application frontend")
    public void aWebApplicationFrontend() {
        verifyWebApplicationLoaded();
    }

    @When("the application is loaded")
    public void theApplicationIsLoaded() {
        verifyHTML5CSS3JavaScriptUtilization();
    }

    @Then("it should utilize HTML5, CSS3, and JavaScript effectively")
    public void itShouldUtilizeHTML5CSS3AndJavaScriptEffectively() {
        assertHTML5CSS3JavaScriptUtilization();
    }

    @Given("a dynamic web application")
    public void aDynamicWebApplication() {
        verifyDynamicWebApplicationLoaded();
    }

    @When("the application requires interactive features")
    public void theApplicationRequiresInteractiveFeatures() {
        verifyInteractiveFeaturesRequirement();
    }

    @Then("React.js or Angular.js should be implemented")
    public void reactJsOrAngularJsShouldBeImplemented() {
        assertReactOrAngularImplementation();
    }

    @Given("a mobile application frontend")
    public void aMobileApplicationFrontend() {
        verifyMobileApplicationLoaded();
    }

    @When("the application is developed for multiple platforms")
    public void theApplicationIsDevelopedForMultiplePlatforms() {
        verifyCrossPlatformDevelopment();
    }

    @Then("it should use React Native or Flutter for cross-platform compatibility")
    public void itShouldUseReactNativeOrFlutterForCrossPlatformCompatibility() {
        assertReactNativeOrFlutterUsage();
    }

    @Given("a frontend application")
    public void aFrontendApplication() {
        verifyFrontendApplicationLoaded();
    }

    @When("the application is accessed on various devices")
    public void theApplicationIsAccessedOnVariousDevices() {
        verifyDeviceAccess();
    }

    @Then("it should be responsive and adapt to different screen sizes")
    public void itShouldBeResponsiveAndAdaptToDifferentScreenSizes() {
        assertResponsivenessAndAdaptability();
    }

    @When("the application is loaded")
    public void theApplicationIsLoadedAgain() {
        verifyApplicationLoad();
    }

    @Then("the code should be optimized for performance ensuring quick load times")
    public void theCodeShouldBeOptimizedForPerformanceEnsuringQuickLoadTimes() {
        assertCodeOptimization();
    }

    @When("the application is developed")
    public void theApplicationIsDeveloped() {
        verifyDevelopmentProcess();
    }

    @Then("security best practices must be adhered to")
    public void securityBestPracticesMustBeAdheredTo() {
        assertSecurityBestPractices();
    }

    @When("an error occurs during user interaction")
    public void anErrorOccursDuringUserInteraction() {
        verifyErrorOccurrence();
    }

    @Then("error handling must be implemented")
    public void errorHandlingMustBeImplemented() {
        assertErrorHandlingImplementation();
    }

    @When("accessed through the latest web browsers")
    public void accessedThroughTheLatestWebBrowsers() {
        verifyBrowserAccess();
    }

    @Then("it should be compatible with them")
    public void itShouldBeCompatibleWithThem() {
        assertBrowserCompatibility();
    }

    @When("tested on both web and mobile platforms")
    public void testedOnBothWebAndMobilePlatforms() {
        verifyPlatformTesting();
    }

    @Then("functionality should be confirmed")
    public void functionalityShouldBeConfirmed() {
        assertFunctionalityConfirmation();
    }

    @Given("a frontend project")
    public void aFrontendProject() {
        verifyFrontendProjectLoaded();
    }

    @When("the project is completed")
    public void theProjectIsCompleted() {
        verifyProjectCompletion();
    }

    @Then("documentation must be provided for frontend technologies used")
    public void documentationMustBeProvidedForFrontendTechnologiesUsed() {
        assertDocumentationProvision();
    }
}