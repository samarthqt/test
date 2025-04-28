package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ErrorMessagePage extends WebReusableComponents {

    protected By errorMessage = By.id("errorMessage");
    protected By screenshotArea = By.id("screenshotArea");

    public void launchApplication() {
        launchUrl(getAppUrl());
        waitUntilElementVisible(errorMessage, 5);
    }

    public void attemptIncorrectSignIn() {
        // Code to attempt sign-in using incorrect method
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not displayed.");
    }

    public void triggerErrorMessage() {
        // Code to trigger error message
    }

    public void captureScreenshot() {
        captureElementScreenshot(screenshotArea);
    }

    public void verifyErrorMessageClarity() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.contains("correct sign-in method"), "Error message does not state correct sign-in method.");
    }

    public void verifyCredentialRecoveryGuidance() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.contains("credential recovery"), "Error message does not provide credential recovery guidance.");
    }

    public void verifyAlternativeSignInOptions() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.contains("alternative sign-in options"), "Error message does not mention alternative sign-in options.");
    }

    public void verifyErrorMessageConciseness() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.length() < 100, "Error message is not brief.");
    }

    public void verifyErrorMessageConsistency() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.contains("consistent style"), "Error message does not align with other guidance messages.");
    }

    public void verifyScreenReaderAccessibility() {
        // Code to verify screen reader accessibility
    }

    public void verifyErrorMessageResponsiveness() {
        // Code to verify responsiveness across devices
    }

    public void verifyErrorMessageSimplicity() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertFalse(messageText.contains("technical terms"), "Error message contains technical jargon.");
    }

    public void verifyPromptDisplayOfErrorMessage() {
        // Code to verify prompt display
    }

    public void verifyErrorMessageVisibility() {
        // Code to verify visibility in different browser settings
    }

    public void logErrorMessage() {
        // Code to log error message
    }

    public void performSuccessfulSignIn() {
        // Code to perform successful sign-in
    }

    public void verifyErrorMessageClearance() {
        Assert.assertFalse(isElementVisible(errorMessage), "Error message is not cleared.");
    }

    public void updateSignInMethod() {
        // Code to update sign-in method
    }

    public void verifyRealTimeUpdateOfErrorMessage() {
        String messageText = getTextFromElement(errorMessage);
        Assert.assertTrue(messageText.contains("current correct sign-in method"), "Error message does not reflect current sign-in method.");
    }
}