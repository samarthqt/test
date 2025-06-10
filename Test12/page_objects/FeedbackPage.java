package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FeedbackPage extends WebReusableComponents {

    private final By feedbackSection = By.id("feedbackSection");

    public FeedbackPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Validates the visibility of the feedback section.
     */
    public void receiveUserFeedback() {
        waitUntilElementVisible(feedbackSection, 3);
        Assert.assertTrue(isElementDisplayed(feedbackSection), "Feedback section is not visible.");
    }

    /**
     * Reviews the feedback content ensuring it is not empty.
     */
    public void reviewFeedback() {
        String feedbackText = getTextFromElement(feedbackSection);
        Assert.assertFalse(feedbackText.isEmpty(), "Feedback is not reviewed.");
    }

    /**
     * Confirms feedback is incorporated into the UI design.
     */
    public void incorporateFeedbackIntoUIDesign() {
        Assert.assertTrue(isElementDisplayed(feedbackSection), "Feedback is not incorporated into UI design.");
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator The locator of the element to wait for.
     * @param timeout The timeout in seconds.
     */
    public void waitUntilElementVisible(By locator, int timeout) {
        WebElement element = waitUntilElementVisible(locator, timeout);
        Assert.assertNotNull(element, "Element is not visible: " + locator.toString());
    }

    /**
     * Checks if the specified element is displayed.
     * 
     * @param locator The locator of the element to check.
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    /**
     * Retrieves text from the specified element.
     * 
     * @param locator The locator of the element to retrieve text from.
     * @return The text of the element.
     */
    public String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}