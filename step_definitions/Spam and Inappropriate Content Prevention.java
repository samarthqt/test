package com.cucumber.steps;

import com.page_objects.ReviewManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewManagementSteps extends ReviewManagementPage {

    @Given("the user submits a review with content {string}")
    public void theUserSubmitsAReviewWithContent(String content) {
        submitReview(content);
    }

    @Then("the review should be flagged as spam")
    public void theReviewShouldBeFlaggedAsSpam() {
        verifyReviewFlaggedAsSpam();
    }

    @Then("the review should not be displayed to users")
    public void theReviewShouldNotBeDisplayedToUsers() {
        verifyReviewNotDisplayed();
    }

    @Then("the review should be flagged for inappropriate content")
    public void theReviewShouldBeFlaggedForInappropriateContent() {
        verifyReviewFlaggedForInappropriateContent();
    }

    @Then("the review requires admin approval")
    public void theReviewRequiresAdminApproval() {
        verifyReviewRequiresAdminApproval();
    }

    @Given("the admin logs in with credentials {string} and {string}")
    public void theAdminLogsInWithCredentials(String username, String password) {
        adminLogin(username, password);
    }

    @When("the admin navigates to the flagged reviews section")
    public void theAdminNavigatesToTheFlaggedReviewsSection() {
        navigateToFlaggedReviewsSection();
    }

    @Then("flagged reviews are listed with options for further action")
    public void flaggedReviewsAreListedWithOptionsForFurtherAction() {
        verifyFlaggedReviewsListed();
    }

    @Given("the admin accesses a flagged review for manual inspection")
    public void theAdminAccessesAFlaggedReviewForManualInspection() {
        accessFlaggedReviewForInspection();
    }

    @When("the admin approves the review")
    public void theAdminApprovesTheReview() {
        approveReview();
    }

    @Then("the review status changes to {string}")
    public void theReviewStatusChangesTo(String status) {
        verifyReviewStatusChanged(status);
    }

    @Then("the review is visible to users")
    public void theReviewIsVisibleToUsers() {
        verifyReviewVisibleToUsers();
    }

    @Given("the admin accesses a review flagged for inappropriate content")
    public void theAdminAccessesAReviewFlaggedForInappropriateContent() {
        accessReviewFlaggedForInappropriateContent();
    }

    @When("the admin deletes the review")
    public void theAdminDeletesTheReview() {
        deleteReview();
    }

    @Then("the review is removed from the system")
    public void theReviewIsRemovedFromTheSystem() {
        verifyReviewRemovedFromSystem();
    }

    @Then("the review is no longer visible")
    public void theReviewIsNoLongerVisible() {
        verifyReviewNoLongerVisible();
    }

    @Given("a user submits multiple spam reviews")
    public void aUserSubmitsMultipleSpamReviews() {
        submitMultipleSpamReviews();
    }

    @Then("the system automatically blocks repeated spam submissions from the same user")
    public void theSystemAutomaticallyBlocksRepeatedSpamSubmissionsFromTheSameUser() {
        verifySystemBlocksRepeatedSpam();
    }

    @Given("reviews are flagged as spam or inappropriate")
    public void reviewsAreFlaggedAsSpamOrInappropriate() {
        flagReviewsAsSpamOrInappropriate();
    }

    @Then("admins receive notifications for the flagged reviews")
    public void adminsReceiveNotificationsForTheFlaggedReviews() {
        verifyAdminNotificationsReceived();
    }

    @Given("a high rate of review submissions occurs")
    public void aHighRateOfReviewSubmissionsOccurs() {
        simulateHighRateOfReviewSubmissions();
    }

    @Then("the system maintains performance")
    public void theSystemMaintainsPerformance() {
        verifySystemPerformanceMaintained();
    }

    @Then("the system accurately flags spam")
    public void theSystemAccuratelyFlagsSpam() {
        verifySpamAccuratelyFlagged();
    }

    @Given("the admin is logged into the system")
    public void theAdminIsLoggedIntoTheSystem() {
        verifyAdminLoggedIn();
    }

    @When("the admin logs out")
    public void theAdminLogsOut() {
        adminLogout();
    }

    @Then("the admin is redirected to the login page")
    public void theAdminIsRedirectedToTheLoginPage() {
        verifyRedirectedToLoginPage();
    }

    @Given("the admin logs back into the system")
    public void theAdminLogsBackIntoTheSystem() {
        adminLoginBack();
    }

    @Then("the admin can access the flagged reviews section with updated list")
    public void theAdminCanAccessTheFlaggedReviewsSectionWithUpdatedList() {
        verifyAccessToUpdatedFlaggedReviews();
    }

    @Given("the user submits a review with mixed content")
    public void theUserSubmitsAReviewWithMixedContent() {
        submitReviewWithMixedContent();
    }

    @Then("the system flags the review for manual inspection")
    public void theSystemFlagsTheReviewForManualInspection() {
        verifyReviewFlaggedForManualInspection();
    }

    @Given("a large volume of spam reviews are submitted")
    public void aLargeVolumeOfSpamReviewsAreSubmitted() {
        submitLargeVolumeOfSpamReviews();
    }

    @Then("the system efficiently handles and flags spam without crashing")
    public void theSystemEfficientlyHandlesAndFlagsSpamWithoutCrashing() {
        verifySystemHandlesSpamEfficiently();
    }

    @Given("reviews are flagged")
    public void reviewsAreFlagged() {
        flagReviews();
    }

    @Then("flagged reviews remain hidden from user view until resolved")
    public void flaggedReviewsRemainHiddenFromUserViewUntilResolved() {
        verifyFlaggedReviewsHidden();
    }

    @Given("the system is used over time")
    public void theSystemIsUsedOverTime() {
        simulateSystemUsageOverTime();
    }

    @Then("the system shows improved accuracy in detecting spam")
    public void theSystemShowsImprovedAccuracyInDetectingSpam() {
        verifyImprovedSpamDetectionAccuracy();
    }

    @Given("a review is flagged by the spam detection system")
    public void aReviewIsFlaggedByTheSpamDetectionSystem() {
        flagReviewBySpamDetectionSystem();
    }

    @When("the admin decides to override the system")
    public void theAdminDecidesToOverrideTheSystem() {
        adminOverrideSpamDetection();
    }

    @Then("the admin can manually approve or delete the flagged review")
    public void theAdminCanManuallyApproveOrDeleteTheFlaggedReview() {
        verifyAdminCanApproveOrDeleteReview();
    }
}