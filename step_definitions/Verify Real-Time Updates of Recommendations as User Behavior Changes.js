import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("the user is logged into the application", () => {
 RecommendationsPage.login();
});

When("the user starts browsing home decor items", () => {
 RecommendationsPage.browseHomeDecor();
});

Then("the recommendations section on the homepage should focus on home decor items", () => {
 RecommendationsPage.verifyHomeDecorRecommendations();
});

When("the user shifts browsing behavior to electronics items", () => {
 RecommendationsPage.browseElectronics();
});

Then("the recommendations should update to include electronics items", () => {
 RecommendationsPage.verifyElectronicsRecommendations();
});

Given("the user is browsing electronics items", () => {
 RecommendationsPage.browseElectronics();
});

When("the user adds an electronic item to the cart", () => {
 RecommendationsPage.addItemToCart();
});

Then("the item should be successfully added to the cart", () => {
 RecommendationsPage.verifyItemAddedToCart();
});

And("the recommendations should further refine to include accessories related to the cart item", () => {
 RecommendationsPage.verifyAccessoryRecommendations();
});

Given("the user changes browsing category to fashion", () => {
 RecommendationsPage.changeCategoryToFashion();
});

When("the user starts browsing fashion items", () => {
 RecommendationsPage.browseFashionItems();
});

Then("the recommendations should quickly adapt to focus on fashion items", () => {
 RecommendationsPage.verifyFashionRecommendations();
});

Given("the user purchases a fashion item", () => {
 RecommendationsPage.purchaseFashionItem();
});

Then("the recommendations should include complementary fashion items post-purchase", () => {
 RecommendationsPage.verifyComplementaryFashionRecommendations();
});

Given("the user logs out and logs back into the application", () => {
 RecommendationsPage.logoutAndLogin();
});

Then("the user should be successfully logged in with updated recommendations", () => {
 RecommendationsPage.verifySuccessfulLoginWithUpdatedRecommendations();
});

And("the recommendations should remain consistent with updated browsing and purchase behavior", () => {
 RecommendationsPage.verifyConsistentRecommendations();
});

Given("the user performs rapid category changes", () => {
 RecommendationsPage.performRapidCategoryChanges();
});

Then("the system should efficiently update recommendations with each category change", () => {
 RecommendationsPage.verifyEfficientRecommendationsUpdate();
});

Given("the user tests recommendation updates on different devices simultaneously", () => {
 RecommendationsPage.testRecommendationsOnDifferentDevices();
});

Then("the recommendations should sync in real-time across all devices", () => {
 RecommendationsPage.verifyRealTimeSyncAcrossDevices();
});

Given("the user clears browsing history", () => {
 RecommendationsPage.clearBrowsingHistory();
});

Then("the recommendations should adjust to focus more on recent behavior", () => {
 RecommendationsPage.verifyRecommendationsAdjustToRecentBehavior();
});

Given("the user repeats the real-time update verification process for different user profiles", () => {
 RecommendationsPage.repeatVerificationForDifferentProfiles();
});

Then("the recommendations should be personalized and real-time for each user profile", () => {
 RecommendationsPage.verifyPersonalizedRecommendationsForProfiles();
});