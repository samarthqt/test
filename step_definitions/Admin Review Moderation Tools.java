package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminDashboardPage;

public class AdminReviewModerationSteps extends AdminDashboardPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the admin user is logged into the system")
    public void theAdminUserIsLoggedIntoTheSystem() {
        loginAsAdmin();
    }

    @When("the admin navigates to the admin dashboard")
    public void theAdminNavigatesToTheAdminDashboard() {
        navigateToDashboard();
    }

    @Then("the admin dashboard is displayed with options for review moderation")
    public void theAdminDashboardIsDisplayedWithOptionsForReviewModeration() {
        verifyDashboardOptions();
    }

    @Given("there are existing reviews available for moderation")
    public void thereAreExistingReviewsAvailableForModeration() {
        verifyReviewsExist();
    }

    @When("the admin selects the 'Reviews' section from the dashboard menu")
    public void theAdminSelectsTheReviewsSectionFromTheDashboardMenu() {
        selectReviewsSection();
    }

    @Then("a list of reviews is displayed with options to approve, edit, or delete")
    public void aListOfReviewsIsDisplayedWithOptionsToApproveEditOrDelete() {
        verifyReviewOptions();
    }

    @Given("the review content is 'Great product!'")
    public void theReviewContentIsGreatProduct() {
        verifyReviewContent("Great product!");
    }

    @When("the admin selects a review with ID 12345")
    public void theAdminSelectsAReviewWithID12345() {
        selectReviewById("12345");
    }

    @Then("review details are displayed including content and user information")
    public void reviewDetailsAreDisplayedIncludingContentAndUserInformation() {
        verifyReviewDetails();
    }

    @Given("the admin credentials are admin_user and secure_password")
    public void theAdminCredentialsAreAdminUserAndSecurePassword() {
        verifyAdminCredentials("admin_user", "secure_password");
    }

    @When("the admin clicks on 'Approve' for the selected review")
    public void theAdminClicksOnApproveForTheSelectedReview() {
        approveSelectedReview();
    }

    @Then("the review status changes to 'Approved' and is visible to users")
    public void theReviewStatusChangesToApprovedAndIsVisibleToUsers() {
        verifyReviewStatus("Approved");
    }

    @When("the admin edits the review content to 'Excellent product!' and saves changes")
    public void theAdminEditsTheReviewContentToExcellentProductAndSavesChanges() {
        editReviewContent("Excellent product!");
    }

    @Then("the review content is updated successfully")
    public void theReviewContentIsUpdatedSuccessfully() {
        verifyUpdatedReviewContent("Excellent product!");
    }

    @When("the admin deletes the review with ID 12345")
    public void theAdminDeletesTheReviewWithID12345() {
        deleteReviewById("12345");
    }

    @Then("the review is removed from the list and no longer visible to users")
    public void theReviewIsRemovedFromTheListAndNoLongerVisibleToUsers() {
        verifyReviewDeletion("12345");
    }

    @When("the admin verifies the audit log for actions taken on the review")
    public void theAdminVerifiesTheAuditLogForActionsTakenOnTheReview() {
        verifyAuditLog();
    }

    @Then("the audit log shows entries for approval, edit, and deletion actions")
    public void theAuditLogShowsEntriesForApprovalEditAndDeletionActions() {
        verifyAuditLogEntries();
    }

    @When("the admin logs out from the admin account")
    public void theAdminLogsOutFromTheAdminAccount() {
        logoutAdmin();
    }

    @Then("the admin is logged out and redirected to the login page")
    public void theAdminIsLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutRedirection();
    }

    @When("the admin logs back into the admin account")
    public void theAdminLogsBackIntoTheAdminAccount() {
        loginAsAdmin();
    }

    @When("navigates to the reviews section")
    public void navigatesToTheReviewsSection() {
        selectReviewsSection();
    }

    @Then("the admin can access the reviews section with updated review list")
    public void theAdminCanAccessTheReviewsSectionWithUpdatedReviewList() {
        verifyUpdatedReviewList();
    }

    @When("the admin attempts to edit a non-existent review")
    public void theAdminAttemptsToEditANonExistentReview() {
        attemptEditNonExistentReview();
    }

    @Then("the system displays an error message indicating the review does not exist")
    public void theSystemDisplaysAnErrorMessageIndicatingTheReviewDoesNotExist() {
        verifyNonExistentReviewError();
    }

    @When("the admin attempts to delete a review not owned by the admin")
    public void theAdminAttemptsToDeleteAReviewNotOwnedByTheAdmin() {
        attemptDeleteUnauthorizedReview();
    }

    @Then("the system restricts action and displays an authorization error")
    public void theSystemRestrictsActionAndDisplaysAnAuthorizationError() {
        verifyAuthorizationError();
    }

    @When("the admin checks system response to bulk approval of reviews")
    public void theAdminChecksSystemResponseToBulkApprovalOfReviews() {
        checkBulkApprovalResponse();
    }

    @Then("the system processes bulk approval without errors and updates statuses")
    public void theSystemProcessesBulkApprovalWithoutErrorsAndUpdatesStatuses() {
        verifyBulkApprovalStatus();
    }

    @When("the admin verifies review moderation tools on mobile devices")
    public void theAdminVerifiesReviewModerationToolsOnMobileDevices() {
        verifyMobileAccessibility();
    }

    @Then("admin tools are accessible and functional on mobile interfaces")
    public void adminToolsAreAccessibleAndFunctionalOnMobileInterfaces() {
        verifyMobileFunctionality();
    }

    @When("the admin tests the performance of the review moderation tools under high load")
    public void theAdminTestsThePerformanceOfTheReviewModerationToolsUnderHighLoad() {
        testPerformanceUnderLoad();
    }

    @Then("the system maintains performance and responsiveness under load")
    public void theSystemMaintainsPerformanceAndResponsivenessUnderLoad() {
        verifyPerformanceUnderLoad();
    }

    @When("changes are made by one admin")
    public void changesAreMadeByOneAdmin() {
        makeChangesAsAdmin();
    }

    @Then("changes are synchronized in real-time across all admin views")
    public void changesAreSynchronizedInRealTimeAcrossAllAdminViews() {
        verifyRealTimeSynchronization();
    }
}