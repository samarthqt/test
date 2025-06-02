import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ReviewPage from "../pages/reviewPage";

Given("the system supports multiple languages", () => {
 ReviewPage.verifyLanguageSupport();
});

When("a review is submitted in {string} with content {string}", (language, content) => {
 ReviewPage.submitReview(language, content);
});

Then("the review is accepted and displayed correctly in {string}", (language) => {
 ReviewPage.verifyReviewDisplay(language);
});

Given("admin credentials are {string} and {string}", (username, password) => {
 ReviewPage.loginAsAdmin(username, password);
});

When("the admin navigates to the dashboard", () => {
 ReviewPage.navigateToDashboard();
});

Then("reviews are listed with language indicators", () => {
 ReviewPage.verifyLanguageIndicators();
});

Given("the admin is on the review moderation page", () => {
 ReviewPage.accessReviewModeration();
});

When("the admin approves a review submitted in {string}", (language) => {
 ReviewPage.approveReview(language);
});

Then("the review status changes to 'Approved' and is visible to users", () => {
 ReviewPage.verifyReviewApproval();
});

When("the admin edits a review submitted in {string}", (language) => {
 ReviewPage.editReview(language);
});

Then("the review content is updated successfully", () => {
 ReviewPage.verifyReviewUpdate();
});

When("the admin deletes a review submitted in {string}", (language) => {
 ReviewPage.deleteReview(language);
});

Then("the review is removed from the system and no longer visible", () => {
 ReviewPage.verifyReviewDeletion();
});

When("a review with inappropriate content is submitted", () => {
 ReviewPage.submitInappropriateContentReview();
});

Then("the system flags inappropriate content regardless of language", () => {
 ReviewPage.verifyInappropriateContentFlagging();
});

When("reviews are submitted simultaneously in different languages", () => {
 ReviewPage.submitSimultaneousReviews();
});

Then("the system processes and displays reviews without errors", () => {
 ReviewPage.verifySimultaneousReviewProcessing();
});

Given("the admin is logged in", () => {
 ReviewPage.verifyAdminLogin();
});

When("the admin logs out", () => {
 ReviewPage.logoutAdmin();
});

Then("the admin is redirected to the login page", () => {
 ReviewPage.verifyLogoutRedirection();
});

Given("the admin is on the login page", () => {
 ReviewPage.accessLoginPage();
});

When("the admin logs back in", () => {
 ReviewPage.reloginAdmin();
});

Then("the admin can access multilingual reviews with updated list", () => {
 ReviewPage.verifyMultilingualReviewAccess();
});

When("a review is submitted in an unsupported language", () => {
 ReviewPage.submitUnsupportedLanguageReview();
});

Then("the system displays an error message indicating unsupported language", () => {
 ReviewPage.verifyUnsupportedLanguageError();
});

When("a mixed-language review is submitted", () => {
 ReviewPage.submitMixedLanguageReview();
});

Then("the system processes mixed-language reviews correctly", () => {
 ReviewPage.verifyMixedLanguageReviewProcessing();
});

When("a review with language-specific characters is submitted", () => {
 ReviewPage.submitLanguageSpecificCharactersReview();
});

Then("all characters are displayed correctly without encoding issues", () => {
 ReviewPage.verifyCharacterDisplay();
});

When("the admin filters reviews by language", () => {
 ReviewPage.filterReviewsByLanguage();
});

Then("the admin can view reviews based on language selection", () => {
 ReviewPage.verifyLanguageFilteredReviews();
});