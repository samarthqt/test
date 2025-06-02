package com.cucumber.steps;

import com.page_objects.WebApplicationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebApplicationSteps extends WebApplicationPage {

    @Given("the web application is deployed using HTML5, CSS3, and JavaScript")
    public void theWebApplicationIsDeployed() {
        deployWebApplication();
    }

    @When("I open the web application in Chrome")
    public void iOpenTheWebApplicationInChrome() {
        openApplicationInBrowser("Chrome");
    }

    @Then("the application loads successfully")
    public void theApplicationLoadsSuccessfully() {
        verifyApplicationLoad();
    }

    @Given("the web application is open")
    public void theWebApplicationIsOpen() {
        verifyApplicationIsOpen();
    }

    @When("I navigate through the homepage")
    public void iNavigateThroughTheHomepage() {
        navigateHomepage();
    }

    @Then("the homepage displays correctly with all elements visible")
    public void theHomepageDisplaysCorrectly() {
        verifyHomepageDisplay();
    }

    @When("I check CSS3 animations")
    public void iCheckCSS3Animations() {
        checkCSS3Animations();
    }

    @Then("the animations play smoothly without lag")
    public void theAnimationsPlaySmoothly() {
        verifyAnimationsSmoothness();
    }

    @When("I verify HTML5 video playback")
    public void iVerifyHTML5VideoPlayback() {
        verifyVideoPlayback();
    }

    @Then("the video plays without issues")
    public void theVideoPlaysWithoutIssues() {
        verifyVideoPlaybackIssues();
    }

    @When("I test JavaScript interactivity on forms")
    public void iTestJavaScriptInteractivityOnForms() {
        testFormInteractivity();
    }

    @Then("the forms respond correctly to user inputs")
    public void theFormsRespondCorrectly() {
        verifyFormResponse();
    }

    @When("I open the web application in Firefox")
    public void iOpenTheWebApplicationInFirefox() {
        openApplicationInBrowser("Firefox");
    }

    @When("I navigate through the product page")
    public void iNavigateThroughTheProductPage() {
        navigateProductPage();
    }

    @Then("the product page displays correctly with all elements visible")
    public void theProductPageDisplaysCorrectly() {
        verifyProductPageDisplay();
    }

    @When("I check CSS3 transitions")
    public void iCheckCSS3Transitions() {
        checkCSS3Transitions();
    }

    @Then("the transitions execute smoothly")
    public void theTransitionsExecuteSmoothly() {
        verifyTransitionsSmoothness();
    }

    @When("I verify HTML5 audio playback")
    public void iVerifyHTML5AudioPlayback() {
        verifyAudioPlayback();
    }

    @Then("the audio plays without issues")
    public void theAudioPlaysWithoutIssues() {
        verifyAudioPlaybackIssues();
    }

    @When("I test JavaScript validation on checkout")
    public void iTestJavaScriptValidationOnCheckout() {
        testCheckoutValidation();
    }

    @Then("the validation works correctly, preventing incorrect submissions")
    public void theValidationWorksCorrectly() {
        verifyValidationCorrectness();
    }

    @When("I open the web application in Safari")
    public void iOpenTheWebApplicationInSafari() {
        openApplicationInBrowser("Safari");
    }

    @When("I navigate through the account settings page")
    public void iNavigateThroughTheAccountSettingsPage() {
        navigateAccountSettingsPage();
    }

    @Then("the account settings page displays correctly with all elements visible")
    public void theAccountSettingsPageDisplaysCorrectly() {
        verifyAccountSettingsPageDisplay();
    }

    @When("I check CSS3 flexbox layout")
    public void iCheckCSS3FlexboxLayout() {
        checkFlexboxLayout();
    }

    @Then("the layout adjusts correctly across different screen sizes")
    public void theLayoutAdjustsCorrectly() {
        verifyLayoutAdjustment();
    }

    @When("I verify HTML5 local storage functionality")
    public void iVerifyHTML5LocalStorageFunctionality() {
        verifyLocalStorageFunctionality();
    }

    @Then("the local storage retains data accurately")
    public void theLocalStorageRetainsDataAccurately() {
        verifyLocalStorageDataRetention();
    }

    @When("I test JavaScript event handling")
    public void iTestJavaScriptEventHandling() {
        testEventHandling();
    }

    @Then("the events trigger correctly without errors")
    public void theEventsTriggerCorrectly() {
        verifyEventTriggering();
    }
}