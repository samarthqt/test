import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminDashboardPage from "../pages/adminDashboardPage";

Given("the admin user is logged into the system", () => {
 AdminDashboardPage.login('admin_user', 'secure_password');
});

When("the admin navigates to the admin dashboard", () => {
 AdminDashboardPage.navigateToDashboard();
});

Then("the admin dashboard is displayed with options for review moderation", () => {
 AdminDashboardPage.verifyDashboardOptions();
});

Given("there are existing reviews available for moderation", () => {
 AdminDashboardPage.checkReviewsAvailable();
});

When("the admin selects the 'Reviews' section from the dashboard menu", () => {
 AdminDashboardPage.selectReviewsSection();
});

Then("a list of reviews is displayed with options to approve, edit, or delete", () => {
 AdminDashboardPage.verifyReviewListOptions();
});

Given("the review content is 'Great product!'", () => {
 AdminDashboardPage.verifyReviewContent('12345', 'Great product!');
});

When("the admin selects a review with ID 12345", () => {
 AdminDashboardPage.selectReviewById('12345');
});

Then("review details are displayed including content and user information", () => {
 AdminDashboardPage.verifyReviewDetails();
});

Given("the admin credentials are admin_user and secure_password", () => {
 AdminDashboardPage.setCredentials('admin_user', 'secure_password');
});

When("the admin clicks on 'Approve' for the selected review", () => {
 AdminDashboardPage.approveReview('12345');
});

Then("the review status changes to 'Approved' and is visible to users", () => {
 AdminDashboardPage.verifyReviewStatus('12345', 'Approved');
});

When("the admin edits the review content to 'Excellent product!' and saves changes", () => {
 AdminDashboardPage.editReviewContent('12345', 'Excellent product!');
});

Then("the review content is updated successfully", () => {
 AdminDashboardPage.verifyReviewContent('12345', 'Excellent product!');
});

When("the admin deletes the review with ID 12345", () => {
 AdminDashboardPage.deleteReview('12345');
});

Then("the review is removed from the list and no longer visible to users", () => {
 AdminDashboardPage.verifyReviewDeleted('12345');
});

When("the admin verifies the audit log for actions taken on the review", () => {
 AdminDashboardPage.verifyAuditLog('12345');
});

Then("the audit log shows entries for approval, edit, and deletion actions", () => {
 AdminDashboardPage.verifyAuditLogEntries('12345');
});

When("the admin logs out from the admin account", () => {
 AdminDashboardPage.logout();
});

Then("the admin is logged out and redirected to the login page", () => {
 AdminDashboardPage.verifyLogoutRedirect();
});

When("the admin logs back into the admin account", () => {
 AdminDashboardPage.login('admin_user', 'secure_password');
});

And("navigates to the reviews section", () => {
 AdminDashboardPage.selectReviewsSection();
});

Then("the admin can access the reviews section with updated review list", () => {
 AdminDashboardPage.verifyUpdatedReviewList();
});

When("the admin attempts to edit a non-existent review", () => {
 AdminDashboardPage.editNonExistentReview('99999');
});

Then("the system displays an error message indicating the review does not exist", () => {
 AdminDashboardPage.verifyNonExistentReviewError();
});

When("the admin attempts to delete a review not owned by the admin", () => {
 AdminDashboardPage.deleteReviewNotOwned('54321');
});

Then("the system restricts action and displays an authorization error", () => {
 AdminDashboardPage.verifyAuthorizationError();
});

When("the admin checks system response to bulk approval of reviews", () => {
 AdminDashboardPage.bulkApproveReviews();
});

Then("the system processes bulk approval without errors and updates statuses", () => {
 AdminDashboardPage.verifyBulkApprovalStatus();
});

When("the admin verifies review moderation tools on mobile devices", () => {
 AdminDashboardPage.verifyMobileAccessibility();
});

Then("admin tools are accessible and functional on mobile interfaces", () => {
 AdminDashboardPage.verifyMobileFunctionality();
});

When("the admin tests the performance of the review moderation tools under high load", () => {
 AdminDashboardPage.testPerformanceUnderLoad();
});

Then("the system maintains performance and responsiveness under load", () => {
 AdminDashboardPage.verifyPerformanceUnderLoad();
});

When("changes are made by one admin", () => {
 AdminDashboardPage.makeChangesAsAdmin();
});

Then("changes are synchronized in real-time across all admin views", () => {
 AdminDashboardPage.verifyRealTimeSynchronization();
});