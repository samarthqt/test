import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("a user account with browsing history of Electronics and Books", () => {
 // Setup user account with browsing history
});

And("a purchase history of Smartphone and Fiction Novel", () => {
 // Setup purchase history
});

When("the user logs into the application", () => {
 RecommendationsPage.login();
});

When("navigates to the homepage", () => {
 RecommendationsPage.goToHomepage();
});

Then("the homepage should display personalized recommendations including electronics and books related items", () => {
 RecommendationsPage.verifyHomepageRecommendations(['Electronics', 'Books']);
});

Given("the user is on the homepage", () => {
 RecommendationsPage.goToHomepage();
});

When("the user navigates to the product page of a recently browsed category", () => {
 RecommendationsPage.navigateToRecentlyBrowsedCategory();
});

Then("the product page should display related recommendations based on browsing history", () => {
 RecommendationsPage.verifyProductPageRecommendations();
});

When("the user checks the recommendations section", () => {
 RecommendationsPage.checkRecommendationsSection();
});

Then("recommendations should include accessories for the smartphone and similar genre novels", () => {
 RecommendationsPage.verifyRecommendationsForPurchases(['Smartphone Accessories', 'Fiction Novels']);
});

When("the user adds a camera to the browsing history", () => {
 RecommendationsPage.addToBrowsingHistory('Camera');
});

And("refreshes the homepage recommendations", () => {
 RecommendationsPage.refreshHomepageRecommendations();
});

Then("recommendations should update to include camera-related products", () => {
 RecommendationsPage.verifyUpdatedRecommendations(['Camera']);
});

Given("the user has purchased a camera lens", () => {
 RecommendationsPage.purchaseItem('Camera Lens');
});

Then("recommendations should include accessories for the camera lens", () => {
 RecommendationsPage.verifyRecommendationsForPurchases(['Camera Lens Accessories']);
});

Given("the user logs out and logs back into the application", () => {
 RecommendationsPage.logoutAndLogin();
});

Then("the user should see consistent recommendations with updated browsing and purchase history", () => {
 RecommendationsPage.verifyConsistentRecommendations();
});

Given("the user is logged in", () => {
 RecommendationsPage.login();
});

When("the user checks recommendations on the deals page", () => {
 RecommendationsPage.checkDealsPageRecommendations();
});

Then("recommendations should align with user history across different sections", () => {
 RecommendationsPage.verifyCrossSectionRecommendations();
});

Given("the user clears their browsing history", () => {
 RecommendationsPage.clearBrowsingHistory();
});

Then("recommendations should adjust to focus more on purchase history", () => {
 RecommendationsPage.verifyRecommendationsFocusOnPurchases();
});

Given("the user deletes a past purchase from the history", () => {
 RecommendationsPage.deletePastPurchase();
});

Then("recommendations should adjust, removing items related to the deleted purchase", () => {
 RecommendationsPage.verifyRecommendationsAfterPurchaseDeletion();
});

Given("different user profiles with unique browsing and purchase histories", () => {
 RecommendationsPage.setupMultipleUserProfiles();
});

When("the user logs into each profile", () => {
 RecommendationsPage.loginToEachProfile();
});

Then("recommendations should be personalized and accurate for each user profile", () => {
 RecommendationsPage.verifyPersonalizedRecommendationsForProfiles();
});