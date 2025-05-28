import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductRecommendationsPage from "../pages/productRecommendationsPage";

Given("a user is logged into the application", () => {
 ProductRecommendationsPage.login();
});

Given("the user has a history of interactions with various products", () => {
 ProductRecommendationsPage.loadUserHistory();
});

When("the user navigates to the homepage", () => {
 ProductRecommendationsPage.visitHomepage();
});

Then("the system should display personalized product recommendations", () => {
 ProductRecommendationsPage.verifyPersonalizedRecommendations();
});

Then("the recommendations should be based on the user's past behavior and preferences", () => {
 ProductRecommendationsPage.verifyRecommendationsBasedOnBehavior();
});

Given("a new user has registered and logged into the application", () => {
 ProductRecommendationsPage.registerNewUser();
 ProductRecommendationsPage.login();
});

Then("the system should not display any product recommendations", () => {
 ProductRecommendationsPage.verifyNoRecommendations();
});

Then("a message should be shown encouraging the user to explore products", () => {
 ProductRecommendationsPage.verifyExploreProductsMessage();
});

Given("a user is viewing personalized product recommendations", () => {
 ProductRecommendationsPage.viewPersonalizedRecommendations();
});

When("the user interacts with a product", () => {
 ProductRecommendationsPage.interactWithProduct();
});

Then("the system should update the recommendations based on the latest interaction", () => {
 ProductRecommendationsPage.verifyUpdatedRecommendations();
});

Given("a user is viewing a product detail page", () => {
 ProductRecommendationsPage.viewProductDetailPage();
});

When("the user scrolls down the page", () => {
 ProductRecommendationsPage.scrollDownPage();
});

Then("the system should display additional product recommendations", () => {
 ProductRecommendationsPage.verifyAdditionalRecommendations();
});

Then("these recommendations should be related to the product being viewed", () => {
 ProductRecommendationsPage.verifyRelatedRecommendations();
});

Given("a user with similar behavior to the current user has interacted with certain products", () => {
 ProductRecommendationsPage.loadSimilarUserBehavior();
});

When("the current user views their personalized recommendations", () => {
 ProductRecommendationsPage.viewPersonalizedRecommendations();
});

Then("the system should include products that were popular among users with similar behavior", () => {
 ProductRecommendationsPage.verifySimilarBehaviorRecommendations();
});

Given("a user has opted out of personalized product recommendations", () => {
 ProductRecommendationsPage.optOutPersonalizedRecommendations();
});

Then("the system should not display personalized product recommendations", () => {
 ProductRecommendationsPage.verifyNoPersonalizedRecommendations();
});

Then("the user should have an option to opt back in for personalized recommendations", () => {
 ProductRecommendationsPage.verifyOptInOption();
});