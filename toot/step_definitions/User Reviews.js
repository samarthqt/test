import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserReviewsPage from "../pages/userReviewsPage";

Given("the user is logged into their account", () => {
  // Assume user is already logged in for testing purposes
});

Given("the user has completed a purchase", () => {
  // Assume purchase is completed for testing purposes
});

Given("the user navigates to the {string} page", (page) => {
  UserReviewsPage.navigateToPage(page);
});

When("the user selects a completed purchase", () => {
  UserReviewsPage.selectCompletedPurchase();
});

When("the user clicks on {string}", (button) => {
  UserReviewsPage.clickButton(button);
});

Then("the user should be presented with a review form", () => {
  UserReviewsPage.verifyReviewFormIsPresent();
});

When("the user enters a rating between 1 and 5 stars", () => {
  UserReviewsPage.enterRating(5);
});

When("the user writes a comment in the feedback section", () => {
  UserReviewsPage.enterFeedback("Great product!");
});

When("the user submits the review", () => {
  UserReviewsPage.submitReview();
});

Then("the review should be saved and displayed under the product", () => {
  UserReviewsPage.verifyReviewIsDisplayed();
});

Given("the user has already submitted a review for a product", () => {
  // Assume review is already submitted for testing purposes
});

When("the user navigates to the product page", () => {
  UserReviewsPage.navigateToProductPage();
});

Then("the user should be able to modify the rating and feedback", () => {
  UserReviewsPage.verifyReviewModification();
});

When("the user submits the updated review", () => {
  UserReviewsPage.submitUpdatedReview();
});

Then("the updated review should replace the previous review", () => {
  UserReviewsPage.verifyUpdatedReview();
});

Then("the user should be prompted to confirm the deletion", () => {
  UserReviewsPage.verifyDeletionPrompt();
});

When("the user confirms the deletion", () => {
  UserReviewsPage.confirmDeletion();
});

Then("the review should be removed from the product page", () => {
  UserReviewsPage.verifyReviewIsRemoved();
});

Given("the user is on a product page", () => {
  UserReviewsPage.verifyOnProductPage();
});

When("the product has existing reviews", () => {
  UserReviewsPage.verifyExistingReviews();
});

Then("the user should be able to see the average rating", () => {
  UserReviewsPage.verifyAverageRating();
});

Then("the user should be able to read individual reviews", () => {
  UserReviewsPage.verifyIndividualReviews();
});

Given("the user is browsing a product page", () => {
  UserReviewsPage.verifyBrowsingProductPage();
});

When("the user tries to leave a review without purchasing the product", () => {
  UserReviewsPage.attemptReviewWithoutPurchase();
});

Then("the user should be notified that only verified purchasers can leave reviews", () => {
  UserReviewsPage.verifyPurchaseRequirementNotification();
});