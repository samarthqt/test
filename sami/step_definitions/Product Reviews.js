import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../pageObjects/ProductPage';

const productPage = new ProductPage();

Given('the user is on the product page', () => {
  productPage.visitProductPage();
});

Given('the user is logged in', () => {
  productPage.ensureUserIsLoggedIn();
});

Given('the user is not logged in', () => {
  productPage.ensureUserIsNotLoggedIn();
});

When('the user navigates to the product reviews section', () => {
  productPage.navigateToReviewsSection();
});

When('the user clicks on {string}', (buttonText) => {
  productPage.clickButton(buttonText);
});

When('the user enters a review title {string}', (title) => {
  productPage.enterReviewTitle(title);
});

When('the user enters a review description {string}', (description) => {
  productPage.enterReviewDescription(description);
});

When('the user selects a rating of {int} stars', (rating) => {
  productPage.selectRating(rating);
});

When('the user submits the review', () => {
  productPage.submitReview();
});

When('the user attempts to write a review', () => {
  productPage.attemptToWriteReview();
});

Then('the review should be successfully submitted', () => {
  productPage.verifyReviewSubmissionSuccess();
});

Then('the review should be visible under the product reviews section', () => {
  productPage.verifyReviewVisibility();
});

Then('the user should see a list of reviews for the product', () => {
  productPage.verifyListOfReviews();
});

Then('each review should display the reviewer's name, review title, review description, rating, and date of submission', () => {
  productPage.verifyReviewDetails();
});

Then('the user should be prompted to log in or register', () => {
  productPage.verifyLoginPrompt();
});

Then('the user should see an error message indicating that the review description is required', () => {
  productPage.verifyReviewDescriptionError();
});