package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationSelectionSteps extends LocationSelectionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @Given("the user is on the location selection screen")
    public void theUserIsOnTheLocationSelectionScreen() {
        navigateToLocationSelectionScreen();
    }

    @When("the user selects {string} from the list")
    public void theUserSelectsLocationFromTheList(String location) {
        selectLocation(location);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        clickCancelButton();
    }

    @Then("the location selection process is canceled")
    public void theLocationSelectionProcessIsCanceled() {
        verifyLocationSelectionCanceled();
    }

    @Then("no location is set in the system")
    public void noLocationIsSetInTheSystem() {
        verifyNoLocationSet();
    }

    @Then("the system returns to the default state or previous screen")
    public void theSystemReturnsToTheDefaultStateOrPreviousScreen() {
        verifyReturnToDefaultState();
    }

    @When("the user attempts to access the Menu screen without selecting a location")
    public void theUserAttemptsToAccessTheMenuScreenWithoutSelectingALocation() {
        attemptAccessMenuScreen();
    }

    @Then("access to the Menu screen is restricted or a prompt to select a location is shown")
    public void accessToTheMenuScreenIsRestrictedOrAPromptToSelectALocationIsShown() {
        verifyAccessRestrictionOrPrompt();
    }

    @Then("no error messages should be displayed upon cancellation")
    public void noErrorMessagesShouldBeDisplayedUponCancellation() {
        verifyNoErrorMessages();
    }

    @Then("no errors or warnings are logged in the system")
    public void noErrorsOrWarningsAreLoggedInTheSystem() {
        verifyNoErrorsLogged();
    }

    @When("the user repeats the cancellation process multiple times")
    public void theUserRepeatsTheCancellationProcessMultipleTimes() {
        repeatCancellationProcess();
    }

    @Then("the system consistently handles cancellation without errors")
    public void theSystemConsistentlyHandlesCancellationWithoutErrors() {
        verifyConsistentCancellationHandling();
    }

    @Then("the user can re-initiate location selection without issues")
    public void theUserCanReInitiateLocationSelectionWithoutIssues() {
        verifyReInitiationOfLocationSelection();
    }

    @Then("no confirmation prompt is shown unless designed to do so")
    public void noConfirmationPromptIsShownUnlessDesignedToDoSo() {
        verifyNoConfirmationPrompt();
    }

    @When("the user tests cancellation in different browsers and devices")
    public void theUserTestsCancellationInDifferentBrowsersAndDevices() {
        testCancellationAcrossPlatforms();
    }

    @Then("cancellation behaves consistently across all platforms")
    public void cancellationBehavesConsistentlyAcrossAllPlatforms() {
        verifyConsistentBehaviorAcrossPlatforms();
    }

    @Then("session data remains intact")
    public void sessionDataRemainsIntact() {
        verifySessionDataIntact();
    }

    @When("the user performs rapid consecutive cancellations")
    public void theUserPerformsRapidConsecutiveCancellations() {
        performRapidCancellations();
    }

    @Then("the system handles rapid cancellations without crashing or errors")
    public void theSystemHandlesRapidCancellationsWithoutCrashingOrErrors() {
        verifyRapidCancellationHandling();
    }

    @Then("no UI glitches or artifacts are present")
    public void noUIGlitchesOrArtifactsArePresent() {
        verifyNoUIGlitches();
    }
}