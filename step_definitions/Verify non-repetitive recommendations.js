import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationPage from "../pages/recommendationPage";

Given("a user account with recommendation system access", () => {
 RecommendationPage.visitLoginPage();
});

When("the user logs in with User ID {string}", (userId) => {
 RecommendationPage.login(userId);
});

Then("the user is successfully logged in and directed to the homepage", () => {
 RecommendationPage.verifyHomePage();
});

Given("the user is on the homepage", () => {
 RecommendationPage.verifyHomePage();
});

When("the user navigates to the recommendations section", () => {
 RecommendationPage.navigateToRecommendations();
});

Then("the recommendation section is visible with product suggestions", () => {
 RecommendationPage.verifyRecommendationsVisible();
});

Then("the product categories include Electronics and Clothing", () => {
 RecommendationPage.verifyProductCategories();
});

Given("the user is in the recommendations section", () => {
 RecommendationPage.verifyRecommendationsVisible();
});

When("the user observes the list of recommended products", () => {
 RecommendationPage.observeRecommendedProducts();
});

Then("no product is repeated in the list of recommendations", () => {
 RecommendationPage.verifyNoRepetitionInRecommendations();
});

When("the user refreshes the recommendation section multiple times", () => {
 RecommendationPage.refreshRecommendations();
});

Then("each refresh presents a new set of non-repetitive recommendations", () => {
 RecommendationPage.verifyNewSetOfRecommendations();
});

When("the user switches to a different category", () => {
 RecommendationPage.switchCategory();
});

Then("the recommendations are relevant to the new category and non-repetitive", () => {
 RecommendationPage.verifyCategoryRelevanceAndNoRepetition();
});

Given("the user is logged in", () => {
 RecommendationPage.verifyUserLoggedIn();
});

When("the user logs out and logs in again", () => {
 RecommendationPage.logoutAndLoginAgain();
});

Then("the non-repetitive nature of recommendations persists across sessions", () => {
 RecommendationPage.verifyPersistenceOfRecommendations();
});

Given("the user is logged in on a different device", () => {
 RecommendationPage.verifyUserLoggedInOnDifferentDevice();
});

When("the user checks the recommendations", () => {
 RecommendationPage.checkRecommendations();
});

Then("the recommendations remain non-repetitive across different devices", () => {
 RecommendationPage.verifyNoRepetitionAcrossDevices();
});

When("the user provides feedback on a recommendation", () => {
 RecommendationPage.provideFeedback();
});

Then("the feedback does not cause repetition in subsequent recommendations", () => {
 RecommendationPage.verifyFeedbackEffect();
});

Given("the system has a very limited product pool", () => {
 RecommendationPage.setupLimitedProductPool();
});

Then("the system manages to avoid repetition even with a limited product pool", () => {
 RecommendationPage.verifyLimitedProductPoolHandling();
});

When("the user checks for any system errors or delays", () => {
 RecommendationPage.checkSystemErrorsOrDelays();
});

Then("no errors or significant delays are observed in generating non-repetitive recommendations", () => {
 RecommendationPage.verifyNoErrorsOrDelays();
});

Given("a new user account with recommendation system access", () => {
 RecommendationPage.setupNewUserAccount();
});

When("the new user logs in and checks recommendations", () => {
 RecommendationPage.newUserLoginAndCheckRecommendations();
});

Then("the recommendations are non-repetitive even for new users", () => {
 RecommendationPage.verifyRecommendationsForNewUser();
});

Given("a user exhibits extreme behavior by browsing only one product repeatedly", () => {
 RecommendationPage.simulateExtremeUserBehavior();
});

Then("the system maintains non-repetitive recommendations despite extreme user behavior", () => {
 RecommendationPage.verifyExtremeBehaviorHandling();
});

When("the user provides feedback on multiple recommendations in quick succession", () => {
 RecommendationPage.quickFeedbackOnMultipleRecommendations();
});

Then("the system handles feedback inputs without causing repetition", () => {
 RecommendationPage.verifyFeedbackHandling();
});

Given("the system is experiencing peak usage times", () => {
 RecommendationPage.simulatePeakUsageTimes();
});

Then("the system consistently provides non-repetitive recommendations during peak times", () => {
 RecommendationPage.verifyPeakUsageHandling();
});

Given("the system is handling a large dataset", () => {
 RecommendationPage.setupLargeDataset();
});

Then("the system efficiently handles large datasets and maintains non-repetitive recommendations", () => {
 RecommendationPage.verifyLargeDatasetHandling();
});