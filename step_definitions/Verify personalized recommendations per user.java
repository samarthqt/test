package com.cucumber.steps;

import com.page_objects.RecommendationsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecommendationsSteps extends RecommendationsPage {

    @Given("User ID {int} is logged in")
    public void userIsLoggedIn(int userId) {
        loginUser(userId);
    }

    @Given("a user is logged in")
    public void aUserIsLoggedIn() {
        loginUser();
    }

    @Given("User ID {int} has cleared browsing history")
    public void userHasClearedBrowsingHistory(int userId) {
        clearBrowsingHistory(userId);
    }

    @Given("a new user account is created")
    public void aNewUserAccountIsCreated() {
        createNewUserAccount();
    }

    @Given("a user is logged in on multiple devices")
    public void aUserIsLoggedInOnMultipleDevices() {
        loginUserOnMultipleDevices();
    }

    @Given("multiple users are logged in simultaneously")
    public void multipleUsersAreLoggedInSimultaneously() {
        loginMultipleUsersSimultaneously();
    }

    @Given("the system is experiencing peak usage")
    public void theSystemIsExperiencingPeakUsage() {
        simulatePeakUsage();
    }

    @Given("a user has a large dataset")
    public void aUserHasALargeDataset() {
        prepareLargeDataset();
    }

    @When("the user navigates to the recommendations section")
    public void theUserNavigatesToTheRecommendationsSection() {
        navigateToRecommendationsSection();
    }

    @When("the user refreshes the recommendations section")
    public void theUserRefreshesTheRecommendationsSection() {
        refreshRecommendationsSection();
    }

    @When("the user provides feedback on recommendations")
    public void theUserProvidesFeedbackOnRecommendations() {
        provideFeedbackOnRecommendations();
    }

    @When("the user checks recommendations on each device")
    public void theUserChecksRecommendationsOnEachDevice() {
        checkRecommendationsOnEachDevice();
    }

    @When("each user checks their recommendations")
    public void eachUserChecksTheirRecommendations() {
        checkRecommendationsForAllUsers();
    }

    @When("the user checks recommendations")
    public void theUserChecksRecommendations() {
        checkRecommendations();
    }

    @When("the user logs in and checks recommendations")
    public void theUserLogsInAndChecksRecommendations() {
        loginAndCheckRecommendations();
    }

    @When("users check their recommendations")
    public void usersCheckTheirRecommendations() {
        checkRecommendationsDuringPeakUsage();
    }

    @Then("user-specific recommendations for User ID {int} are displayed")
    public void userSpecificRecommendationsAreDisplayed(int userId) {
        verifyUserSpecificRecommendations(userId);
    }

    @Then("user-specific recommendations for User ID {int} are displayed, different from User ID {int}")
    public void userSpecificRecommendationsAreDisplayedDifferentFromOtherUser(int userId, int otherUserId) {
        verifyRecommendationsDifferentFromOtherUser(userId, otherUserId);
    }

    @Then("recommendations reflect the browsing history and preferences of the logged-in user")
    public void recommendationsReflectBrowsingHistoryAndPreferences() {
        verifyRecommendationsReflectBrowsingHistory();
    }

    @Then("user-specific recommendations are maintained")
    public void userSpecificRecommendationsAreMaintained() {
        verifyRecommendationsMaintainedAfterRefresh();
    }

    @Then("feedback influences recommendations for User ID {int} only")
    public void feedbackInfluencesRecommendationsForUserOnly(int userId) {
        verifyFeedbackInfluencesRecommendations(userId);
    }

    @Then("recommendations remain personalized and consistent across different devices")
    public void recommendationsRemainPersonalizedAndConsistentAcrossDevices() {
        verifyRecommendationsConsistencyAcrossDevices();
    }

    @Then("each account receives personalized recommendations without cross-account influence")
    public void eachAccountReceivesPersonalizedRecommendations() {
        verifyNoCrossAccountInfluence();
    }

    @Then("recommendations become more generic but remain unique to User ID {int}")
    public void recommendationsBecomeMoreGenericButRemainUnique(int userId) {
        verifyGenericRecommendationsUniqueToUser(userId);
    }

    @Then("no system errors occur during personalization")
    public void noSystemErrorsOccurDuringPersonalization() {
        verifyNoSystemErrorsDuringPersonalization();
    }

    @Then("recommendations are personalized even for new users")
    public void recommendationsArePersonalizedEvenForNewUsers() {
        verifyPersonalizedRecommendationsForNewUsers();
    }

    @Then("feedback submission is smooth and consistent with desktop experience")
    public void feedbackSubmissionIsSmoothAndConsistent() {
        verifyFeedbackSubmissionConsistency();
    }

    @Then("the system consistently provides personalized recommendations")
    public void theSystemConsistentlyProvidesPersonalizedRecommendations() {
        verifyConsistentRecommendationsDuringPeakUsage();
    }

    @Then("the system efficiently handles large datasets and maintains personalized recommendations")
    public void theSystemEfficientlyHandlesLargeDatasets() {
        verifyEfficientHandlingOfLargeDatasets();
    }
}