import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecommendationsPage from "../pages/recommendationsPage";

Given("a user account with browsing and purchase history", () => {
 // Setup user account with history
});

When("the user logs into the application", () => {
 RecommendationsPage.login();
});

Then("the user is successfully logged in", () => {
 RecommendationsPage.verifyLogin();
});

Then("the homepage is displayed with personalized recommendations including electronics and fashion items", () => {
 RecommendationsPage.verifyHomepageRecommendations();
});

Given("the user is on the homepage", () => {
 RecommendationsPage.visitHomepage();
});

When("the user navigates to a product page of an electronics item", () => {
 RecommendationsPage.navigateToElectronicsProductPage();
});

Then("the product page displays related accessories recommendations", () => {
 RecommendationsPage.verifyElectronicsRecommendations();
});

Then("the recommendations are relevant to the electronics item", () => {
 RecommendationsPage.verifyElectronicsRelevance();
});

When("the user navigates to a product page of a fashion item", () => {
 RecommendationsPage.navigateToFashionProductPage();
});

Then("the product page displays related fashion accessories recommendations", () => {
 RecommendationsPage.verifyFashionRecommendations();
});

Then("the recommendations are relevant to the fashion item", () => {
 RecommendationsPage.verifyFashionRelevance();
});

Given("the user is on a product page with recommendations", () => {
 RecommendationsPage.visitProductPageWithRecommendations();
});

When("the user adds an item from the recommendations to the cart", () => {
 RecommendationsPage.addItemToCartFromRecommendations();
});

Then("the item is successfully added to the cart", () => {
 RecommendationsPage.verifyItemAddedToCart();
});

Given("the user has added an item to the cart", () => {
 RecommendationsPage.addItemToCart();
});

When("the user checks the recommendations", () => {
 RecommendationsPage.checkUpdatedRecommendations();
});

Then("the recommendations adjust to include complementary items", () => {
 RecommendationsPage.verifyComplementaryRecommendations();
});

Given("the user logs out of the application", () => {
 RecommendationsPage.logout();
});

When("the user logs back into the application", () => {
 RecommendationsPage.login();
});

Then("the user is successfully logged in with updated recommendations", () => {
 RecommendationsPage.verifyLoginWithUpdatedRecommendations();
});

Then("the recommendations remain consistent with browsing and purchase behavior", () => {
 RecommendationsPage.verifyConsistencyOfRecommendations();
});

Given("the user is logged into the application", () => {
 RecommendationsPage.login();
});

When("the user checks recommendations on other sections of the application (e.g., deals page)", () => {
 RecommendationsPage.checkRecommendationsOnOtherSections();
});

Then("the recommendations align with user history across different sections", () => {
 RecommendationsPage.verifyRecommendationsAcrossSections();
});

Given("the user clears browsing history", () => {
 RecommendationsPage.clearBrowsingHistory();
});

When("the user checks recommendations", () => {
 RecommendationsPage.checkRecommendations();
});

Then("the recommendations adjust to focus more on purchase history", () => {
 RecommendationsPage.verifyRecommendationsFocusOnPurchaseHistory();
});

Given("the user deletes a past purchase from the history", () => {
 RecommendationsPage.deletePastPurchase();
});

When("the user checks recommendations", () => {
 RecommendationsPage.checkRecommendations();
});

Then("the recommendations adjust, removing items related to the deleted purchase", () => {
 RecommendationsPage.verifyRecommendationsAfterDeletingPurchase();
});

Given("different user profiles with browsing and purchase history", () => {
 RecommendationsPage.setupUserProfiles();
});

When("the recommendation verification process is repeated for each user profile", () => {
 RecommendationsPage.repeatVerificationForUserProfiles();
});

Then("the recommendations are personalized and accurate for each user profile", () => {
 RecommendationsPage.verifyPersonalizedRecommendations();
});