package com.cucumber.steps;

import com.page_objects.ApplicationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationLoadSteps extends ApplicationPage {

    @Given("I open a web browser")
    public void iOpenAWebBrowser() {
        launchWebBrowser();
    }

    @When("I navigate to the application URL")
    public void iNavigateToTheApplicationURL() {
        navigateToApplicationURL();
    }

    @Then("the application URL is accessed successfully")
    public void theApplicationURLIsAccessedSuccessfully() {
        verifyURLAccess();
    }

    @Then("the application loads within 3 seconds")
    public void theApplicationLoadsWithin3Seconds() {
        verifyLoadTime(3);
    }

    @Given("I open the application on a mobile device")
    public void iOpenTheApplicationOnAMobileDevice() {
        launchMobileApplication();
    }

    @When("I access the application URL")
    public void iAccessTheApplicationURL() {
        accessApplicationURLOnMobile();
    }

    @Then("the application is accessed successfully on mobile")
    public void theApplicationIsAccessedSuccessfullyOnMobile() {
        verifyMobileURLAccess();
    }

    @Then("the application loads within 3 seconds on mobile")
    public void theApplicationLoadsWithin3SecondsOnMobile() {
        verifyMobileLoadTime(3);
    }

    @Given("the application is loaded")
    public void theApplicationIsLoaded() {
        verifyApplicationLoaded();
    }

    @Then("the application functions correctly after loading")
    public void theApplicationFunctionsCorrectlyAfterLoading() {
        verifyApplicationFunctionality();
    }

    @Then("all UI elements are displayed correctly")
    public void allUIElementsAreDisplayedCorrectly() {
        verifyUIElements();
    }

    @When("I navigate through different sections of the application")
    public void iNavigateThroughDifferentSectionsOfTheApplication() {
        navigateThroughSections();
    }

    @Then("navigation is smooth and responsive")
    public void navigationIsSmoothAndResponsive() {
        verifyNavigationSmoothness();
    }

    @When("I perform a sample transaction or task")
    public void iPerformASampleTransactionOrTask() {
        performSampleTransaction();
    }

    @Then("the transaction or task is completed successfully")
    public void theTransactionOrTaskIsCompletedSuccessfully() {
        verifyTransactionCompletion();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOut();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogOutSuccess();
    }

    @When("I log back into the application")
    public void iLogBackIntoTheApplication() {
        logBackIn();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        verifyLogInSuccess();
    }

    @Then("the application performs optimally under normal conditions")
    public void theApplicationPerformsOptimallyUnderNormalConditions() {
        verifyOptimalPerformance();
    }

    @Then("no loading errors or delays are encountered")
    public void noLoadingErrorsOrDelaysAreEncountered() {
        verifyNoLoadingErrors();
    }

    @Then("the application responds promptly to user actions")
    public void theApplicationRespondsPromptlyToUserActions() {
        verifyUserActionResponsiveness();
    }

    @Then("the application is compatible with various browsers and devices")
    public void theApplicationIsCompatibleWithVariousBrowsersAndDevices() {
        verifyCompatibility();
    }

    @Then("application updates are visible immediately")
    public void applicationUpdatesAreVisibleImmediately() {
        verifyImmediateUpdates();
    }
}