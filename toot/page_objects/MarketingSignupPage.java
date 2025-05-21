package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class MarketingSignupPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailField = By.id(email);
    private final By optInCheckbox = By.id(opt_in);
    private final By submitButton = By.id(submit_button);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By errorMessage = By.id(error_message);
    private final By optInRequiredMessage = By.id(opt_in_required_message);
    private final By alreadySubscribedMessage = By.id(already_subscribed_message);

    public MarketingSignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(final String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
        Assert.assertEquals(emailElement.getAttribute(value), email, Email input failed);
    }

    public void checkOptInCheckbox() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(optInCheckbox));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected(), Opt-in checkbox is not selected);
    }

    public void uncheckOptInCheckbox() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(optInCheckbox));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertFalse(checkbox.isSelected(), Opt-in checkbox is still selected);
    }

    public void submitForm() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitBtn.click();
        Assert.assertTrue(isConfirmationMessageDisplayed() || isErrorMessageDisplayed(), Form submission failed);
    }

    public boolean isConfirmationMessageDisplayed() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
        Assert.assertTrue(isDisplayed, Confirmation message is not displayed);
        return isDisplayed;
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        Assert.assertTrue(isDisplayed, Error message is not displayed);
        return isDisplayed;
    }

    public boolean isOptInRequiredMessageDisplayed() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(optInRequiredMessage)).isDisplayed();
        Assert.assertTrue(isDisplayed, Opt-in required message is not displayed);
        return isDisplayed;
    }

    public boolean isAlreadySubscribedMessageDisplayed() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadySubscribedMessage)).isDisplayed();
        Assert.assertTrue(isDisplayed, Already subscribed message is not displayed);
        return isDisplayed;
    }
}