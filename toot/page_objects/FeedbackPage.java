package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FeedbackPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By customerServiceSection = By.id(customer_service_section);
    private final By feedbackOption = By.id(feedback_option);
    private final By feedbackForm = By.id(feedback_form);
    private final By feedbackComments = By.id(feedback_comments);
    private final By submitButton = By.id(submit_feedback);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By errorMessage = By.id(error_message);
    private final By feedbackPrompt = By.id(feedback_prompt);
    private final By feedbackHistorySection = By.id(feedback_history_section);
    private final By feedbackHistoryList = By.id(feedback_history_list);
    private final By feedbackEntry = By.id(feedback_entry);

    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void navigateToCustomerService() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(customerServiceSection));
        element.click();
        Assert.assertTrue(isFeedbackOptionVisible(), Feedback option is not visible after navigating to customer service.);
    }

    public boolean isFeedbackOptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackOption)).isDisplayed();
    }

    public void navigateToFeedbackForm() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(feedbackOption));
        element.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackForm)).isDisplayed(), Feedback form is not visible after navigation.);
    }

    public void enterFeedbackComments(String comments) {
        WebElement commentsField = wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackComments));
        commentsField.clear();
        commentsField.sendKeys(comments);
        Assert.assertEquals(commentsField.getAttribute(value), comments, Feedback comments were not entered correctly.);
    }

    public void submitFeedbackForm() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        element.click();
        Assert.assertTrue(isFeedbackSubmissionSuccessful() || isFeedbackSubmissionErrorVisible(), Feedback submission did not trigger any response.);
    }

    public boolean isFeedbackSubmissionSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }

    public boolean isFeedbackSubmissionErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }

    public boolean isFeedbackPromptVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackPrompt)).isDisplayed();
    }

    public void navigateToFeedbackHistory() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(feedbackHistorySection));
        element.click();
        Assert.assertTrue(isFeedbackHistoryVisible(), Feedback history is not visible after navigation.);
    }

    public boolean isFeedbackHistoryVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackHistoryList)).isDisplayed();
    }

    public void selectFeedbackEntry() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(feedbackEntry));
        element.click();
        Assert.assertTrue(isFeedbackPromptVisible(), Feedback prompt is not visible after selecting feedback entry.);
    }

    public void editFeedbackComments(String updatedComments) {
        enterFeedbackComments(updatedComments);
        submitFeedbackForm();
        Assert.assertTrue(isFeedbackUpdateSuccessful(), Feedback update was not successful.);
    }

    public boolean isFeedbackUpdateSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }
}