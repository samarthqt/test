package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ErrorPage extends WebReusableComponents {

    private final By errorMessage = By.id("errorMessage");

    public ErrorPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Performs an invalid action and verifies if the error message is displayed.
     */
    public void performInvalidAction() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Invalid action is not performed.");
    }

    /**
     * Displays the error message and verifies its visibility.
     */
    public void displayErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    /**
     * Verifies that the error message is clear and not empty.
     */
    public void verifyClearErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String errorText = getTextFromElement(errorMessage);
        Assert.assertFalse(errorText.isEmpty(), "Error message is not clear.");
    }

    /**
     * Verifies that the error message contains actionable text.
     */
    public void verifyActionableErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String errorText = getTextFromElement(errorMessage);
        Assert.assertTrue(errorText.contains("action"), "Error message is not actionable.");
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator The locator of the element to wait for.
     * @param timeout The timeout in seconds.
     */
    public void waitUntilElementVisible(By locator, int timeout) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertNotNull(element, "Element is not visible.");
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
     * Retrieves the text from the specified element.
     * 
     * @param locator The locator of the element to retrieve text from.
     * @return The text of the element.
     */
    public String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}