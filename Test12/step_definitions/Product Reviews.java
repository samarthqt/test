package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ReviewPage;

public class ReviewSteps extends ReviewPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is on the product page")
    public void aUserIsOnTheProductPage() {
        String productPageURL = testHarness.getData("ReviewData", "ProductPageURL");
        navigateToPage(productPageURL);
    }

    @When("the user navigates to the review section")
    public void theUserNavigatesToTheReviewSection() {
        navigateToReviewSection();
    }

    @Then("the review functionality should be accessible")
    public void theReviewFunctionalityShouldBeAccessible() {
        verifyReviewFunctionalityAccessible();
    }

    @When("the user rates a product using the star system")
    public void theUserRatesAProductUsingTheStarSystem() {
        rateProductUsingStarSystem();
    }

    @Then("the rating should be recorded")
    public void theRatingShouldBeRecorded() {
        verifyRatingRecorded();
    }

    @When("the user leaves a text review for a product")
    public void theUserLeavesATextReviewForAProduct() {
        leaveTextReview();
    }

    @Then("the text review should be submitted")
    public void theTextReviewShouldBeSubmitted() {
        verifyTextReviewSubmitted();
    }

    @Given("a user attempts to submit a review")
    public void aUserAttemptsToSubmitAReview() {
        attemptToSubmitReview();
    }

    @When("the review contains spam or inappropriate content")
    public void theReviewContainsSpamOrInappropriateContent() {
        checkForSpamOrInappropriateContent();
    }

    @Then("the review should be blocked")
    public void theReviewShouldBeBlocked() {
        verifyReviewBlocked();
    }

    @Given("an admin is reviewing submitted reviews")
    public void anAdminIsReviewingSubmittedReviews() {
        adminReviewSubmittedReviews();
    }

    @When("the admin identifies a review that needs moderation or deletion")
    public void theAdminIdentifiesAReviewThatNeedsModerationOrDeletion() {
        identifyReviewForModerationOrDeletion();
    }

    @Then("the admin should be able to moderate or delete the review")
    public void theAdminShouldBeAbleToModerateOrDeleteTheReview() {
        moderateOrDeleteReview();
    }

    @Given("a user submits an invalid review")
    public void aUserSubmitsAnInvalidReview() {
        submitInvalidReview();
    }

    @When("the system processes the review")
    public void theSystemProcessesTheReview() {
        processReview();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Given("a user is using the system")
    public void aUserIsUsingTheSystem() {
        userUsingSystem();
    }

    @When("the user accesses the review functionality")
    public void theUserAccessesTheReviewFunctionality() {
        accessReviewFunctionality();
    }

    @Then("the review functionality should be available on both desktop and mobile platforms")
    public void theReviewFunctionalityShouldBeAvailableOnBothDesktopAndMobilePlatforms() {
        verifyReviewFunctionalityOnPlatforms();
    }

    @Given("a user submits a review")
    public void aUserSubmitsAReview() {
        submitReview();
    }

    @When("the review is processed")
    public void theReviewIsProcessed() {
        processReviewForAnalytics();
    }

    @Then("the review should be logged for analytics purposes")
    public void theReviewShouldBeLoggedForAnalyticsPurposes() {
        verifyReviewLoggedForAnalytics();
    }

    @Given("a user views the product page")
    public void aUserViewsTheProductPage() {
        viewProductPage();
    }

    @When("the reviews are displayed")
    public void theReviewsAreDisplayed() {
        displayReviews();
    }

    @Then("the reviews should be accurately displayed through integration with the product database")
    public void theReviewsShouldBeAccuratelyDisplayedThroughIntegrationWithTheProductDatabase() {
        verifyReviewsDisplayedAccurately();
    }

    @Given("a user submits a review")
    public void aUserSubmitsAReviewAgain() {
        submitReviewAgain();
    }

    @When("the review is approved or rejected")
    public void theReviewIsApprovedOrRejected() {
        approveOrRejectReview();
    }

    @Then("the user should receive a notification about the review status")
    public void theUserShouldReceiveANotificationAboutTheReviewStatus() {
        verifyNotificationReceived();
    }
}