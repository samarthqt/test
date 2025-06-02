import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPage from "../pages/accountPage";
import OrderHistoryPage from "../pages/orderHistoryPage";
import ProductDetailsPage from "../pages/productDetailsPage";
import ReviewsPage from "../pages/reviewsPage";

Given("a customer account with purchased products", () => {
 AccountPage.verifyPurchasedProducts();
});

When("the customer logs in to the account", () => {
 AccountPage.login();
});

Then("the customer account login is successful", () => {
 AccountPage.verifyLoginSuccess();
});

Given("the customer is logged in", () => {
 AccountPage.verifyLoginSuccess();
});

When("the customer navigates to the order history page", () => {
 OrderHistoryPage.visit();
});

Then("the order history page displays all purchased products", () => {
 OrderHistoryPage.verifyPurchasedProductsDisplay();
});

Given("the order history page is displayed", () => {
 OrderHistoryPage.verifyPageDisplayed();
});

When("the customer selects a purchased product to review", () => {
 OrderHistoryPage.selectProductForReview();
});

Then("the product details page opens successfully", () => {
 ProductDetailsPage.verifyPageOpened();
});

Given("the product details page is open", () => {
 ProductDetailsPage.verifyPageOpened();
});

When("the customer locates the ratings and reviews section", () => {
 ProductDetailsPage.locateReviewsSection();
});

Then("the ratings and reviews section is visible", () => {
 ProductDetailsPage.verifyReviewsSectionVisible();
});

Given("the ratings and reviews section is visible", () => {
 ProductDetailsPage.verifyReviewsSectionVisible();
});

When("the customer submits a rating by selecting the desired number of stars", () => {
 ReviewsPage.submitRating();
});

Then("the rating submission is successful", () => {
 ReviewsPage.verifyRatingSubmissionSuccess();
});

When("the customer enters a review text in the provided field", () => {
 ReviewsPage.enterReviewText();
});

And("submits the review", () => {
 ReviewsPage.submitReview();
});

Then("the review submission is successful", () => {
 ReviewsPage.verifyReviewSubmissionSuccess();
});

Given("the customer has submitted a rating and review", () => {
 ReviewsPage.verifyReviewAndRatingSubmitted();
});

When("viewing the product page", () => {
 ProductDetailsPage.visit();
});

Then("the submitted rating and review are visible on the product page", () => {
 ProductDetailsPage.verifyRatingAndReviewVisible();
});

Given("the customer has submitted a review", () => {
 ReviewsPage.verifyReviewSubmitted();
});

When("the customer attempts to edit or delete the review", () => {
 ReviewsPage.editOrDeleteReview();
});

Then("the review can be edited or deleted by the customer", () => {
 ReviewsPage.verifyEditOrDeleteSuccess();
});

When("the customer attempts to submit a duplicate review", () => {
 ReviewsPage.submitDuplicateReview();
});

Then("the system prevents submission of duplicate reviews", () => {
 ReviewsPage.verifyDuplicateReviewPrevention();
});

Given("the customer is submitting a review", () => {
 ReviewsPage.startReviewSubmission();
});

When("the review contains inappropriate language", () => {
 ReviewsPage.enterInappropriateLanguage();
});

Then("the system flags or rejects reviews with inappropriate language", () => {
 ReviewsPage.verifyInappropriateLanguageHandling();
});

When("viewing the review", () => {
 ReviewsPage.viewReview();
});

Then("the review displays correct timestamps", () => {
 ReviewsPage.verifyCorrectTimestamps();
});

When("the review submission is successful", () => {
 ReviewsPage.verifyReviewSubmissionSuccess();
});

Then("the system sends notifications for successful review submissions", () => {
 ReviewsPage.verifyNotificationSent();
});

When("other users view the product page", () => {
 ProductDetailsPage.otherUsersView();
});

Then("the submitted reviews are visible to other users", () => {
 ProductDetailsPage.verifyReviewsVisibleToOthers();
});

Given("reviews have been submitted", () => {
 ReviewsPage.verifyReviewsSubmitted();
});

When("using the system's moderation tools", () => {
 ReviewsPage.useModerationTools();
});

Then("moderation tools allow management of submitted reviews", () => {
 ReviewsPage.verifyModerationToolsFunctionality();
});