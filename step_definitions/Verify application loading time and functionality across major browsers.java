package com.cucumber.steps;

import com.page_objects.ApplicationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationLoadingSteps extends ApplicationPage {

    @Given("I open {string} browser")
    public void iOpenBrowser(String browserName) {
        openBrowser(browserName);
    }

    @When("I navigate to the application home page")
    public void iNavigateToTheApplicationHomePage() {
        navigateToHomePage();
    }

    @When("I start a timer as the page begins loading")
    public void iStartATimerAsThePageBeginsLoading() {
        startLoadingTimer();
    }

    @Then("the application should load within 3 seconds")
    public void theApplicationShouldLoadWithin3Seconds() {
        verifyLoadingTimeWithinLimit(3);
    }

    @Given("the application has loaded")
    public void theApplicationHasLoaded() {
        verifyApplicationLoaded();
    }

    @Then("all application features should be functional")
    public void allApplicationFeaturesShouldBeFunctional() {
        verifyApplicationFunctionality();
    }

    @Then("there should be no errors in the browser console")
    public void thereShouldBeNoErrorsInTheBrowserConsole() {
        checkBrowserConsoleForErrors();
    }

    @Then("the application layout and design should appear correctly")
    public void theApplicationLayoutAndDesignShouldAppearCorrectly() {
        verifyApplicationLayoutAndDesign();
    }

    @Given("I have slightly reduced network conditions")
    public void iHaveSlightlyReducedNetworkConditions() {
        setReducedNetworkConditions();
    }

    @Then("the application should still load within 3 seconds")
    public void theApplicationShouldStillLoadWithin3Seconds() {
        verifyLoadingTimeWithinLimit(3);
    }

    @Given("I repeatedly access the application")
    public void iRepeatedlyAccessTheApplication() {
        repeatedlyAccessApplication();
    }

    @Then("the loading time should not be affected")
    public void theLoadingTimeShouldNotBeAffected() {
        verifyConsistentLoadingTime();
    }

    @Given("it is peak hours")
    public void itIsPeakHours() {
        setPeakHours();
    }

    @Then("there should be no performance degradation")
    public void thereShouldBeNoPerformanceDegradation() {
        verifyNoPerformanceDegradation();
    }

    @Given("the application has loaded on all browsers")
    public void theApplicationHasLoadedOnAllBrowsers() {
        verifyApplicationLoadedOnAllBrowsers();
    }

    @Then("loading times should be logged accurately")
    public void loadingTimesShouldBeLoggedAccurately() {
        verifyLoadingTimesLogged();
    }

    @Given("the application has been updated")
    public void theApplicationHasBeenUpdated() {
        updateApplication();
    }

    @Then("loading times should remain consistent across updates")
    public void loadingTimesShouldRemainConsistentAcrossUpdates() {
        verifyConsistentLoadingTimesAcrossUpdates();
    }
}