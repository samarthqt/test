package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RatingsReviewsPage;

public class RatingsReviewsSteps extends RatingsReviewsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a customer account with purchased products")
    public void aCustomerAccountWithPurchasedProducts() {
        loginToCustomerAccount();
    }

    @When("the customer logs in to the account")
    public void theCustomerLogsInToTheAccount() {
        performLogin();
    }

    @Then("the customer account login is successful")
    public void theCustomerAccountLoginIsSuccessful() {
        verifyLoginSuccess();
    }

    @Given("the customer is logged in")
    public void theCustomerIsLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the customer navigates to the order history page")
    public void theCustomerNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistory();
    }

    @Then("the order history page displays all purchased products")
    public void theOrderHistoryPageDisplaysAllPurchasedProducts() {
        verifyOrderHistoryPage();
    }

    @Given("the order history page is displayed")
    public void theOrderHistoryPageIsDisplayed() {
        verifyOrderHistoryPage();
    }

    @When("the customer selects a purchased product to review")
    public void theCustomerSelectsAPurchasedProductToReview() {
        selectPurchasedProduct();
    }

    @Then("the product details page opens successfully")
    public void theProductDetailsPageOpensSuccessfully() {
        verifyProductDetailsPage();
    }

    @Given("the product details page is open")
    public void theProductDetailsPageIsOpen() {
        verifyProductDetailsPage();
    }

    @When("the customer locates the ratings and reviews section")
    public void theCustomerLocatesTheRatingsAndReviewsSection() {
        locateRatingsReviewsSection();
    }

    @Then("the ratings and reviews section is visible")
    public void theRatingsAndReviewsSectionIsVisible() {
        verifyRatingsReviewsSectionVisible();
    }

    @Given("the ratings and reviews section is visible")
    public void theRatingsAndReviewsSectionIsVisibleAgain() {
        verifyRatingsReviewsSectionVisible();
    }

    @When("the customer submits a rating by selecting the desired number of stars")
    public void theCustomerSubmitsARatingBySelectingTheDesiredNumberOfStars() {
        submitRating();
    }

    @Then("the rating submission is successful")
    public void theRatingSubmissionIsSuccessful() {
        verifyRatingSubmissionSuccess();
    }

    @When("the customer enters a review text in the provided field")
    public void theCustomerEntersAReviewTextInTheProvidedField() {
        enterReviewText();
    }

    @When("submits the review")
    public void submitsTheReview() {
        submitReview();
    }

    @Then("the review submission is successful")
    public void theReviewSubmissionIsSuccessful() {
        verifyReviewSubmissionSuccess();
    }

    @Given("the customer has submitted a rating and review")
    public void theCustomerHasSubmittedARatingAndReview() {
        verifyRatingReviewSubmission();
    }

    @When("viewing the product page")
    public void viewingTheProductPage() {
        openProductPage();
    }

    @Then("the submitted rating and review are visible on the product page")
    public void theSubmittedRatingAndReviewAreVisibleOnTheProductPage() {
        verifySubmittedRatingReviewVisible();
    }

    @Given("the customer has submitted a review")
    public void theCustomerHasSubmittedAReview() {
        verifyReviewSubmission();
    }

    @When("the customer attempts to edit or delete the review")
    public void theCustomerAttemptsToEditOrDeleteTheReview() {
        editOrDeleteReview();
    }

    @Then("the review can be edited or deleted by the customer")
    public void theReviewCanBeEditedOrDeletedByTheCustomer() {
        verifyReviewEditDelete();
    }

    @When("the customer attempts to submit a duplicate review")
    public void theCustomerAttemptsToSubmitADuplicateReview() {
        attemptDuplicateReviewSubmission();
    }

    @Then("the system prevents submission of duplicate reviews")
    public void theSystemPreventsSubmissionOfDuplicateReviews() {
        verifyDuplicateReviewPrevention();
    }

    @When("the review contains inappropriate language")
    public void theReviewContainsInappropriateLanguage() {
        submitInappropriateLanguageReview();
    }

    @Then("the system flags or rejects reviews with inappropriate language")
    public void theSystemFlagsOrRejectsReviewsWithInappropriateLanguage() {
        verifyInappropriateLanguageHandling();
    }

    @When("viewing the review")
    public void viewingTheReview() {
        viewReview();
    }

    @Then("the review displays correct timestamps")
    public void theReviewDisplaysCorrectTimestamps() {
        verifyReviewTimestamps();
    }

    @When("the review submission is successful")
    public void theReviewSubmissionIsSuccessfulAgain() {
        verifyReviewSubmissionSuccess();
    }

    @Then("the system sends notifications for successful review submissions")
    public void theSystemSendsNotificationsForSuccessfulReviewSubmissions() {
        verifyReviewSubmissionNotification();
    }

    @When("other users view the product page")
    public void otherUsersViewTheProductPage() {
        otherUsersViewProductPage();
    }

    @Then("the submitted reviews are visible to other users")
    public void theSubmittedReviewsAreVisibleToOtherUsers() {
        verifySubmittedReviewsVisibility();
    }

    @Given("reviews have been submitted")
    public void reviewsHaveBeenSubmitted() {
        verifyReviewsSubmission();
    }

    @When("using the system's moderation tools")
    public void usingTheSystemsModerationTools() {
        useModerationTools();
    }

    @Then("moderation tools allow management of submitted reviews")
    public void moderationToolsAllowManagementOfSubmittedReviews() {
        verifyModerationToolsFunctionality();
    }
}