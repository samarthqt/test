import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductReviewsPage from "../pages/productReviewsPage";

Given("the user is on the product page", () => {
 ProductReviewsPage.visit();
});

Given("the user is logged in", () => {
 ProductReviewsPage.ensureUserIsLoggedIn();
});

Given("the user is not logged in", () => {
 ProductReviewsPage.ensureUserIsNotLoggedIn();
});

When("the user navigates to the product reviews section", () => {
 ProductReviewsPage.goToReviewsSection();
});

When("the user clicks on \"Write a Review\"", () => {
 ProductReviewsPage.clickWriteReview();
});

When("the user enters a review title {string}", (title) => {
 ProductReviewsPage.enterReviewTitle(title);
});

When("the user enters a review description {string}", (description) => {
 ProductReviewsPage.enterReviewDescription(description);
});

When("the user selects a rating of {int} stars", (stars) => {
 ProductReviewsPage.selectRating(stars);
});

When("the user submits the review", () => {
 ProductReviewsPage.submitReview();
});

When("the user attempts to write a review", () => {
 ProductReviewsPage.attemptToWriteReview();
});

Then("the review should be successfully submitted", () => {
 ProductReviewsPage.verifyReviewSubmissionSuccess();
});

Then("the review should be visible under the product reviews section", () => {
 ProductReviewsPage.verifyReviewVisible();
});

Then("the user should see a list of reviews for the product", () => {
 ProductReviewsPage.verifyListOfReviewsVisible();
});

Then("each review should display the reviewer's name, review title, review description, rating, and date of submission", () => {
 ProductReviewsPage.verifyReviewDetailsVisible();
});

Then("the user should be prompted to log in or register", () => {
 ProductReviewsPage.verifyLoginOrRegisterPrompt();
});

Then("the user should see an error message indicating that the review description is required", () => {
 ProductReviewsPage.verifyReviewDescriptionError();
});