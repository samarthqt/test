package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecommendationsPage;

public class RecommendationsSteps extends RecommendationsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with User ID: {int}")
    public void aUserAccountWithUserID(int userId) {
        loginWithUserId(userId);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        performLogin();
    }

    @Then("the user is successfully logged in and directed to the homepage")
    public void theUserIsSuccessfullyLoggedInAndDirectedToTheHomepage() {
        verifyHomePage();
    }

    @Then("the recommendations section is visible with product suggestions")
    public void theRecommendationsSectionIsVisibleWithProductSuggestions() {
        verifyRecommendationsSection();
    }

    @Given("the user is on the recommendations section")
    public void theUserIsOnTheRecommendationsSection() {
        navigateToRecommendations();
    }

    @When("the user selects a recommended product and provides feedback using the 'Like' option")
    public void theUserSelectsARecommendedProductAndProvidesFeedbackUsingTheLikeOption() {
        provideFeedback("Like");
    }

    @Then("the feedback is submitted successfully and the system acknowledges the input")
    public void theFeedbackIsSubmittedSuccessfullyAndTheSystemAcknowledgesTheInput() {
        verifyFeedbackAcknowledgement();
    }

    @When("the user selects another recommended product and provides feedback using the 'Dislike' option")
    public void theUserSelectsAnotherRecommendedProductAndProvidesFeedbackUsingTheDislikeOption() {
        provideFeedback("Dislike");
    }

    @When("the user selects a third recommended product and provides feedback using the 'Not Relevant' option")
    public void theUserSelectsAThirdRecommendedProductAndProvidesFeedbackUsingTheNotRelevantOption() {
        provideFeedback("Not Relevant");
    }

    @Given("the user has provided feedback on recommendations")
    public void theUserHasProvidedFeedbackOnRecommendations() {
        verifyFeedbackProvided();
    }

    @When("the user checks future recommendations")
    public void theUserChecksFutureRecommendations() {
        checkFutureRecommendations();
    }

    @Then("future recommendations are adjusted based on the feedback provided")
    public void futureRecommendationsAreAdjustedBasedOnTheFeedbackProvided() {
        verifyAdjustedRecommendations();
    }

    @Given("the user has logged out")
    public void theUserHasLoggedOut() {
        performLogout();
    }

    @When("the user logs in again")
    public void theUserLogsInAgain() {
        performLogin();
    }

    @Then("the feedback impact persists across sessions")
    public void theFeedbackImpactPersistsAcrossSessions() {
        verifyFeedbackPersistence();
    }

    @When("the user provides feedback on multiple recommendations quickly")
    public void theUserProvidesFeedbackOnMultipleRecommendationsQuickly() {
        provideQuickFeedback();
    }

    @Then("the system handles multiple feedback inputs without errors")
    public void theSystemHandlesMultipleFeedbackInputsWithoutErrors() {
        verifyNoErrorsOnMultipleFeedback();
    }

    @When("the user attempts to provide feedback on the same recommendation multiple times")
    public void theUserAttemptsToProvideFeedbackOnTheSameRecommendationMultipleTimes() {
        attemptDuplicateFeedback();
    }

    @Then("the system prevents duplicate feedback submissions for the same recommendation")
    public void theSystemPreventsDuplicateFeedbackSubmissionsForTheSameRecommendation() {
        verifyNoDuplicateFeedback();
    }

    @When("the user checks feedback options for all recommendations")
    public void theUserChecksFeedbackOptionsForAllRecommendations() {
        checkFeedbackOptions();
    }

    @Then("feedback options are consistently available for all recommendations")
    public void feedbackOptionsAreConsistentlyAvailableForAllRecommendations() {
        verifyFeedbackOptionsAvailability();
    }

    @When("the user interacts with the feedback interface")
    public void theUserInteractsWithTheFeedbackInterface() {
        interactWithFeedbackInterface();
    }

    @Then("the feedback interface is user-friendly and accessible")
    public void theFeedbackInterfaceIsUserFriendlyAndAccessible() {
        verifyFeedbackInterfaceAccessibility();
    }

    @When("the user submits feedback")
    public void theUserSubmitsFeedback() {
        submitFeedback();
    }

    @Then("no system errors occur during feedback submission")
    public void noSystemErrorsOccurDuringFeedbackSubmission() {
        verifyNoSystemErrors();
    }

    @Given("the user accesses the recommendations section using a mobile device")
    public void theUserAccessesTheRecommendationsSectionUsingAMobileDevice() {
        accessRecommendationsOnMobile();
    }

    @Then("feedback submission is smooth and consistent with desktop experience")
    public void feedbackSubmissionIsSmoothAndConsistentWithDesktopExperience() {
        verifyMobileFeedbackConsistency();
    }

    @Given("a new user account")
    public void aNewUserAccount() {
        createNewUserAccount();
    }

    @When("the user provides feedback on recommendations")
    public void theUserProvidesFeedbackOnRecommendations() {
        provideFeedbackOnRecommendations();
    }

    @Then("feedback influences recommendations even for new users")
    public void feedbackInfluencesRecommendationsEvenForNewUsers() {
        verifyFeedbackInfluenceForNewUsers();
    }

    @Given("the user provides conflicting feedback on similar products")
    public void theUserProvidesConflictingFeedbackOnSimilarProducts() {
        provideConflictingFeedback();
    }

    @When("the user checks the system's response")
    public void theUserChecksTheSystemsResponse() {
        checkSystemResponseToFeedback();
    }

    @Then("the system balances conflicting feedback to optimize recommendations")
    public void theSystemBalancesConflictingFeedbackToOptimizeRecommendations() {
        verifyBalancedRecommendations();
    }
}