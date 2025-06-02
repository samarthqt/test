import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ReviewPage from "../pages/reviewPage";
import AdminPage from "../pages/adminPage";

Given("the user submits a review with content {string}", (content) => {
 ReviewPage.submitReview(content);
});

Then("the review should be flagged as spam", () => {
 ReviewPage.verifyReviewFlaggedAsSpam();
});

Then("the review should not be displayed to users", () => {
 ReviewPage.verifyReviewNotDisplayed();
});

Given("the admin logs in with credentials {string} and {string}", (username, password) => {
 AdminPage.login(username, password);
});

When("the admin navigates to the flagged reviews section", () => {
 AdminPage.navigateToFlaggedReviews();
});

Then("flagged reviews are listed with options for further action", () => {
 AdminPage.verifyFlaggedReviewsListed();
});

Given("the admin accesses a flagged review for manual inspection", () => {
 AdminPage.accessFlaggedReview();
});

When("the admin approves the review", () => {
 AdminPage.approveReview();
});

Then("the review status changes to {string}", (status) => {
 AdminPage.verifyReviewStatus(status);
});

Then("the review is visible to users", () => {
 AdminPage.verifyReviewVisibleToUsers();
});

When("the admin deletes the review", () => {
 AdminPage.deleteReview();
});

Then("the review is removed from the system", () => {
 AdminPage.verifyReviewRemoved();
});

Then("the review is no longer visible", () => {
 AdminPage.verifyReviewNotVisible();
});

Given("a user submits multiple spam reviews", () => {
 ReviewPage.submitMultipleSpamReviews();
});

Then("the system automatically blocks repeated spam submissions from the same user", () => {
 ReviewPage.verifySpamBlocked();
});

Given("reviews are flagged as spam or inappropriate", () => {
 ReviewPage.flagReviews();
});

Then("admins receive notifications for the flagged reviews", () => {
 AdminPage.verifyAdminNotifications();
});

Given("a high rate of review submissions occurs", () => {
 ReviewPage.submitHighRateOfReviews();
});

Then("the system maintains performance", () => {
 ReviewPage.verifySystemPerformance();
});

And("the system accurately flags spam", () => {
 ReviewPage.verifyAccurateSpamFlagging();
});

Given("the admin is logged into the system", () => {
 AdminPage.verifyAdminLoggedIn();
});

When("the admin logs out", () => {
 AdminPage.logout();
});

Then("the admin is redirected to the login page", () => {
 AdminPage.verifyRedirectToLoginPage();
});

Given("the admin logs back into the system", () => {
 AdminPage.loginBack();
});

Then("the admin can access the flagged reviews section with updated list", () => {
 AdminPage.verifyAccessToUpdatedFlaggedReviews();
});

Given("the user submits a review with mixed content", () => {
 ReviewPage.submitMixedContentReview();
});

Then("the system flags the review for manual inspection", () => {
 ReviewPage.verifyMixedContentFlagged();
});

Given("a large volume of spam reviews are submitted", () => {
 ReviewPage.submitLargeVolumeOfSpam();
});

Then("the system efficiently handles and flags spam without crashing", () => {
 ReviewPage.verifyEfficientSpamHandling();
});

Given("reviews are flagged", () => {
 ReviewPage.flagReviews();
});

Then("flagged reviews remain hidden from user view until resolved", () => {
 ReviewPage.verifyFlaggedReviewsHidden();
});

Given("the system is used over time", () => {
 ReviewPage.simulateSystemUsageOverTime();
});

Then("the system shows improved accuracy in detecting spam", () => {
 ReviewPage.verifyImprovedSpamDetectionAccuracy();
});

Given("a review is flagged by the spam detection system", () => {
 ReviewPage.flagReviewBySystem();
});

When("the admin decides to override the system", () => {
 AdminPage.overrideSystem();
});

Then("the admin can manually approve or delete the flagged review", () => {
 AdminPage.verifyManualOverrideOptions();
});