package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecommendationPage;

public class RecommendationSteps extends RecommendationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with User ID: {int}")
    public void aUserAccountWithUserID(int userId) {
        loginUser(userId);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        verifyUserLoggedIn();
    }

    @Then("the user is successfully logged in and directed to the homepage")
    public void theUserIsSuccessfullyLoggedInAndDirectedToTheHomepage() {
        verifyOnHomepage();
    }

    @When("the user navigates to the recommendations section on the homepage")
    public void theUserNavigatesToTheRecommendationsSectionOnTheHomepage() {
        navigateToRecommendations();
    }

    @Then("the recommendation section is visible with product suggestions")
    public void theRecommendationSectionIsVisibleWithProductSuggestions() {
        verifyRecommendationsVisible();
    }

    @Then("recommendations include products from Electronics, Clothing, and Home & Kitchen categories")
    public void recommendationsIncludeProductsFromElectronicsClothingAndHomeKitchenCategories() {
        verifyRecommendationsDiversity();
    }

    @Given("the user is logged in with User ID: {int}")
    public void theUserIsLoggedInWithUserID(int userId) {
        loginUser(userId);
    }

    @When("the user accesses the recommendations section")
    public void theUserAccessesTheRecommendationsSection() {
        navigateToRecommendations();
    }

    @Then("all recommended products are relevant to the user's past interactions")
    public void allRecommendedProductsAreRelevantToTheUsersPastInteractions() {
        verifyRecommendationsRelevance();
    }

    @Given("the user is logged in and viewing the recommendations section")
    public void theUserIsLoggedInAndViewingTheRecommendationsSection() {
        verifyUserLoggedIn();
        navigateToRecommendations();
    }

    @When("the user refreshes the recommendation section")
    public void theUserRefreshesTheRecommendationSection() {
        refreshRecommendations();
    }

    @Then("a new set of recommendations are displayed, maintaining diversity and relevance")
    public void aNewSetOfRecommendationsAreDisplayedMaintainingDiversityAndRelevance() {
        verifyNewRecommendations();
    }

    @Given("the user logs out and logs in with a different user account")
    public void theUserLogsOutAndLogsInWithADifferentUserAccount() {
        logoutUser();
        loginUserWithDifferentAccount();
    }

    @Then("recommendations are personalized for the new user, maintaining diversity and relevance")
    public void recommendationsArePersonalizedForTheNewUserMaintainingDiversityAndRelevance() {
        verifyPersonalizedRecommendations();
    }

    @When("the user checks for repeated recommendations")
    public void theUserChecksForRepeatedRecommendations() {
        checkForRepeatedRecommendations();
    }

    @Then("no repeated recommendations are shown in the same session")
    public void noRepeatedRecommendationsAreShownInTheSameSession() {
        verifyNoRepeatedRecommendations();
    }

    @Given("the user clears browsing history")
    public void theUserClearsBrowsingHistory() {
        clearBrowsingHistory();
    }

    @When("the user checks recommendations")
    public void theUserChecksRecommendations() {
        navigateToRecommendations();
    }

    @Then("recommendations are still diverse, but less personalized")
    public void recommendationsAreStillDiverseButLessPersonalized() {
        verifyLessPersonalizedRecommendations();
    }

    @Given("the user switches to a new device and logs in to the account")
    public void theUserSwitchesToANewDeviceAndLogsInToTheAccount() {
        switchDeviceAndLogin();
    }

    @Then("recommendations are consistent with previous device")
    public void recommendationsAreConsistentWithPreviousDevice() {
        verifyConsistentRecommendations();
    }

    @Given("the user is logged in and browsing new data")
    public void theUserIsLoggedInAndBrowsingNewData() {
        verifyUserLoggedIn();
        browseNewData();
    }

    @Then("new browsing data influences the recommendations in real-time")
    public void newBrowsingDataInfluencesTheRecommendationsInRealTime() {
        verifyRealTimeRecommendations();
    }

    @When("the user checks for system errors or delays")
    public void theUserChecksForSystemErrorsOrDelays() {
        checkForSystemErrors();
    }

    @Then("no errors or significant delays are observed in generating recommendations")
    public void noErrorsOrSignificantDelaysAreObservedInGeneratingRecommendations() {
        verifyNoSystemErrors();
    }

    @Given("the user logs in with a user account that has no browsing history")
    public void theUserLogsInWithAUserAccountThatHasNoBrowsingHistory() {
        loginUserWithNoHistory();
    }

    @Then("recommendations are generic but diverse across categories")
    public void recommendationsAreGenericButDiverseAcrossCategories() {
        verifyGenericRecommendations();
    }

    @Given("the user is logged in and viewing a recommendation")
    public void theUserIsLoggedInAndViewingARecommendation() {
        verifyUserLoggedIn();
        viewRecommendation();
    }

    @When("the user provides feedback on a recommendation")
    public void theUserProvidesFeedbackOnARecommendation() {
        provideFeedback();
    }

    @Then("providing feedback influences future recommendations positively")
    public void providingFeedbackInfluencesFutureRecommendationsPositively() {
        verifyFeedbackInfluence();
    }

    @Given("the user is logged in and browsing only one category")
    public void theUserIsLoggedInAndBrowsingOnlyOneCategory() {
        verifyUserLoggedIn();
        browseSingleCategory();
    }

    @Then("the system adjusts recommendations to reflect the user's extreme browsing behavior while maintaining some diversity")
    public void theSystemAdjustsRecommendationsToReflectTheUsersExtremeBrowsingBehaviorWhileMaintainingSomeDiversity() {
        verifyExtremeBehaviorRecommendations();
    }
}