package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductReviewSteps extends ProductReviewPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is logged in")
    public void aUserIsLoggedIn() {
        loginUser();
    }

    @When("the user navigates to a product page")
    public void theUserNavigatesToAProductPage() {
        navigateToProductPage();
    }

    @When("the user clicks on \"Write a Review\"")
    public void theUserClicksOnWriteAReview() {
        clickWriteReview();
    }

    @When("the user enters a review title and description")
    public void theUserEntersAReviewTitleAndDescription() {
        enterReviewTitleAndDescription();
    }

    @When("the user selects a rating for the product")
    public void theUserSelectsARatingForTheProduct() {
        selectProductRating();
    }

    @When("the user submits the review")
    public void theUserSubmitsTheReview() {
        submitReview();
    }

    @Then("the review should be saved and displayed on the product page")
    public void theReviewShouldBeSavedAndDisplayedOnTheProductPage() {
        verifyReviewDisplayed();
    }

    @Given("a user is on a product page")
    public void aUserIsOnAProductPage() {
        navigateToProductPage();
    }

    @When("the user scrolls to the reviews section")
    public void theUserScrollsToTheReviewsSection() {
        scrollToReviewsSection();
    }

    @Then("the user should see a list of reviews for the product")
    public void theUserShouldSeeAListOfReviewsForTheProduct() {
        verifyReviewsListDisplayed();
    }

    @Then("each review should display the reviewer's name, rating, title, and description")
    public void eachReviewShouldDisplayTheReviewersNameRatingTitleAndDescription() {
        verifyReviewDetails();
    }

    @Given("a user is not logged in")
    public void aUserIsNotLoggedIn() {
        ensureUserIsLoggedOut();
    }

    @When("the user attempts to submit a review")
    public void theUserAttemptsToSubmitAReview() {
        attemptToSubmitReview();
    }

    @Then("the user should be prompted to log in or register")
    public void theUserShouldBePromptedToLogInOrRegister() {
        verifyLoginPrompt();
    }

    @When("the user submits the review without selecting a rating")
    public void theUserSubmitsTheReviewWithoutSelectingARating() {
        submitReviewWithoutRating();
    }

    @Then("the user should see an error message indicating that a rating is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThatARatingIsRequired() {
        verifyRatingErrorMessage();
    }

    @When("the user submits the review without entering a title")
    public void theUserSubmitsTheReviewWithoutEnteringATitle() {
        submitReviewWithoutTitle();
    }

    @Then("the user should see an error message indicating that a title is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThatATitleIsRequired() {
        verifyTitleErrorMessage();
    }

    @When("the user submits the review without entering a description")
    public void theUserSubmitsTheReviewWithoutEnteringADescription() {
        submitReviewWithoutDescription();
    }

    @Then("the user should see an error message indicating that a description is required")
    public void theUserShouldSeeAnErrorMessageIndicatingThatADescriptionIsRequired() {
        verifyDescriptionErrorMessage();
    }

    @Given("the user has previously submitted a review")
    public void theUserHasPreviouslySubmittedAReview() {
        ensureReviewExists();
    }

    @When("the user clicks on \"Edit Review\"")
    public void theUserClicksOnEditReview() {
        clickEditReview();
    }

    @When("the user updates the review title, description, or rating")
    public void theUserUpdatesTheReviewTitleDescriptionOrRating() {
        updateReviewDetails();
    }

    @When("the user submits the changes")
    public void theUserSubmitsTheChanges() {
        submitReviewChanges();
    }

    @Then("the updated review should be saved and displayed on the product page")
    public void theUpdatedReviewShouldBeSavedAndDisplayedOnTheProductPage() {
        verifyUpdatedReviewDisplayed();
    }

    @When("the user clicks on \"Delete Review\"")
    public void theUserClicksOnDeleteReview() {
        clickDeleteReview();
    }

    @Then("the review should be removed from the product page")
    public void theReviewShouldBeRemovedFromTheProductPage() {
        verifyReviewRemoved();
    }
}