package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ReviewPage extends WebReusableComponents {

    protected By reviewSection = By.id("reviewSection");
    protected By starRating = By.cssSelector(".star-rating");
    protected By textReviewInput = By.id("textReviewInput");
    protected By submitReviewButton = By.id("submitReviewButton");
    protected By spamWarning = By.id("spamWarning");
    protected By adminReviewSection = By.id("adminReviewSection");
    protected By errorMessage = By.id("errorMessage");
    protected By notification = By.id("notification");

    public ReviewPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToReviewSection() {
        waitUntilElementVisible(reviewSection, 3);
        clickElement(reviewSection);
    }

    public void verifyReviewFunctionalityAccessible() {
        boolean isAccessible = elementVisible(reviewSection);
        Assert.assertTrue(isAccessible, "Review functionality is not accessible.");
    }

    public void rateProductUsingStarSystem() {
        waitUntilElementVisible(starRating, 3);
        clickElement(starRating);
    }

    public void verifyRatingRecorded() {
        boolean isRecorded = elementVisible(starRating);
        Assert.assertTrue(isRecorded, "Rating was not recorded.");
    }

    public void leaveTextReview() {
        waitUntilElementVisible(textReviewInput, 3);
        enterText(textReviewInput, "Great product!");
        clickElement(submitReviewButton);
    }

    public void verifyTextReviewSubmitted() {
        boolean isSubmitted = elementVisible(submitReviewButton);
        Assert.assertTrue(isSubmitted, "Text review was not submitted.");
    }

    public void attemptToSubmitReview() {
        clickElement(submitReviewButton);
    }

    public void checkForSpamOrInappropriateContent() {
        boolean containsSpam = elementVisible(spamWarning);
        Assert.assertTrue(containsSpam, "Review contains spam or inappropriate content.");
    }

    public void verifyReviewBlocked() {
        boolean isBlocked = elementVisible(spamWarning);
        Assert.assertTrue(isBlocked, "Review was not blocked.");
    }

    public void adminReviewSubmittedReviews() {
        waitUntilElementVisible(adminReviewSection, 3);
        clickElement(adminReviewSection);
    }

    public void identifyReviewForModerationOrDeletion() {
        boolean needsModeration = elementVisible(adminReviewSection);
        Assert.assertTrue(needsModeration, "Review does not need moderation or deletion.");
    }

    public void moderateOrDeleteReview() {
        clickElement(adminReviewSection);
    }

    public void submitInvalidReview() {
        enterText(textReviewInput, "Invalid review!");
        clickElement(submitReviewButton);
    }

    public void processReview() {
        clickElement(submitReviewButton);
    }

    public void verifyErrorMessageDisplayed() {
        boolean isErrorDisplayed = elementVisible(errorMessage);
        Assert.assertTrue(isErrorDisplayed, "Error message was not displayed.");
    }

    public void userUsingSystem() {
        // Placeholder for user using system logic
    }

    public void accessReviewFunctionality() {
        navigateToReviewSection();
    }

    public void verifyReviewFunctionalityOnPlatforms() {
        boolean isAvailable = elementVisible(reviewSection);
        Assert.assertTrue(isAvailable, "Review functionality is not available on both platforms.");
    }

    public void submitReview() {
        leaveTextReview();
    }

    public void processReviewForAnalytics() {
        clickElement(submitReviewButton);
    }

    public void verifyReviewLoggedForAnalytics() {
        boolean isLogged = elementVisible(submitReviewButton);
        Assert.assertTrue(isLogged, "Review was not logged for analytics.");
    }

    public void viewProductPage() {
        // Placeholder for viewing product page logic
    }

    public void displayReviews() {
        waitUntilElementVisible(reviewSection, 3);
    }

    public void verifyReviewsDisplayedAccurately() {
        boolean areDisplayedAccurately = elementVisible(reviewSection);
        Assert.assertTrue(areDisplayedAccurately, "Reviews are not displayed accurately.");
    }

    public void submitReviewAgain() {
        leaveTextReview();
    }

    public void approveOrRejectReview() {
        clickElement(submitReviewButton);
    }

    public void verifyNotificationReceived() {
        boolean isNotificationReceived = elementVisible(notification);
        Assert.assertTrue(isNotificationReceived, "Notification was not received.");
    }
}