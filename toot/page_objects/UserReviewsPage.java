package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class UserReviewsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By completedPurchaseLocator = By.id(completed_purchase);
    private final By leaveReviewButtonLocator = By.id(leave_review_button);
    private final By reviewFormLocator = By.id(review_form);
    private final By ratingFieldLocator = By.id(rating);
    private final By feedbackFieldLocator = By.id(feedback);
    private final By submitReviewButtonLocator = By.id(submit_review_button);
    private final By reviewConfirmationLocator = By.id(review_confirmation);
    private final By editReviewButtonLocator = By.id(edit_review_button);
    private final By updatedReviewConfirmationLocator = By.id(updated_review_confirmation);
    private final By deleteReviewButtonLocator = By.id(delete_review_button);
    private final By confirmDeletionPromptLocator = By.id(confirm_deletion_prompt);
    private final By confirmDeletionButtonLocator = By.id(confirm_deletion_button);
    private final By reviewRemovedConfirmationLocator = By.id(review_removed_confirmation);
    private final By existingReviewsLocator = By.id(existing_reviews);
    private final By averageRatingLocator = By.id(average_rating);
    private final By individualReviewsLocator = By.id(individual_reviews);
    private final By purchaseVerificationNotificationLocator = By.id(purchase_verification_notification);

    public UserReviewsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrderHistoryPage() {
        driver.get(http://example.com/order-history);
    }

    public void selectCompletedPurchase() {
        WebElement completedPurchase = wait.until(ExpectedConditions.visibilityOfElementLocated(completedPurchaseLocator));
        completedPurchase.click();
    }

    public void clickLeaveReview() {
        WebElement leaveReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveReviewButtonLocator));
        leaveReviewButton.click();
    }

    public boolean isReviewFormDisplayed() {
        WebElement reviewForm = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewFormLocator));
        return reviewForm.isDisplayed();
    }

    public void enterRating(String rating) {
        WebElement ratingField = driver.findElement(ratingFieldLocator);
        ratingField.sendKeys(rating);
    }

    public void enterFeedback(String feedback) {
        WebElement feedbackField = driver.findElement(feedbackFieldLocator);
        feedbackField.sendKeys(feedback);
    }

    public void submitReview() {
        WebElement submitReviewButton = driver.findElement(submitReviewButtonLocator);
        submitReviewButton.click();
    }

    public boolean isReviewSaved() {
        WebElement reviewConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewConfirmationLocator));
        return reviewConfirmation.isDisplayed();
    }

    public void navigateToProductPage() {
        driver.get(http://example.com/product-page);
    }

    public void clickEditReview() {
        WebElement editReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(editReviewButtonLocator));
        editReviewButton.click();
    }

    public boolean isRatingFieldEditable() {
        WebElement ratingField = driver.findElement(ratingFieldLocator);
        return ratingField.isEnabled();
    }

    public boolean isFeedbackFieldEditable() {
        WebElement feedbackField = driver.findElement(feedbackFieldLocator);
        return feedbackField.isEnabled();
    }

    public boolean isUpdatedReviewSaved() {
        WebElement updatedReviewConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(updatedReviewConfirmationLocator));
        return updatedReviewConfirmation.isDisplayed();
    }

    public void clickDeleteReview() {
        WebElement deleteReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteReviewButtonLocator));
        deleteReviewButton.click();
    }

    public boolean isDeletionPromptDisplayed() {
        WebElement confirmDeletionPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeletionPromptLocator));
        return confirmDeletionPrompt.isDisplayed();
    }

    public void confirmDeletion() {
        WebElement confirmDeletionButton = driver.findElement(confirmDeletionButtonLocator);
        confirmDeletionButton.click();
    }

    public boolean isReviewRemoved() {
        WebElement reviewRemovedConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewRemovedConfirmationLocator));
        return reviewRemovedConfirmation.isDisplayed();
    }

    public boolean areExistingReviewsDisplayed() {
        WebElement existingReviews = wait.until(ExpectedConditions.visibilityOfElementLocated(existingReviewsLocator));
        return existingReviews.isDisplayed();
    }

    public boolean isAverageRatingDisplayed() {
        WebElement averageRating = wait.until(ExpectedConditions.visibilityOfElementLocated(averageRatingLocator));
        return averageRating.isDisplayed();
    }

    public boolean areIndividualReviewsDisplayed() {
        WebElement individualReviews = wait.until(ExpectedConditions.visibilityOfElementLocated(individualReviewsLocator));
        return individualReviews.isDisplayed();
    }

    public void clickLeaveReviewWithoutPurchase() {
        WebElement leaveReviewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveReviewButtonLocator));
        leaveReviewButton.click();
    }

    public boolean isPurchaseVerificationNotificationDisplayed() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseVerificationNotificationLocator));
        return notification.isDisplayed();
    }

    private void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}