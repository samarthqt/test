package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NavigationPage;

public class NavigationSteps extends NavigationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is open")
    public void theApplicationIsOpen() {
        launchApplication();
    }

    @When("the user attempts to navigate using the label {string}")
    public void theUserAttemptsToNavigateUsingTheLabel(String label) {
        attemptNavigation(label);
    }

    @Then("an error message is displayed indicating incorrect navigation label")
    public void anErrorMessageIsDisplayedIndicatingIncorrectNavigationLabel() {
        verifyErrorMessageForIncorrectLabel();
    }

    @When("the user attempts to navigate without providing a label")
    public void theUserAttemptsToNavigateWithoutProvidingALabel() {
        attemptNavigation("");
    }

    @Then("an error message is displayed indicating missing navigation label")
    public void anErrorMessageIsDisplayedIndicatingMissingNavigationLabel() {
        verifyErrorMessageForMissingLabel();
    }

    @When("the user attempts navigation with incorrect labels")
    public void theUserAttemptsNavigationWithIncorrectLabels() {
        attemptNavigationWithIncorrectLabels();
    }

    @Then("errors related to incorrect labels are logged appropriately")
    public void errorsRelatedToIncorrectLabelsAreLoggedAppropriately() {
        verifyErrorLogsForIncorrectLabels();
    }

    @Then("the system prevents navigation and maintains stability")
    public void theSystemPreventsNavigationAndMaintainsStability() {
        verifySystemStability();
    }

    @Then("the user feedback mechanism provides helpful guidance")
    public void theUserFeedbackMechanismProvidesHelpfulGuidance() {
        verifyUserFeedbackMechanism();
    }

    @Then("the system recovers smoothly from incorrect navigation attempts")
    public void theSystemRecoversSmoothlyFromIncorrectNavigationAttempts() {
        verifySystemRecovery();
    }

    @Then("the UI remains stable and informative during incorrect navigation attempts")
    public void theUIRemainsStableAndInformativeDuringIncorrectNavigationAttempts() {
        verifyUIStability();
    }

    @When("the user attempts navigation using correct labels {string}, {string}, or {string}")
    public void theUserAttemptsNavigationUsingCorrectLabels(String label1, String label2, String label3) {
        attemptNavigationWithCorrectLabels(label1, label2, label3);
    }

    @Then("navigation functions as expected")
    public void navigationFunctionsAsExpected() {
        verifyCorrectNavigation();
    }

    @Then("the system effectively guides users to correct navigation paths")
    public void theSystemEffectivelyGuidesUsersToCorrectNavigationPaths() {
        verifyGuidanceToCorrectPaths();
    }

    @Then("error messages are clear and provide helpful information")
    public void errorMessagesAreClearAndProvideHelpfulInformation() {
        verifyErrorMessageClarity();
    }

    @When("the user attempts multiple incorrect navigation attempts")
    public void theUserAttemptsMultipleIncorrectNavigationAttempts() {
        attemptMultipleIncorrectNavigations();
    }

    @Then("the system handles these attempts without degradation")
    public void theSystemHandlesTheseAttemptsWithoutDegradation() {
        verifySystemHandlingOfMultipleAttempts();
    }

    @Then("the UI remains unchanged post-error handling")
    public void theUIRemainsUnchangedPostErrorHandling() {
        verifyUIUnchangedPostErrorHandling();
    }

    @Then("error handling is isolated and does not affect other functionalities")
    public void errorHandlingIsIsolatedAndDoesNotAffectOtherFunctionalities() {
        verifyErrorHandlingIsolation();
    }
}