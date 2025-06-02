package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecommendationPage;

public class RecommendationSteps extends RecommendationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User {int} frequently purchases electronics")
    public void userFrequentlyPurchasesElectronics(int userId) {
        setUserPurchaseHistory(userId, "electronics");
    }

    @Given("User {int} browses fashion items regularly")
    public void userBrowsesFashionItemsRegularly(int userId) {
        setUserPurchaseHistory(userId, "fashion");
    }

    @Given("User {int} is interested in home appliances")
    public void userIsInterestedInHomeAppliances(int userId) {
        setUserPurchaseHistory(userId, "home appliances");
    }

    @Given("User {int}'s browsing history is modified to include fashion items")
    public void userBrowsingHistoryModifiedToIncludeFashionItems(int userId) {
        modifyUserBrowsingHistory(userId, "fashion");
    }

    @Given("User {int}'s browsing history is modified to include electronics")
    public void userBrowsingHistoryModifiedToIncludeElectronics(int userId) {
        modifyUserBrowsingHistory(userId, "electronics");
    }

    @Given("User {int} has multiple interactions with the recommendations")
    public void userHasMultipleInteractionsWithRecommendations(int userId) {
        simulateUserInteractions(userId);
    }

    @Given("there is a sudden change in user behavior")
    public void suddenChangeInUserBehavior() {
        simulateSuddenBehaviorChange();
    }

    @Given("there are relevant promotions available")
    public void relevantPromotionsAvailable() {
        setRelevantPromotions();
    }

    @When("User {int} logs in and navigates to the recommendations section")
    public void userLogsInAndNavigatesToRecommendationsSection(int userId) {
        loginUser(userId);
        navigateToRecommendations();
    }

    @When("User {int} checks the recommendation accuracy")
    public void userChecksRecommendationAccuracy(int userId) {
        checkRecommendationAccuracy(userId);
    }

    @When("the algorithm processes the new behavior")
    public void algorithmProcessesNewBehavior() {
        processNewBehavior();
    }

    @When("User {int} checks the diversity of recommendations")
    public void userChecksDiversityOfRecommendations(int userId) {
        checkRecommendationDiversity(userId);
    }

    @When("the recommendations are generated")
    public void recommendationsAreGenerated() {
        generateRecommendations();
    }

    @When("the algorithm incorporates external factors")
    public void algorithmIncorporatesExternalFactors() {
        incorporateExternalFactors();
    }

    @Then("Recommendations should primarily include electronics")
    public void recommendationsShouldIncludeElectronics() {
        verifyRecommendationsInclude("electronics");
    }

    @Then("Recommendations should primarily include fashion items")
    public void recommendationsShouldIncludeFashionItems() {
        verifyRecommendationsInclude("fashion");
    }

    @Then("Recommendations should primarily include home appliances")
    public void recommendationsShouldIncludeHomeAppliances() {
        verifyRecommendationsInclude("home appliances");
    }

    @Then("Recommendations should adjust to include fashion items")
    public void recommendationsShouldAdjustToIncludeFashionItems() {
        verifyRecommendationsInclude("fashion");
    }

    @Then("Recommendations should adjust to include electronics")
    public void recommendationsShouldAdjustToIncludeElectronics() {
        verifyRecommendationsInclude("electronics");
    }

    @Then("Recommendations should become more accurate and personalized over time")
    public void recommendationsShouldBecomeMoreAccurate() {
        verifyRecommendationsAccuracy();
    }

    @Then("Recommendations should quickly adapt to reflect new interests")
    public void recommendationsShouldAdaptToNewInterests() {
        verifyRecommendationsAdaptation();
    }

    @Then("Recommendations should include a variety of electronics brands and types")
    public void recommendationsShouldIncludeVarietyOfElectronics() {
        verifyRecommendationsDiversity("electronics");
    }

    @Then("Recommendations should include a variety of fashion brands and styles")
    public void recommendationsShouldIncludeVarietyOfFashion() {
        verifyRecommendationsDiversity("fashion");
    }

    @Then("Recommendations should include a variety of appliance brands and models")
    public void recommendationsShouldIncludeVarietyOfAppliances() {
        verifyRecommendationsDiversity("home appliances");
    }

    @Then("Recommendations should not include items unrelated to user interests")
    public void recommendationsShouldExcludeIrrelevantItems() {
        verifyRecommendationsExclusion();
    }

    @Then("Recommendations should incorporate relevant promotions without losing personalization")
    public void recommendationsShouldIncorporatePromotions() {
        verifyRecommendationsWithPromotions();
    }
}