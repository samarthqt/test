import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("a user is on the product page", () => {
 ProductPage.visit();
});

When("the user navigates to the review section", () => {
 ProductPage.navigateToReviewSection();
});

Then("the review functionality should be accessible", () => {
 ProductPage.verifyReviewFunctionalityAccessible();
});

When("the user rates a product using the star system", () => {
 ProductPage.rateProductWithStars();
});

Then("the rating should be recorded", () => {
 ProductPage.verifyRatingRecorded();
});

When("the user leaves a text review for a product", () => {
 ProductPage.leaveTextReview();
});

Then("the text review should be submitted", () => {
 ProductPage.verifyTextReviewSubmitted();
});

Given("a user attempts to submit a review", () => {
 ProductPage.attemptSubmitReview();
});

When("the review contains spam or inappropriate content", () => {
 ProductPage.enterSpamContent();
});

Then("the review should be blocked", () => {
 ProductPage.verifyReviewBlocked();
});

Given("an admin is reviewing submitted reviews", () => {
 ProductPage.adminReviewing();
});

When("the admin identifies a review that needs moderation or deletion", () => {
 ProductPage.identifyReviewForModeration();
});

Then("the admin should be able to moderate or delete the review", () => {
 ProductPage.moderateOrDeleteReview();
});

Given("a user submits an invalid review", () => {
 ProductPage.submitInvalidReview();
});

When("the system processes the review", () => {
 ProductPage.processReview();
});

Then("an error message should be displayed", () => {
 ProductPage.verifyErrorMessageDisplayed();
});

Given("a user is using the system", () => {
 ProductPage.userUsingSystem();
});

When("the user accesses the review functionality", () => {
 ProductPage.accessReviewFunctionality();
});

Then("the review functionality should be available on both desktop and mobile platforms", () => {
 ProductPage.verifyFunctionalityOnPlatforms();
});

Given("a user submits a review", () => {
 ProductPage.submitReview();
});

When("the review is processed", () => {
 ProductPage.processReview();
});

Then("the review should be logged for analytics purposes", () => {
 ProductPage.verifyReviewLoggedForAnalytics();
});

Given("a user views the product page", () => {
 ProductPage.viewProductPage();
});

When("the reviews are displayed", () => {
 ProductPage.displayReviews();
});

Then("the reviews should be accurately displayed through integration with the product database", () => {
 ProductPage.verifyReviewDisplayAccuracy();
});

Given("a user submits a review", () => {
 ProductPage.submitReview();
});

When("the review is approved or rejected", () => {
 ProductPage.reviewApprovalOrRejection();
});

Then("the user should receive a notification about the review status", () => {
 ProductPage.verifyNotificationReceived();
});