package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RatingsReviewsPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By orderHistoryLink = By.id("orderHistoryLink");
    protected By purchasedProductLink = By.cssSelector(".purchased-product");
    protected By ratingsReviewsSection = By.id("ratingsReviewsSection");
    protected By starRating = By.cssSelector(".star-rating");
    protected By reviewTextField = By.id("reviewTextField");
    protected By submitReviewButton = By.id("submitReviewButton");
    protected By submittedRatingReview = By.cssSelector(".submitted-rating-review");
    protected By editReviewButton = By.id("editReviewButton");
    protected By deleteReviewButton = By.id("deleteReviewButton");
    protected By duplicateReviewWarning = By.id("duplicateReviewWarning");
    protected By inappropriateLanguageWarning = By.id("inappropriateLanguageWarning");
    protected By reviewTimestamp = By.cssSelector(".review-timestamp");
    protected By notificationMessage = By.id("notificationMessage");
    protected By moderationToolsLink = By.id("moderationToolsLink");

    public RatingsReviewsPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToCustomerAccount() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        verifyLoginSuccess();
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        verifyLoginSuccess();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(orderHistoryLink), "Login was not successful.");
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistoryLink, 3);
        clickElement(orderHistoryLink);
        verifyOrderHistoryPage();
    }

    public void verifyOrderHistoryPage() {
        Assert.assertTrue(isElementVisible(purchasedProductLink), "Order history page is not displayed.");
    }

    public void selectPurchasedProduct() {
        waitUntilElementVisible(purchasedProductLink, 3);
        clickElement(purchasedProductLink);
        verifyProductDetailsPage();
    }

    public void verifyProductDetailsPage() {
        Assert.assertTrue(isElementVisible(ratingsReviewsSection), "Product details page is not open.");
    }

    public void locateRatingsReviewsSection() {
        waitUntilElementVisible(ratingsReviewsSection, 3);
        verifyRatingsReviewsSectionVisible();
    }

    public void verifyRatingsReviewsSectionVisible() {
        Assert.assertTrue(isElementVisible(ratingsReviewsSection), "Ratings and reviews section is not visible.");
    }

    public void submitRating() {
        waitUntilElementVisible(starRating, 3);
        clickElement(starRating);
        verifyRatingSubmissionSuccess();
    }

    public void verifyRatingSubmissionSuccess() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Rating submission was not successful.");
    }

    public void enterReviewText() {
        waitUntilElementVisible(reviewTextField, 3);
        enterText(reviewTextField, "Great product!");
    }

    public void submitReview() {
        waitUntilElementVisible(submitReviewButton, 3);
        clickElement(submitReviewButton);
        verifyReviewSubmissionSuccess();
    }

    public void verifyReviewSubmissionSuccess() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Review submission was not successful.");
    }

    public void verifyRatingReviewSubmission() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Rating and review were not submitted.");
    }

    public void openProductPage() {
        waitUntilElementVisible(purchasedProductLink, 3);
        clickElement(purchasedProductLink);
        verifySubmittedRatingReviewVisible();
    }

    public void verifySubmittedRatingReviewVisible() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Submitted rating and review are not visible.");
    }

    public void verifyReviewSubmission() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Review was not submitted.");
    }

    public void editOrDeleteReview() {
        waitUntilElementVisible(editReviewButton, 3);
        clickElement(editReviewButton);
        waitUntilElementVisible(deleteReviewButton, 3);
        clickElement(deleteReviewButton);
        verifyReviewEditDelete();
    }

    public void verifyReviewEditDelete() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Review cannot be edited or deleted.");
    }

    public void attemptDuplicateReviewSubmission() {
        waitUntilElementVisible(submitReviewButton, 3);
        clickElement(submitReviewButton);
        verifyDuplicateReviewPrevention();
    }

    public void verifyDuplicateReviewPrevention() {
        Assert.assertTrue(isElementVisible(duplicateReviewWarning), "Duplicate review was not prevented.");
    }

    public void submitInappropriateLanguageReview() {
        waitUntilElementVisible(reviewTextField, 3);
        enterText(reviewTextField, "Bad language");
        clickElement(submitReviewButton);
        verifyInappropriateLanguageHandling();
    }

    public void verifyInappropriateLanguageHandling() {
        Assert.assertTrue(isElementVisible(inappropriateLanguageWarning), "Inappropriate language was not flagged.");
    }

    public void viewReview() {
        waitUntilElementVisible(submittedRatingReview, 3);
        verifyReviewTimestamps();
    }

    public void verifyReviewTimestamps() {
        Assert.assertTrue(isElementVisible(reviewTimestamp), "Review timestamps are incorrect.");
    }

    public void verifyReviewSubmissionNotification() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Notification for review submission was not sent.");
    }

    public void otherUsersViewProductPage() {
        waitUntilElementVisible(purchasedProductLink, 3);
        clickElement(purchasedProductLink);
        verifySubmittedReviewsVisibility();
    }

    public void verifySubmittedReviewsVisibility() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Submitted reviews are not visible to other users.");
    }

    public void verifyReviewsSubmission() {
        Assert.assertTrue(isElementVisible(submittedRatingReview), "Reviews were not submitted.");
    }

    public void useModerationTools() {
        waitUntilElementVisible(moderationToolsLink, 3);
        clickElement(moderationToolsLink);
        verifyModerationToolsFunctionality();
    }

    public void verifyModerationToolsFunctionality() {
        Assert.assertTrue(isElementVisible(moderationToolsLink), "Moderation tools are not functional.");
    }
}